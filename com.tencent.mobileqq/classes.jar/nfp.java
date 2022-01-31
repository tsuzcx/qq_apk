import com.tencent.biz.qqstory.network.handler.GetUserIconHandler;
import java.util.ArrayList;
import java.util.Set;

public class nfp
  implements Runnable
{
  public nfp(GetUserIconHandler paramGetUserIconHandler) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Thread.sleep(1000L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        continue;
      }
      synchronized (GetUserIconHandler.a())
      {
        if (!GetUserIconHandler.a().isEmpty())
        {
          ArrayList localArrayList2 = new ArrayList(GetUserIconHandler.a());
          GetUserIconHandler.a().clear();
          GetUserIconHandler.a().clear();
          this.a.a(localArrayList2);
        }
        this.a.a = false;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfp
 * JD-Core Version:    0.7.0.1
 */