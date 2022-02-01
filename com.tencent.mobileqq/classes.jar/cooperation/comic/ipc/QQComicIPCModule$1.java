package cooperation.comic.ipc;

import android.os.Bundle;
import bkfy;
import com.tencent.mobileqq.config.business.QQComicConfBean;
import com.tencent.mobileqq.config.business.QQComicConfBean.IPExpressionConfig;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class QQComicIPCModule$1
  implements Runnable
{
  public QQComicIPCModule$1(bkfy parambkfy, int paramInt) {}
  
  public void run()
  {
    Object localObject = new Bundle();
    QQComicConfBean.IPExpressionConfig localIPExpressionConfig = QQComicConfBean.a();
    if (QLog.isColorLevel()) {
      QLog.d("QQComicIPCModule", 2, " ipExpressionConfig" + localIPExpressionConfig);
    }
    ((Bundle)localObject).putSerializable("ipExpressionConfig", localIPExpressionConfig);
    localObject = EIPCResult.createSuccessResult((Bundle)localObject);
    this.this$0.callbackResult(this.a, (EIPCResult)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.comic.ipc.QQComicIPCModule.1
 * JD-Core Version:    0.7.0.1
 */