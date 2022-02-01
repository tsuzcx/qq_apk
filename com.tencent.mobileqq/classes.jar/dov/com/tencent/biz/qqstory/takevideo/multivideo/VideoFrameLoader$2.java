package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.graphics.Bitmap;
import bnoq;
import bnor;
import boac;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import yoy;

public class VideoFrameLoader$2
  implements Runnable
{
  public VideoFrameLoader$2(bnoq parambnoq, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != bnoq.a(this.this$0).size()) && (QLog.isColorLevel())) {
      QLog.d("VideoFrameLoader", 2, "onloadframe index error!");
    }
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    Object localObject;
    if (bnoq.a(this.this$0))
    {
      localObject = localBitmap;
      if (bnoq.b(this.this$0)) {
        localObject = yoy.a(localBitmap, -bnoq.a(this.this$0));
      }
      if (bnoq.a(this.this$0) == null)
      {
        bnoq.a(this.this$0, new boac());
        bnoq.a(this.this$0).a(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      localBitmap = bnoq.a(this.this$0, bnoq.a(this.this$0), (Bitmap)localObject, bnoq.b(this.this$0));
    }
    for (;;)
    {
      bnoq.a(this.this$0).add(localBitmap);
      localObject = null;
      if (bnoq.a(this.this$0) != null) {
        localObject = (bnor)bnoq.a(this.this$0).get();
      }
      if (localObject != null) {
        ((bnor)localObject).a(this.jdField_a_of_type_Int, localBitmap);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.2
 * JD-Core Version:    0.7.0.1
 */