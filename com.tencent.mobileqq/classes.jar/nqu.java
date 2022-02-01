import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;

public class nqu
{
  public static int a()
  {
    return (int)(0.64F * ViewUtils.getScreenWidth());
  }
  
  public static int a(TextView paramTextView)
  {
    if ((paramTextView != null) && (paramTextView.getText() != null))
    {
      TextPaint localTextPaint = paramTextView.getPaint();
      return new StaticLayout(paramTextView.getText().toString(), localTextPaint, paramTextView.getWidth() - paramTextView.getPaddingLeft() - paramTextView.getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false).getLineCount();
    }
    return -1;
  }
  
  public static int b()
  {
    return (int)(ViewUtils.getScreenWidth() * 0.045F);
  }
  
  public static int c()
  {
    return (int)(ViewUtils.getScreenWidth() * 0.058F);
  }
  
  public static int d()
  {
    return (int)(ViewUtils.getScreenWidth() * 0.048F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nqu
 * JD-Core Version:    0.7.0.1
 */