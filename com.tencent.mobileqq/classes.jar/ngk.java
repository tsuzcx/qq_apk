import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.TextView;

public class ngk
{
  public static int a()
  {
    return (int)(0.64F * bgtn.a());
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
    return (int)(bgtn.a() * 0.045F);
  }
  
  public static int c()
  {
    return (int)(bgtn.a() * 0.058F);
  }
  
  public static int d()
  {
    return (int)(bgtn.a() * 0.048F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ngk
 * JD-Core Version:    0.7.0.1
 */