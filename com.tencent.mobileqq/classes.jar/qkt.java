import android.app.Activity;
import com.tencent.gdtad.jsbridge.GdtAdWebPlugin;
import com.tencent.gdtad.jsbridge.GdtJsCallHandler;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtDeviceUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class qkt
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    if ((paramGdtAdWebPlugin == null) || (paramGdtAdWebPlugin.mRuntime == null) || (paramGdtAdWebPlugin.mRuntime.a() == null))
    {
      GdtLog.d("GdtCarrierJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    Activity localActivity = paramGdtAdWebPlugin.mRuntime.a();
    paramVarArgs = new JSONObject();
    try
    {
      paramVarArgs.put("carrier", GdtDeviceUtil.a(localActivity));
      try
      {
        paramGdtAdWebPlugin.callJs(paramString, new String[] { paramVarArgs.toString() });
        return true;
      }
      catch (Throwable paramGdtAdWebPlugin)
      {
        GdtLog.d("GdtCarrierJsCallHandler", "handleJsCallRequest error", paramGdtAdWebPlugin);
        return true;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        GdtLog.d("GdtCarrierJsCallHandler", "handleJsCallRequest error", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qkt
 * JD-Core Version:    0.7.0.1
 */