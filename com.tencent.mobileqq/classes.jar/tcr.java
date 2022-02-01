import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySlidingIndicator;

public class tcr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public tcr(ReadinjoySlidingIndicator paramReadinjoySlidingIndicator) {}
  
  @SuppressLint({"NewApi"})
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    for (;;)
    {
      ReadinjoySlidingIndicator.a(this.a, ReadinjoySlidingIndicator.a(this.a));
      View localView = ReadinjoySlidingIndicator.a(this.a).getChildAt(ReadinjoySlidingIndicator.a(this.a));
      ReadinjoySlidingIndicator.a(this.a, localView.getLeft());
      this.a.invalidate();
      return;
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tcr
 * JD-Core Version:    0.7.0.1
 */