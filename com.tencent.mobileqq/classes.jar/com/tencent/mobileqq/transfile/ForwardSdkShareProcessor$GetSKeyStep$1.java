package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.data.SharedPrefs;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.SSOAccountObserver;

class ForwardSdkShareProcessor$GetSKeyStep$1
  extends SSOAccountObserver
{
  ForwardSdkShareProcessor$GetSKeyStep$1(ForwardSdkShareProcessor.GetSKeyStep paramGetSKeyStep) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetSKeyStep|onFailed|account=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",ret=");
    localStringBuilder.append(paramInt2);
    QLog.w("Q.share.ForwardSdkShareProcessor", 1, localStringBuilder.toString());
    if (this.this$1.this$0.isSdkShare()) {
      ForwardStatisticsReporter.a("KEY_SSO_GET_TICKET_NO_PASSWD", paramBundle, false);
    }
    this.this$1.this$0.mProcessorReport.setError(9401, "get sKey failed", null, null);
    this.this$1.doError();
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetSKeyStep|onGetTicketNoPasswd|account=");
    localStringBuilder.append(AuthorityUtil.a(paramString));
    localStringBuilder.append(",type=");
    localStringBuilder.append(paramInt);
    QLog.i("Q.share.ForwardSdkShareProcessor", 1, localStringBuilder.toString());
    if (this.this$1.this$0.isSdkShare()) {
      ForwardStatisticsReporter.a("KEY_SSO_GET_TICKET_NO_PASSWD", paramBundle, true);
    }
    long l = System.currentTimeMillis();
    if (paramInt == 4096)
    {
      ForwardSdkShareProcessor.access$202(this.this$1.this$0, new String(paramArrayOfByte));
      ForwardSdkShareProcessor.GetSKeyStep.access$300(this.this$1).set(true);
      SharedPrefs.a(paramString, l);
      this.this$1.doNextStep();
      return;
    }
    this.this$1.this$0.mProcessorReport.setError(9401, "get sKey failed", null, null);
    this.this$1.doError();
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    paramString = new StringBuilder();
    paramString.append("GetSKeyStep|onUserCancel|action=");
    paramString.append(paramInt);
    QLog.w("Q.share.ForwardSdkShareProcessor", 1, paramString.toString());
    if (this.this$1.this$0.isSdkShare()) {
      ForwardStatisticsReporter.a("KEY_SSO_GET_TICKET_NO_PASSWD", paramBundle, false);
    }
    this.this$1.this$0.mProcessorReport.setError(9401, "onUserCancel", null, null);
    this.this$1.doError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.GetSKeyStep.1
 * JD-Core Version:    0.7.0.1
 */