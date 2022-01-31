import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class mka
  extends ClickableSpan
{
  mka(mjs parammjs) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mka
 * JD-Core Version:    0.7.0.1
 */