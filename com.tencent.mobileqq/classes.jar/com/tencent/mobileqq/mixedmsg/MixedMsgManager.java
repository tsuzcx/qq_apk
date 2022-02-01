package com.tencent.mobileqq.mixedmsg;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.image.GifDrawable;
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
import com.tencent.mobileqq.app.MediaMessageObserver;
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
import com.tencent.mobileqq.pic.api.IPicUtil;
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
import java.io.File;
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
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.RichText;

public class MixedMsgManager
  implements IUpLoadMsgPackBusinessType, Manager
{
  private static final String c;
  public ConcurrentHashMap<Long, ChatMessage> a = new ConcurrentHashMap();
  public QQAppInterface b;
  private long d;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("fight/pic_expire.png");
    c = localStringBuilder.toString();
  }
  
  public MixedMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  @NotNull
  private MediaMessageObserver a(String paramString, int paramInt, MessageForMixedMsg paramMessageForMixedMsg, QQAppInterface paramQQAppInterface)
  {
    return new MixedMsgManager.4(this, paramQQAppInterface, paramMessageForMixedMsg, paramString, paramInt);
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
      paramString3 = new File(paramString1);
      if (paramString3.exists()) {
        if (GifDrawable.isGifFile(paramString3)) {
          paramString2.imageType = 2000;
        } else {
          paramString2.imageType = ((IPicUtil)QRoute.api(IPicUtil.class)).getImageType(paramString1);
        }
      }
      paramString2.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString2.path));
      if (BaseImageUtil.c(paramString1))
      {
        paramString1 = new PicMessageExtraData();
        paramString1.textSummary = paramQQAppInterface.getApp().getString(2131888229);
        paramString2.picExtraData = paramString1;
      }
      if ((paramInt == 10014) && (paramString2.picExtraData != null)) {
        paramString2.picExtraData = new PicMessageExtraData();
      }
      paramString2.serial();
      return paramString2;
    }
    return null;
  }
  
  public static List<MessageRecord> a(QQAppInterface paramQQAppInterface, ArrayList<AtTroopMemberInfo> paramArrayList, MixedMsgInfo paramMixedMsgInfo, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString, int paramInt, Map<String, Boolean> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = 1;
    while (j < paramMixedMsgInfo.a().size())
    {
      Object localObject1 = (MixedMsgInfo.MsgNode)paramMixedMsgInfo.a().get(j);
      Object localObject2;
      if ((localObject1 instanceof MixedMsgInfo.TextMsgNode))
      {
        str = ((MixedMsgInfo.MsgNode)localObject1).text();
        if (!TextUtils.isEmpty(str))
        {
          if ((i != 0) && (paramSourceMsgInfo != null))
          {
            localObject2 = MessageRecordFactory.a(paramQQAppInterface, paramString, paramInt, paramSourceMsgInfo, str);
            ((MessageForReplyText)localObject2).atInfoList = paramArrayList;
            localArrayList.add(localObject2);
            if (QLog.isColorLevel()) {
              QLog.d("MixedMsgManager", 2, "Attach at first text node");
            }
            i = 0;
          }
          else
          {
            localObject2 = MessageRecordFactory.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), paramString, paramString, paramInt, (byte)1, (byte)0, (short)0, str);
            ((MessageForText)localObject2).atInfoList = paramArrayList;
            localArrayList.add(localObject2);
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("add txt:");
            ((StringBuilder)localObject2).append(str);
            localObject2 = ((StringBuilder)localObject2).toString();
            str = "MixedMsgManager";
            QLog.d(str, 2, (String)localObject2);
            break label229;
          }
          str = "MixedMsgManager";
          break label229;
        }
      }
      String str = "MixedMsgManager";
      label229:
      if ((localObject1 instanceof MixedMsgInfo.PhotoMsgNode))
      {
        localObject2 = ((MixedMsgInfo.PhotoMsgNode)localObject1).getPhotoItem();
        if ((localObject2 != null) && (FileUtil.d(((MixedMsgInfo.PhotoItem)localObject2).path)))
        {
          localObject1 = a(paramQQAppInterface, ((MixedMsgInfo.PhotoItem)localObject2).path, null, paramString, paramInt);
          ThreadManager.getFileThreadHandler().post(new MixedMsgManager.6((MessageForPic)localObject1));
          ((MessageForPic)localObject1).subMsgId = localArrayList.size();
          localArrayList.add(localObject1);
          Boolean localBoolean = (Boolean)paramMap.get(((MessageForPic)localObject1).path);
          if (localBoolean == null) {
            paramMap.put(((MessageForPic)localObject1).path, Boolean.valueOf(((MixedMsgInfo.PhotoItem)localObject2).isOriginal));
          } else if (!localBoolean.booleanValue()) {
            paramMap.put(((MessageForPic)localObject1).path, Boolean.valueOf(((MixedMsgInfo.PhotoItem)localObject2).isOriginal));
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("add pic:");
            ((StringBuilder)localObject2).append(((MessageForPic)localObject1).path);
            ((StringBuilder)localObject2).append(", raw:");
            ((StringBuilder)localObject2).append(paramMap.get(((MessageForPic)localObject1).path));
            QLog.d(str, 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
      j += 1;
    }
    return localArrayList;
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
    if (paramInt == 10014) {
      ((IOrderMediaMsgService)paramQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).sendOrderMsg(paramMessageForMixedMsg, a(paramMessageForMixedMsg.frienduin, 10014, paramMessageForMixedMsg, paramQQAppInterface));
    } else {
      a(paramString, paramInt, paramMessageForMixedMsg, paramQQAppInterface, false);
    }
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
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    if ((paramMessageForMixedMsg.istroop != 3000) && (paramMessageForMixedMsg.istroop != 1)) {
      this.b.getMessageFacade().a(paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 32770, paramMessageForMixedMsg.sendFailCode);
    }
    b(this.b, paramMessageForMixedMsg);
    this.a.remove(paramMessageForMixedMsg);
    this.a.remove(Long.valueOf(paramMessageForMixedMsg.mForwardFromUniSeq));
    a(true, paramBoolean, paramMessageForMixedMsg, null);
  }
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean, String paramString)
  {
    this.b.getMessageFacade().a(paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 32768, paramMessageForMixedMsg.sendFailCode);
    a(this.b, paramMessageForMixedMsg);
    this.a.remove(Long.valueOf(paramMessageForMixedMsg.mForwardFromUniSeq));
    ((IOrderMediaMsgService)this.b.getRuntimeService(IOrderMediaMsgService.class)).removeMediaMsgByUniseq(paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.uniseq);
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
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.b.getCurrentAccountUin(), "MixedMsgForward", paramBoolean1, 0L, 0L, localHashMap, "");
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
    Object localObject = (ChatMessage)this.a.get(Long.valueOf(paramLong));
    if (localObject != null)
    {
      if (((ChatMessage)localObject).msgtype == -1036) {
        localObject = (MessageForMixedMsg)((MessageForLongMsg)localObject).rebuildLongMsg();
      } else {
        localObject = (MessageForMixedMsg)localObject;
      }
      ((MessageForMixedMsg)localObject).mForwardFromUniSeq = paramLong;
      ((MessageForMixedMsg)localObject).forwardID = paramInt;
      ReplyMsgSender.a().a(this.b, (MessageForMixedMsg)localObject, paramSessionInfo, paramInt);
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
    this.b.execute(paramSessionInfo);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ArrayList<AtTroopMemberInfo> paramArrayList, MixedMsgInfo paramMixedMsgInfo, boolean paramBoolean)
  {
    if ((paramQQAppInterface != null) && (paramBaseChatPie != null) && (paramMixedMsgInfo != null))
    {
      Object localObject = paramMixedMsgInfo.e();
      boolean bool1 = TextUtils.isEmpty(paramMixedMsgInfo.c());
      boolean bool2 = false;
      if ((bool1) && (localObject != null) && (((List)localObject).size() == 1))
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
        paramMixedMsgInfo = paramBaseChatPie.bv().p().d().e();
        AIOPanelUtiles.a(paramQQAppInterface, paramBaseChatPie.bv(), paramMixedMsgInfo, paramBaseChatPie.W, false, paramArrayList).a(paramBaseChatPie, (List)localObject, false);
        return;
      }
      if (localObject == null) {
        i = 0;
      } else {
        i = ((List)localObject).size();
      }
      a("0X800AE1B", i);
      MessageForReplyText.SourceMsgInfo localSourceMsgInfo = ((ReplyHelper)paramBaseChatPie.q(119)).a();
      localObject = paramBaseChatPie.ah.b;
      int i = paramBaseChatPie.ah.a;
      bool1 = bool2;
      if (paramArrayList != null)
      {
        bool1 = bool2;
        if (!paramArrayList.isEmpty())
        {
          paramBaseChatPie = (ITroopRobotService)paramQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
          Iterator localIterator = paramArrayList.iterator();
          do
          {
            bool1 = bool2;
            if (!localIterator.hasNext()) {
              break;
            }
          } while (!paramBaseChatPie.isRobotUin(((AtTroopMemberInfo)localIterator.next()).uin));
          bool1 = true;
        }
      }
      paramBaseChatPie = new HashMap();
      paramMixedMsgInfo = a(a(paramQQAppInterface, paramArrayList, paramMixedMsgInfo, localSourceMsgInfo, (String)localObject, i, paramBaseChatPie), paramArrayList, localSourceMsgInfo, i, bool1);
      if (paramMixedMsgInfo == null) {
        return;
      }
      if (paramBoolean) {
        ((TroopEssenceMsgManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).a(paramMixedMsgInfo.frienduin, paramMixedMsgInfo.uniseq);
      }
      a(paramMixedMsgInfo, paramArrayList, (String)localObject, paramBaseChatPie);
      paramQQAppInterface.getMessageFacade().s((String)localObject, i);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("orderSender, sessionUin:");
        paramQQAppInterface.append((String)localObject);
        paramQQAppInterface.append(", sequin:");
        paramQQAppInterface.append(paramMixedMsgInfo.uniseq);
        QLog.d("MixedMsgManager", 2, paramQQAppInterface.toString());
      }
      return;
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
    paramQQAppInterface.getMsgCache().b(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
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
      if (paramInt == 10014)
      {
        localObject = paramArrayList1.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((AtTroopMemberInfo)((Iterator)localObject).next()).isResvAttr = true;
        }
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
        if (FileUtil.d(paramString2))
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
            if (FileUtil.d(((MessageForPic)localObject).path)) {
              paramString2.put(((MessageForPic)localObject).path, Boolean.valueOf(paramBoolean));
            }
          }
        }
        a(paramArrayList, paramArrayList1, paramString1, paramString2);
        paramQQAppInterface.getMessageFacade().s(paramString1, paramInt);
      }
    }
  }
  
  public void a(MessageForMixedMsg paramMessageForMixedMsg, ArrayList<AtTroopMemberInfo> paramArrayList, String paramString, Map<String, Boolean> paramMap)
  {
    ((IOrderMediaMsgService)this.b.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByUniseq(paramString, paramMessageForMixedMsg.uniseq);
    ((IOrderMediaMsgService)this.b.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsg(paramMessageForMixedMsg, null);
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
        if (FileUtil.d(localMessageForPic.path))
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
        localObject = (Boolean)paramMap.get(paramArrayList.d);
        bool1 = bool2;
        if (localObject != null) {
          bool1 = ((Boolean)localObject).booleanValue();
        }
      }
      a(this.b, (MessageForPic)paramString.getKey(), bool1, paramArrayList);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("send pic req:");
        paramString.append(paramArrayList.d);
        paramString.append(", raw:");
        paramString.append(bool1);
        QLog.d("MixedMsgManager", 2, paramString.toString());
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_istroop", String.valueOf(paramMessageRecord.istroop));
    localHashMap.put("param_issend", String.valueOf(paramMessageRecord.issend));
    localHashMap.put("param_msgtype", String.valueOf(paramMessageRecord.msgtype));
    localHashMap.put("param_isAnonymous", String.valueOf(AnonymousChatHelper.c(paramMessageRecord)));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.b.getCurrentAccountUin(), "MixedMsgReceived", true, 0L, 0L, localHashMap, "");
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
    Object localObject = paramQQAppInterface.getProxyManager().b().b(paramMessageForMixedMsg);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "step2: sendStructLongMsg pack failed! packData is null.............................");
      }
      a(paramMessageForMixedMsg, true, "sendStructLongMsg pack fail : packData is null");
      return;
    }
    this.d = System.currentTimeMillis();
    paramString = a(paramString, paramInt, paramMessageForMixedMsg, paramQQAppInterface);
    paramBoolean = a(paramQQAppInterface, (byte[])localObject, paramQQAppInterface.getCurrentAccountUin(), paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 1035, new MixedMsgManager.3(this, paramQQAppInterface, paramMessageForMixedMsg, paramString));
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
    localHashMap.put("param_uin", this.b.getCurrentAccountUin());
    localHashMap.put("param_isTroop", String.valueOf(paramInt));
    if (paramBoolean)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.b.getCurrentAccountUin(), "MixedMsgClientAutoPull", true, 0L, 0L, localHashMap, "");
      return;
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.b.getCurrentAccountUin(), "MixedMsgClientManualPull", true, 0L, 0L, localHashMap, "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgManager
 * JD-Core Version:    0.7.0.1
 */