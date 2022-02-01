package com.tencent.mobileqq.msf.core.c;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.aj;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingDeque;

class m
  implements CrashHandleListener
{
  m(k paramk) {}
  
  public byte[] getCrashExtraData(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    return null;
  }
  
  public String getCrashExtraMessage(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    QLog.d("MSF.C.StatReport", 1, "getCrashExtraMessage...isNativeCrashed: " + paramBoolean + " crashType=" + paramString1 + " crashAddress=" + paramString2 + " crashStack=" + paramString3 + " native_SICODE=" + paramInt + " crashTime=" + paramLong);
    QLog.flushLog(true);
    if (paramString1.contains("OutOfMemory"))
    {
      com.tencent.qphone.base.util.k.a(k.a(this.a));
      k.a(this.a).append("\n:SendQueueSize:").append(MsfCore.sCore.sender.g.size());
      k.a(this.a).append("\n:heapMax=").append(Runtime.getRuntime().maxMemory());
      k.a(this.a).append(",heapTotal=").append(Runtime.getRuntime().totalMemory());
      k.a(this.a).append(",heapFree=").append(Runtime.getRuntime().freeMemory());
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.StatReport", 2, "getCrashExtraMessage." + k.a(this.a).toString());
    }
    return k.a(this.a).toString();
  }
  
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    return true;
  }
  
  public void onCrashHandleStart(boolean paramBoolean)
  {
    QLog.d("MSF.C.StatReport", 1, "onCrashHandleStart...isNativeCrashed: " + paramBoolean);
    k.a(this.a).append("\nCurrent thread Id=").append(Process.myTid()).append(", Name=").append(Thread.currentThread().getName());
    this.a.a();
    this.a.b();
  }
  
  public boolean onCrashSaving(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return (paramBoolean) || (!"java.util.concurrent.TimeoutException".equals(paramString1)) || (TextUtils.isEmpty(paramString3)) || (!paramString3.contains("java.lang.Daemons$FinalizerDaemon"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.m
 * JD-Core Version:    0.7.0.1
 */