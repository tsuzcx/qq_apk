import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;

public class nlu
  extends URLDrawableDownListener.Adapter
{
  public nlu(VideoCoverFragment paramVideoCoverFragment) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    super.onLoadCancelled(paramView, paramURLDrawable);
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFailed(paramView, paramURLDrawable, paramThrowable);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    super.onLoadInterrupted(paramView, paramURLDrawable, paramInterruptedException);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (paramView == null) {}
    while (!(paramView instanceof ImageView)) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i = paramURLDrawable.getIntrinsicWidth();
    int j = paramURLDrawable.getIntrinsicHeight();
    localLayoutParams.width = (i * aepi.a(23.0F, VideoCoverFragment.a(this.a).getResources()) / j);
    paramView.setLayoutParams(localLayoutParams);
    ((URLImageView)paramView).setImageDrawable(paramURLDrawable);
    paramView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nlu
 * JD-Core Version:    0.7.0.1
 */