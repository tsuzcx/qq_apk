import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ImageData;
import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class mqz
  implements URLDrawableDownListener
{
  mqz(mqy parammqy) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.d("Q.readinjoy.fast_web", 2, " onLoadFailed: " + paramURLDrawable.getURL().toString() + " retryCnt: " + mqy.a(this.a));
    paramView = PubAccountHttpDownloader.a(((ImageData)this.a.a).jdField_a_of_type_JavaLangString, 4);
    if ((paramView != null) && (paramView.equals(paramURLDrawable.getURL())))
    {
      if (mqy.b(this.a) < 2) {
        mqy.c(this.a);
      }
      mqy.d(this.a);
      StatisticCollector.a(BaseApplication.getContext()).a(null, "NativeWebImageUI", false, 0L, 0L, null, "", true);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (ImageData)this.a.a;
    URL localURL = PubAccountHttpDownloader.a(paramView.jdField_a_of_type_JavaLangString, 4);
    if ((localURL != null) && (localURL.equals(paramURLDrawable.getURL())))
    {
      if ((paramView.jdField_a_of_type_Int == 0) || (paramView.b == 0))
      {
        mqy.a(this.a, paramURLDrawable);
        mqy.a(this.a).setImageDrawable(paramURLDrawable);
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "NativeWebImageUI", true, 0L, 0L, null, "", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqz
 * JD-Core Version:    0.7.0.1
 */