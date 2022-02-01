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
        paramContext = new StringBuilder();
        paramContext.append("apiLevel = ");
        paramContext.append(i);
        ab.c("TMAssistantBaseCallYYB", paramContext.toString());
        return i;
      }
      ab.c("TMAssistantBaseCallYYB", "appInfo is null,return 0");
      return 0;
    }
    catch (Exception paramContext)
    {
      label88:
      break label88;
    }
    ab.c("TMAssistantBaseCallYYB", "packagename not found！");
    return 0;
  }
  
  public static boolean isExistActoin(long paramLong)
  {
    if (paramLong < 0L)
    {
      ab.c("TMAssistantBaseCallYYB", "actionId < 0,return false");
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("actionId = ");
    ((StringBuilder)localObject).append(paramLong);
    ab.c("TMAssistantBaseCallYYB", ((StringBuilder)localObject).toString());
    localObject = new b().a();
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
    String str = paramBundle.getString("url");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addDownloadTaskFromTmast url = ");
    ((StringBuilder)localObject).append(str);
    ab.c("TMAssistantBaseCallYYB", ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(str))
    {
      ab.c("TMAssistantBaseCallYYB", "url is null !! result = -1");
      return -1L;
    }
    localObject = formatEncryptUrl(str);
    long l1 = System.currentTimeMillis();
    long l3 = paramBundle.getLong("startTime");
    long l4 = paramBundle.getLong("endTime");
    long l2;
    if ((l3 != 0L) && (l4 != 0L))
    {
      l1 = l4;
      l2 = l3;
    }
    else
    {
      l2 = l1;
      l1 = 300000L + l1;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("addDownloadTaskFromTmast ");
    paramBundle.append(l2);
    paramBundle.append("|");
    paramBundle.append(l1);
    paramBundle.append(",from bundle:");
    paramBundle.append(l3);
    paramBundle.append("|");
    paramBundle.append(l4);
    ab.c("TMAssistantBaseCallYYB", paramBundle.toString());
    paramBundle = new StringBuilder();
    paramBundle.append("addDownloadTaskFromTmast,hostPackageName=");
    paramBundle.append(this.hostPackageName);
    paramBundle.append("; hostVersionCode=");
    paramBundle.append(this.hostVersionCode);
    paramBundle.append("; hostUserIdentity=");
    paramBundle.append("");
    paramBundle.append("; dataItemType=");
    paramBundle.append(0);
    paramBundle.append(";dataItemAction=");
    paramBundle.append((String)localObject);
    ab.c("TMAssistantBaseCallYYB", paramBundle.toString());
    l3 = this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, (String)localObject, l2, l1, 0, null);
    paramBundle = new StringBuilder();
    paramBundle.append("result = ");
    paramBundle.append(l3);
    ab.c("TMAssistantBaseCallYYB", paramBundle.toString());
    GlobalUtil.setClipboardCMD(this.mContext, str, l2, l1);
    return l3;
  }
  
  public long addDownloadTaskFromWebview(Bundle paramBundle)
  {
    String str = paramBundle.getString("url");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("url = ");
    ((StringBuilder)localObject).append(str);
    ab.c("TMAssistantBaseCallYYB", ((StringBuilder)localObject).toString());
    localObject = new HashMap();
    ((Map)localObject).put("url", str);
    str = formatIntentUriPath(5, (Map)localObject);
    long l2 = System.currentTimeMillis();
    long l3 = paramBundle.getLong("startTime");
    long l4 = paramBundle.getLong("endTime");
    long l1;
    if ((l3 != 0L) && (l4 != 0L))
    {
      l2 = l3;
      l1 = l4;
    }
    else
    {
      l1 = 300000L + l2;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("addDownloadTaskFromTmast ");
    paramBundle.append(l2);
    paramBundle.append("|");
    paramBundle.append(l1);
    paramBundle.append(",from bundle:");
    paramBundle.append(l3);
    paramBundle.append("|");
    paramBundle.append(l4);
    ab.c("TMAssistantBaseCallYYB", paramBundle.toString());
    paramBundle = new StringBuilder();
    paramBundle.append("addDownloadTaskFromTaskList,hostPackageName=");
    paramBundle.append(this.hostPackageName);
    paramBundle.append("; hostVersionCode=");
    paramBundle.append(this.hostVersionCode);
    paramBundle.append("; hostUserIdentity=");
    paramBundle.append("");
    paramBundle.append("; dataItemType=");
    paramBundle.append(0);
    paramBundle.append(";dataItemAction=");
    paramBundle.append(str);
    ab.c("TMAssistantBaseCallYYB", paramBundle.toString());
    l3 = this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, str, l2, l1, 0, null);
    paramBundle = new StringBuilder();
    paramBundle.append("result = ");
    paramBundle.append(l3);
    ab.c("TMAssistantBaseCallYYB", paramBundle.toString());
    paramBundle = formatIntentUriPath(5, (Map)localObject, false);
    GlobalUtil.setClipboardCMD(this.mContext, paramBundle, l2, l1);
    return l3;
  }
  
  public long buildAddDBData(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("param = ");
    localStringBuilder.append(paramTMAssistantCallYYBParamStruct);
    localStringBuilder.append(",isAutoDownload = ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(",isAutoInstall = ");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append(",actionFlag = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",verifyType = ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",actionType = ");
    localStringBuilder.append(paramInt);
    ab.c("TMAssistantBaseCallYYB", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString2))
    {
      paramTMAssistantCallYYBParamStruct = formatMapParams(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, paramString3);
    }
    else
    {
      paramTMAssistantCallYYBParamStruct = formatMapParams(paramTMAssistantCallYYBParamStruct, true, true, paramString3);
      paramTMAssistantCallYYBParamStruct.put("verifytype", paramString2);
    }
    paramString1 = formatIntentUriPath(paramInt, paramTMAssistantCallYYBParamStruct);
    long l1 = System.currentTimeMillis();
    long l2 = 300000L + l1;
    paramString2 = new StringBuilder();
    paramString2.append("addDownloadTaskFromTaskList,hostPackageName=");
    paramString2.append(this.hostPackageName);
    paramString2.append("; hostVersionCode=");
    paramString2.append(this.hostVersionCode);
    paramString2.append("; hostUserIdentity=");
    paramString2.append("");
    paramString2.append("; dataItemType=");
    paramString2.append(0);
    paramString2.append(";dataItemAction=");
    paramString2.append(paramString1);
    ab.c("TMAssistantBaseCallYYB", paramString2.toString());
    long l3 = this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, paramString1, l1, l2, 0, null);
    paramString1 = new StringBuilder();
    paramString1.append("result = ");
    paramString1.append(l3);
    ab.c("TMAssistantBaseCallYYB", paramString1.toString());
    paramTMAssistantCallYYBParamStruct = formatIntentUriPath(paramInt, paramTMAssistantCallYYBParamStruct, false);
    GlobalUtil.setClipboardCMD(this.mContext, paramTMAssistantCallYYBParamStruct, l1, l2);
    return l3;
  }
  
  protected long buildAddDBData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      ab.c("TMAssistantBaseCallYYB", "IPCData is null,return -1");
      return -1L;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IPCData length = ");
    localStringBuilder.append(paramArrayOfByte.length);
    ab.c("TMAssistantBaseCallYYB", localStringBuilder.toString());
    long l = System.currentTimeMillis();
    l = this.sdkChannel.a(null, 0, null, 0, null, l, l + 300000L, 1, paramArrayOfByte);
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("result = ");
    paramArrayOfByte.append(l);
    ab.c("TMAssistantBaseCallYYB", paramArrayOfByte.toString());
    return l;
  }
  
  public int checkQQDownloaderInstalled()
  {
    int j;
    int k;
    if (this.mContext != null)
    {
      ab.c("TMAssistantBaseCallYYB", "checkQQDownloaderInstalled start");
      localObject = this.mContext.getPackageManager();
      j = 1;
      i = j;
      if (localObject != null)
      {
        k = 0;
        i = j;
      }
    }
    try
    {
      if (((PackageManager)localObject).getPackageInfo("com.tencent.android.qqdownloader", 0) == null) {
        break label85;
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
      label76:
      break label76;
    }
    ab.c("TMAssistantBaseCallYYB", "packagename not found！");
    int i = j;
    label85:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("result = ");
    ((StringBuilder)localObject).append(i);
    ab.c("TMAssistantBaseCallYYB", ((StringBuilder)localObject).toString());
    return i;
    ab.e("TMAssistantBaseCallYYB", "mContext is null");
    throw new Exception("you must initial openSDK,by calling initQQDownloaderOpenSDK method!");
  }
  
  public int checkQQDownloaderInstalled(int paramInt)
  {
    Object localObject = this.mContext;
    if (localObject != null)
    {
      localObject = ((Context)localObject).getPackageManager();
      int j = 1;
      int i = j;
      if (localObject != null)
      {
        i = j;
        try
        {
          if (((PackageManager)localObject).getPackageInfo("com.tencent.android.qqdownloader", 0) != null)
          {
            int k = GlobalUtil.getInstance().getQQDownloaderVersionCode();
            int m = GlobalUtil.getInstance().getQQDownloaderAPILevel();
            int n = this.sdkAPILevel;
            i = 2;
            if (n > m) {
              paramInt = i;
            } else if (paramInt > k) {
              paramInt = i;
            } else {
              paramInt = 0;
            }
            i = paramInt;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localNameNotFoundException.printStackTrace();
          i = j;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("result = ");
      localStringBuilder.append(i);
      ab.c("TMAssistantBaseCallYYB", localStringBuilder.toString());
      return i;
    }
    ab.e("TMAssistantBaseCallYYB", "mContext is null");
    throw new Exception("you must initial openSDK,by calling initQQDownloaderOpenSDK method!");
  }
  
  public abstract void destroyQQDownloaderOpenSDK();
  
  protected String formatEncryptUrl(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url = ");
    localStringBuilder.append(paramString);
    ab.c("TMAssistantBaseCallYYB", localStringBuilder.toString());
    paramString = URLEncoder.encode(c.a(paramString));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("tmast://encrypt?encryptdata=");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("finalPath = ");
    localStringBuilder.append(paramString);
    ab.c("TMAssistantBaseCallYYB", localStringBuilder.toString());
    return paramString;
  }
  
  protected String formatIntentUriPath(int paramInt, Map<String, String> paramMap)
  {
    return formatIntentUriPath(paramInt, paramMap, true);
  }
  
  protected String formatIntentUriPath(int paramInt, Map<String, String> paramMap, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("actionType = ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(",params = ");
    ((StringBuilder)localObject1).append(paramMap);
    ab.c("TMAssistantBaseCallYYB", ((StringBuilder)localObject1).toString());
    Object localObject2 = "appdetails";
    localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
      break;
    case 6: 
      localObject1 = "downloadmanager";
      break;
    case 5: 
      localObject1 = "webview";
      break;
    case 4: 
      localObject1 = "updatedownload";
      break;
    case 1: 
      localObject1 = "download";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("tpmast://");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("?");
    localObject2 = ((StringBuilder)localObject2).toString();
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      paramMap = "";
      paramInt = 0;
      for (;;)
      {
        localObject1 = paramMap;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (Map.Entry)localIterator.next();
        String str1 = (String)((Map.Entry)localObject1).getKey();
        String str2 = (String)((Map.Entry)localObject1).getValue();
        localObject1 = paramMap;
        if (!TextUtils.isEmpty(str1))
        {
          localObject1 = paramMap;
          if (!TextUtils.isEmpty(str2))
          {
            if (paramInt <= 0) {
              localObject1 = "";
            } else {
              localObject1 = "&";
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramMap);
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(str1);
            localStringBuilder.append("=");
            localStringBuilder.append(URLEncoder.encode(str2));
            localObject1 = localStringBuilder.toString();
          }
        }
        paramInt += 1;
        paramMap = (Map<String, String>)localObject1;
      }
    }
    localObject1 = "";
    paramMap = new StringBuilder();
    paramMap.append((String)localObject2);
    paramMap.append((String)localObject1);
    localObject1 = paramMap.toString();
    paramMap = new StringBuilder();
    paramMap.append(">formatIntentUriPath ");
    paramMap.append((String)localObject1);
    ab.c("TMAssistantBaseCallYYB", paramMap.toString());
    paramMap = (Map<String, String>)localObject1;
    if (paramBoolean) {
      paramMap = formatEncryptUrl((String)localObject1);
    }
    return paramMap;
  }
  
  protected Map<String, String> formatMapParams(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("param = ");
    ((StringBuilder)localObject1).append(paramTMAssistantCallYYBParamStruct);
    ((StringBuilder)localObject1).append(",isAutoDownload = ");
    ((StringBuilder)localObject1).append(paramBoolean1);
    ((StringBuilder)localObject1).append(",isAutoInstall = ");
    ((StringBuilder)localObject1).append(paramBoolean2);
    ab.c("TMAssistantBaseCallYYB", ((StringBuilder)localObject1).toString());
    Object localObject2 = formatOplist(paramBoolean1, paramBoolean2);
    localObject1 = new HashMap();
    ((Map)localObject1).put("hostpname", this.hostPackageName);
    ((Map)localObject1).put("hostversioncode", String.valueOf(this.hostVersionCode));
    ((Map)localObject1).put("sngappid", paramTMAssistantCallYYBParamStruct.SNGAppId);
    ((Map)localObject1).put("appid", paramTMAssistantCallYYBParamStruct.taskAppId);
    ((Map)localObject1).put("apkid", paramTMAssistantCallYYBParamStruct.taskApkId);
    ((Map)localObject1).put("pname", paramTMAssistantCallYYBParamStruct.taskPackageName);
    ((Map)localObject1).put("via", paramTMAssistantCallYYBParamStruct.via);
    ((Map)localObject1).put("uin", paramTMAssistantCallYYBParamStruct.uin);
    ((Map)localObject1).put("uintype", paramTMAssistantCallYYBParamStruct.uinType);
    ((Map)localObject1).put("versioncode", String.valueOf(paramTMAssistantCallYYBParamStruct.taskVersion));
    ((Map)localObject1).put("oplist", localObject2);
    ((Map)localObject1).put("channelid", paramTMAssistantCallYYBParamStruct.channelId);
    ((Map)localObject1).put("actionflag", paramTMAssistantCallYYBParamStruct.actionFlag);
    ((Map)localObject1).put("traceid", paramString);
    ((Map)localObject1).put("recommendId", paramTMAssistantCallYYBParamStruct.recommendId);
    paramString = new JSONObject();
    localObject2 = paramTMAssistantCallYYBParamStruct.timePointMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      try
      {
        paramString.put(str, paramTMAssistantCallYYBParamStruct.timePointMap.get(str));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    ((Map)localObject1).put("timePoints", paramString.toString());
    paramTMAssistantCallYYBParamStruct = new StringBuilder();
    paramTMAssistantCallYYBParamStruct.append("mapParams = ");
    paramTMAssistantCallYYBParamStruct.append(localObject1);
    ab.c("TMAssistantBaseCallYYB", paramTMAssistantCallYYBParamStruct.toString());
    return localObject1;
  }
  
  protected String formatOplist(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isAutoDownload = ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(",isAutoInstall = ");
    ((StringBuilder)localObject).append(paramBoolean2);
    ab.c("TMAssistantBaseCallYYB", ((StringBuilder)localObject).toString());
    if ((paramBoolean1) && (paramBoolean2)) {
      localObject = "1;2";
    } else if (paramBoolean2) {
      localObject = "2";
    } else if (paramBoolean1) {
      localObject = "1";
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("oplist = ");
    localStringBuilder.append((String)localObject);
    ab.c("TMAssistantBaseCallYYB", localStringBuilder.toString());
    return localObject;
  }
  
  public abstract TMAssistantCallYYBTaskInfo getDownloadTaskState(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct);
  
  public abstract void initTMAssistantCallYYBApi(Context paramContext);
  
  protected void onStateChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("param = ");
    ((StringBuilder)localObject).append(paramTMAssistantCallYYBParamStruct);
    ((StringBuilder)localObject).append(",state = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",errorCode = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(",errorMsg = ");
    ((StringBuilder)localObject).append(paramString);
    ab.c("TMAssistantBaseCallYYB", ((StringBuilder)localObject).toString());
    localObject = this.mWeakListenerArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ITMAssistantCallBackListener localITMAssistantCallBackListener = (ITMAssistantCallBackListener)((WeakReference)((Iterator)localObject).next()).get();
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("listener = ");
    ((StringBuilder)localObject).append(paramITMAssistantCallBackListener);
    ab.c("TMAssistantBaseCallYYB", ((StringBuilder)localObject).toString());
    for (;;)
    {
      localObject = this.mListenerQueue.poll();
      if (localObject == null) {
        break;
      }
      this.mWeakListenerArrayList.remove(localObject);
    }
    localObject = this.mWeakListenerArrayList.iterator();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setQQGameClientKey clientKey = ");
    localStringBuilder.append(paramString);
    ab.c("jimluo", localStringBuilder.toString());
    this.mClientKey = paramString;
  }
  
  public void startQQDownloader(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("context = ");
    ((StringBuilder)localObject).append(paramContext);
    ab.c("TMAssistantBaseCallYYB", ((StringBuilder)localObject).toString());
    if (paramContext != null)
    {
      localObject = paramContext.getPackageManager().getLaunchIntentForPackage("com.tencent.android.qqdownloader");
      if ((paramContext instanceof Application)) {
        ((Intent)localObject).addFlags(268435456);
      }
      paramContext.startActivity((Intent)localObject);
    }
  }
  
  public abstract void startToAuthorized(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, String paramString);
  
  public void startToDownloadTaskList(Context paramContext)
  {
    if (paramContext != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tmast://download?hostpname=");
      ((StringBuilder)localObject).append(this.hostPackageName);
      ((StringBuilder)localObject).append("&hostversion=");
      ((StringBuilder)localObject).append(this.hostVersionCode);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("path = ");
      localStringBuilder.append((String)localObject);
      ab.c("TMAssistantBaseCallYYB", localStringBuilder.toString());
      localObject = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
      if ((paramContext instanceof Application)) {
        ((Intent)localObject).addFlags(268435456);
      }
      paramContext.startActivity((Intent)localObject);
      return;
    }
    ab.e("TMAssistantBaseCallYYB", "context is null,return 0");
    throw new Exception("you must input an application or activity context!");
  }
  
  public void startToDownloadTaskListWithParams(Context paramContext, Bundle paramBundle)
  {
    if (paramContext != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tmast://download?hostpname=");
      localStringBuilder.append(this.hostPackageName);
      localStringBuilder.append("&hostversion=");
      localStringBuilder.append(this.hostVersionCode);
      localStringBuilder = new StringBuilder(localStringBuilder.toString());
      if (paramBundle != null)
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localStringBuilder.append("&");
          localStringBuilder.append(str);
          localStringBuilder.append("=");
          localStringBuilder.append(paramBundle.getString(str));
        }
      }
      paramBundle = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startToDownloadTaskListWithParams path = ");
      localStringBuilder.append(paramBundle);
      ab.c("TMAssistantBaseCallYYB", localStringBuilder.toString());
      paramBundle = new Intent("android.intent.action.VIEW", Uri.parse(paramBundle));
      if ((paramContext instanceof Application)) {
        paramBundle.addFlags(268435456);
      }
      paramContext.startActivity(paramBundle);
      return;
    }
    ab.e("TMAssistantBaseCallYYB", "context is null,return 0");
    paramContext = new Exception("you must input an application or activity context!");
    for (;;)
    {
      throw paramContext;
    }
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