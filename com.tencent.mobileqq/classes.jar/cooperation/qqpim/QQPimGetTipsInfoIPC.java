package cooperation.qqpim;

import biyg;
import biyh;
import biyi;
import biyk;
import biyn;
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
  private biyk jdField_a_of_type_Biyk;
  biyn jdField_a_of_type_Biyn = new biyh(this);
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new biyi(this, biyg.c);
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
    this.jdField_a_of_type_Biyk = null;
    if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable != null)
    {
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable.a();
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable = null;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, biyk parambiyk, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(biyg.jdField_a_of_type_JavaLangString, 2, "QQPimGetTipsInfoIPC.getContactTipsIpc()" + parambiyk.hashCode());
    }
    jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Biyk = parambiyk;
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
    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable = new QQPimPluginLoadRunnable(this.jdField_a_of_type_Biyn);
    ThreadManager.postImmediately(this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable, null, true);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i(biyg.jdField_a_of_type_JavaLangString, 2, "QQPimGetTipsInfoIPC.noticeClickTipsIPC()");
    }
    jdField_a_of_type_Int = 1;
    QQPimPluginProxyService.a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqpim.QQPimGetTipsInfoIPC
 * JD-Core Version:    0.7.0.1
 */