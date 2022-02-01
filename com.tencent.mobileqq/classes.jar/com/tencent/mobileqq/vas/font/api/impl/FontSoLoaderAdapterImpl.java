package com.tencent.mobileqq.vas.font.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.etrump.mixlayout.ETEngine;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hiboom.HiBoomFont;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.font.api.IFontSoLoaderAdapter;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class FontSoLoaderAdapterImpl
  implements IFontSoLoaderAdapter
{
  private static final String TAG = "FontSoLoaderAdapterImpl";
  private static AtomicBoolean sIsVipFontSoLoaded = new AtomicBoolean(false);
  
  public boolean isVipFontSoDownloaded()
  {
    boolean bool = BaseApplication.getContext().getSharedPreferences("early_qq.android.native.vipfont.v5", 4).getBoolean("vip_font_so_downloaded", false);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("VipFontData in sp: vip_font_so_downloaded=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("FontSoLoaderAdapterImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      localObject = VasSoUtils.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("libvipfont8417.so");
      return new File(localStringBuilder.toString()).exists();
    }
    return false;
  }
  
  public boolean isVipFontSoLoaded()
  {
    return sIsVipFontSoLoaded.get();
  }
  
  public boolean loadSo()
  {
    if (BaseApplicationImpl.getApplication() == null) {
      return false;
    }
    int i = VasSoUtils.a(VasSoUtils.a(), "libvipfont8417.so");
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 instanceof QQAppInterface))
      {
        Object localObject2 = (QQAppInterface)localObject1;
        ((IVasQuickUpdateService)((QQAppInterface)localObject2).getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1004L, "libVipFont_8417", "FontManager_initHYEngine");
        localObject1 = ((FriendsManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(((QQAppInterface)localObject2).getAccount());
        if ((localObject1 != null) && (0L != ((ExtensionInfo)localObject1).uVipFont) && (((ExtensionInfo)localObject1).vipFontType == 1)) {
          localObject1 = "0";
        } else {
          localObject1 = "1";
        }
        ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "Font_Mall", "0X80072C8", 0, 0, "1", (String)localObject1, "", "");
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("VipFontReport: early download start, restartDownload=true, type=");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("FontSoLoaderAdapterImpl", 2, ((StringBuilder)localObject2).toString());
        }
      }
      return false;
    }
    ETEngine.isSOLoaded.set(true);
    HiBoomFont.a().a();
    sIsVipFontSoLoaded.set(true);
    BaseApplication.getContext().getSharedPreferences("early_qq.android.native.vipfont.v5", 4).edit().putBoolean("vip_font_so_downloaded", true).commit();
    return true;
  }
  
  public void setVipFontSoLoad(boolean paramBoolean)
  {
    sIsVipFontSoLoaded.set(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.font.api.impl.FontSoLoaderAdapterImpl
 * JD-Core Version:    0.7.0.1
 */