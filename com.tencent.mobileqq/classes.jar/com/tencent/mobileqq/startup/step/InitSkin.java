package com.tencent.mobileqq.startup.step;

import aijt;
import aiju;
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
    jdField_a_of_type_ArrayOfInt = new int[] { 2130837594, 2130837908, 2130837907, 2130837906, 2130838485, 2130838577, 2130838576, 2130838601, 2130838603, 2130838607, 2130838591, 2130838712, 2130838926, 2130839210, 2130839544, 2130840587, 2130843108, 2130843107, 2130843103, 2130843102, 2130843098, 2130843097, 2130841562, 2130841567, 2130841568, 2130841569, 2130841570, 2130841571, 2130841572, 2130841573, 2130841574, 2130841575, 2130841578, 2130841577, 2130841579, 2130841580, 2130841581, 2130841583, 2130841582, 2130841584, 2130841585, 2130841586, 2130841587, 2130841588, 2130841589, 2130841590, 2130841591, 2130841592, 2130841593, 2130841594, 2130839154, 2130839153, 2130843013, 2130841689, 2130841690, 2130841568, 2130841627, 2130841689, 2130841690, 2130841567, 2130845518, 2130845713, 2130845703, 2130845702, 2130845724, 2130845723, 2130846083, 2130846020, 2130846017, 2130845886, 2130845951, 2130846137, 2130845963, 2130845961, 2130845965, 2130845969, 2130845968, 2130845954, 2130845913, 2130845919, 2130845920, 2130845932, 2130846083, 2130846046, 2130846047, 2130846052, 2130846068, 2130846072, 2130846070, 2130846076, 2130846074, 2130839162, 2130839166, 2130845990, 2130841607, 2130841606, 2130838593, 2130838594, 2130846022, 2130846019 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130837534, 2130837537, 2130837538, 2130837540, 2130837541, 2130837543, 2130837544, 2130838577, 2130838576, 2130845713, 2130846152, 2130846151, 2130839168, 2130839166, 2130846346, 2130845951, 2130845954, 2130845961, 2130845963, 2130845965, 2130845966, 2130845967, 2130845968, 2130845969, 2130846351, 2130846452, 2130839240, 2130839238, 2130839239, 2130839237, 2130839235, 2130839236, 2130841599, 2130841597, 2130841598, 2130839243, 2130839241, 2130839242, 2130838215, 2130846489, 2130839798, 2130839799, 2130839800, 2130839801, 2130846128, 2130845886, 2130845930, 2130845932, 2130840547, 2130840546, 2130840553, 2130846020, 2130846017, 2130846023, 2130845949, 2130846076, 2130846074, 2130846068, 2130838712, 2130846086, 2130846088, 2130846045, 2130846044 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2130837534, 2130837537, 2130837538, 2130837540, 2130837541, 2130837543, 2130837544, 2130837570, 2130837620, 2130837721, 2130837969, 2130846534, 2130846531, 2130846532, 2130846529, 2130846530, 2130846536, 2130838215, 2130838216, 2130838217, 2130838332, 2130838357, 2130838359, 2130838428, 2130838429, 2130838432, 2130838433, 2130838485, 2130838486, 2130838488, 2130838489, 2130838576, 2130838577, 2130838580, 2130838601, 2130838605, 2130838607, 2130838645, 2130838654, 2130838686, 2130838712, 2130838728, 2130838746, 2130839941, 2130838914, 2130838927, 2130837760, 2130846533, 2130846524, 2130839147, 2130844853, 2130844854, 2130839231, 2130839232, 2130844935, 2130839539, 2130839572, 2130840452, 2130840453, 2130840455, 2130840456, 2130841118, 2130841226, 2130841689, 2130841690, 2130843097, 2130843098, 2130843102, 2130843103, 2130843105, 2130843106, 2130843107, 2130843108, 2130843132, 2130846539, 2130844445, 2130844446, 2130844452, 2130844487, 2130844494, 2130844500, 2130844501, 2130844502, 2130844503, 2130844504, 2130844505, 2130844506, 2130844507, 2130844509, 2130844510, 2130844513, 2130844517, 2130844546, 2130844547, 2130844548, 2130846543, 2130844549, 2130844550, 2130844551, 2130844567, 2130844568, 2130846051, 2130837540, 2130844635, 2130844636, 2130846526, 2130846527, 2130844678, 2130846538, 2130845194, 2130844695, 2130844696, 2130844712, 2130846540, 2130846542, 2130844713, 2130844736, 2130844737, 2130844770, 2130844782, 2130844789, 2130844793, 2130844794, 2130844801, 2130844803, 2130844804, 2130844810, 2130844811, 2130844813, 2130844817, 2130844819, 2130844823, 2130844826, 2130844831, 2130844837, 2130844838, 2130844839, 2130844851, 2130844852, 2130844858, 2130844863, 2130844869, 2130844878, 2130844895, 2130844925, 2130844928, 2130844930, 2130844931, 2130844932, 2130844933, 2130844934, 2130844980, 2130845019, 2130845049, 2130845059, 2130845060, 2130845062, 2130845065, 2130845068, 2130842567, 2130845100, 2130845101, 2130845113, 2130845114, 2130845121, 2130845136, 2130845159, 2130845237, 2130845293, 2130845308, 2130845338, 2130845342, 2130845345, 2130845347, 2130845348, 2130845354, 2130845368, 2130845369, 2130845429, 2130845437, 2130845438, 2130845447, 2130845448, 2130845449, 2130845450, 2130845454, 2130845455, 2130845461, 2130845462, 2130845463, 2130845465, 2130845467, 2130845468, 2130845469, 2130845470, 2130845519, 2130845520, 2130845521, 2130845522, 2130845524, 2130845526, 2130845557, 2130845602, 2130845600, 2130845601, 2130845604, 2130845886, 2130845903, 2130845904, 2130845905, 2130845906, 2130845907, 2130845911, 2130845912, 2130845913, 2130845919, 2130845920, 2130845921, 2130845922, 2130845930, 2130845931, 2130845932, 2130845951, 2130845954, 2130845961, 2130845963, 2130845965, 2130845966, 2130845967, 2130845968, 2130845969, 2130845970, 2130845982, 2130845983, 2130845984, 2130845985, 2130845986, 2130845987, 2130845988, 2130845989, 2130845990, 2130845998, 2130845999, 2130846017, 2130846046, 2130846047, 2130846048, 2130846049, 2130846050, 2130846052, 2130846055, 2130846056, 2130846057, 2130846058, 2130846059, 2130846065, 2130846068, 2130846070, 2130846072, 2130846074, 2130846076, 2130846080, 2130846083, 2130846086, 2130846088, 2130846095, 2130846097, 2130846101, 2130846103, 2130846136, 2130846137, 2130846175, 2130846339, 2130846341, 2130846344, 2130846489, 2130846361, 2130846363 };
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
        ThreadManager.getSubThreadHandler().postDelayed(new aiju("/skin/web_config", "/skin/web_skin_cache"), 10000L);
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
        if ((i != AppSetting.jdField_a_of_type_Int) || (!"355371".equals(str))) {
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
      SkinEngine.getInstances().addDrawableResource(2130838219);
      SkinEngine.getInstances().addDrawableResource(2130838596);
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
      ThreadManager.getSubThreadHandler().postDelayed(new aiju("/skin/web_config", "/skin/web_skin_cache"), 10000L);
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
      ThreadManager.post(new aijt(this), 8, null, false);
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
        ThreadManager.getSubThreadHandler().postDelayed(new aiju("/skin/qqfav_config", "/skin/qqfav_skin_cache"), 10000L);
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
        if ((i != AppSetting.jdField_a_of_type_Int) || (!"355371".equals(str))) {
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
      SkinEngine.getInstances().addDrawableResource(2130838219);
      SkinEngine.getInstances().addDrawableResource(2130838348);
      SkinEngine.getInstances().addDrawableResource(2130838596);
      SkinEngine.getInstances().addDrawableResource(2130838358);
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
      ThreadManager.getSubThreadHandler().postDelayed(new aiju("/skin/qqfav_config", "/skin/qqfav_skin_cache"), 10000L);
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
        a().postDelayed(new aiju("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
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
        if ((i != AppSetting.jdField_a_of_type_Int) || (!"355371".equals(str))) {
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
      SkinEngine.getInstances().addDrawableResource(2130838219);
      SkinEngine.getInstances().addDrawableResource(2130838348);
      SkinEngine.getInstances().addDrawableResource(2130838596);
      SkinEngine.getInstances().addDrawableResource(2130838358);
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
      a().postDelayed(new aiju("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
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
        ThreadManager.getSubThreadHandler().postDelayed(new aiju("/skin/config", str), 10000L);
        continue;
      }
      try
      {
        localObject2 = BaseApplicationImpl.sApplication;
        if (((Application)localObject2).getPackageManager().getApplicationInfo(((Application)localObject2).getPackageName(), 128).metaData.getBoolean("com.sec.android.support.multiwindow"))
        {
          SkinEngine.mIconResourceID = Integer.valueOf(2130839210);
          if (QLog.isColorLevel()) {
            QLog.d("SkinEngine", 2, "Set icon resouceID to " + 2130839210);
          }
        }
        i = a(paramContext);
        str = "/skin/skin_cache_mobileqq_" + AppSetting.jdField_a_of_type_Int + "_" + "355371" + "_" + i;
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
        SkinEngine.getInstances().addDrawableResource(2130838219);
        SkinEngine.getInstances().addDrawableResource(2130838348);
        SkinEngine.getInstances().addDrawableResource(2130838220);
        SkinEngine.getInstances().addDrawableResource(2130838596);
        SkinEngine.getInstances().addDrawableResource(2130838358);
        l2 = SystemClock.uptimeMillis();
        localObject1 = new SkinEngine.BackupForOOMData(2130845897, 2130845899, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130845897), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130843319, 2130845899, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130843319), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130843316, 2130845899, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130843316), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130845888, 2130845899, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130845888), (SkinEngine.BackupForOOMData)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitSkin
 * JD-Core Version:    0.7.0.1
 */