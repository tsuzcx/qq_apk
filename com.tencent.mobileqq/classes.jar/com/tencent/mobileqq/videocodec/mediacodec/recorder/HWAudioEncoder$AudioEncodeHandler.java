package com.tencent.mobileqq.videocodec.mediacodec.recorder;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class HWAudioEncoder$AudioEncodeHandler
  extends Handler
{
  protected WeakReference<HWAudioEncoder> a;
  
  public HWAudioEncoder$AudioEncodeHandler(HWAudioEncoder paramHWAudioEncoder1, Looper paramLooper, HWAudioEncoder paramHWAudioEncoder2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHWAudioEncoder2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    HWAudioEncoder localHWAudioEncoder = (HWAudioEncoder)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localHWAudioEncoder == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("HWAudioEncoder", 2, "AudioEncodeHandler.handleMessage: encoder is null");
      }
      return;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4)
          {
            this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder.b();
            return;
          }
          paramMessage = new StringBuilder();
          paramMessage.append("Unhandled msg what=");
          paramMessage.append(i);
          throw new RuntimeException(paramMessage.toString());
        }
        paramMessage = (String)paramMessage.obj;
        try
        {
          HWAudioEncoder.a(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder, paramMessage);
          return;
        }
        catch (Exception paramMessage)
        {
          QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler start fail.", paramMessage);
          HWAudioEncoder.a(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder);
          return;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder.a();
      return;
    }
    paramMessage = (Object[])paramMessage.obj;
    try
    {
      localHWAudioEncoder.a((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue(), false);
      return;
    }
    catch (Exception paramMessage)
    {
      QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler encode audio fail.", paramMessage);
      HWAudioEncoder.a(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.recorder.HWAudioEncoder.AudioEncodeHandler
 * JD-Core Version:    0.7.0.1
 */