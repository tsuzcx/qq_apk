import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

final class rdo
  extends ClickableSpan
{
  rdo(TextView paramTextView) {}
  
  public void onClick(View paramView)
  {
    this.a.performClick();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.parseColor("#FF00CAFC"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rdo
 * JD-Core Version:    0.7.0.1
 */