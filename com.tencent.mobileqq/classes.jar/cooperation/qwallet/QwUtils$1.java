package cooperation.qwallet;

import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

final class QwUtils$1
  implements WtTicketPromise
{
  QwUtils$1(QwUtils.AnsyListener paramAnsyListener, String paramString) {}
  
  public void Done(Ticket paramTicket)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletUtils", 2, "get pskey async success!");
    }
    QwUtils.AnsyListener localAnsyListener = this.a;
    if (localAnsyListener != null) {
      localAnsyListener.a(0, new String[] { QwUtils.a(paramTicket, this.b) });
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletUtils", 2, "preGetKey. PSk Failed!!!");
    }
    QwUtils.AnsyListener localAnsyListener = this.a;
    if (localAnsyListener != null) {
      localAnsyListener.a(-1, new String[] { paramErrMsg.getMessage() });
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletUtils", 2, "preGetKey. PSk Timeout!");
    }
    QwUtils.AnsyListener localAnsyListener = this.a;
    if (localAnsyListener != null) {
      localAnsyListener.a(-1, new String[] { paramErrMsg.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qwallet.QwUtils.1
 * JD-Core Version:    0.7.0.1
 */