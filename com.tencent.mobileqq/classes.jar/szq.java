import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.QQCustomDialog;
import org.jetbrains.annotations.NotNull;

public class szq
{
  public static tro a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new tro(paramContext, 2131755829);
    paramContext.setContentView(2131562755);
    paramContext.setTitle(null);
    paramContext.setMessage(paramString1);
    paramContext.a(paramString2);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static void a(@NotNull Context paramContext)
  {
    szr localszr = new szr(paramContext);
    bhdj.a(paramContext, 230, null, paramContext.getResources().getString(2131717605), localszr, localszr).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     szq
 * JD-Core Version:    0.7.0.1
 */