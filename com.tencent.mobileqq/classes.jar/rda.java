import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.qphone.base.util.QLog;

public class rda
  implements Runnable
{
  public rda(LiteTransferWrapper paramLiteTransferWrapper, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      if (LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper) != 0L)
      {
        QLog.i("dataline.LiteTTransferWrapper", 1, "destryOperator mLiteTransferOperator:" + LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper) + " threadId:" + Thread.currentThread().getId());
        long l = LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper);
        LiteTransferWrapper.access$202(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper, 0L);
        this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.destryOperator(l, this.jdField_a_of_type_Boolean);
      }
      LiteTransferWrapper.access$002(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper, null);
      LiteTransferWrapper.access$102(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper, null);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("dataline.LiteTTransferWrapper", 2, "cannot endLiteTransfer, load litetranfer library error?" + QLog.getStackTraceString(localUnsatisfiedLinkError));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     rda
 * JD-Core Version:    0.7.0.1
 */