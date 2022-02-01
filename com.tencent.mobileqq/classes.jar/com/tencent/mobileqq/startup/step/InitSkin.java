package com.tencent.mobileqq.startup.step;

import aafh;
import amqv;
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
import bdbs;
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
    jdField_a_of_type_ArrayOfInt = new int[] { 2130838064, 2130838327, 2130838326, 2130838325, 2130839309, 2130839413, 2130839412, 2130839444, 2130839446, 2130839450, 2130839434, 2130839579, 2130839699, 2130840385, 2130841418, 2130842542, 2130845714, 2130845713, 2130845709, 2130845708, 2130845704, 2130845703, 2130844028, 2130844043, 2130844044, 2130844045, 2130844046, 2130844047, 2130844048, 2130844049, 2130844050, 2130844051, 2130844054, 2130844053, 2130844055, 2130844056, 2130844057, 2130844059, 2130844058, 2130844068, 2130844069, 2130844070, 2130844071, 2130844072, 2130844073, 2130844074, 2130844075, 2130844076, 2130844077, 2130844078, 2130840321, 2130840320, 2130845581, 2130844255, 2130844257, 2130844044, 2130844161, 2130844255, 2130844257, 2130844043, 2130849475, 2130849756, 2130849742, 2130849741, 2130849763, 2130849762, 2130850271, 2130850156, 2130850152, 2130849941, 2130850016, 2130850325, 2130850034, 2130850030, 2130850038, 2130850044, 2130850042, 2130850022, 2130849972, 2130849979, 2130849980, 2130849992, 2130850271, 2130850234, 2130850235, 2130848968, 2130850251, 2130850256, 2130850254, 2130850262, 2130850258, 2130840329, 2130840333, 2130850066, 2130844110, 2130844109, 2130839437, 2130839438, 2130850159, 2130850155 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130837574, 2130837581, 2130837582, 2130837588, 2130837589, 2130837593, 2130837594, 2130839413, 2130839412, 2130849756, 2130840335, 2130840333, 2130850593, 2130850016, 2130850022, 2130850030, 2130850034, 2130850038, 2130850040, 2130850041, 2130850042, 2130850044, 2130850602, 2130850745, 2130840429, 2130840424, 2130840428, 2130840423, 2130840421, 2130840422, 2130844085, 2130844083, 2130844084, 2130840435, 2130840433, 2130840434, 2130838831, 2130850605, 2130841878, 2130841879, 2130841880, 2130841881, 2130850315, 2130849941, 2130849990, 2130849992, 2130842499, 2130842498, 2130842505, 2130850156, 2130850152, 2130850160, 2130850014, 2130850262, 2130850258, 2130850251, 2130839579, 2130850274, 2130850276, 2130850233, 2130850232 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2130837574, 2130837581, 2130837582, 2130837588, 2130837589, 2130837593, 2130837594, 2130838034, 2130838100, 2130838255, 2130838423, 2130838778, 2130838779, 2130838780, 2130838782, 2130838783, 2130838791, 2130838831, 2130838842, 2130838844, 2130838995, 2130839143, 2130839145, 2130839227, 2130839229, 2130839233, 2130839234, 2130839309, 2130839310, 2130839312, 2130839313, 2130839412, 2130839413, 2130839422, 2130839444, 2130839448, 2130839450, 2130839500, 2130839511, 2130839542, 2130839579, 2130839595, 2130839613, 2130839941, 2130839684, 2130839700, 2130837760, 2130840154, 2130840285, 2130840312, 2130848192, 2130848193, 2130840412, 2130840413, 2130848304, 2130841412, 2130841520, 2130842397, 2130842398, 2130842400, 2130842401, 2130843481, 2130843585, 2130844255, 2130844257, 2130845703, 2130845704, 2130845708, 2130845709, 2130845711, 2130845712, 2130845713, 2130845714, 2130845743, 2130847481, 2130847609, 2130847610, 2130847622, 2130847660, 2130847667, 2130847677, 2130847678, 2130847679, 2130847680, 2130847681, 2130847682, 2130847683, 2130847684, 2130847686, 2130847687, 2130847690, 2130847694, 2130847731, 2130847732, 2130847733, 2130847734, 2130847735, 2130847736, 2130847754, 2130847755, 2130848896, 2130837588, 2130847866, 2130847867, 2130847887, 2130847896, 2130847921, 2130847934, 2130848709, 2130847944, 2130847966, 2130847967, 2130847968, 2130847969, 2130847990, 2130847991, 2130848037, 2130848087, 2130848088, 2130848130, 2130848132, 2130848133, 2130848139, 2130848140, 2130848141, 2130848143, 2130848144, 2130848146, 2130848148, 2130848153, 2130848159, 2130848160, 2130848161, 2130848190, 2130848191, 2130848198, 2130848219, 2130848226, 2130848235, 2130848252, 2130848292, 2130848295, 2130848298, 2130848300, 2130848301, 2130848302, 2130848303, 2130848416, 2130848474, 2130848505, 2130848516, 2130848517, 2130848519, 2130848522, 2130848525, 2130845106, 2130848567, 2130848568, 2130848606, 2130848607, 2130848614, 2130848635, 2130848671, 2130848771, 2130848905, 2130849029, 2130848973, 2130848977, 2130848980, 2130848983, 2130848984, 2130849077, 2130849092, 2130849093, 2130849183, 2130849206, 2130849207, 2130849208, 2130849209, 2130849213, 2130849214, 2130849219, 2130849220, 2130849221, 2130849222, 2130849223, 2130849224, 2130849225, 2130849476, 2130849477, 2130849478, 2130849479, 2130849481, 2130849483, 2130849530, 2130849592, 2130849590, 2130849591, 2130849594, 2130849941, 2130849960, 2130849961, 2130849962, 2130849964, 2130849965, 2130849969, 2130849970, 2130849972, 2130849979, 2130849980, 2130849981, 2130849982, 2130849990, 2130849991, 2130849992, 2130850016, 2130850022, 2130850030, 2130850034, 2130850038, 2130850040, 2130850041, 2130850042, 2130850044, 2130850046, 2130850058, 2130850059, 2130850060, 2130850061, 2130850062, 2130850063, 2130850064, 2130850065, 2130850066, 2130850077, 2130850078, 2130850152, 2130850234, 2130850235, 2130850236, 2130850242, 2130850243, 2130848968, 2130848922, 2130848923, 2130848924, 2130848925, 2130848926, 2130850250, 2130850251, 2130850254, 2130850256, 2130850258, 2130850262, 2130850268, 2130850271, 2130850274, 2130850276, 2130850283, 2130850285, 2130850289, 2130850291, 2130850324, 2130850325, 2130850385, 2130850539, 2130850541, 2130850591, 2130850605, 2130850620, 2130850622 };
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
        if ((i != AppSetting.a()) || (!"94cf45ad".equals(str))) {
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
      SkinEngine.getInstances().setSkinEngineHandler(new aafh(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838891);
      SkinEngine.getInstances().addDrawableResource(2130839440);
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
      if (DeviceProfileManager.a((String)localObject1, (Object[])localObject2, new amqv()) >= 2)
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
        if ((i != AppSetting.a()) || (!"94cf45ad".equals(str))) {
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
      SkinEngine.getInstances().setSkinEngineHandler(new aafh(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838891);
      SkinEngine.getInstances().addDrawableResource(2130839134);
      SkinEngine.getInstances().addDrawableResource(2130839440);
      SkinEngine.getInstances().addDrawableResource(2130839144);
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
        localObject1 = new aafh(BaseApplicationImpl.getApplication());
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
        SkinEngine.init(paramContext, 8191, 2130837504, 2130850838, 1264, 2131165184, null);
        ThreadManager.getSubThreadHandler().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/config", str), 10000L);
        continue;
      }
      try
      {
        localObject2 = BaseApplicationImpl.sApplication;
        if (((Application)localObject2).getPackageManager().getApplicationInfo(((Application)localObject2).getPackageName(), 128).metaData.getBoolean("com.sec.android.support.multiwindow"))
        {
          SkinEngine.mIconResourceID = Integer.valueOf(2130840385);
          if (QLog.isColorLevel()) {
            QLog.d("SkinEngine", 2, "Set icon resouceID to " + 2130840385);
          }
        }
        i = a(paramContext);
        str = "/skin/skin_cache_mobileqq_" + AppSetting.a() + "_" + "94cf45ad" + "_" + i;
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
          SkinEngine.init(paramContext, 8191, 2130837504, 2130850838, 1264, 2131165184, localFile);
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
          SkinEngine.init(paramContext, 8191, 2130837504, 2130850838, 1264, 2131165184, null);
          continue;
        }
        SkinEngine.getInstances().setSkinEngineHandler((SkinEngineHandler)localObject1);
        SkinEngine.getInstances().addDrawableResource(2130838891);
        SkinEngine.getInstances().addDrawableResource(2130839134);
        SkinEngine.getInstances().addDrawableResource(2130838892);
        SkinEngine.getInstances().addDrawableResource(2130850216);
        SkinEngine.getInstances().addDrawableResource(2130839440);
        SkinEngine.getInstances().addDrawableResource(2130839144);
        l2 = SystemClock.uptimeMillis();
        localObject1 = new SkinEngine.BackupForOOMData(2130849953, 2130849955, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130849953), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130845954, 2130849955, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130845954), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130849943, 2130849955, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130849943), (SkinEngine.BackupForOOMData)localObject1);
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
      SkinEngine.getInstances().setSkinTint(new bdbs());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitSkin
 * JD-Core Version:    0.7.0.1
 */