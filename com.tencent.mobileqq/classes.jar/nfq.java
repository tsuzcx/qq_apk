import android.os.Handler;
import android.os.Message;

class nfq
  extends Handler
{
  nfq(nfp paramnfp) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      nfp.a(this.a, nfp.a(this.a), nfp.a(this.a));
      nfp.a(this.a);
      return;
    }
    nfp.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nfq
 * JD-Core Version:    0.7.0.1
 */