package com.tencent.mobileqq.msf.core.c;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.i;
import java.util.concurrent.LinkedBlockingDeque;

class l
  implements CrashHandleListener
{
  l(j paramj) {}
  
  public byte[] getCrashExtraData(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    return null;
  }
  
  public String getCrashExtraMessage(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCrashExtraMessage...isNativeCrashed: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" crashType=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" crashAddress=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" crashStack=");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(" native_SICODE=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" crashTime=");
    localStringBuilder.append(paramLong);
    QLog.d("MSF.C.StatReport", 1, localStringBuilder.toString());
    QLog.flushLog(true);
    if (paramString1.contains("OutOfMemory"))
    {
      i.a(j.a(this.a));
      paramString1 = j.a(this.a);
      paramString1.append("\n:SendQueueSize:");
      paramString1.append(MsfCore.sCore.sender.g.size());
      paramString1 = j.a(this.a);
      paramString1.append("\n:heapMax=");
      paramString1.append(Runtime.getRuntime().maxMemory());
      paramString1 = j.a(this.a);
      paramString1.append(",heapTotal=");
      paramString1.append(Runtime.getRuntime().totalMemory());
      paramString1 = j.a(this.a);
      paramString1.append(",heapFree=");
      paramString1.append(Runtime.getRuntime().freeMemory());
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("getCrashExtraMessage.");
      paramString1.append(j.a(this.a).toString());
      QLog.d("MSF.C.StatReport", 2, paramString1.toString());
    }
    return j.a(this.a).toString();
  }
  
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    return true;
  }
  
  public void onCrashHandleStart(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCrashHandleStart...isNativeCrashed: ");
    localStringBuilder.append(paramBoolean);
    QLog.d("MSF.C.StatReport", 1, localStringBuilder.toString());
    localStringBuilder = j.a(this.a);
    localStringBuilder.append("\nCurrent thread Id=");
    localStringBuilder.append(Process.myTid());
    localStringBuilder.append(", Name=");
    localStringBuilder.append(Thread.currentThread().getName());
    this.a.a();
    this.a.b();
  }
  
  public boolean onCrashSaving(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return (paramBoolean) || (!"java.util.concurrent.TimeoutException".equals(paramString1)) || (TextUtils.isEmpty(paramString3)) || (!paramString3.contains("java.lang.Daemons$FinalizerDaemon"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.l
 * JD-Core Version:    0.7.0.1
 */