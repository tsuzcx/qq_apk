import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.QQCustomDialog;
import org.jetbrains.annotations.NotNull;

public class smg
{
  public static ted a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new ted(paramContext, 2131755826);
    paramContext.setContentView(2131562684);
    paramContext.setTitle(null);
    paramContext.setMessage(paramString1);
    paramContext.a(paramString2);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static void a(@NotNull Context paramContext)
  {
    smh localsmh = new smh(paramContext);
    bfur.a(paramContext, 230, null, paramContext.getResources().getString(2131717241), localsmh, localsmh).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     smg
 * JD-Core Version:    0.7.0.1
 */