package cooperation.qqpim;

import amqm;
import amqn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class QQPimGetTipsInfoIPC
{
  private static int jdField_a_of_type_Int = -1;
  private static QQPimGetTipsInfoIPC jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC;
  private long jdField_a_of_type_Long;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new amqn(this, QQPimDefineList.c);
  private QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC$IGetQQPimTipsCallBack;
  QQPimPluginLoadRunnable.IPluginLoadListener jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener = new amqm(this);
  private QQPimPluginLoadRunnable jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable;
  public QQPimTipsInfo a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static QQPimGetTipsInfoIPC a()
  {
    if (jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC == null) {
        jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC = new QQPimGetTipsInfoIPC();
      }
      return jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC$IGetQQPimTipsCallBack = null;
    if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable != null)
    {
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable.a();
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable = null;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack paramIGetQQPimTipsCallBack, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.jdField_a_of_type_JavaLangString, 2, "QQPimGetTipsInfoIPC.getContactTipsIpc()" + paramIGetQQPimTipsCallBack.hashCode());
    }
    jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC$IGetQQPimTipsCallBack = paramIGetQQPimTipsCallBack;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        QIPCServerHelper.getInstance().register(this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule);
        this.jdField_a_of_type_Boolean = true;
      }
      b();
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable != null) {
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable.a();
    }
    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable = new QQPimPluginLoadRunnable(this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener);
    ThreadManager.postImmediately(this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable, null, true);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.jdField_a_of_type_JavaLangString, 2, "QQPimGetTipsInfoIPC.noticeClickTipsIPC()");
    }
    jdField_a_of_type_Int = 1;
    QQPimPluginProxyService.a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqpim.QQPimGetTipsInfoIPC
 * JD-Core Version:    0.7.0.1
 */