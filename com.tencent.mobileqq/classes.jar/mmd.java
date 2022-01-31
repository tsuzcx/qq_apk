import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class mmd
  implements URLDrawableDownListener
{
  mmd(mmc parammmc) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.d("Q.readinjoy.fast_web", 2, " onLoadFailed: " + paramURLDrawable.getURL().toString() + " retryCnt: " + mmc.a(this.a));
    if ((((RecommendData)this.a.a).b.equals(paramURLDrawable.getURL().getFile())) && (mmc.a(this.a) < 3))
    {
      mmc.b(this.a);
      this.a.b(this.a.a, this.a.a, true);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    mmc.a(this.a).setImageDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmd
 * JD-Core Version:    0.7.0.1
 */