package com.tencent.mobileqq.mixedmsg;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.replymsg.ReplyMsgSender;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
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
  private static final String jdField_a_of_type_JavaLangString = AppConstants.SDCARD_PATH + "fight/pic_expire.png";
  private long jdField_a_of_type_Long;
  public QQAppInterface a;
  public ConcurrentHashMap<Long, ChatMessage> a;
  
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
    if (localMessageForMixedMsg.istroop == 1) {
      AnonymousChatHelper.a().b(localMessageForMixedMsg);
    }
    if ((paramSourceMsgInfo != null) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
      paramSourceMsgInfo = new JSONObject();
    }
    try
    {
      localObject = new JSONArray();
      int i = 0;
      while (i < paramArrayList.size())
      {
        ((JSONArray)localObject).put(i, ((AtTroopMemberInfo)paramArrayList.get(i)).toJsonObject());
        i += 1;
      }
      paramSourceMsgInfo.put("0", localObject);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("MixedMsgManager", 1, localJSONException, new Object[0]);
        continue;
        paramInt = -1;
      }
    }
    AtTroopMemberSpan.a(paramInt, paramSourceMsgInfo.toString(), localMessageForMixedMsg);
    localMessageForMixedMsg.uniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localMessageForMixedMsg.issend = 1;
    localMessageForMixedMsg.msgtype = -1035;
    localMessageForMixedMsg.extraflag = 32772;
    localMessageForMixedMsg.msgElemList = paramList;
    if (paramBoolean)
    {
      paramInt = 1;
      localMessageForMixedMsg.mRobotFlag = paramInt;
      localMessageForMixedMsg.atInfoList = paramArrayList;
      localMessageForMixedMsg.prewrite();
      return localMessageForMixedMsg;
    }
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
      if (Utils.a(paramString1))
      {
        paramString1 = new PicMessageExtraData();
        paramString1.textSummary = paramQQAppInterface.getApp().getString(2131691358);
        paramString2.picExtraData = paramString1;
      }
      paramString2.serial();
      return paramString2;
    }
    return null;
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    int m = paramMessageForMixedMsg.msgElemList.size();
    int j = 0;
    int i = 0;
    Object localObject;
    if (j < m)
    {
      localObject = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(j);
      if ((localObject instanceof MessageForText))
      {
        localObject = MessageProtoCodec.a((MessageForText)localObject);
        if (localObject != null) {}
      }
    }
    for (;;)
    {
      j += 1;
      break;
      int k = 0;
      while (k < ((im_msg_body.RichText)localObject).elems.size())
      {
        localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(k));
        k += 1;
      }
      continue;
      if ((localObject instanceof MessageForRichText))
      {
        localObject = ((MessageForPic)localObject).richText;
        if (localObject != null)
        {
          localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(0));
          i += 1;
        }
      }
      else if ((localObject instanceof MessageForReplyText))
      {
        localObject = MessageProtoCodec.a((MessageForReplyText)localObject);
        if (localObject != null)
        {
          k = 0;
          while (k < ((im_msg_body.RichText)localObject).elems.size())
          {
            localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(k));
            k += 1;
            continue;
            i = localRichText.toByteArray().length;
            if (QLog.isColorLevel()) {
              QLog.d("MixedMsgManager", 2, "packAndSendMsg, richTextLength : " + i);
            }
            paramMessageForMixedMsg.mRichTextLength = i;
            a(paramString, paramInt, paramMessageForMixedMsg, paramQQAppInterface, false);
            if (QLog.isColorLevel()) {
              QLog.d("MixedMsgManager", 2, "packAndSendMsg,, send by longStruct message");
            }
            return;
          }
        }
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, ArrayList<PicFowardInfo> paramArrayList, MessageForMixedMsg paramMessageForMixedMsg)
  {
    PicReq localPicReq = PicBusiManager.a(8, 7);
    localPicReq.a(paramArrayList);
    localPicReq.a(new MixedMsgManager.2(this, paramMessageForMixedMsg, paramQQAppInterface, paramString, paramInt));
    PicBusiManager.a(localPicReq);
  }
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg, ArrayList<AtTroopMemberInfo> paramArrayList, String paramString, Map<String, Boolean> paramMap)
  {
    Object localObject = (OrderMediaMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER);
    ((OrderMediaMsgManager)localObject).a(paramString, paramMessageForMixedMsg.uniseq);
    ((OrderMediaMsgManager)localObject).a(paramMessageForMixedMsg, null);
    Map localMap = Collections.synchronizedMap(new HashMap());
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMessageForMixedMsg.msgElemList.iterator();
    while (localIterator.hasNext())
    {
      paramString = (MessageRecord)localIterator.next();
      if ((paramString instanceof MessageForPic))
      {
        MessageForPic localMessageForPic = (MessageForPic)paramString;
        if (FileUtil.a(localMessageForPic.path))
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
    if (paramMessageForMixedMsg.hasNext())
    {
      paramArrayList = (Map.Entry)paramMessageForMixedMsg.next();
      paramString = (MixedMsgManager.PicUploadCallBack2)paramArrayList.getValue();
      if (paramMap == null) {
        break label346;
      }
      localObject = (Boolean)paramMap.get(paramString.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        break label346;
      }
    }
    label346:
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForPic)paramArrayList.getKey(), bool, paramString);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MixedMsgManager", 2, "send pic req:" + paramString.jdField_a_of_type_JavaLangString + ", raw:" + bool);
      break;
      return;
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
    OrderMediaMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.uniseq);
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
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, "[sendLongTextMsg]data.length = " + paramArrayOfByte.length);
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mFileType = 131078;
    localTransferRequest.multiMsgType = 1;
    localTransferRequest.toSendData = paramArrayOfByte;
    localTransferRequest.mSelfUin = paramString1;
    localTransferRequest.mPeerUin = paramString2;
    localTransferRequest.mSecondId = paramString3;
    localTransferRequest.mUinType = paramInt1;
    localTransferRequest.mUniseq = paramLong;
    localTransferRequest.mBusiType = paramInt2;
    localTransferRequest.mUpCallBack = paramUpCallBack;
    localTransferRequest.upMsgBusiType = a();
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
    return true;
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a(SessionInfo paramSessionInfo, long paramLong, int paramInt)
  {
    Object localObject = (ChatMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localObject != null) {
      if (((ChatMessage)localObject).msgtype == -1036)
      {
        localObject = (MessageForMixedMsg)((MessageForLongMsg)localObject).rebuildLongMsg();
        ((MessageForMixedMsg)localObject).mForwardFromUniSeq = paramLong;
        ((MessageForMixedMsg)localObject).forwardID = paramInt;
        ReplyMsgSender.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForMixedMsg)localObject, paramSessionInfo, paramInt);
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        localObject = (MessageForMixedMsg)localObject;
      }
    }
    QLog.e("MixedMsgManager", 2, "forwardMixedMsg, not find in cache !");
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
    if ((paramQQAppInterface == null) || (paramBaseChatPie == null) || (paramMixedMsgInfo == null)) {}
    Object localObject1;
    label254:
    do
    {
      int m;
      Object localObject2;
      do
      {
        return;
        localObject1 = paramMixedMsgInfo.b();
        if ((TextUtils.isEmpty(paramMixedMsgInfo.b())) && (localObject1 != null) && (((List)localObject1).size() == 1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MixedMsgManager", 2, "sendMixedMrInfo, only 1 pic, send by pic message");
          }
          paramArrayList = null;
          if (paramBoolean)
          {
            paramArrayList = new Intent();
            paramArrayList.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1057);
          }
          AIOPanelUtiles.a(paramQQAppInterface, paramBaseChatPie, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, false, paramArrayList).a(paramBaseChatPie, (List)localObject1, false);
          return;
        }
        int i;
        MessageForReplyText.SourceMsgInfo localSourceMsgInfo;
        boolean bool1;
        Object localObject3;
        int k;
        int j;
        Object localObject4;
        Object localObject5;
        if (localObject1 == null)
        {
          i = 0;
          a("0X800AE1B", i);
          localSourceMsgInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
          localObject1 = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          m = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
          paramBaseChatPie = new ArrayList();
          boolean bool2 = false;
          bool1 = bool2;
          if (paramArrayList != null)
          {
            bool1 = bool2;
            if (!paramArrayList.isEmpty())
            {
              localObject2 = (TroopRobotManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
              localObject3 = paramArrayList.iterator();
              do
              {
                bool1 = bool2;
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
              } while (!((TroopRobotManager)localObject2).a(((AtTroopMemberInfo)((Iterator)localObject3).next()).uin));
              bool1 = true;
            }
          }
          localObject2 = new HashMap();
          k = 0;
          i = 1;
          if (k >= paramMixedMsgInfo.a().size()) {
            break label698;
          }
          localObject3 = (MixedMsgInfo.MsgNode)paramMixedMsgInfo.a().get(k);
          j = i;
          if ((localObject3 instanceof MixedMsgInfo.TextMsgNode))
          {
            localObject4 = ((MixedMsgInfo.MsgNode)localObject3).text();
            j = i;
            if (!TextUtils.isEmpty((CharSequence)localObject4))
            {
              if ((i == 0) || (localSourceMsgInfo == null)) {
                break label627;
              }
              localObject5 = MessageRecordFactory.a(paramQQAppInterface, (String)localObject1, m, localSourceMsgInfo, (String)localObject4);
              ((MessageForReplyText)localObject5).atInfoList = paramArrayList;
              paramBaseChatPie.add(localObject5);
              if (QLog.isColorLevel()) {
                QLog.d("MixedMsgManager", 2, "Attach at first text node");
              }
              i = 0;
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("MixedMsgManager", 2, "add txt:" + (String)localObject4);
                j = i;
              }
            }
          }
          if ((localObject3 instanceof MixedMsgInfo.PhotoMsgNode))
          {
            localObject3 = ((MixedMsgInfo.PhotoMsgNode)localObject3).getPhotoItem();
            if ((localObject3 != null) && (FileUtil.a(((MixedMsgInfo.PhotoItem)localObject3).path)))
            {
              localObject4 = a(paramQQAppInterface, ((MixedMsgInfo.PhotoItem)localObject3).path, null, (String)localObject1, m);
              ThreadManager.getFileThreadHandler().post(new MixedMsgManager.6(this, (MessageForPic)localObject4));
              ((MessageForPic)localObject4).subMsgId = paramBaseChatPie.size();
              paramBaseChatPie.add(localObject4);
              localObject5 = (Boolean)((Map)localObject2).get(((MessageForPic)localObject4).path);
              if (localObject5 != null) {
                break label666;
              }
              ((Map)localObject2).put(((MessageForPic)localObject4).path, Boolean.valueOf(((MixedMsgInfo.PhotoItem)localObject3).isOriginal));
            }
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MixedMsgManager", 2, "add pic:" + ((MessageForPic)localObject4).path + ", raw:" + ((Map)localObject2).get(((MessageForPic)localObject4).path));
          }
          k += 1;
          i = j;
          break label254;
          i = ((List)localObject1).size();
          break;
          localObject5 = MessageRecordFactory.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), (String)localObject1, (String)localObject1, m, (byte)1, (byte)0, (short)0, (String)localObject4);
          ((MessageForText)localObject5).atInfoList = paramArrayList;
          paramBaseChatPie.add(localObject5);
          break label374;
          if (!((Boolean)localObject5).booleanValue()) {
            ((Map)localObject2).put(((MessageForPic)localObject4).path, Boolean.valueOf(((MixedMsgInfo.PhotoItem)localObject3).isOriginal));
          }
        }
        paramBaseChatPie = a(paramBaseChatPie, paramArrayList, localSourceMsgInfo, m, bool1);
      } while (paramBaseChatPie == null);
      if (paramBoolean) {
        ((TroopEssenceMsgManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).a(paramBaseChatPie.frienduin, paramBaseChatPie.uniseq);
      }
      a(paramBaseChatPie, paramArrayList, (String)localObject1, (Map)localObject2);
      paramQQAppInterface.getMessageFacade().f((String)localObject1, m);
    } while (!QLog.isColorLevel());
    label374:
    QLog.d("MixedMsgManager", 2, "orderSender, sessionUin:" + (String)localObject1 + ", sequin:" + paramBaseChatPie.uniseq);
    label627:
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
    if ((paramQQAppInterface == null) || (paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    Object localObject = new ArrayList();
    boolean bool;
    if (paramSourceMsgInfo != null)
    {
      paramString2 = MessageRecordFactory.a(paramQQAppInterface, paramString1, paramInt, paramSourceMsgInfo, paramString2);
      paramString2.atInfoList = paramArrayList1;
      ((List)localObject).add(paramString2);
      bool = false;
    }
    for (;;)
    {
      label64:
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramString2 = (String)paramArrayList.next();
        if (FileUtil.a(paramString2))
        {
          paramString2 = a(paramQQAppInterface, paramString2, null, paramString1, paramInt);
          if (paramString2 != null)
          {
            ThreadManager.post(new MixedMsgManager.5(this, paramString2), 8, null, true);
            paramString2.subMsgId = ((List)localObject).size();
            ((List)localObject).add(paramString2);
            continue;
            if (TextUtils.isEmpty(paramString2)) {
              break label417;
            }
            paramString2 = MessageRecordFactory.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, paramInt, (byte)1, (byte)0, (short)0, paramString2);
            paramString2.atInfoList = paramArrayList1;
            if ((paramString2.atInfoList == null) || (paramString2.atInfoList.isEmpty())) {
              break label411;
            }
            TroopRobotManager localTroopRobotManager = (TroopRobotManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
            Iterator localIterator = paramString2.atInfoList.iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
            } while (!localTroopRobotManager.a(((AtTroopMemberInfo)localIterator.next()).uin));
          }
        }
      }
      label411:
      for (bool = true;; bool = false)
      {
        ((List)localObject).add(paramString2);
        break label64;
        paramArrayList = a((List)localObject, paramArrayList1, paramSourceMsgInfo, paramInt, bool);
        if (paramArrayList == null) {
          break;
        }
        paramString2 = new HashMap();
        paramSourceMsgInfo = paramArrayList.msgElemList.iterator();
        while (paramSourceMsgInfo.hasNext())
        {
          localObject = (MessageRecord)paramSourceMsgInfo.next();
          if ((localObject instanceof MessageForPic))
          {
            localObject = (MessageForPic)localObject;
            if (FileUtil.a(((MessageForPic)localObject).path)) {
              paramString2.put(((MessageForPic)localObject).path, Boolean.valueOf(paramBoolean));
            }
          }
        }
        a(paramArrayList, paramArrayList1, paramString1, paramString2);
        paramQQAppInterface.getMessageFacade().f(paramString1, paramInt);
        return;
      }
      label417:
      bool = false;
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
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, "step2: sendStructLongMsg saveMessage end and pack StructLongMsg start currenttime:" + System.currentTimeMillis());
    }
    byte[] arrayOfByte = paramQQAppInterface.getProxyManager().a().a(paramMessageForMixedMsg);
    if (arrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "step2: sendStructLongMsg pack failed! packData is null.............................");
      }
      a(paramMessageForMixedMsg, true, "sendStructLongMsg pack fail : packData is null");
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        paramString = new MixedMsgManager.3(this, paramQQAppInterface, paramMessageForMixedMsg, paramString, paramInt);
        paramBoolean = a(paramQQAppInterface, arrayOfByte, paramQQAppInterface.getCurrentAccountUin(), paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 1035, new MixedMsgManager.4(this, paramQQAppInterface, paramMessageForMixedMsg, paramString));
        if (!paramBoolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MixedMsgManager", 2, "sendLongTextMsg successful, uploadLongTextMsgPkg start!");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("MixedMsgManager", 2, "sendLongTextMsg failed! isSuccess:" + paramBoolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgManager
 * JD-Core Version:    0.7.0.1
 */