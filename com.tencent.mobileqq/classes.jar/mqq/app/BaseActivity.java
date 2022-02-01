package mqq.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class BaseActivity
  extends Activity
{
  public static Locale locale;
  public static int localeId;
  private AppRuntime app;
  private boolean isResume;
  AndroidOreoUtils mAndroidOreoUtils;
  protected boolean mIsShadow;
  private SparseArray<List> mPermissionCallerMap = new SparseArray();
  private AppRuntime mProcRuntime;
  private MobileQQ mqq;
  
  private boolean isActivityLocaleUpdated(Locale paramLocale)
  {
    if ((locale == null) || (paramLocale == null)) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return false;
      bool1 = locale.getLanguage().equals(paramLocale.getLanguage());
      bool2 = locale.getCountry().equals(paramLocale.getCountry());
    } while ((bool1) && (bool2));
    return true;
  }
  
  private boolean isLocaleCN()
  {
    return localeId == 2052;
  }
  
  @TargetApi(11)
  private void recreateOnLocaleUpdate()
  {
    if (isActivityLocaleUpdated(getResources().getConfiguration().locale)) {
      recreate();
    }
  }
  
  public boolean bindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 2);
    return super.bindService(paramIntent, paramServiceConnection, paramInt);
  }
  
  public int checkSelfPermission(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return super.checkSelfPermission(paramString);
    }
    return 0;
  }
  
  protected boolean compatibleAndroidOreo()
  {
    return true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public final AppRuntime getAppRuntime()
  {
    return this.app;
  }
  
  protected String getModuleId()
  {
    return null;
  }
  
  public Resources getResources()
  {
    if ((this.mIsShadow) || (isLocaleCN())) {
      return super.getResources();
    }
    return getApplicationContext().getResources();
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  protected boolean isLatecyWaitRuntime()
  {
    return false;
  }
  
  public final boolean isResume()
  {
    return this.isResume;
  }
  
  protected boolean isShadow()
  {
    return false;
  }
  
  protected void onAccountChanged() {}
  
  protected void onAccoutChangeFailed() {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.mAndroidOreoUtils = new AndroidOreoUtils(this);
    if ((Build.VERSION.SDK_INT == 26) && (compatibleAndroidOreo()) && (getApplicationInfo().targetSdkVersion >= 27) && (this.mAndroidOreoUtils.isTranslucentOrFloating()))
    {
      boolean bool = this.mAndroidOreoUtils.fixOrientation();
      QLog.i("mqq", 1, "onCreate fixOrientation when Oreo, result = " + bool);
    }
    onCreateNoRuntime(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("mqq", 2, "[Activity]" + getClass().getSimpleName() + " onCreate");
    }
    if (!isLatecyWaitRuntime()) {
      waitAppRuntime();
    }
    if (isActivityLocaleUpdated(getResources().getConfiguration().locale))
    {
      paramBundle = getResources();
      Configuration localConfiguration = paramBundle.getConfiguration();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      localDisplayMetrics.setTo(paramBundle.getDisplayMetrics());
      localConfiguration.locale = locale;
      paramBundle.updateConfiguration(localConfiguration, paramBundle.getDisplayMetrics());
      paramBundle.getDisplayMetrics().setTo(localDisplayMetrics);
    }
  }
  
  protected void onCreateNoRuntime(Bundle paramBundle)
  {
    this.mIsShadow = isShadow();
    if (!this.mIsShadow) {
      super.onCreate(paramBundle);
    }
    if (QLog.isColorLevel()) {
      QLog.i("mqq", 2, "[Activity]" + getClass().getSimpleName() + " onCreateNoRuntime");
    }
    this.mqq = MobileQQ.getMobileQQ();
    this.mqq.addActivity(this);
  }
  
  protected void onDestroy()
  {
    if (!this.mIsShadow) {
      super.onDestroy();
    }
    if (QLog.isColorLevel()) {
      QLog.i("mqq", 2, "[Activity]" + getClass().getSimpleName() + " onDestroy");
    }
    this.mqq.removeActivity(this);
    this.mqq = null;
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    finish();
  }
  
  protected void onPause()
  {
    if (!this.mIsShadow) {
      super.onPause();
    }
    this.isResume = false;
  }
  
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
  
  protected void onResume()
  {
    if (!this.mIsShadow) {
      super.onResume();
    }
    this.isResume = true;
  }
  
  protected void onStart()
  {
    if (!this.mIsShadow)
    {
      super.onStart();
      recreateOnLocaleUpdate();
    }
  }
  
  protected void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.i("mqq", 2, "[Activity]" + getClass().getSimpleName() + " onStop");
    }
    if (!this.mIsShadow) {
      super.onStop();
    }
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
      for (;;)
      {
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
          requestPermissions((String[])localArrayList.toArray(new String[localArrayList.size()]), paramInt);
          return;
        }
        i += 1;
      }
    }
    if ((paramObject instanceof QQPermissionCallback))
    {
      ((QQPermissionCallback)paramObject).grant(paramInt, paramVarArgs, null);
      return;
    }
    QQPermissionHelper.doExecuteSuccess(paramObject, paramInt);
  }
  
  public void sendBroadcast(Intent paramIntent)
  {
    MobileQQ.restrictBroadcast(paramIntent);
    super.sendBroadcast(paramIntent);
  }
  
  public void sendBroadcast(Intent paramIntent, String paramString)
  {
    MobileQQ.restrictBroadcast(paramIntent);
    super.sendBroadcast(paramIntent, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString)
  {
    MobileQQ.restrictBroadcast(paramIntent);
    super.sendOrderedBroadcast(paramIntent, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle)
  {
    MobileQQ.restrictBroadcast(paramIntent);
    super.sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
  }
  
  void setAppRuntime(AppRuntime paramAppRuntime)
  {
    this.mProcRuntime = paramAppRuntime;
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime != null) {
      localAppRuntime = paramAppRuntime.getAppRuntime(getModuleId());
    }
    this.app = localAppRuntime;
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if ((Build.VERSION.SDK_INT == 26) && (compatibleAndroidOreo()) && (getApplicationInfo().targetSdkVersion >= 27) && (this.mAndroidOreoUtils.isTranslucentOrFloating()) && (this.mAndroidOreoUtils.isFixedOrientation(this.mAndroidOreoUtils.getCurrentActivityInfo(), paramInt)))
    {
      QLog.i("mqq", 1, "avoid calling setRequestedOrientation when Oreo.");
      return;
    }
    super.setRequestedOrientation(paramInt);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (!this.mIsShadow)
    {
      paramIntent.putExtra("preAct", getClass().getSimpleName());
      paramIntent.putExtra("preAct_time", System.currentTimeMillis());
    }
    FileProvider7Helper.intentCompatForN(getApplicationContext(), paramIntent);
    ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 0);
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 1);
    return super.startService(paramIntent);
  }
  
  public final void superFinish()
  {
    super.finish();
  }
  
  public AppRuntime waitAppRuntime()
  {
    AppRuntime localAppRuntime = this.mqq.waitAppRuntime(this);
    if (localAppRuntime == null) {
      return null;
    }
    this.mProcRuntime = localAppRuntime;
    this.app = localAppRuntime.getAppRuntime(getModuleId());
    return this.app;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.BaseActivity
 * JD-Core Version:    0.7.0.1
 */