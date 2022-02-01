package com.tencent.mobileqq.vas.updatesystem.api.impl;

import com.tencent.mobileqq.activity.aio.item.TroopPobingEffectItemView;
import com.tencent.mobileqq.activity.aio.item.TroopPobingItemView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.api.impl.ThemeSwitcherImpl;
import com.tencent.mobileqq.vas.theme.api.impl.ThemeSwitcherImpl.Companion;
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
    Iterator localIterator = paramHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      paramHashMap = new File(paramString, (String)localIterator.next());
      if (!paramHashMap.exists())
      {
        paramString = new StringBuilder();
        paramString.append("missing: ");
        paramString.append(paramHashMap.getAbsolutePath());
        QLog.e("VasQuickUpdateAdapterIm", 1, paramString.toString());
        return true;
      }
    }
    return false;
  }
  
  public void downloadItem(AppRuntime paramAppRuntime, long paramLong, String paramString1, String paramString2, CallBacker paramCallBacker)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      paramString2 = (IVasQuickUpdateService)paramAppRuntime.getRuntimeService(IVasQuickUpdateService.class, "");
    } else {
      paramString2 = null;
    }
    if (paramString2 == null)
    {
      paramString2 = new StringBuilder();
      paramString2.append("downloadItem, manager == null; scid: ");
      paramString2.append(paramString1);
      paramString2.append(", bid: ");
      paramString2.append(paramLong);
      paramString2.append(" , app= ");
      paramString2.append(paramAppRuntime);
      QLog.e("VasQuickUpdateAdapterIm", 1, paramString2.toString());
      return;
    }
    paramString2.addCallBacker(paramCallBacker);
    if (16L == paramLong)
    {
      if ((!"iRedPacket_v3.json".equals(paramString1)) && (!"iRedPacket_v3.char300.json".equals(paramString1)) && (!"iRedPacket_v3.font.zip".equals(paramString1)) && (!"iRedPacket_v3.specialChar.zip".equals(paramString1)))
      {
        paramAppRuntime = "getFileFromLocal_redPacket";
      }
      else
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("silent_download.redbag");
        paramAppRuntime.append(paramString1);
        paramAppRuntime = paramAppRuntime.toString();
      }
      paramString2.downloadItem(paramLong, paramString1, paramAppRuntime);
      return;
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getFileFromLocal_");
    paramAppRuntime.append(paramLong);
    paramString2.downloadItem(paramLong, paramString1, paramAppRuntime.toString());
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
    if (paramInt == 2000) {
      return new File(paramString, "addgroup_preview.png").exists();
    }
    if (paramInt == 2004)
    {
      if (fileExist(paramString, TroopPobingEffectItemView.a)) {
        return false;
      }
      if (fileExist(paramString, TroopPobingItemView.b)) {
        return false;
      }
    }
    else
    {
      if (fileExist(paramString, TroopPobingItemView.a)) {
        return false;
      }
      if (fileExist(paramString, TroopPobingItemView.b)) {
        return false;
      }
    }
    return true;
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
    ThemeSwitcherImpl.Companion.a(paramString1, paramInt1);
    if (paramInt1 != 0)
    {
      String str = ThemeUtil.getIDFromSCID(paramString1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("from");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(",httpCode=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",errorCode:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", scid:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", cfgScid:");
      localStringBuilder.append(paramString2);
      VasMonitorHandler.a(null, "individual_v2_theme_download_fail", String.valueOf(paramInt1), localStringBuilder.toString(), str, String.valueOf(paramInt2), null, 0.0F, 0.0F);
      paramString1 = new HashMap();
      paramString2 = new StringBuilder();
      paramString2.append("errorCode:");
      paramString2.append(paramInt1);
      paramString1.put("reportKey", paramString2.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.api.impl.VasQuickUpdateAdapterImpl
 * JD-Core Version:    0.7.0.1
 */