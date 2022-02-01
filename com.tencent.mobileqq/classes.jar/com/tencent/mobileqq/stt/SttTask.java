package com.tencent.mobileqq.stt;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.PttWithTextSwitchBean;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.shard.AIOSttResult;
import com.tencent.mobileqq.stt.shard.IntactSttPushReceiver;
import com.tencent.mobileqq.stt.shard.ShardSttPushReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.TransPttResp;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.TransPttShardRsp;

public class SttTask
{
  private static long jdField_a_of_type_Long;
  private int jdField_a_of_type_Int;
  private MessageForPtt jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  private IntactSttPushReceiver jdField_a_of_type_ComTencentMobileqqSttShardIntactSttPushReceiver;
  private ShardSttPushReceiver jdField_a_of_type_ComTencentMobileqqSttShardShardSttPushReceiver;
  private volatile Long jdField_a_of_type_JavaLangLong;
  private WeakReference<Handler> jdField_a_of_type_MqqUtilWeakReference;
  private int jdField_b_of_type_Int;
  private volatile Long jdField_b_of_type_JavaLangLong;
  private WeakReference<AppRuntime> jdField_b_of_type_MqqUtilWeakReference;
  
  public SttTask()
  {
    Long localLong = Long.valueOf(0L);
    this.jdField_a_of_type_JavaLangLong = localLong;
    this.jdField_b_of_type_JavaLangLong = localLong;
  }
  
  public static long a()
  {
    if (jdField_a_of_type_Long == 0L)
    {
      long l2 = ((PttWithTextSwitchBean)QConfigManager.a().a(488)).a();
      long l1 = l2;
      if (l2 == 0L) {
        l1 = 45000L;
      }
      jdField_a_of_type_Long = l1;
    }
    return jdField_a_of_type_Long;
  }
  
  public static SttTask a(MessageForPtt paramMessageForPtt, AppRuntime paramAppRuntime, int paramInt)
  {
    if ((paramMessageForPtt != null) && (paramAppRuntime != null))
    {
      SttTask localSttTask = new SttTask();
      localSttTask.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = paramMessageForPtt;
      localSttTask.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramAppRuntime);
      localSttTask.jdField_b_of_type_Int = paramInt;
      return localSttTask;
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    a(paramInt, -1L);
  }
  
  private void a(int paramInt, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if ((localObject != null) && (!((WeakReference)localObject).isEnqueued()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendMsgHandlerDelayed,  msgKey = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" | sessionID = ");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append(" | delayMillis = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.e("Q.stt_SttTask", 1, ((StringBuilder)localObject).toString());
      localObject = (Handler)this.jdField_a_of_type_MqqUtilWeakReference.get();
      long l = a().longValue();
      Message localMessage = ((Handler)localObject).obtainMessage(paramInt, (int)(l >> 32) & 0xFFFFFFFF, (int)(l & 0xFFFFFFFF), this);
      if (paramLong > 0L)
      {
        ((Handler)localObject).sendMessageDelayed(localMessage, paramLong);
        return;
      }
      ((Handler)localObject).sendMessage(localMessage);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendMsgHandlerDelayed, handlerWeakReference is Null msgKey = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" | sessionID = ");
    ((StringBuilder)localObject).append(a());
    QLog.e("Q.stt_SttTask", 1, ((StringBuilder)localObject).toString());
  }
  
  private long b()
  {
    int i = (int)(a().uniseq >> 32);
    int j = new Random().nextInt();
    long l = i & 0xFFFFFFFF;
    return j & 0xFFFFFFFF | l << 32;
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if ((localObject != null) && (!((WeakReference)localObject).isEnqueued()))
    {
      localObject = (Handler)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (((Handler)localObject).hasMessages(paramInt, this))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkAndRemoveMsgHandler, hasMessages is true msgKey = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" | sessionID = ");
        localStringBuilder.append(a());
        QLog.e("Q.stt_SttTask", 1, localStringBuilder.toString());
        ((Handler)localObject).removeMessages(paramInt, this);
        boolean bool = ((Handler)localObject).hasMessages(paramInt, this);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkAndRemoveMsgHandler, removeMessages removeResult = ");
        ((StringBuilder)localObject).append(bool ^ true);
        ((StringBuilder)localObject).append(" | msgKey = ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" | sessionID = ");
        ((StringBuilder)localObject).append(a());
        QLog.e("Q.stt_SttTask", 1, ((StringBuilder)localObject).toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkAndRemoveMsgHandler, hasMessages is false msgKey = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" | sessionID = ");
      ((StringBuilder)localObject).append(a());
      QLog.e("Q.stt_SttTask", 1, ((StringBuilder)localObject).toString());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkAndRemoveMsgHandler, handlerWeakReference is Null msgKey = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" | sessionID = ");
    ((StringBuilder)localObject).append(a());
    QLog.e("Q.stt_SttTask", 1, ((StringBuilder)localObject).toString());
  }
  
  private Long c()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("realRetryStt session = ");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append(", retryNum = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.e("Q.stt_SttTask", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_b_of_type_JavaLangLong = Long.valueOf(0L);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSttShardShardSttPushReceiver;
    if (localObject != null) {
      ((ShardSttPushReceiver)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqSttShardIntactSttPushReceiver;
    if (localObject != null) {
      ((IntactSttPushReceiver)localObject).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a(false);
    return b();
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_b_of_type_JavaLangLong.longValue() == 0L) {
      return;
    }
    long l = System.currentTimeMillis() - this.jdField_b_of_type_JavaLangLong.longValue();
    this.jdField_b_of_type_JavaLangLong = Long.valueOf(0L);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PttSttReport reportSttFristPackTimeCost cost = ");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("  | type = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.stt_SttTask", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append("");
    ((HashMap)localObject).put("timeCost", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    ((HashMap)localObject).put("sttType", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append("");
    ((HashMap)localObject).put("ntimeCost", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttSttFristShowTimeCost", true, 0L, 0L, (HashMap)localObject, null);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a();
  }
  
  public MessageForPtt a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  }
  
  public Long a()
  {
    return this.jdField_a_of_type_JavaLangLong;
  }
  
  public Long a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkTimeOutRetryStt session = ");
      localStringBuilder.append(a());
      localStringBuilder.append(", timeoutType = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", retryNum = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.e("Q.stt_SttTask", 2, localStringBuilder.toString());
    }
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    if (i > 3)
    {
      a().getSttResult().a(3, paramInt);
      return null;
    }
    return c();
  }
  
  public void a(Handler paramHandler)
  {
    if (paramHandler == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.stt_SttTask", 2, "setTimeoutHandler timeoutHandler is null");
      }
      return;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramHandler);
  }
  
  public boolean a(SttResultPush.MsgBody paramMsgBody)
  {
    if (paramMsgBody == null)
    {
      if (QLog.isColorLevel())
      {
        paramMsgBody = new StringBuilder();
        paramMsgBody.append("doReceivePushData resp is null. session = ");
        paramMsgBody.append(a());
        QLog.e("Q.stt_SttTask", 2, paramMsgBody.toString());
      }
      return false;
    }
    if ((a() != 2) && (a() != 1)) {
      return true;
    }
    int j;
    int i;
    if (paramMsgBody.msg_ptt_shard_resp.has())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSttShardShardSttPushReceiver == null) {
        this.jdField_a_of_type_ComTencentMobileqqSttShardShardSttPushReceiver = new ShardSttPushReceiver(a().getSttResult());
      }
      j = this.jdField_a_of_type_ComTencentMobileqqSttShardShardSttPushReceiver.a(paramMsgBody);
      i = 1;
    }
    else
    {
      if (!paramMsgBody.msg_ptt_resp.has()) {
        break label339;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSttShardIntactSttPushReceiver == null) {
        this.jdField_a_of_type_ComTencentMobileqqSttShardIntactSttPushReceiver = new IntactSttPushReceiver(a().getSttResult());
      }
      j = this.jdField_a_of_type_ComTencentMobileqqSttShardIntactSttPushReceiver.a(paramMsgBody);
      i = 2;
    }
    if ((j != 0) && (j != -10001) && (j != -10002))
    {
      a(1002);
      return false;
    }
    b(1);
    b(3);
    int k;
    if (j == -10002) {
      k = 4;
    } else {
      k = 2;
    }
    if (a() == 3)
    {
      if (QLog.isColorLevel())
      {
        paramMsgBody = new StringBuilder();
        paramMsgBody.append("doReceivePushData stt receive success session = ");
        paramMsgBody.append(a());
        QLog.d("Q.stt_SttTask", 2, paramMsgBody.toString());
      }
      a(k);
      c(i);
      return true;
    }
    if ((a() == 2) && ((j == -10001) || (j == -10002)))
    {
      a(k);
      if (i == 1) {
        c(1);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a()) {
      a(3, a());
    }
    return true;
    label339:
    if (QLog.isColorLevel())
    {
      paramMsgBody = new StringBuilder();
      paramMsgBody.append("doReceivePushData msg_ptt_resp and msg_ptt_shard_resp all are null. session = ");
      paramMsgBody.append(a());
      QLog.e("Q.stt_SttTask", 2, paramMsgBody.toString());
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().b();
    Long localLong = Long.valueOf(paramBundle.getLong("k_time_out", 60000L));
    int i = paramBundle.getInt("k_result_code", 0);
    String str = paramBundle.getString("k_ptt_trans_txt", null);
    paramBundle.getInt("k_retry", 0);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onReceive, session = ");
      paramBundle.append(a());
      paramBundle.append(", timeout = ");
      paramBundle.append(localLong);
      paramBundle.append(", retryNum = ");
      paramBundle.append(this.jdField_a_of_type_Int);
      QLog.d("Q.stt_SttTask", 2, paramBundle.toString());
    }
    if (paramBoolean)
    {
      if (str != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a(false);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a(str, true);
        a(2);
        c(3);
        return paramBoolean;
      }
      a(1, localLong.longValue());
      return paramBoolean;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a(2, i);
    a(1001);
    return paramBoolean;
  }
  
  public Long b()
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_b_of_type_MqqUtilWeakReference != null) && (!this.jdField_b_of_type_MqqUtilWeakReference.isEnqueued()))
        {
          Object localObject1 = (AppRuntime)this.jdField_b_of_type_MqqUtilWeakReference.get();
          if (localObject1 == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a(2, 2005);
            a(1001);
            return null;
          }
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a();
          long l = b();
          this.jdField_a_of_type_JavaLangLong = Long.valueOf(l);
          SttServlet.a((AppRuntime)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, Long.valueOf(l), this.jdField_b_of_type_Int, 1);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("sendSttRequest, session = ");
            ((StringBuilder)localObject1).append(a());
            ((StringBuilder)localObject1).append(", version = ");
            ((StringBuilder)localObject1).append(1);
            ((StringBuilder)localObject1).append(", retryNum = ");
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
            QLog.d("Q.stt_SttTask", 2, ((StringBuilder)localObject1).toString());
          }
          this.jdField_b_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
          return Long.valueOf(l);
        }
      }
      finally {}
      Object localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.stt.SttTask
 * JD-Core Version:    0.7.0.1
 */