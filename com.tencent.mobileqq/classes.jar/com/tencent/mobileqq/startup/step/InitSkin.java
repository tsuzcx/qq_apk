package com.tencent.mobileqq.startup.step;

import alrg;
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
import baow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.QQAppInterface;
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
import zhw;

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
    jdField_a_of_type_ArrayOfInt = new int[] { 2130837935, 2130838179, 2130838178, 2130838177, 2130839093, 2130839194, 2130839193, 2130839224, 2130839226, 2130839230, 2130839214, 2130839356, 2130839479, 2130840158, 2130841122, 2130842173, 2130845402, 2130845401, 2130845397, 2130845396, 2130845392, 2130845391, 2130843764, 2130843770, 2130843771, 2130843772, 2130843773, 2130843774, 2130843775, 2130843776, 2130843777, 2130843778, 2130843781, 2130843780, 2130843782, 2130843783, 2130843784, 2130843786, 2130843785, 2130843795, 2130843796, 2130843797, 2130843798, 2130843799, 2130843800, 2130843801, 2130843802, 2130843803, 2130843804, 2130843805, 2130840094, 2130840093, 2130845291, 2130843962, 2130843964, 2130843771, 2130843874, 2130843962, 2130843964, 2130843770, 2130849020, 2130849277, 2130849263, 2130849262, 2130849284, 2130849283, 2130849752, 2130849647, 2130849643, 2130849461, 2130849536, 2130849805, 2130849554, 2130849550, 2130849558, 2130849564, 2130849562, 2130849542, 2130849492, 2130849499, 2130849500, 2130849512, 2130849752, 2130849715, 2130849716, 2130848562, 2130849732, 2130849737, 2130849735, 2130849743, 2130849739, 2130840102, 2130840106, 2130849586, 2130843825, 2130843824, 2130839217, 2130839218, 2130849650, 2130849646 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130837562, 2130837569, 2130837570, 2130837573, 2130837574, 2130837576, 2130837577, 2130839194, 2130839193, 2130849277, 2130840108, 2130840106, 2130850060, 2130849536, 2130849542, 2130849550, 2130849554, 2130849558, 2130849560, 2130849561, 2130849562, 2130849564, 2130850069, 2130850195, 2130840201, 2130840196, 2130840200, 2130840195, 2130840193, 2130840194, 2130843812, 2130843810, 2130843811, 2130840207, 2130840205, 2130840206, 2130838578, 2130850072, 2130841521, 2130841522, 2130841523, 2130841524, 2130849796, 2130849461, 2130849510, 2130849512, 2130842130, 2130842129, 2130842136, 2130849647, 2130849643, 2130849651, 2130849534, 2130849743, 2130849739, 2130849732, 2130839356, 2130849755, 2130849757, 2130849714, 2130849713 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2130837562, 2130837569, 2130837570, 2130837573, 2130837574, 2130837576, 2130837577, 2130837906, 2130837971, 2130838118, 2130838287, 2130838566, 2130838567, 2130838568, 2130838570, 2130838571, 2130838572, 2130838578, 2130838579, 2130838580, 2130838700, 2130838934, 2130838936, 2130839016, 2130839017, 2130839020, 2130839021, 2130839093, 2130839094, 2130839096, 2130839097, 2130839193, 2130839194, 2130839203, 2130839224, 2130839228, 2130839230, 2130839279, 2130839290, 2130839322, 2130839356, 2130839372, 2130839390, 2130839941, 2130839464, 2130839480, 2130837760, 2130839702, 2130840060, 2130840085, 2130847802, 2130847803, 2130840184, 2130840185, 2130847898, 2130841116, 2130841171, 2130842034, 2130842035, 2130842037, 2130842038, 2130843054, 2130843158, 2130843962, 2130843964, 2130845391, 2130845392, 2130845396, 2130845397, 2130845399, 2130845400, 2130845401, 2130845402, 2130845431, 2130847094, 2130847221, 2130847222, 2130847234, 2130847272, 2130847279, 2130847289, 2130847290, 2130847291, 2130847292, 2130847293, 2130847294, 2130847295, 2130847296, 2130847298, 2130847299, 2130847302, 2130847306, 2130847343, 2130847344, 2130847345, 2130847346, 2130847347, 2130847348, 2130847366, 2130847367, 2130848490, 2130837573, 2130847477, 2130847478, 2130847498, 2130847507, 2130847532, 2130847545, 2130848303, 2130847555, 2130847576, 2130847577, 2130847578, 2130847579, 2130847600, 2130847601, 2130847647, 2130847697, 2130847698, 2130847740, 2130847742, 2130847743, 2130847749, 2130847750, 2130847751, 2130847753, 2130847754, 2130847756, 2130847758, 2130847763, 2130847769, 2130847770, 2130847771, 2130847800, 2130847801, 2130847808, 2130847813, 2130847820, 2130847829, 2130847846, 2130847886, 2130847889, 2130847892, 2130847894, 2130847895, 2130847896, 2130847897, 2130848010, 2130848068, 2130848099, 2130848110, 2130848111, 2130848113, 2130848116, 2130848119, 2130844807, 2130848161, 2130848162, 2130848200, 2130848201, 2130848208, 2130848229, 2130848265, 2130848365, 2130848499, 2130848623, 2130848567, 2130848571, 2130848574, 2130848577, 2130848578, 2130848671, 2130848686, 2130848687, 2130848775, 2130848798, 2130848799, 2130848800, 2130848801, 2130848805, 2130848806, 2130848811, 2130848812, 2130848813, 2130848814, 2130848815, 2130848816, 2130848817, 2130849021, 2130849022, 2130849023, 2130849024, 2130849026, 2130849028, 2130849068, 2130849124, 2130849122, 2130849123, 2130849126, 2130849461, 2130849480, 2130849481, 2130849482, 2130849484, 2130849485, 2130849489, 2130849490, 2130849492, 2130849499, 2130849500, 2130849501, 2130849502, 2130849510, 2130849511, 2130849512, 2130849536, 2130849542, 2130849550, 2130849554, 2130849558, 2130849560, 2130849561, 2130849562, 2130849564, 2130849566, 2130849578, 2130849579, 2130849580, 2130849581, 2130849582, 2130849583, 2130849584, 2130849585, 2130849586, 2130849596, 2130849597, 2130849643, 2130849715, 2130849716, 2130849717, 2130849723, 2130849724, 2130848562, 2130848516, 2130848517, 2130848518, 2130848519, 2130848520, 2130849731, 2130849732, 2130849735, 2130849737, 2130849739, 2130849743, 2130849749, 2130849752, 2130849755, 2130849757, 2130849764, 2130849766, 2130849770, 2130849772, 2130849804, 2130849805, 2130849859, 2130850009, 2130850011, 2130850058, 2130850072, 2130850085, 2130850087 };
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
        if ((i != AppSetting.a()) || (!"fd2cc8f9".equals(str))) {
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
      SkinEngine.getInstances().setSkinEngineHandler(new zhw(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838592);
      SkinEngine.getInstances().addDrawableResource(2130839220);
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
      if (DeviceProfileManager.a((String)localObject1, (Object[])localObject2, new alrg()) >= 2)
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
        if ((i != AppSetting.a()) || (!"fd2cc8f9".equals(str))) {
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
      SkinEngine.getInstances().setSkinEngineHandler(new zhw(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838592);
      SkinEngine.getInstances().addDrawableResource(2130838925);
      SkinEngine.getInstances().addDrawableResource(2130839220);
      SkinEngine.getInstances().addDrawableResource(2130838935);
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
        localObject1 = new zhw(BaseApplicationImpl.getApplication());
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
          break label688;
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
        SkinEngine.init(paramContext, 8191, 2130837504, 1264, 2131165184, null);
        ThreadManager.getSubThreadHandler().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/config", str), 10000L);
        continue;
      }
      try
      {
        localObject2 = BaseApplicationImpl.sApplication;
        if (((Application)localObject2).getPackageManager().getApplicationInfo(((Application)localObject2).getPackageName(), 128).metaData.getBoolean("com.sec.android.support.multiwindow"))
        {
          SkinEngine.mIconResourceID = Integer.valueOf(2130840158);
          if (QLog.isColorLevel()) {
            QLog.d("SkinEngine", 2, "Set icon resouceID to " + 2130840158);
          }
        }
        i = a(paramContext);
        str = "/skin/skin_cache_mobileqq_" + AppSetting.a() + "_" + "fd2cc8f9" + "_" + i;
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
          SkinEngine.init(paramContext, 8191, 2130837504, 1264, 2131165184, localFile);
        }
        catch (Exception localException3)
        {
          long l2;
          if (!localNameNotFoundException.exists()) {
            break label613;
          }
          localNameNotFoundException.delete();
          if (!localFile.exists()) {
            break label627;
          }
          localFile.delete();
          if (!QLog.isColorLevel()) {
            break label645;
          }
          QLog.d("SkinEngine", 2, "Cache load failed.", localException3);
          SkinEngine.init(paramContext, 8191, 2130837504, 1264, 2131165184, null);
          continue;
        }
        SkinEngine.getInstances().setSkinEngineHandler((SkinEngineHandler)localObject1);
        SkinEngine.getInstances().addDrawableResource(2130838592);
        SkinEngine.getInstances().addDrawableResource(2130838925);
        SkinEngine.getInstances().addDrawableResource(2130838593);
        SkinEngine.getInstances().addDrawableResource(2130849703);
        SkinEngine.getInstances().addDrawableResource(2130839220);
        SkinEngine.getInstances().addDrawableResource(2130838935);
        l2 = SystemClock.uptimeMillis();
        localObject1 = new SkinEngine.BackupForOOMData(2130849473, 2130849475, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130849473), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130845638, 2130849475, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130845638), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130849463, 2130849475, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130849463), (SkinEngine.BackupForOOMData)localObject1);
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        try
        {
          paramContext.getResources().getDrawable(2130837504);
          if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
            ThemeUtil.initTheme(null);
          }
          if (!QLog.isColorLevel()) {
            break label688;
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
    label613:
    label627:
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
      SkinEngine.getInstances().setSkinTint(new baow());
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