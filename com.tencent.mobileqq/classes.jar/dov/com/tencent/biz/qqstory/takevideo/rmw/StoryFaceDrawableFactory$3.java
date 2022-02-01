package dov.com.tencent.biz.qqstory.takevideo.rmw;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import bqux;
import yuk;
import zrx;

public class StoryFaceDrawableFactory$3
  implements Runnable
{
  public StoryFaceDrawableFactory$3(bqux parambqux, String paramString1, String paramString2) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.a(this.a);
    if (localBitmap != null)
    {
      zrx localzrx = (zrx)this.this$0.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.b);
      if (localzrx != null)
      {
        localzrx.a(localBitmap);
        this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(1002).sendToTarget();
        return;
      }
      yuk.d("Q.qqstory.record.StoryFaceDrawableFactory", "Find faceDrawable is not in cache after decoding bitmap!");
      localzrx = new zrx(this.this$0.jdField_a_of_type_Int, this.this$0.b);
      localzrx.a(localBitmap);
      this.this$0.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(this.b, localzrx);
      return;
    }
    yuk.e("Q.qqstory.record.StoryFaceDrawableFactory", "getFaceBitmapByPath return null!.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.rmw.StoryFaceDrawableFactory.3
 * JD-Core Version:    0.7.0.1
 */