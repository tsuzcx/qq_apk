package cooperation.qappcenter.remote;

import java.util.concurrent.ConcurrentLinkedQueue;

class RemoteServiceProxy$2
  extends Thread
{
  RemoteServiceProxy$2(RemoteServiceProxy paramRemoteServiceProxy) {}
  
  public void run()
  {
    while (!this.this$0.c.isEmpty())
    {
      SendMsg localSendMsg = (SendMsg)this.this$0.c.poll();
      if (localSendMsg != null) {
        try
        {
          this.this$0.a(localSendMsg);
        }
        catch (Exception localException)
        {
          RemoteServiceProxy localRemoteServiceProxy = this.this$0;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("sendMsgToServiceFailed，");
          localStringBuilder.append(localException.toString());
          RecvMsg localRecvMsg = localRemoteServiceProxy.a(localSendMsg, localStringBuilder.toString());
          this.this$0.a(localSendMsg, localRecvMsg);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qappcenter.remote.RemoteServiceProxy.2
 * JD-Core Version:    0.7.0.1
 */