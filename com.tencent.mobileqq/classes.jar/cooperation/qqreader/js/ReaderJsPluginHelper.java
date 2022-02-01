package cooperation.qqreader.js;

import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qqreader.QRPluginManagerClient;
import cooperation.qqreader.QRPluginManagerClient.OnPluginReadyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReaderJsPluginHelper
{
  private static long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler = new ReaderJsPluginHelper.2(this, Looper.getMainLooper());
  private QRPluginManagerClient.OnPluginReadyListener jdField_a_of_type_CooperationQqreaderQRPluginManagerClient$OnPluginReadyListener = new ReaderJsPluginHelper.1(this);
  private ReaderJsPlugin jdField_a_of_type_CooperationQqreaderJsReaderJsPlugin;
  private List<ReaderJsPluginHelper.PendingJsCallHolder> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  ReaderJsPluginHelper(ReaderJsPlugin paramReaderJsPlugin)
  {
    this.jdField_a_of_type_CooperationQqreaderJsReaderJsPlugin = paramReaderJsPlugin;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    return (("JSbookshelf".equals(paramString1)) && ("kvStorageGet".equals(paramString2)) && (!this.jdField_a_of_type_CooperationQqreaderJsReaderJsPlugin.a())) || (("JSbookshelf".equals(paramString1)) && ("reportParams".equals(paramString2)));
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(100001);
    d();
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ReaderJsPluginHelper.PendingJsCallHolder localPendingJsCallHolder = (ReaderJsPluginHelper.PendingJsCallHolder)localIterator.next();
      if (!localPendingJsCallHolder.a()) {
        this.jdField_a_of_type_CooperationQqreaderJsReaderJsPlugin.a(localPendingJsCallHolder.a.a(), localPendingJsCallHolder.a.b(), localPendingJsCallHolder.a.c(), localPendingJsCallHolder.a.a());
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  private void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ReaderJsPluginHelper.PendingJsCallHolder localPendingJsCallHolder = (ReaderJsPluginHelper.PendingJsCallHolder)localIterator.next();
      if (localPendingJsCallHolder.a())
      {
        if (!a(localPendingJsCallHolder.a.b(), localPendingJsCallHolder.a.c())) {
          f();
        }
        localIterator.remove();
      }
    }
  }
  
  private void f()
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long > 5000L)
    {
      jdField_a_of_type_Long = l;
      QQToast.a(BaseApplicationImpl.getApplication(), "插件正在加载中，请稍候...", 0).a();
    }
  }
  
  private void g()
  {
    if (!QRPluginManagerClient.a().a()) {
      QRPluginManagerClient.a().a(this.jdField_a_of_type_CooperationQqreaderQRPluginManagerClient$OnPluginReadyListener);
    }
  }
  
  void a() {}
  
  void a(String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramString1 = new ReaderJsPluginHelper.PendingJsCallHolder(paramString1, paramString2, paramString3, 3000L, paramVarArgs);
    paramString2 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString2.hasNext())
    {
      paramString3 = (ReaderJsPluginHelper.PendingJsCallHolder)paramString2.next();
      if (paramString3.a(paramString1)) {
        paramString3.a();
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_JavaUtilList.add(paramString1);
      }
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(100001)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100001, 3000L);
      }
      g();
      return;
    }
  }
  
  void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(100001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.js.ReaderJsPluginHelper
 * JD-Core Version:    0.7.0.1
 */