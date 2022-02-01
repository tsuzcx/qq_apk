package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.graphics.Bitmap;
import bqti;
import bqtj;
import brgc;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import zoc;

public class VideoFrameLoader$2
  implements Runnable
{
  public VideoFrameLoader$2(bqti parambqti, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != bqti.a(this.this$0).size()) && (QLog.isColorLevel())) {
      QLog.d("VideoFrameLoader", 2, "onloadframe index error!");
    }
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    Object localObject;
    if (bqti.a(this.this$0))
    {
      localObject = localBitmap;
      if (bqti.b(this.this$0)) {
        localObject = zoc.a(localBitmap, -bqti.a(this.this$0));
      }
      if (bqti.a(this.this$0) == null)
      {
        bqti.a(this.this$0, new brgc());
        bqti.a(this.this$0).a(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      localBitmap = bqti.a(this.this$0, bqti.a(this.this$0), (Bitmap)localObject, bqti.b(this.this$0));
    }
    for (;;)
    {
      bqti.a(this.this$0).add(localBitmap);
      localObject = null;
      if (bqti.a(this.this$0) != null) {
        localObject = (bqtj)bqti.a(this.this$0).get();
      }
      if (localObject != null) {
        ((bqtj)localObject).a(this.jdField_a_of_type_Int, localBitmap);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.2
 * JD-Core Version:    0.7.0.1
 */