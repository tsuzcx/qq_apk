import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.os.Build.VERSION;

public final class naa
{
  @TargetApi(11)
  public static void a(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      ((android.content.ClipboardManager)paramContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, paramString));
      return;
    }
    ((android.text.ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     naa
 * JD-Core Version:    0.7.0.1
 */