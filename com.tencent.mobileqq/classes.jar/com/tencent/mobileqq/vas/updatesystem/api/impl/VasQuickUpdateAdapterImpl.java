package com.tencent.mobileqq.vas.updatesystem.api.impl;

import com.tencent.mobileqq.activity.aio.item.TroopPobingEffectItemView;
import com.tencent.mobileqq.activity.aio.item.TroopPobingItemView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.updatesystem.impl.VasHttpDownloaderImpl;
import com.tencent.open.base.BspatchUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.IHttpDownloader;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class VasQuickUpdateAdapterImpl
  implements IVasQuickUpdateAdapter
{
  private static final String TAG = "VasQuickUpdateAdapterIm";
  
  private boolean fileExist(String paramString, HashMap<Integer, String> paramHashMap)
  {
    paramHashMap = paramHashMap.values().iterator();
    while (paramHashMap.hasNext())
    {
      File localFile = new File(paramString, (String)paramHashMap.next());
      if (!localFile.exists())
      {
        QLog.e("VasQuickUpdateAdapterIm", 1, "missing: " + localFile.getAbsolutePath());
        return true;
      }
    }
    return false;
  }
  
  public void downloadItem(AppRuntime paramAppRuntime, long paramLong, String paramString1, String paramString2, CallBacker paramCallBacker)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {}
    for (paramString2 = (IVasQuickUpdateService)paramAppRuntime.getRuntimeService(IVasQuickUpdateService.class, "");; paramString2 = null)
    {
      if (paramString2 == null)
      {
        QLog.e("VasQuickUpdateAdapterIm", 1, "downloadItem, manager == null; scid: " + paramString1 + ", bid: " + paramLong + " , app= " + paramAppRuntime);
        return;
      }
      paramString2.addCallBacker(paramCallBacker);
      if (16L == paramLong)
      {
        paramAppRuntime = "getFileFromLocal_redPacket";
        if (("iRedPacket_v3.json".equals(paramString1)) || ("iRedPacket_v3.char300.json".equals(paramString1)) || ("iRedPacket_v3.font.zip".equals(paramString1)) || ("iRedPacket_v3.specialChar.zip".equals(paramString1))) {
          paramAppRuntime = "silent_download.redbag" + paramString1;
        }
        paramString2.downloadItem(paramLong, paramString1, paramAppRuntime);
        return;
      }
      paramString2.downloadItem(paramLong, paramString1, "getFileFromLocal_" + paramLong);
      return;
    }
  }
  
  public String getFileMd5(String paramString)
  {
    return MD5Utils.encodeFileHexStr(paramString);
  }
  
  public IHttpDownloader getHttpDownloader()
  {
    return new VasHttpDownloaderImpl();
  }
  
  public String getUpdateReportAppid()
  {
    return "qqvas_updatemgr_complete";
  }
  
  public boolean isPobingCardExit(int paramInt, String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt == 2000) {
      bool1 = new File(paramString, "addgroup_preview.png").exists();
    }
    do
    {
      do
      {
        return bool1;
        if (paramInt != 2004) {
          break;
        }
        bool1 = bool2;
      } while (fileExist(paramString, TroopPobingEffectItemView.a));
      bool1 = bool2;
    } while (fileExist(paramString, TroopPobingItemView.b));
    do
    {
      return true;
      bool1 = bool2;
      if (fileExist(paramString, TroopPobingItemView.a)) {
        break;
      }
    } while (!fileExist(paramString, TroopPobingItemView.b));
    return false;
  }
  
  public boolean isPobingUpdateEnable()
  {
    return QzoneConfig.getInstance().getConfig("qqsetting", "addgroupvasfeaturedisable", 0L) == 0L;
  }
  
  public void onMusicThemeCleanCache()
  {
    AIOMusicSkin.a().b();
  }
  
  public void onThemeComplete(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    ThemeSwitcher.a(paramString1, paramInt1);
    if (paramInt1 != 0)
    {
      String str = ThemeUtil.b(paramString1);
      VasMonitorHandler.a(null, "individual_v2_theme_download_fail", String.valueOf(paramInt1), "from" + paramString3 + ",httpCode=" + paramInt2 + ",errorCode:" + paramInt1 + ", scid:" + paramString1 + ", cfgScid:" + paramString2, str, String.valueOf(paramInt2), null, 0.0F, 0.0F);
      paramString1 = new HashMap();
      paramString1.put("reportKey", "errorCode:" + paramInt1);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "individual_v2_theme_download_fail", false, 0L, -1L, paramString1, "", true);
    }
  }
  
  public void onThemeProgress(String paramString, long paramLong1, long paramLong2)
  {
    ThemeSwitcher.a(paramString, paramLong1, paramLong2);
  }
  
  public boolean patch(String paramString1, String paramString2, String paramString3)
  {
    return BspatchUtil.a(paramString1, paramString2, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.api.impl.VasQuickUpdateAdapterImpl
 * JD-Core Version:    0.7.0.1
 */