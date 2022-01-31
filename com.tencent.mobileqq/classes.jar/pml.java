import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.util.Log;
import com.tencent.component.media.image.drawable.AutoGifDrawable;
import com.tencent.component.media.image.drawable.AutoGifDrawable.AutoGifCallback;
import com.tencent.component.media.utils.ImageManagerLog;

public class pml
  implements Drawable.Callback
{
  public pml(AutoGifDrawable paramAutoGifDrawable) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    try
    {
      if (this.a.a != null) {
        this.a.a.invalidateGifView();
      }
      return;
    }
    catch (Throwable paramDrawable)
    {
      ImageManagerLog.w(AutoGifDrawable.a(), "invalidateDrawable,catch an exception:" + Log.getStackTraceString(paramDrawable));
    }
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pml
 * JD-Core Version:    0.7.0.1
 */