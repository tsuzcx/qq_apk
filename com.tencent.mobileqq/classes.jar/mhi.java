import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class mhi
  extends ClickableSpan
{
  mhi(mha parammha) {}
  
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
 * Qualified Name:     mhi
 * JD-Core Version:    0.7.0.1
 */