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
  private static Boolean sIsLiquid;
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
  protected Activity mOutActivity = null;
  protected PackageInfo mPackageInfo;
  private SparseArray<List> mPermissionCallerMap = new SparseArray();
  protected String mPluginID;
  protected int mPluginResourcesType;
  protected boolean mUseSkinEngine = false;
  View mViewShadow;
  SkinnableActivityProcesser processer;
  
  public static final Bitmap getDrawableBitmap(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    if ((paramDrawable instanceof SkinnableBitmapDrawable)) {
      return ((SkinnableBitmapDrawable)paramDrawable).getBitmap();
    }
    return null;
  }
  
  public static boolean reflectHasAndIsNull(Object paramObject, String paramString, Class paramClass)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Class localClass;
    if (paramObject != null)
    {
      bool1 = bool2;
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
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = true;
        paramString.setAccessible(true);
        paramObject = paramString.get(paramObject);
        if (paramObject != null) {
          bool1 = false;
        }
      }
      return bool1;
    }
    catch (Exception paramObject) {}
    return false;
  }
  
  private void setNightMaskVisible(boolean paramBoolean)
  {
    Object localObject = this.mViewShadow;
    int i = 0;
    if (localObject != null)
    {
      if (!paramBoolean) {
        i = 8;
      }
      ((View)localObject).setVisibility(i);
      return;
    }
    if (paramBoolean == true)
    {
      localObject = new ImageView(this);
      ((ImageView)localObject).setImageDrawable(new ColorDrawable(Color.parseColor("#77000000")));
      ((ImageView)localObject).setPadding(0, this.mConfig.titleHeight, 0, 0);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
      ((ImageView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.mViewShadow = ((View)localObject);
      if (this.mViewShadow != null)
      {
        localObject = getWindow().getDecorView();
        if ((localObject instanceof ViewGroup))
        {
          localObject = (ViewGroup)localObject;
          localView = this.mViewShadow;
          ((ViewGroup)localObject).addView(localView, localView.getLayoutParams());
          return;
        }
        localObject = getWindow();
        View localView = this.mViewShadow;
        ((Window)localObject).addContentView(localView, localView.getLayoutParams());
      }
    }
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
    catch (Exception paramMotionEvent)
    {
      label8:
      break label8;
    }
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
    Context localContext = this.mContext;
    if (localContext != null) {
      return localContext.getResources();
    }
    return this.mActivity.getResources();
  }
  
  public void IInit(String paramString1, String paramString2, Activity paramActivity, ClassLoader paramClassLoader, PackageInfo paramPackageInfo, boolean paramBoolean, int paramInt)
  {
    if (DebugHelper.sDebug)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BasePluginActivity.Init:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.mPluginResourcesType);
      DebugHelper.log("plugin_tag", localStringBuilder.toString());
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
    if ((!sSkilEngineInit) && (paramBoolean))
    {
      paramInt = this.mPluginResourcesType;
      if ((paramInt == 1) || (paramInt == 2)) {}
    }
    try
    {
      SkinEngineInitBridge.init(this);
      sSkilEngineInit = true;
      return;
    }
    catch (Exception paramString1)
    {
      label203:
      break label203;
    }
    SkinEngine.getInstances().unInit();
    return;
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
    Object localObject = EventCollector.getInstance();
    boolean bool = true;
    ((EventCollector)localObject).onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    if (reflectHasAndIsNull(this, "mWindow", Activity.class))
    {
      if (paramMotionEvent.getAction() == 0) {
        onUserInteraction();
      }
      localObject = getWindow();
      if ((localObject == null) || (!((Window)localObject).superDispatchTouchEvent(paramMotionEvent))) {
        bool = onTouchEvent(paramMotionEvent);
      }
    }
    else
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public View findViewById(int paramInt)
  {
    if (this.mIsRunInPlugin)
    {
      View localView1 = this.mContentView;
      if (localView1 != null)
      {
        localView1 = localView1.findViewById(paramInt);
        if (localView1 == null) {
          try
          {
            View localView2 = super.findViewById(paramInt);
            return localView2;
          }
          catch (Exception localException)
          {
            DebugHelper.debug("plugin_tag", "findViewById", localException);
          }
        }
        return localView1;
      }
    }
    return super.findViewById(paramInt);
  }
  
  /* Error */
  public void finish()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mIsRunInPlugin	Z
    //   4: ifeq +135 -> 139
    //   7: iconst_0
    //   8: istore_2
    //   9: aconst_null
    //   10: astore 4
    //   12: aload_0
    //   13: monitorenter
    //   14: iload_2
    //   15: istore_1
    //   16: ldc 237
    //   18: ldc_w 479
    //   21: invokevirtual 121	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   24: astore_3
    //   25: iload_2
    //   26: istore_1
    //   27: aload_3
    //   28: iconst_1
    //   29: invokevirtual 127	java/lang/reflect/Field:setAccessible	(Z)V
    //   32: iload_2
    //   33: istore_1
    //   34: aload_3
    //   35: aload_0
    //   36: invokevirtual 131	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 481	java/lang/Integer
    //   42: invokevirtual 484	java/lang/Integer:intValue	()I
    //   45: istore_2
    //   46: iload_2
    //   47: istore_1
    //   48: ldc 237
    //   50: ldc_w 486
    //   53: invokevirtual 121	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   56: astore_3
    //   57: iload_2
    //   58: istore_1
    //   59: aload_3
    //   60: iconst_1
    //   61: invokevirtual 127	java/lang/reflect/Field:setAccessible	(Z)V
    //   64: iload_2
    //   65: istore_1
    //   66: aload_3
    //   67: aload_0
    //   68: invokevirtual 131	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 488	android/content/Intent
    //   74: astore_3
    //   75: goto +36 -> 111
    //   78: astore_3
    //   79: goto +56 -> 135
    //   82: astore 5
    //   84: iload_1
    //   85: istore_2
    //   86: aload 4
    //   88: astore_3
    //   89: getstatic 245	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   92: ifeq +19 -> 111
    //   95: ldc_w 266
    //   98: ldc_w 490
    //   101: aload 5
    //   103: invokestatic 492	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload 4
    //   108: astore_3
    //   109: iload_1
    //   110: istore_2
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_0
    //   114: getfield 61	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mOutActivity	Landroid/app/Activity;
    //   117: iload_2
    //   118: aload_3
    //   119: invokevirtual 496	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   122: aload_0
    //   123: getfield 61	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mOutActivity	Landroid/app/Activity;
    //   126: invokevirtual 497	android/app/Activity:finish	()V
    //   129: aload_0
    //   130: iconst_1
    //   131: putfield 67	com/tencent/mobileqq/pluginsdk/BasePluginActivity:mFinished	Z
    //   134: return
    //   135: aload_0
    //   136: monitorexit
    //   137: aload_3
    //   138: athrow
    //   139: aload_0
    //   140: invokespecial 498	mqq/app/BaseActivity:finish	()V
    //   143: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	BasePluginActivity
    //   15	95	1	i	int
    //   8	110	2	j	int
    //   24	51	3	localObject1	Object
    //   78	1	3	localObject2	Object
    //   88	50	3	localObject3	Object
    //   10	97	4	localObject4	Object
    //   82	20	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   16	25	78	finally
    //   27	32	78	finally
    //   34	46	78	finally
    //   48	57	78	finally
    //   59	64	78	finally
    //   66	75	78	finally
    //   89	106	78	finally
    //   111	113	78	finally
    //   135	137	78	finally
    //   16	25	82	java/lang/Exception
    //   27	32	82	java/lang/Exception
    //   34	46	82	java/lang/Exception
    //   48	57	82	java/lang/Exception
    //   59	64	82	java/lang/Exception
    //   66	75	82	java/lang/Exception
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
    Context localContext = this.mContext;
    if (localContext != null) {
      return LayoutInflater.from(localContext);
    }
    return LayoutInflater.from(this.mActivity);
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
    if ((!"window".equals(paramString)) && (!"search".equals(paramString)))
    {
      Context localContext = this.mContext;
      if (localContext != null) {
        return localContext.getSystemService(paramString);
      }
      return super.getSystemService(paramString);
    }
    if (this.mIsRunInPlugin) {
      return this.mOutActivity.getSystemService(paramString);
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
      if ((!bool1) && (bool2))
      {
        setNavigationBarColor(-16777216);
        return;
      }
      QLog.d("plugin_tag", 1, new Object[] { "[NavigationBar] disableNavigationBar=", Boolean.valueOf(bool1), " isNightMode=", Boolean.valueOf(bool2) });
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("plugin_tag", 1, "[NavigationBar] initNavigationBarColor=", localThrowable);
    }
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
    boolean bool2 = this.mIsRunInPlugin;
    boolean bool1 = true;
    if ((bool2) && (paramIntent != null))
    {
      if (paramIntent.hasExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY")) {
        return paramIntent.getBooleanExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      }
      ComponentName localComponentName = paramIntent.getComponent();
      if (localComponentName != null) {
        if (this.mOutActivity.getPackageName().equals(localComponentName.getPackageName()))
        {
          paramIntent = this.mActivity.getPackageManager().queryIntentActivities(paramIntent, 65536);
          if (paramIntent == null) {
            return bool1;
          }
          if (paramIntent.size() == 0) {
            return true;
          }
        }
        else if (getPackageName().equals(localComponentName.getPackageName()))
        {
          return true;
        }
      }
    }
    bool1 = false;
    return bool1;
  }
  
  boolean isSamePackage2(Intent paramIntent)
  {
    boolean bool3 = this.mIsRunInPlugin;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (paramIntent != null)
      {
        if (paramIntent.hasExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY")) {
          return paramIntent.getBooleanExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        }
        paramIntent = paramIntent.getComponent();
        bool1 = bool2;
        if (paramIntent != null)
        {
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
          if (getPackageName().equals(paramIntent.getPackageName())) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
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
  
  protected void onCreate(Bundle paramBundle)
  {
    if (this.mIsRunInPlugin)
    {
      this.mActivity = this.mOutActivity;
      Window localWindow = this.mActivity.getWindow();
      if (Build.VERSION.SDK_INT >= 26) {
        try
        {
          setProperty(this, Activity.class, "mWindow", localWindow);
        }
        catch (Exception localException1)
        {
          QLog.d("plugin_tag", 1, "setPluginWindow", localException1);
        }
      }
      onConfig(this.mConfig);
      if (this.processer != null) {}
    }
    try
    {
      this.processer = new SkinnableActivityProcesser(this, this);
    }
    catch (Exception localException2)
    {
      label87:
      break label87;
    }
    PluginStatic.add(this);
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("params_remote_connect_at_launch", false))
    {
      readyPluginInterface(this.mOutActivity, this);
      break label132;
      super.onCreate(paramBundle);
      this.mActivity = this;
    }
    label132:
    initNavigationBarColor();
  }
  
  protected void onDestroy()
  {
    try
    {
      if ((this.jumpDialog != null) && (this.jumpDialog.isShowing())) {
        this.jumpDialog.dismiss();
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BasePluginActivity", 1, localThrowable, new Object[0]);
    }
    if (this.mIsRunInPlugin)
    {
      SkinnableActivityProcesser localSkinnableActivityProcesser = this.processer;
      if (localSkinnableActivityProcesser != null)
      {
        localSkinnableActivityProcesser.destory();
        this.processer = null;
      }
      this.mDexClassLoader = null;
      PluginStatic.remove(this);
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
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramArrayOfInt.length == 0) {
      return;
    }
    List localList = (List)this.mPermissionCallerMap.get(paramInt);
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
    if (localList != null) {
      this.mPermissionCallerMap.remove(paramInt);
    }
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
  
  protected void onResume()
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
    ArrayList localArrayList = new ArrayList();
    int j = paramVarArgs.length;
    int k = 0;
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
    if (localArrayList.size() > 0)
    {
      localObject = (List)this.mPermissionCallerMap.get(paramInt);
      paramVarArgs = (String[])localObject;
      if (localObject == null) {
        paramVarArgs = new ArrayList();
      }
      int m = paramVarArgs.size();
      i = 0;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        localObject = paramVarArgs.get(i);
        if ((localObject != null) && (localObject == paramObject))
        {
          j = 1;
          break;
        }
        i += 1;
      }
      if (j == 0)
      {
        paramVarArgs.add(paramObject);
        this.mPermissionCallerMap.put(paramInt, paramVarArgs);
      }
      if (isShadow())
      {
        paramObject = this.mOutActivity;
        if (paramObject != null)
        {
          paramObject.requestPermissions((String[])localArrayList.toArray(new String[localArrayList.size()]), paramInt);
          return;
        }
      }
      requestPermissions((String[])localArrayList.toArray(new String[localArrayList.size()]), paramInt);
      return;
    }
    if ((paramObject instanceof QQPermissionCallback))
    {
      paramObject = (QQPermissionCallback)paramObject;
      if (getApplicationInfo().targetSdkVersion < 23) {
        paramObject.grant(paramInt, paramVarArgs, null);
      }
    }
    else
    {
      QQPermissionHelper.doExecuteSuccess(paramObject, paramInt);
    }
  }
  
  public void setContentView(int paramInt)
  {
    if (this.mIsRunInPlugin)
    {
      this.mContentView = LayoutInflater.from(this.mContext).inflate(paramInt, null);
      if (!this.mIsTab) {
        this.mActivity.setContentView(this.mContentView);
      }
    }
    else
    {
      super.setContentView(paramInt);
    }
  }
  
  public void setContentView(View paramView)
  {
    if (this.mIsRunInPlugin)
    {
      this.mContentView = paramView;
      if (!this.mIsTab) {
        this.mActivity.setContentView(this.mContentView);
      }
    }
    else
    {
      super.setContentView(paramView);
    }
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
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (getWindow() == null) {
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
        if (getTheme() == null) {
          return;
        }
        getTheme().setTo(this.mOutActivity.getTheme());
        return;
      }
      catch (Exception localException)
      {
        QLog.e("plugin_tag", 1, "setTheme Exception:", localException);
        return;
      }
    }
    else
    {
      super.setTheme(paramInt);
    }
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
      label6:
      break label6;
    }
    startActivityForResult(paramIntent, -1);
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    try
    {
      super.startActivity(paramIntent, paramBundle);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      label7:
      break label7;
    }
    startActivityForResult(paramIntent, -1, paramBundle);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (this.mIsRunInPlugin)
    {
      boolean bool1 = paramIntent.hasExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY");
      boolean bool2 = false;
      if (bool1)
      {
        bool1 = paramIntent.getBooleanExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      }
      else
      {
        localObject = paramIntent.getComponent();
        bool1 = bool2;
        if (localObject != null)
        {
          if (this.mOutActivity.getPackageName().equals(((ComponentName)localObject).getPackageName()))
          {
            localObject = this.mActivity.getPackageManager().queryIntentActivities(paramIntent, 65536);
            if (localObject != null)
            {
              bool1 = bool2;
              if (((List)localObject).size() != 0) {
                break label123;
              }
            }
          }
          else
          {
            bool1 = bool2;
            if (!getPackageName().equals(((ComponentName)localObject).getPackageName())) {
              break label123;
            }
          }
          bool1 = true;
        }
      }
      label123:
      if (bool1) {
        paramIntent.putExtra("pluginsdk_IsPluginActivity", true);
      }
      Object localObject = this.mActivity;
      if ((localObject instanceof PluginProxyActivity))
      {
        ((PluginProxyActivity)localObject).startActivityForResult(paramIntent, paramInt);
        return;
      }
      ((Activity)localObject).startActivityForResult(paramIntent, paramInt);
      return;
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.BasePluginActivity
 * JD-Core Version:    0.7.0.1
 */