import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class myn
  implements WtTicketPromise
{
  myn(myl parammyl) {}
  
  public void Done(Ticket paramTicket)
  {
    myl.a(this.a, false);
    this.a.h();
  }
  
  public void Failed(ErrMsg paramErrMsg) {}
  
  public void Timeout(ErrMsg paramErrMsg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     myn
 * JD-Core Version:    0.7.0.1
 */