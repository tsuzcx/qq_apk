package com.tencent.mobileqq.vaswebviewplugin;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BrowserAppInterface;
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
  private static final String[] FILE_PATH_WHITE_LIST = { AppConstants.bx };
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
    if ((!localFile.exists()) || (!localFile.isDirectory())) {}
    while (FileUtils.a(paramString).size() <= 0) {
      return false;
    }
    return true;
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
      try
      {
        ((JSONObject)localObject2).put("filePath", localObject3);
        if (paramJSONObject != null) {
          ((JSONObject)localObject2).put("localRules", paramJSONObject);
        }
        paramString2.put("data", localObject2);
        paramString2.put("result", 0);
        super.callJs(paramString1, new String[] { paramString2.toString() });
        if (QLog.isColorLevel()) {
          QLog.d("LocalDataJsPlugin", 2, "handleSignatureRequest callbackId = " + paramString1 + " result = " + paramString2.toString());
        }
        return;
      }
      catch (JSONException paramString2)
      {
        super.callJs(paramString1, new String[] { "{\"result\": -1}" });
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocalDataJsPlugin", 2, "handleSignatureRequest file not exist, start download");
    }
    Object localObject2 = ((DownloaderFactory)this.browserApp.getManager(46)).a(1);
    paramString2 = new DownloadTask(paramString2, new File(SignatureTemplateConfig.a((String)localObject1, "temp.zip")));
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putString("callbackId", paramString1);
    ((Bundle)localObject3).putString("itemId", (String)localObject1);
    if (paramJSONObject != null) {
      ((Bundle)localObject3).putString("localRules", paramJSONObject.toString());
    }
    ((DownloaderInterface)localObject2).a(paramString2, this.sigTplResDownloadListener, (Bundle)localObject3);
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
    int j;
    int i;
    if (((SwiftBrowserStatistics)localObject).a.size() > 0)
    {
      localObject = (String)((SwiftBrowserStatistics)localObject).a.get(((SwiftBrowserStatistics)localObject).a.size() - 1);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label174;
      }
      if (localAuthorizeConfig.a((String)localObject, "localData.getFileInfo"))
      {
        localObject = FILE_PATH_WHITE_LIST;
        j = localObject.length;
        i = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (i >= j) {
          break label137;
        }
        if (paramString.startsWith(localObject[i]))
        {
          return true;
          localObject = ((SwiftBrowserStatistics)localObject).b;
          break;
        }
        i += 1;
      }
      label137:
      QLog.e("LocalDataJsPlugin", 1, "hasInterceptRight file path invalid: " + paramString);
    }
    for (;;)
    {
      return false;
      QLog.e("LocalDataJsPlugin", 1, "hasInterceptRight url has no Right");
      return false;
      label174:
      QLog.e("LocalDataJsPlugin", 1, "hasInterceptRight url is empty");
    }
  }
  
  private WebResourceResponse shouldInterceptRequest(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocalDataJsPlugin", 2, "shouldInterceptRequest url = " + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("local"))) {}
    do
    {
      do
      {
        return null;
        paramString = Uri.parse(paramString);
        paramString = paramString.getAuthority() + paramString.getPath();
      } while (!hasInterceptRight(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("LocalDataJsPlugin", 2, "shouldInterceptRequest filePath = " + paramString);
      }
      Object localObject = new File(paramString);
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
    } while (!QLog.isColorLevel());
    QLog.d("LocalDataJsPlugin", 2, "shouldInterceptRequest filePath = " + paramString + " file not exists");
    return null;
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
    if ((TextUtils.isEmpty(paramString1)) || (!"localData".equals(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocalDataJsPlugin", 2, "handleJsRequest signjs, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    paramVarArgs = null;
    paramJsBridgeListener = paramVarArgs;
    try
    {
      localObject = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (localObject == null) {
        return true;
      }
      paramJsBridgeListener = paramVarArgs;
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = paramVarArgs;
        QLog.d("LocalDataJsPlugin", 2, "handleJsRequest JSON = " + ((JSONObject)localObject).toString());
      }
      paramJsBridgeListener = paramVarArgs;
      paramVarArgs = ((JSONObject)localObject).optString("callback");
      paramJsBridgeListener = paramVarArgs;
      if (TextUtils.isEmpty(paramVarArgs))
      {
        paramJsBridgeListener = paramVarArgs;
        QLog.e("LocalDataJsPlugin", 1, "callback id is null, so return");
        return true;
      }
      paramJsBridgeListener = paramVarArgs;
      if (!"getFileInfo".equals(paramString3)) {
        break label475;
      }
      paramJsBridgeListener = paramVarArgs;
      localJSONObject = ((JSONObject)localObject).optJSONObject("localRules");
      j = -1;
      i = -1;
      if (localJSONObject != null)
      {
        paramJsBridgeListener = paramVarArgs;
        j = localJSONObject.optInt("appId");
        paramJsBridgeListener = paramVarArgs;
        i = localJSONObject.optInt("itemId");
      }
      paramJsBridgeListener = paramVarArgs;
      localObject = ((JSONObject)localObject).optString("fileUrl");
      paramJsBridgeListener = paramVarArgs;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label453;
      }
      paramJsBridgeListener = paramVarArgs;
      QLog.e("LocalDataJsPlugin", 1, "handleJsRequest itemUrl is empty");
      paramJsBridgeListener = paramVarArgs;
      super.callJs(paramVarArgs, new String[] { "{\"result\": -1}" });
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        Object localObject;
        JSONObject localJSONObject;
        int j;
        int i;
        QLog.e("LocalDataJsPlugin", 2, "handleJsRequest exception url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3 + ", msg=" + paramVarArgs.getMessage());
        if (TextUtils.isEmpty(paramJsBridgeListener)) {
          break;
        }
        super.callJs(paramJsBridgeListener, new String[] { "{\"result\": -1}" });
        break;
        switch (j)
        {
        }
      }
    }
    paramJsBridgeListener = paramVarArgs;
    super.callJs(paramVarArgs, new String[] { "{\"result\": -1}" });
    paramJsBridgeListener = paramVarArgs;
    QLog.e("LocalDataJsPlugin", 1, "handleJsRequest can not handle appid " + j);
    break label475;
    paramJsBridgeListener = paramVarArgs;
    handleSignatureRequest(paramVarArgs, i, (String)localObject, localJSONObject);
    label453:
    label475:
    return true;
  }
  
  protected void onCreate()
  {
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("LocalDataJsPlugin", 2, "ERROR!!! LocalDataJsPlugin is not running in web process!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.LocalDataJsPlugin
 * JD-Core Version:    0.7.0.1
 */