package com.tencent.mobileqq.startup.step;

import ahqx;
import ahqy;
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
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.StringToIntParser;
import com.tencent.mobileqq.app.ThreadManager;
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
  extends Step
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
    jdField_a_of_type_ArrayOfInt = new int[] { 2130837592, 2130837906, 2130837905, 2130837904, 2130838475, 2130838567, 2130838566, 2130838591, 2130838593, 2130838597, 2130838581, 2130838699, 2130838913, 2130839189, 2130839524, 2130840566, 2130842977, 2130842976, 2130842972, 2130842971, 2130842967, 2130842966, 2130841498, 2130841503, 2130841504, 2130841505, 2130841506, 2130841507, 2130841508, 2130841509, 2130841510, 2130841511, 2130841514, 2130841513, 2130841515, 2130841516, 2130841517, 2130841519, 2130841518, 2130841520, 2130841521, 2130841522, 2130841523, 2130841524, 2130841525, 2130841526, 2130841527, 2130841528, 2130841529, 2130841530, 2130839135, 2130839134, 2130842882, 2130841625, 2130841626, 2130841504, 2130841563, 2130841625, 2130841626, 2130841503, 2130845309, 2130845504, 2130845494, 2130845493, 2130845515, 2130845514, 2130845873, 2130845810, 2130845807, 2130845677, 2130845743, 2130845927, 2130845755, 2130845753, 2130845757, 2130845761, 2130845760, 2130845746, 2130845705, 2130845711, 2130845712, 2130845724, 2130845873, 2130845836, 2130845837, 2130845842, 2130845858, 2130845862, 2130845860, 2130845866, 2130845864, 2130839143, 2130839147, 2130845782, 2130841543, 2130841542, 2130838583, 2130838584, 2130845812, 2130845809 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130837534, 2130837535, 2130837538, 2130837539, 2130837541, 2130837542, 2130837544, 2130837545, 2130838567, 2130838566, 2130845504, 2130845942, 2130845941, 2130839149, 2130839147, 2130846136, 2130845743, 2130845746, 2130845753, 2130845755, 2130845757, 2130845758, 2130845759, 2130845760, 2130845761, 2130846141, 2130846242, 2130839217, 2130839215, 2130839216, 2130839214, 2130839212, 2130839213, 2130841535, 2130841533, 2130841534, 2130839220, 2130839218, 2130839219, 2130838206, 2130846277, 2130839777, 2130839778, 2130839779, 2130839780, 2130845918, 2130845677, 2130845722, 2130845724, 2130840526, 2130840525, 2130840532, 2130845810, 2130845807, 2130845813, 2130845741, 2130845681, 2130845866, 2130845864, 2130845858, 2130838699, 2130845876, 2130845878, 2130845835, 2130845834 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2130837534, 2130837535, 2130837538, 2130837539, 2130837541, 2130837542, 2130837544, 2130837545, 2130837571, 2130837618, 2130837719, 2130837967, 2130846322, 2130846319, 2130846320, 2130846317, 2130846318, 2130846324, 2130838206, 2130838207, 2130838208, 2130838323, 2130838348, 2130838350, 2130838419, 2130838420, 2130838423, 2130838424, 2130838475, 2130838476, 2130838478, 2130838479, 2130838566, 2130838567, 2130838570, 2130838591, 2130838595, 2130838597, 2130838635, 2130838644, 2130838674, 2130838699, 2130838715, 2130838733, 2130839941, 2130838901, 2130838914, 2130837760, 2130846321, 2130846312, 2130839128, 2130844654, 2130844655, 2130839208, 2130839209, 2130844735, 2130839519, 2130839552, 2130840431, 2130840432, 2130840434, 2130840435, 2130841060, 2130841061, 2130841163, 2130841625, 2130841626, 2130842966, 2130842967, 2130842971, 2130842972, 2130842974, 2130842975, 2130842976, 2130842977, 2130843001, 2130846327, 2130844248, 2130844249, 2130844255, 2130844290, 2130844297, 2130844303, 2130844304, 2130844305, 2130844306, 2130844307, 2130844308, 2130844309, 2130844310, 2130844312, 2130844313, 2130844316, 2130844320, 2130844358, 2130844359, 2130844360, 2130846331, 2130844361, 2130844362, 2130844363, 2130844379, 2130844380, 2130845841, 2130837541, 2130844444, 2130844445, 2130846314, 2130846315, 2130844485, 2130846326, 2130844995, 2130844502, 2130844503, 2130844519, 2130846328, 2130846330, 2130844520, 2130844543, 2130844544, 2130844570, 2130844582, 2130844583, 2130844590, 2130844594, 2130844595, 2130844602, 2130844604, 2130844605, 2130844611, 2130844612, 2130844614, 2130844618, 2130844620, 2130844624, 2130844627, 2130844632, 2130844638, 2130844639, 2130844640, 2130844652, 2130844653, 2130844659, 2130844664, 2130844670, 2130844679, 2130844696, 2130844725, 2130844728, 2130844730, 2130844731, 2130844732, 2130844733, 2130844734, 2130844780, 2130844818, 2130844849, 2130844859, 2130844860, 2130844862, 2130844865, 2130844868, 2130842440, 2130844900, 2130844901, 2130844914, 2130844915, 2130844922, 2130844937, 2130844960, 2130845038, 2130845094, 2130845109, 2130845139, 2130845143, 2130845146, 2130845147, 2130845148, 2130845154, 2130845167, 2130845168, 2130845224, 2130845232, 2130845233, 2130845242, 2130845243, 2130845244, 2130845245, 2130845249, 2130845250, 2130845255, 2130845256, 2130845257, 2130845259, 2130845261, 2130845262, 2130845263, 2130845264, 2130845310, 2130845311, 2130845312, 2130845313, 2130845315, 2130845317, 2130845348, 2130845393, 2130845391, 2130845392, 2130845395, 2130845677, 2130845695, 2130845696, 2130845697, 2130845698, 2130845699, 2130845703, 2130845704, 2130845705, 2130845711, 2130845712, 2130845713, 2130845714, 2130845722, 2130845723, 2130845724, 2130845743, 2130845746, 2130845753, 2130845755, 2130845757, 2130845758, 2130845759, 2130845760, 2130845761, 2130845762, 2130845774, 2130845775, 2130845776, 2130845777, 2130845778, 2130845779, 2130845780, 2130845781, 2130845782, 2130845790, 2130845791, 2130845807, 2130845836, 2130845837, 2130845838, 2130845839, 2130845840, 2130845842, 2130845845, 2130845846, 2130845847, 2130845848, 2130845849, 2130845855, 2130845858, 2130845860, 2130845862, 2130845864, 2130845866, 2130845870, 2130845873, 2130845876, 2130845878, 2130845885, 2130845887, 2130845891, 2130845893, 2130845926, 2130845927, 2130845965, 2130846129, 2130846131, 2130846134, 2130846277, 2130846151, 2130846153 };
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
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131492864, null);
        ThreadManager.getSubThreadHandler().postDelayed(new ahqy("/skin/web_config", "/skin/web_skin_cache"), 10000L);
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
        if ((i != AppSetting.jdField_a_of_type_Int) || (!"345599".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "web skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131492864, localFile2);
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
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131492864, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838210);
      SkinEngine.getInstances().addDrawableResource(2130838586);
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
      SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, 1264, 2131492864, null);
      ThreadManager.getSubThreadHandler().postDelayed(new ahqy("/skin/web_config", "/skin/web_skin_cache"), 10000L);
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
      if (DeviceProfileManager.a((String)localObject1, (Object[])localObject2, new DeviceProfileManager.StringToIntParser()) >= 2)
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
      ThreadManager.post(new ahqx(this), 8, null, false);
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
        localFile1 = new File(localFile2, "/skin/qqfav_config");
        localFile2 = new File(localFile2, "/skin/qqfav_skin_cache");
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
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, 1264, 2131492864, null);
        ThreadManager.getSubThreadHandler().postDelayed(new ahqy("/skin/qqfav_config", "/skin/qqfav_skin_cache"), 10000L);
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
        if ((i != AppSetting.jdField_a_of_type_Int) || (!"345599".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qqfav skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, 1264, 2131492864, localFile2);
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
        QLog.d("SkinEngine", 2, "qqfav skin Cache load failed.", localException3);
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, 1264, 2131492864, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838210);
      SkinEngine.getInstances().addDrawableResource(2130838339);
      SkinEngine.getInstances().addDrawableResource(2130838586);
      SkinEngine.getInstances().addDrawableResource(2130838349);
      l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qqfav skin init skin engine cost: " + (l2 - l1));
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
        QLog.d("SkinEngine", 2, "qqfav skin cache time out");
      }
      SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, 1264, 2131492864, null);
      ThreadManager.getSubThreadHandler().postDelayed(new ahqy("/skin/qqfav_config", "/skin/qqfav_skin_cache"), 10000L);
    }
  }
  
  @TargetApi(16)
  public static final boolean c(Context paramContext)
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
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131492864, null);
        a().postDelayed(new ahqy("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
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
        if ((i != AppSetting.jdField_a_of_type_Int) || (!"345599".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qzone skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131492864, localFile2);
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
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131492864, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838210);
      SkinEngine.getInstances().addDrawableResource(2130838339);
      SkinEngine.getInstances().addDrawableResource(2130838586);
      SkinEngine.getInstances().addDrawableResource(2130838349);
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
      SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, 1264, 2131492864, null);
      a().postDelayed(new ahqy("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
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
          break label695;
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
        SkinEngine.init(paramContext, 8191, 2130837504, 1264, 2131492864, null);
        ThreadManager.getSubThreadHandler().postDelayed(new ahqy("/skin/config", str), 10000L);
        continue;
      }
      try
      {
        localObject2 = BaseApplicationImpl.sApplication;
        if (((Application)localObject2).getPackageManager().getApplicationInfo(((Application)localObject2).getPackageName(), 128).metaData.getBoolean("com.sec.android.support.multiwindow"))
        {
          SkinEngine.mIconResourceID = Integer.valueOf(2130839189);
          if (QLog.isColorLevel()) {
            QLog.d("SkinEngine", 2, "Set icon resouceID to " + 2130839189);
          }
        }
        i = a(paramContext);
        str = "/skin/skin_cache_mobileqq_" + AppSetting.jdField_a_of_type_Int + "_" + "345599" + "_" + i;
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
          SkinEngine.init(paramContext, 8191, 2130837504, 1264, 2131492864, localFile);
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
          SkinEngine.init(paramContext, 8191, 2130837504, 1264, 2131492864, null);
          continue;
        }
        SkinEngine.getInstances().setSkinEngineHandler((SkinEngineHandler)localObject1);
        SkinEngine.getInstances().addDrawableResource(2130838210);
        SkinEngine.getInstances().addDrawableResource(2130838339);
        SkinEngine.getInstances().addDrawableResource(2130838211);
        SkinEngine.getInstances().addDrawableResource(2130838586);
        SkinEngine.getInstances().addDrawableResource(2130838349);
        l2 = SystemClock.uptimeMillis();
        localObject1 = new SkinEngine.BackupForOOMData(2130845689, 2130845691, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130845689), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130843187, 2130845691, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130843187), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130843184, 2130845691, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130843184), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130845679, 2130845691, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130845679), (SkinEngine.BackupForOOMData)localObject1);
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        try
        {
          paramContext.getResources().getDrawable(2130837504);
          if (!QLog.isColorLevel()) {
            break label695;
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
  
  protected boolean a()
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
      if ((str == null) || (str.endsWith("map")) || (str.equals("pedit")) || (str.equals("plugin")) || (str.equals("demoji")) || (str.equals("peak")) || (str.equals("readinjoy")) || (str.endsWith("nearby")) || (str.equals("tool")))
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
        c(BaseApplicationImpl.sApplication);
        return true;
      }
      if (str.equals("web"))
      {
        a(BaseApplicationImpl.sApplication);
        return true;
      }
    } while (!str.equals("qqfav"));
    b(BaseApplicationImpl.sApplication);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitSkin
 * JD-Core Version:    0.7.0.1
 */