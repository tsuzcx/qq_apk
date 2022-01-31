package com.tencent.mobileqq.utils;

import ajng;
import android.annotation.TargetApi;
import android.content.Context;
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
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;

public class AudioHelper
{
  private static int jdField_a_of_type_Int;
  static long jdField_a_of_type_Long;
  static String jdField_a_of_type_JavaLangString = "actAVFunChatExpression";
  public static boolean a;
  public static final int[] a;
  private static AudioHelper.AudioPlayerParameter[] jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
  public static boolean b;
  private static final int[] b = { 35, 36 };
  private static boolean jdField_c_of_type_Boolean;
  private static final int[] jdField_c_of_type_ArrayOfInt = { 26, 27 };
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[9];
    int i = 0;
    while (i < 9)
    {
      jdField_a_of_type_ArrayOfInt[i] = -1000;
      i += 1;
    }
  }
  
  public static int a(int paramInt)
  {
    if (!jdField_a_of_type_Boolean) {
      return -1;
    }
    if (jdField_a_of_type_ArrayOfInt[paramInt] == -1000)
    {
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("debugconfig", 0);
      jdField_a_of_type_ArrayOfInt[paramInt] = localSharedPreferences.getInt("debugvalue" + paramInt, -1);
      QLog.w("AudioHelper", 1, "getDebugValue, [" + paramInt + "]=[" + jdField_a_of_type_ArrayOfInt[paramInt] + "]");
    }
    return jdField_a_of_type_ArrayOfInt[paramInt];
  }
  
  public static long a()
  {
    long l = jdField_a_of_type_Long;
    jdField_a_of_type_Long += 1L;
    return l;
  }
  
  /* Error */
  public static long a(Context paramContext, byte[] paramArrayOfByte, int paramInt, float paramFloat)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 86	com/tencent/mobileqq/utils/AudioHelper:jdField_c_of_type_Boolean	Z
    //   6: ifne +27 -> 33
    //   9: getstatic 88	com/tencent/mobileqq/utils/AudioHelper:jdField_a_of_type_Int	I
    //   12: iconst_3
    //   13: if_icmpge +20 -> 33
    //   16: getstatic 88	com/tencent/mobileqq/utils/AudioHelper:jdField_a_of_type_Int	I
    //   19: iconst_1
    //   20: iadd
    //   21: putstatic 88	com/tencent/mobileqq/utils/AudioHelper:jdField_a_of_type_Int	I
    //   24: aload_0
    //   25: ldc 90
    //   27: invokestatic 96	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   30: putstatic 86	com/tencent/mobileqq/utils/AudioHelper:jdField_c_of_type_Boolean	Z
    //   33: getstatic 86	com/tencent/mobileqq/utils/AudioHelper:jdField_c_of_type_Boolean	Z
    //   36: ifeq +17 -> 53
    //   39: aload_1
    //   40: iload_2
    //   41: fload_3
    //   42: invokestatic 100	com/tencent/mobileqq/utils/AudioHelper:enlargeVolum	([BIF)J
    //   45: lstore 4
    //   47: ldc 2
    //   49: monitorexit
    //   50: lload 4
    //   52: lreturn
    //   53: ldc2_w 101
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
  
  public static AudioHelper.AudioPlayerParameter a()
  {
    if (g()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, true);
    }
    return new AudioHelper.AudioPlayerParameter(3, 0, true);
  }
  
  private static AudioHelper.AudioPlayerParameter a(int paramInt)
  {
    AudioHelper.AudioPlayerParameter localAudioPlayerParameter;
    if (paramInt == 0) {
      localAudioPlayerParameter = a();
    }
    for (;;)
    {
      String str = "!@$#_" + paramInt + "_";
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext());
      localAudioPlayerParameter.jdField_a_of_type_Int = localSharedPreferences.getInt(str + "m", localAudioPlayerParameter.jdField_a_of_type_Int);
      localAudioPlayerParameter.b = localSharedPreferences.getInt(str + "s", localAudioPlayerParameter.b);
      localAudioPlayerParameter.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean(str + "so", localAudioPlayerParameter.jdField_a_of_type_Boolean);
      return a(paramInt, localAudioPlayerParameter);
      if (paramInt == 1)
      {
        localAudioPlayerParameter = b();
      }
      else if (paramInt == 2)
      {
        localAudioPlayerParameter = a();
        localAudioPlayerParameter.jdField_a_of_type_Boolean = false;
      }
      else if (paramInt == 3)
      {
        localAudioPlayerParameter = a();
        localAudioPlayerParameter.jdField_a_of_type_Boolean = false;
      }
      else
      {
        localAudioPlayerParameter = c();
        localAudioPlayerParameter.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  private static AudioHelper.AudioPlayerParameter a(int paramInt, AudioHelper.AudioPlayerParameter paramAudioPlayerParameter)
  {
    paramAudioPlayerParameter = new AudioHelper.AudioPlayerParameter(paramAudioPlayerParameter.b, paramAudioPlayerParameter.jdField_a_of_type_Int, paramAudioPlayerParameter.jdField_a_of_type_Boolean);
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
            paramAudioPlayerParameter.jdField_a_of_type_Int = Integer.parseInt(localObject[0]);
          }
          if (!"-1".equals(localObject[1]))
          {
            paramAudioPlayerParameter.b = Integer.parseInt(localObject[1]);
            return paramAudioPlayerParameter;
          }
        }
        else if (paramInt == 1)
        {
          if (!"-1".equals(localObject[2])) {
            paramAudioPlayerParameter.jdField_a_of_type_Int = Integer.parseInt(localObject[2]);
          }
          if (!"-1".equals(localObject[3]))
          {
            paramAudioPlayerParameter.b = Integer.parseInt(localObject[3]);
            return paramAudioPlayerParameter;
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
    return paramAudioPlayerParameter;
  }
  
  public static String a(Object paramObject)
  {
    if (d()) {
      return "" + paramObject;
    }
    if (paramObject == null) {
      return "null.";
    }
    return "***";
  }
  
  public static void a(int paramInt, AudioHelper.AudioPlayerParameter paramAudioPlayerParameter)
  {
    String str = "!@$#_" + paramInt + "_";
    PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext()).edit().putInt(str + "m", paramAudioPlayerParameter.jdField_a_of_type_Int).putInt(str + "s", paramAudioPlayerParameter.b).putBoolean(str + "so", paramAudioPlayerParameter.jdField_a_of_type_Boolean).commit();
  }
  
  public static void a(Context paramContext)
  {
    if (!jdField_a_of_type_Boolean) {
      jdField_a_of_type_Boolean = d();
    }
    if (a(2) == 1)
    {
      UserAction.setLogAble(true, true);
      UserAction.initUserAction(paramContext);
      UserAction.setLogAble(true, true);
      QLog.d("AudioHelper", 1, "setBeaconDebug");
    }
  }
  
  private static void a(Resources paramResources, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
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
    paramTextView.setTextColor(paramResources.getColorStateList(paramInt3));
  }
  
  public static void a(Resources paramResources, TextView paramTextView, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      a(paramResources, paramTextView, paramInt, 2131494061, 2131494062);
      return;
    }
    a(paramResources, paramTextView, paramInt, 2131494053, 2131494054);
  }
  
  public static void a(ImageButton paramImageButton, int paramInt1, int paramInt2)
  {
    if (paramImageButton == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AudioHelper", 2, "changButtonStyle button is null");
      }
    }
    while (paramInt1 == 0) {
      return;
    }
    Object localObject = paramImageButton.getResources();
    Drawable localDrawable = ((Resources)localObject).getDrawable(paramInt1);
    localObject = TintStateDrawable.a((Resources)localObject, paramInt1, paramInt2);
    ((Drawable)localObject).setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    paramImageButton.setImageDrawable((Drawable)localObject);
  }
  
  public static void a(ImageButton paramImageButton, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      a(paramImageButton, paramInt, 2131494061);
      return;
    }
    a(paramImageButton, paramInt, 2131494053);
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
    String str;
    Object localObject3;
    Object localObject2;
    if ((paramBoolean) || (QLog.isDevelopLevel()))
    {
      paramString = "BundleValue[" + paramString + "]:\n";
      if (paramBundle != null)
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        localObject1 = paramString;
        if (!localIterator.hasNext()) {
          break label318;
        }
        str = (String)localIterator.next();
        localObject3 = paramBundle.get(str);
        if ((localObject3 == null) || (!(localObject3 instanceof long[]))) {
          break label327;
        }
        localObject2 = (long[])localObject3;
        localObject1 = "" + localObject2.length;
        int i = 0;
        while ((i < localObject2.length) && (i < 5))
        {
          localObject1 = (String)localObject1 + "[" + localObject2[i] + "]";
          i += 1;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "" + localObject3;
      }
      localObject1 = new StringBuilder().append(paramString).append("    [").append(str).append("]=[").append((String)localObject2).append("], [");
      if (localObject3 == null) {}
      for (paramString = null;; paramString = localObject3.getClass().getSimpleName())
      {
        paramString = paramString + "]\n";
        break;
      }
      localObject1 = paramString + "bundle为空";
      label318:
      QLog.w("AudioHelper", 1, (String)localObject1);
      return;
      label327:
      localObject1 = null;
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
    String str1 = SharedPreUtils.d(BaseApplicationImpl.getContext());
    Object localObject = str1;
    if (StringUtil.a(str1)) {
      localObject = "HUAWEI;HUAWEI NXT-AL10;24|HUAWEI;FRD-AL00;24|HUAWEI;EVA-AL00;24|HUAWEI;KNT-AL10;24|HUAWEI;EDI-AL10;24";
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioHelper", 2, "isHuaweiGreen greenList: " + (String)localObject);
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
            i = b[paramInt];
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
            i = b[paramInt];
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
    jdField_a_of_type_Boolean = d();
    if (!jdField_a_of_type_Boolean) {
      if ((paramLong != 88884098L) && ((paramLong < 1002000551L) || (paramLong > 1002000555L))) {
        break label78;
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("tencent.video.q2v.debug");
      if (paramBaseApplicationImpl.registerReceiver(new ajng(paramBaseApplicationImpl), localIntentFilter) == null) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    long l = paramQQAppInterface.getLongAccountUin();
    return (l == 88884098L) || ((l >= 1002000551L) && (l <= 1002000555L));
  }
  
  public static AudioHelper.AudioPlayerParameter[] a()
  {
    try
    {
      if (jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter == null)
      {
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter = new AudioHelper.AudioPlayerParameter[5];
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[0] = a(0);
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[1] = a(1);
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[2] = a(2);
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[3] = a(3);
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[4] = a(4);
      }
      AudioHelper.AudioPlayerParameter[] arrayOfAudioPlayerParameter = jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
      return arrayOfAudioPlayerParameter;
    }
    finally {}
  }
  
  @TargetApi(17)
  public static long b()
  {
    long l2 = 0L;
    long l1 = l2;
    if (Build.VERSION.SDK_INT >= 17)
    {
      l1 = l2;
      if (QLog.isDevelopLevel()) {
        l1 = SystemClock.elapsedRealtimeNanos();
      }
    }
    return l1;
  }
  
  @TargetApi(11)
  public static AudioHelper.AudioPlayerParameter b()
  {
    if (q()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (h()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (i()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (j()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (k()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (m()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if ((b()) || (l())) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (n()) {
      return new AudioHelper.AudioPlayerParameter(0, 2, false);
    }
    if (o()) {
      return new AudioHelper.AudioPlayerParameter(0, 2, false);
    }
    if (p()) {
      return new AudioHelper.AudioPlayerParameter(3, 3, false);
    }
    if (r()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      return new AudioHelper.AudioPlayerParameter(0, 3, false);
    }
    return new AudioHelper.AudioPlayerParameter(0, 2, false);
  }
  
  public static void b(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 17)
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
  
  public static AudioHelper.AudioPlayerParameter c()
  {
    return new AudioHelper.AudioPlayerParameter(0, 2, true);
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
    String str1 = Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT;
    String[] arrayOfString = "HUAWEI;DUK-AL20;24|HUAWEI;Nexus 6P;24|HUAWEI;PRA-AL00X;24|HUAWEI;WAS-AL00;24|HUAWEI;STF-AL00;24|HUAWEI;VKY-AL00;24".split("\\|");
    int i;
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      i = 0;
      if (i < j)
      {
        str2 = arrayOfString[i];
        if ((str2 != null) && (str2.equals(str1))) {
          if (QLog.isColorLevel()) {
            QLog.d("AudioHelper", 2, "isHuaweiGreenForSegment in huawei whitelist: " + str1);
          }
        }
      }
    }
    while ((!Build.MANUFACTURER.equals("HUAWEI")) || (Build.VERSION.SDK_INT != 24))
    {
      String str2;
      return false;
      i += 1;
      break;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioHelper", 2, "isHuaweiGreenForSegment is huawei rubbish: " + str1);
    }
    return true;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioHelper
 * JD-Core Version:    0.7.0.1
 */