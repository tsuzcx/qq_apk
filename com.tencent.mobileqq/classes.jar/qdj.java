import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class qdj
  implements View.OnAttachStateChangeListener
{
  qdj(qdf paramqdf) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (qdf.a(this.a) != null)
    {
      qdf.a(this.a).b();
      qdf.a(this.a, null);
    }
    if (qdf.a(this.a) != null)
    {
      qdf.a(this.a).a();
      qdf.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qdj
 * JD-Core Version:    0.7.0.1
 */