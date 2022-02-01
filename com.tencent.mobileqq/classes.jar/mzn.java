import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;

class mzn
  implements SurfaceTexture.OnFrameAvailableListener
{
  mzn(mzm parammzm) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    mzm.a(this.a, true);
    mzm.a(this.a, "onFrameAvailable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mzn
 * JD-Core Version:    0.7.0.1
 */