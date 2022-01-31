package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.graphics.Bitmap;
import android.os.Handler;
import ariv;
import aroo;
import bdcs;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class VideoFilePresenter$11$1
  implements Runnable
{
  public VideoFilePresenter$11$1(ariv paramariv, Bitmap paramBitmap) {}
  
  public void run()
  {
    String str = aroo.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    if (bdcs.b(str)) {
      ThreadManagerV2.getUIHandlerV2().post(new VideoFilePresenter.11.1.1(this, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.11.1
 * JD-Core Version:    0.7.0.1
 */