import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class pha
  implements View.OnAttachStateChangeListener
{
  pha(pgw parampgw) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (pgw.a(this.a) != null)
    {
      pgw.a(this.a).b();
      pgw.a(this.a, null);
    }
    if (pgw.a(this.a) != null)
    {
      pgw.a(this.a).a();
      pgw.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pha
 * JD-Core Version:    0.7.0.1
 */