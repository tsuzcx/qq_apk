package me.ele.uetool;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import me.ele.uetool.util.JarResource;
import me.ele.uetool.util.SettingsCompat;
import me.ele.uetool.view.BaseLineView;

public class UETool
{
  public static final String UI_ACTION = "UI_DEBUG_TOOL";
  private static volatile UETool instance;
  private static boolean interrupt = false;
  private static volatile boolean isShow = true;
  private static boolean isShowNow = false;
  private static BroadcastReceiver receiver;
  private Set<String> attrsProviderSet = new UETool.1(this);
  private BaseLineView baseLineView;
  private Application.ActivityLifecycleCallbacks callbacks = null;
  private int currentType = -1;
  private Set<String> filterClassesSet = new HashSet();
  private Class lastTimeActivityClassName = null;
  private volatile Activity targetActivity;
  private UETMenu uetMenu;
  
  private UETool()
  {
    isShow = me.ele.uetool.base.Application.getApplicationContext().getSharedPreferences("isShow_setting", 4).getBoolean("isShow", false);
    setReceiver();
  }
  
  private int dismissMenu()
  {
    if (this.uetMenu != null)
    {
      int i = this.uetMenu.dismiss();
      isShowNow = false;
      this.uetMenu = null;
      return i;
    }
    return -1;
  }
  
  public static int dismissUETMenu()
  {
    return getInstance().dismissMenu();
  }
  
  public static UETool getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new UETool();
      }
      return instance;
    }
    finally {}
  }
  
  public static boolean getIsShow()
  {
    return isShow;
  }
  
  private static boolean getIsShowFromSharePref()
  {
    isShow = me.ele.uetool.base.Application.getApplicationContext().getSharedPreferences("isShow_setting", 4).getBoolean("isShow", false);
    return isShow;
  }
  
  public static void initResource(Map paramMap)
  {
    JarResource.setNameIdMap(paramMap);
  }
  
  public static void putAttrsProviderClass(Class paramClass)
  {
    putAttrsProviderClass(paramClass.getName());
  }
  
  public static void putAttrsProviderClass(String paramString)
  {
    getInstance().putAttrsProviderClassName(paramString);
  }
  
  private void putAttrsProviderClassName(String paramString)
  {
    this.attrsProviderSet.add(paramString);
  }
  
  public static void putFilterClass(Class paramClass)
  {
    putFilterClass(paramClass.getName());
  }
  
  public static void putFilterClass(String paramString)
  {
    getInstance().putFilterClassName(paramString);
  }
  
  private void putFilterClassName(String paramString)
  {
    this.filterClassesSet.add(paramString);
  }
  
  public static void registerActivityLifecycleToShow()
  {
    getInstance().registerActivityLifecycle();
  }
  
  @TargetApi(23)
  private void requestPermission(Context paramContext)
  {
    SettingsCompat.manageDrawOverlays(paramContext);
  }
  
  private void sentBroadcastToShow(boolean paramBoolean)
  {
    Log.i("ContentValues", "sentBroadcastToShow: " + paramBoolean);
    Intent localIntent = new Intent();
    localIntent.setAction("UI_DEBUG_TOOL");
    localIntent.putExtra("show", paramBoolean);
    localIntent.putExtra("pid", Process.myPid());
    localIntent.putExtra("PackageName", me.ele.uetool.base.Application.getApplicationContext().getPackageName());
    me.ele.uetool.base.Application.getApplicationContext().sendBroadcast(localIntent);
  }
  
  public static void setIsShow(boolean paramBoolean)
  {
    isShow = paramBoolean;
    setSharePref(paramBoolean);
    if (paramBoolean) {
      showUETMenu();
    }
    for (;;)
    {
      setReceiver();
      return;
      dismissUETMenu();
    }
  }
  
  private static void setReceiver()
  {
    if ((isShow) && (receiver == null))
    {
      receiver = new UETool.2();
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("UI_DEBUG_TOOL");
      me.ele.uetool.base.Application.getApplicationContext().registerReceiver(receiver, localIntentFilter);
    }
    while ((isShow) || (receiver == null))
    {
      IntentFilter localIntentFilter;
      return;
    }
    me.ele.uetool.base.Application.getApplicationContext().unregisterReceiver(receiver);
    receiver = null;
  }
  
  private static void setSharePref(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = me.ele.uetool.base.Application.getApplicationContext().getSharedPreferences("isShow_setting", 4).edit();
    localEditor.putBoolean("isShow", paramBoolean);
    localEditor.commit();
  }
  
  private boolean showMenu()
  {
    return showMenu(1600);
  }
  
  private boolean showMenu(int paramInt)
  {
    if (!getIsShowFromSharePref()) {}
    do
    {
      return false;
      if ((Build.VERSION.SDK_INT >= 23) && (!Settings.canDrawOverlays(me.ele.uetool.base.Application.getApplicationContext())))
      {
        requestPermission(me.ele.uetool.base.Application.getApplicationContext());
        Toast.makeText(me.ele.uetool.base.Application.getApplicationContext(), "请授予权限", 1).show();
        return false;
      }
      if (this.uetMenu == null) {
        this.uetMenu = new UETMenu(me.ele.uetool.base.Application.getApplicationContext(), paramInt);
      }
    } while (this.uetMenu.isShown());
    this.uetMenu.show();
    interrupt = false;
    isShowNow = true;
    return true;
  }
  
  public static boolean showUETMenu()
  {
    return getInstance().showMenu();
  }
  
  public static boolean showUETMenu(int paramInt)
  {
    return getInstance().showMenu(paramInt);
  }
  
  public static void unregisterActivityLifecycleToHide()
  {
    getInstance().unregisterActivityLifecycle();
  }
  
  public Set<String> getAttrsProvider()
  {
    return this.attrsProviderSet;
  }
  
  public BaseLineView getBaseLineView()
  {
    return this.baseLineView;
  }
  
  public int getCurrentType()
  {
    return this.currentType;
  }
  
  public Set<String> getFilterClasses()
  {
    return this.filterClassesSet;
  }
  
  public Class getLastTimeActivityClassName()
  {
    return this.lastTimeActivityClassName;
  }
  
  public Activity getTargetActivity()
  {
    try
    {
      Activity localActivity = this.targetActivity;
      return localActivity;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public UETMenu getUetMenu()
  {
    return this.uetMenu;
  }
  
  public void registerActivityLifecycle()
  {
    this.callbacks = new UETool.LifeCallBack(null);
    ((android.app.Application)me.ele.uetool.base.Application.getApplicationContext()).registerActivityLifecycleCallbacks(this.callbacks);
  }
  
  void release()
  {
    this.targetActivity = null;
  }
  
  public void setBaseLineView(BaseLineView paramBaseLineView)
  {
    this.baseLineView = paramBaseLineView;
  }
  
  public void setCurrentType(int paramInt)
  {
    this.currentType = paramInt;
  }
  
  public void setLastTimeActivityClassName(Class paramClass)
  {
    this.lastTimeActivityClassName = paramClass;
  }
  
  public void setTargetActivity(Activity paramActivity)
  {
    try
    {
      this.targetActivity = paramActivity;
      return;
    }
    finally
    {
      paramActivity = finally;
      throw paramActivity;
    }
  }
  
  public void unregisterActivityLifecycle()
  {
    ((android.app.Application)me.ele.uetool.base.Application.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.callbacks);
    this.callbacks = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.UETool
 * JD-Core Version:    0.7.0.1
 */