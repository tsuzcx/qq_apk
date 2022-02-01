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
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.data.SonicPreloadData;
import com.tencent.mobileqq.webview.util.WebProcessStartListener;
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
    if ((this.mReceiver != null) && (!this.mIsRegistered))
    {
      this.mIsRegistered = true;
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
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessStartServiceImpl", 2, "isPreloadFail");
      }
      ReportController.b(null, "P_CliOper", "Vip", "", "0X8004875", "0X8004875", 0, 1, 0, "", "", "", "");
    }
    setPreloadSuccess(false);
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
    if ((this.mReceiver != null) && (this.mIsRegistered)) {
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
  }
  
  public boolean enablePreloadInBusiness(int paramInt)
  {
    Object localObject = WebAccelerateHelper.getInstance().getWebViewFeatureParams();
    if ((paramInt < localObject.length) && (paramInt >= 0))
    {
      if (localObject[paramInt].intValue() != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("now enable preload tool process for businessId=");
          ((StringBuilder)localObject).append(paramInt);
          QLog.i("WebProcessStartServiceImpl", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
      QLog.e("WebProcessStartServiceImpl", 1, new Object[] { "can not preload tool process for businessId=", Integer.valueOf(paramInt) });
      return false;
    }
    QLog.e("WebProcessStartServiceImpl", 1, new Object[] { "can not preload tool process for businessId=", Integer.valueOf(paramInt) });
    return false;
  }
  
  public boolean isNeedPreloadWebProcess()
  {
    Object localObject = (Integer)webProcessBuffer.get("key_preload_strategy");
    if ((localObject != null) && (((Integer)localObject).intValue() == 2))
    {
      localObject = (Integer)webProcessBuffer.get("key_preload_flag");
      if ((localObject != null) && (((Integer)localObject).intValue() == 1))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("is need prload, totalMemSize = ");
          ((StringBuilder)localObject).append(this.totalMemSize);
          ((StringBuilder)localObject).append("M");
          QLog.d("WebProcessStartServiceImpl", 2, ((StringBuilder)localObject).toString());
        }
        localObject = (Integer)webProcessBuffer.get("key_red_ram");
        return (localObject != null) && (this.totalMemSize > ((Integer)localObject).intValue());
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
    if (paramArrayList != null)
    {
      if (paramArrayList.size() < 1) {
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
    }
    return false;
  }
  
  public void startWebProcess(int paramInt, WebProcessStartListener paramWebProcessStartListener)
  {
    if (sRunningStartWebProcess.compareAndSet(false, true))
    {
      ThreadManager.excute(new WebProcessManagerServiceImpl.WebProcessPreloadJob(paramInt, paramWebProcessStartListener, this), 128, null, false);
      return;
    }
    if (paramWebProcessStartListener != null)
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread())
      {
        paramWebProcessStartListener.onResult(false);
        return;
      }
      ThreadManager.excute(new WebProcessManagerServiceImpl.1(this, paramWebProcessStartListener), 128, null, false);
    }
  }
  
  public void updatePreloadWebProcessFlag()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.api.impl.WebProcessManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */