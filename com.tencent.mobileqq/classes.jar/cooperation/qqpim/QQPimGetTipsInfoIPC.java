package cooperation.qqpim;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class QQPimGetTipsInfoIPC
{
  private static int g = -1;
  private static QQPimGetTipsInfoIPC j;
  public QQPimTipsInfo a;
  QQPimPluginLoadRunnable.IPluginLoadListener b = new QQPimGetTipsInfoIPC.1(this);
  private QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack c;
  private String d;
  private String e;
  private long f;
  private boolean h;
  private QQPimPluginLoadRunnable i;
  private QIPCModule k = new QQPimGetTipsInfoIPC.2(this, QQPimDefineList.d);
  
  public static QQPimGetTipsInfoIPC a()
  {
    if (j == null) {
      try
      {
        if (j == null) {
          j = new QQPimGetTipsInfoIPC();
        }
      }
      finally {}
    }
    return j;
  }
  
  private QQAppInterface f()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack paramIGetQQPimTipsCallBack, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = QQPimDefineList.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQPimGetTipsInfoIPC.getContactTipsIpc()");
      localStringBuilder.append(paramIGetQQPimTipsCallBack.hashCode());
      QLog.i(paramQQAppInterface, 2, localStringBuilder.toString());
    }
    g = 0;
    this.c = paramIGetQQPimTipsCallBack;
    this.d = paramString1;
    this.e = paramString2;
    try
    {
      if (!this.h)
      {
        QIPCServerHelper.getInstance().register(this.k);
        this.h = true;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    c();
  }
  
  public void b()
  {
    this.c = null;
    QQPimPluginLoadRunnable localQQPimPluginLoadRunnable = this.i;
    if (localQQPimPluginLoadRunnable != null)
    {
      localQQPimPluginLoadRunnable.a();
      this.i = null;
    }
  }
  
  public void c()
  {
    QQPimPluginLoadRunnable localQQPimPluginLoadRunnable = this.i;
    if (localQQPimPluginLoadRunnable != null) {
      localQQPimPluginLoadRunnable.a();
    }
    this.i = new QQPimPluginLoadRunnable(this.b);
    ThreadManager.postImmediately(this.i, null, true);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.a, 2, "QQPimGetTipsInfoIPC.noticeClickTipsIPC()");
    }
    g = 1;
    QQPimPluginProxyService.a(f());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqpim.QQPimGetTipsInfoIPC
 * JD-Core Version:    0.7.0.1
 */