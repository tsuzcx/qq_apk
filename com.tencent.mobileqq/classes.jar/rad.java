import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.qphone.base.util.QLog;

public class rad
  implements Runnable
{
  public rad(LiteTransferWrapper paramLiteTransferWrapper) {}
  
  public void run()
  {
    if ((LiteTransferWrapper.access$000(this.a) == null) || (LiteTransferWrapper.access$100(this.a) == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.LiteTTransferWrapper", 2, "litetransfer callback is null, do nothing");
      }
    }
    while (LiteTransferWrapper.access$200(this.a) != 0L) {
      return;
    }
    try
    {
      LiteTransferWrapper.access$202(this.a, this.a.createOperator(LiteTransferWrapper.access$000(this.a), LiteTransferWrapper.access$100(this.a)));
      this.a.SetBusinessID(38, 3, 106, 102);
      QLog.i("dataline.LiteTTransferWrapper", 1, "createOperator mLiteTransferOperator:" + LiteTransferWrapper.access$200(this.a) + " threadId:" + Thread.currentThread().getId());
      this.a.checkPathExist();
      this.a.SetProxyToJni();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     rad
 * JD-Core Version:    0.7.0.1
 */