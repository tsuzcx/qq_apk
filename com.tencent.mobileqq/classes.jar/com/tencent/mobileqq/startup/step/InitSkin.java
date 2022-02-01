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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.TintManager;
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
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_Int = 3000;
    jdField_c_of_type_Boolean = false;
    jdField_a_of_type_ArrayOfInt = new int[] { 2130838150, 2130838409, 2130838408, 2130838407, 2130839407, 2130839513, 2130839512, 2130839544, 2130839546, 2130839550, 2130839534, 2130839679, 2130840058, 2130840535, 2130841567, 2130842718, 2130846123, 2130846122, 2130846118, 2130846117, 2130846113, 2130846112, 2130844264, 2130844287, 2130844288, 2130844289, 2130844290, 2130844291, 2130844292, 2130844293, 2130844294, 2130844295, 2130844298, 2130844297, 2130844299, 2130844300, 2130844301, 2130844303, 2130844302, 2130844312, 2130844313, 2130844314, 2130844315, 2130844316, 2130844317, 2130844319, 2130844320, 2130844321, 2130844322, 2130844323, 2130840470, 2130840469, 2130845984, 2130844512, 2130844514, 2130844288, 2130844418, 2130844512, 2130844514, 2130844287, 2130849959, 2130850247, 2130850233, 2130850232, 2130850254, 2130850253, 2130850777, 2130850656, 2130850652, 2130850432, 2130850507, 2130850834, 2130850525, 2130850521, 2130850529, 2130850535, 2130850533, 2130850513, 2130850463, 2130850470, 2130850471, 2130850483, 2130850777, 2130850738, 2130850739, 2130849440, 2130850755, 2130850760, 2130850758, 2130850767, 2130850762, 2130840478, 2130840482, 2130850557, 2130844359, 2130844358, 2130839537, 2130839538, 2130850659, 2130850655 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130837574, 2130837581, 2130837582, 2130837588, 2130837589, 2130837593, 2130837594, 2130839513, 2130839512, 2130850247, 2130840484, 2130840482, 2130851150, 2130850507, 2130850513, 2130850521, 2130850525, 2130850529, 2130850531, 2130850532, 2130850533, 2130850535, 2130851159, 2130851316, 2130840581, 2130840576, 2130840580, 2130840575, 2130840573, 2130840574, 2130844330, 2130844328, 2130844329, 2130840587, 2130840585, 2130840586, 2130838964, 2130851162, 2130842034, 2130842035, 2130842036, 2130842037, 2130850824, 2130850432, 2130850481, 2130850483, 2130842675, 2130842674, 2130842681, 2130850656, 2130850652, 2130850660, 2130850505, 2130850767, 2130850762, 2130850755, 2130839679, 2130850780, 2130850782, 2130850737, 2130850736 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2130837574, 2130837581, 2130837582, 2130837588, 2130837589, 2130837593, 2130837594, 2130838120, 2130838186, 2130838348, 2130838505, 2130838952, 2130838953, 2130838954, 2130838956, 2130838957, 2130838958, 2130838964, 2130838966, 2130838967, 2130839083, 2130839231, 2130839233, 2130839322, 2130839324, 2130839328, 2130839329, 2130839407, 2130839408, 2130839410, 2130839411, 2130839512, 2130839513, 2130839522, 2130839544, 2130839548, 2130839550, 2130839600, 2130839611, 2130839642, 2130839679, 2130839695, 2130839713, 2130839941, 2130839785, 2130840059, 2130837760, 2130840266, 2130840425, 2130840452, 2130848640, 2130848641, 2130840564, 2130840565, 2130848752, 2130841558, 2130841670, 2130842572, 2130842573, 2130842575, 2130842576, 2130843688, 2130843792, 2130844512, 2130844514, 2130846112, 2130846113, 2130846117, 2130846118, 2130846120, 2130846121, 2130846122, 2130846123, 2130846152, 2130847929, 2130848057, 2130848058, 2130848070, 2130848108, 2130848115, 2130848125, 2130848126, 2130848127, 2130848128, 2130848129, 2130848130, 2130848131, 2130848132, 2130848134, 2130848135, 2130848138, 2130848142, 2130848179, 2130848180, 2130848181, 2130848182, 2130848183, 2130848184, 2130848202, 2130848203, 2130849368, 2130837588, 2130848314, 2130848315, 2130848335, 2130848344, 2130848369, 2130848382, 2130849181, 2130848392, 2130848414, 2130848415, 2130848416, 2130848417, 2130848438, 2130848439, 2130848485, 2130848535, 2130848536, 2130848578, 2130848580, 2130848581, 2130848587, 2130848588, 2130848589, 2130848591, 2130848592, 2130848594, 2130848596, 2130848601, 2130848607, 2130848608, 2130848609, 2130848638, 2130848639, 2130848646, 2130848667, 2130848674, 2130848683, 2130848700, 2130848740, 2130848743, 2130848746, 2130848748, 2130848749, 2130848750, 2130848751, 2130848888, 2130848946, 2130848977, 2130848988, 2130848989, 2130848991, 2130848994, 2130848997, 2130845342, 2130849039, 2130849040, 2130849078, 2130849079, 2130849086, 2130849107, 2130849143, 2130849243, 2130849377, 2130849501, 2130849445, 2130849449, 2130849452, 2130849455, 2130849456, 2130849549, 2130849564, 2130849565, 2130849655, 2130849678, 2130849679, 2130849680, 2130849681, 2130849685, 2130849686, 2130849691, 2130849692, 2130849693, 2130849694, 2130849695, 2130849696, 2130849697, 2130849960, 2130849961, 2130849963, 2130849964, 2130849966, 2130849968, 2130850018, 2130850081, 2130850079, 2130850080, 2130850083, 2130850432, 2130850451, 2130850452, 2130850453, 2130850455, 2130850456, 2130850460, 2130850461, 2130850463, 2130850470, 2130850471, 2130850472, 2130850473, 2130850481, 2130850482, 2130850483, 2130850507, 2130850513, 2130850521, 2130850525, 2130850529, 2130850531, 2130850532, 2130850533, 2130850535, 2130850537, 2130850549, 2130850550, 2130850551, 2130850552, 2130850553, 2130850554, 2130850555, 2130850556, 2130850557, 2130850568, 2130850569, 2130850652, 2130850738, 2130850739, 2130850740, 2130850746, 2130850747, 2130849440, 2130849394, 2130849395, 2130849396, 2130849397, 2130849398, 2130850754, 2130850755, 2130850758, 2130850760, 2130850762, 2130850767, 2130850774, 2130850777, 2130850780, 2130850782, 2130850789, 2130850791, 2130850795, 2130850797, 2130850833, 2130850834, 2130850894, 2130851070, 2130851072, 2130851148, 2130851162, 2130851180, 2130851182 };
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
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131165184, 2131167426, null);
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
        if ((i != AppSetting.a()) || (!"de12fadd".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "web skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131165184, 2131167426, localFile2);
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
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131165184, 2131167426, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838979);
      SkinEngine.getInstances().addDrawableResource(2130839540);
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
      SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131165184, 2131167426, null);
      ThreadManager.getSubThreadHandler().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/web_config", "/skin/web_skin_cache"), 10000L);
    }
  }
  
  private void b()
  {
    jdField_b_of_type_Boolean = false;
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("dpcConfig", 4).getString("tool_process_profile", "");
    if (!TextUtils.isEmpty(str))
    {
      if ((str.indexOf('{', 0) != 0) || (str.lastIndexOf('}') != str.length() - 1)) {
        break label268;
      }
      str = str.substring(1, str.length() - 1);
    }
    label268:
    for (;;)
    {
      Integer[] arrayOfInteger = new Integer[2];
      Arrays.fill(arrayOfInteger, Integer.valueOf(0));
      boolean bool;
      int i;
      if (((IDPCApi)QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser(str, arrayOfInteger) >= 2)
      {
        if (arrayOfInteger[0].intValue() == 1)
        {
          bool = true;
          jdField_b_of_type_Boolean = bool;
          if (arrayOfInteger[1].intValue() <= 0) {
            break label219;
          }
          i = arrayOfInteger[1].intValue();
          label141:
          jdField_a_of_type_Int = i;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("InitSkin", 2, "ToolAsynInitDPC = " + jdField_b_of_type_Boolean + "  sToolInitTimeout = " + jdField_a_of_type_Int);
        }
        if (!jdField_b_of_type_Boolean) {
          break label224;
        }
        ThreadManager.post(new InitSkin.1(this), 8, null, false);
      }
      label219:
      label224:
      do
      {
        return;
        bool = false;
        break;
        i = 0;
        break label141;
        if (QLog.isColorLevel()) {
          QLog.i("InitSkin", 2, "start synInitSkin");
        }
        initSkin(BaseApplicationImpl.sApplication);
        jdField_c_of_type_Boolean = true;
      } while (!QLog.isColorLevel());
      QLog.i("InitSkin", 2, "end synInitSkin");
      return;
    }
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
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131165184, 2131167426, null);
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
        if ((i != AppSetting.a()) || (!"de12fadd".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qzone skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131165184, 2131167426, localFile2);
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
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131165184, 2131167426, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838979);
      SkinEngine.getInstances().addDrawableResource(2130839222);
      SkinEngine.getInstances().addDrawableResource(2130839540);
      SkinEngine.getInstances().addDrawableResource(2130839232);
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
      SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131165184, 2131167426, null);
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
        localObject1 = new OOMHandler(BaseApplicationImpl.getApplication());
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
        SkinEngine.init(paramContext, 8191, 2130837504, 2130851414, 1264, 2131165184, 2131167426, null);
        ThreadManager.getSubThreadHandler().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/config", str), 10000L);
        continue;
      }
      try
      {
        localObject2 = BaseApplicationImpl.sApplication;
        if (((Application)localObject2).getPackageManager().getApplicationInfo(((Application)localObject2).getPackageName(), 128).metaData.getBoolean("com.sec.android.support.multiwindow"))
        {
          SkinEngine.mIconResourceID = Integer.valueOf(2130840535);
          if (QLog.isColorLevel()) {
            QLog.d("SkinEngine", 2, "Set icon resouceID to " + 2130840535);
          }
        }
        i = a(paramContext);
        str = "/skin/skin_cache_mobileqq_" + AppSetting.a() + "_" + "de12fadd" + "_" + i;
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
          SkinEngine.init(paramContext, 8191, 2130837504, 2130851414, 1264, 2131165184, 2131167426, localFile);
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
          SkinEngine.init(paramContext, 8191, 2130837504, 2130851414, 1264, 2131165184, 2131167426, null);
          continue;
        }
        SkinEngine.getInstances().setSkinEngineHandler((SkinEngineHandler)localObject1);
        SkinEngine.getInstances().addDrawableResource(2130838979);
        SkinEngine.getInstances().addDrawableResource(2130839222);
        SkinEngine.getInstances().addDrawableResource(2130838980);
        SkinEngine.getInstances().addDrawableResource(2130850719);
        SkinEngine.getInstances().addDrawableResource(2130839540);
        SkinEngine.getInstances().addDrawableResource(2130839232);
        l2 = SystemClock.uptimeMillis();
        localObject1 = new SkinEngine.BackupForOOMData(2130850444, 2130850446, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130850444), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130846363, 2130850446, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130846363), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130850434, 2130850446, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130850434), (SkinEngine.BackupForOOMData)localObject1);
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
      SkinEngine.getInstances().setSkinTint(new TintManager());
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