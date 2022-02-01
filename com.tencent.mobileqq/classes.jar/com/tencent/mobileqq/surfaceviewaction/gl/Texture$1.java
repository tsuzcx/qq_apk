package com.tencent.mobileqq.surfaceviewaction.gl;

import com.tencent.qphone.base.util.QLog;

class Texture$1
  implements Runnable
{
  Texture$1(Texture paramTexture) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Texture", 2, "runOnSurfaceViewThread load()");
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.Texture.1
 * JD-Core Version:    0.7.0.1
 */