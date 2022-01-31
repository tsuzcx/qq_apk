package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.graphics.Bitmap;
import bkju;
import bkjv;
import bkxk;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import vxy;

public class VideoFrameLoader$2
  implements Runnable
{
  public VideoFrameLoader$2(bkju parambkju, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != bkju.a(this.this$0).size()) && (QLog.isColorLevel())) {
      QLog.d("VideoFrameLoader", 2, "onloadframe index error!");
    }
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    Object localObject;
    if (bkju.a(this.this$0))
    {
      localObject = localBitmap;
      if (bkju.b(this.this$0)) {
        localObject = vxy.a(localBitmap, -bkju.a(this.this$0));
      }
      if (bkju.a(this.this$0) == null)
      {
        bkju.a(this.this$0, new bkxk());
        bkju.a(this.this$0).a(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      localBitmap = bkju.a(this.this$0, bkju.a(this.this$0), (Bitmap)localObject, bkju.b(this.this$0));
    }
    for (;;)
    {
      bkju.a(this.this$0).add(localBitmap);
      localObject = null;
      if (bkju.a(this.this$0) != null) {
        localObject = (bkjv)bkju.a(this.this$0).get();
      }
      if (localObject != null) {
        ((bkjv)localObject).a(this.jdField_a_of_type_Int, localBitmap);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.2
 * JD-Core Version:    0.7.0.1
 */