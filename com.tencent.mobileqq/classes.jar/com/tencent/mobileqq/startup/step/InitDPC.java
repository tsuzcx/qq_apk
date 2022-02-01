package com.tencent.mobileqq.startup.step;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;

public class InitDPC
  extends Step
{
  protected boolean doStep()
  {
    if (QLog.isColorLevel()) {
      QLog.i("InitDPC", 2, "InitDPC.doStep()");
    }
    String str = WebAccelerateHelper.getInstance().getTBSDpcParam();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tbs dpc: ");
      localStringBuilder.append(str);
      QLog.i("InitDPC", 2, localStringBuilder.toString());
    }
    if (str.charAt(0) != '1')
    {
      QLog.e("TBS_update", 1, "tbs update disabled from InitDPC.doStep()!");
      QbSdk.reset(BaseApplicationImpl.getContext());
    }
    if ((BaseApplicationImpl.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("isTbsEnabled", true)) && (str.charAt(2) == '1'))
    {
      if ((Build.VERSION.SDK_INT < 17) && (QbSdk.getTbsVersion(BaseApplicationImpl.getContext()) > 0))
      {
        WebpSoLoader.a(false);
        return true;
      }
    }
    else
    {
      QLog.e("TBS_update", 1, "tbs force system webview");
      QbSdk.forceSysWebView();
      WebpSoLoader.a(true);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitDPC
 * JD-Core Version:    0.7.0.1
 */