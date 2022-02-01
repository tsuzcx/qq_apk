package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl.Stub;
import com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class TPDownloadProxyFactory$1
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    TPDownloadProxyFactory.access$002(TPDownloadProxyFactoryAidl.Stub.asInterface(paramIBinder));
    try
    {
      paramComponentName = TPDownloadProxyFactory.access$100().entrySet().iterator();
      while (paramComponentName.hasNext())
      {
        paramIBinder = (Map.Entry)paramComponentName.next();
        ((TPDownloadProxyClient)paramIBinder.getValue()).updateAidl(TPDownloadProxyFactory.access$000().getTPDownloadProxy(((Integer)paramIBinder.getKey()).intValue()));
      }
      return;
    }
    catch (Throwable paramComponentName)
    {
      TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "onServiceConnected failed, error:" + paramComponentName.toString());
      TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "on service connected!");
      if (TPDownloadProxyFactory.access$000() == null) {
        TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "on service connected, aidl is null!");
      }
      do
      {
        return;
        TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "on service connected, aidl not null!");
        TPDownloadProxyFactory.access$200(true);
      } while (TPDownloadProxyFactory.access$300() == null);
      TPDownloadProxyFactory.access$300().onBindSuccess();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "on service disconnected");
    TPDownloadProxyFactory.access$002(null);
    TPDownloadProxyFactory.access$200(false);
    TPDownloadProxyFactory.ensurePlayManagerService(TPDownloadProxyFactory.access$300());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory.1
 * JD-Core Version:    0.7.0.1
 */