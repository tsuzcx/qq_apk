package com.tencent.mobileqq.intervideo.huayang.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloaderUtil;
import com.tencent.mobileqq.intervideo.huayang.IHuayangDowanloadHelper;
import com.tencent.mobileqq.intervideo.huayang.IHuayangOpenHelper;
import com.tencent.mobileqq.intervideo.huayang.IHuayangPluginNewDownloader;
import com.tencent.mobileqq.intervideo.huayang.IHuayangPluginNewDownloader.HuayangPluginLoadStatusListener;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.intervideo.shadow.PluginProcessKiller;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.proxyinner.plugin.loader.QTProxyService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mqq.app.MobileQQ;

public class HuayangDowanloadHelperImpl
  implements IHuayangDowanloadHelper, PluginProcessKiller
{
  private IHuayangPluginNewDownloader huayangPluginNewDownloader;
  private volatile boolean isNeedStop;
  private String mAction;
  private Context mAppContext;
  private String mAppName;
  private IVPluginDataReporter mDataReporter;
  private List<HuayangDowanloadHelperImpl.GetLoginKeyDataListener> mGetLoginKeyDataListeners = new ArrayList();
  private ILoginKeyHelper mLoginKeyHelper = (ILoginKeyHelper)QRoute.api(ILoginKeyHelper.class);
  private Map<String, IVPluginInfo> mPluginInfoMap;
  private String mPluginPackageName;
  private long mStartGetHYAITime;
  private long mStartGetODAITime;
  private String mUin;
  private String mUri;
  private IHuayangPluginNewDownloader.HuayangPluginLoadStatusListener pluginDownloaderPreLoaderListener = new HuayangDowanloadHelperImpl.1(this);
  
  private void getAIData(InstalledPlugin paramInstalledPlugin, boolean paramBoolean, long paramLong)
  {
    IVPluginInfo localIVPluginInfo = (IVPluginInfo)this.mPluginInfoMap.get(paramInstalledPlugin.pluginPackageName);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("开始拉取AI票据：");
      ((StringBuilder)localObject).append(localIVPluginInfo.g);
      QLog.d("IHuayangPluginNewDownloader", 2, ((StringBuilder)localObject).toString());
    }
    paramInstalledPlugin = new HuayangDowanloadHelperImpl.GetLoginKeyDataListener(this, this.mPluginPackageName, localIVPluginInfo, paramInstalledPlugin, paramBoolean, paramLong);
    this.mGetLoginKeyDataListeners.add(paramInstalledPlugin);
    if (localIVPluginInfo.g == 1)
    {
      this.mStartGetHYAITime = System.currentTimeMillis();
      this.mLoginKeyHelper.getA1(this.mUin, localIVPluginInfo.a, localIVPluginInfo.c, localIVPluginInfo.b, paramInstalledPlugin, true, localIVPluginInfo.p);
      return;
    }
    if (localIVPluginInfo.g == 2)
    {
      this.mStartGetODAITime = System.currentTimeMillis();
      localObject = (AppInterface)((BaseApplicationImpl)MobileQQ.getContext()).waitAppRuntime(null);
      this.mLoginKeyHelper.getAccessToken((AppInterface)localObject, localIVPluginInfo.a, this.mAppContext, localIVPluginInfo.b, paramInstalledPlugin);
    }
  }
  
  private void stopLoad()
  {
    Iterator localIterator = this.mGetLoginKeyDataListeners.iterator();
    while (localIterator.hasNext()) {
      ((HuayangDowanloadHelperImpl.GetLoginKeyDataListener)localIterator.next()).a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("IHuayangPluginNewDownloader", 2, "setStop");
    }
  }
  
  public void canceLauncher()
  {
    this.huayangPluginNewDownloader.setDonwanlodPreloadListener(null);
    this.mGetLoginKeyDataListeners.clear();
    this.mUin = null;
    this.mUri = null;
    this.mAction = null;
    if (!NetworkUtil.isWifiEnabled(this.mAppContext)) {
      this.huayangPluginNewDownloader.cancelDownload();
    }
    this.huayangPluginNewDownloader.cancelLauncher();
  }
  
  public void downloadPlugin(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, IVPluginInfo> paramMap)
  {
    this.isNeedStop = false;
    this.huayangPluginNewDownloader.setUin(paramString2);
    if (!paramString2.equals(this.mUin)) {
      this.mLoginKeyHelper.clearAccount();
    }
    Monitor.a(TextUtils.equals(paramString1, "hy_sixgod"));
    this.mUin = paramString2;
    this.mUri = paramString3;
    this.mAction = paramString4;
    this.mAppName = paramString1;
    this.mPluginInfoMap = paramMap;
    this.mGetLoginKeyDataListeners.clear();
    this.huayangPluginNewDownloader.setDonwanlodPreloadListener(this.pluginDownloaderPreLoaderListener);
    this.huayangPluginNewDownloader.download(paramString1, paramString4, this.mPluginPackageName, paramMap);
  }
  
  public HuayangDowanloadHelperImpl init(Context paramContext, String paramString1, String paramString2)
  {
    this.mAppContext = paramContext.getApplicationContext();
    this.mPluginPackageName = paramString1;
    this.mDataReporter = new IVPluginDataReporter();
    this.mDataReporter.opDepartment(paramString2);
    this.huayangPluginNewDownloader = HuayangPluginNewDownloaderUtil.a(paramContext, paramString1, paramString2);
    return this;
  }
  
  public void onKillPluginProcess()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.isNeedStop = true;
      Object localObject1 = new Intent(this.mAppContext, QTProxyService.class);
      Object localObject2 = new CountDownLatch(1);
      long l = System.currentTimeMillis();
      QLog.i("IHuayangPluginNewDownloader", 2, "bindService ");
      this.mAppContext.bindService((Intent)localObject1, new HuayangDowanloadHelperImpl.2(this, (CountDownLatch)localObject2), 1);
      try
      {
        if ((true ^ ((CountDownLatch)localObject2).await(3L, TimeUnit.SECONDS)))
        {
          QLog.e("IHuayangPluginNewDownloader", 2, "onKillPluginProcess timeout");
          localObject1 = (IHuayangOpenHelper)QRoute.api(IHuayangOpenHelper.class);
          localObject2 = this.mAppContext;
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(this.mAppContext.getPackageName());
          localStringBuilder2.append(":troophomework");
          ((IHuayangOpenHelper)localObject1).killProcess((Context)localObject2, localStringBuilder2.toString());
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onKillPluginProcess end costTime:");
      localStringBuilder1.append(System.currentTimeMillis() - l);
      QLog.i("IHuayangPluginNewDownloader", 2, localStringBuilder1.toString());
      return;
    }
    throw new RuntimeException(HardCodeUtil.a(2131903604));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.impl.HuayangDowanloadHelperImpl
 * JD-Core Version:    0.7.0.1
 */