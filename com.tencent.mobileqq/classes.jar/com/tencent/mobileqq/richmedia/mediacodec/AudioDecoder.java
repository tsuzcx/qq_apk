package com.tencent.mobileqq.richmedia.mediacodec;

import android.annotation.TargetApi;
import auxn;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import urk;

@TargetApi(16)
public class AudioDecoder
{
  private auxn jdField_a_of_type_Auxn;
  private AudioDecoder.AudioPlayRunnable jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable.a();
      QLog.d("AudioDecoder", 4, "repeat");
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Auxn != null)
    {
      this.jdField_a_of_type_Auxn.jdField_a_of_type_Int = paramInt;
      QLog.d("AudioDecoder", 4, "setSpeedType:" + paramInt);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable.a(paramLong, this.jdField_a_of_type_Auxn.c);
      QLog.d("AudioDecoder", 1, "seekTo: " + paramLong);
      return;
    }
    QLog.d("AudioDecoder", 4, "seekTo failed: " + paramLong);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Auxn == null)
    {
      QLog.w("AudioDecoder", 4, "you must start play first");
      return;
    }
    if ((paramLong1 == this.jdField_a_of_type_Auxn.jdField_a_of_type_Long) && (paramLong2 == this.jdField_a_of_type_Auxn.jdField_b_of_type_Long))
    {
      urk.d("AudioDecoder", "segment not changed, setPlayRange ignore, startTimeMs=%d, endTimeMs=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      return;
    }
    QLog.d("AudioDecoder", 4, "setPlayRange begin startTimeMs=" + paramLong1 + " endTimeMs=" + paramLong2);
    this.jdField_a_of_type_Auxn.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Auxn.jdField_b_of_type_Long = paramLong2;
    a(this.jdField_a_of_type_Auxn);
  }
  
  public void a(auxn paramauxn)
  {
    QLog.d("AudioDecoder", 4, "startPlay " + paramauxn.toString());
    b();
    if (this.jdField_a_of_type_Auxn == null) {
      this.jdField_a_of_type_Auxn = new auxn();
    }
    this.jdField_a_of_type_Auxn.a(paramauxn);
    if (this.jdField_a_of_type_Auxn.jdField_b_of_type_Long == 0L) {
      this.jdField_a_of_type_Auxn.jdField_b_of_type_Long = this.jdField_a_of_type_Auxn.c;
    }
    float f2 = (float)this.jdField_a_of_type_Auxn.jdField_a_of_type_Long / (float)this.jdField_a_of_type_Auxn.c;
    float f3 = (float)this.jdField_a_of_type_Auxn.jdField_b_of_type_Long / (float)this.jdField_a_of_type_Auxn.c;
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
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable = new AudioDecoder.AudioPlayRunnable(this, f1, f2);
    this.jdField_a_of_type_JavaLangThread = ThreadManager.newFreeThread(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable, "AudioPlay", 8);
    if (!this.jdField_a_of_type_JavaLangThread.isAlive()) {
      this.jdField_a_of_type_JavaLangThread.start();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Auxn == null) {
      return;
    }
    QLog.d("AudioDecoder", 1, "setMuteAudio: " + paramBoolean);
    this.jdField_a_of_type_Auxn.jdField_b_of_type_Boolean = paramBoolean;
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
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable.b();
      QLog.d("AudioDecoder", 4, "pausePlay");
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable.c();
      QLog.d("AudioDecoder", 4, "resumePlay");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder
 * JD-Core Version:    0.7.0.1
 */