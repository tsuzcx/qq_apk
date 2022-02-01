import com.tencent.av.app.VideoAppInterface;
import java.util.Observable;

public class lfj
  extends Observable
{
  VideoAppInterface a = null;
  
  public lfj(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface != null) {
      this.a = paramVideoAppInterface;
    }
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfj
 * JD-Core Version:    0.7.0.1
 */