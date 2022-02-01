package com.tencent.mobileqq.startup.step;

import aaut;
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
import antj;
import beis;
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
    jdField_a_of_type_ArrayOfInt = new int[] { 2130838078, 2130838340, 2130838339, 2130838338, 2130839330, 2130839434, 2130839433, 2130839465, 2130839467, 2130839471, 2130839455, 2130839600, 2130839720, 2130840422, 2130841424, 2130842572, 2130845802, 2130845801, 2130845797, 2130845796, 2130845792, 2130845791, 2130844082, 2130844105, 2130844106, 2130844107, 2130844108, 2130844109, 2130844110, 2130844111, 2130844112, 2130844113, 2130844116, 2130844115, 2130844117, 2130844118, 2130844119, 2130844121, 2130844120, 2130844130, 2130844131, 2130844132, 2130844133, 2130844134, 2130844135, 2130844137, 2130844138, 2130844139, 2130844140, 2130844141, 2130840357, 2130840356, 2130845666, 2130844322, 2130844324, 2130844106, 2130844228, 2130844322, 2130844324, 2130844105, 2130849568, 2130849849, 2130849835, 2130849834, 2130849856, 2130849855, 2130850375, 2130850258, 2130850254, 2130850034, 2130850109, 2130850431, 2130850127, 2130850123, 2130850131, 2130850137, 2130850135, 2130850115, 2130850065, 2130850072, 2130850073, 2130850085, 2130850375, 2130850338, 2130850339, 2130849060, 2130850355, 2130850360, 2130850358, 2130850366, 2130850362, 2130840365, 2130840369, 2130850159, 2130844177, 2130844176, 2130839458, 2130839459, 2130850261, 2130850257 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130837574, 2130837581, 2130837582, 2130837588, 2130837589, 2130837593, 2130837594, 2130839434, 2130839433, 2130849849, 2130840371, 2130840369, 2130850724, 2130850109, 2130850115, 2130850123, 2130850127, 2130850131, 2130850133, 2130850134, 2130850135, 2130850137, 2130850733, 2130850887, 2130840466, 2130840461, 2130840465, 2130840460, 2130840458, 2130840459, 2130844148, 2130844146, 2130844147, 2130840472, 2130840470, 2130840471, 2130838895, 2130850736, 2130841891, 2130841892, 2130841893, 2130841894, 2130850421, 2130850034, 2130850083, 2130850085, 2130842529, 2130842528, 2130842535, 2130850258, 2130850254, 2130850262, 2130850107, 2130850366, 2130850362, 2130850355, 2130839600, 2130850378, 2130850380, 2130850337, 2130850336 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2130837574, 2130837581, 2130837582, 2130837588, 2130837589, 2130837593, 2130837594, 2130838048, 2130838114, 2130838268, 2130838436, 2130838855, 2130838857, 2130838859, 2130838861, 2130838862, 2130838864, 2130838895, 2130838897, 2130838898, 2130839015, 2130839163, 2130839165, 2130839248, 2130839250, 2130839254, 2130839255, 2130839330, 2130839331, 2130839333, 2130839334, 2130839433, 2130839434, 2130839443, 2130839465, 2130839469, 2130839471, 2130839521, 2130839532, 2130839563, 2130839600, 2130839616, 2130839634, 2130839941, 2130839705, 2130839721, 2130837760, 2130840175, 2130840321, 2130840348, 2130848283, 2130848284, 2130840449, 2130840450, 2130848395, 2130841418, 2130841527, 2130842427, 2130842428, 2130842430, 2130842431, 2130843518, 2130843622, 2130844322, 2130844324, 2130845791, 2130845792, 2130845796, 2130845797, 2130845799, 2130845800, 2130845801, 2130845802, 2130845831, 2130847572, 2130847700, 2130847701, 2130847713, 2130847751, 2130847758, 2130847768, 2130847769, 2130847770, 2130847771, 2130847772, 2130847773, 2130847774, 2130847775, 2130847777, 2130847778, 2130847781, 2130847785, 2130847822, 2130847823, 2130847824, 2130847825, 2130847826, 2130847827, 2130847845, 2130847846, 2130848988, 2130837588, 2130847957, 2130847958, 2130847978, 2130847987, 2130848012, 2130848025, 2130848801, 2130848035, 2130848057, 2130848058, 2130848059, 2130848060, 2130848081, 2130848082, 2130848128, 2130848178, 2130848179, 2130848221, 2130848223, 2130848224, 2130848230, 2130848231, 2130848232, 2130848234, 2130848235, 2130848237, 2130848239, 2130848244, 2130848250, 2130848251, 2130848252, 2130848281, 2130848282, 2130848289, 2130848310, 2130848317, 2130848326, 2130848343, 2130848383, 2130848386, 2130848389, 2130848391, 2130848392, 2130848393, 2130848394, 2130848508, 2130848566, 2130848597, 2130848608, 2130848609, 2130848611, 2130848614, 2130848617, 2130845180, 2130848659, 2130848660, 2130848698, 2130848699, 2130848706, 2130848727, 2130848763, 2130848863, 2130848997, 2130849121, 2130849065, 2130849069, 2130849072, 2130849075, 2130849076, 2130849169, 2130849184, 2130849185, 2130849275, 2130849298, 2130849299, 2130849300, 2130849301, 2130849305, 2130849306, 2130849311, 2130849312, 2130849313, 2130849314, 2130849315, 2130849316, 2130849317, 2130849569, 2130849570, 2130849571, 2130849572, 2130849574, 2130849576, 2130849623, 2130849685, 2130849683, 2130849684, 2130849687, 2130850034, 2130850053, 2130850054, 2130850055, 2130850057, 2130850058, 2130850062, 2130850063, 2130850065, 2130850072, 2130850073, 2130850074, 2130850075, 2130850083, 2130850084, 2130850085, 2130850109, 2130850115, 2130850123, 2130850127, 2130850131, 2130850133, 2130850134, 2130850135, 2130850137, 2130850139, 2130850151, 2130850152, 2130850153, 2130850154, 2130850155, 2130850156, 2130850157, 2130850158, 2130850159, 2130850170, 2130850171, 2130850254, 2130850338, 2130850339, 2130850340, 2130850346, 2130850347, 2130849060, 2130849014, 2130849015, 2130849016, 2130849017, 2130849018, 2130850354, 2130850355, 2130850358, 2130850360, 2130850362, 2130850366, 2130850372, 2130850375, 2130850378, 2130850380, 2130850387, 2130850389, 2130850393, 2130850395, 2130850430, 2130850431, 2130850491, 2130850646, 2130850648, 2130850722, 2130850736, 2130850751, 2130850753 };
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
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131165184, 2131167414, null);
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
        if ((i != AppSetting.a()) || (!"b8c39faf".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "web skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131165184, 2131167414, localFile2);
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
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131165184, 2131167414, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new aaut(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838911);
      SkinEngine.getInstances().addDrawableResource(2130839461);
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
          break label519;
        }
        QLog.e("SkinEngine", 2, "", localException2);
        SkinEngine.getInstances().unInit();
        throw localException2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "web skin cache time out");
      }
      SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131165184, 2131167414, null);
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
      if (DeviceProfileManager.a((String)localObject1, (Object[])localObject2, new antj()) >= 2)
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
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131165184, 2131167414, null);
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
        if ((i != AppSetting.a()) || (!"b8c39faf".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qzone skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131165184, 2131167414, localFile2);
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
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131165184, 2131167414, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new aaut(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838911);
      SkinEngine.getInstances().addDrawableResource(2130839154);
      SkinEngine.getInstances().addDrawableResource(2130839461);
      SkinEngine.getInstances().addDrawableResource(2130839164);
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
          break label537;
        }
        QLog.e("SkinEngine", 2, "", localException2);
        SkinEngine.getInstances().unInit();
        throw localException2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "qzone skin cache time out");
      }
      SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131165184, 2131167414, null);
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
        localObject1 = new aaut(BaseApplicationImpl.getApplication());
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
          break label701;
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
        SkinEngine.init(paramContext, 8191, 2130837504, 2130850980, 1264, 2131165184, 2131167414, null);
        ThreadManager.getSubThreadHandler().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/config", str), 10000L);
        continue;
      }
      try
      {
        localObject2 = BaseApplicationImpl.sApplication;
        if (((Application)localObject2).getPackageManager().getApplicationInfo(((Application)localObject2).getPackageName(), 128).metaData.getBoolean("com.sec.android.support.multiwindow"))
        {
          SkinEngine.mIconResourceID = Integer.valueOf(2130840422);
          if (QLog.isColorLevel()) {
            QLog.d("SkinEngine", 2, "Set icon resouceID to " + 2130840422);
          }
        }
        i = a(paramContext);
        str = "/skin/skin_cache_mobileqq_" + AppSetting.a() + "_" + "b8c39faf" + "_" + i;
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
          SkinEngine.init(paramContext, 8191, 2130837504, 2130850980, 1264, 2131165184, 2131167414, localFile);
        }
        catch (Exception localException3)
        {
          long l2;
          if (!localNameNotFoundException.exists()) {
            break label620;
          }
          localNameNotFoundException.delete();
          if (!localFile.exists()) {
            break label634;
          }
          localFile.delete();
          if (!QLog.isColorLevel()) {
            break label652;
          }
          QLog.d("SkinEngine", 2, "Cache load failed.", localException3);
          SkinEngine.init(paramContext, 8191, 2130837504, 2130850980, 1264, 2131165184, 2131167414, null);
          continue;
        }
        SkinEngine.getInstances().setSkinEngineHandler((SkinEngineHandler)localObject1);
        SkinEngine.getInstances().addDrawableResource(2130838911);
        SkinEngine.getInstances().addDrawableResource(2130839154);
        SkinEngine.getInstances().addDrawableResource(2130838912);
        SkinEngine.getInstances().addDrawableResource(2130850319);
        SkinEngine.getInstances().addDrawableResource(2130839461);
        SkinEngine.getInstances().addDrawableResource(2130839164);
        l2 = SystemClock.uptimeMillis();
        localObject1 = new SkinEngine.BackupForOOMData(2130850046, 2130850048, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130850046), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130846042, 2130850048, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130846042), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130850036, 2130850048, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130850036), (SkinEngine.BackupForOOMData)localObject1);
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
            break label701;
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
    label620:
    label634:
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
      SkinEngine.getInstances().setSkinTint(new beis());
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