package com.tencent.mobileqq.vas.adapter;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.text.TextUtils;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManagerForTool;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.simpleui.SimpleUIObserver;
import com.tencent.mobileqq.util.AppUtil;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.VasResEngine.VasResController;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import java.io.File;
import mqq.app.AppRuntime;

public class ThemeFontAdapter
  extends SignatureFontAdapter
{
  static SimpleUIObserver jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIObserver = new ThemeFontAdapter.1();
  private static ThemeFontAdapter.FontBroadcastReceiver jdField_a_of_type_ComTencentMobileqqVasAdapterThemeFontAdapter$FontBroadcastReceiver = new ThemeFontAdapter.FontBroadcastReceiver();
  private static int b;
  private static int c = 10;
  private static int d = 0;
  
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
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      File localFile = new File(paramString2);
      if (localFile.exists()) {
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(".");
      localStringBuilder.append(Process.myPid());
      localStringBuilder.append(".tmp");
      paramString2 = localStringBuilder.toString();
      try
      {
        ETEngine.getInstanceForSpace();
        boolean bool = ETEngine.native_ftf2ttf(paramString1, paramString2);
        if (bool)
        {
          paramString1 = new File(paramString2);
          bool = paramString1.renameTo(localFile);
          if (!bool)
          {
            paramString2 = new StringBuilder();
            paramString2.append("failed to move trueType font file, from path = ");
            paramString2.append(paramString1.getAbsolutePath());
            QLog.e("ThemeFontAdapter", 1, paramString2.toString());
          }
          return bool;
        }
        QLog.e("ThemeFontAdapter", 1, "call native_ftf2ttf error");
        return bool;
      }
      catch (Throwable paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("call native_ftf2ttf error, errMsg = ");
        paramString2.append(paramString1.toString());
        QLog.e("ThemeFontAdapter", 1, paramString2.toString());
      }
    }
    return false;
  }
  
  public static void b(int paramInt)
  {
    long l = paramInt;
    b((int)FontManagerConstants.parseFontId(l), FontManagerConstants.parseFontType(l));
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchFont  fontId:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" fontType:");
    localStringBuilder.append(paramInt2);
    QLog.d("ThemeFontAdapter", 1, localStringBuilder.toString());
    if (b == paramInt1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchFont already set fontId:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" fontType:");
      localStringBuilder.append(paramInt2);
      QLog.d("ThemeFontAdapter", 1, localStringBuilder.toString());
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
  
  public static void c()
  {
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIObserver);
  }
  
  public static void c(Context paramContext)
  {
    paramContext.unregisterReceiver(jdField_a_of_type_ComTencentMobileqqVasAdapterThemeFontAdapter$FontBroadcastReceiver);
  }
  
  private static void d(int paramInt1, int paramInt2)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    VasRes localVasRes = new VasRes(localAppRuntime, paramInt1);
    localVasRes.a(new ThemeFontAdapter(localVasRes, localAppRuntime, paramInt2));
  }
  
  public void a()
  {
    FontInfo localFontInfo;
    if (AppUtil.a()) {
      localFontInfo = a(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController.a(), this.jdField_a_of_type_Int);
    } else {
      localFontInfo = FontManagerForTool.a().a(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController.a(), this.jdField_a_of_type_Int);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("load   fontInfo:");
    localStringBuilder.append(localFontInfo);
    localStringBuilder.append(" sCurrentTryNumber:");
    localStringBuilder.append(d);
    QLog.e("ThemeFontAdapter", 2, localStringBuilder.toString());
    if (localFontInfo != null)
    {
      b(localFontInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.ThemeFontAdapter
 * JD-Core Version:    0.7.0.1
 */