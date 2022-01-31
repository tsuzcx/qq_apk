package com.tencent.mobileqq.pluginsdk;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.skin.util.SkinEngineInitBridge;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import mqq.app.BaseActivity;

public class BasePluginActivity
  extends BaseActivity
  implements IPluginActivity, PluginInterfaceHelper.OnPluginInterfaceLoadedListener, SkinnableActivityProcesser.Callback
{
  private static Boolean d;
  private static boolean e;
  public static int i_support_immersive = -1;
  boolean a = false;
  View b;
  SkinnableActivityProcesser c;
  private Activity f;
  private ClassLoader g;
  private PluginConfig h = new PluginConfig();
  private ImmersiveConfig i = new ImmersiveConfig();
  protected String mApkFilePath = "";
  public View mContentView;
  public Context mContext;
  protected boolean mIsRunInPlugin;
  protected boolean mIsTab;
  protected Activity mOutActivity;
  protected PackageInfo mPackageInfo;
  protected String mPluginID;
  protected int mPluginResourcesType;
  protected boolean mUseSkinEngine;
  
  private void a(boolean paramBoolean)
  {
    int j = 0;
    if (this.b != null)
    {
      localObject = this.b;
      if (paramBoolean) {
        ((View)localObject).setVisibility(j);
      }
    }
    do
    {
      do
      {
        return;
        j = 8;
        break;
      } while (paramBoolean != true);
      localObject = new ImageView(this);
      ((ImageView)localObject).setImageDrawable(new ColorDrawable(Color.parseColor("#77000000")));
      ((ImageView)localObject).setPadding(0, this.h.titleHeight, 0, 0);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
      ((ImageView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.b = ((View)localObject);
    } while (this.b == null);
    Object localObject = getWindow().getDecorView();
    if ((localObject instanceof ViewGroup))
    {
      ((ViewGroup)localObject).addView(this.b, this.b.getLayoutParams());
      return;
    }
    getWindow().addContentView(this.b, this.b.getLayoutParams());
  }
  
  public static final Bitmap getDrawableBitmap(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      return null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)paramDrawable).getBitmap();
      }
    } while (!(paramDrawable instanceof SkinnableBitmapDrawable));
    return ((SkinnableBitmapDrawable)paramDrawable).getBitmap();
  }
  
  public static boolean reflectHasAndIsNull(Object paramObject, String paramString, Class paramClass)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    Class localClass;
    if (paramObject != null)
    {
      bool1 = bool3;
      if (paramString != null)
      {
        localClass = paramClass;
        if (paramClass != null) {}
      }
    }
    try
    {
      localClass = paramObject.getClass();
      paramString = localClass.getDeclaredField(paramString);
      bool1 = bool3;
      if (paramString != null)
      {
        paramString.setAccessible(true);
        paramObject = paramString.get(paramObject);
        if (paramObject != null) {
          break label67;
        }
      }
      label67:
      for (bool1 = bool2;; bool1 = false) {
        return bool1;
      }
      return false;
    }
    catch (Exception paramObject) {}
  }
  
  public static void setProperty(Object paramObject1, Class paramClass, String paramString, Object paramObject2)
    throws Exception
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    paramClass.set(paramObject1, paramObject2);
  }
  
  public boolean IDispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return true;
  }
  
  public void IFinish()
  {
    finish();
  }
  
  public View IGetContentView()
  {
    return this.mContentView;
  }
  
  public Handler IGetInHandler()
  {
    return null;
  }
  
  public Resources IGetResource()
  {
    if (this.mContext != null) {
      return this.mContext.getResources();
    }
    return this.f.getResources();
  }
  
  public void IInit(String paramString1, String paramString2, Activity paramActivity, ClassLoader paramClassLoader, PackageInfo paramPackageInfo, boolean paramBoolean, int paramInt)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "BasePluginActivity.Init:" + paramString1 + ", " + paramBoolean + ", " + this.mPluginResourcesType);
    }
    this.mIsRunInPlugin = true;
    this.g = paramClassLoader;
    this.mOutActivity = paramActivity;
    this.mPluginID = paramString1;
    this.mApkFilePath = paramString2;
    this.mPackageInfo = paramPackageInfo;
    this.mPluginResourcesType = paramInt;
    if (this.mContext == null) {
      this.mContext = new c(paramActivity, 0, this.mApkFilePath, this.g, paramActivity.getResources(), this.mPluginResourcesType);
    }
    attachBaseContext(this.mContext);
    this.mUseSkinEngine = paramBoolean;
    if ((e) || (!paramBoolean) || ((this.mPluginResourcesType != 1) && (this.mPluginResourcesType != 2))) {
      try
      {
        SkinEngineInitBridge.init(this);
        e = true;
        return;
      }
      catch (Exception paramString1)
      {
        SkinEngine.getInstances().unInit();
        return;
      }
    }
    SkinEngineInitBridge.initSkin(this);
  }
  
  public boolean IIsWrapContent()
  {
    return true;
  }
  
  public void IOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void IOnAttachFragment(Fragment paramFragment)
  {
    onAttachFragment(paramFragment);
  }
  
  public boolean IOnBackPressed()
  {
    try
    {
      onBackPressed();
      label4:
      return true;
    }
    catch (Exception localException)
    {
      break label4;
    }
  }
  
  public void IOnConfigurationChanged(Configuration paramConfiguration)
  {
    onConfigurationChanged(paramConfiguration);
  }
  
  public void IOnCreate(Bundle paramBundle)
  {
    onCreate(paramBundle);
  }
  
  public boolean IOnCreateOptionsMenu(Menu paramMenu)
  {
    return onCreateOptionsMenu(paramMenu);
  }
  
  public void IOnDestroy()
  {
    onDestroy();
  }
  
  public boolean IOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean IOnKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    return onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
  }
  
  public boolean IOnKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return onKeyUp(paramInt, paramKeyEvent);
  }
  
  public boolean IOnMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    return onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public void IOnNewIntent(Intent paramIntent)
  {
    onNewIntent(paramIntent);
  }
  
  public boolean IOnOptionsItemSelected(MenuItem paramMenuItem)
  {
    return onOptionsItemSelected(paramMenuItem);
  }
  
  public void IOnPause()
  {
    onPause();
  }
  
  public boolean IOnPrepareOptionsMenu(Menu paramMenu)
  {
    return onPrepareOptionsMenu(paramMenu);
  }
  
  public void IOnRestart()
  {
    onRestart();
  }
  
  public void IOnRestoreInstanceState(Bundle paramBundle) {}
  
  public void IOnResume()
  {
    onResume();
  }
  
  public void IOnSaveInstanceState(Bundle paramBundle) {}
  
  public void IOnSetTheme() {}
  
  public void IOnStart()
  {
    onStart();
  }
  
  public void IOnStop()
  {
    onStop();
  }
  
  public boolean IOnTouchEvent(MotionEvent paramMotionEvent)
  {
    return onTouchEvent(paramMotionEvent);
  }
  
  public void IOnUserInteraction()
  {
    onUserInteraction();
  }
  
  public void IOnWindowFocusChanged(boolean paramBoolean)
  {
    onWindowFocusChanged(paramBoolean);
  }
  
  public void ISetIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
  }
  
  public void ISetIsTab()
  {
    this.mIsTab = true;
  }
  
  public void ISetOutHandler(Handler paramHandler) {}
  
  public void ISetParent(BasePluginActivity paramBasePluginActivity)
  {
    try
    {
      Method localMethod = Activity.class.getDeclaredMethod("setParent", new Class[] { Activity.class });
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[] { paramBasePluginActivity });
      return;
    }
    catch (Exception paramBasePluginActivity) {}
  }
  
  public ImmersiveConfig IgetImmersiveConfig()
  {
    return this.i;
  }
  
  boolean a(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mIsRunInPlugin)
    {
      bool1 = bool2;
      if (paramIntent != null)
      {
        if (!paramIntent.hasExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY")) {
          break label38;
        }
        bool1 = paramIntent.getBooleanExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      }
    }
    label38:
    ComponentName localComponentName;
    label101:
    do
    {
      do
      {
        do
        {
          return bool1;
          localComponentName = paramIntent.getComponent();
          bool1 = bool2;
        } while (localComponentName == null);
        if (!this.mOutActivity.getPackageName().equals(localComponentName.getPackageName())) {
          break label101;
        }
        paramIntent = this.f.getPackageManager().queryIntentActivities(paramIntent, 65536);
        if (paramIntent == null) {
          break;
        }
        bool1 = bool2;
      } while (paramIntent.size() != 0);
      return true;
      bool1 = bool2;
    } while (!getPackageName().equals(localComponentName.getPackageName()));
    return true;
  }
  
  boolean b(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mIsRunInPlugin)
    {
      bool1 = bool2;
      if (paramIntent != null)
      {
        if (!paramIntent.hasExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY")) {
          break label38;
        }
        bool1 = paramIntent.getBooleanExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      }
    }
    label38:
    do
    {
      do
      {
        return bool1;
        paramIntent = paramIntent.getComponent();
        bool1 = bool2;
      } while (paramIntent == null);
      if (this.mOutActivity.getPackageName().equals(paramIntent.getPackageName()))
      {
        paramIntent = paramIntent.getClassName();
        try
        {
          bool1 = BasePluginActivity.class.isAssignableFrom(Class.forName(paramIntent, false, this.mContext.getClassLoader()));
          return bool1;
        }
        catch (ClassNotFoundException paramIntent)
        {
          DebugHelper.log("plugin_tag", "isSamePackage2", paramIntent);
          return false;
        }
      }
      bool1 = bool2;
    } while (!getPackageName().equals(paramIntent.getPackageName()));
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (reflectHasAndIsNull(this, "mWindow", Activity.class))
    {
      if (paramMotionEvent.getAction() == 0) {
        onUserInteraction();
      }
      Window localWindow = getWindow();
      if ((localWindow != null) && (localWindow.superDispatchTouchEvent(paramMotionEvent))) {
        return true;
      }
      return onTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public View findViewById(int paramInt)
  {
    if ((this.mIsRunInPlugin) && (this.mContentView != null))
    {
      View localView2 = this.mContentView.findViewById(paramInt);
      View localView1 = localView2;
      if (localView2 == null) {}
      try
      {
        localView1 = super.findViewById(paramInt);
        return localView1;
      }
      catch (Exception localException)
      {
        DebugHelper.debug("plugin_tag", "findViewById", localException);
        return localView2;
      }
    }
    return super.findViewById(paramInt);
  }
  
  public void finish()
  {
    int k;
    int j;
    if (this.mIsRunInPlugin)
    {
      k = 0;
      j = k;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = Activity.class.getDeclaredField("mResultCode");
        j = k;
        ((Field)localObject1).setAccessible(true);
        j = k;
        k = ((Integer)((Field)localObject1).get(this)).intValue();
        j = k;
        localObject1 = Activity.class.getDeclaredField("mResultData");
        j = k;
        ((Field)localObject1).setAccessible(true);
        j = k;
        localObject1 = (Intent)((Field)localObject1).get(this);
        j = k;
        this.mOutActivity.setResult(j, (Intent)localObject1);
        this.mOutActivity.finish();
        this.a = true;
        return;
      }
      catch (Exception localException)
      {
        if (!DebugHelper.sDebug) {
          break label127;
        }
        DebugHelper.log("plugin_tag", "BasePluginActivity.finish", localException);
      }
      finally {}
      super.finish();
      return;
      label127:
      Object localObject3 = null;
    }
  }
  
  public Context getApplicationContext()
  {
    if (this.mIsRunInPlugin) {
      return this.mOutActivity.getApplicationContext();
    }
    return super.getApplicationContext();
  }
  
  public ApplicationInfo getApplicationInfo()
  {
    if (this.mIsRunInPlugin) {
      return this.mPackageInfo.applicationInfo;
    }
    return super.getApplicationInfo();
  }
  
  public int getChangingConfigurations()
  {
    if (this.mIsRunInPlugin) {
      return this.mOutActivity.getChangingConfigurations();
    }
    return super.getChangingConfigurations();
  }
  
  public FragmentManager getFragmentManager()
  {
    if (this.mIsRunInPlugin) {
      return getOutActivity().getFragmentManager();
    }
    return super.getFragmentManager();
  }
  
  public Resources getHostResources()
  {
    return this.mOutActivity.getResources();
  }
  
  public LayoutInflater getLayoutInflater()
  {
    if (this.mContext != null) {
      return LayoutInflater.from(this.mContext);
    }
    return LayoutInflater.from(this.f);
  }
  
  protected String getModuleId()
  {
    return this.mPluginID;
  }
  
  public Activity getOutActivity()
  {
    return this.mOutActivity;
  }
  
  public Resources getOutResources()
  {
    if (this.mIsRunInPlugin == true) {
      return this.mOutActivity.getResources();
    }
    return this.f.getResources();
  }
  
  public PackageInfo getPackageInfo()
  {
    if (this.mIsRunInPlugin) {
      return this.mPackageInfo;
    }
    return null;
  }
  
  public String getPackageName()
  {
    if (this.mIsRunInPlugin) {
      return this.mPackageInfo.packageName;
    }
    return super.getPackageName();
  }
  
  public Object getSystemService(String paramString)
  {
    if (("window".equals(paramString)) || ("search".equals(paramString)))
    {
      if (this.mIsRunInPlugin) {
        return this.mOutActivity.getSystemService(paramString);
      }
      return super.getSystemService(paramString);
    }
    if (this.mContext != null) {
      return this.mContext.getSystemService(paramString);
    }
    return super.getSystemService(paramString);
  }
  
  public Window getWindow()
  {
    if (this.mIsRunInPlugin) {
      return this.mOutActivity.getWindow();
    }
    return super.getWindow();
  }
  
  public WindowManager getWindowManager()
  {
    if (this.mIsRunInPlugin) {
      return this.mOutActivity.getWindowManager();
    }
    return super.getWindowManager();
  }
  
  public boolean isFinishing()
  {
    if (this.mIsRunInPlugin) {
      return this.a;
    }
    return super.isFinishing();
  }
  
  public boolean isShadow()
  {
    return true;
  }
  
  public int isSupportStatus()
  {
    return IPluginAdapterProxy.getProxy().isSupportImmersive();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.mIsRunInPlugin) {
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttachFragment(Fragment paramFragment)
  {
    super.onAttachFragment(paramFragment);
  }
  
  public void onBackPressed()
  {
    finish();
  }
  
  protected void onConfig(PluginConfig paramPluginConfig) {}
  
  /* Error */
  protected void onCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 258	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mIsRunInPlugin	Z
    //   4: ifeq +112 -> 116
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 262	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mOutActivity	Landroid/app/Activity;
    //   12: putfield 217	com/tencent/mobileqq/pluginsdk/BasePluginActivity:f	Landroid/app/Activity;
    //   15: aload_0
    //   16: getfield 217	com/tencent/mobileqq/pluginsdk/BasePluginActivity:f	Landroid/app/Activity;
    //   19: invokevirtual 587	android/app/Activity:getWindow	()Landroid/view/Window;
    //   22: astore_2
    //   23: getstatic 616	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 26
    //   28: if_icmplt +13 -> 41
    //   31: aload_0
    //   32: ldc 219
    //   34: ldc_w 494
    //   37: aload_2
    //   38: invokestatic 618	com/tencent/mobileqq/pluginsdk/BasePluginActivity:setProperty	(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   41: aload_0
    //   42: aload_0
    //   43: getfield 65	com/tencent/mobileqq/pluginsdk/BasePluginActivity:h	Lcom/tencent/mobileqq/pluginsdk/BasePluginActivity$PluginConfig;
    //   46: invokevirtual 620	com/tencent/mobileqq/pluginsdk/BasePluginActivity:onConfig	(Lcom/tencent/mobileqq/pluginsdk/BasePluginActivity$PluginConfig;)V
    //   49: aload_0
    //   50: getfield 622	com/tencent/mobileqq/pluginsdk/BasePluginActivity:c	Lcom/tencent/theme/SkinnableActivityProcesser;
    //   53: ifnonnull +16 -> 69
    //   56: aload_0
    //   57: new 624	com/tencent/theme/SkinnableActivityProcesser
    //   60: dup
    //   61: aload_0
    //   62: aload_0
    //   63: invokespecial 627	com/tencent/theme/SkinnableActivityProcesser:<init>	(Landroid/app/Activity;Lcom/tencent/theme/SkinnableActivityProcesser$Callback;)V
    //   66: putfield 622	com/tencent/mobileqq/pluginsdk/BasePluginActivity:c	Lcom/tencent/theme/SkinnableActivityProcesser;
    //   69: aload_0
    //   70: invokestatic 632	com/tencent/mobileqq/pluginsdk/PluginStatic:a	(Lcom/tencent/mobileqq/pluginsdk/IPluginActivity;)V
    //   73: aload_0
    //   74: aload_1
    //   75: invokespecial 633	mqq/app/BaseActivity:onCreate	(Landroid/os/Bundle;)V
    //   78: aload_0
    //   79: invokevirtual 637	com/tencent/mobileqq/pluginsdk/BasePluginActivity:getIntent	()Landroid/content/Intent;
    //   82: ldc_w 639
    //   85: iconst_0
    //   86: invokevirtual 436	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   89: ifeq +12 -> 101
    //   92: aload_0
    //   93: aload_0
    //   94: getfield 262	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mOutActivity	Landroid/app/Activity;
    //   97: aload_0
    //   98: invokevirtual 643	com/tencent/mobileqq/pluginsdk/BasePluginActivity:readyPluginInterface	(Landroid/content/Context;Lcom/tencent/mobileqq/pluginsdk/PluginInterfaceHelper$OnPluginInterfaceLoadedListener;)V
    //   101: return
    //   102: astore_2
    //   103: ldc 229
    //   105: iconst_1
    //   106: ldc_w 645
    //   109: aload_2
    //   110: invokestatic 650	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: goto -72 -> 41
    //   116: aload_0
    //   117: aload_1
    //   118: invokespecial 633	mqq/app/BaseActivity:onCreate	(Landroid/os/Bundle;)V
    //   121: aload_0
    //   122: aload_0
    //   123: putfield 217	com/tencent/mobileqq/pluginsdk/BasePluginActivity:f	Landroid/app/Activity;
    //   126: return
    //   127: astore_2
    //   128: goto -59 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	BasePluginActivity
    //   0	131	1	paramBundle	Bundle
    //   22	16	2	localWindow	Window
    //   102	8	2	localException1	Exception
    //   127	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   31	41	102	java/lang/Exception
    //   56	69	127	java/lang/Exception
  }
  
  protected void onDestroy()
  {
    if (this.mIsRunInPlugin)
    {
      if (this.c != null)
      {
        this.c.destory();
        this.c = null;
      }
      this.g = null;
      PluginStatic.b(this);
      super.onDestroy();
      return;
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mIsRunInPlugin) {
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    if (this.mIsRunInPlugin) {
      return false;
    }
    return super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mIsRunInPlugin) {
      return false;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    if (this.mIsRunInPlugin)
    {
      super.onPause();
      return;
    }
    super.onPause();
  }
  
  public void onPluginInterfaceLoaded(PluginInterface paramPluginInterface)
  {
    onPluginInterfaceReady(paramPluginInterface);
  }
  
  protected void onPluginInterfaceReady(PluginInterface paramPluginInterface) {}
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  protected void onRestart()
  {
    if (this.mIsRunInPlugin)
    {
      super.onRestart();
      return;
    }
    super.onRestart();
  }
  
  protected void onResume()
  {
    if (this.mIsRunInPlugin)
    {
      super.onResume();
      if ((IPluginAdapterProxy.getProxy().isNightMode()) && (this.h.enableNight))
      {
        a(true);
        return;
      }
      a(false);
      return;
    }
    super.onResume();
  }
  
  protected void onStart()
  {
    if (this.mIsRunInPlugin)
    {
      super.onStart();
      return;
    }
    super.onStart();
  }
  
  protected void onStop()
  {
    if (this.mIsRunInPlugin)
    {
      super.onStop();
      return;
    }
    super.onStop();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mIsRunInPlugin) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (this.mIsRunInPlugin) {
      return;
    }
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void openOptionsMenu()
  {
    if (this.mIsRunInPlugin)
    {
      this.mOutActivity.openOptionsMenu();
      return;
    }
    super.openOptionsMenu();
  }
  
  public void overridePendingTransition(int paramInt1, int paramInt2)
  {
    if (this.mIsRunInPlugin)
    {
      this.f.overridePendingTransition(paramInt1, paramInt2);
      return;
    }
    super.overridePendingTransition(paramInt1, paramInt2);
  }
  
  protected final void readyPluginInterface(Context paramContext, PluginInterfaceHelper.OnPluginInterfaceLoadedListener paramOnPluginInterfaceLoadedListener)
  {
    PluginInterfaceHelper.getPluginInterface(paramContext, paramOnPluginInterfaceLoadedListener);
  }
  
  public void setContentView(int paramInt)
  {
    if (this.mIsRunInPlugin)
    {
      this.mContentView = LayoutInflater.from(this.mContext).inflate(paramInt, null);
      if (!this.mIsTab) {
        this.f.setContentView(this.mContentView);
      }
      return;
    }
    super.setContentView(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    if (this.mIsRunInPlugin)
    {
      this.mContentView = paramView;
      if (!this.mIsTab) {
        this.f.setContentView(this.mContentView);
      }
      return;
    }
    super.setContentView(paramView);
  }
  
  public void setImmersiveConfig(ImmersiveConfig paramImmersiveConfig)
  {
    this.i = paramImmersiveConfig;
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    super.setRequestedOrientation(paramInt);
  }
  
  public void setTheme(int paramInt)
  {
    if (this.mIsRunInPlugin)
    {
      this.mOutActivity.setTheme(paramInt);
      return;
    }
    super.setTheme(paramInt);
  }
  
  public void setTitle(int paramInt)
  {
    if (this.mIsRunInPlugin)
    {
      this.f.setTitle(paramInt);
      return;
    }
    super.setTitle(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (this.mIsRunInPlugin)
    {
      this.f.setTitle(paramCharSequence);
      return;
    }
    super.setTitle(paramCharSequence);
  }
  
  public void startActivity(Intent paramIntent)
  {
    try
    {
      super.startActivity(paramIntent);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      startActivityForResult(paramIntent, -1);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    boolean bool2 = false;
    if (this.mIsRunInPlugin)
    {
      boolean bool1;
      if (paramIntent.hasExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY"))
      {
        bool1 = paramIntent.getBooleanExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        if (bool1) {
          break label150;
        }
      }
      for (;;)
      {
        if (!(this.f instanceof PluginProxyActivity)) {
          break label162;
        }
        ((PluginProxyActivity)this.f).startActivityForResult(paramIntent, paramInt);
        return;
        Object localObject = paramIntent.getComponent();
        bool1 = bool2;
        if (localObject == null) {
          break;
        }
        if (this.mOutActivity.getPackageName().equals(((ComponentName)localObject).getPackageName()))
        {
          localObject = this.f.getPackageManager().queryIntentActivities(paramIntent, 65536);
          if (localObject != null)
          {
            bool1 = bool2;
            if (((List)localObject).size() != 0) {
              break;
            }
          }
          bool1 = true;
          break;
        }
        bool1 = bool2;
        if (!getPackageName().equals(((ComponentName)localObject).getPackageName())) {
          break;
        }
        bool1 = true;
        break;
        label150:
        paramIntent.putExtra("pluginsdk_IsPluginActivity", true);
      }
      label162:
      this.f.startActivityForResult(paramIntent, paramInt);
      return;
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public class ImmersiveConfig
  {
    public boolean isNeedColor;
    public boolean isTranslate;
    public int mStatusColor = 0;
    public Drawable mStatusDrawable;
    
    public ImmersiveConfig() {}
  }
  
  public static class PluginConfig
  {
    public boolean enableNight = true;
    public int titleHeight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.BasePluginActivity
 * JD-Core Version:    0.7.0.1
 */