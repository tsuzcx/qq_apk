package cooperation.qqreader;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qqreader.proxy.ReaderInterfacePluginBuilder;
import cooperation.qqreader.proxy.ReaderInterfacePluginProxy;
import cooperation.qqreader.proxy.ReaderJsCallback;
import cooperation.qqreader.proxy.ReaderJsPluginBuilder;
import cooperation.qqreader.proxy.ReaderJsPluginProxy;
import cooperation.qqreader.shadow.ReaderPluginHelper;
import cooperation.qqreader.utils.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class QRPluginManagerClient
{
  private static QRPluginManagerClient jdField_a_of_type_CooperationQqreaderQRPluginManagerClient;
  private long jdField_a_of_type_Long = 0L;
  private ReaderInterfacePluginBuilder jdField_a_of_type_CooperationQqreaderProxyReaderInterfacePluginBuilder;
  private ReaderJsPluginBuilder jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginBuilder;
  private List<WeakReference<QRPluginManagerClient.OnPluginReadyListener>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public static QRPluginManagerClient a()
  {
    
    if (jdField_a_of_type_CooperationQqreaderQRPluginManagerClient == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQqreaderQRPluginManagerClient == null) {
        jdField_a_of_type_CooperationQqreaderQRPluginManagerClient = new QRPluginManagerClient();
      }
      return jdField_a_of_type_CooperationQqreaderQRPluginManagerClient;
    }
    finally {}
  }
  
  private void b()
  {
    Log.c("QRPluginManagerClient", "dispatchPluginReadyEvent");
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator2.hasNext())
      {
        QRPluginManagerClient.OnPluginReadyListener localOnPluginReadyListener = (QRPluginManagerClient.OnPluginReadyListener)((WeakReference)localIterator2.next()).get();
        if (localOnPluginReadyListener != null) {
          localArrayList.add(localOnPluginReadyListener);
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    finally {}
    Iterator localIterator1 = localObject.iterator();
    while (localIterator1.hasNext()) {
      c((QRPluginManagerClient.OnPluginReadyListener)localIterator1.next());
    }
  }
  
  private void b(QRPluginManagerClient.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (paramOnPluginReadyListener == null) {
      return;
    }
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      QRPluginManagerClient.OnPluginReadyListener localOnPluginReadyListener;
      do
      {
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label68;
          }
          localOnPluginReadyListener = (QRPluginManagerClient.OnPluginReadyListener)((WeakReference)localIterator.next()).get();
          if (localOnPluginReadyListener != null) {
            break;
          }
          localIterator.remove();
        }
      } while (localOnPluginReadyListener != paramOnPluginReadyListener);
    }
    finally {}
    return;
    label68:
    this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramOnPluginReadyListener));
  }
  
  private static void c()
  {
    if (BaseApplicationImpl.sProcessId != 7) {
      Log.a("QRPluginManagerClient", "checkToolProcess: QRPluginManagerClient的逻辑必须在Tool进程调用");
    }
  }
  
  private void c(QRPluginManagerClient.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (paramOnPluginReadyListener == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new QRPluginManagerClient.2(this, paramOnPluginReadyListener));
  }
  
  @Nullable
  public ReaderInterfacePluginProxy a()
  {
    if (this.jdField_a_of_type_CooperationQqreaderProxyReaderInterfacePluginBuilder == null) {
      return null;
    }
    return this.jdField_a_of_type_CooperationQqreaderProxyReaderInterfacePluginBuilder.create();
  }
  
  @Nullable
  public ReaderJsPluginProxy a(ReaderJsCallback paramReaderJsCallback)
  {
    if (this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginBuilder == null) {
      return null;
    }
    return this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginBuilder.create(paramReaderJsCallback);
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(Context paramContext, Intent paramIntent, String paramString)
  {
    if (!a())
    {
      Log.a("QRPluginManagerClient", "startPluginActivityWhenReady: plugin is not ready");
      return;
    }
    if (ReaderPluginHelper.a())
    {
      ReaderPluginHelper.a(paramContext, paramIntent, paramString);
      return;
    }
    QRJumpAction.a(paramContext, paramIntent, paramString);
  }
  
  public void a(QRPluginManagerClient.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (a()) {
      c(paramOnPluginReadyListener);
    }
    do
    {
      return;
      b(paramOnPluginReadyListener);
    } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 3000L);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (ReaderPluginHelper.a())
    {
      ReaderPluginHelper.a(BaseApplicationImpl.getApplication());
      return;
    }
    ThreadManager.getSubThreadHandler().post(new QRPluginManagerClient.1(this));
  }
  
  public void a(ReaderJsPluginBuilder paramReaderJsPluginBuilder, ReaderInterfacePluginBuilder paramReaderInterfacePluginBuilder)
  {
    this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginBuilder = paramReaderJsPluginBuilder;
    this.jdField_a_of_type_CooperationQqreaderProxyReaderInterfacePluginBuilder = paramReaderInterfacePluginBuilder;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.QRPluginManagerClient
 * JD-Core Version:    0.7.0.1
 */