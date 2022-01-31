import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.component.media.photogif.NewAnimationDrawable;

public class piv
  extends Handler
{
  public piv(NewAnimationDrawable paramNewAnimationDrawable, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      NewAnimationDrawable.a(this.a, NewAnimationDrawable.a(this.a));
      this.a.invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     piv
 * JD-Core Version:    0.7.0.1
 */