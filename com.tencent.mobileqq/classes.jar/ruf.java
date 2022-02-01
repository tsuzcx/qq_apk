import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ruf
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public ruf(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public ruf a()
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    if (!localFile.exists())
    {
      ReadInJoyDeliverUGCActivity.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity.l();
      ReadInJoyDeliverUGCActivity.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity.getString(2131717709));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity.i();
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic file not exist, path=" + this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    this.jdField_a_of_type_Long = localFile.length();
    ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
    ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).c(this.jdField_a_of_type_Int, NetConnInfoCenter.getServerTimeMillis());
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ruf
 * JD-Core Version:    0.7.0.1
 */