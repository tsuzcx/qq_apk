package com.tencent.ttpic.offlineset.utils;

import com.google.gson.JsonObject;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.offlineset.beans.ConfigJsonBean;
import com.tencent.ttpic.openapi.offlineset.utils.FileOfflineUtil;
import com.tencent.ttpic.openapi.offlineset.utils.IHttpClient;
import com.tencent.ttpic.openapi.offlineset.utils.IResponseListener;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class OfflineSettingUtils
{
  private static final String CONFIG_NAME = "config.json";
  private static final int REQUEST_CHECK_CODE = 1;
  private static final int REQUEST_DOWNLOAD_ZIP_CODE = 2;
  private static String REQUEST_URL_PRE = "https://offline.qq.com/offline/check?";
  private static final String TAG = "OfflineSettingUtils";
  private static ArrayList<OfflineSettingUtils.IDownloadedListener> sDownloadedListeners;
  private static IHttpClient sHttpClient;
  private static IResponseListener sResponseListener = new OfflineSettingUtils.1();
  
  public static void addDownloadLister(OfflineSettingUtils.IDownloadedListener paramIDownloadedListener)
  {
    if (paramIDownloadedListener != null)
    {
      if (sDownloadedListeners == null) {
        sDownloadedListeners = new ArrayList();
      }
      if (!sDownloadedListeners.contains(paramIDownloadedListener)) {
        sDownloadedListeners.add(paramIDownloadedListener);
      }
    }
  }
  
  private static String getBid(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      paramString = new StringBuilder();
      paramString.append("biz=");
      paramString.append(Integer.valueOf(i));
      paramString = paramString.toString();
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      label36:
      break label36;
    }
    return null;
  }
  
  private static String getHVerion(String paramString)
  {
    int i = getLocalVersion(paramString);
    paramString = new StringBuilder();
    paramString.append("hver=");
    paramString.append(i);
    return paramString.toString();
  }
  
  private static int getLocalVersion(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FileOfflineUtil.getOfflineDirPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("config.json");
    paramString = FileOfflineUtil.readJsonStringFromFile(localStringBuilder.toString());
    if (paramString == null) {
      return 0;
    }
    paramString = (ConfigJsonBean)GsonUtils.json2Obj(paramString, new OfflineSettingUtils.2().getType());
    if (paramString != null) {
      i = paramString.version;
    }
    return i;
  }
  
  public static String getOfflineCGIUrl(String paramString)
  {
    String str = getBid(paramString);
    if (str != null)
    {
      Object localObject = REQUEST_URL_PRE;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(getHVerion(paramString));
      paramString = localStringBuilder.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("&");
      paramString = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(getPlatformId());
      paramString = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("&");
      paramString = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    return null;
  }
  
  private static String getPlatformId()
  {
    return "pf=3";
  }
  
  private static boolean isNeedUpdate(JsonObject paramJsonObject)
  {
    if (paramJsonObject == null) {
      return false;
    }
    try
    {
      paramJsonObject = Integer.valueOf(GsonUtils.getIntUnsafe(paramJsonObject, "type"));
      if (paramJsonObject != null)
      {
        int i = paramJsonObject.intValue();
        if (i == 1) {
          return true;
        }
      }
      return false;
    }
    catch (Exception paramJsonObject) {}
    return false;
  }
  
  private static void notifyDownloadListeners(String paramString)
  {
    Iterator localIterator = sDownloadedListeners.iterator();
    while (localIterator.hasNext()) {
      ((OfflineSettingUtils.IDownloadedListener)localIterator.next()).downloadCompleted(paramString);
    }
  }
  
  public static void removeDownloadListener(OfflineSettingUtils.IDownloadedListener paramIDownloadedListener)
  {
    if (paramIDownloadedListener != null)
    {
      ArrayList localArrayList = sDownloadedListeners;
      if (localArrayList != null) {
        localArrayList.remove(paramIDownloadedListener);
      }
    }
  }
  
  public static void setHttpClient(IHttpClient paramIHttpClient)
  {
    sHttpClient = paramIHttpClient;
    paramIHttpClient = sHttpClient;
    if (paramIHttpClient != null) {
      paramIHttpClient.setResponseListener(sResponseListener);
    }
  }
  
  private static void startDownload(JsonObject paramJsonObject, String paramString)
  {
    if (paramJsonObject == null) {
      return;
    }
    try
    {
      paramJsonObject = GsonUtils.getStringUnsafe(paramJsonObject, "url");
      if (paramJsonObject != null)
      {
        String str = FileOfflineUtil.getOfflineDirPath();
        if (sHttpClient != null) {
          sHttpClient.download(2, paramString, paramJsonObject, str);
        }
        return;
      }
    }
    catch (Exception paramJsonObject)
    {
      paramString = new StringBuilder();
      paramString.append("startDownload:");
      paramString.append(paramJsonObject.getMessage());
      LogUtils.e("OfflineSettingUtils", paramString.toString());
    }
  }
  
  public static boolean updateOfflinePage(String paramString)
  {
    if ((paramString != null) && (sHttpClient != null))
    {
      localObject = getOfflineCGIUrl(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getUrl:");
      localStringBuilder.append((String)localObject);
      LogUtils.i("OfflineSettingUtils", localStringBuilder.toString());
      sHttpClient.get(1, paramString, (String)localObject);
      return true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bid :");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" ,sHttpClient:");
    ((StringBuilder)localObject).append(sHttpClient);
    LogUtils.i("OfflineSettingUtils", ((StringBuilder)localObject).toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.offlineset.utils.OfflineSettingUtils
 * JD-Core Version:    0.7.0.1
 */