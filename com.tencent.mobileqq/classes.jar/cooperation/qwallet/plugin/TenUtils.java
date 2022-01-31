package cooperation.qwallet.plugin;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class TenUtils
{
  private static final String TAG = "TenUtils";
  
  public static void startQQBrowser(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TenUtils", 2, "startQQBrowserActivity url=" + paramString);
    }
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qwallet.plugin.TenUtils
 * JD-Core Version:    0.7.0.1
 */