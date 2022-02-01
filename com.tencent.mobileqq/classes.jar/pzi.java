import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class pzi
  implements View.OnAttachStateChangeListener
{
  pzi(pzh parampzh) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (pzh.a(this.a) != null)
    {
      pzh.a(this.a).b();
      pzh.a(this.a, null);
    }
    if (pzh.a(this.a) != null)
    {
      pzh.a(this.a).a();
      pzh.a(this.a, null);
    }
    if (pzh.a(this.a) != null)
    {
      pzh.a(this.a).a();
      pzh.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pzi
 * JD-Core Version:    0.7.0.1
 */