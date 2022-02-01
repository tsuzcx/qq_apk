package dov.com.qq.im.ae.camera;

public class AEVideoCaptureResult
  extends BaseVideoCaptureResult
{
  public long finishTimeMs;
  public long startTimeMs;
  
  public long getVideoCaptureLength()
  {
    return this.finishTimeMs - this.startTimeMs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.AEVideoCaptureResult
 * JD-Core Version:    0.7.0.1
 */