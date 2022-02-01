package com.tencent.mobileqq.vas.config.business.qvip;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.annotation.Keep;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

@Keep
public class QVipFeatureConfig
{
  public boolean enableDownloadExtraTabIcon = true;
  public boolean enableShootAnim = true;
  public boolean enableSplashAnim = true;
  
  private void setSplashEnable(boolean paramBoolean)
  {
    MobileQQ.getContext().getSharedPreferences("banner_and_splash", 4).edit().putBoolean("splashAnim", paramBoolean).commit();
  }
  
  public void onParsedConfigFinished()
  {
    setSplashEnable(this.enableSplashAnim);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipFeatureConfig
 * JD-Core Version:    0.7.0.1
 */