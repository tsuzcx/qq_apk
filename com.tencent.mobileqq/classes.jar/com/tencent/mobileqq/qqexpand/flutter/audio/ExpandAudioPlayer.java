package com.tencent.mobileqq.qqexpand.flutter.audio;

import android.os.Handler;
import android.os.Looper;
import com.qflutter.audio.BasePlayer;
import com.qflutter.audio.IPlayerStatusListener;
import com.tencent.mobileqq.qqexpand.audio.IExpandAudioPlayer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodChannel.Result;

public class ExpandAudioPlayer
  implements BasePlayer
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private IExpandAudioPlayer jdField_a_of_type_ComTencentMobileqqQqexpandAudioIExpandAudioPlayer;
  
  public ExpandAudioPlayer()
  {
    QLog.w("ExpandAudioPlayer", 1, "flutter version");
    this.jdField_a_of_type_ComTencentMobileqqQqexpandAudioIExpandAudioPlayer = ((IExpandAudioPlayer)QRoute.api(IExpandAudioPlayer.class));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(MethodChannel.Result paramResult, Object paramObject)
  {
    if (paramResult == null)
    {
      QLog.w("ExpandAudioPlayer", 1, "doMethodCallback result is null");
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramResult.success(paramObject);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ExpandAudioPlayer.7(this, paramResult, paramObject));
  }
  
  public void audioPreDownLoad(String paramString, MethodChannel.Result paramResult)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandAudioIExpandAudioPlayer.audioPreDownLoad(paramString, new ExpandAudioPlayer.1(this, paramResult));
  }
  
  public void continueAudioPlay(MethodChannel.Result paramResult)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandAudioIExpandAudioPlayer.continueAudioPlay(new ExpandAudioPlayer.4(this, paramResult));
  }
  
  public void pauseAudioPlay(MethodChannel.Result paramResult)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandAudioIExpandAudioPlayer.pauseAudioPlay(new ExpandAudioPlayer.5(this, paramResult));
  }
  
  public void removeAudioPlayerListener()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandAudioIExpandAudioPlayer.removeAudioPlayerListener();
  }
  
  public void setAudioPlayerListener(IPlayerStatusListener paramIPlayerStatusListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandAudioIExpandAudioPlayer.setAudioPlayerListener(new ExpandAudioPlayer.6(this, paramIPlayerStatusListener));
  }
  
  public void startAudioPlay(String paramString, MethodChannel.Result paramResult)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandAudioIExpandAudioPlayer.startAudioPlay(paramString, new ExpandAudioPlayer.2(this, paramResult));
  }
  
  public void stopAudioPlay(MethodChannel.Result paramResult)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandAudioIExpandAudioPlayer.stopAudioPlay(new ExpandAudioPlayer.3(this, paramResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.audio.ExpandAudioPlayer
 * JD-Core Version:    0.7.0.1
 */