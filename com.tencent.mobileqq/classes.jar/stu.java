import android.view.View;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import org.json.JSONObject;

class stu
  implements URLDrawableDownListener
{
  stu(stp paramstp) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    AbstractGifImage.resumeAll();
    stp.a(this.a).setVisibility(0);
    this.a.a("0X800920C", new JSONObject());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     stu
 * JD-Core Version:    0.7.0.1
 */