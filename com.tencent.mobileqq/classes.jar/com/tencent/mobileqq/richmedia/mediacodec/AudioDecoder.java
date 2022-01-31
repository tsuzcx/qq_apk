package com.tencent.mobileqq.richmedia.mediacodec;

import ahss;
import android.annotation.TargetApi;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

@TargetApi(16)
public class AudioDecoder
{
  private ahss jdField_a_of_type_Ahss;
  private AudioDecoder.AudioDecodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig;
  private Thread jdField_a_of_type_JavaLangThread;
  
  public void a()
  {
    if (this.jdField_a_of_type_Ahss != null)
    {
      this.jdField_a_of_type_Ahss.a();
      QLog.d("AudioDecoder", 4, "repeat");
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_a_of_type_Int = paramInt;
      QLog.d("AudioDecoder", 4, "setSpeedType:" + paramInt);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Ahss != null)
    {
      this.jdField_a_of_type_Ahss.a(paramLong, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.c);
      QLog.d("AudioDecoder", 1, "seekTo: " + paramLong);
      return;
    }
    QLog.d("AudioDecoder", 4, "seekTo failed: " + paramLong);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig == null)
    {
      QLog.w("AudioDecoder", 4, "you must start play first");
      return;
    }
    if ((paramLong1 == this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_a_of_type_Long) && (paramLong2 == this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_b_of_type_Long))
    {
      SLog.d("AudioDecoder", "segment not changed, setPlayRange ignore, startTimeMs=%d, endTimeMs=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      return;
    }
    QLog.d("AudioDecoder", 4, "setPlayRange begin startTimeMs=" + paramLong1 + " endTimeMs=" + paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_b_of_type_Long = paramLong2;
    a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig);
  }
  
  public void a(AudioDecoder.AudioDecodeConfig paramAudioDecodeConfig)
  {
    QLog.d("AudioDecoder", 4, "startPlay " + paramAudioDecodeConfig.toString());
    b();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig = new AudioDecoder.AudioDecodeConfig();
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.a(paramAudioDecodeConfig);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_b_of_type_Long == 0L) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.c;
    }
    float f2 = (float)this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_a_of_type_Long / (float)this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.c;
    float f3 = (float)this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_b_of_type_Long / (float)this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.c;
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = 0.0F;
    }
    if (f3 != 0.0F)
    {
      f2 = f3;
      if (f3 <= 1.0F) {}
    }
    else
    {
      f2 = 1.0F;
    }
    this.jdField_a_of_type_Ahss = new ahss(this, f1, f2);
    this.jdField_a_of_type_JavaLangThread = ThreadManager.newFreeThread(this.jdField_a_of_type_Ahss, "AudioPlay", 8);
    this.jdField_a_of_type_JavaLangThread.start();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig == null) {
      return;
    }
    QLog.d("AudioDecoder", 1, "setMuteAudio: " + paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      this.jdField_a_of_type_JavaLangThread.interrupt();
      this.jdField_a_of_type_JavaLangThread = null;
      QLog.d("AudioDecoder", 4, "stopAudio");
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ahss != null)
    {
      this.jdField_a_of_type_Ahss.b();
      QLog.d("AudioDecoder", 4, "pausePlay");
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ahss != null)
    {
      this.jdField_a_of_type_Ahss.c();
      QLog.d("AudioDecoder", 4, "resumePlay");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder
 * JD-Core Version:    0.7.0.1
 */