import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import java.lang.ref.WeakReference;

class mhi
  extends ClickableSpan
{
  private WeakReference<mha> a;
  
  public mhi(mha parammha)
  {
    this.a = new WeakReference(parammha);
  }
  
  public void onClick(View paramView)
  {
    if (this.a == null) {}
    do
    {
      return;
      paramView = (mha)this.a.get();
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
 * Qualified Name:     mhi
 * JD-Core Version:    0.7.0.1
 */