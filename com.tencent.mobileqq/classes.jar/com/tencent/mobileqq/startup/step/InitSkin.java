package com.tencent.mobileqq.startup.step;

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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.OOMHandler;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.TintManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
  public static int a = 0;
  public static final Object a;
  public static boolean a = false;
  private static final int[] a;
  public static boolean b = false;
  private static final int[] b;
  public static volatile boolean c;
  private static final int[] c;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_Int = 3000;
    jdField_c_of_type_Boolean = false;
    jdField_a_of_type_ArrayOfInt = new int[] { 2130837996, 2130838245, 2130838244, 2130838243, 2130839263, 2130839369, 2130839368, 2130839400, 2130839402, 2130839407, 2130839390, 2130839537, 2130839670, 2130840405, 2130841450, 2130842617, 2130846001, 2130846000, 2130845996, 2130845995, 2130845991, 2130845990, 2130844170, 2130844193, 2130844194, 2130844195, 2130844196, 2130844197, 2130844198, 2130844199, 2130844200, 2130844201, 2130844204, 2130844203, 2130844205, 2130844206, 2130844207, 2130844209, 2130844208, 2130844218, 2130844219, 2130844220, 2130844221, 2130844222, 2130844223, 2130844225, 2130844226, 2130844227, 2130844228, 2130844229, 2130840339, 2130840338, 2130845859, 2130844418, 2130844420, 2130844194, 2130844324, 2130844418, 2130844420, 2130844193, 2130849857, 2130850174, 2130850160, 2130850159, 2130850181, 2130850180, 2130850703, 2130850582, 2130850578, 2130850359, 2130850433, 2130850770, 2130850451, 2130850447, 2130850455, 2130850461, 2130850459, 2130850439, 2130850390, 2130850397, 2130850398, 2130850410, 2130850703, 2130850664, 2130850665, 2130849326, 2130850681, 2130850686, 2130850684, 2130850693, 2130850688, 2130840347, 2130840351, 2130850483, 2130844265, 2130844264, 2130839393, 2130839394, 2130850585, 2130850581 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130837661, 2130837668, 2130837669, 2130837675, 2130837676, 2130837680, 2130837681, 2130839369, 2130839368, 2130850174, 2130840353, 2130840351, 2130851066, 2130850433, 2130850439, 2130850447, 2130850451, 2130850455, 2130850457, 2130850458, 2130850459, 2130850461, 2130851075, 2130851229, 2130840450, 2130840445, 2130840449, 2130840444, 2130840442, 2130840443, 2130844236, 2130844234, 2130844235, 2130840456, 2130840454, 2130840455, 2130838724, 2130851078, 2130841931, 2130841932, 2130841933, 2130841934, 2130850760, 2130850359, 2130850408, 2130850410, 2130842574, 2130842573, 2130842580, 2130850582, 2130850578, 2130850586, 2130850431, 2130850693, 2130850688, 2130850681, 2130839537, 2130850706, 2130850708, 2130850663, 2130850662 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2130837661, 2130837668, 2130837669, 2130837675, 2130837676, 2130837680, 2130837681, 2130837969, 2130838027, 2130838177, 2130838353, 2130838712, 2130838713, 2130838714, 2130838716, 2130838717, 2130838718, 2130838724, 2130838726, 2130838727, 2130838936, 2130839085, 2130839087, 2130839177, 2130839179, 2130839183, 2130839184, 2130839263, 2130839264, 2130839266, 2130839267, 2130839368, 2130839369, 2130839378, 2130839400, 2130839405, 2130839407, 2130839458, 2130839469, 2130839500, 2130839537, 2130839553, 2130839571, 2130839941, 2130839645, 2130839671, 2130837760, 2130840125, 2130840294, 2130840321, 2130848519, 2130848520, 2130840433, 2130840434, 2130848632, 2130841439, 2130841556, 2130842471, 2130842472, 2130842474, 2130842475, 2130843608, 2130843712, 2130844418, 2130844420, 2130845990, 2130845991, 2130845995, 2130845996, 2130845998, 2130845999, 2130846000, 2130846001, 2130847796, 2130847928, 2130847929, 2130847941, 2130847979, 2130847986, 2130847996, 2130847997, 2130847998, 2130847999, 2130848000, 2130848001, 2130848002, 2130848003, 2130848005, 2130848006, 2130848009, 2130848013, 2130848050, 2130848051, 2130848052, 2130848053, 2130848054, 2130848055, 2130848073, 2130848074, 2130849254, 2130837675, 2130848184, 2130848185, 2130848206, 2130848215, 2130848240, 2130848253, 2130849061, 2130848267, 2130848291, 2130848292, 2130848293, 2130848294, 2130848317, 2130848318, 2130848364, 2130848414, 2130848415, 2130848457, 2130848459, 2130848460, 2130848466, 2130848467, 2130848468, 2130848470, 2130848471, 2130848473, 2130848475, 2130848480, 2130848486, 2130848487, 2130848488, 2130848517, 2130848518, 2130848525, 2130848546, 2130848553, 2130848562, 2130848579, 2130848619, 2130848622, 2130848625, 2130848628, 2130848629, 2130848630, 2130848631, 2130848768, 2130848826, 2130848857, 2130848868, 2130848869, 2130848871, 2130848874, 2130848877, 2130845215, 2130848919, 2130848920, 2130848958, 2130848959, 2130848966, 2130848987, 2130849023, 2130849123, 2130849263, 2130849387, 2130849331, 2130849335, 2130849338, 2130849341, 2130849342, 2130849435, 2130849462, 2130849463, 2130849552, 2130849575, 2130849576, 2130849577, 2130849578, 2130849582, 2130849583, 2130849588, 2130849589, 2130849590, 2130849591, 2130849592, 2130849593, 2130849594, 2130849858, 2130849859, 2130849861, 2130849862, 2130849864, 2130849866, 2130849945, 2130850007, 2130850005, 2130850006, 2130850009, 2130850359, 2130850378, 2130850379, 2130850380, 2130850382, 2130850383, 2130850387, 2130850388, 2130850390, 2130850397, 2130850398, 2130850399, 2130850400, 2130850408, 2130850409, 2130850410, 2130850433, 2130850439, 2130850447, 2130850451, 2130850455, 2130850457, 2130850458, 2130850459, 2130850461, 2130850463, 2130850475, 2130850476, 2130850477, 2130850478, 2130850479, 2130850480, 2130850481, 2130850482, 2130850483, 2130850494, 2130850495, 2130850578, 2130850664, 2130850665, 2130850666, 2130850672, 2130850673, 2130849326, 2130849280, 2130849281, 2130849282, 2130849283, 2130849284, 2130850680, 2130850681, 2130850684, 2130850686, 2130850688, 2130850693, 2130850700, 2130850703, 2130850706, 2130850708, 2130850715, 2130850717, 2130850721, 2130850723, 2130850769, 2130850770, 2130850831, 2130851010, 2130851012, 2130851062, 2130851078, 2130851096, 2130851098 };
  }
  
  private static final int a(Context paramContext)
  {
    Object localObject = paramContext.getResources();
    paramContext = new TypedValue();
    ((Resources)localObject).getValue(2130837504, paramContext, true);
    int i;
    if (paramContext.string != null) {
      i = paramContext.assetCookie;
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDefaultCookieId value.string=");
      ((StringBuilder)localObject).append(paramContext.string);
      ((StringBuilder)localObject).append(", cookieId=");
      ((StringBuilder)localObject).append(i);
      QLog.i("InitSkin", 2, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  private static MqqHandler a()
  {
    return new MqqHandler(ThreadManager.getSubThreadLooper());
  }
  
  public static void a()
  {
    if ((jdField_b_of_type_Boolean) && (!jdField_c_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.i("InitSkin", 2, "start waitAsynInitSkin");
      }
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        boolean bool = jdField_c_of_type_Boolean;
        if (!bool) {
          try
          {
            jdField_a_of_type_JavaLangObject.wait(jdField_a_of_type_Int);
          }
          catch (InterruptedException localInterruptedException)
          {
            if (QLog.isColorLevel()) {
              QLog.i("InitSkin", 2, localInterruptedException.toString());
            }
          }
        }
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("end waitAsynInitSkin InitSkin.sToolProcessInitComplete = ");
          ((StringBuilder)???).append(jdField_c_of_type_Boolean);
          QLog.i("InitSkin", 2, ((StringBuilder)???).toString());
          return;
        }
      }
    }
  }
  
  public static final boolean a(Context paramContext)
  {
    try
    {
      Object localObject = paramContext.getCacheDir();
      long l1 = SystemClock.uptimeMillis();
      SkinEngine.SWITCH_DEBUG = false;
      SkinEngine.DEBUG = false;
      File localFile2 = new File((File)localObject, "/skin/web_config");
      File localFile1 = new File((File)localObject, "/skin/web_skin_cache");
      try
      {
        if (localFile2.exists())
        {
          localObject = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile2)));
          int i = ((ObjectInputStream)localObject).readInt();
          String str = ((ObjectInputStream)localObject).readUTF();
          ((ObjectInputStream)localObject).close();
          if ((i == AppSetting.a()) && ("01328a87".equals(str)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SkinEngine", 2, "web skin cache find, use cache file accered");
            }
            localObject = jdField_b_of_type_ArrayOfInt;
          }
        }
        try
        {
          SkinEngine.init(paramContext, (int[])localObject, 1264, 2131165184, 2131167446, localFile1);
        }
        catch (Exception localException1)
        {
          break label281;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "web skin cache time out");
        }
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131165184, 2131167446, null);
        ThreadManager.getSubThreadHandler().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/web_config", "/skin/web_skin_cache"), 10000L);
        break label344;
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "No cache found");
        }
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131165184, 2131167446, null);
        ThreadManager.getSubThreadHandler().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/web_config", "/skin/web_skin_cache"), 10000L);
      }
      catch (Exception localException2) {}
      label281:
      if (!localFile2.exists()) {
        localFile2.delete();
      }
      if (!localFile1.exists()) {
        localFile1.delete();
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "web skin Cache load failed.", localException2);
      }
      SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131165184, 2131167446, null);
      label344:
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838739);
      SkinEngine.getInstances().addDrawableResource(2130839396);
      long l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("web skin init skin engine cost: ");
          localStringBuilder.append(l2 - l1);
          QLog.d("SkinEngine", 2, localStringBuilder.toString());
        }
      }
      catch (Exception localException3)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SkinEngine", 2, "", localException3);
        }
        SkinEngine.getInstances().unInit();
        throw localException3;
      }
      try
      {
        paramContext.createNewFile();
        return true;
      }
      catch (IOException paramContext)
      {
        break label541;
      }
    }
    catch (Exception localException4)
    {
      BaseApplicationImpl.IS_SUPPORT_THEME = false;
      if (QLog.isColorLevel()) {
        QLog.e("SkinEngine", 2, "", localException4);
      }
      paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
      if (!paramContext.exists()) {
        if (!paramContext.getParentFile().exists()) {
          paramContext.getParentFile().mkdirs();
        }
      }
    }
  }
  
  private void b()
  {
    jdField_b_of_type_Boolean = false;
    Object localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("dpcConfig", 4).getString("tool_process_profile", "");
    Object localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (((String)localObject2).indexOf('{', 0) == 0)
      {
        localObject1 = localObject2;
        if (((String)localObject2).lastIndexOf('}') == ((String)localObject2).length() - 1) {
          localObject1 = ((String)localObject2).substring(1, ((String)localObject2).length() - 1);
        }
      }
      localObject2 = new Integer[2];
      Arrays.fill((Object[])localObject2, Integer.valueOf(0));
      if (((IDPCApi)QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser((String)localObject1, (Integer[])localObject2) >= 2)
      {
        boolean bool;
        if (localObject2[0].intValue() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        jdField_b_of_type_Boolean = bool;
        int i;
        if (localObject2[1].intValue() > 0) {
          i = localObject2[1].intValue();
        } else {
          i = 0;
        }
        jdField_a_of_type_Int = i;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ToolAsynInitDPC = ");
      ((StringBuilder)localObject1).append(jdField_b_of_type_Boolean);
      ((StringBuilder)localObject1).append("  sToolInitTimeout = ");
      ((StringBuilder)localObject1).append(jdField_a_of_type_Int);
      QLog.i("InitSkin", 2, ((StringBuilder)localObject1).toString());
    }
    if (jdField_b_of_type_Boolean)
    {
      ThreadManager.post(new InitSkin.1(this), 8, null, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("InitSkin", 2, "start synInitSkin");
    }
    initSkin(BaseApplicationImpl.sApplication);
    jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.i("InitSkin", 2, "end synInitSkin");
    }
  }
  
  @TargetApi(16)
  public static final boolean b(Context paramContext)
  {
    try
    {
      Object localObject = paramContext.getCacheDir();
      long l1 = SystemClock.uptimeMillis();
      SkinEngine.SWITCH_DEBUG = false;
      SkinEngine.DEBUG = false;
      File localFile2 = new File((File)localObject, "/skin/qzone_config");
      File localFile1 = new File((File)localObject, "/skin/qzone_skin_cache");
      try
      {
        if (localFile2.exists())
        {
          localObject = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile2)));
          int i = ((ObjectInputStream)localObject).readInt();
          String str = ((ObjectInputStream)localObject).readUTF();
          ((ObjectInputStream)localObject).close();
          if ((i == AppSetting.a()) && ("01328a87".equals(str)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SkinEngine", 2, "qzone skin cache find, use cache file accered");
            }
            localObject = jdField_c_of_type_ArrayOfInt;
          }
        }
        try
        {
          SkinEngine.init(paramContext, (int[])localObject, 1264, 2131165184, 2131167446, localFile1);
        }
        catch (Exception localException1)
        {
          break label281;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qzone skin cache time out");
        }
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131165184, 2131167446, null);
        a().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
        break label344;
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "No cache found");
        }
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131165184, 2131167446, null);
        a().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
      }
      catch (Exception localException2) {}
      label281:
      if (!localFile2.exists()) {
        localFile2.delete();
      }
      if (!localFile1.exists()) {
        localFile1.delete();
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "qzone skin Cache load failed.", localException2);
      }
      SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131165184, 2131167446, null);
      label344:
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838739);
      SkinEngine.getInstances().addDrawableResource(2130839075);
      SkinEngine.getInstances().addDrawableResource(2130839396);
      SkinEngine.getInstances().addDrawableResource(2130839086);
      long l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("qzone skin init skin engine cost: ");
          localStringBuilder.append(l2 - l1);
          QLog.d("SkinEngine", 2, localStringBuilder.toString());
        }
      }
      catch (Exception localException3)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SkinEngine", 2, "", localException3);
        }
        SkinEngine.getInstances().unInit();
        throw localException3;
      }
      try
      {
        paramContext.createNewFile();
        return true;
      }
      catch (IOException paramContext)
      {
        break label559;
      }
    }
    catch (Exception localException4)
    {
      BaseApplicationImpl.IS_SUPPORT_THEME = false;
      if (QLog.isColorLevel()) {
        QLog.e("SkinEngine", 2, "", localException4);
      }
      paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
      if (!paramContext.exists()) {
        if (!paramContext.getParentFile().exists()) {
          paramContext.getParentFile().mkdirs();
        }
      }
    }
  }
  
  public static final boolean initSkin(Context paramContext)
  {
    try
    {
      File localFile = paramContext.getCacheDir();
      long l1 = SystemClock.uptimeMillis();
      SkinEngine.SWITCH_DEBUG = false;
      SkinEngine.DEBUG = false;
      Object localObject1 = new OOMHandler(BaseApplicationImpl.getApplication());
      SkinEngine.setSKLog((ISkinEngineLog)localObject1);
      try
      {
        Object localObject2 = BaseApplicationImpl.sApplication;
        if (((Application)localObject2).getPackageManager().getApplicationInfo(((Application)localObject2).getPackageName(), 128).metaData.getBoolean("com.sec.android.support.multiwindow"))
        {
          SkinEngine.mIconResourceID = Integer.valueOf(2130840405);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Set icon resouceID to ");
            ((StringBuilder)localObject2).append(2130840405);
            QLog.d("SkinEngine", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        localNameNotFoundException.printStackTrace();
      }
      int i = a(paramContext);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("/skin/skin_cache_mobileqq_");
      ((StringBuilder)localObject3).append(AppSetting.a());
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append("01328a87");
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append(i);
      String str = ((StringBuilder)localObject3).toString();
      localObject3 = new File(localFile, "/skin/config");
      localFile = new File(localFile, str);
      try
      {
        if (localFile.exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("SkinEngine", 2, "cache find, use cache file accered");
          }
          SkinEngine.init(paramContext, 8191, 2130837504, 2130851335, 1264, 2131165184, 2131167446, localFile);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("SkinEngine", 2, "No cache found");
          }
          SkinEngine.init(paramContext, 8191, 2130837504, 2130851335, 1264, 2131165184, 2131167446, null);
          ThreadManager.getSubThreadHandler().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/config", str), 10000L);
        }
      }
      catch (Exception localException3)
      {
        if (((File)localObject3).exists()) {
          ((File)localObject3).delete();
        }
        if (localFile.exists()) {
          localFile.delete();
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "Cache load failed.", localException3);
        }
        SkinEngine.init(paramContext, 8191, 2130837504, 2130851335, 1264, 2131165184, 2131167446, null);
      }
      SkinEngine.getInstances().setSkinEngineHandler((SkinEngineHandler)localObject1);
      SkinEngine.getInstances().addDrawableResource(2130838739);
      SkinEngine.getInstances().addDrawableResource(2130839075);
      SkinEngine.getInstances().addDrawableResource(2130838740);
      SkinEngine.getInstances().addDrawableResource(2130850645);
      SkinEngine.getInstances().addDrawableResource(2130839396);
      SkinEngine.getInstances().addDrawableResource(2130839086);
      long l2 = SystemClock.uptimeMillis();
      localObject1 = new SkinEngine.BackupForOOMData(2130850371, 2130850373, Bitmap.Config.RGB_565);
      SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130850371), (SkinEngine.BackupForOOMData)localObject1);
      localObject1 = new SkinEngine.BackupForOOMData(2130846235, 2130850373, Bitmap.Config.RGB_565);
      SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130846235), (SkinEngine.BackupForOOMData)localObject1);
      localObject1 = new SkinEngine.BackupForOOMData(2130850361, 2130850373, Bitmap.Config.RGB_565);
      SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130850361), (SkinEngine.BackupForOOMData)localObject1);
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (BaseApplicationImpl.sProcessId == 1) {
          ThemeUtil.initTheme(null);
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("init skin engine cost: ");
          ((StringBuilder)localObject1).append(l2 - l1);
          QLog.d("SkinEngine", 2, ((StringBuilder)localObject1).toString());
          return true;
        }
      }
      catch (Exception localException1)
      {
        QLog.e("SkinEngine", 1, "getDrawable(R.drawable.a) error:", localException1);
        SkinEngine.getInstances().unInit();
        throw localException1;
      }
      return true;
    }
    catch (Exception localException2)
    {
      BaseApplicationImpl.IS_SUPPORT_THEME = false;
      QLog.e("SkinEngine", 1, "Init SkinEngine Error:", localException2);
      paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
      if (!paramContext.exists()) {
        if (!paramContext.getParentFile().exists()) {
          paramContext.getParentFile().mkdirs();
        }
      }
      try
      {
        paramContext.createNewFile();
        return true;
      }
      catch (IOException paramContext) {}
    }
  }
  
  protected boolean doStep()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    jdField_a_of_type_Boolean = true;
    String[] arrayOfString = BaseApplicationImpl.processName.split(":");
    String str = null;
    if (arrayOfString.length > 1) {
      str = arrayOfString[1];
    }
    SkinEngine.getInstances().setSkinTint(TintManager.a());
    if ((str != null) && (!str.endsWith("map")) && (!str.equals("qzone")) && (!str.equals("picture")) && (!str.equals("pedit")) && (!str.equals("plugin")) && (!str.equals("demoji")) && (!str.equals("peak")) && (!str.equals("readinjoy")) && (!str.endsWith("nearby")) && (!str.equals("tool")) && (!str.equals("qqfav")))
    {
      if (str.equals("qzone"))
      {
        b(BaseApplicationImpl.sApplication);
        return true;
      }
      if (str.equals("web"))
      {
        a(BaseApplicationImpl.sApplication);
        return true;
      }
    }
    else
    {
      if ("tool".equals(str))
      {
        b();
        return true;
      }
      initSkin(BaseApplicationImpl.sApplication);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitSkin
 * JD-Core Version:    0.7.0.1
 */