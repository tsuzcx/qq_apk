package com.tencent.mobileqq.startup.step;

import abeu;
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
import ankp;
import bdqa;
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
    jdField_a_of_type_ArrayOfInt = new int[] { 2130838029, 2130838292, 2130838291, 2130838290, 2130839266, 2130839370, 2130839369, 2130839401, 2130839403, 2130839407, 2130839391, 2130839535, 2130839653, 2130840337, 2130841372, 2130842483, 2130845799, 2130845798, 2130845794, 2130845793, 2130845789, 2130845788, 2130844130, 2130844145, 2130844146, 2130844147, 2130844148, 2130844149, 2130844150, 2130844151, 2130844152, 2130844153, 2130844156, 2130844155, 2130844157, 2130844158, 2130844159, 2130844161, 2130844160, 2130844170, 2130844171, 2130844172, 2130844173, 2130844174, 2130844175, 2130844176, 2130844177, 2130844178, 2130844179, 2130844180, 2130840273, 2130840272, 2130845687, 2130844356, 2130844358, 2130844146, 2130844262, 2130844356, 2130844358, 2130844145, 2130849557, 2130849828, 2130849814, 2130849813, 2130849835, 2130849834, 2130850338, 2130850223, 2130850219, 2130850012, 2130850087, 2130850392, 2130850105, 2130850101, 2130850109, 2130850115, 2130850113, 2130850093, 2130850043, 2130850050, 2130850051, 2130850063, 2130850338, 2130850301, 2130850302, 2130849038, 2130850318, 2130850323, 2130850321, 2130850329, 2130850325, 2130840281, 2130840285, 2130850137, 2130844211, 2130844210, 2130839394, 2130839395, 2130850226, 2130850222 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130837574, 2130837581, 2130837582, 2130837588, 2130837589, 2130837593, 2130837594, 2130839370, 2130839369, 2130849828, 2130840287, 2130840285, 2130850652, 2130850087, 2130850093, 2130850101, 2130850105, 2130850109, 2130850111, 2130850112, 2130850113, 2130850115, 2130850661, 2130850791, 2130840381, 2130840376, 2130840380, 2130840375, 2130840373, 2130840374, 2130844187, 2130844185, 2130844186, 2130840387, 2130840385, 2130840386, 2130838741, 2130850664, 2130841824, 2130841825, 2130841826, 2130841827, 2130850382, 2130850012, 2130850061, 2130850063, 2130842440, 2130842439, 2130842446, 2130850223, 2130850219, 2130850227, 2130850085, 2130850329, 2130850325, 2130850318, 2130839535, 2130850341, 2130850343, 2130850300, 2130850299 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2130837574, 2130837581, 2130837582, 2130837588, 2130837589, 2130837593, 2130837594, 2130838000, 2130838065, 2130838214, 2130838385, 2130838729, 2130838730, 2130838731, 2130838733, 2130838734, 2130838735, 2130838741, 2130838743, 2130838744, 2130838951, 2130839100, 2130839102, 2130839184, 2130839186, 2130839190, 2130839191, 2130839266, 2130839267, 2130839269, 2130839270, 2130839369, 2130839370, 2130839379, 2130839401, 2130839405, 2130839407, 2130839457, 2130839468, 2130839499, 2130839535, 2130839551, 2130839569, 2130839941, 2130839638, 2130839654, 2130837760, 2130840108, 2130840238, 2130840264, 2130848262, 2130848263, 2130840364, 2130840365, 2130848374, 2130841366, 2130841474, 2130842343, 2130842344, 2130842346, 2130842347, 2130843401, 2130843505, 2130844356, 2130844358, 2130845788, 2130845789, 2130845793, 2130845794, 2130845796, 2130845797, 2130845798, 2130845799, 2130845828, 2130847553, 2130847680, 2130847681, 2130847693, 2130847731, 2130847738, 2130847748, 2130847749, 2130847750, 2130847751, 2130847752, 2130847753, 2130847754, 2130847755, 2130847757, 2130847758, 2130847761, 2130847765, 2130847802, 2130847803, 2130847804, 2130847805, 2130847806, 2130847807, 2130847825, 2130847826, 2130848966, 2130837588, 2130847937, 2130847938, 2130847958, 2130847967, 2130847992, 2130848005, 2130848779, 2130848015, 2130848036, 2130848037, 2130848038, 2130848039, 2130848060, 2130848061, 2130848107, 2130848157, 2130848158, 2130848200, 2130848202, 2130848203, 2130848209, 2130848210, 2130848211, 2130848213, 2130848214, 2130848216, 2130848218, 2130848223, 2130848229, 2130848230, 2130848231, 2130848260, 2130848261, 2130848268, 2130848289, 2130848296, 2130848305, 2130848322, 2130848362, 2130848365, 2130848368, 2130848370, 2130848371, 2130848372, 2130848373, 2130848486, 2130848544, 2130848575, 2130848586, 2130848587, 2130848589, 2130848592, 2130848595, 2130845204, 2130848637, 2130848638, 2130848676, 2130848677, 2130848684, 2130848705, 2130848741, 2130848841, 2130848975, 2130849099, 2130849043, 2130849047, 2130849050, 2130849053, 2130849054, 2130849147, 2130849162, 2130849163, 2130849253, 2130849276, 2130849277, 2130849278, 2130849279, 2130849283, 2130849284, 2130849289, 2130849290, 2130849291, 2130849292, 2130849293, 2130849294, 2130849295, 2130849558, 2130849559, 2130849560, 2130849561, 2130849563, 2130849565, 2130849608, 2130849665, 2130849663, 2130849664, 2130849667, 2130850012, 2130850031, 2130850032, 2130850033, 2130850035, 2130850036, 2130850040, 2130850041, 2130850043, 2130850050, 2130850051, 2130850052, 2130850053, 2130850061, 2130850062, 2130850063, 2130850087, 2130850093, 2130850101, 2130850105, 2130850109, 2130850111, 2130850112, 2130850113, 2130850115, 2130850117, 2130850129, 2130850130, 2130850131, 2130850132, 2130850133, 2130850134, 2130850135, 2130850136, 2130850137, 2130850147, 2130850148, 2130850219, 2130850301, 2130850302, 2130850303, 2130850309, 2130850310, 2130849038, 2130848992, 2130848993, 2130848994, 2130848995, 2130848996, 2130850317, 2130850318, 2130850321, 2130850323, 2130850325, 2130850329, 2130850335, 2130850338, 2130850341, 2130850343, 2130850350, 2130850352, 2130850356, 2130850358, 2130850391, 2130850392, 2130850447, 2130850601, 2130850603, 2130850650, 2130850664, 2130850678, 2130850680 };
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
        if ((i != AppSetting.a()) || (!"2703aac4".equals(str))) {
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
      SkinEngine.getInstances().setSkinEngineHandler(new abeu(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838758);
      SkinEngine.getInstances().addDrawableResource(2130839397);
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
      if (DeviceProfileManager.a((String)localObject1, (Object[])localObject2, new ankp()) >= 2)
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
        if ((i != AppSetting.a()) || (!"2703aac4".equals(str))) {
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
      SkinEngine.getInstances().setSkinEngineHandler(new abeu(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838758);
      SkinEngine.getInstances().addDrawableResource(2130839091);
      SkinEngine.getInstances().addDrawableResource(2130839397);
      SkinEngine.getInstances().addDrawableResource(2130839101);
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
        localObject1 = new abeu(BaseApplicationImpl.getApplication());
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
        SkinEngine.init(paramContext, 8191, 2130837504, 2130850872, 1264, 2131165184, null);
        ThreadManager.getSubThreadHandler().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/config", str), 10000L);
        continue;
      }
      try
      {
        localObject2 = BaseApplicationImpl.sApplication;
        if (((Application)localObject2).getPackageManager().getApplicationInfo(((Application)localObject2).getPackageName(), 128).metaData.getBoolean("com.sec.android.support.multiwindow"))
        {
          SkinEngine.mIconResourceID = Integer.valueOf(2130840337);
          if (QLog.isColorLevel()) {
            QLog.d("SkinEngine", 2, "Set icon resouceID to " + 2130840337);
          }
        }
        i = a(paramContext);
        str = "/skin/skin_cache_mobileqq_" + AppSetting.a() + "_" + "2703aac4" + "_" + i;
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
          SkinEngine.init(paramContext, 8191, 2130837504, 2130850872, 1264, 2131165184, localFile);
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
          SkinEngine.init(paramContext, 8191, 2130837504, 2130850872, 1264, 2131165184, null);
          continue;
        }
        SkinEngine.getInstances().setSkinEngineHandler((SkinEngineHandler)localObject1);
        SkinEngine.getInstances().addDrawableResource(2130838758);
        SkinEngine.getInstances().addDrawableResource(2130839091);
        SkinEngine.getInstances().addDrawableResource(2130838759);
        SkinEngine.getInstances().addDrawableResource(2130850283);
        SkinEngine.getInstances().addDrawableResource(2130839397);
        SkinEngine.getInstances().addDrawableResource(2130839101);
        l2 = SystemClock.uptimeMillis();
        localObject1 = new SkinEngine.BackupForOOMData(2130850024, 2130850026, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130850024), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130846048, 2130850026, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130846048), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130850014, 2130850026, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130850014), (SkinEngine.BackupForOOMData)localObject1);
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
      SkinEngine.getInstances().setSkinTint(new bdqa());
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