package com.tencent.qqmini.proxyimpl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import java.io.File;

class VideoJsProxyImpl$7
  implements IActivityResultListener
{
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidAppActivity).getString("miniapp_video_path", "");
        VideoJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplVideoJsProxyImpl, new File(paramIntent), this.jdField_a_of_type_Boolean);
      }
      else
      {
        paramIntent = this.jdField_a_of_type_ComTencentQqminiProxyimplVideoJsProxyImpl;
        VideoJsProxyImpl.a(paramIntent, VideoJsProxyImpl.a(paramIntent), "chooseVideo", null);
      }
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.7
 * JD-Core Version:    0.7.0.1
 */