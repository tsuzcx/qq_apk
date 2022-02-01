import android.content.Context;
import android.content.res.Resources;
import org.jetbrains.annotations.NotNull;

public class spq
{
  public static tjj a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new tjj(paramContext, 2131755823);
    paramContext.setContentView(2131562771);
    paramContext.setTitle(null);
    paramContext.setMessage(paramString1);
    paramContext.a(paramString2);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static void a(@NotNull Context paramContext)
  {
    spr localspr = new spr(paramContext);
    bglp.a(paramContext, 230, null, paramContext.getResources().getString(2131716890), localspr, localspr).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     spq
 * JD-Core Version:    0.7.0.1
 */