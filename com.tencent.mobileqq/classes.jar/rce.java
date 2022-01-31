import android.content.Context;

public class rce
{
  public static ruf a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new ruf(paramContext, 2131755791);
    paramContext.setContentView(2131562313);
    paramContext.setTitle(null);
    paramContext.setMessage(paramString1);
    paramContext.a(paramString2);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rce
 * JD-Core Version:    0.7.0.1
 */