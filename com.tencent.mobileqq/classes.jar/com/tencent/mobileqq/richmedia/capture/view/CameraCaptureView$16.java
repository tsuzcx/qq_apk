package com.tencent.mobileqq.richmedia.capture.view;

import android.graphics.Bitmap;
import baou;
import baox;
import bgmg;
import bgmo;
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
    bgmg.c(str);
    File localFile = new File(str);
    try
    {
      bgmo.a(this.a, localFile);
      bgmo.a(BaseApplicationImpl.getContext(), localFile.getAbsolutePath());
      this.this$0.a(new baox(0, 0, str, null, this.this$0.u));
      this.a.recycle();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        this.this$0.a(new baox(0, -1, str, null, this.this$0.u));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.16
 * JD-Core Version:    0.7.0.1
 */