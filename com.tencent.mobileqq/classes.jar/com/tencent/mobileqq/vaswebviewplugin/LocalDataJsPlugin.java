package com.tencent.mobileqq.vaswebviewplugin;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LocalDataJsPlugin
  extends VasWebviewJsPlugin
{
  private static final String[] FILE_PATH_WHITE_LIST = { AppConstants.SDCARD_SIGNATURE_TEMPLATE_ROOT };
  public static final String NAME_SPACE = "localData";
  private static final String TAG = "LocalDataJsPlugin";
  private BrowserAppInterface browserApp;
  DownloadListener sigTplResDownloadListener = new LocalDataJsPlugin.1(this);
  
  public LocalDataJsPlugin()
  {
    this.mPluginNameSpace = "localData";
  }
  
  private boolean existDynamicSource(String paramString)
  {
    paramString = SignatureTemplateConfig.a(paramString, "dynamic_aio");
    File localFile = new File(paramString);
    boolean bool3 = localFile.exists();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      if (!localFile.isDirectory()) {
        return false;
      }
      bool1 = bool2;
      if (FileUtils.getChildFiles(paramString).size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void handleSignatureRequest(String paramString1, int paramInt, String paramString2, JSONObject paramJSONObject)
  {
    Object localObject1 = Integer.toString(paramInt);
    if (existDynamicSource((String)localObject1))
    {
      paramString2 = new JSONObject();
      localObject2 = new JSONObject();
      localObject3 = new JSONArray();
      localObject1 = new File(SignatureTemplateConfig.a((String)localObject1, "dynamic_aio")).listFiles();
      int i = localObject1.length;
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject4 = localObject1[paramInt];
        if (localObject4.getAbsolutePath().endsWith(".png")) {
          ((JSONArray)localObject3).put(localObject4.getAbsolutePath());
        }
        paramInt += 1;
      }
    }
    try
    {
      ((JSONObject)localObject2).put("filePath", localObject3);
      if (paramJSONObject != null) {
        ((JSONObject)localObject2).put("localRules", paramJSONObject);
      }
      paramString2.put("data", localObject2);
      paramString2.put("result", 0);
      super.callJs(paramString1, new String[] { paramString2.toString() });
      if (!QLog.isColorLevel()) {
        break label356;
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("handleSignatureRequest callbackId = ");
      paramJSONObject.append(paramString1);
      paramJSONObject.append(" result = ");
      paramJSONObject.append(paramString2.toString());
      QLog.d("LocalDataJsPlugin", 2, paramJSONObject.toString());
      return;
    }
    catch (JSONException paramString2)
    {
      label228:
      break label228;
    }
    super.callJs(paramString1, new String[] { "{\"result\": -1}" });
    return;
    if (QLog.isColorLevel()) {
      QLog.d("LocalDataJsPlugin", 2, "handleSignatureRequest file not exist, start download");
    }
    Object localObject2 = ((DownloaderFactory)this.browserApp.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    paramString2 = new DownloadTask(paramString2, new File(SignatureTemplateConfig.a((String)localObject1, "temp.zip")));
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putString("callbackId", paramString1);
    ((Bundle)localObject3).putString("itemId", (String)localObject1);
    if (paramJSONObject != null) {
      ((Bundle)localObject3).putString("localRules", paramJSONObject.toString());
    }
    ((DownloaderInterface)localObject2).startDownload(paramString2, this.sigTplResDownloadListener, (Bundle)localObject3);
    label356:
  }
  
  private boolean hasInterceptRight(String paramString)
  {
    AuthorizeConfig localAuthorizeConfig = AuthorizeConfig.a();
    Object localObject = (SwiftBrowserStatistics)super.getBrowserComponent(-2);
    if (localObject == null)
    {
      QLog.e("LocalDataJsPlugin", 1, "hasInterceptRight SwiftBrowserStatistics = null");
      return false;
    }
    if (((SwiftBrowserStatistics)localObject).aK.size() > 0) {
      localObject = (String)((SwiftBrowserStatistics)localObject).aK.get(((SwiftBrowserStatistics)localObject).aK.size() - 1);
    } else {
      localObject = ((SwiftBrowserStatistics)localObject).aw;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (localAuthorizeConfig.a((String)localObject, "localData.getFileInfo"))
      {
        localObject = FILE_PATH_WHITE_LIST;
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (paramString.startsWith(localObject[i])) {
            return true;
          }
          i += 1;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hasInterceptRight file path invalid: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("LocalDataJsPlugin", 1, ((StringBuilder)localObject).toString());
        return false;
      }
      QLog.e("LocalDataJsPlugin", 1, "hasInterceptRight url has no Right");
      return false;
    }
    QLog.e("LocalDataJsPlugin", 1, "hasInterceptRight url is empty");
    return false;
  }
  
  private WebResourceResponse shouldInterceptRequest(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shouldInterceptRequest url = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("LocalDataJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("local")) {
        return null;
      }
      paramString = Uri.parse(paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.getAuthority());
      ((StringBuilder)localObject).append(paramString.getPath());
      paramString = ((StringBuilder)localObject).toString();
      if (!hasInterceptRight(paramString)) {
        return null;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("shouldInterceptRequest filePath = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("LocalDataJsPlugin", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new File(paramString);
      if (((File)localObject).exists()) {
        try
        {
          localObject = new WebResourceResponse("image/*", "UTF-8", new BufferedInputStream(new FileInputStream((File)localObject)));
          return localObject;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          QLog.e("LocalDataJsPlugin", 1, "shouldInterceptRequest error: ", localFileNotFoundException);
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("shouldInterceptRequest filePath = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" file not exists");
        QLog.d("LocalDataJsPlugin", 2, localStringBuilder.toString());
      }
    }
    return null;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8L;
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    if (paramLong == 8L) {
      return shouldInterceptRequest(paramString);
    }
    return null;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!TextUtils.isEmpty(paramString1)) && ("localData".equals(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("handleJsRequest signjs, url=");
        paramJsBridgeListener.append(paramString1);
        paramJsBridgeListener.append(", pkgName=");
        paramJsBridgeListener.append(paramString2);
        paramJsBridgeListener.append(", methodName=");
        paramJsBridgeListener.append(paramString3);
        QLog.d("LocalDataJsPlugin", 2, paramJsBridgeListener.toString());
      }
      paramVarArgs = null;
      paramJsBridgeListener = paramVarArgs;
    }
    for (;;)
    {
      try
      {
        localObject1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (localObject1 == null) {
          return true;
        }
        paramJsBridgeListener = paramVarArgs;
        Object localObject2;
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = paramVarArgs;
          localObject2 = new StringBuilder();
          paramJsBridgeListener = paramVarArgs;
          ((StringBuilder)localObject2).append("handleJsRequest JSON = ");
          paramJsBridgeListener = paramVarArgs;
          ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
          paramJsBridgeListener = paramVarArgs;
          QLog.d("LocalDataJsPlugin", 2, ((StringBuilder)localObject2).toString());
        }
        paramJsBridgeListener = paramVarArgs;
        paramVarArgs = ((JSONObject)localObject1).optString("callback");
        paramJsBridgeListener = paramVarArgs;
        if (TextUtils.isEmpty(paramVarArgs))
        {
          paramJsBridgeListener = paramVarArgs;
          QLog.e("LocalDataJsPlugin", 1, "callback id is null, so return");
          return true;
        }
        paramJsBridgeListener = paramVarArgs;
        if ("getFileInfo".equals(paramString3))
        {
          paramJsBridgeListener = paramVarArgs;
          localObject2 = ((JSONObject)localObject1).optJSONObject("localRules");
          int i = -1;
          if (localObject2 == null) {
            break label536;
          }
          paramJsBridgeListener = paramVarArgs;
          i = ((JSONObject)localObject2).optInt("appId");
          paramJsBridgeListener = paramVarArgs;
          j = ((JSONObject)localObject2).optInt("itemId");
          paramJsBridgeListener = paramVarArgs;
          localObject1 = ((JSONObject)localObject1).optString("fileUrl");
          paramJsBridgeListener = paramVarArgs;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramJsBridgeListener = paramVarArgs;
            QLog.e("LocalDataJsPlugin", 1, "handleJsRequest itemUrl is empty");
            paramJsBridgeListener = paramVarArgs;
            super.callJs(paramVarArgs, new String[] { "{\"result\": -1}" });
          }
          if (i != 9)
          {
            paramJsBridgeListener = paramVarArgs;
            super.callJs(paramVarArgs, new String[] { "{\"result\": -1}" });
            paramJsBridgeListener = paramVarArgs;
            localObject1 = new StringBuilder();
            paramJsBridgeListener = paramVarArgs;
            ((StringBuilder)localObject1).append("handleJsRequest can not handle appid ");
            paramJsBridgeListener = paramVarArgs;
            ((StringBuilder)localObject1).append(i);
            paramJsBridgeListener = paramVarArgs;
            QLog.e("LocalDataJsPlugin", 1, ((StringBuilder)localObject1).toString());
            return true;
          }
          paramJsBridgeListener = paramVarArgs;
          handleSignatureRequest(paramVarArgs, j, (String)localObject1, (JSONObject)localObject2);
          return true;
        }
      }
      catch (Exception paramVarArgs)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleJsRequest exception url=");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(", pkgName=");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(", methodName=");
        ((StringBuilder)localObject1).append(paramString3);
        ((StringBuilder)localObject1).append(", msg=");
        ((StringBuilder)localObject1).append(paramVarArgs.getMessage());
        QLog.e("LocalDataJsPlugin", 2, ((StringBuilder)localObject1).toString());
        if (!TextUtils.isEmpty(paramJsBridgeListener)) {
          super.callJs(paramJsBridgeListener, new String[] { "{\"result\": -1}" });
        }
      }
      return true;
      return false;
      label536:
      int j = -1;
    }
  }
  
  protected void onCreate()
  {
    AppInterface localAppInterface = this.mRuntime.b();
    if ((localAppInterface instanceof BrowserAppInterface))
    {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocalDataJsPlugin", 2, "ERROR!!! LocalDataJsPlugin is not running in web process!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.LocalDataJsPlugin
 * JD-Core Version:    0.7.0.1
 */