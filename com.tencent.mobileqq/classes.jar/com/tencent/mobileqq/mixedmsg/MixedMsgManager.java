package com.tencent.mobileqq.mixedmsg;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.ReplyHelper;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.multimsg.IUpLoadMsgPackBusinessType;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.replymsg.ReplyMsgSender;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.RichText;

public class MixedMsgManager
  implements IUpLoadMsgPackBusinessType, Manager
{
  private static final String jdField_a_of_type_JavaLangString;
  private long jdField_a_of_type_Long;
  public QQAppInterface a;
  public ConcurrentHashMap<Long, ChatMessage> a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("fight/pic_expire.png");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public MixedMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private MessageForMixedMsg a(List<MessageRecord> paramList, ArrayList<AtTroopMemberInfo> paramArrayList, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, int paramInt, boolean paramBoolean)
  {
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "constructMixedMr, input elemList is null, return...");
      }
      return null;
    }
    MessageForMixedMsg localMessageForMixedMsg = (MessageForMixedMsg)MessageRecordFactory.a(-1035);
    Object localObject = (MessageRecord)paramList.get(0);
    ((MessageRecord)localObject).longMsgId = 0;
    MessageRecord.copyMessageRecordBaseField(localMessageForMixedMsg, (MessageRecord)localObject);
    int i = localMessageForMixedMsg.istroop;
    int j = 1;
    if (i == 1) {
      AnonymousChatHelper.a().b(localMessageForMixedMsg);
    }
    if ((paramSourceMsgInfo != null) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramSourceMsgInfo = new JSONObject();
      try
      {
        localObject = new JSONArray();
        i = 0;
        while (i < paramArrayList.size())
        {
          ((JSONArray)localObject).put(i, ((AtTroopMemberInfo)paramArrayList.get(i)).toJsonObject());
          i += 1;
        }
        paramSourceMsgInfo.put("0", localObject);
      }
      catch (JSONException localJSONException)
      {
        QLog.e("MixedMsgManager", 1, localJSONException, new Object[0]);
      }
      AtTroopMemberSpan.a(paramInt, paramSourceMsgInfo.toString(), localMessageForMixedMsg);
    }
    localMessageForMixedMsg.uniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localMessageForMixedMsg.issend = 1;
    localMessageForMixedMsg.msgtype = -1035;
    localMessageForMixedMsg.extraflag = 32772;
    localMessageForMixedMsg.msgElemList = paramList;
    if (paramBoolean) {
      paramInt = j;
    } else {
      paramInt = -1;
    }
    localMessageForMixedMsg.mRobotFlag = paramInt;
    localMessageForMixedMsg.atInfoList = paramArrayList;
    localMessageForMixedMsg.prewrite();
    return localMessageForMixedMsg;
  }
  
  public static MessageForPic a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramString1 != null)
    {
      paramString2 = MessageRecordFactory.a(paramQQAppInterface, paramString3, paramString2, paramInt);
      paramString2.path = paramString1;
      paramString2.size = 0L;
      paramString2.uniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      paramString2.type = 1;
      paramString2.isRead = true;
      paramString2.localUUID = PicReq.a();
      paramString2.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString2.path));
      if (BaseImageUtil.b(paramString1))
      {
        paramString1 = new PicMessageExtraData();
        paramString1.textSummary = paramQQAppInterface.getApp().getString(2131691279);
        paramString2.picExtraData = paramString1;
      }
      paramString2.serial();
      return paramString2;
    }
    return null;
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    Object localObject1 = new im_msg_body.RichText();
    int k = paramMessageForMixedMsg.msgElemList.size();
    int i = 0;
    while (i < k)
    {
      Object localObject2 = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(i);
      int j;
      if ((localObject2 instanceof MessageForText))
      {
        localObject2 = MessageProtoCodec.a((MessageForText)localObject2);
        if (localObject2 != null)
        {
          j = 0;
          while (j < ((im_msg_body.RichText)localObject2).elems.size())
          {
            ((im_msg_body.RichText)localObject1).elems.add(((im_msg_body.RichText)localObject2).elems.get(j));
            j += 1;
          }
        }
      }
      else if ((localObject2 instanceof MessageForRichText))
      {
        localObject2 = ((MessageForPic)localObject2).richText;
        if (localObject2 != null) {
          ((im_msg_body.RichText)localObject1).elems.add(((im_msg_body.RichText)localObject2).elems.get(0));
        }
      }
      else if ((localObject2 instanceof MessageForReplyText))
      {
        localObject2 = MessageProtoCodec.a((MessageForReplyText)localObject2);
        if (localObject2 != null)
        {
          j = 0;
          while (j < ((im_msg_body.RichText)localObject2).elems.size())
          {
            ((im_msg_body.RichText)localObject1).elems.add(((im_msg_body.RichText)localObject2).elems.get(j));
            j += 1;
          }
        }
      }
      i += 1;
    }
    i = ((im_msg_body.RichText)localObject1).toByteArray().length;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("packAndSendMsg, richTextLength : ");
      ((StringBuilder)localObject1).append(i);
      QLog.d("MixedMsgManager", 2, ((StringBuilder)localObject1).toString());
    }
    paramMessageForMixedMsg.mRichTextLength = i;
    a(paramString, paramInt, paramMessageForMixedMsg, paramQQAppInterface, false);
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, "packAndSendMsg,, send by longStruct message");
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, ArrayList<PicFowardInfo> paramArrayList, MessageForMixedMsg paramMessageForMixedMsg)
  {
    PicReq localPicReq = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(8, 7);
    localPicReq.a(paramArrayList);
    localPicReq.a(new MixedMsgManager.2(this, paramMessageForMixedMsg, paramQQAppInterface, paramString, paramInt));
    ((IPicBus)QRoute.api(IPicBus.class)).launch(localPicReq);
  }
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg, ArrayList<AtTroopMemberInfo> paramArrayList, String paramString, Map<String, Boolean> paramMap)
  {
    ((IOrderMediaMsgService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByUniseq(paramString, paramMessageForMixedMsg.uniseq);
    ((IOrderMediaMsgService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsg(paramMessageForMixedMsg, null);
    Map localMap = Collections.synchronizedMap(new HashMap());
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMessageForMixedMsg.msgElemList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      paramString = (MessageRecord)localIterator.next();
      if ((paramString instanceof MessageForPic))
      {
        MessageForPic localMessageForPic = (MessageForPic)paramString;
        if (FileUtil.b(localMessageForPic.path))
        {
          localObject = (List)localMap.get(localMessageForPic.path);
          paramString = (String)localObject;
          if (localObject == null)
          {
            localHashMap.put(localMessageForPic, new MixedMsgManager.PicUploadCallBack2(this, paramMessageForMixedMsg, localMap, localMessageForPic.path, paramArrayList));
            paramString = new ArrayList();
          }
          paramString.add(Integer.valueOf(localMessageForPic.subMsgId));
          localMap.put(localMessageForPic.path, paramString);
        }
      }
    }
    paramMessageForMixedMsg = localHashMap.entrySet().iterator();
    while (paramMessageForMixedMsg.hasNext())
    {
      paramString = (Map.Entry)paramMessageForMixedMsg.next();
      paramArrayList = (MixedMsgManager.PicUploadCallBack2)paramString.getValue();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramMap != null)
      {
        localObject = (Boolean)paramMap.get(paramArrayList.jdField_a_of_type_JavaLangString);
        bool1 = bool2;
        if (localObject != null) {
          bool1 = ((Boolean)localObject).booleanValue();
        }
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForPic)paramString.getKey(), bool1, paramArrayList);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("send pic req:");
        paramString.append(paramArrayList.jdField_a_of_type_JavaLangString);
        paramString.append(", raw:");
        paramString.append(bool1);
        QLog.d("MixedMsgManager", 2, paramString.toString());
      }
    }
  }
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    if ((paramMessageForMixedMsg.istroop != 3000) && (paramMessageForMixedMsg.istroop != 1)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 32770, paramMessageForMixedMsg.sendFailCode);
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForMixedMsg);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramMessageForMixedMsg);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForMixedMsg.mForwardFromUniSeq));
    a(true, paramBoolean, paramMessageForMixedMsg, null);
  }
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 32768, paramMessageForMixedMsg.sendFailCode);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForMixedMsg);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForMixedMsg.mForwardFromUniSeq));
    ((IOrderMediaMsgService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).removeMediaMsgByUniseq(paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.uniseq);
    a(false, paramBoolean, paramMessageForMixedMsg, paramString);
  }
  
  public static void a(String paramString, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, MessageForMixedMsg paramMessageForMixedMsg, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_isresend", String.valueOf(paramMessageForMixedMsg.mIsResend));
    if (!paramMessageForMixedMsg.mIsResend)
    {
      localHashMap.put("param_forwardFromUin", paramMessageForMixedMsg.mForwardFromUin);
      localHashMap.put("param_forwardFromUinType", String.valueOf(paramMessageForMixedMsg.mForwardFromIsTroop));
    }
    localHashMap.put("param_senderUin", paramMessageForMixedMsg.senderuin);
    localHashMap.put("param_toUin", paramMessageForMixedMsg.frienduin);
    localHashMap.put("param_toUinType", String.valueOf(paramMessageForMixedMsg.istroop));
    localHashMap.put("param_sendByLongStruct", String.valueOf(paramBoolean2));
    localHashMap.put("param_richTextLength", String.valueOf(paramMessageForMixedMsg.mRichTextLength));
    if (paramString != null) {
      localHashMap.put("param_errDesc", paramString);
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MixedMsgForward", paramBoolean1, 0L, 0L, localHashMap, "");
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, UpCallBack paramUpCallBack)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[sendLongTextMsg]data.length = ");
      ((StringBuilder)localObject).append(paramArrayOfByte.length);
      QLog.d("MixedMsgManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new TransferRequest();
    ((TransferRequest)localObject).mIsUp = true;
    ((TransferRequest)localObject).mFileType = 131078;
    ((TransferRequest)localObject).multiMsgType = 1;
    ((TransferRequest)localObject).toSendData = paramArrayOfByte;
    ((TransferRequest)localObject).mSelfUin = paramString1;
    ((TransferRequest)localObject).mPeerUin = paramString2;
    ((TransferRequest)localObject).mSecondId = paramString3;
    ((TransferRequest)localObject).mUinType = paramInt1;
    ((TransferRequest)localObject).mUniseq = paramLong;
    ((TransferRequest)localObject).mBusiType = paramInt2;
    ((TransferRequest)localObject).mUpCallBack = paramUpCallBack;
    ((TransferRequest)localObject).upMsgBusiType = a();
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject);
    return true;
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a(SessionInfo paramSessionInfo, long paramLong, int paramInt)
  {
    Object localObject = (ChatMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localObject != null)
    {
      if (((ChatMessage)localObject).msgtype == -1036) {
        localObject = (MessageForMixedMsg)((MessageForLongMsg)localObject).rebuildLongMsg();
      } else {
        localObject = (MessageForMixedMsg)localObject;
      }
      ((MessageForMixedMsg)localObject).mForwardFromUniSeq = paramLong;
      ((MessageForMixedMsg)localObject).forwardID = paramInt;
      ReplyMsgSender.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForMixedMsg)localObject, paramSessionInfo, paramInt);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MixedMsgManager", 2, "forwardMixedMsg, not find in cache !");
    }
  }
  
  public void a(SessionInfo paramSessionInfo, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    a(paramSessionInfo, paramMessageForMixedMsg, paramBoolean, 0);
  }
  
  public void a(SessionInfo paramSessionInfo, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean, int paramInt)
  {
    paramSessionInfo = new MixedMsgManager.1(this, paramSessionInfo, paramInt, paramMessageForMixedMsg, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(paramSessionInfo);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ArrayList<AtTroopMemberInfo> paramArrayList, MixedMsgInfo paramMixedMsgInfo, boolean paramBoolean)
  {
    if ((paramQQAppInterface != null) && (paramBaseChatPie != null))
    {
      if (paramMixedMsgInfo == null) {
        return;
      }
      Object localObject2 = paramMixedMsgInfo.b();
      boolean bool = TextUtils.isEmpty(paramMixedMsgInfo.b());
      Object localObject1 = "MixedMsgManager";
      if ((bool) && (localObject2 != null) && (((List)localObject2).size() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MixedMsgManager", 2, "sendMixedMrInfo, only 1 pic, send by pic message");
        }
        if (paramBoolean)
        {
          paramArrayList = new Intent();
          paramArrayList.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1057);
        }
        else
        {
          paramArrayList = null;
        }
        paramMixedMsgInfo = paramBaseChatPie.b().a().a().a();
        AIOPanelUtiles.a(paramQQAppInterface, paramBaseChatPie.b(), paramMixedMsgInfo, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, false, paramArrayList).a(paramBaseChatPie, (List)localObject2, false);
        return;
      }
      if (localObject2 == null) {
        i = 0;
      } else {
        i = ((List)localObject2).size();
      }
      a("0X800AE1B", i);
      MessageForReplyText.SourceMsgInfo localSourceMsgInfo = ((ReplyHelper)paramBaseChatPie.a(119)).a();
      String str = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      int i = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      localObject2 = new ArrayList();
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        paramBaseChatPie = (ITroopRobotService)paramQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
        localObject3 = paramArrayList.iterator();
        while (((Iterator)localObject3).hasNext()) {
          if (paramBaseChatPie.isRobotUin(((AtTroopMemberInfo)((Iterator)localObject3).next()).uin))
          {
            bool = true;
            break label281;
          }
        }
      }
      bool = false;
      label281:
      Object localObject3 = new HashMap();
      int k = 0;
      int j = 1;
      paramBaseChatPie = (BaseChatPie)localObject1;
      localObject1 = localObject3;
      for (;;)
      {
        int m = 0;
        if (k >= paramMixedMsgInfo.a().size()) {
          break;
        }
        localObject3 = (MixedMsgInfo.MsgNode)paramMixedMsgInfo.a().get(k);
        Object localObject4;
        Object localObject5;
        if ((localObject3 instanceof MixedMsgInfo.TextMsgNode))
        {
          localObject4 = ((MixedMsgInfo.MsgNode)localObject3).text();
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            if ((j != 0) && (localSourceMsgInfo != null))
            {
              localObject5 = MessageRecordFactory.a(paramQQAppInterface, str, i, localSourceMsgInfo, (String)localObject4);
              ((MessageForReplyText)localObject5).atInfoList = paramArrayList;
              ((List)localObject2).add(localObject5);
              if (QLog.isColorLevel()) {
                QLog.d(paramBaseChatPie, 2, "Attach at first text node");
              }
              j = m;
            }
            else
            {
              localObject5 = MessageRecordFactory.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), str, str, i, (byte)1, (byte)0, (short)0, (String)localObject4);
              ((MessageForText)localObject5).atInfoList = paramArrayList;
              ((List)localObject2).add(localObject5);
            }
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("add txt:");
              ((StringBuilder)localObject5).append((String)localObject4);
              QLog.d(paramBaseChatPie, 2, ((StringBuilder)localObject5).toString());
            }
          }
        }
        if ((localObject3 instanceof MixedMsgInfo.PhotoMsgNode))
        {
          localObject5 = ((MixedMsgInfo.PhotoMsgNode)localObject3).getPhotoItem();
          if ((localObject5 != null) && (FileUtil.b(((MixedMsgInfo.PhotoItem)localObject5).path)))
          {
            localObject4 = a(paramQQAppInterface, ((MixedMsgInfo.PhotoItem)localObject5).path, null, str, i);
            ThreadManager.getFileThreadHandler().post(new MixedMsgManager.6(this, (MessageForPic)localObject4));
            ((MessageForPic)localObject4).subMsgId = ((List)localObject2).size();
            ((List)localObject2).add(localObject4);
            Object localObject6 = ((MessageForPic)localObject4).path;
            localObject3 = localObject1;
            localObject6 = (Boolean)((Map)localObject3).get(localObject6);
            if (localObject6 == null) {
              ((Map)localObject3).put(((MessageForPic)localObject4).path, Boolean.valueOf(((MixedMsgInfo.PhotoItem)localObject5).isOriginal));
            } else if (!((Boolean)localObject6).booleanValue()) {
              ((Map)localObject3).put(((MessageForPic)localObject4).path, Boolean.valueOf(((MixedMsgInfo.PhotoItem)localObject5).isOriginal));
            }
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("add pic:");
              ((StringBuilder)localObject5).append(((MessageForPic)localObject4).path);
              ((StringBuilder)localObject5).append(", raw:");
              ((StringBuilder)localObject5).append(((Map)localObject3).get(((MessageForPic)localObject4).path));
              QLog.d(paramBaseChatPie, 2, ((StringBuilder)localObject5).toString());
            }
            else {}
          }
        }
        k += 1;
      }
      paramMixedMsgInfo = a((List)localObject2, paramArrayList, localSourceMsgInfo, i, bool);
      if (paramMixedMsgInfo == null) {
        return;
      }
      if (paramBoolean) {
        ((TroopEssenceMsgManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).a(paramMixedMsgInfo.frienduin, paramMixedMsgInfo.uniseq);
      }
      a(paramMixedMsgInfo, paramArrayList, str, (Map)localObject1);
      paramQQAppInterface.getMessageFacade().e(str, i);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("orderSender, sessionUin:");
        paramQQAppInterface.append(str);
        paramQQAppInterface.append(", sequin:");
        paramQQAppInterface.append(paramMixedMsgInfo.uniseq);
        QLog.d(paramBaseChatPie, 2, paramQQAppInterface.toString());
      }
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic, boolean paramBoolean, UpCallBack paramUpCallBack)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mSelfUin = paramMessageForPic.selfuin;
    localTransferRequest.mPeerUin = paramMessageForPic.frienduin;
    localTransferRequest.mUinType = paramMessageForPic.istroop;
    localTransferRequest.mFileType = 1;
    localTransferRequest.mUniseq = (paramMessageForPic.uniseq + paramMessageForPic.subMsgId);
    Object localObject = (ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class);
    while (((ITransFileController)localObject).containsProcessor(localTransferRequest.mPeerUin, localTransferRequest.mUniseq)) {
      localTransferRequest.mUniseq += 100L;
    }
    localTransferRequest.mIsUp = true;
    localTransferRequest.needSendMsg = false;
    localObject = new TransferRequest.PicUpExtraInfo();
    ((TransferRequest.PicUpExtraInfo)localObject).mIsRaw = paramBoolean;
    localTransferRequest.mExtraObj = localObject;
    localTransferRequest.mLocalPath = paramMessageForPic.path;
    localTransferRequest.mUpCallBack = paramUpCallBack;
    localTransferRequest.mRec = paramMessageForPic;
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramMessageRecord.extraflag = 32768;
    paramQQAppInterface.getMsgCache().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.uniseq;
    paramQQAppInterface.getMsgHandler().notifyUI(1000, false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean, String paramString2, ArrayList<AtTroopMemberInfo> paramArrayList1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if ((paramQQAppInterface != null) && (paramArrayList != null))
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      Object localObject = new ArrayList();
      boolean bool1 = false;
      boolean bool2 = false;
      if (paramSourceMsgInfo != null)
      {
        paramString2 = MessageRecordFactory.a(paramQQAppInterface, paramString1, paramInt, paramSourceMsgInfo, paramString2);
        paramString2.atInfoList = paramArrayList1;
        ((List)localObject).add(paramString2);
      }
      else if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = MessageRecordFactory.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, paramInt, (byte)1, (byte)0, (short)0, paramString2);
        paramString2.atInfoList = paramArrayList1;
        bool1 = bool2;
        if (paramString2.atInfoList != null)
        {
          bool1 = bool2;
          if (!paramString2.atInfoList.isEmpty())
          {
            ITroopRobotService localITroopRobotService = (ITroopRobotService)paramQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
            Iterator localIterator = paramString2.atInfoList.iterator();
            do
            {
              bool1 = bool2;
              if (!localIterator.hasNext()) {
                break;
              }
            } while (!localITroopRobotService.isRobotUin(((AtTroopMemberInfo)localIterator.next()).uin));
            bool1 = true;
          }
        }
        ((List)localObject).add(paramString2);
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramString2 = (String)paramArrayList.next();
        if (FileUtil.b(paramString2))
        {
          paramString2 = a(paramQQAppInterface, paramString2, null, paramString1, paramInt);
          if (paramString2 != null)
          {
            ThreadManager.post(new MixedMsgManager.5(this, paramString2), 8, null, true);
            paramString2.subMsgId = ((List)localObject).size();
            ((List)localObject).add(paramString2);
          }
        }
      }
      paramArrayList = a((List)localObject, paramArrayList1, paramSourceMsgInfo, paramInt, bool1);
      if (paramArrayList != null)
      {
        paramString2 = new HashMap();
        paramSourceMsgInfo = paramArrayList.msgElemList.iterator();
        while (paramSourceMsgInfo.hasNext())
        {
          localObject = (MessageRecord)paramSourceMsgInfo.next();
          if ((localObject instanceof MessageForPic))
          {
            localObject = (MessageForPic)localObject;
            if (FileUtil.b(((MessageForPic)localObject).path)) {
              paramString2.put(((MessageForPic)localObject).path, Boolean.valueOf(paramBoolean));
            }
          }
        }
        a(paramArrayList, paramArrayList1, paramString1, paramString2);
        paramQQAppInterface.getMessageFacade().e(paramString1, paramInt);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_istroop", String.valueOf(paramMessageRecord.istroop));
    localHashMap.put("param_issend", String.valueOf(paramMessageRecord.issend));
    localHashMap.put("param_msgtype", String.valueOf(paramMessageRecord.msgtype));
    localHashMap.put("param_isAnonymous", String.valueOf(AnonymousChatHelper.a(paramMessageRecord)));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MixedMsgReceived", true, 0L, 0L, localHashMap, "");
  }
  
  public void a(String paramString, int paramInt, MessageForMixedMsg paramMessageForMixedMsg, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, " sendStructLongMsg start");
    }
    if ((paramMessageForMixedMsg instanceof ChatMessage)) {
      paramMessageForMixedMsg.mPendantAnimatable = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("step2: sendStructLongMsg saveMessage end and pack StructLongMsg start currenttime:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("MixedMsgManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramQQAppInterface.getProxyManager().a().a(paramMessageForMixedMsg);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "step2: sendStructLongMsg pack failed! packData is null.............................");
      }
      a(paramMessageForMixedMsg, true, "sendStructLongMsg pack fail : packData is null");
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramString = new MixedMsgManager.3(this, paramQQAppInterface, paramMessageForMixedMsg, paramString, paramInt);
    paramBoolean = a(paramQQAppInterface, (byte[])localObject, paramQQAppInterface.getCurrentAccountUin(), paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 1035, new MixedMsgManager.4(this, paramQQAppInterface, paramMessageForMixedMsg, paramString));
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "sendLongTextMsg successful, uploadLongTextMsgPkg start!");
      }
    }
    else if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("sendLongTextMsg failed! isSuccess:");
      paramString.append(paramBoolean);
      QLog.d("MixedMsgManager", 2, paramString.toString());
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localHashMap.put("param_isTroop", String.valueOf(paramInt));
    if (paramBoolean)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MixedMsgClientAutoPull", true, 0L, 0L, localHashMap, "");
      return;
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MixedMsgClientManualPull", true, 0L, 0L, localHashMap, "");
  }
  
  protected void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop != 3000) && (paramMessageRecord.istroop != 1)) {
      paramMessageRecord.extraflag = 32770;
    }
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.uniseq;
    paramQQAppInterface.getMsgHandler().notifyUI(1000, true, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgManager
 * JD-Core Version:    0.7.0.1
 */