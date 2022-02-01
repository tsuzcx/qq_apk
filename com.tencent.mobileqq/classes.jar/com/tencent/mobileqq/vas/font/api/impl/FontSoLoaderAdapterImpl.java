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

public class FontSoLoaderAdapterImpl
  implements IFontSoLoaderAdapter
{
  private static final String TAG = "FontSoLoaderAdapterImpl";
  private static AtomicBoolean sIsVipFontSoLoaded = new AtomicBoolean(false);
  
  public boolean isVipFontSoDownloaded()
  {
    boolean bool1 = false;
    boolean bool2 = BaseApplication.getContext().getSharedPreferences("early_qq.android.native.vipfont.v5", 4).getBoolean("vip_font_so_downloaded", false);
    if (QLog.isColorLevel()) {
      QLog.d("FontSoLoaderAdapterImpl", 2, "VipFontData in sp: vip_font_so_downloaded=" + bool2);
    }
    if (bool2)
    {
      String str = VasSoUtils.a();
      bool1 = new File(str + "libvipfont8417.so").exists();
    }
    return bool1;
  }
  
  public boolean isVipFontSoLoaded()
  {
    return sIsVipFontSoLoaded.get();
  }
  
  public boolean loadSo()
  {
    if (BaseApplicationImpl.getApplication() == null) {}
    do
    {
      return false;
      switch (VasSoUtils.a(VasSoUtils.a(), "libvipfont8417.so"))
      {
      default: 
        return false;
      case 0: 
        ETEngine.isSOLoaded.set(true);
        HiBoomFont.a().a();
        sIsVipFontSoLoaded.set(true);
        BaseApplication.getContext().getSharedPreferences("early_qq.android.native.vipfont.v5", 4).edit().putBoolean("vip_font_so_downloaded", true).commit();
        return true;
      }
      localObject = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localObject instanceof QQAppInterface));
    QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
    ((IVasQuickUpdateService)localQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1004L, "libVipFont_8417", "FontManager_initHYEngine");
    Object localObject = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(localQQAppInterface.getAccount());
    if ((localObject != null) && (0L != ((ExtensionInfo)localObject).uVipFont) && (((ExtensionInfo)localObject).vipFontType == 1)) {}
    for (localObject = "0";; localObject = "1")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Font_Mall", "0X80072C8", 0, 0, "1", (String)localObject, "", "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FontSoLoaderAdapterImpl", 2, "VipFontReport: early download start, restartDownload=true, type=" + (String)localObject);
      return false;
    }
  }
  
  public void setVipFontSoLoad(boolean paramBoolean)
  {
    sIsVipFontSoLoaded.set(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.font.api.impl.FontSoLoaderAdapterImpl
 * JD-Core Version:    0.7.0.1
 */