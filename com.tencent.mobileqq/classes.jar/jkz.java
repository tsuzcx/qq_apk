import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomWebProtocol;
import java.util.concurrent.atomic.AtomicInteger;

public class jkz
  implements Runnable
{
  public jkz(RandomController paramRandomController) {}
  
  public void run()
  {
    if (!RandomController.a(this.a).a())
    {
      this.a.a(RandomController.a(this.a).getAccount());
      RandomController.a(this.a).a().postDelayed(RandomController.b(this.a), 2000L);
    }
    do
    {
      return;
      if (RandomController.a(this.a))
      {
        RandomController.b(this.a, false);
        RandomController.a(this.a).set(0);
        RandomController.a(this.a).a(RandomController.b(this.a), RandomController.c(this.a), 1, new String[0]);
        return;
      }
    } while (!RandomController.b(this.a));
    RandomController.c(this.a, false);
    RandomController.a(this.a).a(this.a.b, RandomController.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jkz
 * JD-Core Version:    0.7.0.1
 */