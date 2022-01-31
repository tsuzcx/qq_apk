import android.text.TextUtils;
import com.google.zxing.client.android.wifi.ParsedResultType;

public abstract class gp
{
  private final ParsedResultType a;
  
  protected gp(ParsedResultType paramParsedResultType)
  {
    this.a = paramParsedResultType;
  }
  
  public static void a(String paramString, StringBuilder paramStringBuilder)
  {
    if ((paramStringBuilder != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramStringBuilder.length() > 0) {
        paramStringBuilder.append('\n');
      }
      paramStringBuilder.append(paramString);
    }
  }
  
  public abstract String a();
  
  public final String toString()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     gp
 * JD-Core Version:    0.7.0.1
 */