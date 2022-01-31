import android.text.TextPaint;

public class mrf
{
  public static float a(String paramString, TextPaint paramTextPaint)
  {
    return paramTextPaint.measureText(paramString);
  }
  
  public static float a(StringBuilder paramStringBuilder, String paramString, TextPaint paramTextPaint, float paramFloat)
  {
    float f1;
    if (paramString == null)
    {
      f1 = paramFloat;
      return f1;
    }
    paramString = paramString.toCharArray();
    int i = 0;
    for (;;)
    {
      f1 = paramFloat;
      if (i >= paramString.length) {
        break;
      }
      float f2 = paramTextPaint.measureText(paramString, i, 1);
      f1 = paramFloat;
      if (f2 >= paramFloat) {
        break;
      }
      paramFloat -= f2;
      paramStringBuilder.append(paramString[i]);
      i += 1;
    }
  }
  
  public static float b(StringBuilder paramStringBuilder, String paramString, TextPaint paramTextPaint, float paramFloat)
  {
    float f = paramTextPaint.measureText("...");
    if (f > a(paramStringBuilder, paramString, paramTextPaint, paramFloat - f)) {
      paramStringBuilder.append("...");
    }
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mrf
 * JD-Core Version:    0.7.0.1
 */