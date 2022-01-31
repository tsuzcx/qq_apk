package com.tencent.mobileqq.startup.step;

import ajve;
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
import aymr;
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
import xoo;

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
    jdField_a_of_type_ArrayOfInt = new int[] { 2130837738, 2130838122, 2130838121, 2130838120, 2130839011, 2130839112, 2130839111, 2130839139, 2130839141, 2130839145, 2130839129, 2130839266, 2130839396, 2130840055, 2130841003, 2130842008, 2130844965, 2130844964, 2130844960, 2130844959, 2130844955, 2130844954, 2130843339, 2130843345, 2130843346, 2130843347, 2130843348, 2130843349, 2130843350, 2130843351, 2130843352, 2130843353, 2130843356, 2130843355, 2130843357, 2130843358, 2130843359, 2130843361, 2130843360, 2130843370, 2130843371, 2130843372, 2130843373, 2130843374, 2130843375, 2130843376, 2130843377, 2130843378, 2130843379, 2130843380, 2130839745, 2130839744, 2130844855, 2130843531, 2130843533, 2130843346, 2130843443, 2130843531, 2130843533, 2130843345, 2130848519, 2130848773, 2130848759, 2130848758, 2130848780, 2130848779, 2130849248, 2130849143, 2130849139, 2130848957, 2130849032, 2130849301, 2130849050, 2130849046, 2130849054, 2130849060, 2130849058, 2130849038, 2130848988, 2130848995, 2130848996, 2130849008, 2130849248, 2130849211, 2130849212, 2130848104, 2130849228, 2130849233, 2130849231, 2130849239, 2130849235, 2130839753, 2130839757, 2130849082, 2130843400, 2130843399, 2130839132, 2130839133, 2130849146, 2130849142 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130837562, 2130837568, 2130837569, 2130837572, 2130837573, 2130837575, 2130837576, 2130839112, 2130839111, 2130848773, 2130839759, 2130839757, 2130849547, 2130849032, 2130849038, 2130849046, 2130849050, 2130849054, 2130849056, 2130849057, 2130849058, 2130849060, 2130849555, 2130849681, 2130840097, 2130840092, 2130840096, 2130840091, 2130840089, 2130840090, 2130843387, 2130843385, 2130843386, 2130840103, 2130840101, 2130840102, 2130838508, 2130849558, 2130841360, 2130841361, 2130841362, 2130841363, 2130849292, 2130848957, 2130849006, 2130849008, 2130841965, 2130841964, 2130841971, 2130849143, 2130849139, 2130849147, 2130849030, 2130849239, 2130849235, 2130849228, 2130839266, 2130849251, 2130849253, 2130849210, 2130849209 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2130837562, 2130837568, 2130837569, 2130837572, 2130837573, 2130837575, 2130837576, 2130837709, 2130837914, 2130838061, 2130838209, 2130838496, 2130838497, 2130838498, 2130838500, 2130838501, 2130838502, 2130838508, 2130838509, 2130838510, 2130838622, 2130838771, 2130838773, 2130838937, 2130838938, 2130838941, 2130838942, 2130839011, 2130839012, 2130839014, 2130839015, 2130839111, 2130839112, 2130839118, 2130839139, 2130839143, 2130839145, 2130839189, 2130839200, 2130839232, 2130839266, 2130839282, 2130839300, 2130839941, 2130839382, 2130839397, 2130837760, 2130839604, 2130839711, 2130839736, 2130847347, 2130847348, 2130840081, 2130840082, 2130847443, 2130840997, 2130841051, 2130841869, 2130841870, 2130841872, 2130841873, 2130842857, 2130842961, 2130843531, 2130843533, 2130844954, 2130844955, 2130844959, 2130844960, 2130844962, 2130844963, 2130844964, 2130844965, 2130844994, 2130846654, 2130846781, 2130846782, 2130846794, 2130846832, 2130846839, 2130846849, 2130846850, 2130846851, 2130846852, 2130846853, 2130846854, 2130846855, 2130846856, 2130846858, 2130846859, 2130846862, 2130846866, 2130846903, 2130846904, 2130846905, 2130846906, 2130846907, 2130846908, 2130846925, 2130846926, 2130848032, 2130837572, 2130847037, 2130847038, 2130847058, 2130847067, 2130847092, 2130847105, 2130847845, 2130847115, 2130847135, 2130847136, 2130847137, 2130847138, 2130847159, 2130847160, 2130847205, 2130847255, 2130847256, 2130847286, 2130847288, 2130847289, 2130847295, 2130847296, 2130847297, 2130847299, 2130847300, 2130847302, 2130847304, 2130847309, 2130847315, 2130847316, 2130847317, 2130847345, 2130847346, 2130847353, 2130847358, 2130847365, 2130847374, 2130847391, 2130847431, 2130847434, 2130847437, 2130847439, 2130847440, 2130847441, 2130847442, 2130847555, 2130847613, 2130847644, 2130847655, 2130847656, 2130847658, 2130847661, 2130847664, 2130844373, 2130847706, 2130847707, 2130847742, 2130847743, 2130847750, 2130847771, 2130847807, 2130847907, 2130848041, 2130848165, 2130848109, 2130848113, 2130848116, 2130848119, 2130848120, 2130848213, 2130848228, 2130848229, 2130848297, 2130848318, 2130848319, 2130848320, 2130848321, 2130848325, 2130848326, 2130848331, 2130848332, 2130848333, 2130848334, 2130848335, 2130848336, 2130848337, 2130848520, 2130848521, 2130848522, 2130848523, 2130848525, 2130848527, 2130848565, 2130848621, 2130848619, 2130848620, 2130848623, 2130848957, 2130848976, 2130848977, 2130848978, 2130848980, 2130848981, 2130848985, 2130848986, 2130848988, 2130848995, 2130848996, 2130848997, 2130848998, 2130849006, 2130849007, 2130849008, 2130849032, 2130849038, 2130849046, 2130849050, 2130849054, 2130849056, 2130849057, 2130849058, 2130849060, 2130849062, 2130849074, 2130849075, 2130849076, 2130849077, 2130849078, 2130849079, 2130849080, 2130849081, 2130849082, 2130849092, 2130849093, 2130849139, 2130849211, 2130849212, 2130849213, 2130849219, 2130849220, 2130848104, 2130848058, 2130848059, 2130848060, 2130848061, 2130848062, 2130849227, 2130849228, 2130849231, 2130849233, 2130849235, 2130849239, 2130849245, 2130849248, 2130849251, 2130849253, 2130849260, 2130849262, 2130849266, 2130849268, 2130849300, 2130849301, 2130849353, 2130849496, 2130849498, 2130849545, 2130849558, 2130849571, 2130849573 };
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
        if ((i != AppSetting.a()) || (!"a9855103".equals(str))) {
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
      SkinEngine.getInstances().setSkinEngineHandler(new xoo(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838514);
      SkinEngine.getInstances().addDrawableResource(2130839135);
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
      if (DeviceProfileManager.a((String)localObject1, (Object[])localObject2, new ajve()) >= 2)
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
        if ((i != AppSetting.a()) || (!"a9855103".equals(str))) {
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
      SkinEngine.getInstances().setSkinEngineHandler(new xoo(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838514);
      SkinEngine.getInstances().addDrawableResource(2130838762);
      SkinEngine.getInstances().addDrawableResource(2130839135);
      SkinEngine.getInstances().addDrawableResource(2130838772);
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
        localObject1 = new xoo(BaseApplicationImpl.getApplication());
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
          SkinEngine.mIconResourceID = Integer.valueOf(2130840055);
          if (QLog.isColorLevel()) {
            QLog.d("SkinEngine", 2, "Set icon resouceID to " + 2130840055);
          }
        }
        i = a(paramContext);
        str = "/skin/skin_cache_mobileqq_" + AppSetting.a() + "_" + "a9855103" + "_" + i;
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
        SkinEngine.getInstances().addDrawableResource(2130838514);
        SkinEngine.getInstances().addDrawableResource(2130838762);
        SkinEngine.getInstances().addDrawableResource(2130838515);
        SkinEngine.getInstances().addDrawableResource(2130849199);
        SkinEngine.getInstances().addDrawableResource(2130839135);
        SkinEngine.getInstances().addDrawableResource(2130838772);
        l2 = SystemClock.uptimeMillis();
        localObject1 = new SkinEngine.BackupForOOMData(2130848969, 2130848971, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130848969), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130845201, 2130848971, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130845201), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130848959, 2130848971, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130848959), (SkinEngine.BackupForOOMData)localObject1);
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
      SkinEngine.getInstances().setSkinTint(new aymr());
      if ((str == null) || (str.endsWith("map")) || (str.equals("qzone")) || (str.equals("pedit")) || (str.equals("plugin")) || (str.equals("demoji")) || (str.equals("peak")) || (str.equals("readinjoy")) || (str.endsWith("nearby")) || (str.equals("tool")) || (str.equals("qqfav")))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitSkin
 * JD-Core Version:    0.7.0.1
 */