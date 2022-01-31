import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class mvu
  implements WtTicketPromise
{
  mvu(mvs parammvs) {}
  
  public void Done(Ticket paramTicket)
  {
    mvs.a(this.a, false);
    this.a.h();
  }
  
  public void Failed(ErrMsg paramErrMsg) {}
  
  public void Timeout(ErrMsg paramErrMsg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mvu
 * JD-Core Version:    0.7.0.1
 */