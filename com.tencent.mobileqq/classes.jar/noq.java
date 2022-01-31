import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class noq
  extends WebViewPlugin
{
  public noq()
  {
    this.mPluginNameSpace = "ReadinjoyAdJs";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString3)) || (paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountWebviewPlugin", 2, " method null or args == null");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountWebviewPlugin", 2, " method:" + paramString3);
    }
    if ("setGameSubscribe".equals(paramString3)) {}
    try
    {
      paramString1 = new JSONObject(paramVarArgs[0]);
      paramJsBridgeListener = paramString1.optString("ret");
      paramString1.optString("appid");
      paramString1 = paramString1.optString("pkgname");
      if (("1".equals(paramJsBridgeListener)) && (!TextUtils.isEmpty(paramString2)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountWebviewPlugin", 2, " method:pkgname=" + paramString1);
        }
        paramJsBridgeListener = new Bundle();
        paramJsBridgeListener.putBoolean("isSuccess", true);
        paramJsBridgeListener.putString("pkgname", paramString1);
        wis.a().a(130, paramJsBridgeListener);
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountWebviewPlugin", 2, paramJsBridgeListener.getMessage());
        }
      }
    }
    if ("setGameLoadState".equals(paramString3)) {}
    try
    {
      paramString1 = new JSONObject(paramVarArgs[0]);
      paramJsBridgeListener = paramString1.optString("adid");
      long l1 = nbj.a(paramString1.optString("navigationStart"), 0L);
      long l2 = nbj.a(paramString1.optString("htmlLoaded"), 0L);
      long l3 = nbj.a(paramString1.optString("domComplete"), 0L);
      if ((l1 > 0L) || (l2 > 0L) || (l3 > 0L))
      {
        paramString1 = new Bundle();
        paramString1.putString("adid", paramJsBridgeListener);
        paramString1.putLong("navigationStart", l1);
        paramString1.putLong("htmlLoaded", l2);
        paramString1.putLong("domComplete", l3);
        wis.a().a(137, paramString1);
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountWebviewPlugin", 2, paramJsBridgeListener.getMessage());
        }
      }
    }
    return true;
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    return super.handleSchemaRequest(paramString1, paramString2);
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     noq
 * JD-Core Version:    0.7.0.1
 */