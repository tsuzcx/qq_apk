package com.tencent.mobileqq.msf.core.c;

import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.af;
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
    QLog.d("MSF.C.StatReport", 1, "getCrashExtraMessage...isNativeCrashed: " + paramBoolean + " crashType=" + paramString1 + " crashAddress=" + paramString2 + " crashStack=" + paramString3 + " native_SICODE=" + paramInt + " crashTime=" + paramLong);
    QLog.flushLog(true);
    if (paramString1.contains("OutOfMemory"))
    {
      i.a(j.a(this.a));
      j.a(this.a).append("\n:SendQueueSize:").append(MsfCore.sCore.sender.f.size());
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.StatReport", 2, "getCrashExtraMessage." + j.a(this.a).toString());
    }
    return j.a(this.a).toString();
  }
  
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    return true;
  }
  
  public void onCrashHandleStart(boolean paramBoolean)
  {
    this.a.a();
    this.a.b();
  }
  
  public boolean onCrashSaving(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.l
 * JD-Core Version:    0.7.0.1
 */