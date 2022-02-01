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
  public static String b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static boolean g = false;
  private static AtomicInteger h = new AtomicInteger(-2147483648);
  private static AtomicInteger i = new AtomicInteger(-2147483648);
  private static AtomicInteger j = new AtomicInteger(-2147483648);
  private static boolean k = false;
  private static boolean l;
  private static int m;
  
  static
  {
    a = -2368549;
    l = false;
    b = "2971";
    c = -1;
    d = 0;
    int n = 0;
    while (n < QQTheme.themeIds.size())
    {
      if (TextUtils.equals("2920", a(n)))
      {
        d = n;
        break;
      }
      n += 1;
    }
    e = 0;
    f = 0;
    m = 0;
  }
  
  public static int a(String paramString)
  {
    if (QQTheme.themeIds.size() == 0) {
      return -1;
    }
    if (QQTheme.themeIds.contains(paramString)) {
      return QQTheme.themeIds.indexOf(paramString);
    }
    b = paramString;
    c = QQTheme.themeIds.size();
    return c;
  }
  
  public static String a(int paramInt)
  {
    if ((QQTheme.themeIds.size() > paramInt) && (paramInt >= 0)) {
      return (String)QQTheme.themeIds.get(paramInt);
    }
    if (c == paramInt) {
      return b;
    }
    return "2971";
  }
  
  public static List<String> a()
  {
    return QQTheme.themeIds;
  }
  
  public static void a(ImmersiveTitleBar2 paramImmersiveTitleBar2, Window paramWindow)
  {
    if (e())
    {
      boolean bool = QQTheme.isNowThemeIsNight();
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()) && (!l))
      {
        if (QQTheme.isThemeSimpleDayUI(QQTheme.getCurrentThemeId()))
        {
          if (!QQTheme.isSimpleColrThemeStateBarUseWhite(QQTheme.getCurrentThemeId())) {
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
        paramImmersiveTitleBar2.setBackgroundColor(a);
      }
      k = true;
      return;
    }
    if (true == k)
    {
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()) && (!l)) {
        ImmersiveUtils.setStatusTextColor(false, paramWindow);
      } else if ((ImmersiveUtils.isSupporImmersive() != 0) && (paramImmersiveTitleBar2 != null)) {
        paramImmersiveTitleBar2.setBackgroundColor(MobileQQ.getContext().getResources().getColor(2131168092));
      }
      k = false;
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
    if (e())
    {
      bool = QQTheme.isNowThemeIsNight();
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()) && (!l))
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
        if (QQTheme.isThemeSimpleDayUI(QQTheme.getCurrentThemeId()))
        {
          if (!QQTheme.isSimpleColrThemeStateBarUseWhite(QQTheme.getCurrentThemeId())) {
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
        paramSystemBarCompact.setStatusBarColor(a);
      }
      k = true;
      return;
    }
    if (true == k)
    {
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()) && (!l))
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
        paramSystemBarCompact.setStatusBarColor(2131168092);
      }
      k = false;
      return;
    }
    if (paramSystemBarCompact != null) {
      ImmersiveUtils.adjustThemeStatusBar(paramWindow);
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt, Window paramWindow)
  {
    if (e())
    {
      boolean bool = QQTheme.isNowThemeIsNight();
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
  
  static int b()
  {
    return i.get();
  }
  
  public static int b(String paramString)
  {
    int n = 0;
    while (n < QQTheme.themeIds.size())
    {
      if (TextUtils.equals(paramString, a(n))) {
        return n;
      }
      n += 1;
    }
    return -1;
  }
  
  static void b(int paramInt)
  {
    i.set(paramInt);
  }
  
  static int c()
  {
    return h.get();
  }
  
  static void c(int paramInt)
  {
    j.set(paramInt);
  }
  
  static int d()
  {
    return m;
  }
  
  static void d(int paramInt)
  {
    h.set(paramInt);
  }
  
  static void e(int paramInt)
  {
    m = paramInt;
  }
  
  public static final boolean e()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static int f()
  {
    int n = e;
    if (n != 0) {
      return n;
    }
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "action_qzone_get_themeid", null);
    if ((localObject != null) && (((EIPCResult)localObject).data != null))
    {
      localObject = ((EIPCResult)localObject).data.getString("themeId");
      if ("2971".equals(localObject)) {
        e = -1;
      } else if ("2921".equals(localObject)) {
        e = -657670;
      } else if ("3064".equals(localObject)) {
        e = -7084;
      } else if ("3063".equals(localObject)) {
        e = -15542596;
      } else if ("3066".equals(localObject)) {
        e = -34918;
      } else if ("3065".equals(localObject)) {
        e = -10145065;
      } else if ("3067".equals(localObject)) {
        e = -39054;
      } else if ("3491".equals(localObject)) {
        e = -15120003;
      }
    }
    return e;
  }
  
  public static void f(int paramInt)
  {
    d = paramInt;
  }
  
  public static int g()
  {
    int n = f;
    if (n != 0) {
      return n;
    }
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "action_qzone_get_themeid", null);
    if ((localObject != null) && (((EIPCResult)localObject).data != null))
    {
      localObject = ((EIPCResult)localObject).data.getString("themeId");
      if ("2971".equals(localObject)) {
        f = Color.parseColor("#03081A");
      } else if ("2921".equals(localObject)) {
        f = Color.parseColor("#03081A");
      } else if ("3064".equals(localObject)) {
        f = Color.parseColor("#03081A");
      } else if ("3063".equals(localObject)) {
        f = -1;
      } else if ("3066".equals(localObject)) {
        f = -1;
      } else if ("3065".equals(localObject)) {
        f = -1;
      } else if ("3067".equals(localObject)) {
        f = -1;
      } else if ("3491".equals(localObject)) {
        f = -1;
      }
    }
    return f;
  }
  
  public static boolean g(int paramInt)
  {
    if (((paramInt < 0) || (paramInt >= QQTheme.themeIds.size())) && (paramInt != c))
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
  
  public static boolean h()
  {
    return Color.parseColor("#03081A") == g();
  }
  
  public static final int i()
  {
    int i3 = MobileQQ.sProcessId;
    int n = 1;
    int i2 = 0;
    int i1 = 0;
    if (i3 != 1) {
      n = 0;
    }
    if ((n != 0) && (i.get() != -2147483648) && (g(i.get()))) {
      return i.get();
    }
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    n = i2;
    if (localObject != null)
    {
      localObject = QQTheme.getUinThemePreferences(((AppRuntime)localObject).getAccount());
      n = ((SharedPreferences)localObject).getInt("key_simple_ui_pref_828", -1);
      if (!g(n))
      {
        n = ((SharedPreferences)localObject).getInt("key_simple_ui_pref_new", 0);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).remove("key_simple_ui_pref_new");
        ((SharedPreferences.Editor)localObject).commit();
        if (!g(n)) {
          n = i1;
        } else {}
      }
      i.compareAndSet(-2147483648, n);
    }
    return n;
  }
  
  public static int j()
  {
    int i3 = MobileQQ.sProcessId;
    int n = 1;
    int i2 = 0;
    int i1 = 0;
    if (i3 != 1) {
      n = 0;
    }
    if ((n != 0) && (j.get() != -2147483648) && (g(j.get()))) {
      return j.get();
    }
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    n = i2;
    if (localObject != null)
    {
      localObject = QQTheme.getUinThemePreferences(((AppRuntime)localObject).getAccount());
      n = ((SharedPreferences)localObject).getInt("key_simple_no_night_ui_828", -1);
      if (!g(n))
      {
        i2 = ((SharedPreferences)localObject).getInt("key_simple_no_night_ui_new", 0);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).remove("key_simple_no_night_ui_new");
        ((SharedPreferences.Editor)localObject).commit();
        n = i1;
        if (g(i2)) {
          if (i2 == d) {
            n = i1;
          } else {
            n = i2;
          }
        }
      }
      j.compareAndSet(-2147483648, n);
    }
    return n;
  }
  
  public static void k()
  {
    h.set(-2147483648);
    i.set(-2147483648);
    j.set(-2147483648);
  }
  
  public static void l()
  {
    int n = m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.SimpleUIUtil
 * JD-Core Version:    0.7.0.1
 */