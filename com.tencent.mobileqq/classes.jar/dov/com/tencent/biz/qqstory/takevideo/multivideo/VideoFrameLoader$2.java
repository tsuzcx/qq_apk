package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.graphics.Bitmap;
import bkkl;
import bkkm;
import bkyb;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import vxv;

public class VideoFrameLoader$2
  implements Runnable
{
  public VideoFrameLoader$2(bkkl parambkkl, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != bkkl.a(this.this$0).size()) && (QLog.isColorLevel())) {
      QLog.d("VideoFrameLoader", 2, "onloadframe index error!");
    }
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    Object localObject;
    if (bkkl.a(this.this$0))
    {
      localObject = localBitmap;
      if (bkkl.b(this.this$0)) {
        localObject = vxv.a(localBitmap, -bkkl.a(this.this$0));
      }
      if (bkkl.a(this.this$0) == null)
      {
        bkkl.a(this.this$0, new bkyb());
        bkkl.a(this.this$0).a(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      localBitmap = bkkl.a(this.this$0, bkkl.a(this.this$0), (Bitmap)localObject, bkkl.b(this.this$0));
    }
    for (;;)
    {
      bkkl.a(this.this$0).add(localBitmap);
      localObject = null;
      if (bkkl.a(this.this$0) != null) {
        localObject = (bkkm)bkkl.a(this.this$0).get();
      }
      if (localObject != null) {
        ((bkkm)localObject).a(this.jdField_a_of_type_Int, localBitmap);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.2
 * JD-Core Version:    0.7.0.1
 */