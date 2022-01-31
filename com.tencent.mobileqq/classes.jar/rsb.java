import android.content.Context;
import android.content.res.Resources;
import org.jetbrains.annotations.NotNull;

public class rsb
{
  public static sks a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new sks(paramContext, 2131755801);
    paramContext.setContentView(2131562535);
    paramContext.setTitle(null);
    paramContext.setMessage(paramString1);
    paramContext.a(paramString2);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static void a(@NotNull Context paramContext)
  {
    rsc localrsc = new rsc(paramContext);
    bgow.a(paramContext, 230, null, paramContext.getResources().getString(2131718755), localrsc, localrsc).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rsb
 * JD-Core Version:    0.7.0.1
 */