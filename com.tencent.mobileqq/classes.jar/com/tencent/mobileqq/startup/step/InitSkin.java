package com.tencent.mobileqq.startup.step;

import ajhd;
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
import axmj;
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
import xfr;

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
    jdField_a_of_type_ArrayOfInt = new int[] { 2130837728, 2130838115, 2130838114, 2130838113, 2130838983, 2130839084, 2130839083, 2130839112, 2130839114, 2130839118, 2130839101, 2130839242, 2130839366, 2130839762, 2130840939, 2130841914, 2130844883, 2130844882, 2130844878, 2130844877, 2130844873, 2130844872, 2130843257, 2130843263, 2130843264, 2130843265, 2130843266, 2130843267, 2130843268, 2130843269, 2130843270, 2130843271, 2130843274, 2130843273, 2130843275, 2130843276, 2130843277, 2130843279, 2130843278, 2130843288, 2130843289, 2130843290, 2130843291, 2130843292, 2130843293, 2130843294, 2130843295, 2130843296, 2130843297, 2130843298, 2130839696, 2130839695, 2130844774, 2130843446, 2130843448, 2130843264, 2130843360, 2130843446, 2130843448, 2130843263, 2130848281, 2130848524, 2130848510, 2130848509, 2130848531, 2130848530, 2130849004, 2130848906, 2130848902, 2130848725, 2130848801, 2130849057, 2130848819, 2130848815, 2130848823, 2130848829, 2130848827, 2130848807, 2130848757, 2130848764, 2130848765, 2130848777, 2130849004, 2130848967, 2130848968, 2130847870, 2130848984, 2130848989, 2130848987, 2130848995, 2130848991, 2130839704, 2130839708, 2130848851, 2130843317, 2130843316, 2130839104, 2130839105, 2130848909, 2130848905 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130837557, 2130837563, 2130837564, 2130837567, 2130837568, 2130837570, 2130837571, 2130839084, 2130839083, 2130848524, 2130839710, 2130839708, 2130849303, 2130848801, 2130848807, 2130848815, 2130848819, 2130848823, 2130848825, 2130848826, 2130848827, 2130848829, 2130849311, 2130849436, 2130839804, 2130839799, 2130839803, 2130839798, 2130839796, 2130839797, 2130843305, 2130843303, 2130843304, 2130840057, 2130840055, 2130840056, 2130838497, 2130849314, 2130841283, 2130841284, 2130841285, 2130841286, 2130849048, 2130848725, 2130848775, 2130848777, 2130841871, 2130841870, 2130841877, 2130848906, 2130848902, 2130848910, 2130848799, 2130848995, 2130848991, 2130848984, 2130839242, 2130849007, 2130849009, 2130848966, 2130848965 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2130837557, 2130837563, 2130837564, 2130837567, 2130837568, 2130837570, 2130837571, 2130837699, 2130837905, 2130838054, 2130838201, 2130838485, 2130838486, 2130838487, 2130838489, 2130838490, 2130838491, 2130838497, 2130838498, 2130838499, 2130838615, 2130838751, 2130838753, 2130838916, 2130838917, 2130838920, 2130838921, 2130838983, 2130838984, 2130838986, 2130838987, 2130839083, 2130839084, 2130839090, 2130839112, 2130839116, 2130839118, 2130839164, 2130839175, 2130839208, 2130839242, 2130839258, 2130839276, 2130839941, 2130839352, 2130839367, 2130837760, 2130839556, 2130839662, 2130839687, 2130847132, 2130847133, 2130839788, 2130839789, 2130847220, 2130840933, 2130840977, 2130841775, 2130841776, 2130841778, 2130841779, 2130842773, 2130842877, 2130843446, 2130843448, 2130844872, 2130844873, 2130844877, 2130844878, 2130844880, 2130844881, 2130844882, 2130844883, 2130844911, 2130846460, 2130846587, 2130846588, 2130846600, 2130846638, 2130846645, 2130846655, 2130846656, 2130846657, 2130846658, 2130846659, 2130846660, 2130846661, 2130846662, 2130846664, 2130846665, 2130846668, 2130846672, 2130846707, 2130846708, 2130846709, 2130846710, 2130846711, 2130846712, 2130846729, 2130846730, 2130847798, 2130837567, 2130846840, 2130846841, 2130846861, 2130846870, 2130846895, 2130846908, 2130847612, 2130846918, 2130846938, 2130846939, 2130846940, 2130846941, 2130846962, 2130846963, 2130847007, 2130847057, 2130847058, 2130847071, 2130847073, 2130847074, 2130847080, 2130847081, 2130847082, 2130847084, 2130847085, 2130847087, 2130847089, 2130847094, 2130847100, 2130847101, 2130847102, 2130847130, 2130847131, 2130847138, 2130847143, 2130847150, 2130847159, 2130847176, 2130847208, 2130847211, 2130847214, 2130847216, 2130847217, 2130847218, 2130847219, 2130847324, 2130847381, 2130847412, 2130847423, 2130847424, 2130847426, 2130847429, 2130847432, 2130844287, 2130847474, 2130847475, 2130847510, 2130847511, 2130847518, 2130847538, 2130847574, 2130847673, 2130847807, 2130847929, 2130847875, 2130847879, 2130847882, 2130847885, 2130847886, 2130847977, 2130847992, 2130847993, 2130848061, 2130848082, 2130848083, 2130848084, 2130848085, 2130848089, 2130848090, 2130848095, 2130848096, 2130848097, 2130848098, 2130848099, 2130848100, 2130848101, 2130848282, 2130848283, 2130848284, 2130848285, 2130848287, 2130848289, 2130848327, 2130848383, 2130848381, 2130848382, 2130848385, 2130848725, 2130848745, 2130848746, 2130848747, 2130848749, 2130848750, 2130848754, 2130848755, 2130848757, 2130848764, 2130848765, 2130848766, 2130848767, 2130848775, 2130848776, 2130848777, 2130848801, 2130848807, 2130848815, 2130848819, 2130848823, 2130848825, 2130848826, 2130848827, 2130848829, 2130848831, 2130848843, 2130848844, 2130848845, 2130848846, 2130848847, 2130848848, 2130848849, 2130848850, 2130848851, 2130848861, 2130848862, 2130848902, 2130848967, 2130848968, 2130848969, 2130848975, 2130848976, 2130847870, 2130847824, 2130847825, 2130847826, 2130847827, 2130847828, 2130848983, 2130848984, 2130848987, 2130848989, 2130848991, 2130848995, 2130849001, 2130849004, 2130849007, 2130849009, 2130849016, 2130849018, 2130849022, 2130849024, 2130849056, 2130849057, 2130849109, 2130849252, 2130849254, 2130849301, 2130849314, 2130849327, 2130849329 };
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
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131099648, null);
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
        if ((i != AppSetting.a()) || (!"cc9d1343".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "web skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131099648, localFile2);
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
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131099648, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new xfr(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838503);
      SkinEngine.getInstances().addDrawableResource(2130839107);
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
      SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131099648, null);
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
      if (DeviceProfileManager.a((String)localObject1, (Object[])localObject2, new ajhd()) >= 2)
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
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131099648, null);
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
        if ((i != AppSetting.a()) || (!"cc9d1343".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qzone skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131099648, localFile2);
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
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131099648, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new xfr(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838503);
      SkinEngine.getInstances().addDrawableResource(2130838742);
      SkinEngine.getInstances().addDrawableResource(2130839107);
      SkinEngine.getInstances().addDrawableResource(2130838752);
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
      SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131099648, null);
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
        localObject1 = new xfr(BaseApplicationImpl.getApplication());
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
        SkinEngine.init(paramContext, 8191, 2130837504, 1264, 2131099648, null);
        ThreadManager.getSubThreadHandler().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/config", str), 10000L);
        continue;
      }
      try
      {
        localObject2 = BaseApplicationImpl.sApplication;
        if (((Application)localObject2).getPackageManager().getApplicationInfo(((Application)localObject2).getPackageName(), 128).metaData.getBoolean("com.sec.android.support.multiwindow"))
        {
          SkinEngine.mIconResourceID = Integer.valueOf(2130839762);
          if (QLog.isColorLevel()) {
            QLog.d("SkinEngine", 2, "Set icon resouceID to " + 2130839762);
          }
        }
        i = a(paramContext);
        str = "/skin/skin_cache_mobileqq_" + AppSetting.a() + "_" + "cc9d1343" + "_" + i;
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
          SkinEngine.init(paramContext, 8191, 2130837504, 1264, 2131099648, localFile);
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
          SkinEngine.init(paramContext, 8191, 2130837504, 1264, 2131099648, null);
          continue;
        }
        SkinEngine.getInstances().setSkinEngineHandler((SkinEngineHandler)localObject1);
        SkinEngine.getInstances().addDrawableResource(2130838503);
        SkinEngine.getInstances().addDrawableResource(2130838742);
        SkinEngine.getInstances().addDrawableResource(2130838504);
        SkinEngine.getInstances().addDrawableResource(2130848962);
        SkinEngine.getInstances().addDrawableResource(2130839107);
        SkinEngine.getInstances().addDrawableResource(2130838752);
        l2 = SystemClock.uptimeMillis();
        localObject1 = new SkinEngine.BackupForOOMData(2130848738, 2130848740, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130848738), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130845114, 2130848740, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130845114), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130848727, 2130848740, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130848727), (SkinEngine.BackupForOOMData)localObject1);
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
      SkinEngine.getInstances().setSkinTint(new axmj());
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