package com.tencent.mobileqq.multimsg;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.Manager;

public class LongTextMsgManager
  implements IUpLoadMsgPackBusinessType, Manager
{
  public static final int[] a = { 0, 1, 3000 };
  public static boolean b = true;
  private static byte[] f = new byte[0];
  public boolean c = false;
  public boolean d = false;
  private QQAppInterface e;
  private long g;
  
  public LongTextMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.e = paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramMessageRecord.extraflag = 32768;
    paramQQAppInterface.getMsgCache().b(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.uniseq;
    ((MessageHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.b(paramMessageRecord.istroop), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, long paramLong, String paramString2)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestDownloadLongTextMsg begin! touin:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",touinType:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",uniseq:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",fileKey:");
      localStringBuilder.append(paramString2);
      QLog.d("StructLongTextMsg", 2, localStringBuilder.toString());
    }
    MultiMsgManager.a().a(paramQQAppInterface, paramString2, paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, paramInt, paramLong, 1035, new LongTextMsgManager.3(paramQQAppInterface, paramString1, paramInt, paramLong, l));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    LongTextMsgManager localLongTextMsgManager = (LongTextMsgManager)paramQQAppInterface.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER);
    if (!localLongTextMsgManager.c)
    {
      String str = paramQQAppInterface.getAccount();
      paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_");
      localStringBuilder.append("long_text_msg_config_version");
      if (paramQQAppInterface.contains(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append("long_text_msg_switch");
        localLongTextMsgManager.d = paramQQAppInterface.getBoolean(localStringBuilder.toString(), b);
      }
    }
    localLongTextMsgManager.c = true;
    return localLongTextMsgManager.d;
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (paramInt2 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_resultCode", String.valueOf(paramInt2));
    localHashMap.put("param_uin", paramQQAppInterface.getCurrentAccountUin());
    localHashMap.put("param_isTroop", String.valueOf(paramInt1));
    if (paramInt3 != 1)
    {
      if (paramInt3 != 2) {
        return;
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "ltextManualPullResult", bool, 0L, 0L, localHashMap, "");
      return;
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "ltextAutoPullResult", bool, 0L, 0L, localHashMap, "");
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((paramMessageRecord instanceof MessageForReplyText))
    {
      a(paramQQAppInterface, paramMessageRecord, paramBoolean, new LongTextMsgManager.1(this, paramQQAppInterface, paramMessageRecord, paramBoolean));
      return;
    }
    a(paramQQAppInterface, paramMessageRecord, paramBoolean, new LongTextMsgManager.2(this, paramQQAppInterface, paramMessageRecord, paramBoolean));
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean, UpCallBack paramUpCallBack)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructLongTextMsg", 4, " sendLongTextMsg start");
    }
    if (paramMessageRecord == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("step1: sendLongTextMsg saveMessage start currenttime:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("StructLongTextMsg", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramMessageRecord instanceof ChatMessage)) {
      ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
    }
    if ((!paramBoolean) || (TextUtils.isEmpty(paramMessageRecord.extStr)))
    {
      paramMessageRecord.saveExtInfoToExtStr("long_text_recv_state", "0");
      paramQQAppInterface.getMessageFacade().a(paramMessageRecord);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveLongTextMsg reSend:");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(",extStr:");
        ((StringBuilder)localObject).append(paramMessageRecord.extStr);
        QLog.d("StructLongTextMsg", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("step2: sendLongTextMsg saveMessage end and pack longTextMsg start currenttime:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("StructLongTextMsg", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramQQAppInterface.getProxyManager().b().b(paramMessageRecord);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "step2: sendLongTextMsg pack failed! packData is null.............................");
      }
      paramMessageRecord.extraflag = 32768;
      paramQQAppInterface.getMsgCache().b(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
      paramUpCallBack = paramMessageRecord.frienduin;
      int i = paramMessageRecord.istroop;
      long l = paramMessageRecord.uniseq;
      ((MessageHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.b(paramMessageRecord.istroop), false, new Object[] { paramUpCallBack, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
      return;
    }
    this.g = System.currentTimeMillis();
    paramBoolean = a(paramQQAppInterface, (byte[])localObject, paramQQAppInterface.getCurrentAccountUin(), paramMessageRecord.frienduin, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, 1035, paramUpCallBack);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "sendLongTextMsg successful, uploadLongTextMsgPkg start!");
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramUpCallBack = new StringBuilder();
        paramUpCallBack.append("sendLongTextMsg failed! isSuccess:");
        paramUpCallBack.append(paramBoolean);
        QLog.d("StructLongTextMsg", 2, paramUpCallBack.toString());
      }
      a(paramQQAppInterface, paramMessageRecord);
    }
  }
  
  public void a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    try
    {
      MessageRecord localMessageRecord = this.e.getMessageProxy(paramInt1).b(paramString, paramInt1, paramLong1);
      if (localMessageRecord != null)
      {
        Object localObject = new HashMap();
        ((HashMap)localObject).put("param_istroop", String.valueOf(localMessageRecord.istroop));
        ((HashMap)localObject).put("param_msgtype", String.valueOf(localMessageRecord.msgtype));
        ((HashMap)localObject).put("param_replycode", String.valueOf(paramInt2));
        ((HashMap)localObject).put("param_cost", String.valueOf(paramLong2));
        ((HashMap)localObject).put("param_isAnonymous", String.valueOf(AnonymousChatHelper.c(localMessageRecord)));
        if (localMessageRecord.msgtype == -1051)
        {
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.e.getCurrentAccountUin(), "ltextNewSendResult", true, 0L, 0L, (HashMap)localObject, "");
        }
        else
        {
          if ((!localMessageRecord.isLongMsg()) || (this.e.getMsgCache().f(localMessageRecord))) {
            break label446;
          }
          ((HashMap)localObject).put("param_longMsgCount", String.valueOf(localMessageRecord.longMsgCount));
          ((HashMap)localObject).put("param_longMsgId", String.valueOf(localMessageRecord.longMsgId));
          ((HashMap)localObject).put("param_longMsgIndex", String.valueOf(localMessageRecord.longMsgIndex));
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.e.getCurrentAccountUin(), "ltextOldSendResult", true, 0L, 0L, (HashMap)localObject, "");
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("reportSendLongMsg  peerUin:");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(" istroop=");
          ((StringBuilder)localObject).append(localMessageRecord.istroop);
          ((StringBuilder)localObject).append(" issend=");
          ((StringBuilder)localObject).append(localMessageRecord.issend);
          ((StringBuilder)localObject).append(" msgType=");
          ((StringBuilder)localObject).append(localMessageRecord.msgtype);
          ((StringBuilder)localObject).append(" longMsgCount=");
          ((StringBuilder)localObject).append(localMessageRecord.longMsgCount);
          ((StringBuilder)localObject).append(" longMsgId=");
          ((StringBuilder)localObject).append(localMessageRecord.longMsgId);
          ((StringBuilder)localObject).append(" longMsgIndex=");
          ((StringBuilder)localObject).append(localMessageRecord.longMsgIndex);
          ((StringBuilder)localObject).append(" replyCost=");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append(" cost=");
          ((StringBuilder)localObject).append(paramLong2);
          QLog.d("StructLongTextMsg", 2, ((StringBuilder)localObject).toString());
          return;
          label446:
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      QLog.d("StructLongTextMsg", 1, "longmsg send report error!", paramString);
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, UpCallBack paramUpCallBack)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[sendLongTextMsg]data.length = ");
      ((StringBuilder)localObject).append(paramArrayOfByte.length);
      QLog.d("StructLongTextMsg", 2, ((StringBuilder)localObject).toString());
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
  
  public void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportReceiveLongMsg  istroop=");
      ((StringBuilder)localObject).append(paramMessageRecord.istroop);
      ((StringBuilder)localObject).append(" issend=");
      ((StringBuilder)localObject).append(paramMessageRecord.issend);
      ((StringBuilder)localObject).append(" msgType=");
      ((StringBuilder)localObject).append(paramMessageRecord.msgtype);
      ((StringBuilder)localObject).append(" longMsgCount=");
      ((StringBuilder)localObject).append(paramMessageRecord.longMsgCount);
      ((StringBuilder)localObject).append(" longMsgId=");
      ((StringBuilder)localObject).append(paramMessageRecord.longMsgId);
      ((StringBuilder)localObject).append(" longMsgIndex=");
      ((StringBuilder)localObject).append(paramMessageRecord.longMsgIndex);
      QLog.d("StructLongTextMsg", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_istroop", String.valueOf(paramMessageRecord.istroop));
    ((HashMap)localObject).put("param_issend", String.valueOf(paramMessageRecord.issend));
    ((HashMap)localObject).put("param_msgtype", String.valueOf(paramMessageRecord.msgtype));
    ((HashMap)localObject).put("param_isAnonymous", String.valueOf(AnonymousChatHelper.c(paramMessageRecord)));
    if (paramMessageRecord.msgtype == -1051)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "ltextNewReceiveResult", true, 0L, 0L, (HashMap)localObject, "");
      return;
    }
    if (paramMessageRecord.isLongMsg())
    {
      ((HashMap)localObject).put("param_longMsgCount", String.valueOf(paramMessageRecord.longMsgCount));
      ((HashMap)localObject).put("param_longMsgId", String.valueOf(paramMessageRecord.longMsgId));
      ((HashMap)localObject).put("param_longMsgIndex", String.valueOf(paramMessageRecord.longMsgIndex));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "ltextOldReceiveResult", true, 0L, 0L, (HashMap)localObject, "");
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.LongTextMsgManager
 * JD-Core Version:    0.7.0.1
 */