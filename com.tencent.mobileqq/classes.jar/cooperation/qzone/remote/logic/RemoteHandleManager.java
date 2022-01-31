package cooperation.qzone.remote.logic;

import amym;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.IActionListener;
import cooperation.qzone.remote.RemoteServiceProxy;
import cooperation.qzone.remote.SendMsg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class RemoteHandleManager
{
  private static RemoteHandleManager jdField_a_of_type_CooperationQzoneRemoteLogicRemoteHandleManager;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  IActionListener jdField_a_of_type_CooperationQzoneRemoteIActionListener = new amym(this);
  private RemoteServiceProxy jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy = new RemoteServiceProxy("com.qzone.common.webplugin.WebPluginHandleService", QzoneWebPluginProxyService.class, BaseApplicationImpl.getApplication().getRuntime().getAccount());
  private RemoteRequestSender jdField_a_of_type_CooperationQzoneRemoteLogicRemoteRequestSender;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  
  public RemoteHandleManager()
  {
    this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy.setActionListener(this.jdField_a_of_type_CooperationQzoneRemoteIActionListener);
  }
  
  public static RemoteHandleManager a()
  {
    if (jdField_a_of_type_CooperationQzoneRemoteLogicRemoteHandleManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_CooperationQzoneRemoteLogicRemoteHandleManager == null) {
        jdField_a_of_type_CooperationQzoneRemoteLogicRemoteHandleManager = new RemoteHandleManager();
      }
      return jdField_a_of_type_CooperationQzoneRemoteLogicRemoteHandleManager;
    }
  }
  
  protected int a(String paramString, Bundle paramBundle, long paramLong, boolean paramBoolean)
  {
    SendMsg localSendMsg = new SendMsg(paramString);
    paramString = paramBundle;
    if (paramBundle == null) {
      paramString = new Bundle();
    }
    if ((paramString != null) && (paramString.size() > 0)) {
      localSendMsg.extraData.putAll(paramString);
    }
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    localSendMsg.setRequestId(i);
    if (paramLong > 0L) {
      localSendMsg.setTimeout(paramLong);
    }
    localSendMsg.setNeedCallback(paramBoolean);
    if (paramBoolean) {
      localSendMsg.actionListener = this.jdField_a_of_type_CooperationQzoneRemoteIActionListener;
    }
    try
    {
      this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy.sendMsg(localSendMsg);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      throw new RuntimeException("sendMsg is fail", paramString);
    }
  }
  
  public int a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    try
    {
      int i = a(paramString, paramBundle, 0L, paramBoolean);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public RemoteRequestSender a()
  {
    if (this.jdField_a_of_type_CooperationQzoneRemoteLogicRemoteRequestSender == null) {
      this.jdField_a_of_type_CooperationQzoneRemoteLogicRemoteRequestSender = new RemoteRequestSender(this);
    }
    return this.jdField_a_of_type_CooperationQzoneRemoteLogicRemoteRequestSender;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RemoteHandleManager", 2, "----destroy----");
    }
    if (this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy != null) {
      this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy.unbindBaseService();
    }
  }
  
  public void a(WebEventListener paramWebEventListener)
  {
    if (paramWebEventListener == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramWebEventListener));
  }
  
  public void b(WebEventListener paramWebEventListener)
  {
    if (paramWebEventListener == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.remote.logic.RemoteHandleManager
 * JD-Core Version:    0.7.0.1
 */