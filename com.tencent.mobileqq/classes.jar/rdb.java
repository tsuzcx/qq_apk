import com.tencent.litetransfersdk.LiteTransferWrapper;

public class rdb
  implements Runnable
{
  public rdb(LiteTransferWrapper paramLiteTransferWrapper, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper) != 0L) {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelAllToJNI(LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper), this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     rdb
 * JD-Core Version:    0.7.0.1
 */