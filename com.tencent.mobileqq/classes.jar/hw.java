import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.etrump.mixlayout.ETEngine;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class hw
{
  public static AtomicBoolean a = new AtomicBoolean(false);
  
  public static boolean a()
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = BaseApplication.getContext().getSharedPreferences("early_qq.android.native.vipfont.v5", 4).getBoolean("vip_font_so_downloaded", false);
      if (QLog.isColorLevel()) {
        QLog.d("VipFontSoLoader", 2, "VipFontData in sp: vip_font_so_downloaded=" + bool2);
      }
      if (bool2)
      {
        String str = bbkv.a();
        bool1 = new File(str + "libvipfont808.so").exists();
      }
      return bool1;
    }
    finally {}
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = a.get();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean c()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = BaseApplicationImpl.getApplication();
        if (localObject1 == null)
        {
          bool = false;
          return bool;
        }
        switch (bbkv.a(bbkv.a(), "libvipfont808.so"))
        {
        case 1: 
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if (!(localObject1 instanceof QQAppInterface)) {
            break label251;
          }
          QQAppInterface localQQAppInterface = (QQAppInterface)localObject1;
          ((VasQuickUpdateManager)localQQAppInterface.getManager(184)).downloadItem(1004L, VasQuickUpdateManager.SCID_HYFONT_SO, "FontManager_initHYEngine");
          localObject1 = ((ajxn)localQQAppInterface.getManager(51)).a(localQQAppInterface.getAccount());
          if ((localObject1 != null) && (0L != ((ExtensionInfo)localObject1).uVipFont) && (((ExtensionInfo)localObject1).vipFontType == 1))
          {
            localObject1 = "0";
            axqw.b(localQQAppInterface, "CliOper", "", "", "Font_Mall", "0X80072C8", 0, 0, "1", (String)localObject1, "", "");
            if (!QLog.isColorLevel()) {
              break label251;
            }
            QLog.d("VipFontSoLoader", 2, "VipFontReport: early download start, restartDownload=true, type=" + (String)localObject1);
          }
          break;
        }
      }
      finally {}
      String str = "1";
      continue;
      ETEngine.isSOLoaded.set(true);
      aqwz.a().a();
      a.set(true);
      BaseApplication.getContext().getSharedPreferences("early_qq.android.native.vipfont.v5", 4).edit().putBoolean("vip_font_so_downloaded", true).commit();
      boolean bool = true;
      continue;
      label251:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     hw
 * JD-Core Version:    0.7.0.1
 */