import com.tencent.component.media.gif.NewGifDrawable;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class pkm
  implements Runnable
{
  public pkm(NewGifDrawable paramNewGifDrawable) {}
  
  public void run()
  {
    NewGifDrawable.a(this.a);
    this.a.a.execute(new pkn(this, this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pkm
 * JD-Core Version:    0.7.0.1
 */