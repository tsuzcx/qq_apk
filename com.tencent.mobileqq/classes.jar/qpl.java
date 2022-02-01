import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class qpl
  implements View.OnAttachStateChangeListener
{
  qpl(qph paramqph) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (qph.a(this.a) != null)
    {
      qph.a(this.a).b();
      qph.a(this.a, null);
    }
    if (qph.a(this.a) != null)
    {
      qph.a(this.a).a();
      qph.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpl
 * JD-Core Version:    0.7.0.1
 */