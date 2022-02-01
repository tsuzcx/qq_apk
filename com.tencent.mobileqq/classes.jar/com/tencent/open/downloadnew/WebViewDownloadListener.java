package com.tencent.open.downloadnew;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.IJsCallBack;
import com.tencent.open.business.base.JsCallbackManager;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewDownloadListener
  implements DownloadListener
{
  protected static WebViewDownloadListener a;
  protected Handler a;
  
  protected WebViewDownloadListener()
  {
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public static WebViewDownloadListener a()
  {
    if (jdField_a_of_type_ComTencentOpenDownloadnewWebViewDownloadListener == null) {
      jdField_a_of_type_ComTencentOpenDownloadnewWebViewDownloadListener = new WebViewDownloadListener();
    }
    return jdField_a_of_type_ComTencentOpenDownloadnewWebViewDownloadListener;
  }
  
  protected String a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, String paramString3, int paramInt4, int paramInt5)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("packagename", paramString2);
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("state", paramInt1);
      localJSONObject.put("pro", paramInt2);
      localJSONObject.put("ismyapp", paramInt3);
      localJSONObject.put("errorMsg", paramString3);
      localJSONObject.put("errorCode", paramInt4);
      localJSONObject.put("writecodestate", paramInt5);
    }
    catch (JSONException paramString1)
    {
      LogUtility.c("WebViewDownloadListener", "getCallBackJsonObject >>> ", paramString1);
    }
    return localJSONObject.toString();
  }
  
  protected String a(String paramString1, int paramInt, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("packagename", paramString2);
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("state", paramInt);
      localJSONObject.put("pro", 0);
    }
    catch (JSONException paramString1)
    {
      LogUtility.c("WebViewDownloadListener", "getCallBackJsonObject >>> ", paramString1);
    }
    return localJSONObject.toString();
  }
  
  protected void a(String paramString)
  {
    JsCallbackManager localJsCallbackManager = JsCallbackManager.a();
    try
    {
      int j = localJsCallbackManager.a().size();
      int i = 0;
      while (i < j)
      {
        Object localObject = (IJsCallBack)localJsCallbackManager.a().get(i);
        WebView localWebView = ((IJsCallBack)localObject).getWebview();
        if (localWebView != null)
        {
          if (TextUtils.isEmpty(((IJsCallBack)localObject).getJsCallbackMethod()))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('loadProcess',");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(");}void(0);");
            localObject = ((StringBuilder)localObject).toString();
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("javascript:");
            localStringBuilder.append(((IJsCallBack)localObject).getJsCallbackMethod());
            localStringBuilder.append("(");
            localStringBuilder.append(paramString);
            localStringBuilder.append(")");
            localObject = localStringBuilder.toString();
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" commonJsCallBack >>> ");
          localStringBuilder.append((String)localObject);
          LogUtility.a("WebViewDownloadListener", localStringBuilder.toString());
          this.jdField_a_of_type_AndroidOsHandler.post(new WebViewDownloadListener.1(this, localWebView, (String)localObject));
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramString)
    {
      LogUtility.c("WebViewDownloadListener", "doJsCallback >>> ", paramString);
    }
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    a(a(paramString1, 6, paramString2));
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a(paramDownloadInfo.a().toString());
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (paramDownloadInfo != null) {
      a(a(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramInt2, paramDownloadInfo.f, paramDownloadInfo.e, paramDownloadInfo.jdField_c_of_type_Int, paramString, paramInt1, paramDownloadInfo.j));
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a(paramDownloadInfo.a().toString());
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a(paramDownloadInfo.a().toString());
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList != null)
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localJSONArray.put(((DownloadInfo)paramList.next()).a());
      }
      a(localJSONArray.toString());
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a(paramDownloadInfo.a().toString());
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    a(a(paramString1, 13, paramString2));
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    a(a(paramString1, 9, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.WebViewDownloadListener
 * JD-Core Version:    0.7.0.1
 */