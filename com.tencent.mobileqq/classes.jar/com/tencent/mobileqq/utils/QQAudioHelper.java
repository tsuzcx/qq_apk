package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.utils.AVColorStateList;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.UITools;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerHelper.AudioPlayerParameter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AudioHelperUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class QQAudioHelper
{
  private static long jdField_a_of_type_Long = 0L;
  static String jdField_a_of_type_JavaLangString;
  public static boolean a = false;
  static final int[] jdField_a_of_type_ArrayOfInt = new int[39];
  static String b;
  public static boolean b = false;
  public static boolean c = false;
  static boolean d = false;
  private static boolean e = false;
  private static boolean f = false;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    int i = 0;
    while (i < 39)
    {
      jdField_a_of_type_ArrayOfInt[i] = -1000;
      i += 1;
    }
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_JavaLangString = "actAVFunChatExpression";
    jdField_b_of_type_Boolean = false;
    boolean bool;
    if (Build.VERSION.SDK_INT >= 17) {
      bool = true;
    } else {
      bool = false;
    }
    c = bool;
    d = false;
    jdField_b_of_type_JavaLangString = null;
  }
  
  public static int a(int paramInt)
  {
    if (!jdField_a_of_type_Boolean) {
      return -1;
    }
    if (jdField_a_of_type_ArrayOfInt[paramInt] == -1000)
    {
      if (jdField_a_of_type_Long == 0L)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getDebugValue, uin is empty, [");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append("]");
        QLog.w("AudioHelper", 1, ((StringBuilder)localObject1).toString());
        return -1;
      }
      Object localObject1 = BaseApplication.getContext();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("debugconfig_");
      ((StringBuilder)localObject2).append(jdField_a_of_type_Long);
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4);
      localObject2 = jdField_a_of_type_ArrayOfInt;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("debugvalue");
      localStringBuilder.append(paramInt);
      localObject2[paramInt] = ((SharedPreferences)localObject1).getInt(localStringBuilder.toString(), -1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getDebugValue, [");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("]=[");
      ((StringBuilder)localObject1).append(jdField_a_of_type_ArrayOfInt[paramInt]);
      ((StringBuilder)localObject1).append("], mUin[");
      ((StringBuilder)localObject1).append(jdField_a_of_type_Long);
      ((StringBuilder)localObject1).append("]");
      QLog.w("AudioHelper", 1, ((StringBuilder)localObject1).toString());
    }
    return jdField_a_of_type_ArrayOfInt[paramInt];
  }
  
  public static long a()
  {
    if (f()) {
      return System.currentTimeMillis();
    }
    return MessageCache.a() * 1000L;
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    return a(paramAppInterface, -1);
  }
  
  public static String a(AppInterface paramAppInterface, int paramInt)
  {
    if (paramAppInterface == null)
    {
      QLog.d("AudioHelper", 1, "BaseInfo, AppInterface is empty");
      return "BaseInfo, AppInterface is empty";
    }
    try
    {
      if (jdField_b_of_type_JavaLangString == null)
      {
        long l;
        if ((paramAppInterface instanceof VideoAppInterface)) {
          l = VcSystemInfo.getMaxCpuFreq();
        } else {
          l = DeviceInfoUtil.b();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("BaseInfo, APPID[");
        ((StringBuilder)localObject).append(AppSetting.a());
        ((StringBuilder)localObject).append("], \nisPublicVersion[");
        ((StringBuilder)localObject).append(true);
        ((StringBuilder)localObject).append("], \nisGrayVersion[");
        ((StringBuilder)localObject).append(false);
        ((StringBuilder)localObject).append("], \nisDebugVersion[");
        ((StringBuilder)localObject).append(false);
        ((StringBuilder)localObject).append("], \nquaMainVersion[");
        ((StringBuilder)localObject).append("2013 8.7.0");
        ((StringBuilder)localObject).append("], \nversionCode[");
        ((StringBuilder)localObject).append(ApkUtils.a(paramAppInterface.getApp()));
        ((StringBuilder)localObject).append("], \nrevision[");
        ((StringBuilder)localObject).append(AppSetting.g());
        ((StringBuilder)localObject).append("], \nisSupporImmersive[");
        ((StringBuilder)localObject).append(ImmersiveUtils.isSupporImmersive());
        ((StringBuilder)localObject).append("], \nStatusBarHeight[");
        ((StringBuilder)localObject).append(ImmersiveUtils.getStatusBarHeight(paramAppInterface.getApp()));
        ((StringBuilder)localObject).append("], \nhasSmartBar[");
        ((StringBuilder)localObject).append(UITools.a());
        ((StringBuilder)localObject).append("], \naboutSubVersionLog[");
        ((StringBuilder)localObject).append(AppSetting.b());
        ((StringBuilder)localObject).append("], \ngetQUA[");
        ((StringBuilder)localObject).append(a(AppSetting.e()));
        ((StringBuilder)localObject).append("], \nTYPE[");
        ((StringBuilder)localObject).append(Build.TYPE);
        ((StringBuilder)localObject).append("], \nTAGS[");
        ((StringBuilder)localObject).append(Build.TAGS);
        ((StringBuilder)localObject).append("], \nMANUFACTURER[");
        ((StringBuilder)localObject).append(Build.MANUFACTURER);
        ((StringBuilder)localObject).append("], \nPRODUCT[");
        ((StringBuilder)localObject).append(Build.PRODUCT);
        ((StringBuilder)localObject).append("], \nRELEASE[");
        ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
        ((StringBuilder)localObject).append("], \nDISPLAY[");
        ((StringBuilder)localObject).append(Build.DISPLAY);
        ((StringBuilder)localObject).append("], \nCODENAME[");
        ((StringBuilder)localObject).append(Build.VERSION.CODENAME);
        ((StringBuilder)localObject).append("], \nINCREMENTAL[");
        ((StringBuilder)localObject).append(Build.VERSION.INCREMENTAL);
        ((StringBuilder)localObject).append("], \nBRAND[");
        ((StringBuilder)localObject).append(Build.BRAND);
        ((StringBuilder)localObject).append("], \nMODEL[");
        ((StringBuilder)localObject).append(Build.MODEL);
        ((StringBuilder)localObject).append("], \nCPU_ABI[");
        ((StringBuilder)localObject).append(Build.CPU_ABI);
        ((StringBuilder)localObject).append("], \nCPU_ABI2[");
        ((StringBuilder)localObject).append(Build.CPU_ABI2);
        ((StringBuilder)localObject).append("], \nCPU[");
        ((StringBuilder)localObject).append(Build.HARDWARE);
        ((StringBuilder)localObject).append("], \nCPUModel[");
        ((StringBuilder)localObject).append(VcSystemInfo.getCpuModel());
        ((StringBuilder)localObject).append("], \nisExistSDCard[");
        ((StringBuilder)localObject).append(SystemUtil.a());
        ((StringBuilder)localObject).append("], \nsdkVersion[");
        ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
        ((StringBuilder)localObject).append("], \ndevicesInfo[");
        ((StringBuilder)localObject).append(AppSetting.c);
        ((StringBuilder)localObject).append("], \nVendorId[");
        ((StringBuilder)localObject).append(VcSystemInfo.getVendorId());
        ((StringBuilder)localObject).append("], \nIsMarvell[");
        ((StringBuilder)localObject).append(VcSystemInfo.getIsMarvell());
        ((StringBuilder)localObject).append("], \nOpenGLVersion[");
        ((StringBuilder)localObject).append(VcSystemInfo.getOpenGLVersion());
        ((StringBuilder)localObject).append("], \nGLVersion[");
        ((StringBuilder)localObject).append(Utils.a(paramAppInterface.getApp()));
        ((StringBuilder)localObject).append("], \ncupReport[");
        ((StringBuilder)localObject).append(VcSystemInfo.getCpuReport());
        ((StringBuilder)localObject).append("], \nFeature[");
        ((StringBuilder)localObject).append(VcSystemInfo.getFeature());
        ((StringBuilder)localObject).append("], \nMaxCpuFreq[");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append("], \nSystemTotalMemory[");
        ((StringBuilder)localObject).append(DeviceInfoUtil.a());
        ((StringBuilder)localObject).append("], \nCpuNum[");
        ((StringBuilder)localObject).append(DeviceInfoUtil.b());
        ((StringBuilder)localObject).append("], \nuid[");
        ((StringBuilder)localObject).append(paramAppInterface.getApp().getApplicationInfo().uid);
        ((StringBuilder)localObject).append("], \nPermission_PackageName[");
        ((StringBuilder)localObject).append(paramAppInterface.getApp().getPackageName());
        ((StringBuilder)localObject).append("], \n");
        jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      }
      Object localObject = paramAppInterface.getApp().getResources().getDisplayMetrics();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_b_of_type_JavaLangString);
      localStringBuilder.append("UIN[");
      localStringBuilder.append(paramAppInterface.getAccount());
      localStringBuilder.append("], \ndisplayMetrics[");
      localStringBuilder.append(localObject);
      localStringBuilder.append("], \ndensity[");
      localStringBuilder.append(((DisplayMetrics)localObject).density);
      localStringBuilder.append("], \ndensityDpi[");
      localStringBuilder.append(((DisplayMetrics)localObject).densityDpi);
      localStringBuilder.append("], \nlogLevel[");
      localStringBuilder.append(QLog.getUIN_REPORTLOG_LEVEL());
      localStringBuilder.append("], \nisDevelopLevel[");
      localStringBuilder.append(QLog.isDevelopLevel());
      localStringBuilder.append("], \nisColorLevel[");
      localStringBuilder.append(QLog.isColorLevel());
      localStringBuilder.append("], \nsProcessId[");
      localStringBuilder.append(BaseApplicationImpl.sProcessId);
      localStringBuilder.append("], \nprocessName[");
      localStringBuilder.append(BaseApplicationImpl.processName);
      localStringBuilder.append("], \nUIThread[");
      localStringBuilder.append(ThreadManager.getUIHandler().getLooper().getThread().getId());
      localStringBuilder.append("], \nCurThread[");
      localStringBuilder.append(Thread.currentThread().getId());
      localStringBuilder.append("], \nisTestEnvironment[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], \ntid[");
      localStringBuilder.append(Process.myTid());
      localStringBuilder.append("], \nmyPid[");
      localStringBuilder.append(Process.myPid());
      localStringBuilder.append("], \nmyUid[");
      localStringBuilder.append(Process.myUid());
      localStringBuilder.append("]");
      paramAppInterface = localStringBuilder.toString();
      QLog.d("AudioHelper", 1, paramAppInterface);
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.w("AudioHelper", 1, "printBaseInfo, Exception", paramAppInterface);
    }
    return paramAppInterface.getMessage();
  }
  
  public static String a(Object paramObject)
  {
    if (b())
    {
      boolean bool = paramObject instanceof String[];
      int j = 0;
      int i = 0;
      Object localObject1 = "";
      Object localObject2;
      if (bool)
      {
        paramObject = (String[])paramObject;
        j = paramObject.length;
        while (i < j)
        {
          localObject2 = paramObject[i];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append((String)localObject2);
          localObject1 = localStringBuilder.toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("|");
          localObject1 = ((StringBuilder)localObject2).toString();
          i += 1;
        }
        return localObject1;
      }
      if ((paramObject instanceof int[]))
      {
        paramObject = (int[])paramObject;
        int k = paramObject.length;
        i = j;
        while (i < k)
        {
          j = paramObject[i];
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(j);
          localObject1 = ((StringBuilder)localObject2).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("|");
          localObject1 = ((StringBuilder)localObject2).toString();
          i += 1;
        }
        return localObject1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(paramObject);
      return ((StringBuilder)localObject1).toString();
    }
    if (paramObject == null) {
      return "null.";
    }
    if ((paramObject instanceof String))
    {
      if (TextUtils.isEmpty((String)paramObject)) {
        return "*";
      }
      return "**";
    }
    return "***";
  }
  
  public static void a(int paramInt, AudioPlayerHelper.AudioPlayerParameter paramAudioPlayerParameter)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("!@$#_");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("_");
    localObject = ((StringBuilder)localObject).toString();
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("m");
    localEditor = localEditor.putInt(localStringBuilder.toString(), paramAudioPlayerParameter.jdField_a_of_type_Int);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("s");
    localEditor = localEditor.putInt(localStringBuilder.toString(), paramAudioPlayerParameter.b);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("so");
    localEditor.putBoolean(localStringBuilder.toString(), paramAudioPlayerParameter.jdField_a_of_type_Boolean).commit();
  }
  
  public static void a(long paramLong)
  {
    if (jdField_a_of_type_Long != paramLong)
    {
      jdField_a_of_type_Long = paramLong;
      int i = 0;
      while (i < 39)
      {
        jdField_a_of_type_ArrayOfInt[i] = -1000;
        i += 1;
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    if (!jdField_a_of_type_Boolean) {
      jdField_a_of_type_Boolean = b();
    }
    if (a(2) == 1)
    {
      QLog.d("AudioHelper", 1, "setBeaconDebug begin");
      UserAction.setLogAble(AppSetting.c() ^ true, true);
      if (paramContext != null) {
        UserAction.initUserAction(paramContext);
      }
      UserAction.setLogAble(AppSetting.c() ^ true, true);
      QLog.d("AudioHelper", 1, "setBeaconDebug end");
    }
  }
  
  public static void a(Resources paramResources, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramTextView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioHelper", 2, "changButtonStyle button is null");
      }
      return;
    }
    if (paramInt1 != 0)
    {
      Drawable localDrawable = paramResources.getDrawable(paramInt1);
      TintStateDrawable localTintStateDrawable = TintStateDrawable.a(paramResources, paramInt1, paramInt2);
      localTintStateDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(null, localTintStateDrawable, null, null);
    }
    if (paramInt3 != 0) {
      paramTextView.setTextColor(AVColorStateList.a(paramResources, paramInt3));
    }
  }
  
  public static void a(Resources paramResources, TextView paramTextView, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      a(paramResources, paramTextView, paramInt, 2131166043, 2131166044);
      return;
    }
    a(paramResources, paramTextView, paramInt, 2131166006, 2131166007);
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    ThreadManager.getFileThreadHandler().post(new QQAudioHelper.2(paramAppInterface));
  }
  
  public static final void a(String paramString)
  {
    QLog.w("测试开关", 1, paramString);
  }
  
  public static void a(String paramString, Bundle paramBundle)
  {
    a(paramString, paramBundle, false);
  }
  
  public static void a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramBoolean) || (QLog.isDevelopLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("BundleValue[");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("]:\n");
      paramString = ((StringBuilder)localObject1).toString();
      if (paramBundle != null) {
        localObject1 = paramString;
      }
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        Object localObject2 = paramString;
        localObject1 = paramString;
        if (localIterator.hasNext())
        {
          localObject1 = paramString;
          String str = (String)localIterator.next();
          localObject1 = paramString;
          Object localObject5 = paramBundle.get(str);
          Object localObject4 = null;
          if (localObject5 == null) {
            break label581;
          }
          localObject1 = paramString;
          if (!(localObject5 instanceof long[])) {
            break label581;
          }
          localObject1 = paramString;
          long[] arrayOfLong = (long[])localObject5;
          localObject1 = paramString;
          localObject2 = new StringBuilder();
          localObject1 = paramString;
          ((StringBuilder)localObject2).append("");
          localObject1 = paramString;
          ((StringBuilder)localObject2).append(arrayOfLong.length);
          localObject1 = paramString;
          localObject2 = ((StringBuilder)localObject2).toString();
          int i = 0;
          localObject3 = localObject2;
          localObject1 = paramString;
          if (i < arrayOfLong.length)
          {
            localObject3 = localObject2;
            if (i < 5)
            {
              localObject1 = paramString;
              localObject3 = new StringBuilder();
              localObject1 = paramString;
              ((StringBuilder)localObject3).append((String)localObject2);
              localObject1 = paramString;
              ((StringBuilder)localObject3).append("[");
              localObject1 = paramString;
              ((StringBuilder)localObject3).append(arrayOfLong[i]);
              localObject1 = paramString;
              ((StringBuilder)localObject3).append("]");
              localObject1 = paramString;
              localObject2 = ((StringBuilder)localObject3).toString();
              i += 1;
              continue;
            }
          }
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = paramString;
            localObject2 = new StringBuilder();
            localObject1 = paramString;
            ((StringBuilder)localObject2).append("");
            localObject1 = paramString;
            ((StringBuilder)localObject2).append(localObject5);
            localObject1 = paramString;
            localObject2 = ((StringBuilder)localObject2).toString();
          }
          localObject1 = paramString;
          localObject3 = new StringBuilder();
          localObject1 = paramString;
          ((StringBuilder)localObject3).append(paramString);
          localObject1 = paramString;
          ((StringBuilder)localObject3).append("    [");
          localObject1 = paramString;
          ((StringBuilder)localObject3).append(str);
          localObject1 = paramString;
          ((StringBuilder)localObject3).append("]=[");
          localObject1 = paramString;
          ((StringBuilder)localObject3).append((String)localObject2);
          localObject1 = paramString;
          ((StringBuilder)localObject3).append("], [");
          if (localObject5 == null)
          {
            localObject2 = localObject4;
          }
          else
          {
            localObject1 = paramString;
            localObject2 = localObject5.getClass().getSimpleName();
          }
          localObject1 = paramString;
          ((StringBuilder)localObject3).append((String)localObject2);
          localObject1 = paramString;
          ((StringBuilder)localObject3).append("]\n");
          localObject1 = paramString;
          paramString = ((StringBuilder)localObject3).toString();
          continue;
          localObject1 = paramString;
          paramBundle = new StringBuilder();
          localObject1 = paramString;
          paramBundle.append(paramString);
          localObject1 = paramString;
          paramBundle.append("bundle为空");
          localObject1 = paramString;
          localObject2 = paramBundle.toString();
        }
        localObject1 = localObject2;
        QLog.w("AudioHelper", 1, (String)localObject2);
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isDevelopLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append((String)localObject1);
          paramBundle.append("Exception");
          paramBundle.toString();
          QLog.w("AudioHelper", 1, "log", paramString);
        }
      }
      return;
      label581:
      Object localObject3 = null;
    }
  }
  
  public static boolean a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Build.MANUFACTURER);
    ((StringBuilder)localObject1).append(";");
    ((StringBuilder)localObject1).append(Build.MODEL);
    ((StringBuilder)localObject1).append(";");
    ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
    String str = ((StringBuilder)localObject1).toString();
    Object localObject2 = SharedPreUtils.d(BaseApplicationImpl.getContext());
    localObject1 = localObject2;
    if (StringUtil.a((String)localObject2)) {
      localObject1 = "HUAWEI;HUAWEI NXT-AL10;24|HUAWEI;FRD-AL00;24|HUAWEI;EVA-AL00;24|HUAWEI;KNT-AL10;24|HUAWEI;EDI-AL10;24";
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isHuaweiGreen greenList: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", feature :");
      ((StringBuilder)localObject2).append(str);
      QLog.d("AudioHelper", 2, ((StringBuilder)localObject2).toString());
    }
    localObject1 = ((String)localObject1).split("\\|");
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        if ((localObject2 != null) && (((String)localObject2).equals(str)))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("isHuaweiGreen true: ");
            ((StringBuilder)localObject1).append(str);
            QLog.d("AudioHelper", 2, ((StringBuilder)localObject1).toString());
          }
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("SDK_INT: ");
      ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
      ((StringBuilder)localObject1).append(" Man: ");
      ((StringBuilder)localObject1).append(Build.MANUFACTURER);
      QLog.d("AudioHelper", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool2 = e();
    boolean bool1 = false;
    if (bool2)
    {
      if (Build.VERSION.SDK_INT < 17) {
        return false;
      }
      localObject1 = BaseApplicationImpl.getContext().getSystemService("appops");
      if ((localObject1 != null) && (localObject1.getClass().getSimpleName().equals("AppOpsManager"))) {
        try
        {
          Object localObject2 = localObject1.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
          int i = AudioUtil.b[paramInt];
          if (Build.VERSION.SDK_INT < 19) {
            i = AudioUtil.jdField_a_of_type_ArrayOfInt[paramInt];
          }
          ApplicationInfo localApplicationInfo = BaseApplicationImpl.getContext().getApplicationInfo();
          paramInt = ((Integer)((Method)localObject2).invoke(localObject1, new Object[] { Integer.valueOf(i), Integer.valueOf(localApplicationInfo.uid), localApplicationInfo.packageName })).intValue();
          if (QLog.isColorLevel())
          {
            localObject1 = QQAudioHelper.class.getSimpleName();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("isForbidByRubbishXiaomi(), result = ");
            ((StringBuilder)localObject2).append(paramInt);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          }
          if (paramInt != 0) {
            bool1 = true;
          }
          return bool1;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e(QQAudioHelper.class.getSimpleName(), 2, localException.toString());
          }
        }
      }
    }
    return false;
  }
  
  public static boolean a(BaseApplicationImpl paramBaseApplicationImpl, long paramLong)
  {
    if (!jdField_a_of_type_Boolean) {
      jdField_a_of_type_Boolean = b();
    }
    a(paramLong);
    if (paramBaseApplicationImpl != null)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("tencent.video.q2v.debug");
      if (paramBaseApplicationImpl.registerReceiver(new QQAudioHelper.1(paramBaseApplicationImpl), localIntentFilter) != null) {
        return true;
      }
    }
    return false;
  }
  
  public static long b()
  {
    try
    {
      long l = AudioHelperUtil.a();
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @TargetApi(17)
  public static void b(String paramString)
  {
    if ((c) && (d))
    {
      long l = SystemClock.elapsedRealtimeNanos();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("printTime[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], time[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w("AudioHelper", 1, localStringBuilder.toString());
    }
  }
  
  public static boolean b()
  {
    return AudioHelperUtil.b();
  }
  
  @TargetApi(17)
  public static long c()
  {
    if (c) {
      return SystemClock.elapsedRealtimeNanos();
    }
    return 0L;
  }
  
  public static void c(String paramString)
  {
    if (b())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showDebugToast, text[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.w("AudioHelper", 1, localStringBuilder.toString());
      ThreadManager.getUIHandler().post(new QQAudioHelper.3(paramString));
    }
  }
  
  public static boolean c()
  {
    return AudioHelperUtil.a();
  }
  
  public static boolean d()
  {
    if (!((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isSegmentMediaCodecEncodeSwtichOpen())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioHelper", 2, "isHuaweiGreenForSegment true");
      }
      return true;
    }
    if (f)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isHuaweiGreenForSegmentLocal ");
        ((StringBuilder)localObject1).append(e);
        QLog.d("AudioHelper", 2, ((StringBuilder)localObject1).toString());
      }
      return e;
    }
    f = true;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Build.MANUFACTURER);
    ((StringBuilder)localObject1).append(";");
    ((StringBuilder)localObject1).append(Build.MODEL);
    ((StringBuilder)localObject1).append(";");
    ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = "HUAWEI;HUAWEI NXT-AL10;24|HUAWEI;BLN-AL40;24|HUAWEI;FRD-AL10;24|HUAWEI;HUAWEI NXT-DL00;24|HUAWEI;NEXT;23|vivo;vivo X5Pro D;21|asus;ASUS_Z00ADB;21|HUAWEI;LON-AL00;26|HUAWEI;COL-AL10;27|HUAWEI;STF_AL00;26".split("\\|");
    if ((localObject2 != null) && (localObject2.length > 0))
    {
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject3 = localObject2[i];
        if ((localObject3 != null) && (localObject3.equals(localObject1)))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("isHuaweiGreenForSegment true: ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("AudioHelper", 2, ((StringBuilder)localObject2).toString());
          }
          e = true;
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private static boolean e()
  {
    return "Xiaomi".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  private static boolean f()
  {
    if (a(15) == 1)
    {
      a(HardCodeUtil.a(2131701014));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQAudioHelper
 * JD-Core Version:    0.7.0.1
 */