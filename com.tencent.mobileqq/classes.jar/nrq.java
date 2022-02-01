import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class nrq
  implements WtTicketPromise
{
  nrq(nro paramnro) {}
  
  public void Done(Ticket paramTicket)
  {
    nro.a(this.a, false);
    this.a.h();
  }
  
  public void Failed(ErrMsg paramErrMsg) {}
  
  public void Timeout(ErrMsg paramErrMsg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nrq
 * JD-Core Version:    0.7.0.1
 */