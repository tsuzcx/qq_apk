package com.tencent.mobileqq.vas.adapter;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.text.TextUtils;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManager;
import com.etrump.mixlayout.FontManagerForTool;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.simpleui.SimpleUIObserver;
import com.tencent.mobileqq.util.AppUtil;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.VasResEngine.VasResController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import java.io.File;
import mqq.app.AppRuntime;

public class ThemeFontAdapter
  extends SignatureFontAdapter
{
  static SimpleUIObserver jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIObserver = new ThemeFontAdapter.1();
  private static ThemeFontAdapter.FontBroadcastReceiver jdField_a_of_type_ComTencentMobileqqVasAdapterThemeFontAdapter$FontBroadcastReceiver;
  private static int b = 0;
  private static int c;
  private static int d;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasAdapterThemeFontAdapter$FontBroadcastReceiver = new ThemeFontAdapter.FontBroadcastReceiver();
    c = 10;
    d = 0;
  }
  
  public ThemeFontAdapter(VasRes paramVasRes, AppRuntime paramAppRuntime, int paramInt)
  {
    super(paramVasRes, paramAppRuntime, paramInt);
  }
  
  public static String a(Context paramContext)
  {
    return paramContext.getSharedPreferences("theme", 4).getString("theme_font_root_pre", null);
  }
  
  public static void a(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("theme", 4);
    paramContext.edit().remove("theme_font_root_pre").commit();
    paramContext.edit().remove("theme_font_root").commit();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("theme", 4);
    paramContext.edit().putString("theme_font_root_pre", paramString).commit();
    paramContext.edit().remove("theme_font_root").commit();
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      a(BaseApplicationImpl.getApplication().getApplicationContext());
    }
    if (!TextHook.getInstance().isDefault())
    {
      QLog.d("ThemeFontAdapter", 1, "resetDefaultFont");
      TextHook.getInstance().switchDefault();
      TextHook.getInstance().update(BaseApplicationImpl.getApplication().getApplicationContext());
    }
    b = 0;
    d = 0;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        break label22;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label22:
      File localFile = new File(paramString2);
      if (localFile.exists()) {
        return true;
      }
      paramString2 = paramString2 + "." + Process.myPid() + ".tmp";
      try
      {
        ETEngine.getInstanceForSpace();
        bool1 = ETEngine.native_ftf2ttf(paramString1, paramString2);
        if (bool1)
        {
          paramString1 = new File(paramString2);
          bool2 = paramString1.renameTo(localFile);
          bool1 = bool2;
          if (bool2) {
            continue;
          }
          QLog.e("ThemeFontAdapter", 1, "failed to move trueType font file, from path = " + paramString1.getAbsolutePath());
          return bool2;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("ThemeFontAdapter", 1, "call native_ftf2ttf error, errMsg = " + paramString1.toString());
        return false;
      }
    }
    QLog.e("ThemeFontAdapter", 1, "call native_ftf2ttf error");
    return bool1;
  }
  
  public static void b(int paramInt)
  {
    b((int)FontManager.a(paramInt), FontManager.b(paramInt));
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    QLog.d("ThemeFontAdapter", 1, "switchFont  fontId:" + paramInt1 + " fontType:" + paramInt2);
    if (b == paramInt1)
    {
      QLog.d("ThemeFontAdapter", 1, "switchFont already set fontId:" + paramInt1 + " fontType:" + paramInt2);
      return;
    }
    if (paramInt1 == 0)
    {
      a(true);
      return;
    }
    ThreadManagerV2.executeOnFileThread(new ThemeFontAdapter.2(paramInt1, paramInt2));
  }
  
  public static void b(Context paramContext)
  {
    TextHook.setSupportProcess(true);
    paramContext.registerReceiver(jdField_a_of_type_ComTencentMobileqqVasAdapterThemeFontAdapter$FontBroadcastReceiver, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
  }
  
  public static void c(Context paramContext)
  {
    paramContext.unregisterReceiver(jdField_a_of_type_ComTencentMobileqqVasAdapterThemeFontAdapter$FontBroadcastReceiver);
  }
  
  public static void d()
  {
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIObserver);
  }
  
  private static void d(int paramInt1, int paramInt2)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    VasRes localVasRes = new VasRes(localAppRuntime, paramInt1);
    localVasRes.a(new ThemeFontAdapter(localVasRes, localAppRuntime, paramInt2));
  }
  
  public void b()
  {
    if (AppUtil.a()) {}
    for (FontInfo localFontInfo = a(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController.a(), this.jdField_a_of_type_Int);; localFontInfo = FontManagerForTool.a().a(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController.a(), this.jdField_a_of_type_Int))
    {
      QLog.e("ThemeFontAdapter", 2, "load   fontInfo:" + localFontInfo + " sCurrentTryNumber:" + d);
      if (localFontInfo != null)
      {
        b(localFontInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
        c();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.ThemeFontAdapter
 * JD-Core Version:    0.7.0.1
 */