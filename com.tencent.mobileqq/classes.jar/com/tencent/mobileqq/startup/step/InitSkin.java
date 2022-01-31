package com.tencent.mobileqq.startup.step;

import aiez;
import aifa;
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
    jdField_a_of_type_ArrayOfInt = new int[] { 2130837595, 2130837909, 2130837908, 2130837907, 2130838479, 2130838571, 2130838570, 2130838595, 2130838597, 2130838601, 2130838585, 2130838703, 2130838917, 2130839193, 2130839529, 2130840572, 2130843076, 2130843075, 2130843071, 2130843070, 2130843066, 2130843065, 2130841535, 2130841540, 2130841541, 2130841542, 2130841543, 2130841544, 2130841545, 2130841546, 2130841547, 2130841548, 2130841551, 2130841550, 2130841552, 2130841553, 2130841554, 2130841556, 2130841555, 2130841557, 2130841558, 2130841559, 2130841560, 2130841561, 2130841562, 2130841563, 2130841564, 2130841565, 2130841566, 2130841567, 2130839139, 2130839138, 2130842981, 2130841662, 2130841663, 2130841541, 2130841600, 2130841662, 2130841663, 2130841540, 2130845437, 2130845632, 2130845622, 2130845621, 2130845643, 2130845642, 2130846001, 2130845938, 2130845935, 2130845805, 2130845871, 2130846055, 2130845883, 2130845881, 2130845885, 2130845889, 2130845888, 2130845874, 2130845833, 2130845839, 2130845840, 2130845852, 2130846001, 2130845964, 2130845965, 2130845970, 2130845986, 2130845990, 2130845988, 2130845994, 2130845992, 2130839147, 2130839151, 2130845910, 2130841580, 2130841579, 2130838587, 2130838588, 2130845940, 2130845937 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130837534, 2130837535, 2130837538, 2130837539, 2130837541, 2130837542, 2130837544, 2130837545, 2130838571, 2130838570, 2130845632, 2130846070, 2130846069, 2130839153, 2130839151, 2130846264, 2130845871, 2130845874, 2130845881, 2130845883, 2130845885, 2130845886, 2130845887, 2130845888, 2130845889, 2130846269, 2130846370, 2130839221, 2130839219, 2130839220, 2130839218, 2130839216, 2130839217, 2130841572, 2130841570, 2130841571, 2130839224, 2130839222, 2130839223, 2130838210, 2130846407, 2130839783, 2130839784, 2130839785, 2130839786, 2130846046, 2130845805, 2130845850, 2130845852, 2130840532, 2130840531, 2130840538, 2130845938, 2130845935, 2130845941, 2130845869, 2130845809, 2130845994, 2130845992, 2130845986, 2130838703, 2130846004, 2130846006, 2130845963, 2130845962 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2130837534, 2130837535, 2130837538, 2130837539, 2130837541, 2130837542, 2130837544, 2130837545, 2130837571, 2130837621, 2130837722, 2130837970, 2130846452, 2130846449, 2130846450, 2130846447, 2130846448, 2130846454, 2130838210, 2130838211, 2130838212, 2130838327, 2130838352, 2130838354, 2130838423, 2130838424, 2130838427, 2130838428, 2130838479, 2130838480, 2130838482, 2130838483, 2130838570, 2130838571, 2130838574, 2130838595, 2130838599, 2130838601, 2130838639, 2130838648, 2130838678, 2130838703, 2130838719, 2130838737, 2130839941, 2130838905, 2130838918, 2130837760, 2130846451, 2130846442, 2130839132, 2130844778, 2130844779, 2130839212, 2130839213, 2130844860, 2130839524, 2130839557, 2130840437, 2130840438, 2130840440, 2130840441, 2130841097, 2130841098, 2130841200, 2130841662, 2130841663, 2130843065, 2130843066, 2130843070, 2130843071, 2130843073, 2130843074, 2130843075, 2130843076, 2130843100, 2130846457, 2130844372, 2130844373, 2130844379, 2130844414, 2130844421, 2130844427, 2130844428, 2130844429, 2130844430, 2130844431, 2130844432, 2130844433, 2130844434, 2130844436, 2130844437, 2130844440, 2130844444, 2130844482, 2130844483, 2130844484, 2130846461, 2130844485, 2130844486, 2130844487, 2130844503, 2130844504, 2130845969, 2130837541, 2130844568, 2130844569, 2130846444, 2130846445, 2130844609, 2130846456, 2130845120, 2130844626, 2130844627, 2130844643, 2130846458, 2130846460, 2130844644, 2130844667, 2130844668, 2130844694, 2130844706, 2130844707, 2130844714, 2130844718, 2130844719, 2130844726, 2130844728, 2130844729, 2130844735, 2130844736, 2130844738, 2130844742, 2130844744, 2130844748, 2130844751, 2130844756, 2130844762, 2130844763, 2130844764, 2130844776, 2130844777, 2130844783, 2130844788, 2130844794, 2130844803, 2130844820, 2130844850, 2130844853, 2130844855, 2130844856, 2130844857, 2130844858, 2130844859, 2130844905, 2130844943, 2130844974, 2130844984, 2130844985, 2130844987, 2130844990, 2130844993, 2130842532, 2130845025, 2130845026, 2130845039, 2130845040, 2130845047, 2130845062, 2130845085, 2130845163, 2130845219, 2130845234, 2130845264, 2130845268, 2130845271, 2130845272, 2130845273, 2130845279, 2130845292, 2130845293, 2130845349, 2130845357, 2130845358, 2130845367, 2130845368, 2130845369, 2130845370, 2130845374, 2130845375, 2130845380, 2130845381, 2130845382, 2130845384, 2130845386, 2130845387, 2130845388, 2130845389, 2130845438, 2130845439, 2130845440, 2130845441, 2130845443, 2130845445, 2130845476, 2130845521, 2130845519, 2130845520, 2130845523, 2130845805, 2130845823, 2130845824, 2130845825, 2130845826, 2130845827, 2130845831, 2130845832, 2130845833, 2130845839, 2130845840, 2130845841, 2130845842, 2130845850, 2130845851, 2130845852, 2130845871, 2130845874, 2130845881, 2130845883, 2130845885, 2130845886, 2130845887, 2130845888, 2130845889, 2130845890, 2130845902, 2130845903, 2130845904, 2130845905, 2130845906, 2130845907, 2130845908, 2130845909, 2130845910, 2130845918, 2130845919, 2130845935, 2130845964, 2130845965, 2130845966, 2130845967, 2130845968, 2130845970, 2130845973, 2130845974, 2130845975, 2130845976, 2130845977, 2130845983, 2130845986, 2130845988, 2130845990, 2130845992, 2130845994, 2130845998, 2130846001, 2130846004, 2130846006, 2130846013, 2130846015, 2130846019, 2130846021, 2130846054, 2130846055, 2130846093, 2130846257, 2130846259, 2130846262, 2130846407, 2130846279, 2130846281 };
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
        ThreadManager.getSubThreadHandler().postDelayed(new aifa("/skin/web_config", "/skin/web_skin_cache"), 10000L);
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
        if ((i != AppSetting.jdField_a_of_type_Int) || (!"349884".equals(str))) {
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
      SkinEngine.getInstances().addDrawableResource(2130838214);
      SkinEngine.getInstances().addDrawableResource(2130838590);
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
      ThreadManager.getSubThreadHandler().postDelayed(new aifa("/skin/web_config", "/skin/web_skin_cache"), 10000L);
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
      ThreadManager.post(new aiez(this), 8, null, false);
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
        ThreadManager.getSubThreadHandler().postDelayed(new aifa("/skin/qqfav_config", "/skin/qqfav_skin_cache"), 10000L);
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
        if ((i != AppSetting.jdField_a_of_type_Int) || (!"349884".equals(str))) {
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
      SkinEngine.getInstances().addDrawableResource(2130838214);
      SkinEngine.getInstances().addDrawableResource(2130838343);
      SkinEngine.getInstances().addDrawableResource(2130838590);
      SkinEngine.getInstances().addDrawableResource(2130838353);
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
      ThreadManager.getSubThreadHandler().postDelayed(new aifa("/skin/qqfav_config", "/skin/qqfav_skin_cache"), 10000L);
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
        a().postDelayed(new aifa("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
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
        if ((i != AppSetting.jdField_a_of_type_Int) || (!"349884".equals(str))) {
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
      SkinEngine.getInstances().addDrawableResource(2130838214);
      SkinEngine.getInstances().addDrawableResource(2130838343);
      SkinEngine.getInstances().addDrawableResource(2130838590);
      SkinEngine.getInstances().addDrawableResource(2130838353);
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
      a().postDelayed(new aifa("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
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
        ThreadManager.getSubThreadHandler().postDelayed(new aifa("/skin/config", str), 10000L);
        continue;
      }
      try
      {
        localObject2 = BaseApplicationImpl.sApplication;
        if (((Application)localObject2).getPackageManager().getApplicationInfo(((Application)localObject2).getPackageName(), 128).metaData.getBoolean("com.sec.android.support.multiwindow"))
        {
          SkinEngine.mIconResourceID = Integer.valueOf(2130839193);
          if (QLog.isColorLevel()) {
            QLog.d("SkinEngine", 2, "Set icon resouceID to " + 2130839193);
          }
        }
        i = a(paramContext);
        str = "/skin/skin_cache_mobileqq_" + AppSetting.jdField_a_of_type_Int + "_" + "349884" + "_" + i;
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
        SkinEngine.getInstances().addDrawableResource(2130838214);
        SkinEngine.getInstances().addDrawableResource(2130838343);
        SkinEngine.getInstances().addDrawableResource(2130838215);
        SkinEngine.getInstances().addDrawableResource(2130838590);
        SkinEngine.getInstances().addDrawableResource(2130838353);
        l2 = SystemClock.uptimeMillis();
        localObject1 = new SkinEngine.BackupForOOMData(2130845817, 2130845819, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130845817), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130843286, 2130845819, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130843286), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130843283, 2130845819, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130843283), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130845807, 2130845819, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130845807), (SkinEngine.BackupForOOMData)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitSkin
 * JD-Core Version:    0.7.0.1
 */