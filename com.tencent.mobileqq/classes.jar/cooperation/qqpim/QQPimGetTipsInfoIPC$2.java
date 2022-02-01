package cooperation.qqpim;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class QQPimGetTipsInfoIPC$2
  extends QIPCModule
{
  QQPimGetTipsInfoIPC$2(QQPimGetTipsInfoIPC paramQQPimGetTipsInfoIPC, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.a, 2, "QQPimGetTipsInfoIPC.onCall()" + paramString);
    }
    if (QQPimDefineList.g.equals(paramString)) {
      if (QQPimGetTipsInfoIPC.a() != -1) {}
    }
    while ((!QQPimDefineList.h.equals(paramString)) || (System.currentTimeMillis() - QQPimGetTipsInfoIPC.a(this.a) < 500L))
    {
      do
      {
        do
        {
          return null;
        } while (System.currentTimeMillis() - QQPimGetTipsInfoIPC.a(this.a) < 500L);
        QQPimGetTipsInfoIPC.a(this.a, System.currentTimeMillis());
        if (QQPimGetTipsInfoIPC.a() == 0)
        {
          QQPimGetTipsInfoIPC.a(-1);
          ThreadManager.postImmediately(new QQPimGetTipsInfoIPC.GetContactTipsRunnable(this.a, QQPimGetTipsInfoIPC.a(this.a), QQPimGetTipsInfoIPC.b(this.a)), null, true);
          return null;
        }
      } while (QQPimGetTipsInfoIPC.a() != 1);
      QQPimGetTipsInfoIPC.a(-1);
      ThreadManager.postImmediately(new QQPimGetTipsInfoIPC.NoticeClickTipsRunnable(this.a, null), null, true);
      return null;
    }
    QQPimGetTipsInfoIPC.a(this.a, System.currentTimeMillis());
    paramString = new QQPimTipsInfo();
    paramString.a = 0;
    QQPimGetTipsInfoIPC.a(this.a).a(paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqpim.QQPimGetTipsInfoIPC.2
 * JD-Core Version:    0.7.0.1
 */