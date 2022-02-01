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
    for (;;)
    {
      if (i < QQTheme.a.size())
      {
        if (TextUtils.equals("2920", a(i))) {
          jdField_c_of_type_Int = i;
        }
      }
      else
      {
        d = 0;
        e = 0;
        f = 0;
        jdField_a_of_type_Boolean = false;
        return;
      }
      i += 1;
    }
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
    boolean bool1 = false;
    boolean bool2;
    if (a())
    {
      bool2 = QQTheme.a();
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()) && (!jdField_c_of_type_Boolean)) {
        if (QQTheme.c(QQTheme.a())) {
          if (!QQTheme.a(QQTheme.a()))
          {
            ImmersiveUtils.setStatusTextColor(false, paramWindow);
            jdField_b_of_type_Boolean = true;
          }
        }
      }
    }
    do
    {
      return;
      ImmersiveUtils.setStatusTextColor(true, paramWindow);
      break;
      if (!bool2) {
        bool1 = true;
      }
      ImmersiveUtils.setStatusTextColor(bool1, paramWindow);
      break;
      if ((ImmersiveUtils.isSupporImmersive() == 0) || (paramImmersiveTitleBar2 == null) || (bool2)) {
        break;
      }
      paramImmersiveTitleBar2.setBackgroundColor(jdField_a_of_type_Int);
      break;
      if (true == jdField_b_of_type_Boolean)
      {
        if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()) && (!jdField_c_of_type_Boolean)) {
          ImmersiveUtils.setStatusTextColor(false, paramWindow);
        }
        for (;;)
        {
          jdField_b_of_type_Boolean = false;
          return;
          if ((ImmersiveUtils.isSupporImmersive() != 0) && (paramImmersiveTitleBar2 != null)) {
            paramImmersiveTitleBar2.setBackgroundColor(MobileQQ.getContext().getResources().getColor(2131167091));
          }
        }
      }
    } while (paramImmersiveTitleBar2 == null);
    ImmersiveUtils.adjustThemeStatusBar(paramWindow);
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
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()) && (!jdField_c_of_type_Boolean)) {
        if (paramBoolean == null) {
          if (!bool)
          {
            bool = true;
            if (!QQTheme.c(QQTheme.a())) {
              break label89;
            }
            if (QQTheme.a(QQTheme.a())) {
              break label80;
            }
            ImmersiveUtils.setStatusTextColor(false, paramWindow);
            label62:
            jdField_b_of_type_Boolean = true;
          }
        }
      }
    }
    label80:
    label89:
    do
    {
      return;
      bool = false;
      break;
      bool = paramBoolean.booleanValue();
      break;
      ImmersiveUtils.setStatusTextColor(true, paramWindow);
      break label62;
      ImmersiveUtils.setStatusTextColor(bool, paramWindow);
      break label62;
      if ((ImmersiveUtils.isSupporImmersive() == 0) || (paramSystemBarCompact == null) || (bool)) {
        break label62;
      }
      paramSystemBarCompact.setStatusBarColor(jdField_a_of_type_Int);
      break label62;
      if (true == jdField_b_of_type_Boolean)
      {
        if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()) && (!jdField_c_of_type_Boolean)) {
          if (paramBoolean == null)
          {
            bool = false;
            ImmersiveUtils.setStatusTextColor(bool, paramWindow);
          }
        }
        for (;;)
        {
          jdField_b_of_type_Boolean = false;
          return;
          bool = paramBoolean.booleanValue();
          break;
          if ((ImmersiveUtils.isSupporImmersive() != 0) && (paramSystemBarCompact != null)) {
            paramSystemBarCompact.setStatusBarColor(2131167091);
          }
        }
      }
    } while (paramSystemBarCompact == null);
    ImmersiveUtils.adjustThemeStatusBar(paramWindow);
  }
  
  public static void a(boolean paramBoolean, int paramInt, Window paramWindow)
  {
    if (a())
    {
      boolean bool = QQTheme.a();
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()) && (!bool))
      {
        if (!paramBoolean) {
          break label37;
        }
        ImmersiveUtils.setStatusTextColor(false, paramWindow);
      }
    }
    return;
    label37:
    ImmersiveUtils.setStatusTextColor(true, paramWindow);
  }
  
  public static final boolean a()
  {
    int j = 1;
    boolean bool = false;
    if (MobileQQ.sProcessId == 1) {
      i = 1;
    }
    while ((i != 0) && (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -2147483648)) {
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1)
      {
        return true;
        i = 0;
      }
      else
      {
        return false;
      }
    }
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if (localObject != null)
    {
      bool = QQTheme.a(((AppRuntime)localObject).getAccount()).getBoolean("key_simple_ui_switch", false);
      localObject = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
      if (!bool) {
        break label94;
      }
    }
    label94:
    for (int i = j;; i = 0)
    {
      ((AtomicInteger)localObject).compareAndSet(-2147483648, i);
      return bool;
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (((paramInt < 0) || (paramInt >= QQTheme.a.size())) && (paramInt != jdField_b_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUILogSimpleUIUtil", 2, "isValidSimplePref error bPref=" + paramInt);
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
    if (f == 1) {}
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
    if (d != 0) {
      return d;
    }
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "action_qzone_get_themeid", null);
    if ((localObject != null) && (((EIPCResult)localObject).data != null))
    {
      localObject = ((EIPCResult)localObject).data.getString("themeId");
      if (!"2971".equals(localObject)) {
        break label65;
      }
      d = -1;
    }
    for (;;)
    {
      return d;
      label65:
      if ("2921".equals(localObject)) {
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
  }
  
  static void d(int paramInt)
  {
    f = paramInt;
  }
  
  public static int e()
  {
    if (e != 0) {
      return e;
    }
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "action_qzone_get_themeid", null);
    if ((localObject != null) && (((EIPCResult)localObject).data != null))
    {
      localObject = ((EIPCResult)localObject).data.getString("themeId");
      if (!"2971".equals(localObject)) {
        break label69;
      }
      e = Color.parseColor("#03081A");
    }
    for (;;)
    {
      return e;
      label69:
      if ("2921".equals(localObject)) {
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
  }
  
  public static void e(int paramInt)
  {
    jdField_c_of_type_Int = paramInt;
  }
  
  public static final int f()
  {
    int i = 1;
    int j = 0;
    int k = 0;
    if (MobileQQ.sProcessId == 1)
    {
      if ((i == 0) || (jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == -2147483648) || (!a(jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()))) {
        break label54;
      }
      i = jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    }
    label54:
    do
    {
      return i;
      i = 0;
      break;
      localObject = MobileQQ.sMobileQQ.peekAppRuntime();
      i = k;
    } while (localObject == null);
    Object localObject = QQTheme.a(((AppRuntime)localObject).getAccount());
    k = ((SharedPreferences)localObject).getInt("key_simple_ui_pref_828", -1);
    i = k;
    if (!a(k))
    {
      k = ((SharedPreferences)localObject).getInt("key_simple_ui_pref_new", 0);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove("key_simple_ui_pref_new");
      ((SharedPreferences.Editor)localObject).commit();
      i = k;
      if (!a(k)) {
        i = j;
      }
    }
    for (;;)
    {
      jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(-2147483648, i);
      return i;
    }
  }
  
  public static int g()
  {
    int i = 1;
    if (MobileQQ.sProcessId == 1) {}
    while ((i != 0) && (jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -2147483648) && (a(jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())))
    {
      return jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      i = 0;
    }
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if (localObject != null)
    {
      localObject = QQTheme.a(((AppRuntime)localObject).getAccount());
      int j = ((SharedPreferences)localObject).getInt("key_simple_no_night_ui_828", -1);
      i = j;
      if (!a(j))
      {
        j = ((SharedPreferences)localObject).getInt("key_simple_no_night_ui_new", 0);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).remove("key_simple_no_night_ui_new");
        ((SharedPreferences.Editor)localObject).commit();
        if (a(j))
        {
          i = j;
          if (j != jdField_c_of_type_Int) {}
        }
        else
        {
          i = 0;
        }
      }
      jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(-2147483648, i);
      return i;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.SimpleUIUtil
 * JD-Core Version:    0.7.0.1
 */