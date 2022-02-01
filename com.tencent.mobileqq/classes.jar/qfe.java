import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class qfe
  implements View.OnAttachStateChangeListener
{
  qfe(qfa paramqfa) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (qfa.a(this.a) != null)
    {
      qfa.a(this.a).b();
      qfa.a(this.a, null);
    }
    if (qfa.a(this.a) != null)
    {
      qfa.a(this.a).a();
      qfa.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qfe
 * JD-Core Version:    0.7.0.1
 */