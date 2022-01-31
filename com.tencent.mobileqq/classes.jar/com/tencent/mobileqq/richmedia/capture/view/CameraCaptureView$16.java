package com.tencent.mobileqq.richmedia.capture.view;

import android.graphics.Bitmap;
import axmk;
import axmn;
import bdcs;
import bdda;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.io.IOException;

class CameraCaptureView$16
  implements Runnable
{
  CameraCaptureView$16(CameraCaptureView paramCameraCaptureView, Bitmap paramBitmap) {}
  
  public void run()
  {
    String str = this.this$0.a.b + "/" + System.currentTimeMillis() + ".jpg";
    bdcs.c(str);
    File localFile = new File(str);
    try
    {
      bdda.a(this.a, localFile);
      bdda.a(BaseApplicationImpl.getContext(), localFile.getAbsolutePath());
      this.this$0.a(new axmn(0, 0, str, null, this.this$0.u));
      this.a.recycle();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        this.this$0.a(new axmn(0, -1, str, null, this.this$0.u));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.16
 * JD-Core Version:    0.7.0.1
 */