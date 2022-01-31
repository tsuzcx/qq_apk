import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.component.media.image.drawable.AutoGifDrawable;
import com.tencent.component.media.image.drawable.AutoGifDrawable.AutoGifCallback;

public class pfz
  implements Drawable.Callback
{
  public pfz(AutoGifDrawable paramAutoGifDrawable) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (this.a.a != null) {
      this.a.a.invalidateGifView();
    }
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pfz
 * JD-Core Version:    0.7.0.1
 */