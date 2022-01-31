package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.IconListener;
import com.tencent.smtt.utils.TbsLog;
import dalvik.system.DexClassLoader;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

class X5CoreWizard
{
  private static final String TAG = "X5CoreWizard";
  private static final String WEBCOREPROXY_CLASSNAME = "com.tencent.tbs.tbsshell.WebCoreProxy";
  private DexLoader mDexLoader;
  
  public X5CoreWizard(DexLoader paramDexLoader)
  {
    this.mDexLoader = paramDexLoader;
  }
  
  public Object cacheDisabled()
  {
    return this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cacheDisabled", new Class[0], new Object[0]);
  }
  
  public boolean canOpenFile(Context paramContext, String paramString)
  {
    paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString });
    if ((paramContext instanceof Boolean)) {
      return ((Boolean)paramContext).booleanValue();
    }
    return false;
  }
  
  public boolean canUseX5()
  {
    try
    {
      Object localObject = this.mDexLoader.getClassLoader().loadClass("com.tencent.tbs.tbsshell.WebCoreProxy").getMethod("canUseX5", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = ((Method)localObject).invoke(null, new Object[0]);
      if ((localObject instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject).booleanValue();
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
    return ((Boolean)localThrowable).booleanValue();
  }
  
  public void clearAllX5Cache(Context paramContext, boolean paramBoolean)
  {
    TbsLog.w("desktop", " tbsWizard clearAllX5Cache");
    if (paramBoolean)
    {
      this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[] { Context.class }, new Object[] { paramContext });
      return;
    }
    try
    {
      this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[] { Context.class, Boolean.TYPE }, new Object[] { paramContext, Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
      this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
      this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[] { Context.class }, new Object[] { paramContext });
      this.mDexLoader.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "removeAllCacheFiles", null, new Object[0]);
      this.mDexLoader.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "clearLocalStorage", null, new Object[0]);
      paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.smtt.net.http.DnsManager", "getInstance", null, new Object[0]);
      if (paramContext != null) {
        this.mDexLoader.invokeMethod(paramContext, "com.tencent.smtt.net.http.DnsManager", "removeAllDns", null, new Object[0]);
      }
      paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.smtt.webkit.SmttPermanentPermissions", "getInstance", null, new Object[0]);
      if (paramContext != null) {
        this.mDexLoader.invokeMethod(paramContext, "com.tencent.smtt.webkit.SmttPermanentPermissions", "clearAllPermanentPermission", null, new Object[0]);
      }
      this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
    }
  }
  
  public void closeFileReader()
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
  }
  
  public void closeIconDB()
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeIconDB", null, new Object[0]);
  }
  
  public boolean cookieManager_acceptCookie()
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
    if (localObject == null) {
      return false;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public boolean cookieManager_hasCookies()
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
    if (localObject == null) {
      return false;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public void cookieManager_removeAllCookie()
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
  }
  
  public boolean cookieManager_setCookies(Map<String, String[]> paramMap)
  {
    paramMap = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new Class[] { Map.class }, new Object[] { paramMap });
    if (paramMap == null) {
      return false;
    }
    return ((Boolean)paramMap).booleanValue();
  }
  
  public IX5DateSorter createDateSorter(Context paramContext)
  {
    paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDateSorter", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null) {
      return null;
    }
    return (IX5DateSorter)paramContext;
  }
  
  public IX5WebChromeClient createDefaultX5WebChromeClient()
  {
    if (this.mDexLoader == null) {
      return null;
    }
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new Class[0], new Object[0]);
    if (localObject == null) {
      return null;
    }
    return (IX5WebChromeClient)localObject;
  }
  
  public IX5WebViewClientExtension createDefaultX5WebChromeClientExtension()
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClientExtension", new Class[0], new Object[0]);
    if (localObject == null) {
      return null;
    }
    return (IX5WebViewClientExtension)localObject;
  }
  
  public IX5WebViewClient createDefaultX5WebViewClient()
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new Class[0], new Object[0]);
    if (localObject == null) {
      return null;
    }
    return (IX5WebViewClient)localObject;
  }
  
  public Object createGameHostBridgeFakeActivity(Activity paramActivity)
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createGameHostBridgeFakeActivity", new Class[] { Activity.class }, new Object[] { paramActivity });
    paramActivity = localObject;
    if (localObject == null) {
      paramActivity = null;
    }
    return paramActivity;
  }
  
  public IX5WebViewBase createSDKWebview(Context paramContext)
  {
    Object localObject4 = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createSDKWebview", new Class[] { Context.class }, new Object[] { paramContext });
    if (localObject4 == null) {}
    try
    {
      localObject1 = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
      if ((localObject1 != null) && ((localObject1 instanceof Throwable))) {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 325, (Throwable)localObject1);
      }
      if ((localObject1 == null) || (!(localObject1 instanceof String))) {
        break label200;
      }
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 325, new Throwable((String)localObject1));
    }
    catch (Exception localException1)
    {
      try
      {
        if (localIX5WebViewBase.getView() != null) {
          break label204;
        }
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 325, new Throwable("x5webview.getView is null!"));
        localObject3 = null;
        Object localObject1 = localIX5WebViewBase;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          IX5WebViewBase localIX5WebViewBase;
          Context localContext;
          paramContext = localIX5WebViewBase;
        }
      }
      localException1 = localException1;
      paramContext = null;
    }
    localIX5WebViewBase = (IX5WebViewBase)localObject4;
    localObject1 = localIX5WebViewBase;
    Object localObject3 = localObject4;
    if (localIX5WebViewBase != null)
    {
      localObject1 = localIX5WebViewBase;
      localObject3 = localObject4;
      localException1.printStackTrace();
      localContext = paramContext;
    }
    label200:
    label204:
    for (localObject3 = localObject4; localObject3 != null; localObject3 = null)
    {
      return localContext;
      Object localObject2 = null;
    }
    return null;
  }
  
  public DexLoader dexLoader()
  {
    return this.mDexLoader;
  }
  
  public void geolocationPermissionsAllow(String paramString)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsAllow", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public void geolocationPermissionsClear(String paramString)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClear", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public void geolocationPermissionsClearAll()
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClearAll", null, new Object[0]);
  }
  
  public void geolocationPermissionsGetAllowed(String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetAllowed", new Class[] { String.class, ValueCallback.class }, new Object[] { paramString, paramValueCallback });
  }
  
  public void geolocationPermissionsGetOrigins(ValueCallback<Set<String>> paramValueCallback)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetOrigins", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  public Object getCachFileBaseDir()
  {
    return this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCachFileBaseDir", new Class[0], new Object[0]);
  }
  
  public InputStream getCacheFile(String paramString, boolean paramBoolean)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCacheFile", new Class[] { String.class, Boolean.TYPE }, new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (paramString == null) {
      return null;
    }
    return (InputStream)paramString;
  }
  
  public String getCookie(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return null;
    }
    return (String)paramString;
  }
  
  public String getDefaultUserAgent(Context paramContext)
  {
    paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getDefaultUserAgent", new Class[] { Context.class }, new Object[] { paramContext });
    if ((paramContext instanceof String)) {
      return (String)paramContext;
    }
    return null;
  }
  
  public Bitmap getIconForPageUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return null;
    }
    return (Bitmap)paramString;
  }
  
  public String getMiniQBVersion()
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getMiniQBVersion", new Class[0], new Object[0]);
    if (localObject == null) {
      return null;
    }
    return (String)localObject;
  }
  
  public String mimeTypeMapGetExtensionFromMimeType(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return null;
    }
    return (String)paramString;
  }
  
  public String mimeTypeMapGetFileExtensionFromUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetFileExtensionFromUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return null;
    }
    return (String)paramString;
  }
  
  public String mimeTypeMapGetMimeTypeFromExtension(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return null;
    }
    return (String)paramString;
  }
  
  public boolean mimeTypeMapHasExtension(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasExtension", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean mimeTypeMapHasMimeType(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasMimeType", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public void openIconDB(String paramString)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "openIconDB", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public Uri[] parseFileChooserResult(int paramInt, Intent paramIntent)
  {
    paramIntent = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "parseFileChooserResult", new Class[] { Integer.TYPE, Intent.class }, new Object[] { Integer.valueOf(paramInt), paramIntent });
    if (paramIntent == null) {
      return null;
    }
    return (Uri[])paramIntent;
  }
  
  public void releaseIconForPageUrl(String paramString)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "releaseIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public void removeAllIcons()
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
  }
  
  public void requestIconForPageUrl(String paramString, IconListener paramIconListener)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "requestIconForPageUrl", new Class[] { String.class, IconListener.class }, new Object[] { paramString, paramIconListener });
  }
  
  public void retainIconForPageUrl(String paramString)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "retainIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public int startMiniQB(Context paramContext, String paramString1, Map<String, String> paramMap, String paramString2)
  {
    return startMiniQB(paramContext, paramString1, paramMap, paramString2, null);
  }
  
  public int startMiniQB(Context paramContext, String paramString1, Map<String, String> paramMap, String paramString2, ValueCallback<String> paramValueCallback)
  {
    if (TbsDownloader.getOverSea(paramContext)) {
      return -103;
    }
    if (paramString2 == null)
    {
      paramValueCallback = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class, Map.class, ValueCallback.class }, new Object[] { paramContext, paramString1, paramMap, paramValueCallback });
      paramString2 = paramValueCallback;
      if (paramValueCallback == null) {
        paramString2 = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class, Map.class }, new Object[] { paramContext, paramString1, paramMap });
      }
      paramMap = paramString2;
      if (paramString2 == null) {
        paramMap = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString1 });
      }
      if (paramMap == null) {
        return -104;
      }
      return ((Integer)paramMap).intValue();
    }
    paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class, String.class }, new Object[] { paramContext, paramString1, paramString2 });
    if (paramContext == null) {
      return -104;
    }
    return ((Integer)paramContext).intValue();
  }
  
  public String urlUtilComposeSearchUrl(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilComposeSearchUrl", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
    if (paramString1 == null) {
      return null;
    }
    return (String)paramString1;
  }
  
  public byte[] urlUtilDecode(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilDecode", new Class[] { String.class }, new Object[] { paramArrayOfByte });
    if (paramArrayOfByte == null) {
      return null;
    }
    return (byte[])paramArrayOfByte;
  }
  
  public String urlUtilGuessFileName(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessFileName", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
    if (paramString1 == null) {
      return null;
    }
    return (String)paramString1;
  }
  
  public String urlUtilGuessUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return null;
    }
    return (String)paramString;
  }
  
  public boolean urlUtilIsAboutUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAboutUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsAssetUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAssetUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsContentUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsContentUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsCookielessProxyUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsCookielessProxyUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsDataUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsDataUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsFileUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsFileUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsHttpUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsHttpsUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpsUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsJavaScriptUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsJavaScriptUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsNetworkUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsNetworkUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsValidUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsValidUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public String urlUtilStripAnchor(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilStripAnchor", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return null;
    }
    return (String)paramString;
  }
  
  public void webStorageDeleteAllData()
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteAllData", null, new Object[0]);
  }
  
  public void webStorageDeleteOrigin(String paramString)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteOrigin", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public void webStorageGetOrigins(ValueCallback<Map> paramValueCallback)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetOrigins", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  public void webStorageGetQuotaForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetQuotaForOrigin", new Class[] { String.class, ValueCallback.class }, new Object[] { paramString, paramValueCallback });
  }
  
  public void webStorageGetUsageForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetUsageForOrigin", new Class[] { String.class, ValueCallback.class }, new Object[] { paramString, paramValueCallback });
  }
  
  public void webStorageSetQuotaForOrigin(String paramString, long paramLong)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageSetQuotaForOrigin", new Class[] { String.class, Long.TYPE }, new Object[] { paramString, Long.valueOf(paramLong) });
  }
  
  public void webViewDatabaseClearFormData(Context paramContext)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[] { Context.class }, new Object[] { paramContext });
  }
  
  public void webViewDatabaseClearHttpAuthUsernamePassword(Context paramContext)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
  }
  
  public void webViewDatabaseClearUsernamePassword(Context paramContext)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
  }
  
  public boolean webViewDatabaseHasFormData(Context paramContext)
  {
    paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasFormData", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null) {
      return false;
    }
    return ((Boolean)paramContext).booleanValue();
  }
  
  public boolean webViewDatabaseHasHttpAuthUsernamePassword(Context paramContext)
  {
    paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasHttpAuthUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null) {
      return false;
    }
    return ((Boolean)paramContext).booleanValue();
  }
  
  public boolean webViewDatabaseHasUsernamePassword(Context paramContext)
  {
    paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null) {
      return false;
    }
    return ((Boolean)paramContext).booleanValue();
  }
  
  public void webview_setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webview_setWebContentsDebuggingEnabled", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.X5CoreWizard
 * JD-Core Version:    0.7.0.1
 */