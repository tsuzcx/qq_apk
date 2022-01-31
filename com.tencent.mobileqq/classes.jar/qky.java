import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.gdtad.jsbridge.GdtAdWebPlugin;
import com.tencent.gdtad.jsbridge.GdtJsCallHandler;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class qky
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    if ((paramGdtAdWebPlugin == null) || (paramGdtAdWebPlugin.mRuntime == null) || (paramGdtAdWebPlugin.mRuntime.a() == null))
    {
      Log.e("GdtOSVersionJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    paramVarArgs = new JSONObject();
    try
    {
      paramVarArgs.put("osVersion", Build.VERSION.RELEASE);
      try
      {
        paramGdtAdWebPlugin.callJs(paramString, new String[] { paramVarArgs.toString() });
        return true;
      }
      catch (Throwable paramGdtAdWebPlugin)
      {
        paramGdtAdWebPlugin.printStackTrace();
        return true;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qky
 * JD-Core Version:    0.7.0.1
 */