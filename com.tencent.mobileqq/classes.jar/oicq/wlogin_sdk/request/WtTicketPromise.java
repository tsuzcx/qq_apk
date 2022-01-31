package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.ErrMsg;

public abstract interface WtTicketPromise
{
  public abstract void Done(Ticket paramTicket);
  
  public abstract void Failed(ErrMsg paramErrMsg);
  
  public abstract void Timeout(ErrMsg paramErrMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtTicketPromise
 * JD-Core Version:    0.7.0.1
 */