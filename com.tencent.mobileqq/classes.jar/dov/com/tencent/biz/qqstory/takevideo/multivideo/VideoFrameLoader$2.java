package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.graphics.Bitmap;
import bnah;
import bnai;
import bnnx;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import xqw;

public class VideoFrameLoader$2
  implements Runnable
{
  public VideoFrameLoader$2(bnah parambnah, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != bnah.a(this.this$0).size()) && (QLog.isColorLevel())) {
      QLog.d("VideoFrameLoader", 2, "onloadframe index error!");
    }
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    Object localObject;
    if (bnah.a(this.this$0))
    {
      localObject = localBitmap;
      if (bnah.b(this.this$0)) {
        localObject = xqw.a(localBitmap, -bnah.a(this.this$0));
      }
      if (bnah.a(this.this$0) == null)
      {
        bnah.a(this.this$0, new bnnx());
        bnah.a(this.this$0).a(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      localBitmap = bnah.a(this.this$0, bnah.a(this.this$0), (Bitmap)localObject, bnah.b(this.this$0));
    }
    for (;;)
    {
      bnah.a(this.this$0).add(localBitmap);
      localObject = null;
      if (bnah.a(this.this$0) != null) {
        localObject = (bnai)bnah.a(this.this$0).get();
      }
      if (localObject != null) {
        ((bnai)localObject).a(this.jdField_a_of_type_Int, localBitmap);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.2
 * JD-Core Version:    0.7.0.1
 */