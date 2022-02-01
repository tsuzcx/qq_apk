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
  static final int[] a = new int[39];
  public static boolean b = false;
  static String c;
  public static boolean d = false;
  public static boolean e = false;
  static boolean f = false;
  static String g = null;
  private static boolean h = false;
  private static boolean i = false;
  private static long j;
  
  static
  {
    int k = 0;
    while (k < 39)
    {
      a[k] = -1000;
      k += 1;
    }
    j = 0L;
    c = "actAVFunChatExpression";
    d = false;
    boolean bool;
    if (Build.VERSION.SDK_INT >= 17) {
      bool = true;
    } else {
      bool = false;
    }
    e = bool;
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
      if (g == null)
      {
        long l;
        if ((paramAppInterface instanceof VideoAppInterface)) {
          l = VcSystemInfo.getMaxCpuFreq();
        } else {
          l = DeviceInfoUtil.k();
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("BaseInfo, APPID[");
        localStringBuilder.append(AppSetting.d());
        localStringBuilder.append("], \nisPublicVersion[");
        localStringBuilder.append(true);
        localStringBuilder.append("], \nisGrayVersion[");
        localStringBuilder.append(false);
        localStringBuilder.append("], \nisDebugVersion[");
        localStringBuilder.append(false);
        localStringBuilder.append("], \nquaMainVersion[");
        localStringBuilder.append("2013 8.8.17");
        localStringBuilder.append("], \nversionCode[");
        localStringBuilder.append(ApkUtils.a(paramAppInterface.getApp()));
        localStringBuilder.append("], \nrevision[");
        localStringBuilder.append(AppSetting.i());
        localStringBuilder.append("], \nisSupporImmersive[");
        localStringBuilder.append(ImmersiveUtils.isSupporImmersive());
        localStringBuilder.append("], \nStatusBarHeight[");
        localStringBuilder.append(ImmersiveUtils.getStatusBarHeight(paramAppInterface.getApp()));
        localStringBuilder.append("], \nhasSmartBar[");
        localStringBuilder.append(UITools.a());
        localStringBuilder.append("], \naboutSubVersionLog[");
        localStringBuilder.append(AppSetting.c());
        localStringBuilder.append("], \ngetQUA[");
        localStringBuilder.append(a(AppSetting.g()));
        localStringBuilder.append("], \nTYPE[");
        localStringBuilder.append(Build.TYPE);
        localStringBuilder.append("], \nTAGS[");
        localStringBuilder.append(Build.TAGS);
        localStringBuilder.append("], \nMANUFACTURER[");
        localStringBuilder.append(Build.MANUFACTURER);
        localStringBuilder.append("], \nPRODUCT[");
        localStringBuilder.append(Build.PRODUCT);
        localStringBuilder.append("], \nRELEASE[");
        localStringBuilder.append(Build.VERSION.RELEASE);
        localStringBuilder.append("], \nDISPLAY[");
        localStringBuilder.append(Build.DISPLAY);
        localStringBuilder.append("], \nCODENAME[");
        localStringBuilder.append(Build.VERSION.CODENAME);
        localStringBuilder.append("], \nINCREMENTAL[");
        localStringBuilder.append(Build.VERSION.INCREMENTAL);
        localStringBuilder.append("], \nBRAND[");
        localStringBuilder.append(Build.BRAND);
        localStringBuilder.append("], \nMODEL[");
        localStringBuilder.append(Build.MODEL);
        localStringBuilder.append("], \nCPU_ABI[");
        localStringBuilder.append(Build.CPU_ABI);
        localStringBuilder.append("], \nCPU_ABI2[");
        localStringBuilder.append(Build.CPU_ABI2);
        localStringBuilder.append("], \nCPU[");
        localStringBuilder.append(Build.HARDWARE);
        localStringBuilder.append("], \nCPUModel[");
        localStringBuilder.append(VcSystemInfo.getCpuModel());
        localStringBuilder.append("], \nisExistSDCard[");
        localStringBuilder.append(SystemUtil.a());
        localStringBuilder.append("], \nsdkVersion[");
        localStringBuilder.append(Build.VERSION.SDK_INT);
        localStringBuilder.append("], \ndevicesInfo[");
        localStringBuilder.append(AppSetting.u);
        localStringBuilder.append("], \nVendorId[");
        localStringBuilder.append(VcSystemInfo.getVendorId());
        localStringBuilder.append("], \nIsMarvell[");
        localStringBuilder.append(VcSystemInfo.getIsMarvell());
        localStringBuilder.append("], \nOpenGLVersion[");
        localStringBuilder.append(VcSystemInfo.getOpenGLVersion());
        localStringBuilder.append("], \nGLVersion[");
        localStringBuilder.append(Utils.a(paramAppInterface.getApp()));
        localStringBuilder.append("], \ncupReport[");
        localStringBuilder.append(VcSystemInfo.getCpuReport());
        localStringBuilder.append("], \nFeature[");
        localStringBuilder.append(VcSystemInfo.getFeature());
        localStringBuilder.append("], \nMaxCpuFreq[");
        localStringBuilder.append(l);
        localStringBuilder.append("], \nSystemTotalMemory[");
        localStringBuilder.append(DeviceInfoUtil.a());
        localStringBuilder.append("], \nCpuNum[");
        localStringBuilder.append(DeviceInfoUtil.h());
        localStringBuilder.append("], \nuid[");
        localStringBuilder.append(paramAppInterface.getApp().getApplicationInfo().uid);
        localStringBuilder.append("], \nPermission_PackageName[");
        localStringBuilder.append(paramAppInterface.getApp().getPackageName());
        localStringBuilder.append("], \n");
        g = localStringBuilder.toString();
      }
      paramAppInterface = paramAppInterface.getApp().getResources().getDisplayMetrics();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(g);
      localStringBuilder.append("], \ndisplayMetrics[");
      localStringBuilder.append(paramAppInterface);
      localStringBuilder.append("], \ndensity[");
      localStringBuilder.append(paramAppInterface.density);
      localStringBuilder.append("], \ndensityDpi[");
      localStringBuilder.append(paramAppInterface.densityDpi);
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
      int m = 0;
      int k = 0;
      Object localObject1 = "";
      Object localObject2;
      if (bool)
      {
        paramObject = (String[])paramObject;
        m = paramObject.length;
        while (k < m)
        {
          localObject2 = paramObject[k];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append((String)localObject2);
          localObject1 = localStringBuilder.toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("|");
          localObject1 = ((StringBuilder)localObject2).toString();
          k += 1;
        }
        return localObject1;
      }
      if ((paramObject instanceof int[]))
      {
        paramObject = (int[])paramObject;
        int n = paramObject.length;
        k = m;
        while (k < n)
        {
          m = paramObject[k];
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(m);
          localObject1 = ((StringBuilder)localObject2).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("|");
          localObject1 = ((StringBuilder)localObject2).toString();
          k += 1;
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
    localEditor = localEditor.putInt(localStringBuilder.toString(), paramAudioPlayerParameter.a);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("s");
    localEditor = localEditor.putInt(localStringBuilder.toString(), paramAudioPlayerParameter.b);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("so");
    localEditor.putBoolean(localStringBuilder.toString(), paramAudioPlayerParameter.c).commit();
  }
  
  public static void a(long paramLong)
  {
    if (j != paramLong)
    {
      j = paramLong;
      int k = 0;
      while (k < 39)
      {
        a[k] = -1000;
        k += 1;
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    if (!b) {
      b = b();
    }
    if (b(2) == 1)
    {
      QLog.d("AudioHelper", 1, "setBeaconDebug begin");
      UserAction.setLogAble(AppSetting.k() ^ true, true);
      if (paramContext != null) {
        UserAction.initUserAction(paramContext);
      }
      UserAction.setLogAble(AppSetting.k() ^ true, true);
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
      a(paramResources, paramTextView, paramInt, 2131166770, 2131166771);
      return;
    }
    a(paramResources, paramTextView, paramInt, 2131166728, 2131166729);
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
            break label583;
          }
          localObject1 = paramString;
          if (!(localObject5 instanceof long[])) {
            break label583;
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
          int k = 0;
          localObject3 = localObject2;
          localObject1 = paramString;
          if (k < arrayOfLong.length)
          {
            localObject3 = localObject2;
            if (k < 5)
            {
              localObject1 = paramString;
              localObject3 = new StringBuilder();
              localObject1 = paramString;
              ((StringBuilder)localObject3).append((String)localObject2);
              localObject1 = paramString;
              ((StringBuilder)localObject3).append("[");
              localObject1 = paramString;
              ((StringBuilder)localObject3).append(arrayOfLong[k]);
              localObject1 = paramString;
              ((StringBuilder)localObject3).append("]");
              localObject1 = paramString;
              localObject2 = ((StringBuilder)localObject3).toString();
              k += 1;
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
      label583:
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
    Object localObject2 = SharedPreUtils.k(BaseApplicationImpl.getContext());
    localObject1 = localObject2;
    if (StringUtil.isEmpty((String)localObject2)) {
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
      int m = localObject1.length;
      int k = 0;
      while (k < m)
      {
        localObject2 = localObject1[k];
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
        k += 1;
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
    boolean bool2 = h();
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
          int k = AudioUtil.b[paramInt];
          if (Build.VERSION.SDK_INT < 19) {
            k = AudioUtil.a[paramInt];
          }
          ApplicationInfo localApplicationInfo = BaseApplicationImpl.getContext().getApplicationInfo();
          paramInt = ((Integer)((Method)localObject2).invoke(localObject1, new Object[] { Integer.valueOf(k), Integer.valueOf(localApplicationInfo.uid), localApplicationInfo.packageName })).intValue();
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
    if (!b) {
      b = b();
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
  
  public static int b(int paramInt)
  {
    if (!b) {
      return -1;
    }
    if (a[paramInt] == -1000)
    {
      if (j == 0L)
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
      ((StringBuilder)localObject2).append(j);
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4);
      localObject2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("debugvalue");
      localStringBuilder.append(paramInt);
      localObject2[paramInt] = ((SharedPreferences)localObject1).getInt(localStringBuilder.toString(), -1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getDebugValue, [");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("]=[");
      ((StringBuilder)localObject1).append(a[paramInt]);
      ((StringBuilder)localObject1).append("]");
      QLog.w("AudioHelper", 1, ((StringBuilder)localObject1).toString());
    }
    return a[paramInt];
  }
  
  public static String b(AppInterface paramAppInterface)
  {
    return a(paramAppInterface, -1);
  }
  
  @TargetApi(17)
  public static void b(String paramString)
  {
    if ((e) && (f))
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
    return AudioHelperUtil.c();
  }
  
  public static long c()
  {
    if (i()) {
      return System.currentTimeMillis();
    }
    return MessageCache.c() * 1000L;
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
  
  public static long d()
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
  public static long e()
  {
    if (e) {
      return SystemClock.elapsedRealtimeNanos();
    }
    return 0L;
  }
  
  public static boolean f()
  {
    return AudioHelperUtil.b();
  }
  
  public static boolean g()
  {
    if (!((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isSegmentMediaCodecEncodeSwtichOpen())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioHelper", 2, "isHuaweiGreenForSegment true");
      }
      return true;
    }
    if (i)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isHuaweiGreenForSegmentLocal ");
        ((StringBuilder)localObject1).append(h);
        QLog.d("AudioHelper", 2, ((StringBuilder)localObject1).toString());
      }
      return h;
    }
    i = true;
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
      int m = localObject2.length;
      int k = 0;
      while (k < m)
      {
        Object localObject3 = localObject2[k];
        if ((localObject3 != null) && (localObject3.equals(localObject1)))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("isHuaweiGreenForSegment true: ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("AudioHelper", 2, ((StringBuilder)localObject2).toString());
          }
          h = true;
          return true;
        }
        k += 1;
      }
    }
    return false;
  }
  
  private static boolean h()
  {
    return "Xiaomi".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  private static boolean i()
  {
    if (b(15) == 1)
    {
      a(HardCodeUtil.a(2131899035));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQAudioHelper
 * JD-Core Version:    0.7.0.1
 */