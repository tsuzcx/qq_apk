package cooperation.vip.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.mobile_monitor_report.ExceptionReport;
import cooperation.vip.pb.mobile_monitor_report.TraceReport;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class MonitorManager
  extends BroadcastReceiver
{
  private static MonitorManager jdField_a_of_type_CooperationVipManagerMonitorManager;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private List<mobile_monitor_report.ExceptionReport> jdField_a_of_type_JavaUtilList = new ArrayList();
  private long b;
  
  MonitorManager()
  {
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.plugin.state.change");
    BaseApplicationImpl.getApplication().registerReceiver(this, (IntentFilter)localObject);
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("monitor_manager", 4);
    this.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("max_size_out", 20);
    this.b = (((SharedPreferences)localObject).getLong("max_time_out", 30L) * 60L * 1000L);
  }
  
  public static MonitorManager a()
  {
    if (jdField_a_of_type_CooperationVipManagerMonitorManager == null) {
      try
      {
        if (jdField_a_of_type_CooperationVipManagerMonitorManager == null) {
          jdField_a_of_type_CooperationVipManagerMonitorManager = new MonitorManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_CooperationVipManagerMonitorManager;
  }
  
  private void a()
  {
    ThreadManager.getSubThreadHandler().post(new MonitorManager.2(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if (a(paramBoolean))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      b();
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool = true;
    if (paramBoolean) {
      return true;
    }
    int i;
    if (this.jdField_a_of_type_JavaUtilList.size() > this.jdField_a_of_type_Int) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > this.b) {
      j = 1;
    } else {
      j = 0;
    }
    paramBoolean = bool;
    if (i == 0)
    {
      if (j != 0) {
        return true;
      }
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      MonitorServlet.a(localArrayList);
      return;
    }
  }
  
  private void b(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    mobile_monitor_report.TraceReport localTraceReport = new mobile_monitor_report.TraceReport();
    localTraceReport.trace_id.set(String.valueOf(paramInt1));
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "";
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "";
    }
    localTraceReport.msg.set(paramString1);
    localTraceReport.trace_num.set(paramInt2);
    localTraceReport.page_id.set(str);
    paramString1 = new ArrayList();
    paramString1.add(localTraceReport);
    MonitorServlet.b(paramString1);
  }
  
  private void b(int paramInt1, int paramInt2, String arg3, boolean paramBoolean)
  {
    mobile_monitor_report.ExceptionReport localExceptionReport = new mobile_monitor_report.ExceptionReport();
    localExceptionReport.busi_id.set(paramInt1);
    localExceptionReport.errcode.set(paramInt2);
    String str = ???;
    if (TextUtils.isEmpty(???)) {
      str = "";
    }
    localExceptionReport.msg.set(str);
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(localExceptionReport);
      a(paramBoolean);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.b = paramInt1;
      this.b = (paramInt2 * 60 * 60);
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("monitor_manager", 4).edit();
      localEditor.putInt("max_size_out", paramInt1);
      localEditor.putInt("max_time_out", paramInt2);
      localEditor.apply();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("report trace ");
      ((StringBuilder)localObject).append(paramInt1);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" trace Num ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" page desc ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" trace Msg ");
      localStringBuilder.append(paramString2);
      QLog.e("MonitorManager", 1, new Object[] { localObject, localStringBuilder.toString() });
    }
    ThreadManager.getSubThreadHandler().post(new MonitorManager.3(this, paramInt1, paramInt2, paramString1, paramString2));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new MonitorManager.1(this, paramInt1, paramInt2, paramString, paramBoolean));
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext)) {
      return;
    }
    if (("com.tencent.plugin.state.change".equals(paramContext)) && (paramIntent.getIntExtra("key_plugin_state", 0) == 0))
    {
      QLog.i("MonitorManager", 1, "[onReceive] bg action");
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.manager.MonitorManager
 * JD-Core Version:    0.7.0.1
 */