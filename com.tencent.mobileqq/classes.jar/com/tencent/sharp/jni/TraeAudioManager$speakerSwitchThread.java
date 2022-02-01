package com.tencent.sharp.jni;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import lez;

class TraeAudioManager$speakerSwitchThread
  extends TraeAudioManager.SwitchThread
{
  TraeAudioManager$speakerSwitchThread(TraeAudioManager paramTraeAudioManager, long paramLong)
  {
    super(paramTraeAudioManager, paramLong);
  }
  
  public String a()
  {
    return "DEVICE_SPEAKERPHONE";
  }
  
  public void a()
  {
    int i = 0;
    this.this$0.a(this.jdField_a_of_type_Long, TraeAudioManager.a(this.this$0), true);
    c();
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (TraeAudioManager.a(this.this$0) == true) {
          break label126;
        }
        if ((this.b) && (i > 4))
        {
          lez locallez = VideoController.a().a();
          if (!locallez.P) {
            QLog.w(this.jdField_a_of_type_JavaLangString, 1, "_run, 不需要打开扬声器, sessionInfo[" + locallez + "]");
          }
        }
      }
      else
      {
        return;
      }
      this.this$0.a(this.jdField_a_of_type_Long, TraeAudioManager.a(this.this$0), true);
      label126:
      long l;
      if (i < 5) {
        l = 1000L;
      }
      try
      {
        for (;;)
        {
          Thread.sleep(l);
          label139:
          i += 1;
          break;
          l = 4000L;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label139;
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.speakerSwitchThread
 * JD-Core Version:    0.7.0.1
 */