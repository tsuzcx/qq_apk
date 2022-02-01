package com.tencent.tmassistantsdk.internal.openSDK;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantsdk.ITMAssistantCallBackListener;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import com.tencent.tmassistantsdk.internal.a.b;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

public abstract class TMAssistantBaseCallYYB
{
  protected static final String TAG = "TMAssistantBaseCallYYB";
  public String hostPackageName = null;
  protected int hostVersionCode = 0;
  protected String mClientKey;
  protected Context mContext = null;
  protected ReferenceQueue<ITMAssistantCallBackListener> mListenerQueue = new ReferenceQueue();
  protected List<WeakReference<ITMAssistantCallBackListener>> mWeakListenerArrayList = new CopyOnWriteArrayList();
  protected int sdkAPILevel = 1;
  protected b sdkChannel = new b();
  
  public static int getQQDownloadApiLevel(Context paramContext)
  {
    if (paramContext == null)
    {
      ab.e("TMAssistantBaseCallYYB", "context is null,return 0");
      return 0;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        int i = paramContext.metaData.getInt("com.tencent.android.qqdownloader.sdk.apilevel");
        ab.c("TMAssistantBaseCallYYB", "apiLevel = " + i);
        return i;
      }
      ab.c("TMAssistantBaseCallYYB", "appInfo is null,return 0");
      return 0;
    }
    catch (Exception paramContext)
    {
      ab.c("TMAssistantBaseCallYYB", "packagename not found！");
    }
    return 0;
  }
  
  public static boolean isExistActoin(long paramLong)
  {
    if (paramLong < 0L)
    {
      ab.c("TMAssistantBaseCallYYB", "actionId < 0,return false");
      return false;
    }
    ab.c("TMAssistantBaseCallYYB", "actionId = " + paramLong);
    Object localObject = new b().a();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.tmassistantsdk.internal.a.c localc = (com.tencent.tmassistantsdk.internal.a.c)((Iterator)localObject).next();
        if ((localc.a == paramLong) && (localc.h - localc.g <= 300000L))
        {
          ab.c("TMAssistantBaseCallYYB", "actionId is exist,return true");
          return true;
        }
      }
    }
    ab.c("TMAssistantBaseCallYYB", "return false");
    return false;
  }
  
  public abstract long addDownloadTaskFromAppDetail(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract long addDownloadTaskFromAuthorize(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, String paramString);
  
  public abstract long addDownloadTaskFromTaskList(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2);
  
  public long addDownloadTaskFromTmast(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("url");
    ab.c("TMAssistantBaseCallYYB", "addDownloadTaskFromTmast url = " + str1);
    if (TextUtils.isEmpty(str1))
    {
      ab.c("TMAssistantBaseCallYYB", "url is null !! result = -1");
      return -1L;
    }
    String str2 = formatEncryptUrl(str1);
    long l5 = System.currentTimeMillis();
    long l6 = l5 + 300000L;
    long l3 = paramBundle.getLong("startTime");
    long l4 = paramBundle.getLong("endTime");
    long l2 = l5;
    long l1 = l6;
    if (l3 != 0L)
    {
      l2 = l5;
      l1 = l6;
      if (l4 != 0L)
      {
        l1 = l4;
        l2 = l3;
      }
    }
    ab.c("TMAssistantBaseCallYYB", "addDownloadTaskFromTmast " + l2 + "|" + l1 + ",from bundle:" + l3 + "|" + l4);
    ab.c("TMAssistantBaseCallYYB", "addDownloadTaskFromTmast,hostPackageName=" + this.hostPackageName + "; hostVersionCode=" + this.hostVersionCode + "; hostUserIdentity=" + "" + "; dataItemType=" + 0 + ";dataItemAction=" + str2);
    l3 = this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, str2, l2, l1, 0, null);
    ab.c("TMAssistantBaseCallYYB", "result = " + l3);
    GlobalUtil.setClipboardCMD(this.mContext, str1, l2, l1);
    return l3;
  }
  
  public long addDownloadTaskFromWebview(Bundle paramBundle)
  {
    String str = paramBundle.getString("url");
    ab.c("TMAssistantBaseCallYYB", "url = " + str);
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", str);
    str = formatIntentUriPath(5, localHashMap);
    long l5 = System.currentTimeMillis();
    long l6 = l5 + 300000L;
    long l3 = paramBundle.getLong("startTime");
    long l4 = paramBundle.getLong("endTime");
    long l2 = l5;
    long l1 = l6;
    if (l3 != 0L)
    {
      l2 = l5;
      l1 = l6;
      if (l4 != 0L)
      {
        l1 = l4;
        l2 = l3;
      }
    }
    ab.c("TMAssistantBaseCallYYB", "addDownloadTaskFromTmast " + l2 + "|" + l1 + ",from bundle:" + l3 + "|" + l4);
    ab.c("TMAssistantBaseCallYYB", "addDownloadTaskFromTaskList,hostPackageName=" + this.hostPackageName + "; hostVersionCode=" + this.hostVersionCode + "; hostUserIdentity=" + "" + "; dataItemType=" + 0 + ";dataItemAction=" + str);
    l3 = this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, str, l2, l1, 0, null);
    ab.c("TMAssistantBaseCallYYB", "result = " + l3);
    paramBundle = formatIntentUriPath(5, localHashMap, false);
    GlobalUtil.setClipboardCMD(this.mContext, paramBundle, l2, l1);
    return l3;
  }
  
  public long buildAddDBData(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ab.c("TMAssistantBaseCallYYB", "param = " + paramTMAssistantCallYYBParamStruct + ",isAutoDownload = " + paramBoolean1 + ",isAutoInstall = " + paramBoolean2 + ",actionFlag = " + paramString1 + ",verifyType = " + paramString2 + ",actionType = " + paramInt);
    if (TextUtils.isEmpty(paramString2)) {
      paramTMAssistantCallYYBParamStruct = formatMapParams(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, paramString3);
    }
    for (;;)
    {
      paramString1 = formatIntentUriPath(paramInt, paramTMAssistantCallYYBParamStruct);
      long l1 = System.currentTimeMillis();
      long l2 = l1 + 300000L;
      ab.c("TMAssistantBaseCallYYB", "addDownloadTaskFromTaskList,hostPackageName=" + this.hostPackageName + "; hostVersionCode=" + this.hostVersionCode + "; hostUserIdentity=" + "" + "; dataItemType=" + 0 + ";dataItemAction=" + paramString1);
      long l3 = this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, paramString1, l1, l2, 0, null);
      ab.c("TMAssistantBaseCallYYB", "result = " + l3);
      paramTMAssistantCallYYBParamStruct = formatIntentUriPath(paramInt, paramTMAssistantCallYYBParamStruct, false);
      GlobalUtil.setClipboardCMD(this.mContext, paramTMAssistantCallYYBParamStruct, l1, l2);
      return l3;
      paramTMAssistantCallYYBParamStruct = formatMapParams(paramTMAssistantCallYYBParamStruct, true, true, paramString3);
      paramTMAssistantCallYYBParamStruct.put("verifytype", paramString2);
    }
  }
  
  protected long buildAddDBData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      ab.c("TMAssistantBaseCallYYB", "IPCData is null,return -1");
      return -1L;
    }
    ab.c("TMAssistantBaseCallYYB", "IPCData length = " + paramArrayOfByte.length);
    long l = System.currentTimeMillis();
    l = this.sdkChannel.a(null, 0, null, 0, null, l, l + 300000L, 1, paramArrayOfByte);
    ab.c("TMAssistantBaseCallYYB", "result = " + l);
    return l;
  }
  
  public int checkQQDownloaderInstalled()
  {
    j = 1;
    int k = 0;
    if (this.mContext == null)
    {
      ab.e("TMAssistantBaseCallYYB", "mContext is null");
      throw new Exception("you must initial openSDK,by calling initQQDownloaderOpenSDK method!");
    }
    ab.c("TMAssistantBaseCallYYB", "checkQQDownloaderInstalled start");
    PackageManager localPackageManager = this.mContext.getPackageManager();
    i = j;
    if (localPackageManager != null) {}
    for (;;)
    {
      try
      {
        if (localPackageManager.getPackageInfo("com.tencent.android.qqdownloader", 0) == null) {
          continue;
        }
        int m = GlobalUtil.getInstance().getQQDownloaderAPILevel();
        int n = this.sdkAPILevel;
        i = k;
        if (n > m) {
          i = 2;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        ab.c("TMAssistantBaseCallYYB", "packagename not found！");
        i = j;
        continue;
      }
      ab.c("TMAssistantBaseCallYYB", "result = " + i);
      return i;
      i = 1;
    }
  }
  
  public int checkQQDownloaderInstalled(int paramInt)
  {
    int j = 2;
    k = 1;
    if (this.mContext == null)
    {
      ab.e("TMAssistantBaseCallYYB", "mContext is null");
      throw new Exception("you must initial openSDK,by calling initQQDownloaderOpenSDK method!");
    }
    PackageManager localPackageManager = this.mContext.getPackageManager();
    i = k;
    if (localPackageManager != null) {}
    for (;;)
    {
      try
      {
        if (localPackageManager.getPackageInfo("com.tencent.android.qqdownloader", 0) == null) {
          continue;
        }
        m = GlobalUtil.getInstance().getQQDownloaderVersionCode();
        i = GlobalUtil.getInstance().getQQDownloaderAPILevel();
        int n = this.sdkAPILevel;
        if (n <= i) {
          continue;
        }
        i = j;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        int m;
        localNameNotFoundException.printStackTrace();
        i = k;
        continue;
      }
      ab.c("TMAssistantBaseCallYYB", "result = " + i);
      return i;
      i = j;
      if (paramInt <= m)
      {
        i = 0;
        continue;
        i = 1;
      }
    }
  }
  
  public abstract void destroyQQDownloaderOpenSDK();
  
  protected String formatEncryptUrl(String paramString)
  {
    ab.c("TMAssistantBaseCallYYB", "url = " + paramString);
    paramString = URLEncoder.encode(c.a(paramString));
    paramString = "tmast://encrypt?encryptdata=" + paramString;
    ab.c("TMAssistantBaseCallYYB", "finalPath = " + paramString);
    return paramString;
  }
  
  protected String formatIntentUriPath(int paramInt, Map<String, String> paramMap)
  {
    return formatIntentUriPath(paramInt, paramMap, true);
  }
  
  protected String formatIntentUriPath(int paramInt, Map<String, String> paramMap, boolean paramBoolean)
  {
    ab.c("TMAssistantBaseCallYYB", "actionType = " + paramInt + ",params = " + paramMap);
    Object localObject;
    String str2;
    switch (paramInt)
    {
    default: 
      localObject = "appdetails";
      str2 = "tpmast://" + (String)localObject + "?";
      String str1 = "";
      localObject = str1;
      if (paramMap != null)
      {
        localObject = str1;
        if (paramMap.size() > 0)
        {
          Iterator localIterator = paramMap.entrySet().iterator();
          paramInt = 0;
          paramMap = str1;
          label153:
          localObject = paramMap;
          if (localIterator.hasNext())
          {
            localObject = (Map.Entry)localIterator.next();
            str1 = (String)((Map.Entry)localObject).getKey();
            String str3 = (String)((Map.Entry)localObject).getValue();
            if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str3))) {
              break label392;
            }
            if (paramInt <= 0)
            {
              localObject = "";
              label226:
              paramMap = paramMap + (String)localObject + str1 + "=" + URLEncoder.encode(str3);
            }
          }
        }
      }
      break;
    }
    label392:
    for (;;)
    {
      paramInt += 1;
      break label153;
      localObject = "appdetails";
      break;
      localObject = "download";
      break;
      localObject = "appdetails";
      break;
      localObject = "updatedownload";
      break;
      localObject = "webview";
      break;
      localObject = "downloadmanager";
      break;
      localObject = "&";
      break label226;
      localObject = str2 + (String)localObject;
      ab.c("TMAssistantBaseCallYYB", ">formatIntentUriPath " + (String)localObject);
      paramMap = (Map<String, String>)localObject;
      if (paramBoolean) {
        paramMap = formatEncryptUrl((String)localObject);
      }
      return paramMap;
    }
  }
  
  protected Map<String, String> formatMapParams(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    ab.c("TMAssistantBaseCallYYB", "param = " + paramTMAssistantCallYYBParamStruct + ",isAutoDownload = " + paramBoolean1 + ",isAutoInstall = " + paramBoolean2);
    Object localObject = formatOplist(paramBoolean1, paramBoolean2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("hostpname", this.hostPackageName);
    localHashMap.put("hostversioncode", String.valueOf(this.hostVersionCode));
    localHashMap.put("sngappid", paramTMAssistantCallYYBParamStruct.SNGAppId);
    localHashMap.put("appid", paramTMAssistantCallYYBParamStruct.taskAppId);
    localHashMap.put("apkid", paramTMAssistantCallYYBParamStruct.taskApkId);
    localHashMap.put("pname", paramTMAssistantCallYYBParamStruct.taskPackageName);
    localHashMap.put("via", paramTMAssistantCallYYBParamStruct.via);
    localHashMap.put("uin", paramTMAssistantCallYYBParamStruct.uin);
    localHashMap.put("uintype", paramTMAssistantCallYYBParamStruct.uinType);
    localHashMap.put("versioncode", String.valueOf(paramTMAssistantCallYYBParamStruct.taskVersion));
    localHashMap.put("oplist", localObject);
    localHashMap.put("channelid", paramTMAssistantCallYYBParamStruct.channelId);
    localHashMap.put("actionflag", paramTMAssistantCallYYBParamStruct.actionFlag);
    localHashMap.put("traceid", paramString);
    localHashMap.put("recommendId", paramTMAssistantCallYYBParamStruct.recommendId);
    paramString = new JSONObject();
    localObject = paramTMAssistantCallYYBParamStruct.timePointMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      try
      {
        paramString.put(str, paramTMAssistantCallYYBParamStruct.timePointMap.get(str));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    localHashMap.put("timePoints", paramString.toString());
    ab.c("TMAssistantBaseCallYYB", "mapParams = " + localHashMap);
    return localHashMap;
  }
  
  protected String formatOplist(boolean paramBoolean1, boolean paramBoolean2)
  {
    ab.c("TMAssistantBaseCallYYB", "isAutoDownload = " + paramBoolean1 + ",isAutoInstall = " + paramBoolean2);
    String str = "";
    if ((paramBoolean1) && (paramBoolean2)) {
      str = "1;2";
    }
    for (;;)
    {
      ab.c("TMAssistantBaseCallYYB", "oplist = " + str);
      return str;
      if (paramBoolean2) {
        str = "2";
      } else if (paramBoolean1) {
        str = "1";
      }
    }
  }
  
  public abstract TMAssistantCallYYBTaskInfo getDownloadTaskState(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct);
  
  public abstract void initTMAssistantCallYYBApi(Context paramContext);
  
  protected void onStateChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString)
  {
    ab.c("TMAssistantBaseCallYYB", "param = " + paramTMAssistantCallYYBParamStruct + ",state = " + paramInt1 + ",errorCode = " + paramInt2 + ",errorMsg = " + paramString);
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext())
    {
      ITMAssistantCallBackListener localITMAssistantCallBackListener = (ITMAssistantCallBackListener)((WeakReference)localIterator.next()).get();
      if (localITMAssistantCallBackListener == null) {
        ab.c("TMAssistantBaseCallYYB", "onDownloadStateChanged listener = null");
      } else {
        localITMAssistantCallBackListener.onDownloadTaskStateChanged(paramTMAssistantCallYYBParamStruct, paramInt1, paramInt2, paramString);
      }
    }
  }
  
  public boolean registerListener(ITMAssistantCallBackListener paramITMAssistantCallBackListener)
  {
    if (paramITMAssistantCallBackListener == null)
    {
      ab.e("TMAssistantBaseCallYYB", "listener is null,return false");
      return false;
    }
    ab.c("TMAssistantBaseCallYYB", "listener = " + paramITMAssistantCallBackListener);
    for (;;)
    {
      localObject = this.mListenerQueue.poll();
      if (localObject == null) {
        break;
      }
      this.mWeakListenerArrayList.remove(localObject);
    }
    Object localObject = this.mWeakListenerArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((ITMAssistantCallBackListener)((WeakReference)((Iterator)localObject).next()).get() == paramITMAssistantCallBackListener)
      {
        ab.c("TMAssistantBaseCallYYB", "listener is existing,return true");
        return true;
      }
    }
    paramITMAssistantCallBackListener = new WeakReference(paramITMAssistantCallBackListener, this.mListenerQueue);
    this.mWeakListenerArrayList.add(paramITMAssistantCallBackListener);
    ab.c("TMAssistantBaseCallYYB", "create new listener,return true");
    return true;
  }
  
  public boolean removeDownloadTask(long paramLong)
  {
    if (paramLong >= 0L) {
      return this.sdkChannel.a(paramLong);
    }
    return false;
  }
  
  public void setQQGameClientKey(String paramString)
  {
    ab.c("jimluo", "setQQGameClientKey clientKey = " + paramString);
    this.mClientKey = paramString;
  }
  
  public void startQQDownloader(Context paramContext)
  {
    ab.c("TMAssistantBaseCallYYB", "context = " + paramContext);
    if (paramContext != null)
    {
      Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage("com.tencent.android.qqdownloader");
      if ((paramContext instanceof Application)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
    }
  }
  
  public abstract void startToAuthorized(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, String paramString);
  
  public void startToDownloadTaskList(Context paramContext)
  {
    if (paramContext == null)
    {
      ab.e("TMAssistantBaseCallYYB", "context is null,return 0");
      throw new Exception("you must input an application or activity context!");
    }
    Object localObject = "tmast://download?hostpname=" + this.hostPackageName + "&hostversion=" + this.hostVersionCode;
    ab.c("TMAssistantBaseCallYYB", "path = " + (String)localObject);
    localObject = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
    if ((paramContext instanceof Application)) {
      ((Intent)localObject).addFlags(268435456);
    }
    paramContext.startActivity((Intent)localObject);
  }
  
  public void startToDownloadTaskListWithParams(Context paramContext, Bundle paramBundle)
  {
    if (paramContext == null)
    {
      ab.e("TMAssistantBaseCallYYB", "context is null,return 0");
      throw new Exception("you must input an application or activity context!");
    }
    StringBuilder localStringBuilder = new StringBuilder("tmast://download?hostpname=" + this.hostPackageName + "&hostversion=" + this.hostVersionCode);
    if (paramBundle != null)
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("&").append(str).append("=").append(paramBundle.getString(str));
      }
    }
    paramBundle = localStringBuilder.toString();
    ab.c("TMAssistantBaseCallYYB", "startToDownloadTaskListWithParams path = " + paramBundle);
    paramBundle = new Intent("android.intent.action.VIEW", Uri.parse(paramBundle));
    if ((paramContext instanceof Application)) {
      paramBundle.addFlags(268435456);
    }
    paramContext.startActivity(paramBundle);
  }
  
  public abstract void startToWebView(Context paramContext, String paramString);
  
  public boolean unregisterListener(ITMAssistantCallBackListener paramITMAssistantCallBackListener)
  {
    if (paramITMAssistantCallBackListener == null)
    {
      ab.e("TMAssistantBaseCallYYB", "listener is null,return false");
      return false;
    }
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext()) {
      if ((ITMAssistantCallBackListener)((WeakReference)localIterator.next()).get() == paramITMAssistantCallBackListener)
      {
        localIterator.remove();
        ab.c("TMAssistantBaseCallYYB", "listener is removed,return true");
        return true;
      }
    }
    ab.c("TMAssistantBaseCallYYB", "return false");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
 * JD-Core Version:    0.7.0.1
 */