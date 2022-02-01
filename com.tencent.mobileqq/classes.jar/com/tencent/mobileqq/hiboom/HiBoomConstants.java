package com.tencent.mobileqq.hiboom;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.hiboom.api.IHiBoomManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public class HiBoomConstants
{
  public static int a = 300;
  public static AtomicBoolean b = new AtomicBoolean(false);
  public static AtomicBoolean c = new AtomicBoolean(false);
  public static HiBoomFont.HiBoomFontDownloader d = new HiBoomConstants.1();
  public static HiBoomFont.HiBoomFontDownloader e = new HiBoomConstants.2();
  
  public static int a(int paramInt)
  {
    HiBoomFontDrawer localHiBoomFontDrawer = HiBoomFont.a().a(paramInt, 0, e);
    if ((localHiBoomFontDrawer.b != 2) && (localHiBoomFontDrawer.b != 1) && (localHiBoomFontDrawer.b != 4) && (localHiBoomFontDrawer.b != 3)) {
      localHiBoomFontDrawer.d(false);
    }
    return localHiBoomFontDrawer.b;
  }
  
  public static IHiBoomManager a(AppRuntime paramAppRuntime)
  {
    return ((IVasService)paramAppRuntime.getRuntimeService(IVasService.class, "")).getHiBoomManager();
  }
  
  public static QQProgressDialog a(Context paramContext)
  {
    return ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getProgressDialog(paramContext);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return Pattern.compile("\\s*|\t|\r|\n").matcher(paramString).replaceAll("");
  }
  
  public static boolean b(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 2)
    {
      bool1 = bool2;
      if (paramInt != 1)
      {
        bool1 = bool2;
        if (paramInt != 3)
        {
          if (paramInt == 4) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomConstants
 * JD-Core Version:    0.7.0.1
 */