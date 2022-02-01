package com.tencent.mobileqq.kandian.base.video.plugin;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.IPlayerSDKMgr;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.mobileqq.kandian.base.video.plugin.api.IVideoPluginInstall;

public class VideoPluginInstall
  implements IVideoPluginInstall
{
  private static boolean b;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new VideoPluginInstall.3(this));
  private IPlayerSDKMgr jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerSDKMgr = PlayerHelper.a.a();
  private OnVideoPluginInstallListener jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginOnVideoPluginInstallListener;
  private boolean jdField_a_of_type_Boolean;
  
  public VideoPluginInstall()
  {
    ThreadManager.executeOnSubThread(new VideoPluginInstall.1(this));
  }
  
  private void c()
  {
    try
    {
      if (!b)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerSDKMgr.a();
        b = true;
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    if ((!a()) && (!this.jdField_a_of_type_Boolean)) {
      ThreadManager.post(new VideoPluginInstall.2(this), 8, null, true);
    }
  }
  
  public void a(OnVideoPluginInstallListener paramOnVideoPluginInstallListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginOnVideoPluginInstallListener = paramOnVideoPluginInstallListener;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerSDKMgr.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginOnVideoPluginInstallListener = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall
 * JD-Core Version:    0.7.0.1
 */