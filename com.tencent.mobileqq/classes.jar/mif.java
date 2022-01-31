import android.annotation.TargetApi;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.BaseMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

@TargetApi(11)
public class mif
  extends BaseMovementMethod
{
  private static mif a;
  
  public static mif a()
  {
    if (a == null) {
      a = new mif();
    }
    return a;
  }
  
  public void initialize(TextView paramTextView, Spannable paramSpannable)
  {
    Selection.removeSelection(paramSpannable);
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if ((i == 1) || (i == 0))
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = paramTextView.getTotalPaddingLeft();
      int n = paramTextView.getTotalPaddingTop();
      int i1 = paramTextView.getScrollX();
      int i2 = paramTextView.getScrollY();
      paramMotionEvent = paramTextView.getLayout();
      j = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(k - n + i2), j - m + i1);
      paramMotionEvent = (ClickableSpan[])paramSpannable.getSpans(j, j, ClickableSpan.class);
      if (paramMotionEvent.length > 0)
      {
        if (i == 1) {
          paramMotionEvent[0].onClick(paramTextView);
        }
        for (;;)
        {
          return true;
          Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(paramMotionEvent[0]), paramSpannable.getSpanEnd(paramMotionEvent[0]));
        }
      }
      Selection.removeSelection(paramSpannable);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mif
 * JD-Core Version:    0.7.0.1
 */