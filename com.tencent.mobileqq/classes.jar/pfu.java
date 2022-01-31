import com.tencent.component.media.gif.NewGifDrawable;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class pfu
  implements Runnable
{
  public pfu(NewGifDrawable paramNewGifDrawable) {}
  
  public void run()
  {
    NewGifDrawable.a(this.a);
    this.a.a.execute(new pfv(this, this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pfu
 * JD-Core Version:    0.7.0.1
 */