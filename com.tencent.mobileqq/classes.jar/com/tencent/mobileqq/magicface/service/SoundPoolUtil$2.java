package com.tencent.mobileqq.magicface.service;

import android.media.SoundPool;
import asdq;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class SoundPoolUtil$2
  extends TimerTask
{
  public SoundPoolUtil$2(asdq paramasdq, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.play(this.jdField_a_of_type_Int, 1.0F, 1.0F, 0, 0, 1.0F) == 0) && (QLog.isColorLevel())) {
      QLog.d("SoundPoolUtil", 2, "play failure filepath=" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.service.SoundPoolUtil.2
 * JD-Core Version:    0.7.0.1
 */