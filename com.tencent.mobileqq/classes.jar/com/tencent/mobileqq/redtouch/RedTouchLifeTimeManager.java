package com.tencent.mobileqq.redtouch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Foreground;
import mqq.app.QActivityLifecycleCallbacks;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class RedTouchLifeTimeManager
  extends BroadcastReceiver
{
  private static RedTouchLifeTimeManager b;
  QActivityLifecycleCallbacks a = new RedTouchLifeTimeManager.2(this);
  private String c;
  private boolean d = false;
  private String e;
  private long f;
  private String g;
  private String h;
  
  private RedTouchLifeTimeManager()
  {
    b();
  }
  
  public static RedTouchLifeTimeManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new RedTouchLifeTimeManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void b()
  {
    Foreground.addActivityLifeCallback(this.a);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.plugin.state.change");
    BaseApplicationImpl.getApplication().registerReceiver(this, localIntentFilter);
  }
  
  private void c()
  {
    if (!this.d) {
      return;
    }
    this.d = false;
    long l = System.currentTimeMillis() - this.f;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("triggleReport time = ");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append(" class name ");
    ((StringBuilder)localObject).append(this.c);
    QLog.i("RedTouchLifeTimeManager", 1, ((StringBuilder)localObject).toString());
    localObject = new TianShuReportData();
    ((TianShuReportData)localObject).p = 133;
    ((TianShuReportData)localObject).q = ((int)l);
    ((TianShuReportData)localObject).h = String.valueOf(this.g);
    ((TianShuReportData)localObject).b = String.valueOf(this.h);
    ((TianShuReportData)localObject).c = 1;
    ((TianShuReportData)localObject).o = (NetConnInfoCenter.getServerTimeMillis() / 1000L);
    ((TianShuReportData)localObject).f = "vab_red";
    ((TianShuReportData)localObject).g = "vab_red";
    ThreadManager.getSubThreadHandler().post(new RedTouchLifeTimeManager.1(this, (TianShuReportData)localObject));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.g = paramString.getString("ad_id");
      this.h = paramString.getString("trace_id");
      this.d = true;
      this.f = System.currentTimeMillis();
      if ((TextUtils.isEmpty(this.c)) && (Foreground.getTopActivity() != null)) {
        this.c = Foreground.getTopActivity().getClass().getName();
      }
      this.e = this.c;
      paramString = new StringBuilder();
      paramString.append(" triggleWhenRedClick class name ");
      paramString.append(this.c);
      QLog.i("RedTouchLifeTimeManager", 1, paramString.toString());
      return;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("triggleWhenRedClick");
      localStringBuilder.append(paramString);
      QLog.e("RedTouchLifeTimeManager", 1, localStringBuilder.toString());
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext)) {
      return;
    }
    if (("com.tencent.plugin.state.change".equals(paramContext)) && (paramIntent.getIntExtra("key_plugin_state", 0) == 0))
    {
      QLog.i("RedTouchLifeTimeManager", 1, "[onReceive] bg action");
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchLifeTimeManager
 * JD-Core Version:    0.7.0.1
 */