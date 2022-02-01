package cooperation.qqcircle.utils;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import cooperation.qqcircle.report.QCircleQualityReporter;

final class QCircleImageLoader$1
  implements URLDrawableDownListener
{
  QCircleImageLoader$1(URLDrawableDownListener paramURLDrawableDownListener, long paramLong, String paramString) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (this.val$listener != null) {
      this.val$listener.onLoadFailed(paramView, paramURLDrawable, paramThrowable);
    }
    if (this.val$startLoadTimeStamp > 0L) {
      QCircleQualityReporter.reportImageQualityEvent("image_load_ret", String.valueOf((float)(System.currentTimeMillis() - this.val$startLoadTimeStamp) / 1000.0F), "-1", this.val$source, 5);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (this.val$listener != null) {
      this.val$listener.onLoadSuccessed(paramView, paramURLDrawable);
    }
    if (this.val$startLoadTimeStamp > 0L) {
      QCircleQualityReporter.reportImageQualityEvent("image_load_ret", String.valueOf((float)(System.currentTimeMillis() - this.val$startLoadTimeStamp) / 1000.0F), "0", this.val$source, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.utils.QCircleImageLoader.1
 * JD-Core Version:    0.7.0.1
 */