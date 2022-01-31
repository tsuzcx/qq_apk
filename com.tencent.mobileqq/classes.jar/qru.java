import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Random;

public class qru
  extends awyn
{
  VideoFeedsAppInterface jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAppInterface;
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  
  public qru(VideoFeedsAppInterface paramVideoFeedsAppInterface)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAppInterface = paramVideoFeedsAppInterface;
    jdField_a_of_type_Int = Math.abs(this.jdField_a_of_type_JavaUtilRandom.nextInt());
  }
  
  public AppInterface a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAppInterface;
  }
  
  protected void a()
  {
    try
    {
      super.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    super.b(paramToServiceMsg, null, qrv.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qru
 * JD-Core Version:    0.7.0.1
 */