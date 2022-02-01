package com.tencent.open.appcommon.now.download.js;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.open.appcommon.now.download.IDownloadCallback;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.IJsCallBack;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadCallbackWebImpl
  implements IDownloadCallback
{
  protected static DownloadCallbackWebImpl a;
  protected Handler b = null;
  
  public static DownloadCallbackWebImpl a()
  {
    if (a == null) {
      a = new DownloadCallbackWebImpl();
    }
    return a;
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
      LogUtility.c("DownloadCallbackWebImpl", "getCallBackJsonObject >>> ", paramString1);
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
      LogUtility.c("DownloadCallbackWebImpl", "getCallBackJsonObject >>> ", paramString1);
    }
    return localJSONObject.toString();
  }
  
  public void a(int paramInt)
  {
    a(b(paramInt));
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    if (paramDownloadInfo != null) {
      a(b(paramDownloadInfo, paramInt).toString());
    }
  }
  
  protected void a(String paramString)
  {
    H5JSCallbackManager localH5JSCallbackManager = H5JSCallbackManager.a();
    try
    {
      int j = localH5JSCallbackManager.b().size();
      int i = 0;
      while (i < j)
      {
        Object localObject = (IJsCallBack)localH5JSCallbackManager.b().get(i);
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
          LogUtility.a("DownloadCallbackWebImpl", localStringBuilder.toString());
          this.b.post(new DownloadCallbackWebImpl.1(this, localWebView, (String)localObject));
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramString)
    {
      LogUtility.c("DownloadCallbackWebImpl", "doJsCallback >>> ", paramString);
    }
  }
  
  public void a(List<DownloadInfo> paramList) {}
  
  protected String b(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("nettype", paramInt);
    }
    catch (JSONException localJSONException)
    {
      LogUtility.c("DownloadCallbackWebImpl", "getCallBackJsonObject >>> ", localJSONException);
    }
    return localJSONObject.toString();
  }
  
  public JSONObject b(DownloadInfo paramDownloadInfo, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", paramDownloadInfo.c);
      localJSONObject.put("state", paramDownloadInfo.a());
      localJSONObject.put("pro", paramDownloadInfo.t);
      localJSONObject.put("packagename", paramDownloadInfo.e);
      localJSONObject.put("ismyapp", paramDownloadInfo.o);
      localJSONObject.put("download_from", paramDownloadInfo.z);
      localJSONObject.put("realDownloadType", paramDownloadInfo.p);
      localJSONObject.put("via", paramDownloadInfo.h);
      localJSONObject.put("writecodestate", paramDownloadInfo.D);
      localJSONObject.put("extraInfo", paramDownloadInfo.F);
      localJSONObject.put("isAutoInstallBySDK", paramDownloadInfo.G);
      localJSONObject.put("queryResult", paramInt);
      return localJSONObject;
    }
    catch (JSONException paramDownloadInfo)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetworkConnect ");
      localStringBuilder.append(paramDownloadInfo.getMessage());
      LogUtility.c("DownloadCallbackWebImpl", localStringBuilder.toString(), paramDownloadInfo);
    }
    return localJSONObject;
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    a(a(paramString1, 6, paramString2));
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a(b(paramDownloadInfo, -1).toString());
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (paramDownloadInfo != null) {
      a(a(paramDownloadInfo.c, paramInt2, paramDownloadInfo.t, paramDownloadInfo.e, paramDownloadInfo.o, paramString, paramInt1, paramDownloadInfo.D));
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a(b(paramDownloadInfo, -1).toString());
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a(b(paramDownloadInfo, -1).toString());
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList != null)
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localJSONArray.put(b((DownloadInfo)paramList.next(), -1));
      }
      a(localJSONArray.toString());
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a(b(paramDownloadInfo, -1).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadCallbackWebImpl
 * JD-Core Version:    0.7.0.1
 */