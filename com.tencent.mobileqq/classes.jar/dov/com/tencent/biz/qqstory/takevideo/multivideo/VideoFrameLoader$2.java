package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.graphics.Bitmap;
import bmvv;
import bmvw;
import bnjl;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import xmn;

public class VideoFrameLoader$2
  implements Runnable
{
  public VideoFrameLoader$2(bmvv parambmvv, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != bmvv.a(this.this$0).size()) && (QLog.isColorLevel())) {
      QLog.d("VideoFrameLoader", 2, "onloadframe index error!");
    }
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    Object localObject;
    if (bmvv.a(this.this$0))
    {
      localObject = localBitmap;
      if (bmvv.b(this.this$0)) {
        localObject = xmn.a(localBitmap, -bmvv.a(this.this$0));
      }
      if (bmvv.a(this.this$0) == null)
      {
        bmvv.a(this.this$0, new bnjl());
        bmvv.a(this.this$0).a(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      localBitmap = bmvv.a(this.this$0, bmvv.a(this.this$0), (Bitmap)localObject, bmvv.b(this.this$0));
    }
    for (;;)
    {
      bmvv.a(this.this$0).add(localBitmap);
      localObject = null;
      if (bmvv.a(this.this$0) != null) {
        localObject = (bmvw)bmvv.a(this.this$0).get();
      }
      if (localObject != null) {
        ((bmvw)localObject).a(this.jdField_a_of_type_Int, localBitmap);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.2
 * JD-Core Version:    0.7.0.1
 */