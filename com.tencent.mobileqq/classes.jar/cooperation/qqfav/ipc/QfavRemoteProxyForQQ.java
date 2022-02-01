package cooperation.qqfav.ipc;

import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import cooperation.qqfav.QfavPluginProxyService;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;

public class QfavRemoteProxyForQQ
{
  private ServiceConnection a;
  protected IQfavRemoteProxyInterface a;
  public final String a;
  protected WeakReference<AppRuntime> a;
  protected HashSet<String> a;
  protected ConcurrentLinkedQueue<QfavRemoteProxyForQQ.QfavRemoteProxyCallWrapper> a;
  protected boolean a;
  
  public QfavRemoteProxyForQQ(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_JavaLangString = "QfavRemoteProxyForQQ";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_CooperationQqfavIpcIQfavRemoteProxyInterface = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_AndroidContentServiceConnection = new QfavRemoteProxyForQQ.2(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppRuntime);
    a("com.tencent.qqfav");
  }
  
  private void a(QfavRemoteProxyForQQ.QfavRemoteProxyCallWrapper paramQfavRemoteProxyCallWrapper)
  {
    if ((this.jdField_a_of_type_CooperationQqfavIpcIQfavRemoteProxyInterface != null) && (paramQfavRemoteProxyCallWrapper != null))
    {
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread())
      {
        new Handler(localLooper).post(new QfavRemoteProxyForQQ.1(this, paramQfavRemoteProxyCallWrapper));
        return;
      }
    }
    try
    {
      this.jdField_a_of_type_CooperationQqfavIpcIQfavRemoteProxyInterface.a(paramQfavRemoteProxyCallWrapper.jdField_a_of_type_Int, paramQfavRemoteProxyCallWrapper.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (RemoteException paramQfavRemoteProxyCallWrapper) {}
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_CooperationQqfavIpcIQfavRemoteProxyInterface == null) && (!this.jdField_a_of_type_Boolean))
    {
      Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject != null)
      {
        localObject = (AppRuntime)((WeakReference)localObject).get();
        if (localObject != null)
        {
          QfavPluginProxyService.a((AppRuntime)localObject, this.jdField_a_of_type_AndroidContentServiceConnection, "com.qqfav.ipc.QfavRemoteProxyService");
          this.jdField_a_of_type_Boolean = true;
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean a(QfavRemoteProxyForQQ.QfavRemoteProxyCallWrapper paramQfavRemoteProxyCallWrapper)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramQfavRemoteProxyCallWrapper);
  }
  
  public boolean a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilHashSet.contains(paramString))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
      a();
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilHashSet.contains(paramString))
    {
      paramString = new QfavRemoteProxyForQQ.QfavRemoteProxyCallWrapper(this, paramInt, paramBundle);
      if (this.jdField_a_of_type_CooperationQqfavIpcIQfavRemoteProxyInterface != null)
      {
        a(paramString);
      }
      else
      {
        a(paramString);
        a();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqfav.ipc.QfavRemoteProxyForQQ
 * JD-Core Version:    0.7.0.1
 */