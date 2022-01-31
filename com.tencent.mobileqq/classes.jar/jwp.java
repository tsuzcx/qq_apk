import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;

public class jwp
  extends ClickableSpan
{
  public jwp(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion) {}
  
  public void onClick(View paramView)
  {
    this.a.y();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jwp
 * JD-Core Version:    0.7.0.1
 */