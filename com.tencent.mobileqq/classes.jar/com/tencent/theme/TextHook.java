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
    try
    {
      paramContext = paramContext.getSharedPreferences("theme", 4).getString("theme_font_root", null);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static TextHook getInstance()
  {
    try
    {
      TextHook localTextHook = b;
      return localTextHook;
    }
    catch (Exception localException) {}
    return b;
  }
  
  public static String getProcessName(Context paramContext)
  {
    for (;;)
    {
      try
      {
        int i = Process.myPid();
        Object localObject = null;
        Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
        paramContext = (Context)localObject;
        localObject = paramContext;
        if (localIterator.hasNext())
        {
          localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
          if (((ActivityManager.RunningAppProcessInfo)localObject).pid == i) {
            paramContext = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
          }
        }
        else
        {
          return localObject;
        }
      }
      catch (Exception paramContext)
      {
        localObject = "";
      }
    }
  }
  
  public static int getTypefaceStyle(Typeface paramTypeface)
  {
    int i = 0;
    if (paramTypeface != null) {}
    try
    {
      i = paramTypeface.getStyle();
      return i;
    }
    catch (Exception paramTypeface) {}
    return 0;
  }
  
  public static boolean isSupportProcess(Context paramContext)
  {
    for (;;)
    {
      int i;
      try
      {
        if (f != null) {
          return f.booleanValue();
        }
        paramContext = getProcessName(paramContext);
        if (paramContext == null) {
          break label90;
        }
        paramContext = paramContext.split(":");
        if (paramContext.length > 1)
        {
          paramContext = paramContext[1];
          String[] arrayOfString = a;
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            if (!paramContext.equals(arrayOfString[i])) {
              break label92;
            }
            f = Boolean.valueOf(true);
            return true;
          }
          f = Boolean.valueOf(false);
          return false;
        }
      }
      catch (Exception paramContext)
      {
        return false;
      }
      paramContext = "";
      continue;
      label90:
      return false;
      label92:
      i += 1;
    }
  }
  
  public static boolean isSysCustomFont(Context paramContext)
  {
    try
    {
      paramContext = new TextView(paramContext);
      if (paramContext.getPaint().getTypeface() == Typeface.SANS_SERIF) {
        return false;
      }
      paramContext = paramContext.getPaint().getTypeface();
      Typeface localTypeface = getInstance().d;
      if (paramContext == localTypeface) {
        break label50;
      }
    }
    catch (Exception paramContext)
    {
      label44:
      break label44;
    }
    return true;
    label50:
    return false;
  }
  
  public static void saveLastPath(Context paramContext, String paramString)
  {
    try
    {
      paramContext.getSharedPreferences("theme", 4).edit().putString("theme_font_root", paramString).commit();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void setSupportProcess(boolean paramBoolean)
  {
    try
    {
      f = Boolean.valueOf(paramBoolean);
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void updateFont(View paramView)
  {
    try
    {
      Typeface localTypeface = getInstance().d;
      if ((paramView != null) && (localTypeface != null) && (f != null))
      {
        if (!f.booleanValue()) {
          return;
        }
        if (!(paramView instanceof ISkinIgnoreTypeface)) {
          if ((paramView instanceof TextView))
          {
            paramView = (TextView)paramView;
            if (paramView.getTypeface() != localTypeface) {
              paramView.setTypeface(localTypeface, getTypefaceStyle(paramView.getTypeface()));
            }
          }
          else if ((paramView instanceof ISkinTypeface))
          {
            Paint localPaint = ((ISkinTypeface)paramView).getPaint();
            if ((localPaint != null) && (localPaint.getTypeface() != localTypeface))
            {
              localPaint.setTypeface(localTypeface);
              paramView.requestLayout();
              paramView.invalidate();
            }
          }
          else
          {
            if ((paramView instanceof ISkinSetTypeface))
            {
              ((ISkinSetTypeface)paramView).setTypeface(localTypeface);
              paramView.requestLayout();
              paramView.invalidate();
              return;
            }
            if ((paramView instanceof ViewGroup))
            {
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
      }
      return;
    }
    catch (Exception paramView) {}
  }
  
  public void checkTypeface(Context paramContext)
  {
    try
    {
      if (!isSupportProcess(paramContext)) {
        return;
      }
      paramContext = getFontPath(paramContext);
      if (!TextUtils.isEmpty(paramContext))
      {
        if (this.mTypefaceMap.get(paramContext) == null)
        {
          if (new File(paramContext).exists())
          {
            Typeface localTypeface = Typeface.createFromFile(new File(paramContext));
            this.mTypefaceMap.put(paramContext, localTypeface);
            a(localTypeface);
          }
        }
        else if (this.mTypefaceMap.get(paramContext) != this.d) {
          a((Typeface)this.mTypefaceMap.get(paramContext));
        }
      }
      else {
        switchDefault();
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public Typeface getSystemDefaultFont()
  {
    try
    {
      Typeface localTypeface = this.e;
      return localTypeface;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public boolean isDefault()
  {
    try
    {
      boolean bool;
      if (this.d != null) {
        bool = this.e.equals(this.d);
      }
      return bool;
    }
    catch (Exception localException) {}
    return true;
  }
  
  public void replaceSystemDefaultFont(Typeface paramTypeface)
  {
    try
    {
      a("DEFAULT", paramTypeface);
      a("DEFAULT_BOLD", paramTypeface);
      a("SANS_SERIF", paramTypeface);
      a("SERIF", paramTypeface);
      return;
    }
    catch (Exception paramTypeface) {}
  }
  
  public void switchDefault()
  {
    try
    {
      a(this.e);
      if (this.g != null) {
        this.g.restore();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean switchFont(Context paramContext, String paramString)
  {
    if (paramContext != null) {}
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
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
    }
    catch (Exception paramContext)
    {
      label47:
      break label47;
    }
    return false;
  }
  
  public void update(Context paramContext)
  {
    try
    {
      Intent localIntent = new Intent("com.tencent.qplus.THEME_INVALIDATE");
      localIntent.putExtra("isFont", true);
      paramContext.sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (Exception paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.TextHook
 * JD-Core Version:    0.7.0.1
 */