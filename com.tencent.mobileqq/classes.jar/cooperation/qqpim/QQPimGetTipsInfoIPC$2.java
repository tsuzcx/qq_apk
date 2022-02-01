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
    if (QLog.isColorLevel())
    {
      paramBundle = QQPimDefineList.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQPimGetTipsInfoIPC.onCall()");
      localStringBuilder.append(paramString);
      QLog.i(paramBundle, 2, localStringBuilder.toString());
    }
    if (QQPimDefineList.h.equals(paramString))
    {
      if (QQPimGetTipsInfoIPC.e() == -1) {
        return null;
      }
      if (System.currentTimeMillis() - QQPimGetTipsInfoIPC.b(this.a) < 500L) {
        return null;
      }
      QQPimGetTipsInfoIPC.a(this.a, System.currentTimeMillis());
      if (QQPimGetTipsInfoIPC.e() == 0)
      {
        QQPimGetTipsInfoIPC.a(-1);
        paramString = this.a;
        ThreadManager.postImmediately(new QQPimGetTipsInfoIPC.GetContactTipsRunnable(paramString, QQPimGetTipsInfoIPC.c(paramString), QQPimGetTipsInfoIPC.d(this.a)), null, true);
        return null;
      }
      if (QQPimGetTipsInfoIPC.e() == 1)
      {
        QQPimGetTipsInfoIPC.a(-1);
        ThreadManager.postImmediately(new QQPimGetTipsInfoIPC.NoticeClickTipsRunnable(this.a, null), null, true);
        return null;
      }
    }
    else if (QQPimDefineList.i.equals(paramString))
    {
      if (System.currentTimeMillis() - QQPimGetTipsInfoIPC.b(this.a) < 500L) {
        return null;
      }
      QQPimGetTipsInfoIPC.a(this.a, System.currentTimeMillis());
      paramString = new QQPimTipsInfo();
      paramString.a = 0;
      QQPimGetTipsInfoIPC.e(this.a).a(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqpim.QQPimGetTipsInfoIPC.2
 * JD-Core Version:    0.7.0.1
 */