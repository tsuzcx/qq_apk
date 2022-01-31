package com.tencent.qqmini.sdk.minigame;

import android.graphics.Bitmap;
import bgib;
import bgkx;
import bgtj;
import bgtn;

public class GameRuntime$7$1
  implements Runnable
{
  public GameRuntime$7$1(bgtn parambgtn, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Bgtn.jdField_a_of_type_Bgib != null) {
      this.jdField_a_of_type_Bgtn.jdField_a_of_type_Bgib.onGetScreenshot(bgkx.a(bgtj.a(this.jdField_a_of_type_Bgtn.jdField_a_of_type_Bgtj), this.jdField_a_of_type_AndroidGraphicsBitmap));
    }
    bgtj.a(this.jdField_a_of_type_Bgtn.jdField_a_of_type_Bgtj).isGettingScreenShot = false;
    this.jdField_a_of_type_Bgtn.jdField_a_of_type_Bgtj.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntime.7.1
 * JD-Core Version:    0.7.0.1
 */