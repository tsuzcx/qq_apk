import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class qre
  implements View.OnAttachStateChangeListener
{
  qre(qrd paramqrd) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (qrd.a(this.a) != null)
    {
      qrd.a(this.a).b();
      qrd.a(this.a, null);
    }
    if (qrd.a(this.a) != null)
    {
      qrd.a(this.a).a();
      qrd.a(this.a, null);
    }
    if (qrd.a(this.a) != null)
    {
      qrd.a(this.a).a();
      qrd.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qre
 * JD-Core Version:    0.7.0.1
 */