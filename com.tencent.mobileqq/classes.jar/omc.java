import android.content.res.Resources;
import android.graphics.Color;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class omc
  extends LinkMovementMethod
{
  private static omc jdField_a_of_type_Omc;
  private BackgroundColorSpan jdField_a_of_type_AndroidTextStyleBackgroundColorSpan;
  
  public static omc a()
  {
    if (jdField_a_of_type_Omc == null) {
      jdField_a_of_type_Omc = new omc();
    }
    return jdField_a_of_type_Omc;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 1) || (i == 0) || (i == 2) || (i == 3))
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
          paramSpannable.removeSpan(this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan);
          paramSpannable.setSpan(new BackgroundColorSpan(0), paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]), 33);
          Selection.removeSelection(paramSpannable);
          localObject[0].onClick(paramTextView);
        }
        for (;;)
        {
          return true;
          if (i == 0)
          {
            this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan = new BackgroundColorSpan(Color.parseColor("#DBE5EF"));
            paramSpannable.setSpan(this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan, paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]), 33);
          }
          else if ((i == 3) || (i == 2))
          {
            paramSpannable.removeSpan(this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan);
            paramSpannable.setSpan(new BackgroundColorSpan(0), paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]), 33);
          }
        }
      }
      if ((paramTextView.getTag(2131375343) != null) && ((paramTextView.getTag(2131375343) instanceof Boolean)) && (((Boolean)paramTextView.getTag(2131375343)).booleanValue()))
      {
        switch (paramMotionEvent.getAction())
        {
        }
        for (;;)
        {
          return true;
          ((LinearLayout)paramTextView.getParent()).setBackgroundDrawable(paramTextView.getResources().getDrawable(2130848866));
          continue;
          ((LinearLayout)paramTextView.getParent()).setBackgroundDrawable(paramTextView.getResources().getDrawable(2130848870));
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     omc
 * JD-Core Version:    0.7.0.1
 */