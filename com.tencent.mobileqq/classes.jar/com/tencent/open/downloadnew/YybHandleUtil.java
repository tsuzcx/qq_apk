package com.tencent.open.downloadnew;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import java.io.File;
import java.text.DecimalFormat;
import mqq.os.MqqHandler;

public class YybHandleUtil
{
  public static String a = "YybHandleUtil";
  public static String b = "APK/MobileAssistant_main.apk";
  public static String c = "yyb.apk";
  public static final String d = HardCodeUtil.a(2131716503);
  
  public static String a(int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    float f1 = paramInt;
    paramInt = 0;
    float f2 = f1 / 1048576.0F;
    if (f2 > 1.0F)
    {
      paramInt = 2;
      f1 = f2;
    }
    else
    {
      f2 = f1 / 1024.0F;
      if (f2 > 1.0F)
      {
        paramInt = 1;
        f1 = f2;
      }
    }
    String str2 = new DecimalFormat("#.#").format(f1);
    String str1;
    if (paramInt == 2) {
      str1 = "MB";
    } else if (paramInt == 1) {
      str1 = "KB";
    } else {
      str1 = "B";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2);
    localStringBuilder.append(str1);
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    LogUtility.c(a, "---deleteYYBApkPackage--");
    ThreadManager.getSubThreadHandler().post(new YybHandleUtil.1());
  }
  
  public static boolean a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(CommonDataAdapter.a().a().getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(c);
    localObject = ((StringBuilder)localObject).toString();
    return AppUtil.a(CommonDataAdapter.a().a(), (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.YybHandleUtil
 * JD-Core Version:    0.7.0.1
 */