package com.tencent.securemodule.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.securemodule.ae;
import com.tencent.securemodule.at;
import com.tencent.securemodule.az;
import com.tencent.securemodule.service.ApkDownLoadListener;
import com.tencent.securemodule.service.CloudScanListener;
import com.tencent.securemodule.service.ISecureModuleService;
import com.tencent.securemodule.service.ProductInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SecureModuleService
  implements ISecureModuleService
{
  private static SecureModuleService mInstance = null;
  private Context mContext;
  private SecureModuleService.DownLoadBroadcastReceiver mDownLoadBroadcastReceiver;
  private List<SecureModuleService.CloudScanBroadcastReceiver> mObserverList;
  
  private SecureModuleService(Context paramContext)
  {
    this.mContext = paramContext;
    this.mObserverList = new ArrayList();
  }
  
  public static String downloadFile(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = new ae(paramContext);
    paramContext.b(paramString2);
    paramContext.a(paramInt);
    while (paramContext.a(paramString1, false) == -7) {}
    return paramContext.b();
  }
  
  public static String getCachePath(Context paramContext)
  {
    return paramContext.getCacheDir().getAbsolutePath();
  }
  
  public static String getFilesPath(Context paramContext)
  {
    return paramContext.getFilesDir().getAbsolutePath();
  }
  
  public static SecureModuleService getInstance(Context paramContext)
  {
    if (mInstance == null) {
      return new SecureModuleService(paramContext);
    }
    return mInstance;
  }
  
  private void removeDownloadReceiver()
  {
    if (this.mDownLoadBroadcastReceiver != null)
    {
      this.mContext.unregisterReceiver(this.mDownLoadBroadcastReceiver);
      this.mDownLoadBroadcastReceiver = null;
    }
  }
  
  public void cloudScan()
  {
    SecureService.a(this.mContext, "1000010");
  }
  
  public void downLoadTMSeucreApk(ApkDownLoadListener paramApkDownLoadListener)
  {
    if (this.mDownLoadBroadcastReceiver != null) {
      return;
    }
    if (paramApkDownLoadListener != null)
    {
      this.mDownLoadBroadcastReceiver = new SecureModuleService.DownLoadBroadcastReceiver(this, paramApkDownLoadListener);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("1000024");
      ((IntentFilter)localObject).addAction("1000025");
      ((IntentFilter)localObject).addAction("1000027");
      ((IntentFilter)localObject).addAction("1000026");
      this.mContext.registerReceiver(this.mDownLoadBroadcastReceiver, (IntentFilter)localObject);
    }
    Object localObject = new Intent("1000011");
    ((Intent)localObject).setClass(this.mContext, SecureService.class);
    if (paramApkDownLoadListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      ((Intent)localObject).putExtra("key_download_listener", bool);
      this.mContext.startService((Intent)localObject);
      return;
    }
  }
  
  public int register(ProductInfo paramProductInfo)
  {
    if (paramProductInfo == null) {
      return -6;
    }
    at.a(this.mContext, paramProductInfo);
    if (!az.a(this.mContext, "sm_mq")) {
      return -1;
    }
    return 0;
  }
  
  public void registerCloudScanListener(Context paramContext, CloudScanListener paramCloudScanListener)
  {
    Object localObject = this.mObserverList.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      if (!((SecureModuleService.CloudScanBroadcastReceiver)((Iterator)localObject).next()).a(paramCloudScanListener)) {
        break label102;
      }
      i = 1;
    }
    label102:
    for (;;)
    {
      break;
      if (i == 0)
      {
        paramCloudScanListener = new SecureModuleService.CloudScanBroadcastReceiver(this, paramCloudScanListener);
        this.mObserverList.add(paramCloudScanListener);
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("1000030");
        ((IntentFilter)localObject).addAction("1000031");
        paramContext.registerReceiver(paramCloudScanListener, (IntentFilter)localObject);
      }
      return;
    }
  }
  
  public void setNotificationUIEnable(boolean paramBoolean)
  {
    at.b(this.mContext, 10002, paramBoolean);
  }
  
  public void unregisterCloudScanListener(Context paramContext, CloudScanListener paramCloudScanListener)
  {
    Object localObject = null;
    Iterator localIterator = this.mObserverList.iterator();
    if (localIterator.hasNext())
    {
      SecureModuleService.CloudScanBroadcastReceiver localCloudScanBroadcastReceiver = (SecureModuleService.CloudScanBroadcastReceiver)localIterator.next();
      if (!localCloudScanBroadcastReceiver.a(paramCloudScanListener)) {
        break label71;
      }
      localObject = localCloudScanBroadcastReceiver;
    }
    label71:
    for (;;)
    {
      break;
      if (localObject != null)
      {
        this.mObserverList.remove(localObject);
        paramContext.unregisterReceiver(localObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.securemodule.impl.SecureModuleService
 * JD-Core Version:    0.7.0.1
 */