import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class qfc
  implements View.OnAttachStateChangeListener
{
  qfc(qfb paramqfb) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (qfb.a(this.a) != null)
    {
      qfb.a(this.a).b();
      qfb.a(this.a, null);
    }
    if (qfb.a(this.a) != null)
    {
      qfb.a(this.a).a();
      qfb.a(this.a, null);
    }
    if (qfb.a(this.a) != null)
    {
      qfb.a(this.a).a();
      qfb.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qfc
 * JD-Core Version:    0.7.0.1
 */