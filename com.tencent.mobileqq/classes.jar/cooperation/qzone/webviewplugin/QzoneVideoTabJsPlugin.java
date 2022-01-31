package cooperation.qzone.webviewplugin;

import amne;
import amnf;
import amng;
import amnh;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneVideoTabJsPlugin
  extends QzoneInternalWebViewPlugin
  implements WebEventListener
{
  private String a;
  private String b;
  
  public QzoneVideoTabJsPlugin()
  {
    this.jdField_a_of_type_JavaLangString = QzoneVideoTabJsPlugin.class.getSimpleName();
  }
  
  private void a(String paramString)
  {
    try
    {
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, "getLocalProxyUrl. json=" + paramString);
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getJSONArray("playList");
      localObject = ((JSONObject)localObject).getString("callback");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.b = ((String)localObject);
      }
      localObject = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        ((ArrayList)localObject).add(paramString.getJSONObject(i).getString("url"));
        localArrayList.add(paramString.getJSONObject(i).getString("vid"));
        i += 1;
      }
      if (((ArrayList)localObject).size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getHandler(QzoneVideoTabJsPlugin.class).post(new amne(this, (ArrayList)localObject, localArrayList));
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getHandler(QzoneVideoTabJsPlugin.class).post(new amng(this));
  }
  
  private void b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("state");
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        localArrayList1.add(localJSONObject.getString("url"));
        localArrayList2.add(localJSONObject.getString("state"));
        i += 1;
      }
      if (localArrayList1.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getHandler(QzoneVideoTabJsPlugin.class).post(new amnf(this, localArrayList1, localArrayList2));
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void c(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("url");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getHandler(QzoneVideoTabJsPlugin.class).post(new amnh(this, paramString));
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, paramString, new Object[0]);
    }
  }
  
  public void a()
  {
    RemoteHandleManager.a().b(this);
    super.a();
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if (("videoProxyGetLocalProxyURL".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      RemoteHandleManager.a().a(this);
      a(paramVarArgs[0]);
      return true;
    }
    if (("videoProxySetPlayState".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      RemoteHandleManager.a().a(this);
      b(paramVarArgs[0]);
      return true;
    }
    if ("videoProxyStopAll".equals(paramString3))
    {
      RemoteHandleManager.a().a(this);
      b();
      return true;
    }
    if ("videoProxySaveVideoToAlbum".equals(paramString3)) {
      c(paramVarArgs[0]);
    }
    return false;
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      do
      {
        return;
        paramBundle = paramBundle.getBundle("data");
        if (paramBundle == null)
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "call js function,bundle is empty");
          return;
        }
      } while (!"cmd.videoGetLocalProxyUrl".equals(paramString));
      paramString = paramBundle.getStringArrayList("param.videoLocalUrls");
      ArrayList localArrayList = paramBundle.getStringArrayList("param.videoId");
      paramBundle = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      if ((paramString != null) && (localArrayList != null)) {}
      try
      {
        if (paramString.size() == localArrayList.size())
        {
          int i = 0;
          while (i < paramString.size())
          {
            String str = (String)paramString.get(i);
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("vid", localArrayList.get(i));
            localJSONObject.put("url", str);
            localJSONArray.put(localJSONObject);
            i += 1;
          }
        }
        paramBundle.put("proxyList", localJSONArray);
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          QLog.w(this.jdField_a_of_type_JavaLangString, 2, "getLocalProxyUrl result is invalid.", paramString);
        }
      }
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, "getLocalProxyUrl result=" + paramBundle);
    } while (TextUtils.isEmpty(this.b));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.b, new String[] { paramBundle.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneVideoTabJsPlugin
 * JD-Core Version:    0.7.0.1
 */