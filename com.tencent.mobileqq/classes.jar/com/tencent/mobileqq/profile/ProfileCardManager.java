package com.tencent.mobileqq.profile;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProfileCardManager
{
  public static Map a;
  public static Map b = new ConcurrentHashMap();
  protected Context a;
  protected AppInterface a;
  Map c = new ConcurrentHashMap();
  Map d = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public ProfileCardManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramAppInterface.getApp().getApplicationContext();
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    return ProfileCardUtil.c(paramContext) + paramLong + File.separator;
  }
  
  public static String a(Context paramContext, long paramLong1, long paramLong2)
  {
    if (paramLong1 == ProfileCardTemplate.j) {
      return a(paramContext, paramLong2) + "wzBgImage.png";
    }
    if (paramLong1 == ProfileCardTemplate.i) {
      return a(paramContext, paramLong2) + "wzJoinImage.png";
    }
    return a(paramContext, paramLong2) + "cardPreview.jpg";
  }
  
  public static boolean a(Context paramContext, long paramLong)
  {
    paramContext = a(paramContext, paramLong);
    if (TextUtils.isEmpty(paramContext)) {}
    for (paramContext = null; (paramContext != null) && (paramContext.exists()) && (paramContext.isDirectory()) && (paramContext.list().length > 1); paramContext = new File(paramContext)) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, long paramLong, String paramString)
  {
    paramContext = new File(a(paramContext, paramLong), paramString);
    return (paramContext.exists()) && ((!paramContext.isDirectory()) || (paramContext.list().length > 1));
  }
  
  public static String b(Context paramContext, long paramLong)
  {
    return ProfileCardUtil.c(paramContext) + paramLong + ".zip";
  }
  
  public static String b(Context paramContext, long paramLong1, long paramLong2)
  {
    if (paramLong1 == ProfileCardTemplate.j) {
      return a(paramContext, paramLong2) + "wzDynamicDrawerImage.png";
    }
    if (paramLong1 == ProfileCardTemplate.i) {
      return a(paramContext, paramLong2) + "wzJoinImage.png";
    }
    return a(paramContext, paramLong2) + "cardPreview.jpg";
  }
  
  public int a(long paramLong)
  {
    int i = 0;
    if (this.c.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.c.get(Long.valueOf(paramLong))).intValue();
    }
    return i;
  }
  
  public void a(long paramLong)
  {
    ((VasQuickUpdateManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(183)).a(15L, "card." + paramLong);
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.c.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardManager", 2, "downloadProfileCardRes scid=" + paramString);
    }
    if ((this.d.containsKey(paramString)) && (((Boolean)this.d.get(paramString)).booleanValue())) {
      return;
    }
    this.d.put(paramString, Boolean.valueOf(true));
    ((VasQuickUpdateManager)paramQQAppInterface.getManager(183)).a(15L, paramString, "ProfileCardRes");
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    this.d.put(paramString1, Boolean.valueOf(false));
    if (paramInt == 0)
    {
      l = Long.parseLong(paramString1.substring("card.".length(), paramString1.length()));
      jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), Boolean.valueOf(true));
      b.put(Long.valueOf(l), Boolean.valueOf(true));
      paramString1 = a(paramQQAppInterface.getApp(), l);
      paramQQAppInterface = new File(b(paramQQAppInterface.getApp(), l));
      if (!paramQQAppInterface.exists()) {
        QLog.e("ProfileCardManager", 1, "unzip file is missing " + paramQQAppInterface.getAbsolutePath());
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        long l;
        return;
        try
        {
          FileUtils.a(paramQQAppInterface.getAbsolutePath(), paramString1, false);
          VasQuickUpdateEngine.safeDeleteFile(paramQQAppInterface);
          paramString2 = new File(paramString1, "dynamic.zip");
          if (paramString2.exists())
          {
            String str = paramString1 + ".dynamic";
            FileUtils.a(paramString2.getAbsolutePath(), str, false);
            VasQuickUpdateEngine.safeDeleteFile(paramString2);
          }
          if (QLog.isColorLevel())
          {
            QLog.d("ProfileCardManager", 2, "onDownloadComplete, resDir= " + paramString1);
            return;
          }
        }
        catch (OutOfMemoryError paramString2)
        {
          for (;;)
          {
            QLog.e("ProfileCardManager", 1, "failed to unzip " + paramQQAppInterface.getAbsolutePath(), paramString2);
          }
        }
        catch (Throwable paramString2)
        {
          for (;;)
          {
            QLog.e("ProfileCardManager", 1, "failed to unzip " + paramQQAppInterface.getAbsolutePath(), paramString2);
          }
        }
      }
    }
    QLog.d("ProfileCardManager", 2, "onDownloadComplete failed, errorCode = " + paramInt);
  }
  
  public boolean b(Context paramContext, long paramLong)
  {
    return VasQuickUpdateEngine.safeDeleteFile(new File(a(paramContext, paramLong)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardManager
 * JD-Core Version:    0.7.0.1
 */