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
  private static long j;
  private MessageForPtt a;
  private int b;
  private WeakReference<Handler> c;
  private WeakReference<AppRuntime> d;
  private int e;
  private IntactSttPushReceiver f;
  private ShardSttPushReceiver g;
  private volatile Long h;
  private volatile Long i;
  
  public SttTask()
  {
    Long localLong = Long.valueOf(0L);
    this.h = localLong;
    this.i = localLong;
  }
  
  public static long a()
  {
    if (j == 0L)
    {
      long l2 = ((PttWithTextSwitchBean)QConfigManager.b().b(488)).b();
      long l1 = l2;
      if (l2 == 0L) {
        l1 = 45000L;
      }
      j = l1;
    }
    return j;
  }
  
  public static SttTask a(MessageForPtt paramMessageForPtt, AppRuntime paramAppRuntime, int paramInt)
  {
    if ((paramMessageForPtt != null) && (paramAppRuntime != null))
    {
      SttTask localSttTask = new SttTask();
      localSttTask.a = paramMessageForPtt;
      localSttTask.d = new WeakReference(paramAppRuntime);
      localSttTask.e = paramInt;
      return localSttTask;
    }
    return null;
  }
  
  private void a(int paramInt, long paramLong)
  {
    Object localObject = this.c;
    if ((localObject != null) && (!((WeakReference)localObject).isEnqueued()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendMsgHandlerDelayed,  msgKey = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" | sessionID = ");
      ((StringBuilder)localObject).append(d());
      ((StringBuilder)localObject).append(" | delayMillis = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.e("Q.stt_SttTask", 1, ((StringBuilder)localObject).toString());
      localObject = (Handler)this.c.get();
      long l = d().longValue();
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
    ((StringBuilder)localObject).append(d());
    QLog.e("Q.stt_SttTask", 1, ((StringBuilder)localObject).toString());
  }
  
  private void b(int paramInt)
  {
    a(paramInt, -1L);
  }
  
  private void c(int paramInt)
  {
    Object localObject = this.c;
    if ((localObject != null) && (!((WeakReference)localObject).isEnqueued()))
    {
      localObject = (Handler)this.c.get();
      if (((Handler)localObject).hasMessages(paramInt, this))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkAndRemoveMsgHandler, hasMessages is true msgKey = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" | sessionID = ");
        localStringBuilder.append(d());
        QLog.e("Q.stt_SttTask", 1, localStringBuilder.toString());
        ((Handler)localObject).removeMessages(paramInt, this);
        boolean bool = ((Handler)localObject).hasMessages(paramInt, this);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkAndRemoveMsgHandler, removeMessages removeResult = ");
        ((StringBuilder)localObject).append(bool ^ true);
        ((StringBuilder)localObject).append(" | msgKey = ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" | sessionID = ");
        ((StringBuilder)localObject).append(d());
        QLog.e("Q.stt_SttTask", 1, ((StringBuilder)localObject).toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkAndRemoveMsgHandler, hasMessages is false msgKey = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" | sessionID = ");
      ((StringBuilder)localObject).append(d());
      QLog.e("Q.stt_SttTask", 1, ((StringBuilder)localObject).toString());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkAndRemoveMsgHandler, handlerWeakReference is Null msgKey = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" | sessionID = ");
    ((StringBuilder)localObject).append(d());
    QLog.e("Q.stt_SttTask", 1, ((StringBuilder)localObject).toString());
  }
  
  private void d(int paramInt)
  {
    if (this.i.longValue() == 0L) {
      return;
    }
    long l = System.currentTimeMillis() - this.i.longValue();
    this.i = Long.valueOf(0L);
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
  
  private long f()
  {
    int k = (int)(b().uniseq >> 32);
    int m = new Random().nextInt();
    long l = k & 0xFFFFFFFF;
    return m & 0xFFFFFFFF | l << 32;
  }
  
  private Long g()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("realRetryStt session = ");
      ((StringBuilder)localObject).append(d());
      ((StringBuilder)localObject).append(", retryNum = ");
      ((StringBuilder)localObject).append(this.b);
      QLog.e("Q.stt_SttTask", 2, ((StringBuilder)localObject).toString());
    }
    this.i = Long.valueOf(0L);
    Object localObject = this.g;
    if (localObject != null) {
      ((ShardSttPushReceiver)localObject).a();
    }
    localObject = this.f;
    if (localObject != null) {
      ((IntactSttPushReceiver)localObject).a();
    }
    this.a.getSttResult().a(false);
    return e();
  }
  
  public Long a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkTimeOutRetryStt session = ");
      localStringBuilder.append(d());
      localStringBuilder.append(", timeoutType = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", retryNum = ");
      localStringBuilder.append(this.b);
      QLog.e("Q.stt_SttTask", 2, localStringBuilder.toString());
    }
    int k = this.b + 1;
    this.b = k;
    if (k > 3)
    {
      b().getSttResult().a(3, paramInt);
      return null;
    }
    return g();
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
    this.c = new WeakReference(paramHandler);
  }
  
  public boolean a(SttResultPush.MsgBody paramMsgBody)
  {
    if (paramMsgBody == null)
    {
      if (QLog.isColorLevel())
      {
        paramMsgBody = new StringBuilder();
        paramMsgBody.append("doReceivePushData resp is null. session = ");
        paramMsgBody.append(d());
        QLog.e("Q.stt_SttTask", 2, paramMsgBody.toString());
      }
      return false;
    }
    if ((c() != 2) && (c() != 1)) {
      return true;
    }
    int m;
    int k;
    if (paramMsgBody.msg_ptt_shard_resp.has())
    {
      if (this.g == null) {
        this.g = new ShardSttPushReceiver(b().getSttResult());
      }
      m = this.g.a(paramMsgBody);
      k = 1;
    }
    else
    {
      if (!paramMsgBody.msg_ptt_resp.has()) {
        break label339;
      }
      if (this.f == null) {
        this.f = new IntactSttPushReceiver(b().getSttResult());
      }
      m = this.f.a(paramMsgBody);
      k = 2;
    }
    if ((m != 0) && (m != -10001) && (m != -10002))
    {
      b(1002);
      return false;
    }
    c(1);
    c(3);
    int n;
    if (m == -10002) {
      n = 4;
    } else {
      n = 2;
    }
    if (c() == 3)
    {
      if (QLog.isColorLevel())
      {
        paramMsgBody = new StringBuilder();
        paramMsgBody.append("doReceivePushData stt receive success session = ");
        paramMsgBody.append(d());
        QLog.d("Q.stt_SttTask", 2, paramMsgBody.toString());
      }
      b(n);
      d(k);
      return true;
    }
    if ((c() == 2) && ((m == -10001) || (m == -10002)))
    {
      b(n);
      if (k == 1) {
        d(1);
      }
    }
    if (this.a.getSttResult().f()) {
      a(3, a());
    }
    return true;
    label339:
    if (QLog.isColorLevel())
    {
      paramMsgBody = new StringBuilder();
      paramMsgBody.append("doReceivePushData msg_ptt_resp and msg_ptt_shard_resp all are null. session = ");
      paramMsgBody.append(d());
      QLog.e("Q.stt_SttTask", 2, paramMsgBody.toString());
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.getSttResult().b();
    Long localLong = Long.valueOf(paramBundle.getLong("k_time_out", 60000L));
    int k = paramBundle.getInt("k_result_code", 0);
    String str = paramBundle.getString("k_ptt_trans_txt", null);
    paramBundle.getInt("k_retry", 0);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onReceive, session = ");
      paramBundle.append(d());
      paramBundle.append(", timeout = ");
      paramBundle.append(localLong);
      paramBundle.append(", retryNum = ");
      paramBundle.append(this.b);
      QLog.d("Q.stt_SttTask", 2, paramBundle.toString());
    }
    if (paramBoolean)
    {
      if (str != null)
      {
        this.a.getSttResult().a(false);
        this.a.getSttResult().a(str, true);
        b(2);
        d(3);
        return paramBoolean;
      }
      a(1, localLong.longValue());
      return paramBoolean;
    }
    this.a.getSttResult().a(2, k);
    b(1001);
    return paramBoolean;
  }
  
  public MessageForPtt b()
  {
    return this.a;
  }
  
  public int c()
  {
    return this.a.getSttResult().e();
  }
  
  public Long d()
  {
    return this.h;
  }
  
  public Long e()
  {
    for (;;)
    {
      try
      {
        if ((this.d != null) && (!this.d.isEnqueued()))
        {
          Object localObject1 = (AppRuntime)this.d.get();
          if (localObject1 == null)
          {
            this.a.getSttResult().a(2, 2005);
            b(1001);
            return null;
          }
          this.a.getSttResult().a();
          long l = f();
          this.h = Long.valueOf(l);
          SttServlet.a((AppRuntime)localObject1, this.a, Long.valueOf(l), this.e, 1);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("sendSttRequest, session = ");
            ((StringBuilder)localObject1).append(d());
            ((StringBuilder)localObject1).append(", version = ");
            ((StringBuilder)localObject1).append(1);
            ((StringBuilder)localObject1).append(", retryNum = ");
            ((StringBuilder)localObject1).append(this.b);
            QLog.d("Q.stt_SttTask", 2, ((StringBuilder)localObject1).toString());
          }
          this.i = Long.valueOf(System.currentTimeMillis());
          return Long.valueOf(l);
        }
      }
      finally {}
      Object localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.stt.SttTask
 * JD-Core Version:    0.7.0.1
 */