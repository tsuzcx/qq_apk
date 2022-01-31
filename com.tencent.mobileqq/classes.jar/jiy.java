import com.tencent.av.camera.CameraUtils;
import java.util.Observable;

public class jiy
  extends Observable
{
  public jiy(CameraUtils paramCameraUtils) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jiy
 * JD-Core Version:    0.7.0.1
 */