package com.tencent.mobileqq.kandian.repo.aladdin.sp;

import android.content.SharedPreferences;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class RIJViolaPicDetailConfigSp
{
  public static void a(int paramInt)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateViolaPicDetailonfig value=");
      localStringBuilder.append(paramInt);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    if (paramInt != 1) {
      bool1 = false;
    }
    RIJSPUtils.a("VIOLA_DYNAMIC_PIC_DETAIL", Boolean.valueOf(bool1));
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getViolaPicDetailConfig failed");
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("VIOLA_DYNAMIC_PIC_DETAIL", false);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getViolaPicDetailConfig result=");
    paramAppRuntime.append(bool);
    QLog.d("Q.readinjoy.tt_report", 1, paramAppRuntime.toString());
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJViolaPicDetailConfigSp
 * JD-Core Version:    0.7.0.1
 */