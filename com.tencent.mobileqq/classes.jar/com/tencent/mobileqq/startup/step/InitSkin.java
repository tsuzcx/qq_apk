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
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.SimpleTintManager;
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
  public static final int COLOR_COUNT = 1264;
  public static final String DPC_KEY_TOOL_PROCESS = "tool_process_profile";
  public static final int DRAWABLE_COUNT = 8191;
  public static final int FIRST_COLOR_ID = 2131165184;
  public static final int FIRST_DRAWABLE_ID = 2130837504;
  public static final int LAST_COLOR_ID = 2131168543;
  public static final int LAST_DRAWABLE_ID = 2130853739;
  private static final int[] QQ_FAV_DRAWABLES;
  private static final int[] QZONE_DRAWABLES = { 2130837684, 2130837692, 2130837693, 2130837699, 2130837700, 2130837704, 2130837705, 2130837993, 2130838069, 2130838223, 2130838404, 2130838928, 2130838929, 2130838930, 2130838932, 2130838933, 2130838934, 2130838940, 2130838942, 2130838943, 2130839090, 2130839240, 2130839242, 2130839336, 2130839340, 2130839347, 2130839348, 2130839439, 2130839440, 2130839442, 2130839443, 2130839550, 2130839551, 2130839560, 2130839584, 2130839589, 2130839591, 2130839647, 2130839658, 2130839690, 2130839736, 2130839760, 2130839784, 2130839941, 2130840114, 2130840143, 2130837760, 2130840350, 2130840613, 2130841060, 2130850185, 2130850186, 2130841189, 2130841190, 2130850295, 2130842279, 2130842449, 2130843424, 2130843425, 2130843427, 2130843428, 2130844562, 2130844666, 2130845736, 2130845738, 2130847460, 2130847461, 2130847465, 2130847466, 2130847468, 2130847469, 2130847470, 2130847471, 2130849457, 2130849588, 2130849589, 2130849601, 2130849639, 2130849646, 2130849656, 2130849657, 2130849658, 2130849659, 2130849660, 2130849661, 2130849662, 2130849663, 2130849665, 2130849666, 2130849669, 2130849673, 2130849714, 2130849715, 2130849716, 2130849717, 2130849718, 2130849719, 2130849737, 2130849738, 2130850937, 2130837699, 2130849848, 2130849849, 2130849870, 2130849879, 2130849904, 2130849917, 2130850744, 2130849931, 2130849955, 2130849956, 2130849957, 2130849958, 2130849983, 2130849984, 2130850030, 2130850080, 2130850081, 2130850123, 2130850125, 2130850126, 2130850132, 2130850133, 2130850134, 2130850136, 2130850137, 2130850139, 2130850141, 2130850146, 2130850152, 2130850153, 2130850154, 2130850183, 2130850184, 2130850191, 2130850209, 2130850216, 2130850225, 2130850242, 2130850282, 2130850285, 2130850288, 2130850291, 2130850292, 2130850293, 2130850294, 2130850435, 2130850493, 2130850524, 2130850535, 2130850536, 2130850538, 2130850541, 2130850544, 2130846657, 2130850602, 2130850603, 2130850641, 2130850642, 2130850649, 2130850670, 2130850706, 2130850806, 2130850947, 2130851071, 2130851015, 2130851019, 2130851022, 2130851025, 2130851026, 2130851119, 2130851146, 2130851147, 2130851236, 2130851259, 2130851260, 2130851261, 2130851262, 2130851266, 2130851267, 2130851272, 2130851273, 2130851274, 2130851275, 2130851276, 2130851277, 2130851278, 2130851565, 2130851566, 2130851568, 2130851569, 2130851571, 2130851573, 2130851695, 2130851768, 2130851766, 2130851767, 2130851772, 2130852150, 2130852169, 2130852170, 2130852171, 2130852173, 2130852174, 2130852178, 2130852179, 2130852181, 2130852188, 2130852189, 2130852190, 2130852191, 2130852199, 2130852200, 2130852201, 2130852228, 2130852235, 2130852243, 2130852247, 2130852251, 2130852253, 2130852254, 2130852255, 2130852257, 2130852259, 2130852271, 2130852272, 2130852273, 2130852274, 2130852275, 2130852276, 2130852277, 2130852278, 2130852279, 2130852290, 2130852291, 2130852374, 2130852468, 2130852469, 2130852470, 2130852476, 2130852477, 2130851010, 2130850964, 2130850965, 2130850966, 2130850967, 2130850968, 2130852484, 2130852485, 2130852488, 2130852490, 2130852492, 2130852497, 2130852504, 2130852507, 2130852510, 2130852512, 2130852519, 2130852521, 2130852525, 2130852527, 2130852591, 2130852592, 2130852666, 2130853225, 2130853241, 2130853293, 2130853309, 2130853331, 2130853333 };
  private static final String TAG = "InitSkin";
  private static final int[] WEB_DRAWABLES;
  public static boolean sInited = false;
  public static boolean sToolAsynInitDPC = false;
  public static final Object sToolInitLock = new Object();
  public static int sToolInitTimeout = 3000;
  public static volatile boolean sToolProcessInitComplete = false;
  
  static
  {
    QQ_FAV_DRAWABLES = new int[] { 2130838020, 2130838304, 2130838303, 2130838302, 2130839439, 2130839551, 2130839550, 2130839584, 2130839586, 2130839591, 2130839574, 2130839736, 2130840142, 2130841158, 2130842292, 2130843570, 2130847471, 2130847470, 2130847466, 2130847465, 2130847461, 2130847460, 2130845487, 2130845510, 2130845511, 2130845512, 2130845513, 2130845514, 2130845515, 2130845516, 2130845517, 2130845518, 2130845521, 2130845520, 2130845522, 2130845523, 2130845524, 2130845526, 2130845525, 2130845535, 2130845536, 2130845537, 2130845538, 2130845539, 2130845540, 2130845542, 2130845543, 2130845544, 2130845545, 2130845546, 2130841079, 2130841078, 2130847329, 2130845736, 2130845738, 2130845511, 2130845641, 2130845736, 2130845738, 2130845510, 2130851564, 2130851965, 2130851945, 2130851944, 2130851972, 2130851971, 2130852507, 2130852379, 2130852374, 2130852150, 2130852228, 2130852592, 2130852247, 2130852243, 2130852251, 2130852257, 2130852255, 2130852235, 2130852181, 2130852188, 2130852189, 2130852201, 2130852507, 2130852468, 2130852469, 2130851010, 2130852485, 2130852490, 2130852488, 2130852497, 2130852492, 2130841087, 2130841091, 2130852279, 2130845582, 2130845581, 2130839577, 2130839578, 2130852382, 2130852377 };
    WEB_DRAWABLES = new int[] { 2130837684, 2130837692, 2130837693, 2130837699, 2130837700, 2130837704, 2130837705, 2130839551, 2130839550, 2130851965, 2130841093, 2130841091, 2130853297, 2130852228, 2130852235, 2130852243, 2130852247, 2130852251, 2130852253, 2130852254, 2130852255, 2130852257, 2130853306, 2130853485, 2130841212, 2130841207, 2130841211, 2130841206, 2130841204, 2130841205, 2130845553, 2130845551, 2130845552, 2130841218, 2130841216, 2130841217, 2130838940, 2130853309, 2130842848, 2130842849, 2130842850, 2130842851, 2130852582, 2130852150, 2130852199, 2130852201, 2130843527, 2130843526, 2130843533, 2130852379, 2130852374, 2130852384, 2130852226, 2130852497, 2130852492, 2130852485, 2130839736, 2130852510, 2130852512, 2130852467, 2130852466 };
  }
  
  private static void asynInitSkin()
  {
    sToolAsynInitDPC = false;
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
        sToolAsynInitDPC = bool;
        int i;
        if (localObject2[1].intValue() > 0) {
          i = localObject2[1].intValue();
        } else {
          i = 0;
        }
        sToolInitTimeout = i;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ToolAsynInitDPC = ");
      ((StringBuilder)localObject1).append(sToolAsynInitDPC);
      ((StringBuilder)localObject1).append("  sToolInitTimeout = ");
      ((StringBuilder)localObject1).append(sToolInitTimeout);
      QLog.i("InitSkin", 2, ((StringBuilder)localObject1).toString());
    }
    if (sToolAsynInitDPC)
    {
      ThreadManager.post(new InitSkin.2(), 8, null, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("InitSkin", 2, "start synInitSkin");
    }
    initSkin(BaseApplicationImpl.sApplication);
    sToolProcessInitComplete = true;
    if (QLog.isColorLevel()) {
      QLog.i("InitSkin", 2, "end synInitSkin");
    }
  }
  
  private static final int getDefaultCookieId(Context paramContext)
  {
    Object localObject = paramContext.getResources();
    paramContext = new TypedValue();
    ((Resources)localObject).getValue(2130837510, paramContext, true);
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
  
  private static MqqHandler getQZoneHander()
  {
    return new MqqHandler(ThreadManager.getSubThreadLooper());
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
          SkinEngine.mIconResourceID = Integer.valueOf(2130841158);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Set icon resouceID to ");
            ((StringBuilder)localObject2).append(2130841158);
            QLog.d("SkinEngine", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        localNameNotFoundException.printStackTrace();
      }
      int i = getDefaultCookieId(paramContext);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("/skin/skin_cache_mobileqq_");
      ((StringBuilder)localObject3).append(AppSetting.d());
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append("846a9bfd");
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
          SkinEngine.init(paramContext, 8191, 2130837504, 2130853739, 1264, 2131165184, 2131168543, localFile);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("SkinEngine", 2, "No cache found");
          }
          SkinEngine.init(paramContext, 8191, 2130837504, 2130853739, 1264, 2131165184, 2131168543, null);
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
        SkinEngine.init(paramContext, 8191, 2130837504, 2130853739, 1264, 2131165184, 2131168543, null);
      }
      SkinEngine.getInstances().setSkinEngineHandler((SkinEngineHandler)localObject1);
      SkinEngine.getInstances().addDrawableResource(2130838958);
      SkinEngine.getInstances().addDrawableResource(2130839229);
      SkinEngine.getInstances().addDrawableResource(2130838959);
      SkinEngine.getInstances().addDrawableResource(2130852449);
      SkinEngine.getInstances().addDrawableResource(2130839580);
      SkinEngine.getInstances().addDrawableResource(2130839241);
      long l2 = SystemClock.uptimeMillis();
      localObject1 = new SkinEngine.BackupForOOMData(2130852162, 2130852164, Bitmap.Config.RGB_565);
      SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130852162), (SkinEngine.BackupForOOMData)localObject1);
      localObject1 = new SkinEngine.BackupForOOMData(2130847705, 2130852164, Bitmap.Config.RGB_565);
      SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130847705), (SkinEngine.BackupForOOMData)localObject1);
      localObject1 = new SkinEngine.BackupForOOMData(2130852152, 2130852164, Bitmap.Config.RGB_565);
      SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130852152), (SkinEngine.BackupForOOMData)localObject1);
      try
      {
        paramContext.getResources().getDrawable(2130837510);
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
  
  public static final boolean initSkin4QQfav(Context paramContext)
  {
    try
    {
      Object localObject = paramContext.getCacheDir();
      long l1 = SystemClock.uptimeMillis();
      SkinEngine.SWITCH_DEBUG = false;
      SkinEngine.DEBUG = false;
      File localFile2 = new File((File)localObject, "/skin/qqfav_config");
      File localFile1 = new File((File)localObject, "/skin/qqfav_skin_cache");
      try
      {
        if (localFile2.exists())
        {
          localObject = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile2)));
          int i = ((ObjectInputStream)localObject).readInt();
          String str = ((ObjectInputStream)localObject).readUTF();
          ((ObjectInputStream)localObject).close();
          if ((i == AppSetting.d()) && ("846a9bfd".equals(str)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SkinEngine", 2, "qqfav skin cache find, use cache file accered");
            }
            localObject = QQ_FAV_DRAWABLES;
          }
        }
        try
        {
          SkinEngine.init(paramContext, (int[])localObject, 1264, 2131165184, 2131168543, localFile1);
        }
        catch (Exception localException1)
        {
          break label275;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qqfav skin cache time out");
        }
        SkinEngine.init(paramContext, QQ_FAV_DRAWABLES, 1264, 2131165184, 2131168543, null);
        ThreadManager.getSubThreadHandler().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/qqfav_config", "/skin/qqfav_skin_cache"), 10000L);
        break label336;
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "No cache found");
        }
        SkinEngine.init(paramContext, QQ_FAV_DRAWABLES, 1264, 2131165184, 2131168543, null);
        ThreadManager.getSubThreadHandler().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/qqfav_config", "/skin/qqfav_skin_cache"), 10000L);
      }
      catch (Exception localException2) {}
      label275:
      if (!localFile2.exists()) {
        localFile2.delete();
      }
      if (!localFile1.exists()) {
        localFile1.delete();
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "qqfav skin Cache load failed.", localException2);
      }
      SkinEngine.init(paramContext, QQ_FAV_DRAWABLES, 1264, 2131165184, 2131168543, null);
      label336:
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838958);
      SkinEngine.getInstances().addDrawableResource(2130839229);
      SkinEngine.getInstances().addDrawableResource(2130839580);
      SkinEngine.getInstances().addDrawableResource(2130839241);
      long l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837510);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("qqfav skin init skin engine cost: ");
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
        break label551;
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
  
  @TargetApi(16)
  public static final boolean initSkin4QZone(Context paramContext)
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
          if ((i == AppSetting.d()) && ("846a9bfd".equals(str)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SkinEngine", 2, "qzone skin cache find, use cache file accered");
            }
            localObject = QZONE_DRAWABLES;
          }
        }
        try
        {
          SkinEngine.init(paramContext, (int[])localObject, 1264, 2131165184, 2131168543, localFile1);
        }
        catch (Exception localException1)
        {
          break label275;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qzone skin cache time out");
        }
        SkinEngine.init(paramContext, QZONE_DRAWABLES, 1264, 2131165184, 2131168543, null);
        getQZoneHander().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
        break label336;
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "No cache found");
        }
        SkinEngine.init(paramContext, QZONE_DRAWABLES, 1264, 2131165184, 2131168543, null);
        getQZoneHander().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
      }
      catch (Exception localException2) {}
      label275:
      if (!localFile2.exists()) {
        localFile2.delete();
      }
      if (!localFile1.exists()) {
        localFile1.delete();
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "qzone skin Cache load failed.", localException2);
      }
      SkinEngine.init(paramContext, QZONE_DRAWABLES, 1264, 2131165184, 2131168543, null);
      label336:
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838958);
      SkinEngine.getInstances().addDrawableResource(2130839229);
      SkinEngine.getInstances().addDrawableResource(2130839580);
      SkinEngine.getInstances().addDrawableResource(2130839241);
      long l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837510);
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
        break label551;
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
  
  public static void initSkinWeb(Context paramContext)
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
          if ((i == AppSetting.d()) && ("846a9bfd".equals(str)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SkinEngine", 2, "web skin cache find, use cache file accered");
            }
            localObject = WEB_DRAWABLES;
          }
        }
        try
        {
          SkinEngine.init(paramContext, (int[])localObject, 1264, 2131165184, 2131168543, localFile1);
        }
        catch (Exception localException1)
        {
          break label275;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "web skin cache time out");
        }
        SkinEngine.init(paramContext, WEB_DRAWABLES, 1264, 2131165184, 2131168543, null);
        ThreadManager.getSubThreadHandler().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/web_config", "/skin/web_skin_cache"), 10000L);
        break label336;
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "No cache found");
        }
        SkinEngine.init(paramContext, WEB_DRAWABLES, 1264, 2131165184, 2131168543, null);
        ThreadManager.getSubThreadHandler().postDelayed(new InitSkin.CreateSkinEngineCacheTask("/skin/web_config", "/skin/web_skin_cache"), 10000L);
      }
      catch (Exception localException2) {}
      label275:
      if (!localFile2.exists()) {
        localFile2.delete();
      }
      if (!localFile1.exists()) {
        localFile1.delete();
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "web skin Cache load failed.", localException2);
      }
      SkinEngine.init(paramContext, WEB_DRAWABLES, 1264, 2131165184, 2131168543, null);
      label336:
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838958);
      SkinEngine.getInstances().addDrawableResource(2130839580);
      long l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837510);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("web skin init skin engine cost: ");
          localStringBuilder.append(l2 - l1);
          QLog.d("SkinEngine", 2, localStringBuilder.toString());
          return;
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
      return;
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
      try
      {
        paramContext.createNewFile();
        return;
      }
      catch (IOException paramContext) {}
    }
  }
  
  public static void startInitSkinEngine()
  {
    for (;;)
    {
      try
      {
        boolean bool = sInited;
        if (bool) {
          return;
        }
        String[] arrayOfString = BaseApplicationImpl.processName.split(":");
        String str = null;
        if (arrayOfString.length > 1) {
          str = arrayOfString[1];
        }
        i = 0;
        if ((str != null) && (!str.endsWith("map")) && (!str.equals("qzone")) && (!str.equals("picture")) && (!str.equals("pedit")) && (!str.equals("plugin")) && (!str.equals("demoji")) && (!str.equals("peak")) && (!str.equals("readinjoy")) && (!str.endsWith("nearby")) && (!str.equals("tool")) && (!str.equals("qqfav")))
        {
          if (str.equals("web"))
          {
            initSkinWeb(BaseApplicationImpl.sApplication);
            break label263;
          }
        }
        else
        {
          if ("tool".equals(str))
          {
            asynInitSkin();
            break label263;
          }
          initSkin(BaseApplicationImpl.sApplication);
          break label263;
        }
        if (i != 0)
        {
          if (QQTheme.isNowSimpleUI()) {
            SkinEngine.getInstances().setSkinTint(SimpleTintManager.instance());
          } else {
            SkinEngine.getInstances().setSkinTint(TintManager.a());
          }
          if (str != null) {
            SkinEngine.getInstances().setUpdateCallback(new InitSkin.1());
          }
        }
        sInited = true;
        return;
      }
      finally {}
      label263:
      int i = 1;
    }
  }
  
  public static void waitAsynInitSkin()
  {
    if ((sToolAsynInitDPC) && (!sToolProcessInitComplete))
    {
      if (QLog.isColorLevel()) {
        QLog.i("InitSkin", 2, "start waitAsynInitSkin");
      }
      synchronized (sToolInitLock)
      {
        boolean bool = sToolProcessInitComplete;
        if (!bool) {
          try
          {
            sToolInitLock.wait(sToolInitTimeout);
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
          ((StringBuilder)???).append(sToolProcessInitComplete);
          QLog.i("InitSkin", 2, ((StringBuilder)???).toString());
          return;
        }
      }
    }
  }
  
  protected boolean doStep()
  {
    startInitSkinEngine();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitSkin
 * JD-Core Version:    0.7.0.1
 */