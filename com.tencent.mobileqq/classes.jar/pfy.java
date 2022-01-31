import android.util.Log;
import com.tencent.component.media.gif.NewGifDecoder;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.utils.ImageManagerLog;

public class pfy
  implements Runnable
{
  private pfy(NewGifDrawable paramNewGifDrawable) {}
  
  public void run()
  {
    NewGifDrawable.a(this.a);
    try
    {
      this.a.a.stop();
      return;
    }
    catch (Throwable localThrowable)
    {
      ImageManagerLog.e("NewGifDrawable", Log.getStackTraceString(localThrowable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pfy
 * JD-Core Version:    0.7.0.1
 */