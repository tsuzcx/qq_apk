package com.tencent.mobileqq.webview.api.impl;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.data.SonicPreloadData;
import com.tencent.mobileqq.webview.util.WebProcessStartListener;
import com.tencent.mobileqq.webview.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class WebProcessManagerServiceImpl
  implements IWebProcessManagerService
{
  private static final int BIG_MEMORY = 1024;
  private static final int RED_POINT_MEMORY = 512;
  private static final String TAG = "WebProcessStartServiceImpl";
  private static final AtomicBoolean sRunningStartWebProcess = new AtomicBoolean(false);
  private static final ConcurrentHashMap<String, Integer> webProcessBuffer = new ConcurrentHashMap();
  private AppRuntime app;
  private boolean mIsRegistered = false;
  protected BroadcastReceiver mReceiver = new WebProcessManagerServiceImpl.3(this);
  private long totalMemSize;
  
  private static boolean isPreloadSuccess()
  {
    return MobileQQ.getContext().getSharedPreferences("web_process_preload_file", 4).getBoolean("key_preload", false);
  }
  
  private void registerReceiver()
  {
    if ((this.mReceiver != null) && (!this.mIsRegistered)) {
      this.mIsRegistered = true;
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.webprocess.restart_web_process");
      localIntentFilter.addAction("com.tencent.mobileqq.webprocess.report");
      MobileQQ.getContext().registerReceiver(this.mReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void reportHitRate()
  {
    if (isPreloadSuccess())
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessStartServiceImpl", 2, "isPreloadSucess");
      }
      ReportController.b(null, "P_CliOper", "Vip", "", "0X8004874", "0X8004874", 0, 1, 0, "", "", "", "");
    }
    for (;;)
    {
      setPreloadSuccess(false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessStartServiceImpl", 2, "isPreloadFail");
      }
      ReportController.b(null, "P_CliOper", "Vip", "", "0X8004875", "0X8004875", 0, 1, 0, "", "", "", "");
    }
  }
  
  private void restartWebProcess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessStartServiceImpl", 2, "restartWebProcess");
    }
    new Handler().postDelayed(new WebProcessManagerServiceImpl.2(this), 800L);
  }
  
  public static void setPreloadSuccess(boolean paramBoolean)
  {
    MobileQQ.getContext().getSharedPreferences("web_process_preload_file", 4).edit().putBoolean("key_preload", paramBoolean).commit();
  }
  
  private void unregisterReceiver()
  {
    if ((this.mReceiver != null) && (this.mIsRegistered)) {}
    try
    {
      this.mIsRegistered = false;
      MobileQQ.getContext().unregisterReceiver(this.mReceiver);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean enablePreloadInBusiness(int paramInt)
  {
    boolean bool = true;
    Integer[] arrayOfInteger = WebAccelerateHelper.getInstance().getWebViewFeatureParams();
    if ((paramInt >= arrayOfInteger.length) || (paramInt < 0))
    {
      QLog.e("WebProcessStartServiceImpl", 1, new Object[] { "can not preload tool process for businessId=", Integer.valueOf(paramInt) });
      bool = false;
    }
    do
    {
      return bool;
      if (arrayOfInteger[paramInt].intValue() == 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("WebProcessStartServiceImpl", 2, "now enable preload tool process for businessId=" + paramInt);
    return true;
    QLog.e("WebProcessStartServiceImpl", 1, new Object[] { "can not preload tool process for businessId=", Integer.valueOf(paramInt) });
    return false;
  }
  
  public boolean isNeedPreloadWebProcess()
  {
    Integer localInteger = (Integer)webProcessBuffer.get("key_preload_strategy");
    if ((localInteger != null) && (localInteger.intValue() == 2))
    {
      localInteger = (Integer)webProcessBuffer.get("key_preload_flag");
      if ((localInteger != null) && (localInteger.intValue() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessStartServiceImpl", 2, "is need prload, totalMemSize = " + this.totalMemSize + "M");
        }
        localInteger = (Integer)webProcessBuffer.get("key_red_ram");
        return (localInteger != null) && (this.totalMemSize > localInteger.intValue());
      }
      return false;
    }
    return true;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
    updatePreloadWebProcessFlag();
    registerReceiver();
    this.totalMemSize = (DeviceInfoUtil.a() / 1048576L);
  }
  
  public void onDestroy()
  {
    unregisterReceiver();
  }
  
  public boolean preloadSonicSession(ArrayList<SonicPreloadData> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 1)) {
      return false;
    }
    if (!new SonicPreloaderServiceImpl().enablePreloadSonic()) {
      return false;
    }
    if (((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist())
    {
      Intent localIntent = new Intent(MobileQQ.getContext(), WebProcessReceiver.class);
      localIntent.setAction("action_preload_sonic_session");
      localIntent.putParcelableArrayListExtra("com.tencent.mobileqq.webprocess.sonic_preload_data", paramArrayList);
      try
      {
        MobileQQ.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
        return true;
      }
      catch (Exception paramArrayList)
      {
        QLog.e("WebProcessStartServiceImpl", 2, "preloadSonicSession, sendBroadcast exception, e = ", paramArrayList);
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessStartServiceImpl", 2, "preloadSonicSession, web process not exists");
    }
    return false;
  }
  
  public void startWebProcess(int paramInt, WebProcessStartListener paramWebProcessStartListener)
  {
    if (sRunningStartWebProcess.compareAndSet(false, true)) {
      ThreadManager.excute(new WebProcessManagerServiceImpl.WebProcessPreloadJob(paramInt, paramWebProcessStartListener, this), 128, null, false);
    }
    while (paramWebProcessStartListener == null) {
      return;
    }
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      paramWebProcessStartListener.onResult(false);
      return;
    }
    ThreadManager.excute(new WebProcessManagerServiceImpl.1(this, paramWebProcessStartListener), 128, null, false);
  }
  
  public void updatePreloadWebProcessFlag()
  {
    int i = 1;
    webProcessBuffer.clear();
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("web_process_preload_file", 4);
    webProcessBuffer.put("key_preload_strategy", Integer.valueOf(localSharedPreferences.getInt("key_preload_strategy" + this.app.getAccount(), 1)));
    ConcurrentHashMap localConcurrentHashMap = webProcessBuffer;
    if (localSharedPreferences.getBoolean("key_preload_flag" + this.app.getAccount(), false)) {}
    for (;;)
    {
      localConcurrentHashMap.put("key_preload_flag", Integer.valueOf(i));
      webProcessBuffer.put("key_red_ram", Integer.valueOf(localSharedPreferences.getInt("key_red_ram" + this.app.getAccount(), 512)));
      webProcessBuffer.put("key_click_ram", Integer.valueOf(localSharedPreferences.getInt("key_click_ram" + this.app.getAccount(), 1024)));
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.api.impl.WebProcessManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */