package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.ErrMsg;

class WtloginHelper$1
  implements WtTicketPromise
{
  WtloginHelper$1(WtloginHelper paramWtloginHelper, String paramString, long paramLong, int paramInt, WtTicketPromise paramWtTicketPromise) {}
  
  public void Done(Ticket paramTicket)
  {
    paramTicket = this.this$0.GetLocalTicket(this.val$userAccount, this.val$appid, this.val$sigType);
    WtTicketPromise localWtTicketPromise = this.val$promise;
    if (localWtTicketPromise != null) {
      localWtTicketPromise.Done(paramTicket);
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    WtTicketPromise localWtTicketPromise = this.val$promise;
    if (localWtTicketPromise != null) {
      localWtTicketPromise.Failed(paramErrMsg);
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    WtTicketPromise localWtTicketPromise = this.val$promise;
    if (localWtTicketPromise != null) {
      localWtTicketPromise.Timeout(paramErrMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.1
 * JD-Core Version:    0.7.0.1
 */