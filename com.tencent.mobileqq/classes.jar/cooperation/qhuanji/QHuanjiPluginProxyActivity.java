package cooperation.qhuanji;

import android.content.Context;
import android.util.Log;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;

public class QHuanjiPluginProxyActivity
  extends PluginProxyActivity
{
  public static boolean a;
  
  public static ClassLoader a(Context paramContext)
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "qhuanji_plugin.apk");
  }
  
  protected void onPause()
  {
    super.onPause();
    Log.i("miles", "QHuanjiPluginProxyActivity >> onPause.");
    a = false;
  }
  
  protected void onResume()
  {
    super.onResume();
    Log.i("miles", "QHuanjiPluginProxyActivity >> onResume.");
    a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qhuanji.QHuanjiPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */