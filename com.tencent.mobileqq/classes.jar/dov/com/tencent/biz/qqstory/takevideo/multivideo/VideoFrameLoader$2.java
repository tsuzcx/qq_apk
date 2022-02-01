package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.graphics.Bitmap;
import bpei;
import bpej;
import bppu;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import zdr;

public class VideoFrameLoader$2
  implements Runnable
{
  public VideoFrameLoader$2(bpei parambpei, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != bpei.a(this.this$0).size()) && (QLog.isColorLevel())) {
      QLog.d("VideoFrameLoader", 2, "onloadframe index error!");
    }
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    Object localObject;
    if (bpei.a(this.this$0))
    {
      localObject = localBitmap;
      if (bpei.b(this.this$0)) {
        localObject = zdr.a(localBitmap, -bpei.a(this.this$0));
      }
      if (bpei.a(this.this$0) == null)
      {
        bpei.a(this.this$0, new bppu());
        bpei.a(this.this$0).a(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      localBitmap = bpei.a(this.this$0, bpei.a(this.this$0), (Bitmap)localObject, bpei.b(this.this$0));
    }
    for (;;)
    {
      bpei.a(this.this$0).add(localBitmap);
      localObject = null;
      if (bpei.a(this.this$0) != null) {
        localObject = (bpej)bpei.a(this.this$0).get();
      }
      if (localObject != null) {
        ((bpej)localObject).a(this.jdField_a_of_type_Int, localBitmap);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.2
 * JD-Core Version:    0.7.0.1
 */