package com.tencent.mobileqq.msf.core.stepcount;

import android.os.Build.VERSION;
import com.tencent.mobileqq.msf.core.u;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class e
  implements b
{
  private static final String a = "LegacyStepCounter";
  
  public e()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if ((g.a().c() == 1) && (Build.VERSION.SDK_INT > 19) && (localBaseApplication != null))
    {
      QLog.i("LegacyStepCounter", 1, "step counter attach mode, results of new step counter report to beacon only.");
      u.am = new f(this, new a(localBaseApplication));
    }
  }
  
  public void a()
  {
    u.a(u.P);
  }
  
  public void a(String paramString, ToServiceMsg paramToServiceMsg)
  {
    u.a(paramString, paramToServiceMsg);
  }
  
  public void a(boolean paramBoolean)
  {
    u.an = paramBoolean;
    u.a(u.O);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.stepcount.e
 * JD-Core Version:    0.7.0.1
 */