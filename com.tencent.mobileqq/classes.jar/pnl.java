import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class pnl
  implements View.OnAttachStateChangeListener
{
  pnl(pnh parampnh) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (pnh.a(this.a) != null)
    {
      pnh.a(this.a).b();
      pnh.a(this.a, null);
    }
    if (pnh.a(this.a) != null)
    {
      pnh.a(this.a).a();
      pnh.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pnl
 * JD-Core Version:    0.7.0.1
 */