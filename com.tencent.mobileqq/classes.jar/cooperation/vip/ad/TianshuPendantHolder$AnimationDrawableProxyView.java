package cooperation.vip.ad;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;

class TianshuPendantHolder$AnimationDrawableProxyView
  extends View
{
  private View jdField_a_of_type_AndroidViewView;
  
  public TianshuPendantHolder$AnimationDrawableProxyView(TianshuPendantHolder paramTianshuPendantHolder, Context paramContext, View paramView, Drawable paramDrawable)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewView = paramView;
    setBackgroundDrawable(paramDrawable);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_AndroidViewView.postDelayed(paramRunnable, paramLong - l);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidViewView.removeCallbacks(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.ad.TianshuPendantHolder.AnimationDrawableProxyView
 * JD-Core Version:    0.7.0.1
 */