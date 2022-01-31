package com.tencent.mobileqq.utils;

import alpo;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import aowf;
import ayvc;
import azfz;
import bdag;
import bdax;
import bday;
import bdcb;
import bdiv;
import bdje;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AVColorStateList;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import lnz;
import lux;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mwj;
import mww;

public class AudioHelper
{
  private static int jdField_a_of_type_Int;
  static long jdField_a_of_type_Long;
  static String jdField_a_of_type_JavaLangString;
  public static boolean a;
  public static final int[] a;
  private static bday[] jdField_a_of_type_ArrayOfBday;
  private static long jdField_b_of_type_Long;
  static String jdField_b_of_type_JavaLangString;
  public static boolean b;
  private static final int[] jdField_b_of_type_ArrayOfInt;
  public static boolean c;
  private static final int[] c;
  static boolean d;
  private static boolean e;
  private static boolean f;
  private static boolean g;
  
  static
  {
    boolean bool = false;
    jdField_b_of_type_ArrayOfInt = new int[] { 35, 36 };
    jdField_c_of_type_ArrayOfInt = new int[] { 26, 27 };
    jdField_a_of_type_ArrayOfInt = new int[35];
    int i = 0;
    while (i < 35)
    {
      jdField_a_of_type_ArrayOfInt[i] = -1000;
      i += 1;
    }
    jdField_a_of_type_JavaLangString = "actAVFunChatExpression";
    if (Build.VERSION.SDK_INT >= 17) {
      bool = true;
    }
    jdField_c_of_type_Boolean = bool;
  }
  
  public static int a(int paramInt)
  {
    if (!jdField_a_of_type_Boolean) {
      return -1;
    }
    if (jdField_a_of_type_ArrayOfInt[paramInt] == -1000)
    {
      if (jdField_b_of_type_Long == 0L)
      {
        QLog.w("AudioHelper", 1, "getDebugValue, uin is empty, [" + paramInt + "]");
        return -1;
      }
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("debugconfig_" + jdField_b_of_type_Long, 4);
      jdField_a_of_type_ArrayOfInt[paramInt] = localSharedPreferences.getInt("debugvalue" + paramInt, -1);
      QLog.w("AudioHelper", 1, "getDebugValue, [" + paramInt + "]=[" + jdField_a_of_type_ArrayOfInt[paramInt] + "], mUin[" + jdField_b_of_type_Long + "]");
    }
    return jdField_a_of_type_ArrayOfInt[paramInt];
  }
  
  public static long a()
  {
    if (w()) {
      return System.currentTimeMillis();
    }
    return ayvc.a() * 1000L;
  }
  
  /* Error */
  public static long a(Context paramContext, byte[] paramArrayOfByte, int paramInt, float paramFloat)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 118	com/tencent/mobileqq/utils/AudioHelper:e	Z
    //   6: ifne +27 -> 33
    //   9: getstatic 120	com/tencent/mobileqq/utils/AudioHelper:jdField_a_of_type_Int	I
    //   12: iconst_3
    //   13: if_icmpge +20 -> 33
    //   16: getstatic 120	com/tencent/mobileqq/utils/AudioHelper:jdField_a_of_type_Int	I
    //   19: iconst_1
    //   20: iadd
    //   21: putstatic 120	com/tencent/mobileqq/utils/AudioHelper:jdField_a_of_type_Int	I
    //   24: aload_0
    //   25: ldc 122
    //   27: invokestatic 128	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   30: putstatic 118	com/tencent/mobileqq/utils/AudioHelper:e	Z
    //   33: getstatic 118	com/tencent/mobileqq/utils/AudioHelper:e	Z
    //   36: ifeq +17 -> 53
    //   39: aload_1
    //   40: iload_2
    //   41: fload_3
    //   42: invokestatic 132	com/tencent/mobileqq/utils/AudioHelper:enlargeVolum	([BIF)J
    //   45: lstore 4
    //   47: ldc 2
    //   49: monitorexit
    //   50: lload 4
    //   52: lreturn
    //   53: ldc2_w 133
    //   56: lstore 4
    //   58: goto -11 -> 47
    //   61: astore_0
    //   62: ldc 2
    //   64: monitorexit
    //   65: aload_0
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramContext	Context
    //   0	67	1	paramArrayOfByte	byte[]
    //   0	67	2	paramInt	int
    //   0	67	3	paramFloat	float
    //   45	12	4	l	long
    // Exception table:
    //   from	to	target	type
    //   3	33	61	finally
    //   33	47	61	finally
  }
  
  public static long a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        long l = Long.parseLong(paramString);
        return l;
      }
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public static bday a()
  {
    if (g()) {
      return new bday(0, 0, true);
    }
    return new bday(3, 0, true);
  }
  
  private static bday a(int paramInt)
  {
    bday localbday;
    if (paramInt == 0) {
      localbday = a();
    }
    for (;;)
    {
      String str = "!@$#_" + paramInt + "_";
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext());
      localbday.jdField_a_of_type_Int = localSharedPreferences.getInt(str + "m", localbday.jdField_a_of_type_Int);
      localbday.b = localSharedPreferences.getInt(str + "s", localbday.b);
      localbday.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean(str + "so", localbday.jdField_a_of_type_Boolean);
      return a(paramInt, localbday);
      if (paramInt == 1)
      {
        localbday = b();
      }
      else if (paramInt == 2)
      {
        localbday = a();
        localbday.jdField_a_of_type_Boolean = false;
      }
      else if (paramInt == 3)
      {
        localbday = a();
        localbday.jdField_a_of_type_Boolean = false;
      }
      else
      {
        localbday = c();
        localbday.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  private static bday a(int paramInt, bday parambday)
  {
    parambday = new bday(parambday.b, parambday.jdField_a_of_type_Int, parambday.jdField_a_of_type_Boolean);
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.qq_audio_play_fix.name(), null);
    if (QLog.isColorLevel()) {
      QLog.d(AudioHelper.class.getSimpleName(), 2, "getDPCFixConfig | dpcConfig = " + (String)localObject);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() > 1)) {
      try
      {
        localObject = ((String)localObject).split("\\|");
        if (paramInt == 0)
        {
          if (!"-1".equals(localObject[0])) {
            parambday.jdField_a_of_type_Int = Integer.parseInt(localObject[0]);
          }
          if (!"-1".equals(localObject[1]))
          {
            parambday.b = Integer.parseInt(localObject[1]);
            return parambday;
          }
        }
        else if (paramInt == 1)
        {
          if (!"-1".equals(localObject[2])) {
            parambday.jdField_a_of_type_Int = Integer.parseInt(localObject[2]);
          }
          if (!"-1".equals(localObject[3]))
          {
            parambday.b = Integer.parseInt(localObject[3]);
            return parambday;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(AudioHelper.class.getSimpleName(), 2, "getDPCFixConfig error.", localException);
        }
      }
    }
    return parambday;
  }
  
  public static String a(Resources paramResources, int paramInt)
  {
    try
    {
      paramResources = paramResources.getResourceEntryName(paramInt);
      return "[" + paramInt + "][" + paramResources + "]";
    }
    catch (Exception paramResources)
    {
      for (;;)
      {
        paramResources = paramResources.getClass().getName();
      }
    }
  }
  
  public static String a(View paramView, int paramInt)
  {
    try
    {
      paramView = paramView.getResources().getResourceEntryName(paramInt);
      return "[" + paramInt + "][" + paramView + "]";
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView = paramView.getClass().getName();
      }
    }
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
    for (;;)
    {
      try
      {
        if (jdField_b_of_type_JavaLangString == null)
        {
          if ((paramAppInterface instanceof VideoAppInterface))
          {
            l = lnz.d();
            jdField_b_of_type_JavaLangString = "BaseInfo, APPID[" + AppSetting.a() + "], \nisPublicVersion[" + true + "], \nisGrayVersion[" + false + "], \nisDebugVersion[" + false + "], \nquaMainVersion[" + "2013 8.3.3" + "], \nversionCode[" + aowf.a(paramAppInterface.getApp()) + "], \nrevision[" + AppSetting.g() + "], \nisSupporImmersive[" + ImmersiveUtils.isSupporImmersive() + "], \nStatusBarHeight[" + ImmersiveUtils.getStatusBarHeight(paramAppInterface.getApp()) + "], \nhasSmartBar[" + mww.a() + "], \naboutSubVersionLog[" + AppSetting.b() + "], \ngetQUA[" + a(AppSetting.e()) + "], \nTYPE[" + Build.TYPE + "], \nTAGS[" + Build.TAGS + "], \nMANUFACTURER[" + Build.MANUFACTURER + "], \nPRODUCT[" + Build.PRODUCT + "], \nRELEASE[" + Build.VERSION.RELEASE + "], \nDISPLAY[" + Build.DISPLAY + "], \nCODENAME[" + Build.VERSION.CODENAME + "], \nINCREMENTAL[" + Build.VERSION.INCREMENTAL + "], \nBRAND[" + Build.BRAND + "], \nMODEL[" + Build.MODEL + "], \nCPU_ABI[" + Build.CPU_ABI + "], \nCPU_ABI2[" + Build.CPU_ABI2 + "], \nCPU[" + Build.HARDWARE + "], \nCPUModel[" + lnz.a() + "], \nisExistSDCard[" + bdag.a() + "], \nsdkVersion[" + Build.VERSION.SDK_INT + "], \ndevicesInfo[" + AppSetting.c + "], \nVendorId[" + lnz.h() + "], \nIsMarvell[" + lnz.g() + "], \nOpenGLVersion[" + lnz.g() + "], \nGLVersion[" + lux.a(paramAppInterface.getApp()) + "], \ncupReport[" + lnz.e() + "], \nFeature[" + lnz.g() + "], \nMaxCpuFreq[" + l + "], \nSystemTotalMemory[" + bdcb.d() + "], \nCpuNum[" + bdcb.b() + "], \nuid[" + paramAppInterface.getApp().getApplicationInfo().uid + "], \nPermission_PackageName[" + paramAppInterface.getApp().getPackageName() + "], \n";
          }
        }
        else
        {
          DisplayMetrics localDisplayMetrics = paramAppInterface.getApp().getResources().getDisplayMetrics();
          paramAppInterface = jdField_b_of_type_JavaLangString + "UIN[" + paramAppInterface.getAccount() + "], \ndisplayMetrics[" + localDisplayMetrics + "], \ndensity[" + localDisplayMetrics.density + "], \ndensityDpi[" + localDisplayMetrics.densityDpi + "], \nlogLevel[" + QLog.getUIN_REPORTLOG_LEVEL() + "], \nisDevelopLevel[" + QLog.isDevelopLevel() + "], \nisColorLevel[" + QLog.isColorLevel() + "], \nsProcessId[" + BaseApplicationImpl.sProcessId + "], \nprocessName[" + BaseApplicationImpl.processName + "], \nUIThread[" + ThreadManager.getUIHandler().getLooper().getThread().getId() + "], \nCurThread[" + Thread.currentThread().getId() + "], \nisTestEnvironment[" + paramInt + "], \ntid[" + Process.myTid() + "], \nmyPid[" + Process.myPid() + "], \nmyUid[" + Process.myUid() + "]";
          QLog.d("AudioHelper", 1, paramAppInterface);
          return paramAppInterface;
        }
      }
      catch (Exception paramAppInterface)
      {
        QLog.w("AudioHelper", 1, "printBaseInfo, Exception", paramAppInterface);
        return paramAppInterface.getMessage();
      }
      long l = bdcb.a();
    }
  }
  
  public static String a(Object paramObject)
  {
    if (d())
    {
      Object localObject;
      int j;
      String str;
      int i;
      if ((paramObject instanceof String[]))
      {
        localObject = (String[])paramObject;
        j = localObject.length;
        str = "";
        i = 0;
        for (;;)
        {
          paramObject = str;
          if (i >= j) {
            break;
          }
          paramObject = localObject[i];
          paramObject = str + paramObject;
          str = paramObject + "|";
          i += 1;
        }
      }
      if ((paramObject instanceof int[]))
      {
        localObject = (int[])paramObject;
        j = localObject.length;
        str = "";
        i = 0;
        for (;;)
        {
          paramObject = str;
          if (i >= j) {
            break;
          }
          int k = localObject[i];
          paramObject = str + k;
          str = paramObject + "|";
          i += 1;
        }
      }
      paramObject = "" + paramObject;
      return paramObject;
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
  
  public static void a(int paramInt, bday parambday)
  {
    String str = "!@$#_" + paramInt + "_";
    PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext()).edit().putInt(str + "m", parambday.jdField_a_of_type_Int).putInt(str + "s", parambday.b).putBoolean(str + "so", parambday.jdField_a_of_type_Boolean).commit();
  }
  
  public static void a(long paramLong)
  {
    if (jdField_b_of_type_Long != paramLong)
    {
      jdField_b_of_type_Long = paramLong;
      int i = 0;
      while (i < 35)
      {
        jdField_a_of_type_ArrayOfInt[i] = -1000;
        i += 1;
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    if (!jdField_a_of_type_Boolean) {
      jdField_a_of_type_Boolean = d();
    }
    if (a(2) == 1)
    {
      QLog.d("AudioHelper", 1, "setBeaconDebug begin");
      UserAction.setLogAble(true, true);
      if (paramContext != null) {
        UserAction.initUserAction(paramContext);
      }
      UserAction.setLogAble(true, true);
      QLog.d("AudioHelper", 1, "setBeaconDebug end");
    }
  }
  
  public static void a(Resources paramResources, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramTextView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AudioHelper", 2, "changButtonStyle button is null");
      }
    }
    do
    {
      return;
      if (paramInt1 != 0)
      {
        Drawable localDrawable = paramResources.getDrawable(paramInt1);
        mwj localmwj = mwj.a(paramResources, paramInt1, paramInt2);
        localmwj.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        paramTextView.setCompoundDrawables(null, localmwj, null, null);
      }
    } while (paramInt3 == 0);
    paramTextView.setTextColor(AVColorStateList.a(paramResources, paramInt3));
  }
  
  public static void a(Resources paramResources, TextView paramTextView, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      a(paramResources, paramTextView, paramInt, 2131165945, 2131165946);
      return;
    }
    a(paramResources, paramTextView, paramInt, 2131165908, 2131165909);
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    ThreadManager.getFileThreadHandler().post(new AudioHelper.2(paramAppInterface));
  }
  
  public static final void a(String paramString)
  {
    QLog.w("测试开关", 1, paramString);
  }
  
  public static void a(String paramString, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      a(paramString, paramIntent.getExtras(), false);
      return;
    }
    paramString = "MapValue[" + paramString + "]:\n";
    QLog.w("AudioHelper", 1, paramString + "intent为空");
  }
  
  public static void a(String paramString, Bundle paramBundle)
  {
    a(paramString, paramBundle, false);
  }
  
  public static void a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    if ((paramBoolean) || (QLog.isDevelopLevel()))
    {
      String str1 = "BundleValue[" + paramString + "]:\n";
      if (paramBundle != null) {
        paramString = str1;
      }
      try
      {
        localIterator = paramBundle.keySet().iterator();
        paramString = str1;
      }
      catch (Exception localException1)
      {
        Iterator localIterator;
        String str2;
        Object localObject3;
        Object localObject2;
        int i;
        label138:
        label192:
        paramBundle = paramString;
        paramString = localException1;
        if (!QLog.isDevelopLevel()) {
          return;
        }
        new StringBuilder().append(paramBundle).append("Exception").toString();
        QLog.w("AudioHelper", 1, "log", paramString);
        return;
      }
      try
      {
        if (!localIterator.hasNext()) {
          break label309;
        }
        str2 = (String)localIterator.next();
        localObject3 = paramBundle.get(str2);
        if ((localObject3 == null) || (!(localObject3 instanceof long[]))) {
          break label404;
        }
        localObject2 = (long[])localObject3;
        str1 = "" + localObject2.length;
        i = 0;
        if ((i >= localObject2.length) || (i >= 5)) {
          break label410;
        }
        str1 = str1 + "[" + localObject2[i] + "]";
        i += 1;
        break label138;
      }
      catch (Exception localException2)
      {
        paramBundle = paramString;
        paramString = localException2;
        break label356;
        Object localObject1 = null;
        break label192;
        break label192;
      }
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = "" + localObject3;
      }
      localObject2 = new StringBuilder().append(paramString).append("    [").append(str2).append("]=[").append((String)localObject2).append("], [");
      if (localObject3 == null) {}
      for (str1 = null;; str1 = localObject3.getClass().getSimpleName())
      {
        str1 = str1 + "]\n";
        paramString = str1;
        break;
      }
      label309:
      for (paramBundle = paramString;; paramBundle = str1 + "bundle为空")
      {
        paramString = paramBundle;
        QLog.w("AudioHelper", 1, paramBundle);
        return;
        paramString = str1;
      }
    }
    label356:
  }
  
  public static <T1, T2> void a(String paramString, Map<T1, T2> paramMap, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramBoolean) || (QLog.isDevelopLevel()))
    {
      paramString = "MapValue[" + paramString + "]:\n";
      if (paramMap != null) {
        localObject1 = paramString;
      }
    }
    try
    {
      Iterator localIterator = paramMap.keySet().iterator();
      Object localObject2 = paramString;
      localObject1 = paramString;
      if (localIterator.hasNext())
      {
        localObject1 = paramString;
        Object localObject3 = localIterator.next();
        localObject1 = paramString;
        localObject2 = paramMap.get(localObject3);
        localObject1 = paramString;
        String str = "" + localObject2;
        localObject1 = paramString;
        localObject3 = new StringBuilder().append(paramString).append("    [").append(localObject3).append("]=[").append(str).append("], [");
        if (localObject2 == null) {}
        for (localObject2 = null;; localObject2 = localObject2.getClass().getSimpleName())
        {
          localObject1 = paramString;
          paramString = (String)localObject2 + "]\n";
          break;
          localObject1 = paramString;
        }
        localObject1 = paramString;
        localObject2 = paramString + "bundle为空";
      }
      localObject1 = localObject2;
      QLog.w("AudioHelper", 1, (String)localObject2);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isDevelopLevel()) {}
      new StringBuilder().append((String)localObject1).append("Exception").toString();
      QLog.w("AudioHelper", 1, "log", paramString);
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      localHashMap.put("expID", paramString);
      localHashMap.put("action", str);
      UserAction.onUserAction(jdField_a_of_type_JavaLangString, true, -1L, -1L, localHashMap, true);
      if (a(2) == 1) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, String.format("expID[%s], action[%s]", new Object[] { paramString, str }));
      }
      return;
    }
  }
  
  public static boolean a()
  {
    String str2 = Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT;
    String str1 = bdiv.d(BaseApplicationImpl.getContext());
    Object localObject = str1;
    if (bdje.a(str1)) {
      localObject = "HUAWEI;HUAWEI NXT-AL10;24|HUAWEI;FRD-AL00;24|HUAWEI;EVA-AL00;24|HUAWEI;KNT-AL10;24|HUAWEI;EDI-AL10;24";
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioHelper", 2, "isHuaweiGreen greenList: " + (String)localObject + ", feature :" + str2);
    }
    localObject = ((String)localObject).split("\\|");
    if ((localObject != null) && (localObject.length > 0))
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        str1 = localObject[i];
        if ((str1 != null) && (str1.equals(str2)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AudioHelper", 2, "isHuaweiGreen true: " + str2);
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
    if (QLog.isColorLevel()) {
      QLog.d("AudioHelper", 2, "SDK_INT: " + Build.VERSION.SDK_INT + " Man: " + Build.MANUFACTURER);
    }
    if ((!v()) || (Build.VERSION.SDK_INT < 17)) {}
    for (;;)
    {
      return false;
      Object localObject = BaseApplicationImpl.getContext().getSystemService("appops");
      if ((localObject != null) && (localObject.getClass().getSimpleName().equals("AppOpsManager"))) {
        try
        {
          Method localMethod = localObject.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
          int i = jdField_c_of_type_ArrayOfInt[paramInt];
          if (Build.VERSION.SDK_INT < 19) {
            i = jdField_b_of_type_ArrayOfInt[paramInt];
          }
          ApplicationInfo localApplicationInfo = BaseApplicationImpl.getContext().getApplicationInfo();
          paramInt = ((Integer)localMethod.invoke(localObject, new Object[] { Integer.valueOf(i), Integer.valueOf(localApplicationInfo.uid), localApplicationInfo.packageName })).intValue();
          if (QLog.isColorLevel()) {
            QLog.d(AudioHelper.class.getSimpleName(), 2, "isForbidByRubbishXiaomi(), result = " + paramInt);
          }
          if (paramInt != 0) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (Exception localException) {}
      }
    }
    QLog.e(AudioHelper.class.getSimpleName(), 2, localException.toString());
    return false;
  }
  
  public static boolean a(int paramInt, Context paramContext)
  {
    if ((!u()) || (Build.VERSION.SDK_INT < 17)) {}
    for (;;)
    {
      return false;
      paramContext = paramContext.getSystemService("appops");
      if ((paramContext != null) && (paramContext.getClass().getSimpleName().equals("AppOpsManager"))) {
        try
        {
          Method localMethod = paramContext.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
          int i = jdField_c_of_type_ArrayOfInt[paramInt];
          if (Build.VERSION.SDK_INT < 19) {
            i = jdField_b_of_type_ArrayOfInt[paramInt];
          }
          ApplicationInfo localApplicationInfo = BaseApplicationImpl.getContext().getApplicationInfo();
          paramInt = ((Integer)localMethod.invoke(paramContext, new Object[] { Integer.valueOf(i), Integer.valueOf(localApplicationInfo.uid), localApplicationInfo.packageName })).intValue();
          if (QLog.isColorLevel()) {
            QLog.d(AudioHelper.class.getSimpleName(), 2, "isForbidByRubbishMeizu(), result = " + paramInt);
          }
          if (paramInt != 0) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (Exception paramContext) {}
      }
    }
    QLog.e(AudioHelper.class.getSimpleName(), 2, paramContext.toString());
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    if (paramContext.isBluetoothA2dpOn()) {
      return true;
    }
    if ((paramContext.isBluetoothScoOn()) || (AudioPlayer.a(paramContext))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(BaseApplicationImpl paramBaseApplicationImpl, long paramLong)
  {
    if (!jdField_a_of_type_Boolean) {
      jdField_a_of_type_Boolean = d();
    }
    a(paramLong);
    if (paramBaseApplicationImpl != null)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("tencent.video.q2v.debug");
      if (paramBaseApplicationImpl.registerReceiver(new bdax(paramBaseApplicationImpl), localIntentFilter) != null) {
        return true;
      }
    }
    return false;
  }
  
  public static bday[] a()
  {
    try
    {
      if (jdField_a_of_type_ArrayOfBday == null)
      {
        jdField_a_of_type_ArrayOfBday = new bday[5];
        jdField_a_of_type_ArrayOfBday[0] = a(0);
        jdField_a_of_type_ArrayOfBday[1] = a(1);
        jdField_a_of_type_ArrayOfBday[2] = a(2);
        jdField_a_of_type_ArrayOfBday[3] = a(3);
        jdField_a_of_type_ArrayOfBday[4] = a(4);
      }
      bday[] arrayOfbday = jdField_a_of_type_ArrayOfBday;
      return arrayOfbday;
    }
    finally {}
  }
  
  public static long b()
  {
    try
    {
      long l = jdField_a_of_type_Long;
      jdField_a_of_type_Long += 1L;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @TargetApi(11)
  public static bday b()
  {
    if (q()) {
      return new bday(0, 0, false);
    }
    if (h()) {
      return new bday(0, 0, false);
    }
    if (i()) {
      return new bday(0, 0, false);
    }
    if (j()) {
      return new bday(0, 0, false);
    }
    if (k()) {
      return new bday(0, 0, false);
    }
    if (m()) {
      return new bday(0, 0, false);
    }
    if ((b()) || (l())) {
      return new bday(0, 0, false);
    }
    if (n()) {
      return new bday(0, 2, false);
    }
    if (o()) {
      return new bday(0, 2, false);
    }
    if (p()) {
      return new bday(3, 3, false);
    }
    if (r()) {
      return new bday(0, 0, false);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      return new bday(0, 3, false);
    }
    return new bday(0, 2, false);
  }
  
  @TargetApi(17)
  public static void b(String paramString)
  {
    if ((jdField_c_of_type_Boolean) && (d))
    {
      long l = SystemClock.elapsedRealtimeNanos();
      QLog.w("AudioHelper", 1, "printTime[" + paramString + "], time[" + l + "]");
    }
  }
  
  public static boolean b()
  {
    return Build.MODEL.contains("Lenovo K900");
  }
  
  public static boolean b(int paramInt)
  {
    return a(paramInt, BaseApplicationImpl.getContext());
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext.isBluetoothScoOn()) || (AudioPlayer.a(paramContext));
  }
  
  @TargetApi(17)
  public static long c()
  {
    if (jdField_c_of_type_Boolean) {
      return SystemClock.elapsedRealtimeNanos();
    }
    return 0L;
  }
  
  public static bday c()
  {
    return new bday(0, 2, true);
  }
  
  public static void c(String paramString)
  {
    if (d())
    {
      QLog.w("AudioHelper", 1, "showDebugToast, text[" + paramString + "]");
      ThreadManager.getUIHandler().post(new AudioHelper.3(paramString));
    }
  }
  
  public static boolean c()
  {
    return (t()) || (s());
  }
  
  public static boolean d()
  {
    return false;
  }
  
  public static boolean e()
  {
    return QLog.isColorLevel();
  }
  
  @Deprecated
  public static native long enlargeVolum(byte[] paramArrayOfByte, int paramInt, float paramFloat);
  
  public static boolean f()
  {
    if (!azfz.m())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioHelper", 2, "isHuaweiGreenForSegment true");
      }
      return true;
    }
    if (g)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioHelper", 2, "isHuaweiGreenForSegmentLocal " + f);
      }
      return f;
    }
    g = true;
    String str1 = Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT;
    String[] arrayOfString = "HUAWEI;HUAWEI NXT-AL10;24|HUAWEI;BLN-AL40;24|HUAWEI;FRD-AL10;24|HUAWEI;HUAWEI NXT-DL00;24|HUAWEI;NEXT;23|vivo;vivo X5Pro D;21|asus;ASUS_Z00ADB;21|HUAWEI;LON-AL00;26|HUAWEI;COL-AL10;27|HUAWEI;STF_AL00;26".split("\\|");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str2 = arrayOfString[i];
        if ((str2 != null) && (str2.equals(str1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AudioHelper", 2, "isHuaweiGreenForSegment true: " + str1);
          }
          f = true;
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private static boolean g()
  {
    String str = Build.MODEL;
    int i;
    if (((Build.MANUFACTURER.equalsIgnoreCase("Samsung")) || (str.contains("MI 2")) || (str.contains("Nexus 4"))) && (Build.VERSION.SDK_INT >= 11))
    {
      i = 1;
      if (i == 0) {
        break label57;
      }
    }
    label57:
    while ((str.contains("SCH-I699")) && (Build.VERSION.SDK_INT == 10))
    {
      return true;
      i = 0;
      break;
    }
    return false;
  }
  
  private static boolean h()
  {
    return (Build.MODEL.contains("HUAWEI Y 200T")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean i()
  {
    return (Build.MODEL.contains("Lenovo A278t")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean j()
  {
    return (Build.MODEL.contains("ZTE-T U960s")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean k()
  {
    return Build.MODEL.contains("5910");
  }
  
  private static boolean l()
  {
    return Build.MODEL.contains("vivo X9");
  }
  
  private static boolean m()
  {
    return Build.MODEL.contains("V926");
  }
  
  private static boolean n()
  {
    return Build.MODEL.contains("ZTE N881E");
  }
  
  private static boolean o()
  {
    return Build.MODEL.contains("LNV-Lenovo S870e");
  }
  
  private static boolean p()
  {
    return Build.MODEL.contains("Coolpad 5891Q");
  }
  
  private static boolean q()
  {
    return (Build.MODEL.contains("ME860")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean r()
  {
    return Build.MODEL.contains("GT-S7500");
  }
  
  private static boolean s()
  {
    return Build.MODEL.contains("Lenovo A750");
  }
  
  private static boolean t()
  {
    String str = Build.MODEL;
    return (Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (str.contains("X907"));
  }
  
  private static boolean u()
  {
    return "Meizu".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  private static boolean v()
  {
    return "Xiaomi".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  private static boolean w()
  {
    if (a(15) == 1)
    {
      a(alpo.a(2131701163));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioHelper
 * JD-Core Version:    0.7.0.1
 */