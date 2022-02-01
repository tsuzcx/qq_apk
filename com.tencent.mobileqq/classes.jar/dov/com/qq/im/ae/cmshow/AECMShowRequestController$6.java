package dov.com.qq.im.ae.cmshow;

import dov.com.qq.im.ae.util.AEQLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class AECMShowRequestController$6
  implements WtTicketPromise
{
  AECMShowRequestController$6(AECMShowRequestController paramAECMShowRequestController) {}
  
  public void Done(Ticket paramTicket)
  {
    AEQLog.b("AECMShowRequestController", "psKey success.");
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    AEQLog.d("AECMShowRequestController", paramErrMsg.toString());
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    AEQLog.d("AECMShowRequestController", paramErrMsg.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowRequestController.6
 * JD-Core Version:    0.7.0.1
 */