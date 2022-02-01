package dov.com.tencent.mobileqq.shortvideo.ptvfilter.material;

import android.graphics.Bitmap;

class GLImage2DTexture$1
  implements Runnable
{
  public void run()
  {
    Bitmap localBitmap = GLImage2DTexture.a(this.this$0, this.a, false);
    if (localBitmap != null) {
      synchronized (GLImage2DTexture.a(this.this$0))
      {
        if (GLImage2DTexture.a(this.this$0) == null)
        {
          GLImage2DTexture.a(this.this$0, localBitmap);
          return;
        }
        GLImage2DTexture.a(this.this$0).recycle();
        GLImage2DTexture.a(this.this$0, localBitmap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ptvfilter.material.GLImage2DTexture.1
 * JD-Core Version:    0.7.0.1
 */