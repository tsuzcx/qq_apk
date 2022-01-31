package cooperation.wadl.ipc;

import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.text.TextUtils;
import angk;
import angl;
import angm;
import angn;
import ango;
import angp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.wadl.WLog;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class WadlProxyServiceManager
{
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new angm(this);
  public Handler a;
  private IBinder.DeathRecipient jdField_a_of_type_AndroidOsIBinder$DeathRecipient = new angl(this);
  private angp jdField_a_of_type_Angp;
  private IWadlProxyServiceMonitor jdField_a_of_type_CooperationWadlIpcIWadlProxyServiceMonitor;
  private IWadlService jdField_a_of_type_CooperationWadlIpcIWadlService;
  private IWadlServiceCallBack jdField_a_of_type_CooperationWadlIpcIWadlServiceCallBack = new ango(this);
  private List jdField_a_of_type_JavaUtilList = new Vector();
  private CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  public boolean a;
  
  public WadlProxyServiceManager(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    paramAppRuntime = new HandlerThread("WadlClientMessage.Thread", 10);
    paramAppRuntime.start();
    this.jdField_a_of_type_Angp = new angp(this, paramAppRuntime.getLooper());
    paramAppRuntime = new HandlerThread("WadlClientJob.Thread", 10);
    paramAppRuntime.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramAppRuntime.getLooper());
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_CooperationWadlIpcIWadlProxyServiceMonitor = new WadlProxyServiceMonitor(this);
  }
  
  private void b(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 100)
    {
      WLog.a("WadlProxyServiceManager", "##@there must be an error too many unproceed message!");
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramBundle);
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_CooperationWadlIpcIWadlProxyServiceMonitor != null) {
      return this.jdField_a_of_type_CooperationWadlIpcIWadlProxyServiceMonitor.a();
    }
    return false;
  }
  
  private void c(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      paramBundle = (WadlResult)paramBundle.getParcelable("download_result");
      WLog.b("WadlProxyServiceManager", "downloadActionCallback params:" + paramBundle + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      if (paramBundle != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (localIterator.hasNext()) {
          ((WadlProxyServiceCallBackInterface)localIterator.next()).b(paramBundle);
        }
      }
    }
    else
    {
      WLog.a("WadlProxyServiceManager", "callBackList is null");
    }
  }
  
  private void d()
  {
    Message localMessage = this.jdField_a_of_type_Angp.obtainMessage();
    localMessage.what = 2;
    this.jdField_a_of_type_Angp.sendMessage(localMessage);
  }
  
  private void d(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
      WLog.b("WadlProxyServiceManager", "onQueryCallback params:" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      paramBundle = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramBundle.hasNext()) {
        ((WadlProxyServiceCallBackInterface)paramBundle.next()).a(localArrayList);
      }
    }
    WLog.a("WadlProxyServiceManager", "callBackList is null");
  }
  
  private void e(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
      WLog.b("WadlProxyServiceManager", "onQueryCallbackVia params" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      paramBundle = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramBundle.hasNext()) {
        ((WadlProxyServiceCallBackInterface)paramBundle.next()).b(localArrayList);
      }
    }
    WLog.a("WadlProxyServiceManager", "callBackList is null");
  }
  
  private void f(Bundle paramBundle)
  {
    String str = paramBundle.getString("report_oper_id");
    Object localObject = paramBundle.getString("report_sso_event");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      WebSSOAgent.UniSsoServerReqComm localUniSsoServerReqComm = new WebSSOAgent.UniSsoServerReqComm();
      localUniSsoServerReqComm.platform.set(109L);
      localUniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
      localUniSsoServerReqComm.mqqver.set("7.6.3");
      paramBundle = new WebSSOAgent.UniSsoServerReq();
      paramBundle.comm.set(localUniSsoServerReqComm);
      paramBundle.reqdata.set((String)localObject);
      localObject = new NewIntent(BaseApplicationImpl.getContext(), WebSSOAgentServlet.class);
      ((NewIntent)localObject).putExtra("extra_cmd", "DownloaderReport.DownloaderMsg");
      ((NewIntent)localObject).putExtra("extra_data", paramBundle.toByteArray());
      ((NewIntent)localObject).putExtra("extra_timeout", 5000L);
      ((NewIntent)localObject).setObserver(new angn(this, str));
      this.jdField_a_of_type_MqqAppAppRuntime.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramBundle)
    {
      WLog.a("WadlProxyServiceManager", "onReportDownloadEvent exception:" + paramBundle.toString());
    }
  }
  
  public Bundle a(Bundle paramBundle)
  {
    String str = paramBundle.getString("WADL.REVERSE_ACTION_CMD_NAME");
    if (QLog.isColorLevel()) {
      WLog.b("WadlProxyServiceManager", "onRemoteReverseInvoke begin cmd=" + str);
    }
    if (str == null) {
      return paramBundle;
    }
    if (str.equals("Wadl_Reverse_StartWadlService"))
    {
      a();
      return paramBundle;
    }
    if (str.equals("Wadl_Reverse_onWadlTaskStatusChanged"))
    {
      c(paramBundle);
      return paramBundle;
    }
    if (str.equals("Wadl_Reverse_QnQureyResult"))
    {
      d(paramBundle);
      return paramBundle;
    }
    if (str.equals("Wadl_Reverse_QnQureyResultVia"))
    {
      e(paramBundle);
      return paramBundle;
    }
    if (str.equals("Wadl_Reverse_Report_Event"))
    {
      f(paramBundle);
      return paramBundle;
    }
    WLog.a("WadlProxyServiceManager", "onRemoteReverseInvoke unknow invokeCmd");
    return paramBundle;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    Message localMessage = this.jdField_a_of_type_Angp.obtainMessage();
    localMessage.what = 1;
    this.jdField_a_of_type_Angp.sendMessage(localMessage);
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_CooperationWadlIpcIWadlProxyServiceMonitor != null) {
      this.jdField_a_of_type_CooperationWadlIpcIWadlProxyServiceMonitor.a(paramBundle);
    }
  }
  
  public void a(Bundle paramBundle, boolean paramBoolean)
  {
    String str = paramBundle.getString("WADL.REMOTE_NOTIFY_CMD_NAME");
    WLog.a("WadlProxyServiceManager", 4, "send action msg cmd=" + str);
    if ((!a()) && (paramBoolean))
    {
      WLog.a("WadlProxyServiceManager", "postRemoteNotify start but service is not launched and start service");
      b();
    }
    b(paramBundle);
    d();
  }
  
  public void a(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface)
  {
    if ((paramWadlProxyServiceCallBackInterface != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramWadlProxyServiceCallBackInterface))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramWadlProxyServiceCallBackInterface);
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      QLog.d("WadlProxyServiceManager", 4, "updateAppRuntime account=" + paramAppRuntime.getAccount());
      this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_CooperationWadlIpcIWadlService != null) && (!this.jdField_a_of_type_Boolean);
  }
  
  public void b()
  {
    WLog.b("WadlProxyServiceManager", "innerStartService start");
    if (this.jdField_a_of_type_CooperationWadlIpcIWadlService != null)
    {
      if (QLog.isColorLevel()) {
        WLog.b("WadlProxyServiceManager", "innerStartService:mWadlService is working");
      }
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("##@innerStartService:mWadlService is connecting >> [mServiceConnecting:").append(this.jdField_a_of_type_Boolean).append(",mWadlService:");
      if (this.jdField_a_of_type_CooperationWadlIpcIWadlService == null) {}
      for (String str = "invaliad";; str = "valid")
      {
        WLog.b("WadlProxyServiceManager", str + "]");
        return;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    try
    {
      WLog.b("WadlProxyServiceManager", "##@innerStartService:bindWadlService");
      WadlProxyService.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidContentServiceConnection);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new angk(this), 3000L);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        WLog.b("WadlProxyServiceManager", "##@failed to lauch servie", localException);
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void b(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface)
  {
    if (paramWadlProxyServiceCallBackInterface != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramWadlProxyServiceCallBackInterface);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      WLog.b("WadlProxyServiceManager", "##@sendAsynRemoteCommandMessage()");
    }
    if (a())
    {
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break label42;
      }
      WLog.b("WadlProxyServiceManager", "##@sendAsynRemoteCommandMessage(empty) END");
    }
    for (;;)
    {
      return;
      label42:
      while (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        Bundle localBundle = (Bundle)this.jdField_a_of_type_JavaUtilList.remove(0);
        if (localBundle != null)
        {
          String str = localBundle.getString("WADL.REMOTE_NOTIFY_CMD_NAME");
          if (QLog.isColorLevel()) {
            WLog.b("WadlProxyServiceManager", "##@sendAsynRemoteCommandMessage():" + str);
          }
          try
          {
            localBundle.setClassLoader(getClass().getClassLoader());
            if (this.jdField_a_of_type_CooperationWadlIpcIWadlService != null)
            {
              WLog.a("WadlProxyServiceManager", 5, "send action to service cmd=" + str);
              this.jdField_a_of_type_CooperationWadlIpcIWadlService.a("WADL.REMOTE_ACTION_CMD", localBundle);
            }
          }
          catch (Exception localException)
          {
            if ((localException instanceof DeadObjectException)) {
              b(localBundle);
            }
            WLog.b("WadlProxyServiceManager", "remote service may be down, restart it!", localException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyServiceManager
 * JD-Core Version:    0.7.0.1
 */