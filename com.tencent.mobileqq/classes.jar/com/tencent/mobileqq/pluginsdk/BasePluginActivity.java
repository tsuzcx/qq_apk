package com.tencent.mobileqq.pluginsdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.util.SparseArray;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;
import mqq.app.QQPermissionHelper;

public class BasePluginActivity
  extends BaseActivity
  implements IPluginActivity, PluginInterfaceHelper.OnPluginInterfaceLoadedListener, SkinnableActivityProcesser.Callback
{
  public static int i_support_immersive = -1;
  private static Boolean sIsLiquid = null;
  private static boolean sSkilEngineInit = false;
  private Dialog jumpDialog;
  private Activity mActivity = null;
  protected String mApkFilePath = "";
  private BasePluginActivity.PluginConfig mConfig = new BasePluginActivity.PluginConfig();
  public View mContentView = null;
  public Context mContext = null;
  private ClassLoader mDexClassLoader = null;
  boolean mFinished = false;
  private BasePluginActivity.ImmersiveConfig mImmerConfit = new BasePluginActivity.ImmersiveConfig(this);
  protected boolean mIsRunInPlugin = false;
  protected boolean mIsTab = false;
  public Activity mOutActivity = null;
  protected PackageInfo mPackageInfo;
  private SparseArray<List> mPermissionCallerMap = new SparseArray();
  protected String mPluginID;
  protected int mPluginResourcesType;
  protected boolean mUseSkinEngine = false;
  View mViewShadow;
  SkinnableActivityProcesser processer;
  
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
  
  private void setNightMaskVisible(boolean paramBoolean)
  {
    int i = 0;
    if (this.mViewShadow != null)
    {
      localObject = this.mViewShadow;
      if (paramBoolean) {
        ((View)localObject).setVisibility(i);
      }
    }
    do
    {
      do
      {
        return;
        i = 8;
        break;
      } while (paramBoolean != true);
      localObject = new ImageView(this);
      ((ImageView)localObject).setImageDrawable(new ColorDrawable(Color.parseColor("#77000000")));
      ((ImageView)localObject).setPadding(0, this.mConfig.titleHeight, 0, 0);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
      ((ImageView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.mViewShadow = ((View)localObject);
    } while (this.mViewShadow == null);
    Object localObject = getWindow().getDecorView();
    if ((localObject instanceof ViewGroup))
    {
      ((ViewGroup)localObject).addView(this.mViewShadow, this.mViewShadow.getLayoutParams());
      return;
    }
    getWindow().addContentView(this.mViewShadow, this.mViewShadow.getLayoutParams());
  }
  
  public static void setProperty(Object paramObject1, Class paramClass, String paramString, Object paramObject2)
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
    return this.mActivity.getResources();
  }
  
  public void IInit(String paramString1, String paramString2, Activity paramActivity, ClassLoader paramClassLoader, PackageInfo paramPackageInfo, boolean paramBoolean, int paramInt)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "BasePluginActivity.Init:" + paramString1 + ", " + paramBoolean + ", " + this.mPluginResourcesType);
    }
    this.mIsRunInPlugin = true;
    this.mDexClassLoader = paramClassLoader;
    this.mOutActivity = paramActivity;
    this.mPluginID = paramString1;
    this.mApkFilePath = paramString2;
    this.mPackageInfo = paramPackageInfo;
    this.mPluginResourcesType = paramInt;
    if (this.mContext == null) {
      this.mContext = new PluginContext(paramActivity, 0, this.mApkFilePath, this.mDexClassLoader, paramActivity.getResources(), this.mPluginResourcesType);
    }
    attachBaseContext(this.mContext);
    this.mUseSkinEngine = paramBoolean;
    if ((sSkilEngineInit) || (!paramBoolean) || ((this.mPluginResourcesType != 1) && (this.mPluginResourcesType != 2))) {
      try
      {
        SkinEngineInitBridge.init(this);
        sSkilEngineInit = true;
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
  
  @TargetApi(5)
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
  
  public BasePluginActivity.ImmersiveConfig IgetImmersiveConfig()
  {
    return this.mImmerConfit;
  }
  
  public int checkSelfPermission(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return super.checkSelfPermission(paramString);
    }
    return 0;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    if (reflectHasAndIsNull(this, "mWindow", Activity.class))
    {
      if (paramMotionEvent.getAction() == 0) {
        onUserInteraction();
      }
      Window localWindow = getWindow();
      if ((localWindow == null) || (!localWindow.superDispatchTouchEvent(paramMotionEvent))) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
      return bool;
      bool = onTouchEvent(paramMotionEvent);
      continue;
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
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
    int j;
    int i;
    if (this.mIsRunInPlugin)
    {
      j = 0;
      i = j;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = Activity.class.getDeclaredField("mResultCode");
        i = j;
        ((Field)localObject1).setAccessible(true);
        i = j;
        j = ((Integer)((Field)localObject1).get(this)).intValue();
        i = j;
        localObject1 = Activity.class.getDeclaredField("mResultData");
        i = j;
        ((Field)localObject1).setAccessible(true);
        i = j;
        localObject1 = (Intent)((Field)localObject1).get(this);
        i = j;
        this.mOutActivity.setResult(i, (Intent)localObject1);
        this.mOutActivity.finish();
        this.mFinished = true;
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
    return LayoutInflater.from(this.mActivity);
  }
  
  public String getModuleId()
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
    return this.mActivity.getResources();
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
  
  public void initNavigationBarColor()
  {
    try
    {
      if (this.mContext == null)
      {
        QLog.d("plugin_tag", 1, "[NavigationBar] initNavigationBarColor context empty:");
        return;
      }
      boolean bool1 = this.mContext.getSharedPreferences("BootOptimize", 0).getBoolean("KEY_DISABLE_NAVIGATION_BAR", false);
      boolean bool2 = IPluginAdapterProxy.getProxy().isNightMode();
      if ((bool1) || (!bool2))
      {
        QLog.d("plugin_tag", 1, new Object[] { "[NavigationBar] disableNavigationBar=", Boolean.valueOf(bool1), " isNightMode=", Boolean.valueOf(bool2) });
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("plugin_tag", 1, "[NavigationBar] initNavigationBarColor=", localThrowable);
      return;
    }
    setNavigationBarColor(-16777216);
  }
  
  public boolean isFinishing()
  {
    if (this.mIsRunInPlugin) {
      return this.mFinished;
    }
    return super.isFinishing();
  }
  
  boolean isSamePackage(Intent paramIntent)
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
        paramIntent = this.mActivity.getPackageManager().queryIntentActivities(paramIntent, 65536);
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
  
  boolean isSamePackage2(Intent paramIntent)
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
  
  protected void onConfig(BasePluginActivity.PluginConfig paramPluginConfig) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    try
    {
      super.onConfigurationChanged(paramConfiguration);
      label5:
      EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
      return;
    }
    catch (Exception localException)
    {
      break label5;
    }
  }
  
  /* Error */
  public void onCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 63	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mIsRunInPlugin	Z
    //   4: ifeq +116 -> 120
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 65	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mOutActivity	Landroid/app/Activity;
    //   12: putfield 69	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mActivity	Landroid/app/Activity;
    //   15: aload_0
    //   16: getfield 69	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mActivity	Landroid/app/Activity;
    //   19: invokevirtual 564	android/app/Activity:getWindow	()Landroid/view/Window;
    //   22: astore_2
    //   23: getstatic 443	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 26
    //   28: if_icmplt +13 -> 41
    //   31: aload_0
    //   32: ldc 241
    //   34: ldc_w 457
    //   37: aload_2
    //   38: invokestatic 700	com/tencent/mobileqq/pluginsdk/BasePluginActivity:setProperty	(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   41: aload_0
    //   42: aload_0
    //   43: getfield 86	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mConfig	Lcom/tencent/mobileqq/pluginsdk/BasePluginActivity$PluginConfig;
    //   46: invokevirtual 702	com/tencent/mobileqq/pluginsdk/BasePluginActivity:onConfig	(Lcom/tencent/mobileqq/pluginsdk/BasePluginActivity$PluginConfig;)V
    //   49: aload_0
    //   50: getfield 704	com/tencent/mobileqq/pluginsdk/BasePluginActivity:processer	Lcom/tencent/theme/SkinnableActivityProcesser;
    //   53: ifnonnull +16 -> 69
    //   56: aload_0
    //   57: new 706	com/tencent/theme/SkinnableActivityProcesser
    //   60: dup
    //   61: aload_0
    //   62: aload_0
    //   63: invokespecial 709	com/tencent/theme/SkinnableActivityProcesser:<init>	(Landroid/app/Activity;Lcom/tencent/theme/SkinnableActivityProcesser$Callback;)V
    //   66: putfield 704	com/tencent/mobileqq/pluginsdk/BasePluginActivity:processer	Lcom/tencent/theme/SkinnableActivityProcesser;
    //   69: aload_0
    //   70: invokestatic 715	com/tencent/mobileqq/pluginsdk/PluginStatic:add	(Lcom/tencent/mobileqq/pluginsdk/IPluginActivity;)V
    //   73: aload_0
    //   74: aload_1
    //   75: invokespecial 716	mqq/app/BaseActivity:onCreate	(Landroid/os/Bundle;)V
    //   78: aload_0
    //   79: invokevirtual 720	com/tencent/mobileqq/pluginsdk/BasePluginActivity:getIntent	()Landroid/content/Intent;
    //   82: ldc_w 722
    //   85: iconst_0
    //   86: invokevirtual 640	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   89: ifeq +12 -> 101
    //   92: aload_0
    //   93: aload_0
    //   94: getfield 65	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mOutActivity	Landroid/app/Activity;
    //   97: aload_0
    //   98: invokevirtual 726	com/tencent/mobileqq/pluginsdk/BasePluginActivity:readyPluginInterface	(Landroid/content/Context;Lcom/tencent/mobileqq/pluginsdk/PluginInterfaceHelper$OnPluginInterfaceLoadedListener;)V
    //   101: aload_0
    //   102: invokevirtual 728	com/tencent/mobileqq/pluginsdk/BasePluginActivity:initNavigationBarColor	()V
    //   105: return
    //   106: astore_2
    //   107: ldc 251
    //   109: iconst_1
    //   110: ldc_w 730
    //   113: aload_2
    //   114: invokestatic 622	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   117: goto -76 -> 41
    //   120: aload_0
    //   121: aload_1
    //   122: invokespecial 716	mqq/app/BaseActivity:onCreate	(Landroid/os/Bundle;)V
    //   125: aload_0
    //   126: aload_0
    //   127: putfield 69	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mActivity	Landroid/app/Activity;
    //   130: goto -29 -> 101
    //   133: astore_2
    //   134: goto -65 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	BasePluginActivity
    //   0	137	1	paramBundle	Bundle
    //   22	16	2	localWindow	Window
    //   106	8	2	localException1	Exception
    //   133	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   31	41	106	java/lang/Exception
    //   56	69	133	java/lang/Exception
  }
  
  public void onDestroy()
  {
    try
    {
      if ((this.jumpDialog != null) && (this.jumpDialog.isShowing())) {
        this.jumpDialog.dismiss();
      }
      if (this.mIsRunInPlugin)
      {
        if (this.processer != null)
        {
          this.processer.destory();
          this.processer = null;
        }
        this.mDexClassLoader = null;
        PluginStatic.remove(this);
        super.onDestroy();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("BasePluginActivity", 1, localThrowable, new Object[0]);
      }
      super.onDestroy();
    }
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
  
  public void onPause()
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
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramArrayOfInt.length == 0) {}
    List localList;
    do
    {
      return;
      localList = (List)this.mPermissionCallerMap.get(paramInt);
      if ((localList != null) && (localList.size() > 0))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          if (localObject != null) {
            if ((localObject instanceof QQPermissionCallback))
            {
              localObject = (QQPermissionCallback)localObject;
              ArrayList localArrayList = new ArrayList();
              int i = 0;
              while (i < paramArrayOfInt.length)
              {
                if (paramArrayOfInt[i] != 0) {
                  localArrayList.add(paramArrayOfString[i]);
                }
                i += 1;
              }
              if (localArrayList.size() > 0) {
                ((QQPermissionCallback)localObject).deny(paramInt, paramArrayOfString, paramArrayOfInt);
              } else {
                ((QQPermissionCallback)localObject).grant(paramInt, paramArrayOfString, paramArrayOfInt);
              }
            }
            else
            {
              QQPermissionHelper.requestResult(localObject, paramInt, paramArrayOfString, paramArrayOfInt);
            }
          }
        }
      }
    } while (localList == null);
    this.mPermissionCallerMap.remove(paramInt);
  }
  
  protected void onRestart()
  {
    if (this.mIsRunInPlugin)
    {
      super.onRestart();
      return;
    }
    super.onRestart();
  }
  
  public void onResume()
  {
    if (this.mIsRunInPlugin)
    {
      super.onResume();
      if ((IPluginAdapterProxy.getProxy().isNightMode()) && (this.mConfig.enableNight))
      {
        setNightMaskVisible(true);
        return;
      }
      setNightMaskVisible(false);
      return;
    }
    super.onResume();
  }
  
  public void onStart()
  {
    if (this.mIsRunInPlugin)
    {
      super.onStart();
      return;
    }
    super.onStart();
  }
  
  public void onStop()
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
      this.mActivity.overridePendingTransition(paramInt1, paramInt2);
      return;
    }
    super.overridePendingTransition(paramInt1, paramInt2);
  }
  
  protected final void readyPluginInterface(Context paramContext, PluginInterfaceHelper.OnPluginInterfaceLoadedListener paramOnPluginInterfaceLoadedListener)
  {
    PluginInterfaceHelper.getPluginInterface(paramContext, paramOnPluginInterfaceLoadedListener);
  }
  
  @TargetApi(24)
  public void requestPermissions(Object paramObject, int paramInt, String... paramVarArgs)
  {
    int k = 0;
    ArrayList localArrayList = new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject;
    while (i < j)
    {
      localObject = paramVarArgs[i];
      if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission((String)localObject) != 0)) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localObject = (List)this.mPermissionCallerMap.get(paramInt);
      paramVarArgs = (String[])localObject;
      if (localObject == null) {
        paramVarArgs = new ArrayList();
      }
      int m = paramVarArgs.size();
      i = 0;
      j = k;
      if (i < m)
      {
        localObject = paramVarArgs.get(i);
        if ((localObject != null) && (localObject == paramObject)) {
          j = 1;
        }
      }
      else
      {
        if (j == 0)
        {
          paramVarArgs.add(paramObject);
          this.mPermissionCallerMap.put(paramInt, paramVarArgs);
        }
        if ((!isShadow()) || (this.mOutActivity == null)) {
          break label232;
        }
        this.mOutActivity.requestPermissions((String[])localArrayList.toArray(new String[localArrayList.size()]), paramInt);
      }
    }
    label232:
    do
    {
      return;
      i += 1;
      break;
      requestPermissions((String[])localArrayList.toArray(new String[localArrayList.size()]), paramInt);
      return;
      if (!(paramObject instanceof QQPermissionCallback)) {
        break label292;
      }
      paramObject = (QQPermissionCallback)paramObject;
    } while (getApplicationInfo().targetSdkVersion >= 23);
    paramObject.grant(paramInt, paramVarArgs, null);
    return;
    label292:
    QQPermissionHelper.doExecuteSuccess(paramObject, paramInt);
  }
  
  public void setContentView(int paramInt)
  {
    if (this.mIsRunInPlugin)
    {
      this.mContentView = LayoutInflater.from(this.mContext).inflate(paramInt, null);
      if (!this.mIsTab) {
        this.mActivity.setContentView(this.mContentView);
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
        this.mActivity.setContentView(this.mContentView);
      }
      return;
    }
    super.setContentView(paramView);
  }
  
  public void setImmersiveConfig(BasePluginActivity.ImmersiveConfig paramImmersiveConfig)
  {
    this.mImmerConfit = paramImmersiveConfig;
  }
  
  public void setJumpDialog(Dialog paramDialog)
  {
    this.jumpDialog = paramDialog;
  }
  
  public void setNavigationBarColor(@ColorInt int paramInt)
  {
    if ((Build.VERSION.SDK_INT < 21) || (getWindow() == null)) {
      return;
    }
    try
    {
      getWindow().addFlags(-2147483648);
      getWindow().setNavigationBarColor(paramInt);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("plugin_tag", 1, "[NavigationBar] setNavigationBarColor Exception:", localException);
    }
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
      try
      {
        if ((this.mContext != null) && (this.mContext.getTheme() != null)) {
          this.mContext.getTheme().setTo(this.mOutActivity.getTheme());
        }
        if (getTheme() != null) {
          getTheme().setTo(this.mOutActivity.getTheme());
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("plugin_tag", 1, "setTheme Exception:", localException);
        return;
      }
    }
    super.setTheme(paramInt);
  }
  
  public void setTitle(int paramInt)
  {
    if (this.mIsRunInPlugin)
    {
      this.mActivity.setTitle(paramInt);
      return;
    }
    super.setTitle(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (this.mIsRunInPlugin)
    {
      this.mActivity.setTitle(paramCharSequence);
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
        if (!(this.mActivity instanceof PluginProxyActivity)) {
          break label162;
        }
        ((PluginProxyActivity)this.mActivity).startActivityForResult(paramIntent, paramInt);
        return;
        Object localObject = paramIntent.getComponent();
        bool1 = bool2;
        if (localObject == null) {
          break;
        }
        if (this.mOutActivity.getPackageName().equals(((ComponentName)localObject).getPackageName()))
        {
          localObject = this.mActivity.getPackageManager().queryIntentActivities(paramIntent, 65536);
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
      this.mActivity.startActivityForResult(paramIntent, paramInt);
      return;
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.BasePluginActivity
 * JD-Core Version:    0.7.0.1
 */