package cooperation.comic.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.config.business.QQComicConfBean;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.Serializable;

class QQComicIPCModule$2
  implements Runnable
{
  QQComicIPCModule$2(QQComicIPCModule paramQQComicIPCModule, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = new Bundle();
    Object localObject2 = QQComicConfBean.a();
    if (QLog.isColorLevel()) {
      QLog.d("QQComicIPCModule", 2, " ipExpressionConfig" + localObject2);
    }
    ((Bundle)localObject1).putSerializable("ipExpressionConfig", (Serializable)localObject2);
    localObject2 = QQComicConfBean.a();
    if (QLog.isColorLevel()) {
      QLog.d("QQComicIPCModule", 2, " hippyConfig" + localObject2);
    }
    ((Bundle)localObject1).putSerializable("hippyConfig", (Serializable)localObject2);
    localObject1 = EIPCResult.createSuccessResult((Bundle)localObject1);
    this.this$0.callbackResult(this.a, (EIPCResult)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.ipc.QQComicIPCModule.2
 * JD-Core Version:    0.7.0.1
 */