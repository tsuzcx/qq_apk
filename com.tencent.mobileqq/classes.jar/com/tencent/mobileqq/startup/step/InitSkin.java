package com.tencent.mobileqq.startup.step;

import almr;
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
import bakn;
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
import zdh;

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
    jdField_a_of_type_ArrayOfInt = new int[] { 2130837934, 2130838178, 2130838177, 2130838176, 2130839092, 2130839193, 2130839192, 2130839223, 2130839225, 2130839229, 2130839213, 2130839355, 2130839478, 2130840157, 2130841121, 2130842160, 2130845330, 2130845329, 2130845325, 2130845324, 2130845320, 2130845319, 2130843692, 2130843698, 2130843699, 2130843700, 2130843701, 2130843702, 2130843703, 2130843704, 2130843705, 2130843706, 2130843709, 2130843708, 2130843710, 2130843711, 2130843712, 2130843714, 2130843713, 2130843723, 2130843724, 2130843725, 2130843726, 2130843727, 2130843728, 2130843729, 2130843730, 2130843731, 2130843732, 2130843733, 2130840093, 2130840092, 2130845219, 2130843890, 2130843892, 2130843699, 2130843802, 2130843890, 2130843892, 2130843698, 2130848947, 2130849204, 2130849190, 2130849189, 2130849211, 2130849210, 2130849679, 2130849574, 2130849570, 2130849388, 2130849463, 2130849732, 2130849481, 2130849477, 2130849485, 2130849491, 2130849489, 2130849469, 2130849419, 2130849426, 2130849427, 2130849439, 2130849679, 2130849642, 2130849643, 2130848489, 2130849659, 2130849664, 2130849662, 2130849670, 2130849666, 2130840101, 2130840105, 2130849513, 2130843753, 2130843752, 2130839216, 2130839217, 2130849577, 2130849573 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130837562, 2130837569, 2130837570, 2130837573, 2130837574, 2130837576, 2130837577, 2130839193, 2130839192, 2130849204, 2130840107, 2130840105, 2130849987, 2130849463, 2130849469, 2130849477, 2130849481, 2130849485, 2130849487, 2130849488, 2130849489, 2130849491, 2130849996, 2130850122, 2130840200, 2130840195, 2130840199, 2130840194, 2130840192, 2130840193, 2130843740, 2130843738, 2130843739, 2130840206, 2130840204, 2130840205, 2130838577, 2130849999, 2130841508, 2130841509, 2130841510, 2130841511, 2130849723, 2130849388, 2130849437, 2130849439, 2130842117, 2130842116, 2130842123, 2130849574, 2130849570, 2130849578, 2130849461, 2130849670, 2130849666, 2130849659, 2130839355, 2130849682, 2130849684, 2130849641, 2130849640 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2130837562, 2130837569, 2130837570, 2130837573, 2130837574, 2130837576, 2130837577, 2130837905, 2130837970, 2130838117, 2130838286, 2130838565, 2130838566, 2130838567, 2130838569, 2130838570, 2130838571, 2130838577, 2130838578, 2130838579, 2130838699, 2130838933, 2130838935, 2130839015, 2130839016, 2130839019, 2130839020, 2130839092, 2130839093, 2130839095, 2130839096, 2130839192, 2130839193, 2130839202, 2130839223, 2130839227, 2130839229, 2130839278, 2130839289, 2130839321, 2130839355, 2130839371, 2130839389, 2130839941, 2130839463, 2130839479, 2130837760, 2130839701, 2130840059, 2130840084, 2130847729, 2130847730, 2130840183, 2130840184, 2130847825, 2130841115, 2130841170, 2130842021, 2130842022, 2130842024, 2130842025, 2130843041, 2130843145, 2130843890, 2130843892, 2130845319, 2130845320, 2130845324, 2130845325, 2130845327, 2130845328, 2130845329, 2130845330, 2130845359, 2130847021, 2130847148, 2130847149, 2130847161, 2130847199, 2130847206, 2130847216, 2130847217, 2130847218, 2130847219, 2130847220, 2130847221, 2130847222, 2130847223, 2130847225, 2130847226, 2130847229, 2130847233, 2130847270, 2130847271, 2130847272, 2130847273, 2130847274, 2130847275, 2130847293, 2130847294, 2130848417, 2130837573, 2130847404, 2130847405, 2130847425, 2130847434, 2130847459, 2130847472, 2130848230, 2130847482, 2130847503, 2130847504, 2130847505, 2130847506, 2130847527, 2130847528, 2130847574, 2130847624, 2130847625, 2130847667, 2130847669, 2130847670, 2130847676, 2130847677, 2130847678, 2130847680, 2130847681, 2130847683, 2130847685, 2130847690, 2130847696, 2130847697, 2130847698, 2130847727, 2130847728, 2130847735, 2130847740, 2130847747, 2130847756, 2130847773, 2130847813, 2130847816, 2130847819, 2130847821, 2130847822, 2130847823, 2130847824, 2130847937, 2130847995, 2130848026, 2130848037, 2130848038, 2130848040, 2130848043, 2130848046, 2130844735, 2130848088, 2130848089, 2130848127, 2130848128, 2130848135, 2130848156, 2130848192, 2130848292, 2130848426, 2130848550, 2130848494, 2130848498, 2130848501, 2130848504, 2130848505, 2130848598, 2130848613, 2130848614, 2130848702, 2130848725, 2130848726, 2130848727, 2130848728, 2130848732, 2130848733, 2130848738, 2130848739, 2130848740, 2130848741, 2130848742, 2130848743, 2130848744, 2130848948, 2130848949, 2130848950, 2130848951, 2130848953, 2130848955, 2130848995, 2130849051, 2130849049, 2130849050, 2130849053, 2130849388, 2130849407, 2130849408, 2130849409, 2130849411, 2130849412, 2130849416, 2130849417, 2130849419, 2130849426, 2130849427, 2130849428, 2130849429, 2130849437, 2130849438, 2130849439, 2130849463, 2130849469, 2130849477, 2130849481, 2130849485, 2130849487, 2130849488, 2130849489, 2130849491, 2130849493, 2130849505, 2130849506, 2130849507, 2130849508, 2130849509, 2130849510, 2130849511, 2130849512, 2130849513, 2130849523, 2130849524, 2130849570, 2130849642, 2130849643, 2130849644, 2130849650, 2130849651, 2130848489, 2130848443, 2130848444, 2130848445, 2130848446, 2130848447, 2130849658, 2130849659, 2130849662, 2130849664, 2130849666, 2130849670, 2130849676, 2130849679, 2130849682, 2130849684, 2130849691, 2130849693, 2130849697, 2130849699, 2130849731, 2130849732, 2130849786, 2130849936, 2130849938, 2130849985, 2130849999, 2130850012, 2130850014 };
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
        if ((i != AppSetting.a()) || (!"6b98d0b0".equals(str))) {
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
      SkinEngine.getInstances().setSkinEngineHandler(new zdh(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838591);
      SkinEngine.getInstances().addDrawableResource(2130839219);
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
      if (DeviceProfileManager.a((String)localObject1, (Object[])localObject2, new almr()) >= 2)
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
        if ((i != AppSetting.a()) || (!"6b98d0b0".equals(str))) {
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
      SkinEngine.getInstances().setSkinEngineHandler(new zdh(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838591);
      SkinEngine.getInstances().addDrawableResource(2130838924);
      SkinEngine.getInstances().addDrawableResource(2130839219);
      SkinEngine.getInstances().addDrawableResource(2130838934);
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
        localObject1 = new zdh(BaseApplicationImpl.getApplication());
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
          SkinEngine.mIconResourceID = Integer.valueOf(2130840157);
          if (QLog.isColorLevel()) {
            QLog.d("SkinEngine", 2, "Set icon resouceID to " + 2130840157);
          }
        }
        i = a(paramContext);
        str = "/skin/skin_cache_mobileqq_" + AppSetting.a() + "_" + "6b98d0b0" + "_" + i;
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
        SkinEngine.getInstances().addDrawableResource(2130838591);
        SkinEngine.getInstances().addDrawableResource(2130838924);
        SkinEngine.getInstances().addDrawableResource(2130838592);
        SkinEngine.getInstances().addDrawableResource(2130849630);
        SkinEngine.getInstances().addDrawableResource(2130839219);
        SkinEngine.getInstances().addDrawableResource(2130838934);
        l2 = SystemClock.uptimeMillis();
        localObject1 = new SkinEngine.BackupForOOMData(2130849400, 2130849402, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130849400), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130845566, 2130849402, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130845566), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130849390, 2130849402, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130849390), (SkinEngine.BackupForOOMData)localObject1);
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
      SkinEngine.getInstances().setSkinTint(new bakn());
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