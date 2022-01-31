package com.tencent.mobileqq.surfaceviewaction.builder;

import android.os.Handler;
import android.os.Looper;
import axbc;
import axbo;
import axbx;

public class SceneBuilder$1
  implements Runnable
{
  public SceneBuilder$1(axbo paramaxbo, axbc paramaxbc, axbx paramaxbx) {}
  
  public void run()
  {
    String str = axbo.a(axbo.a(this.this$0) + "/scene.json");
    new Handler(Looper.getMainLooper()).post(new SceneBuilder.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.1
 * JD-Core Version:    0.7.0.1
 */