import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import java.lang.ref.WeakReference;

class mie
  extends ClickableSpan
{
  private WeakReference<mhw> a;
  
  public mie(mhw parammhw)
  {
    this.a = new WeakReference(parammhw);
  }
  
  public void onClick(View paramView)
  {
    if (this.a == null) {}
    do
    {
      return;
      paramView = (mhw)this.a.get();
    } while (paramView == null);
    paramView.d();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(paramTextPaint.getColor());
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mie
 * JD-Core Version:    0.7.0.1
 */