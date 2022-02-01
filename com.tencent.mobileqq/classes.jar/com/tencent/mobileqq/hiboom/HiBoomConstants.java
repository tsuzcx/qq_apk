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
  public static HiBoomFont.HiBoomFontDownloader a;
  public static AtomicBoolean a;
  public static HiBoomFont.HiBoomFontDownloader b;
  public static AtomicBoolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader = new HiBoomConstants.1();
    jdField_b_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader = new HiBoomConstants.2();
  }
  
  public static int a(int paramInt)
  {
    HiBoomFontDrawer localHiBoomFontDrawer = HiBoomFont.a().a(paramInt, 0, jdField_b_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader);
    if ((localHiBoomFontDrawer.a != 2) && (localHiBoomFontDrawer.a != 1) && (localHiBoomFontDrawer.a != 4) && (localHiBoomFontDrawer.a != 3)) {
      localHiBoomFontDrawer.a(false);
    }
    return localHiBoomFontDrawer.a;
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
  
  public static boolean a(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomConstants
 * JD-Core Version:    0.7.0.1
 */