import android.content.Context;
import android.content.res.Resources;
import org.jetbrains.annotations.NotNull;

public class sgu
{
  public static tad a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new tad(paramContext, 2131755824);
    paramContext.setContentView(2131562805);
    paramContext.setTitle(null);
    paramContext.setMessage(paramString1);
    paramContext.a(paramString2);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static void a(@NotNull Context paramContext)
  {
    sgv localsgv = new sgv(paramContext);
    bhlq.a(paramContext, 230, null, paramContext.getResources().getString(2131717006), localsgv, localsgv).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgu
 * JD-Core Version:    0.7.0.1
 */