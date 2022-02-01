package com.tencent.mobileqq.kandian.biz.ugc.voice;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.repo.handler.UGCVoiceInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class ReadInJoyVoicePlayController
{
  private static ReadInJoyVoicePlayController jdField_a_of_type_ComTencentMobileqqKandianBizUgcVoiceReadInJoyVoicePlayController;
  public static final String a = "ReadInJoyVoicePlayController";
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager = (AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio");
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private UGCVoiceInfo jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerUGCVoiceInfo;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyVoicePlayController.3(this);
  private WeakReference<ReadInJoyVoicePlayController.IPlayCallback> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  
  public static ReadInJoyVoicePlayController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianBizUgcVoiceReadInJoyVoicePlayController == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqKandianBizUgcVoiceReadInJoyVoicePlayController == null) {
          jdField_a_of_type_ComTencentMobileqqKandianBizUgcVoiceReadInJoyVoicePlayController = new ReadInJoyVoicePlayController();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqKandianBizUgcVoiceReadInJoyVoicePlayController;
  }
  
  public void a()
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null)
    {
      try
      {
        localMediaPlayer.stop();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerUGCVoiceInfo;
      if (localObject != null)
      {
        ((UGCVoiceInfo)localObject).isPlaying = false;
        localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
        if (localObject != null)
        {
          localObject = (ReadInJoyVoicePlayController.IPlayCallback)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((ReadInJoyVoicePlayController.IPlayCallback)localObject).b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerUGCVoiceInfo);
            a(false, "ugc voice play");
          }
        }
      }
    }
  }
  
  public void a(ReadInJoyVoicePlayController.IPlayCallback paramIPlayCallback, UGCVoiceInfo paramUGCVoiceInfo)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    }
    a();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIPlayCallback);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerUGCVoiceInfo = paramUGCVoiceInfo;
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new ReadInJoyVoicePlayController.1(this));
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new ReadInJoyVoicePlayController.2(this));
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramUGCVoiceInfo.voiceUrl);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      return;
    }
    catch (IOException paramIPlayCallback)
    {
      paramIPlayCallback.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    try
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_JavaLangRunnable != null))
      {
        if (QLog.isColorLevel())
        {
          String str = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("requestOrAbandonAudioFocus isFocus:");
          localStringBuilder.append(paramBoolean);
          localStringBuilder.append(" ;what:");
          localStringBuilder.append(paramString);
          QLog.d(str, 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
        } else {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.voice.ReadInJoyVoicePlayController
 * JD-Core Version:    0.7.0.1
 */