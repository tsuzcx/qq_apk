package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import com.tencent.commonsdk.soload.SoLoadCore;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

public class PluginContext
  extends ContextThemeWrapper
{
  private static final String TAG = "PluginContext";
  private static final boolean USE_RESOURCES_CACHE = false;
  private static final HashMap<String, PluginContext.ContextRIT> sResourcesCache = new HashMap();
  private ClassLoader mClassLoader;
  private Context mOutContext;
  private PluginContext.ContextRIT mRIT;
  
  public PluginContext(Context paramContext, int paramInt1, String paramString, ClassLoader paramClassLoader, Resources paramResources, int paramInt2)
  {
    super(paramContext, paramInt1);
    this.mClassLoader = paramClassLoader;
    if (paramInt2 == 2)
    {
      paramString = getOrCreateRIT(paramContext, new String[] { SoLoadCore.getApkPath(MobileQQ.getContext()), paramString });
    }
    else if (paramInt2 == 1)
    {
      paramString = new PluginContext.ContextRIT(null, paramResources);
      createTheme(paramString);
    }
    else
    {
      paramString = getOrCreateRIT(paramContext, new String[] { paramString });
    }
    this.mRIT = paramString;
    this.mOutContext = paramContext;
  }
  
  private static Resources createResources(Context paramContext, AssetManager paramAssetManager)
  {
    return new Resources(paramAssetManager, paramContext.getResources().getDisplayMetrics(), paramContext.getResources().getConfiguration());
  }
  
  private static Resources createResources(Context paramContext, String[] paramArrayOfString)
  {
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject5 = null;
    Object localObject1 = localObject5;
    Object localObject2 = localObject6;
    Object localObject3 = localObject7;
    Object localObject4 = localObject8;
    try
    {
      AssetManager localAssetManager = (AssetManager)AssetManager.class.newInstance();
      localObject1 = localObject5;
      localObject2 = localObject6;
      localObject3 = localObject7;
      localObject4 = localObject8;
      Method localMethod = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
      localObject1 = localObject5;
      localObject2 = localObject6;
      localObject3 = localObject7;
      localObject4 = localObject8;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localObject1 = localObject5;
        localObject2 = localObject6;
        localObject3 = localObject7;
        localObject4 = localObject8;
        localMethod.invoke(localAssetManager, new Object[] { paramArrayOfString[i] });
        i += 1;
      }
      localObject1 = localObject5;
      localObject2 = localObject6;
      localObject3 = localObject7;
      localObject4 = localObject8;
      paramArrayOfString = createResources(paramContext, localAssetManager);
      localObject1 = paramArrayOfString;
      localObject2 = paramArrayOfString;
      localObject3 = paramArrayOfString;
      localObject4 = paramArrayOfString;
      paramArrayOfString.getDisplayMetrics().setTo(paramContext.getResources().getDisplayMetrics());
      return paramArrayOfString;
    }
    catch (InvocationTargetException paramContext)
    {
      paramContext.printStackTrace();
      return localObject1;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext.printStackTrace();
      return localObject2;
    }
    catch (IllegalAccessException paramContext)
    {
      paramContext.printStackTrace();
      return localObject3;
    }
    catch (InstantiationException paramContext)
    {
      paramContext.printStackTrace();
    }
    return localObject4;
  }
  
  private static void createTheme(PluginContext.ContextRIT paramContextRIT)
  {
    Resources.Theme localTheme = paramContextRIT.mR.newTheme();
    localTheme.applyStyle(getInnerRIdValue("com.android.internal.R.style.Theme"), true);
    paramContextRIT.mT = localTheme;
  }
  
  private static int getInnerRIdValue(String paramString)
  {
    int j = -1;
    int i = j;
    int k;
    try
    {
      String str2 = paramString.substring(0, paramString.indexOf(".R.") + 2);
      i = j;
      k = paramString.lastIndexOf(".");
      i = j;
      String str1 = paramString.substring(k + 1, paramString.length());
      i = j;
      paramString = paramString.substring(0, k);
      i = j;
      Object localObject = paramString.substring(paramString.lastIndexOf(".") + 1, paramString.length());
      i = j;
      StringBuilder localStringBuilder = new StringBuilder();
      i = j;
      localStringBuilder.append(str2);
      i = j;
      localStringBuilder.append("$");
      i = j;
      localStringBuilder.append((String)localObject);
      i = j;
      str2 = localStringBuilder.toString();
      i = j;
      j = Class.forName(str2).getDeclaredField(str1).getInt(null);
      i = j;
      k = j;
      if (DebugHelper.sDebug)
      {
        i = j;
        localObject = new StringBuilder();
        i = j;
        ((StringBuilder)localObject).append("getInnderR rStrnig:");
        i = j;
        ((StringBuilder)localObject).append(paramString);
        i = j;
        DebugHelper.log("plugin_tag", ((StringBuilder)localObject).toString());
        i = j;
        paramString = new StringBuilder();
        i = j;
        paramString.append("getInnderR className:");
        i = j;
        paramString.append(str2);
        i = j;
        DebugHelper.log("plugin_tag", paramString.toString());
        i = j;
        paramString = new StringBuilder();
        i = j;
        paramString.append("getInnderR fieldName:");
        i = j;
        paramString.append(str1);
        i = j;
        DebugHelper.log("plugin_tag", paramString.toString());
        return j;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      k = i;
    }
    return k;
  }
  
  private static PluginContext.ContextRIT getOrCreateRIT(Context paramContext, String... paramVarArgs)
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
    paramContext = new PluginContext.ContextRIT(null, createResources(paramContext, paramVarArgs));
    createTheme(paramContext);
    return paramContext;
  }
  
  public AssetManager getAssets()
  {
    return this.mRIT.mR.getAssets();
  }
  
  public ClassLoader getClassLoader()
  {
    ClassLoader localClassLoader = this.mClassLoader;
    if (localClassLoader != null) {
      return localClassLoader;
    }
    return super.getClassLoader();
  }
  
  public Context getOutContext()
  {
    return this.mOutContext;
  }
  
  public Resources getResources()
  {
    return this.mRIT.mR;
  }
  
  public Resources.Theme getTheme()
  {
    return this.mRIT.mT;
  }
  
  public void setClassLoader(ClassLoader paramClassLoader)
  {
    this.mClassLoader = paramClassLoader;
  }
  
  public void setTheme(Resources.Theme paramTheme)
  {
    PluginContext.ContextRIT localContextRIT = this.mRIT;
    if (localContextRIT != null) {
      localContextRIT.mT = paramTheme;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginContext
 * JD-Core Version:    0.7.0.1
 */