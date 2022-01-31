package cooperation.wadl.ipc;

import android.os.Bundle;
import com.tencent.open.wadl.WLog;
import com.tencent.open.wadl.WadlJsBridgeUtil;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class WadlProxyServiceWrap
{
  public WadlProxyServiceManager a;
  
  public WadlProxyServiceWrap(AppRuntime paramAppRuntime)
  {
    WLog.b("WadlProxyServiceWrap", "##@WadlProxyServiceWrap():" + paramAppRuntime);
    this.a = new WadlProxyServiceManager(paramAppRuntime);
  }
  
  public List a()
  {
    return this.a.a();
  }
  
  public void a()
  {
    WLog.b("WadlProxyServiceWrap", "##@launchService");
    this.a.a();
  }
  
  public void a(int paramInt, String paramString)
  {
    WLog.b("WadlProxyServiceWrap", "doPauseAction from=" + paramInt + ",appId=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doPauseAction");
    localBundle.putString("appId", paramString);
    localBundle.putInt("actionFrom", paramInt);
    this.a.a(localBundle, true);
  }
  
  public void a(WadlParams paramWadlParams)
  {
    WLog.b("WadlProxyServiceWrap", "doDownloadAction:" + paramWadlParams.toString());
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doDownloadAction");
    localBundle.putString("appId", paramWadlParams.a);
    localBundle.putInt("actionFrom", paramWadlParams.c);
    localBundle.putParcelable("download_wadl_params", paramWadlParams);
    this.a.a(localBundle, true);
    try
    {
      WadlJsBridgeUtil.a(paramWadlParams.d, paramWadlParams.a);
      return;
    }
    catch (Exception paramWadlParams)
    {
      WLog.a("WadlProxyServiceWrap", "savePackageInfo", paramWadlParams);
    }
  }
  
  public void a(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface)
  {
    this.a.a(paramWadlProxyServiceCallBackInterface);
  }
  
  public void a(String paramString)
  {
    WLog.b("WadlProxyServiceWrap", "doQueryActionByVia via=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryActionByVia");
    localBundle.putString("via", paramString);
    this.a.a(localBundle, true);
  }
  
  public void a(String paramString1, String paramString2)
  {
    WLog.b("WadlProxyServiceWrap", "receive system receiver cmd=" + paramString1 + ",packageName=" + paramString2);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", paramString1);
    localBundle.putString("packageName", paramString2);
    this.a.a(localBundle, false);
  }
  
  public void a(ArrayList paramArrayList)
  {
    WLog.b("WadlProxyServiceWrap", "doQueryAction:" + paramArrayList.toString());
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryAction");
    localBundle.putStringArrayList("appIdLis", paramArrayList);
    this.a.a(localBundle, true);
  }
  
  public void b()
  {
    a("ALL_TASK_QUERY_IDENTITY");
  }
  
  public void b(int paramInt, String paramString)
  {
    WLog.b("WadlProxyServiceWrap", "doResumeAction from=" + paramInt + ",appId=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doResumeAction");
    localBundle.putString("appId", paramString);
    localBundle.putInt("actionFrom", paramInt);
    this.a.a(localBundle, true);
  }
  
  public void b(WadlParams paramWadlParams)
  {
    WLog.b("WadlProxyServiceWrap", "doUpdateTaskSign wadlParams=" + paramWadlParams.toString());
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doUpdateTaskSign");
    localBundle.putString("appId", paramWadlParams.a);
    localBundle.putInt("actionFrom", paramWadlParams.c);
    localBundle.putParcelable("download_wadl_params", paramWadlParams);
    this.a.a(localBundle, true);
  }
  
  public void b(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface)
  {
    this.a.b(paramWadlProxyServiceCallBackInterface);
  }
  
  public void c()
  {
    WLog.b("WadlProxyServiceWrap", "initWadlTaskManager:");
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doInitWadlTaskManager");
    this.a.a(localBundle, true);
  }
  
  public void c(int paramInt, String paramString)
  {
    WLog.b("WadlProxyServiceWrap", "##@deleteDownload from=" + paramInt + ",appID=" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doDeleteAction");
    localBundle.putString("appId", paramString);
    localBundle.putInt("actionFrom", paramInt);
    this.a.a(localBundle, true);
  }
  
  public void c(WadlParams paramWadlParams)
  {
    WLog.b("WadlProxyServiceWrap", "doInstallAction：" + paramWadlParams);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doInstallAction");
    localBundle.putParcelable("download_wadl_params", paramWadlParams);
    localBundle.putString("appId", paramWadlParams.a);
    localBundle.putInt("actionFrom", paramWadlParams.c);
    this.a.a(localBundle, true);
    try
    {
      WadlJsBridgeUtil.a(paramWadlParams.d, paramWadlParams.a);
      return;
    }
    catch (Exception paramWadlParams)
    {
      WLog.a("WadlProxyServiceWrap", "savePackageInfo", paramWadlParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyServiceWrap
 * JD-Core Version:    0.7.0.1
 */