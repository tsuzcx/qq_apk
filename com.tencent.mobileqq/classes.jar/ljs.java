import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.widget.TextView;

public class ljs
  extends LinkMovementMethod
{
  private static ljs a;
  public int a;
  public int b = -7447805;
  
  public ljs()
  {
    this.jdField_a_of_type_Int = -10864125;
  }
  
  static int a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    paramTextView = paramTextView.getTag(paramInt1);
    if ((paramTextView instanceof Integer)) {
      paramInt2 = ((Integer)paramTextView).intValue();
    }
    return paramInt2;
  }
  
  public static MovementMethod a()
  {
    if (jdField_a_of_type_Ljs == null) {
      jdField_a_of_type_Ljs = new ljs();
    }
    return jdField_a_of_type_Ljs;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 1) || (i == 0))
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = paramTextView.getTotalPaddingLeft();
      int n = paramTextView.getTotalPaddingTop();
      int i1 = paramTextView.getScrollX();
      int i2 = paramTextView.getScrollY();
      Object localObject = paramTextView.getLayout();
      j = ((Layout)localObject).getOffsetForHorizontal(((Layout)localObject).getLineForVertical(k - n + i2), j - m + i1);
      localObject = (ClickableSpan[])paramSpannable.getSpans(j, j, ClickableSpan.class);
      if (localObject.length != 0)
      {
        if (i == 1)
        {
          i = a(paramTextView, 2131311055, this.b);
          localObject[0].onClick(paramTextView);
          paramSpannable.setSpan(new ForegroundColorSpan(i), paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]), 33);
        }
        for (;;)
        {
          return true;
          if (i == 0)
          {
            paramSpannable.setSpan(new ForegroundColorSpan(a(paramTextView, 2131311054, this.jdField_a_of_type_Int)), paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]), 33);
            Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]));
          }
        }
      }
      Selection.removeSelection(paramSpannable);
    }
    return super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ljs
 * JD-Core Version:    0.7.0.1
 */