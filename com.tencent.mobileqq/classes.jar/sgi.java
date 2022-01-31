import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class sgi
{
  public static Dispatcher a()
  {
    return Dispatchers.get(ThreadManager.getSubThreadLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sgi
 * JD-Core Version:    0.7.0.1
 */