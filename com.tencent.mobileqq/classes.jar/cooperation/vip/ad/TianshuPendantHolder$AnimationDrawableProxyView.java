package cooperation.vip.ad;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;

class TianshuPendantHolder$AnimationDrawableProxyView
  extends View
{
  private View b;
  
  public TianshuPendantHolder$AnimationDrawableProxyView(TianshuPendantHolder paramTianshuPendantHolder, Context paramContext, View paramView, Drawable paramDrawable)
  {
    super(paramContext);
    this.b = paramView;
    setBackgroundDrawable(paramDrawable);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    this.b.invalidate();
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    long l = SystemClock.uptimeMillis();
    this.b.postDelayed(paramRunnable, paramLong - l);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    this.b.removeCallbacks(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.ad.TianshuPendantHolder.AnimationDrawableProxyView
 * JD-Core Version:    0.7.0.1
 */