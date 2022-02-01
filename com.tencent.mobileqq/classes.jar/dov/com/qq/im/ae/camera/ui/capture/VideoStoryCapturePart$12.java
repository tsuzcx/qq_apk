package dov.com.qq.im.ae.camera.ui.capture;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.ExtractFrameRequest;

class VideoStoryCapturePart$12
  implements AECameraGLSurfaceView.ExtractFrameRequest
{
  VideoStoryCapturePart$12(VideoStoryCapturePart paramVideoStoryCapturePart) {}
  
  public void onExtract(Bitmap paramBitmap)
  {
    ThreadManager.excute(new VideoStoryCapturePart.12.1(this, paramBitmap), 64, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.12
 * JD-Core Version:    0.7.0.1
 */