import com.tencent.av.camera.CameraUtils;
import java.util.Observable;

public class jgv
  extends Observable
{
  public jgv(CameraUtils paramCameraUtils) {}
  
  public void a(Object[] paramArrayOfObject)
  {
    try
    {
      super.setChanged();
      super.notifyObservers(paramArrayOfObject);
      return;
    }
    finally
    {
      paramArrayOfObject = finally;
      throw paramArrayOfObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jgv
 * JD-Core Version:    0.7.0.1
 */