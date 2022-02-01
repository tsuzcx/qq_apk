package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.graphics.Bitmap;
import bprn;
import bpro;
import bqer;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import zkh;

public class VideoFrameLoader$2
  implements Runnable
{
  public VideoFrameLoader$2(bprn parambprn, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != bprn.a(this.this$0).size()) && (QLog.isColorLevel())) {
      QLog.d("VideoFrameLoader", 2, "onloadframe index error!");
    }
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    Object localObject;
    if (bprn.a(this.this$0))
    {
      localObject = localBitmap;
      if (bprn.b(this.this$0)) {
        localObject = zkh.a(localBitmap, -bprn.a(this.this$0));
      }
      if (bprn.a(this.this$0) == null)
      {
        bprn.a(this.this$0, new bqer());
        bprn.a(this.this$0).a(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      localBitmap = bprn.a(this.this$0, bprn.a(this.this$0), (Bitmap)localObject, bprn.b(this.this$0));
    }
    for (;;)
    {
      bprn.a(this.this$0).add(localBitmap);
      localObject = null;
      if (bprn.a(this.this$0) != null) {
        localObject = (bpro)bprn.a(this.this$0).get();
      }
      if (localObject != null) {
        ((bpro)localObject).a(this.jdField_a_of_type_Int, localBitmap);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.2
 * JD-Core Version:    0.7.0.1
 */