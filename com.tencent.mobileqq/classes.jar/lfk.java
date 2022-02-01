import com.tencent.av.app.VideoAppInterface;
import java.util.Observable;

public class lfk
  extends Observable
{
  VideoAppInterface a = null;
  
  public lfk(VideoAppInterface paramVideoAppInterface)
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
 * Qualified Name:     lfk
 * JD-Core Version:    0.7.0.1
 */