package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import com.tencent.commonsdk.soload.SoLoadCore;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

class c
  extends ContextThemeWrapper
{
  private static final String a = c.class.getSimpleName();
  private static final HashMap e = new HashMap();
  private static final boolean f = false;
  private a b;
  private ClassLoader c;
  private Context d;
  
  public c(Context paramContext, int paramInt1, String paramString, ClassLoader paramClassLoader, Resources paramResources, int paramInt2)
  {
    super(paramContext, paramInt1);
    this.c = paramClassLoader;
    if (paramInt2 == 2) {
      paramString = a(paramContext, new String[] { SoLoadCore.getApkPath(MobileQQ.getContext()), paramString });
    }
    for (;;)
    {
      this.b = paramString;
      this.d = paramContext;
      return;
      if (paramInt2 == 1)
      {
        paramString = new a(null, paramResources);
        a(paramString);
      }
      else
      {
        paramString = a(paramContext, new String[] { paramString });
      }
    }
  }
  
  private static int a(String paramString)
  {
    try
    {
      String str2 = paramString.substring(0, paramString.indexOf(".R.") + 2);
      i = paramString.lastIndexOf(".");
      String str1 = paramString.substring(i + 1, paramString.length());
      paramString = paramString.substring(0, i);
      String str3 = paramString.substring(paramString.lastIndexOf(".") + 1, paramString.length());
      str2 = str2 + "$" + str3;
      i = Class.forName(str2).getDeclaredField(str1).getInt(null);
      paramString.printStackTrace();
    }
    catch (Throwable paramString)
    {
      try
      {
        if (DebugHelper.sDebug)
        {
          DebugHelper.log("plugin_tag", "getInnderR rStrnig:" + paramString);
          DebugHelper.log("plugin_tag", "getInnderR className:" + str2);
          DebugHelper.log("plugin_tag", "getInnderR fieldName:" + str1);
        }
        return i;
      }
      catch (Throwable paramString)
      {
        int i;
        break label179;
      }
      paramString = paramString;
      i = -1;
    }
    label179:
    return i;
  }
  
  private static Resources a(Context paramContext, AssetManager paramAssetManager)
  {
    return new Resources(paramAssetManager, paramContext.getResources().getDisplayMetrics(), paramContext.getResources().getConfiguration());
  }
  
  private static a a(Context paramContext, String... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramVarArgs[i]);
      i += 1;
    }
    Collections.sort(localArrayList);
    paramContext = new a(null, b(paramContext, paramVarArgs));
    a(paramContext);
    return paramContext;
  }
  
  private static void a(a parama)
  {
    Resources.Theme localTheme = parama.b.newTheme();
    localTheme.applyStyle(a("com.android.internal.R.style.Theme"), true);
    parama.a = localTheme;
  }
  
  private static Resources b(Context paramContext, String[] paramArrayOfString)
  {
    AssetManager localAssetManager = new AssetManager();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localAssetManager.addAssetPath(paramArrayOfString[i]);
      i += 1;
    }
    paramArrayOfString = a(paramContext, localAssetManager);
    paramArrayOfString.getDisplayMetrics().setTo(paramContext.getResources().getDisplayMetrics());
    return paramArrayOfString;
  }
  
  public Context a()
  {
    return this.d;
  }
  
  public void a(ClassLoader paramClassLoader)
  {
    this.c = paramClassLoader;
  }
  
  public AssetManager getAssets()
  {
    return this.b.b.getAssets();
  }
  
  public ClassLoader getClassLoader()
  {
    if (this.c != null) {
      return this.c;
    }
    return super.getClassLoader();
  }
  
  public Resources getResources()
  {
    return this.b.b;
  }
  
  public Resources.Theme getTheme()
  {
    return this.b.a;
  }
  
  private static class a
  {
    public Resources.Theme a;
    public Resources b;
    
    public a(Resources.Theme paramTheme, Resources paramResources)
    {
      this.a = paramTheme;
      this.b = paramResources;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.c
 * JD-Core Version:    0.7.0.1
 */