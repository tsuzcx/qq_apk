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
  private static RedTouchLifeTimeManager jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchLifeTimeManager = null;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  QActivityLifecycleCallbacks jdField_a_of_type_MqqAppQActivityLifecycleCallbacks = new RedTouchLifeTimeManager.2(this);
  private boolean jdField_a_of_type_Boolean = false;
  private String b;
  private String c;
  private String d;
  
  private RedTouchLifeTimeManager()
  {
    a();
  }
  
  public static RedTouchLifeTimeManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchLifeTimeManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchLifeTimeManager == null) {
        jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchLifeTimeManager = new RedTouchLifeTimeManager();
      }
      return jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchLifeTimeManager;
    }
    finally {}
  }
  
  private void a()
  {
    Foreground.addActivityLifeCallback(this.jdField_a_of_type_MqqAppQActivityLifecycleCallbacks);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.plugin.state.change");
    BaseApplicationImpl.getApplication().registerReceiver(this, localIntentFilter);
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    QLog.i("RedTouchLifeTimeManager", 1, "triggleReport time = " + l + " class name " + this.jdField_a_of_type_JavaLangString);
    TianShuReportData localTianShuReportData = new TianShuReportData();
    localTianShuReportData.d = 133;
    localTianShuReportData.jdField_e_of_type_Int = ((int)l);
    localTianShuReportData.g = String.valueOf(this.c);
    localTianShuReportData.b = String.valueOf(this.d);
    localTianShuReportData.jdField_a_of_type_Int = 1;
    localTianShuReportData.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTimeMillis() / 1000L);
    localTianShuReportData.jdField_e_of_type_JavaLangString = "vab_red";
    localTianShuReportData.f = "vab_red";
    ThreadManager.getSubThreadHandler().post(new RedTouchLifeTimeManager.1(this, localTianShuReportData));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.c = paramString.getString("ad_id");
      this.d = paramString.getString("trace_id");
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (Foreground.getTopActivity() != null)) {
        this.jdField_a_of_type_JavaLangString = Foreground.getTopActivity().getClass().getName();
      }
      this.b = this.jdField_a_of_type_JavaLangString;
      QLog.i("RedTouchLifeTimeManager", 1, " triggleWhenRedClick class name " + this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("RedTouchLifeTimeManager", 1, "triggleWhenRedClick" + paramString);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext)) {}
    while ((!"com.tencent.plugin.state.change".equals(paramContext)) || (paramIntent.getIntExtra("key_plugin_state", 0) != 0)) {
      return;
    }
    QLog.i("RedTouchLifeTimeManager", 1, "[onReceive] bg action");
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchLifeTimeManager
 * JD-Core Version:    0.7.0.1
 */