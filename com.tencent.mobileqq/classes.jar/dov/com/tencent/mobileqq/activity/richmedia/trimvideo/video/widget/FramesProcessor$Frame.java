package dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

public class FramesProcessor$Frame
{
  public int a;
  public Bitmap a;
  
  protected void finalize()
  {
    super.finalize();
    if ((this.a != null) && (!this.a.isRecycled()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Frames", 2, "recycle bitmap");
      }
      this.a.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FramesProcessor.Frame
 * JD-Core Version:    0.7.0.1
 */