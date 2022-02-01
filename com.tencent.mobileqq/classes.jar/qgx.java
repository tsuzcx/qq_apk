import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class qgx
  implements View.OnAttachStateChangeListener
{
  qgx(qgw paramqgw) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (qgw.a(this.a) != null)
    {
      qgw.a(this.a).b();
      qgw.a(this.a, null);
    }
    if (qgw.a(this.a) != null)
    {
      qgw.a(this.a).a();
      qgw.a(this.a, null);
    }
    if (qgw.a(this.a) != null)
    {
      qgw.a(this.a).a();
      qgw.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qgx
 * JD-Core Version:    0.7.0.1
 */