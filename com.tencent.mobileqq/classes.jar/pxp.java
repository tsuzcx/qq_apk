import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class pxp
  implements View.OnAttachStateChangeListener
{
  pxp(pxl parampxl) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (pxl.a(this.a) != null)
    {
      pxl.a(this.a).b();
      pxl.a(this.a, null);
    }
    if (pxl.a(this.a) != null)
    {
      pxl.a(this.a).a();
      pxl.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxp
 * JD-Core Version:    0.7.0.1
 */