package cooperation.vip.ad;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;

public class AnimationDrawableProxyView
  extends View
{
  private View a;
  
  public AnimationDrawableProxyView(Context paramContext, View paramView, Drawable paramDrawable)
  {
    super(paramContext);
    this.a = paramView;
    setBackgroundDrawable(paramDrawable);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    this.a.invalidate();
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    long l = SystemClock.uptimeMillis();
    this.a.postDelayed(paramRunnable, paramLong - l);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    this.a.removeCallbacks(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.ad.AnimationDrawableProxyView
 * JD-Core Version:    0.7.0.1
 */