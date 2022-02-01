package cooperation.qqpim;

import com.tencent.qphone.base.util.QLog;

class QQPimGetTipsInfoIPC$1
  implements QQPimPluginLoadRunnable.IPluginLoadListener
{
  QQPimGetTipsInfoIPC$1(QQPimGetTipsInfoIPC paramQQPimGetTipsInfoIPC) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.a, 2, "QQPimGetTipsInfoIPC.hasInstalled() ");
    }
    QQPimPluginProxyService.a(QQPimGetTipsInfoIPC.a(this.a));
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      String str = QQPimDefineList.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQPimGetTipsInfoIPC.downloading() ");
      localStringBuilder.append(paramFloat);
      QLog.i(str, 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = QQPimDefineList.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQPimGetTipsInfoIPC.downloadError() ");
      localStringBuilder.append(paramInt);
      QLog.i(str, 2, localStringBuilder.toString());
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.a, 2, "QQPimGetTipsInfoIPC.downloadBegin()");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqpim.QQPimGetTipsInfoIPC.1
 * JD-Core Version:    0.7.0.1
 */