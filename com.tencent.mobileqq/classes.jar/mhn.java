import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class mhn
  extends ClickableSpan
{
  mhn(mhf parammhf) {}
  
  public void onClick(View paramView)
  {
    this.a.d();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(paramTextPaint.getColor());
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mhn
 * JD-Core Version:    0.7.0.1
 */