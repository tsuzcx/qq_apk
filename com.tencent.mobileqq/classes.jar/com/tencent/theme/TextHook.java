package com.tencent.theme;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Process;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.theme.font.IFontHook;
import com.tencent.theme.font.MiuiFontHook;
import com.tencent.theme.font.OppoFontHook;
import com.tencent.theme.utils.BrandUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TextHook
{
  private static String[] a = { "", "qzone" };
  private static TextHook b = new TextHook();
  private static String c = "";
  private static Boolean f = null;
  private Typeface d;
  private Typeface e = Typeface.SANS_SERIF;
  private IFontHook g;
  private boolean h = false;
  public HashMap<String, Typeface> mTypefaceMap = new HashMap();
  
  private void a(Typeface paramTypeface)
  {
    this.d = paramTypeface;
    try
    {
      b();
      if (this.g != null) {
        this.g.hookFont();
      }
      replaceSystemDefaultFont(paramTypeface);
      b(paramTypeface);
      Field localField = Typeface.class.getDeclaredField("sSystemFontMap");
      localField.setAccessible(true);
      HashMap localHashMap = new HashMap((Map)localField.get(null));
      localHashMap.put("sans-serif", paramTypeface);
      localField.set(null, localHashMap);
      return;
    }
    catch (Exception paramTypeface)
    {
      paramTypeface.printStackTrace();
    }
  }
  
  private void a(String paramString, Object paramObject)
  {
    try
    {
      paramString = Typeface.class.getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramString.set(null, paramObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b()
  {
    if (!this.h)
    {
      if (!BrandUtil.isMiui()) {
        break label30;
      }
      this.g = new MiuiFontHook();
    }
    for (;;)
    {
      this.h = true;
      return;
      label30:
      if (BrandUtil.isOppo()) {
        this.g = new OppoFontHook();
      }
    }
  }
  
  private void b(Typeface paramTypeface)
  {
    try
    {
      Object localObject = Typeface.class.getDeclaredField("sDefaults");
      ((Field)localObject).setAccessible(true);
      localObject = (Typeface[])((Field)localObject).get(null);
      localObject[0] = paramTypeface;
      localObject[1] = paramTypeface;
      return;
    }
    catch (Exception paramTypeface)
    {
      paramTypeface.printStackTrace();
    }
  }
  
  public static String getFontPath(Context paramContext)
  {
    return paramContext.getSharedPreferences("theme", 4).getString("theme_font_root", null);
  }
  
  public static TextHook getInstance()
  {
    return b;
  }
  
  public static String getProcessName(Context paramContext)
  {
    int i = Process.myPid();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = null;
    Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    paramContext = localRunningAppProcessInfo;
    if (localIterator.hasNext())
    {
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (localRunningAppProcessInfo.pid != i) {
        break label63;
      }
      paramContext = localRunningAppProcessInfo.processName;
    }
    label63:
    for (;;)
    {
      break;
      return paramContext;
    }
  }
  
  public static int getTypefaceStyle(Typeface paramTypeface)
  {
    if (paramTypeface != null) {
      return paramTypeface.getStyle();
    }
    return 0;
  }
  
  public static boolean isSupportProcess(Context paramContext)
  {
    if (f != null) {
      return f.booleanValue();
    }
    paramContext = getProcessName(paramContext);
    if (paramContext == null) {
      return false;
    }
    String[] arrayOfString = paramContext.split(":");
    paramContext = "";
    if (arrayOfString.length > 1) {
      paramContext = arrayOfString[1];
    }
    arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramContext.equals(arrayOfString[i]))
      {
        f = Boolean.valueOf(true);
        return true;
      }
      i += 1;
    }
    f = Boolean.valueOf(false);
    return false;
  }
  
  public static boolean isSysCustomFont(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    if (paramContext.getPaint().getTypeface() == Typeface.SANS_SERIF) {}
    while (paramContext.getPaint().getTypeface() == getInstance().d) {
      return false;
    }
    return true;
  }
  
  public static void saveLastPath(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("theme", 4).edit().putString("theme_font_root", paramString).commit();
  }
  
  public static void setSupportProcess(boolean paramBoolean)
  {
    f = Boolean.valueOf(paramBoolean);
  }
  
  public static void updateFont(View paramView)
  {
    Typeface localTypeface = getInstance().d;
    if ((paramView == null) || (localTypeface == null) || (f == null) || (!f.booleanValue()))
    {
      break label30;
      break label30;
    }
    for (;;)
    {
      label30:
      return;
      if (!(paramView instanceof ISkinIgnoreTypeface))
      {
        if ((paramView instanceof TextView))
        {
          paramView = (TextView)paramView;
          if (paramView.getTypeface() == localTypeface) {
            break;
          }
          paramView.setTypeface(localTypeface, getTypefaceStyle(paramView.getTypeface()));
          return;
        }
        if ((paramView instanceof ISkinTypeface))
        {
          Paint localPaint = ((ISkinTypeface)paramView).getPaint();
          if ((localPaint == null) || (localPaint.getTypeface() == localTypeface)) {
            break;
          }
          localPaint.setTypeface(localTypeface);
          paramView.requestLayout();
          paramView.invalidate();
          return;
        }
        if ((paramView instanceof ISkinSetTypeface))
        {
          ((ISkinSetTypeface)paramView).setTypeface(localTypeface);
          paramView.requestLayout();
          paramView.invalidate();
          return;
        }
        if (!(paramView instanceof ViewGroup)) {
          break;
        }
        paramView = (ViewGroup)paramView;
        int i = 0;
        while (i < paramView.getChildCount())
        {
          updateFont(paramView.getChildAt(i));
          i += 1;
        }
      }
    }
  }
  
  public void checkTypeface(Context paramContext)
  {
    if (!isSupportProcess(paramContext)) {}
    do
    {
      do
      {
        return;
        paramContext = getFontPath(paramContext);
        if (TextUtils.isEmpty(paramContext)) {
          break label104;
        }
        if (this.mTypefaceMap.get(paramContext) != null) {
          break;
        }
      } while (!new File(paramContext).exists());
      Typeface localTypeface = Typeface.createFromFile(new File(paramContext));
      this.mTypefaceMap.put(paramContext, localTypeface);
      a(localTypeface);
      return;
    } while (this.mTypefaceMap.get(paramContext) == this.d);
    a((Typeface)this.mTypefaceMap.get(paramContext));
    return;
    label104:
    switchDefault();
  }
  
  public Typeface getSystemDefaultFont()
  {
    return this.e;
  }
  
  public boolean isDefault()
  {
    return (this.d == null) || (this.e.equals(this.d));
  }
  
  public void replaceSystemDefaultFont(Typeface paramTypeface)
  {
    a("DEFAULT", paramTypeface);
    a("DEFAULT_BOLD", paramTypeface);
    a("SANS_SERIF", paramTypeface);
    a("SERIF", paramTypeface);
  }
  
  public void switchDefault()
  {
    a(this.e);
    if (this.g != null) {
      this.g.restore();
    }
  }
  
  public boolean switchFont(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    try
    {
      c = paramString;
      new TextHook.a(this, null).execute(new Context[] { paramContext });
      return true;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public void update(Context paramContext)
  {
    Intent localIntent = new Intent("com.tencent.qplus.THEME_INVALIDATE");
    localIntent.putExtra("isFont", true);
    paramContext.sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.TextHook
 * JD-Core Version:    0.7.0.1
 */