package cooperation.qzone.remote.logic;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.api.QZoneApiProxy.QZoneLoadCallback;
import cooperation.qzone.remote.IActionListener;
import cooperation.qzone.remote.RemoteServiceProxy;
import cooperation.qzone.remote.SendMsg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class RemoteHandleManager
  implements QZoneApiProxy.QZoneLoadCallback
{
  static final String TAG = "RemoteHandleManager";
  private static Object lock = new Object();
  private static RemoteHandleManager mInstance;
  private static Object serviceLock = new Object();
  IActionListener mActionListener = new RemoteHandleManager.1(this);
  private AtomicInteger mReqestId = new AtomicInteger(1);
  private RemoteRequestSender mSender;
  private ArrayList<WeakReference<WebEventListener>> mWebEventListeners = new ArrayList();
  private RemoteServiceProxy serviceProxy;
  
  public RemoteHandleManager()
  {
    if (QZoneApiProxy.isQzonePluginInstalledAndVersionRight(this)) {
      getServiceProxy();
    }
  }
  
  public static RemoteHandleManager getInstance()
  {
    if (mInstance == null) {
      synchronized (lock)
      {
        if (mInstance == null) {
          mInstance = new RemoteHandleManager();
        }
      }
    }
    return mInstance;
  }
  
  public void addWebEventListener(WebEventListener paramWebEventListener)
  {
    if (paramWebEventListener == null) {
      return;
    }
    Iterator localIterator = this.mWebEventListeners.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      if (localObject != null)
      {
        localObject = (WebEventListener)((WeakReference)localObject).get();
        if (localObject == null) {
          localIterator.remove();
        } else if (localObject == paramWebEventListener) {
          return;
        }
      }
    }
    this.mWebEventListeners.add(new WeakReference(paramWebEventListener));
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RemoteHandleManager", 2, "----destroy----");
    }
    RemoteServiceProxy localRemoteServiceProxy = this.serviceProxy;
    if (localRemoteServiceProxy != null) {
      localRemoteServiceProxy.unbindBaseService();
    }
  }
  
  public RemoteRequestSender getSender()
  {
    if (this.mSender == null) {
      this.mSender = new RemoteRequestSender(this);
    }
    return this.mSender;
  }
  
  public RemoteServiceProxy getServiceProxy()
  {
    ??? = this.serviceProxy;
    if (??? != null) {
      return ???;
    }
    synchronized (serviceLock)
    {
      if (this.serviceProxy == null)
      {
        this.serviceProxy = new RemoteServiceProxy("com.qzone.common.webplugin.WebPluginHandleService", QzoneWebPluginProxyService.class, BaseApplicationImpl.getApplication().getRuntime().getAccount());
        this.serviceProxy.setActionListener(this.mActionListener);
      }
      return this.serviceProxy;
    }
  }
  
  public void onLoadOver(boolean paramBoolean)
  {
    getServiceProxy();
  }
  
  public void removeWebEventListener(WebEventListener paramWebEventListener)
  {
    if (paramWebEventListener == null) {
      return;
    }
    Iterator localIterator = this.mWebEventListeners.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      if (localObject != null)
      {
        localObject = (WebEventListener)((WeakReference)localObject).get();
        if (localObject == null) {
          localIterator.remove();
        } else if (localObject == paramWebEventListener) {
          localIterator.remove();
        }
      }
    }
  }
  
  protected int sendData(String paramString, Bundle paramBundle, long paramLong, boolean paramBoolean)
  {
    SendMsg localSendMsg = new SendMsg(paramString);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if ((localBundle != null) && (localBundle.size() > 0)) {
      localSendMsg.extraData.putAll(localBundle);
    }
    int i = this.mReqestId.incrementAndGet();
    localSendMsg.setRequestId(i);
    if (paramLong > 0L) {
      localSendMsg.setTimeout(paramLong);
    }
    localSendMsg.setNeedCallback(paramBoolean);
    if (paramBoolean) {
      localSendMsg.actionListener = this.mActionListener;
    }
    try
    {
      if ((QZoneApiProxy.isQzonePluginInstalledAndVersionRight(null)) && (getServiceProxy() != null))
      {
        getServiceProxy().sendMsg(localSendMsg);
        return i;
      }
      QZoneApiProxy.isQzonePluginInstalledAndVersionRight(new RemoteHandleManager.2(this, localSendMsg, paramString));
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      throw new RuntimeException("sendMsg is fail", paramString);
    }
  }
  
  public int sendData(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    try
    {
      int i = sendData(paramString, paramBundle, 0L, paramBoolean);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.remote.logic.RemoteHandleManager
 * JD-Core Version:    0.7.0.1
 */