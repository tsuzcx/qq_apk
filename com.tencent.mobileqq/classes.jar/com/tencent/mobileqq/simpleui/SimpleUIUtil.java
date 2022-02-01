package com.tencent.mobileqq.simpleui;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SimpleUIUtil
{
  public static int a;
  public static String a;
  private static AtomicInteger a;
  public static boolean a;
  public static int b;
  private static AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static boolean jdField_b_of_type_Boolean;
  public static int c;
  private static AtomicInteger jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static boolean jdField_c_of_type_Boolean;
  public static int d;
  public static int e;
  private static int f;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-2147483648);
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-2147483648);
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-2147483648);
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_Int = -2368549;
    jdField_c_of_type_Boolean = false;
    jdField_a_of_type_JavaLangString = "2921";
    jdField_b_of_type_Int = -1;
    jdField_c_of_type_Int = 0;
    int i = 0;
    while (i < QQTheme.a.size())
    {
      if (TextUtils.equals("2920", a(i)))
      {
        jdField_c_of_type_Int = i;
        break;
      }
      i += 1;
    }
    d = 0;
    e = 0;
    f = 0;
    jdField_a_of_type_Boolean = false;
  }
  
  static int a()
  {
    return jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public static int a(String paramString)
  {
    if (QQTheme.a.size() == 0) {
      return -1;
    }
    if (QQTheme.a.contains(paramString)) {
      return QQTheme.a.indexOf(paramString);
    }
    jdField_a_of_type_JavaLangString = paramString;
    jdField_b_of_type_Int = QQTheme.a.size();
    return jdField_b_of_type_Int;
  }
  
  public static String a(int paramInt)
  {
    if ((QQTheme.a.size() > paramInt) && (paramInt >= 0)) {
      return (String)QQTheme.a.get(paramInt);
    }
    if (jdField_b_of_type_Int == paramInt) {
      return jdField_a_of_type_JavaLangString;
    }
    return "2921";
  }
  
  public static List<String> a()
  {
    return QQTheme.a;
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-2147483648);
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-2147483648);
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-2147483648);
  }
  
  static void a(int paramInt)
  {
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
  }
  
  public static void a(ImmersiveTitleBar2 paramImmersiveTitleBar2, Window paramWindow)
  {
    if (a())
    {
      boolean bool = QQTheme.a();
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()) && (!jdField_c_of_type_Boolean))
      {
        if (QQTheme.d(QQTheme.a()))
        {
          if (!QQTheme.b(QQTheme.a())) {
            ImmersiveUtils.setStatusTextColor(false, paramWindow);
          } else {
            ImmersiveUtils.setStatusTextColor(true, paramWindow);
          }
        }
        else {
          ImmersiveUtils.setStatusTextColor(bool ^ true, paramWindow);
        }
      }
      else if ((ImmersiveUtils.isSupporImmersive() != 0) && (paramImmersiveTitleBar2 != null) && (!bool)) {
        paramImmersiveTitleBar2.setBackgroundColor(jdField_a_of_type_Int);
      }
      jdField_b_of_type_Boolean = true;
      return;
    }
    if (true == jdField_b_of_type_Boolean)
    {
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()) && (!jdField_c_of_type_Boolean)) {
        ImmersiveUtils.setStatusTextColor(false, paramWindow);
      } else if ((ImmersiveUtils.isSupporImmersive() != 0) && (paramImmersiveTitleBar2 != null)) {
        paramImmersiveTitleBar2.setBackgroundColor(MobileQQ.getContext().getResources().getColor(2131167114));
      }
      jdField_b_of_type_Boolean = false;
      return;
    }
    if (paramImmersiveTitleBar2 != null) {
      ImmersiveUtils.adjustThemeStatusBar(paramWindow);
    }
  }
  
  public static void a(SystemBarCompact paramSystemBarCompact, Window paramWindow)
  {
    a(paramSystemBarCompact, paramWindow, null);
  }
  
  public static void a(SystemBarCompact paramSystemBarCompact, Window paramWindow, Boolean paramBoolean)
  {
    boolean bool;
    if (a())
    {
      bool = QQTheme.a();
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()) && (!jdField_c_of_type_Boolean))
      {
        if (paramBoolean == null)
        {
          if (!bool) {
            bool = true;
          } else {
            bool = false;
          }
        }
        else {
          bool = paramBoolean.booleanValue();
        }
        if (QQTheme.d(QQTheme.a()))
        {
          if (!QQTheme.b(QQTheme.a())) {
            ImmersiveUtils.setStatusTextColor(false, paramWindow);
          } else {
            ImmersiveUtils.setStatusTextColor(true, paramWindow);
          }
        }
        else {
          ImmersiveUtils.setStatusTextColor(bool, paramWindow);
        }
      }
      else if ((ImmersiveUtils.isSupporImmersive() != 0) && (paramSystemBarCompact != null) && (!bool))
      {
        paramSystemBarCompact.setStatusBarColor(jdField_a_of_type_Int);
      }
      jdField_b_of_type_Boolean = true;
      return;
    }
    if (true == jdField_b_of_type_Boolean)
    {
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()) && (!jdField_c_of_type_Boolean))
      {
        if (paramBoolean == null) {
          bool = false;
        } else {
          bool = paramBoolean.booleanValue();
        }
        ImmersiveUtils.setStatusTextColor(bool, paramWindow);
      }
      else if ((ImmersiveUtils.isSupporImmersive() != 0) && (paramSystemBarCompact != null))
      {
        paramSystemBarCompact.setStatusBarColor(2131167114);
      }
      jdField_b_of_type_Boolean = false;
      return;
    }
    if (paramSystemBarCompact != null) {
      ImmersiveUtils.adjustThemeStatusBar(paramWindow);
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt, Window paramWindow)
  {
    if (a())
    {
      boolean bool = QQTheme.a();
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()) && (!bool))
      {
        if (paramBoolean)
        {
          ImmersiveUtils.setStatusTextColor(false, paramWindow);
          return;
        }
        ImmersiveUtils.setStatusTextColor(true, paramWindow);
      }
    }
  }
  
  public static final boolean a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean a(int paramInt)
  {
    if (((paramInt < 0) || (paramInt >= QQTheme.a.size())) && (paramInt != jdField_b_of_type_Int))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isValidSimplePref error bPref=");
        localStringBuilder.append(paramInt);
        QLog.d("SimpleUILogSimpleUIUtil", 2, localStringBuilder.toString());
      }
      return false;
    }
    return true;
  }
  
  static int b()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public static int b(String paramString)
  {
    int i = 0;
    while (i < QQTheme.a.size())
    {
      if (TextUtils.equals(paramString, a(i))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static void b()
  {
    int i = f;
  }
  
  static void b(int paramInt)
  {
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
  }
  
  public static boolean b()
  {
    return Color.parseColor("#03081A") == e();
  }
  
  static int c()
  {
    return f;
  }
  
  static void c(int paramInt)
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
  }
  
  public static int d()
  {
    int i = d;
    if (i != 0) {
      return i;
    }
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "action_qzone_get_themeid", null);
    if ((localObject != null) && (((EIPCResult)localObject).data != null))
    {
      localObject = ((EIPCResult)localObject).data.getString("themeId");
      if ("2971".equals(localObject)) {
        d = -1;
      } else if ("2921".equals(localObject)) {
        d = -657670;
      } else if ("3064".equals(localObject)) {
        d = -7084;
      } else if ("3063".equals(localObject)) {
        d = -15542596;
      } else if ("3066".equals(localObject)) {
        d = -34918;
      } else if ("3065".equals(localObject)) {
        d = -10145065;
      } else if ("3067".equals(localObject)) {
        d = -39054;
      } else if ("3491".equals(localObject)) {
        d = -15120003;
      }
    }
    return d;
  }
  
  static void d(int paramInt)
  {
    f = paramInt;
  }
  
  public static int e()
  {
    int i = e;
    if (i != 0) {
      return i;
    }
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "action_qzone_get_themeid", null);
    if ((localObject != null) && (((EIPCResult)localObject).data != null))
    {
      localObject = ((EIPCResult)localObject).data.getString("themeId");
      if ("2971".equals(localObject)) {
        e = Color.parseColor("#03081A");
      } else if ("2921".equals(localObject)) {
        e = Color.parseColor("#03081A");
      } else if ("3064".equals(localObject)) {
        e = Color.parseColor("#03081A");
      } else if ("3063".equals(localObject)) {
        e = -1;
      } else if ("3066".equals(localObject)) {
        e = -1;
      } else if ("3065".equals(localObject)) {
        e = -1;
      } else if ("3067".equals(localObject)) {
        e = -1;
      } else if ("3491".equals(localObject)) {
        e = -1;
      }
    }
    return e;
  }
  
  public static void e(int paramInt)
  {
    jdField_c_of_type_Int = paramInt;
  }
  
  public static final int f()
  {
    int m = MobileQQ.sProcessId;
    int i = 1;
    int k = 0;
    int j = 0;
    if (m != 1) {
      i = 0;
    }
    if ((i != 0) && (jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -2147483648) && (a(jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()))) {
      return jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    }
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    i = k;
    if (localObject != null)
    {
      localObject = QQTheme.a(((AppRuntime)localObject).getAccount());
      i = ((SharedPreferences)localObject).getInt("key_simple_ui_pref_828", -1);
      if (!a(i))
      {
        i = ((SharedPreferences)localObject).getInt("key_simple_ui_pref_new", 0);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).remove("key_simple_ui_pref_new");
        ((SharedPreferences.Editor)localObject).commit();
        if (!a(i)) {
          i = j;
        } else {}
      }
      jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(-2147483648, i);
    }
    return i;
  }
  
  public static int g()
  {
    int m = MobileQQ.sProcessId;
    int i = 1;
    int k = 0;
    int j = 0;
    if (m != 1) {
      i = 0;
    }
    if ((i != 0) && (jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -2147483648) && (a(jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()))) {
      return jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    }
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    i = k;
    if (localObject != null)
    {
      localObject = QQTheme.a(((AppRuntime)localObject).getAccount());
      i = ((SharedPreferences)localObject).getInt("key_simple_no_night_ui_828", -1);
      if (!a(i))
      {
        k = ((SharedPreferences)localObject).getInt("key_simple_no_night_ui_new", 0);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).remove("key_simple_no_night_ui_new");
        ((SharedPreferences.Editor)localObject).commit();
        i = j;
        if (a(k)) {
          if (k == jdField_c_of_type_Int) {
            i = j;
          } else {
            i = k;
          }
        }
      }
      jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(-2147483648, i);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.SimpleUIUtil
 * JD-Core Version:    0.7.0.1
 */