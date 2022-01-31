package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.TexturePreviewContext;

public class StoryTexturePreviewContext
  extends TexturePreviewContext
{
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.mCamera.a();
    this.mCamera.a(0, paramInt1, paramInt2);
    this.mCamera.a(paramSurfaceTexture, null, this, true);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    if (this.mCamera != null)
    {
      this.mCamera.a(false);
      this.mCamera.b(false);
      if (this.mActivtiyDestory) {
        this.mCamera = null;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.StoryTexturePreviewContext
 * JD-Core Version:    0.7.0.1
 */