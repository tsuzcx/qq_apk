package dov.com.tencent.mobileqq.activity.richmedia.state;

import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

class RMVideoStateMgr$3
  implements Runnable
{
  RMVideoStateMgr$3(RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    synchronized (RMVideoStateMgr.a(this.this$0))
    {
      if (this.this$0.d())
      {
        this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.b(this.this$0.jdField_a_of_type_Blbi);
        this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.f();
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoStateMgr", 2, "[@][closeAudioRecord]");
        }
      }
      this.this$0.c = false;
      this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
      this.this$0.d = false;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr.3
 * JD-Core Version:    0.7.0.1
 */