package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.graphics.Bitmap;
import bitg;
import bith;
import bjgz;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import vlc;

public class VideoFrameLoader$2
  implements Runnable
{
  public VideoFrameLoader$2(bitg parambitg, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != bitg.a(this.this$0).size()) && (QLog.isColorLevel())) {
      QLog.d("VideoFrameLoader", 2, "onloadframe index error!");
    }
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    Object localObject;
    if (bitg.a(this.this$0))
    {
      localObject = localBitmap;
      if (bitg.b(this.this$0)) {
        localObject = vlc.a(localBitmap, -bitg.a(this.this$0));
      }
      if (bitg.a(this.this$0) == null)
      {
        bitg.a(this.this$0, new bjgz());
        bitg.a(this.this$0).a(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      localBitmap = bitg.a(this.this$0, bitg.a(this.this$0), (Bitmap)localObject, bitg.b(this.this$0));
    }
    for (;;)
    {
      bitg.a(this.this$0).add(localBitmap);
      localObject = null;
      if (bitg.a(this.this$0) != null) {
        localObject = (bith)bitg.a(this.this$0).get();
      }
      if (localObject != null) {
        ((bith)localObject).a(this.jdField_a_of_type_Int, localBitmap);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.2
 * JD-Core Version:    0.7.0.1
 */