package com.tencent.mobileqq.startup.step;

import abiy;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import anwm;
import beiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinEngineLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinEngine.BackupForOOMData;
import com.tencent.theme.SkinEngineHandler;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import mqq.os.MqqHandler;

public class InitSkin
  extends OnceIfSuccessStep
{
  public static int a;
  public static final Object a;
  public static boolean a;
  private static final int[] a;
  public static boolean b;
  private static final int[] b;
  public static volatile boolean c;
  private static final int[] c;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_Int = 3000;
    jdField_a_of_type_ArrayOfInt = new int[] { 2130838039, 2130838302, 2130838301, 2130838300, 2130839274, 2130839378, 2130839377, 2130839409, 2130839411, 2130839415, 2130839399, 2130839544, 2130839662, 2130840347, 2130841382, 2130842496, 2130845814, 2130845813, 2130845809, 2130845808, 2130845804, 2130845803, 2130844144, 2130844159, 2130844160, 2130844161, 2130844162, 2130844163, 2130844164, 2130844165, 2130844166, 2130844167, 2130844170, 2130844169, 2130844171, 2130844172, 2130844173, 2130844175, 2130844174, 2130844184, 2130844185, 2130844186, 2130844187, 2130844188, 2130844189, 2130844190, 2130844191, 2130844192, 2130844193, 2130844194, 2130840283, 2130840282, 2130845702, 2130844370, 2130844372, 2130844160, 2130844276, 2130844370, 2130844372, 2130844159, 2130849563, 2130849839, 2130849825, 2130849824, 2130849846, 2130849845, 2130850350, 2130850235, 2130850231, 2130850024, 2130850099, 2130850404, 2130850117, 2130850113, 2130850121, 2130850127, 2130850125, 2130850105, 2130850055, 2130850062, 2130850063, 2130850075, 2130850350, 2130850313, 2130850314, 2130849057, 2130850330, 2130850335, 2130850333, 2130850341, 2130850337, 2130840291, 2130840295, 2130850149, 2130844225, 2130844224, 2130839402, 2130839403, 2130850238, 2130850234 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130837574, 2130837581, 2130837582, 2130837588, 2130837589, 2130837593, 2130837594, 2130839378, 2130839377, 2130849839, 2130840297, 2130840295, 2130850668, 2130850099, 2130850105, 2130850113, 2130850117, 2130850121, 2130850123, 2130850124, 2130850125, 2130850127, 2130850677, 2130850811, 2130840391, 2130840386, 2130840390, 2130840385, 2130840383, 2130840384, 2130844201, 2130844199, 2130844200, 2130840397, 2130840395, 2130840396, 2130838762, 2130850680, 2130841836, 2130841837, 2130841838, 2130841839, 2130850394, 2130850024, 2130850073, 2130850075, 2130842453, 2130842452, 2130842459, 2130850235, 2130850231, 2130850239, 2130850097, 2130850341, 2130850337, 2130850330, 2130839544, 2130850353, 2130850355, 2130850312, 2130850311 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2130837574, 2130837581, 2130837582, 2130837588, 2130837589, 2130837593, 2130837594, 2130838009, 2130838075, 2130838224, 2130838398, 2130838750, 2130838751, 2130838752, 2130838754, 2130838755, 2130838756, 2130838762, 2130838764, 2130838765, 2130838960, 2130839108, 2130839110, 2130839192, 2130839194, 2130839198, 2130839199, 2130839274, 2130839275, 2130839277, 2130839278, 2130839377, 2130839378, 2130839387, 2130839409, 2130839413, 2130839415, 2130839465, 2130839476, 2130839507, 2130839544, 2130839560, 2130839578, 2130839941, 2130839647, 2130839663, 2130837760, 2130840117, 2130840248, 2130840274, 2130848281, 2130848282, 2130840374, 2130840375, 2130848393, 2130841376, 2130841484, 2130842355, 2130842356, 2130842358, 2130842359, 2130843419, 2130843523, 2130844370, 2130844372, 2130845803, 2130845804, 2130845808, 2130845809, 2130845811, 2130845812, 2130845813, 2130845814, 2130845843, 2130847572, 2130847699, 2130847700, 2130847712, 2130847750, 2130847757, 2130847767, 2130847768, 2130847769, 2130847770, 2130847771, 2130847772, 2130847773, 2130847774, 2130847776, 2130847777, 2130847780, 2130847784, 2130847821, 2130847822, 2130847823, 2130847824, 2130847825, 2130847826, 2130847844, 2130847845, 2130848985, 2130837588, 2130847956, 2130847957, 2130847977, 2130847986, 2130848011, 2130848024, 2130848798, 2130848034, 2130848055, 2130848056, 2130848057, 2130848058, 2130848079, 2130848080, 2130848126, 2130848176, 2130848177, 2130848219, 2130848221, 2130848222, 2130848228, 2130848229, 2130848230, 2130848232, 2130848233, 2130848235, 2130848237, 2130848242, 2130848248, 2130848249, 2130848250, 2130848279, 2130848280, 2130848287, 2130848308, 2130848315, 2130848324, 2130848341, 2130848381, 2130848384, 2130848387, 2130848389, 2130848390, 2130848391, 2130848392, 2130848505, 2130848563, 2130848594, 2130848605, 2130848606, 2130848608, 2130848611, 2130848614, 2130845219, 2130848656, 2130848657, 2130848695, 2130848696, 2130848703, 2130848724, 2130848760, 2130848860, 2130848994, 2130849118, 2130849062, 2130849066, 2130849069, 2130849072, 2130849073, 2130849166, 2130849181, 2130849182, 2130849272, 2130849295, 2130849296, 2130849297, 2130849298, 2130849302, 2130849303, 2130849308, 2130849309, 2130849310, 2130849311, 2130849312, 2130849313, 2130849314, 2130849564, 2130849565, 2130849566, 2130849567, 2130849569, 2130849571, 2130849618, 2130849675, 2130849673, 2130849674, 2130849677, 2130850024, 2130850043, 2130850044, 2130850045, 2130850047, 2130850048, 2130850052, 2130850053, 2130850055, 2130850062, 2130850063, 2130850064, 2130850065, 2130850073, 2130850074, 2130850075, 2130850099, 2130850105, 2130850113, 2130850117, 2130850121, 2130850123, 2130850124, 2130850125, 2130850127, 2130850129, 2130850141, 2130850142, 2130850143, 2130850144, 2130850145, 2130850146, 2130850147, 2130850148, 2130850149, 2130850159, 2130850160, 2130850231, 2130850313, 2130850314, 2130850315, 2130850321, 2130850322, 2130849057, 2130849011, 2130849012, 2130849013, 2130849014, 2130849015, 2130850329, 2130850330, 2130850333, 2130850335, 2130850337, 2130850341, 2130850347, 2130850350, 2130850353, 2130850355, 2130850362, 2130850364, 2130850368, 2130850370, 2130850403, 2130850404, 2130850460, 2130850614, 2130850616, 2130850666, 2130850680, 2130850695, 2130850697 };
  }
  
  private static final int a(Context paramContext)
  {
    int i = 0;
    paramContext = paramContext.getResources();
    TypedValue localTypedValue = new TypedValue();
    paramContext.getValue(2130837504, localTypedValue, true);
    if (localTypedValue.string != null) {
      i = localTypedValue.assetCookie;
    }
    if (QLog.isColorLevel()) {
      QLog.i("InitSkin", 2, "getDefaultCookieId value.string=" + localTypedValue.string + ", cookieId=" + i);
    }
    return i;
  }
  
  private static MqqHandler a()
  {
    return new MqqHandler(ThreadManager.getSubThreadLooper());
  }
  
  public static void a()
  {
    if ((jdField_b_of_type_Boolean) && (!jdField_c_of_type_Boolean)) {
      if (QLog.isColorLevel()) {
        QLog.i("InitSkin", 2, "start waitAsynInitSkin");
      }
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      boolean bool = jdField_c_of_type_Boolean;
      if (!bool) {}
      try
      {
        jdField_a_of_type_JavaLangObject.wait(jdField_a_of_type_Int);
        if (QLog.isColorLevel()) {
          QLog.i("InitSkin", 2, "end waitAsynInitSkin InitSkin.sToolProcessInitComplete = " + jdField_c_of_type_Boolean);
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("InitSkin", 2, localInterruptedException.toString());
          }
        }
      }
    }
  }
  
  public static final boolean a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localFile2 = paramContext.getCacheDir();
        l1 = SystemClock.uptimeMillis();
        SkinEngine.SWITCH_DEBUG = false;
        SkinEngine.DEBUG = false;
        localFile1 = new File(localFile2, "/skin/web_config");
        localFile2 = new File(localFile2, "/skin/web_skin_cache");
      }
      catch (Exception localException1)
      {
        File localFile2;
        long l1;
        File localFile1;
        ObjectInputStream localObjectInputStream;
        int i;
        String str;
        long l2;
        BaseApplicationImpl.IS_SUPPORT_THEME = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SkinEngine", 2, "", localException1);
        paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
        if (paramContext.exists()) {
          continue;
        }
        if (paramContext.getParentFile().exists()) {
          continue;
        }
        paramContext.getParentFile().mkdirs();
        try
        {
          paramContext.createNewFile();
        }
        catch (IOException paramContext) {}
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "No cache found");
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131165184, null);
        ThreadManager.getSubThreadHandler().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/web_config", "/skin/web_skin_cache"), 10000L);
        continue;
      }
      try
      {
        if (!localFile1.exists()) {
          continue;
        }
        localObjectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile1)));
        i = localObjectInputStream.readInt();
        str = localObjectInputStream.readUTF();
        localObjectInputStream.close();
        if ((i != AppSetting.a()) || (!"6b9ba755".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "web skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131165184, localFile2);
      }
      catch (Exception localException3)
      {
        if (localFile1.exists()) {
          continue;
        }
        localFile1.delete();
        if (localFile2.exists()) {
          continue;
        }
        localFile2.delete();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "web skin Cache load failed.", localException3);
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131165184, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new abiy(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838778);
      SkinEngine.getInstances().addDrawableResource(2130839405);
      l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "web skin init skin engine cost: " + (l2 - l1));
        }
        return true;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label507;
        }
        QLog.e("SkinEngine", 2, "", localException2);
        SkinEngine.getInstances().unInit();
        throw localException2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "web skin cache time out");
      }
      SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131165184, null);
      ThreadManager.getSubThreadHandler().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/web_config", "/skin/web_skin_cache"), 10000L);
    }
  }
  
  private void b()
  {
    jdField_b_of_type_Boolean = false;
    Object localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("dpcConfig", 4).getString("tool_process_profile", "");
    boolean bool;
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      Object localObject1 = localObject2;
      if (((String)localObject2).indexOf('{', 0) == 0)
      {
        localObject1 = localObject2;
        if (((String)localObject2).lastIndexOf('}') == ((String)localObject2).length() - 1) {
          localObject1 = ((String)localObject2).substring(1, ((String)localObject2).length() - 1);
        }
      }
      localObject2 = new Integer[2];
      Arrays.fill((Object[])localObject2, Integer.valueOf(0));
      if (DeviceProfileManager.a((String)localObject1, (Object[])localObject2, new anwm()) >= 2)
      {
        if (localObject2[0].intValue() != 1) {
          break label223;
        }
        bool = true;
        jdField_b_of_type_Boolean = bool;
        if (localObject2[1].intValue() <= 0) {
          break label228;
        }
        i = localObject2[1].intValue();
        label150:
        jdField_a_of_type_Int = i;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("InitSkin", 2, "ToolAsynInitDPC = " + jdField_b_of_type_Boolean + "  sToolInitTimeout = " + jdField_a_of_type_Int);
    }
    if (jdField_b_of_type_Boolean) {
      ThreadManager.post(new InitSkin.1(this), 8, null, false);
    }
    label223:
    label228:
    do
    {
      return;
      bool = false;
      break;
      i = 0;
      break label150;
      if (QLog.isColorLevel()) {
        QLog.i("InitSkin", 2, "start synInitSkin");
      }
      initSkin(BaseApplicationImpl.sApplication);
      jdField_c_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.i("InitSkin", 2, "end synInitSkin");
  }
  
  @TargetApi(16)
  public static final boolean b(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localFile2 = paramContext.getCacheDir();
        l1 = SystemClock.uptimeMillis();
        SkinEngine.SWITCH_DEBUG = false;
        SkinEngine.DEBUG = false;
        localFile1 = new File(localFile2, "/skin/qzone_config");
        localFile2 = new File(localFile2, "/skin/qzone_skin_cache");
      }
      catch (Exception localException1)
      {
        File localFile2;
        long l1;
        File localFile1;
        ObjectInputStream localObjectInputStream;
        int i;
        String str;
        long l2;
        BaseApplicationImpl.IS_SUPPORT_THEME = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SkinEngine", 2, "", localException1);
        paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
        if (paramContext.exists()) {
          continue;
        }
        if (paramContext.getParentFile().exists()) {
          continue;
        }
        paramContext.getParentFile().mkdirs();
        try
        {
          paramContext.createNewFile();
        }
        catch (IOException paramContext) {}
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "No cache found");
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131165184, null);
        a().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
        continue;
      }
      try
      {
        if (!localFile1.exists()) {
          continue;
        }
        localObjectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile1)));
        i = localObjectInputStream.readInt();
        str = localObjectInputStream.readUTF();
        localObjectInputStream.close();
        if ((i != AppSetting.a()) || (!"6b9ba755".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qzone skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131165184, localFile2);
      }
      catch (Exception localException3)
      {
        if (localFile1.exists()) {
          continue;
        }
        localFile1.delete();
        if (localFile2.exists()) {
          continue;
        }
        localFile2.delete();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "qzone skin Cache load failed.", localException3);
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131165184, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new abiy(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838778);
      SkinEngine.getInstances().addDrawableResource(2130839099);
      SkinEngine.getInstances().addDrawableResource(2130839405);
      SkinEngine.getInstances().addDrawableResource(2130839109);
      l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qzone skin init skin engine cost: " + (l2 - l1));
        }
        return true;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label525;
        }
        QLog.e("SkinEngine", 2, "", localException2);
        SkinEngine.getInstances().unInit();
        throw localException2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "qzone skin cache time out");
      }
      SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131165184, null);
      a().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
    }
  }
  
  public static final boolean initSkin(Context paramContext)
  {
    File localFile;
    for (;;)
    {
      try
      {
        localFile = paramContext.getCacheDir();
        l1 = SystemClock.uptimeMillis();
        SkinEngine.SWITCH_DEBUG = false;
        SkinEngine.DEBUG = false;
        localObject1 = new abiy(BaseApplicationImpl.getApplication());
        SkinEngine.setSKLog((ISkinEngineLog)localObject1);
      }
      catch (Exception localException1)
      {
        long l1;
        Object localObject1;
        Object localObject2;
        int i;
        String str;
        BaseApplicationImpl.IS_SUPPORT_THEME = false;
        QLog.e("SkinEngine", 1, "Init SkinEngine Error:", localException1);
        paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
        if (paramContext.exists()) {
          break label692;
        }
        if (paramContext.getParentFile().exists()) {
          continue;
        }
        paramContext.getParentFile().mkdirs();
        try
        {
          paramContext.createNewFile();
        }
        catch (IOException paramContext) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "No cache found");
        SkinEngine.init(paramContext, 8191, 2130837504, 2130850901, 1264, 2131165184, null);
        ThreadManager.getSubThreadHandler().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/config", str), 10000L);
        continue;
      }
      try
      {
        localObject2 = BaseApplicationImpl.sApplication;
        if (((Application)localObject2).getPackageManager().getApplicationInfo(((Application)localObject2).getPackageName(), 128).metaData.getBoolean("com.sec.android.support.multiwindow"))
        {
          SkinEngine.mIconResourceID = Integer.valueOf(2130840347);
          if (QLog.isColorLevel()) {
            QLog.d("SkinEngine", 2, "Set icon resouceID to " + 2130840347);
          }
        }
        i = a(paramContext);
        str = "/skin/skin_cache_mobileqq_" + AppSetting.a() + "_" + "6b9ba755" + "_" + i;
        localObject2 = new File(localFile, "/skin/config");
        localFile = new File(localFile, str);
        try
        {
          if (!localFile.exists()) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SkinEngine", 2, "cache find, use cache file accered");
          }
          SkinEngine.init(paramContext, 8191, 2130837504, 2130850901, 1264, 2131165184, localFile);
        }
        catch (Exception localException3)
        {
          long l2;
          if (!localNameNotFoundException.exists()) {
            break label614;
          }
          localNameNotFoundException.delete();
          if (!localFile.exists()) {
            break label628;
          }
          localFile.delete();
          if (!QLog.isColorLevel()) {
            break label646;
          }
          QLog.d("SkinEngine", 2, "Cache load failed.", localException3);
          SkinEngine.init(paramContext, 8191, 2130837504, 2130850901, 1264, 2131165184, null);
          continue;
        }
        SkinEngine.getInstances().setSkinEngineHandler((SkinEngineHandler)localObject1);
        SkinEngine.getInstances().addDrawableResource(2130838778);
        SkinEngine.getInstances().addDrawableResource(2130839099);
        SkinEngine.getInstances().addDrawableResource(2130838779);
        SkinEngine.getInstances().addDrawableResource(2130850295);
        SkinEngine.getInstances().addDrawableResource(2130839405);
        SkinEngine.getInstances().addDrawableResource(2130839109);
        l2 = SystemClock.uptimeMillis();
        localObject1 = new SkinEngine.BackupForOOMData(2130850036, 2130850038, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130850036), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130846063, 2130850038, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130846063), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130850026, 2130850038, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130850026), (SkinEngine.BackupForOOMData)localObject1);
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        try
        {
          paramContext.getResources().getDrawable(2130837504);
          if (BaseApplicationImpl.sProcessId == 1) {
            ThemeUtil.initTheme(null);
          }
          if (!QLog.isColorLevel()) {
            break label692;
          }
          QLog.d("SkinEngine", 2, "init skin engine cost: " + (l2 - l1));
        }
        catch (Exception localException2)
        {
          QLog.e("SkinEngine", 1, "getDrawable(R.drawable.a) error:", localException2);
          SkinEngine.getInstances().unInit();
          throw localException2;
        }
        localNameNotFoundException = localNameNotFoundException;
        localNameNotFoundException.printStackTrace();
      }
    }
    label614:
    label628:
    return true;
  }
  
  protected boolean doStep()
  {
    if (jdField_a_of_type_Boolean) {}
    String str;
    do
    {
      return true;
      jdField_a_of_type_Boolean = true;
      String[] arrayOfString = BaseApplicationImpl.processName.split(":");
      str = null;
      if (arrayOfString.length > 1) {
        str = arrayOfString[1];
      }
      SkinEngine.getInstances().setSkinTint(new beiw());
      if ((str == null) || (str.endsWith("map")) || (str.equals("qzone")) || (str.equals("picture")) || (str.equals("pedit")) || (str.equals("plugin")) || (str.equals("demoji")) || (str.equals("peak")) || (str.equals("readinjoy")) || (str.endsWith("nearby")) || (str.equals("tool")) || (str.equals("qqfav")))
      {
        if ("tool".equals(str))
        {
          b();
          return true;
        }
        initSkin(BaseApplicationImpl.sApplication);
        return true;
      }
      if (str.equals("qzone"))
      {
        b(BaseApplicationImpl.sApplication);
        return true;
      }
    } while (!str.equals("web"));
    a(BaseApplicationImpl.sApplication);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitSkin
 * JD-Core Version:    0.7.0.1
 */