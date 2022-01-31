package com.tencent.qqmini.sdk.minigame;

import android.graphics.Bitmap;
import bgmi;
import bgpe;
import bgxq;
import bgxu;

public class GameRuntime$7$1
  implements Runnable
{
  public GameRuntime$7$1(bgxu parambgxu, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Bgxu.jdField_a_of_type_Bgmi != null) {
      this.jdField_a_of_type_Bgxu.jdField_a_of_type_Bgmi.onGetScreenshot(bgpe.a(bgxq.a(this.jdField_a_of_type_Bgxu.jdField_a_of_type_Bgxq), this.jdField_a_of_type_AndroidGraphicsBitmap));
    }
    bgxq.a(this.jdField_a_of_type_Bgxu.jdField_a_of_type_Bgxq).isGettingScreenShot = false;
    this.jdField_a_of_type_Bgxu.jdField_a_of_type_Bgxq.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntime.7.1
 * JD-Core Version:    0.7.0.1
 */