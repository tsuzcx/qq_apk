package com.tencent.mobileqq.qqexpand.audio.impl;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qqexpand.audio.IAudioPlayerStatusListener;
import com.tencent.qphone.base.util.QLog;

public class PlayerStatusManager
  implements IAudioPlayerStatusListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private IAudioPlayerStatusListener jdField_a_of_type_ComTencentMobileqqQqexpandAudioIAudioPlayerStatusListener;
  
  private boolean a()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandAudioIAudioPlayerStatusListener = null;
  }
  
  public void a(IAudioPlayerStatusListener paramIAudioPlayerStatusListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandAudioIAudioPlayerStatusListener = paramIAudioPlayerStatusListener;
  }
  
  public void onAudioFinishPlay(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandAudioIAudioPlayerStatusListener == null)
    {
      QLog.e("PlayerStatusManager", 2, "onAudioFinishPlay mListener is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PlayerStatusManager", 2, "onAudioFinishPlay");
    }
    if (a())
    {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandAudioIAudioPlayerStatusListener.onAudioFinishPlay(paramString);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new PlayerStatusManager.2(this, paramString));
  }
  
  public void onAudioPlayFailed(String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandAudioIAudioPlayerStatusListener == null)
    {
      QLog.e("PlayerStatusManager", 2, "onAudioFinishPlay mListener is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PlayerStatusManager", 2, "onAudioFinishPlay");
    }
    if (a())
    {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandAudioIAudioPlayerStatusListener.onAudioFinishPlay(paramString1);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new PlayerStatusManager.3(this, paramString1));
  }
  
  public void onAudioStartPlay(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandAudioIAudioPlayerStatusListener == null)
    {
      QLog.e("PlayerStatusManager", 2, "onAudioStartPlay mListener is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PlayerStatusManager", 2, "onAudioStartPlay");
    }
    if (a())
    {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandAudioIAudioPlayerStatusListener.onAudioStartPlay(paramString);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new PlayerStatusManager.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.audio.impl.PlayerStatusManager
 * JD-Core Version:    0.7.0.1
 */