import com.tencent.av.app.VideoAppInterface;
import java.util.Observable;

public class kvv
  extends Observable
{
  VideoAppInterface a = null;
  
  public kvv(VideoAppInterface paramVideoAppInterface)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kvv
 * JD-Core Version:    0.7.0.1
 */