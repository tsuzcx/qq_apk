import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import java.lang.ref.WeakReference;

class mhz
  extends ClickableSpan
{
  private WeakReference<mhr> a;
  
  public mhz(mhr parammhr)
  {
    this.a = new WeakReference(parammhr);
  }
  
  public void onClick(View paramView)
  {
    if (this.a == null) {}
    do
    {
      return;
      paramView = (mhr)this.a.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mhz
 * JD-Core Version:    0.7.0.1
 */