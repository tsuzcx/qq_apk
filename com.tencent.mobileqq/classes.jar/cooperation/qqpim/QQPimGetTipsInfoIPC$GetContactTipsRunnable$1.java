package cooperation.qqpim;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class QQPimGetTipsInfoIPC$GetContactTipsRunnable$1
  implements EIPCResultCallback
{
  QQPimGetTipsInfoIPC$GetContactTipsRunnable$1(QQPimGetTipsInfoIPC.GetContactTipsRunnable paramGetContactTipsRunnable) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel())
    {
      String str = QQPimDefineList.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQPimGetTipsInfoIPC.onCallback() ");
      localStringBuilder.append(QQPimGetTipsInfoIPC.a(this.a.this$0).hashCode());
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null))
    {
      paramEIPCResult = paramEIPCResult.data.getParcelable(QQPimDefineList.n);
      if (paramEIPCResult != null)
      {
        paramEIPCResult = (QQPimTipsInfo)paramEIPCResult;
        this.a.this$0.a = paramEIPCResult;
        QQPimGetTipsInfoIPC.a(this.a.this$0).a(paramEIPCResult);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqpim.QQPimGetTipsInfoIPC.GetContactTipsRunnable.1
 * JD-Core Version:    0.7.0.1
 */