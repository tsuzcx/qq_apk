import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.DropResultObject;
import com.tencent.mfsdk.persist.DBHandler;

public class rdu
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private DropResultObject jdField_a_of_type_ComTencentMfsdkCollectorDropResultObject;
  private String jdField_a_of_type_JavaLangString;
  
  public rdu(long paramLong, String paramString, DropResultObject paramDropResultObject)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMfsdkCollectorDropResultObject = paramDropResultObject;
  }
  
  public void run()
  {
    if (MagnifierSDK.a != null)
    {
      MagnifierSDK.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMfsdkCollectorDropResultObject);
      this.jdField_a_of_type_ComTencentMfsdkCollectorDropResultObject.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rdu
 * JD-Core Version:    0.7.0.1
 */