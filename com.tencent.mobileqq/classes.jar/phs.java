import android.text.TextUtils;

public class phs
  extends phr
{
  private phs()
  {
    super(null);
  }
  
  public String b(String paramString)
  {
    paramString = super.b(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return paramString;
      i = paramString.indexOf('#');
    } while (i <= 0);
    return paramString.substring(0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     phs
 * JD-Core Version:    0.7.0.1
 */