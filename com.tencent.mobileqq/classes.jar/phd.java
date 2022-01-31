import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class phd
  implements View.OnAttachStateChangeListener
{
  phd(pgz parampgz) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (pgz.a(this.a) != null)
    {
      pgz.a(this.a).b();
      pgz.a(this.a, null);
    }
    if (pgz.a(this.a) != null)
    {
      pgz.a(this.a).a();
      pgz.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phd
 * JD-Core Version:    0.7.0.1
 */