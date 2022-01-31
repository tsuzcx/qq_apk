import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ltf
  implements Runnable
{
  public ltf(ReadInJoyMSFService paramReadInJoyMSFService, ToServiceMsg paramToServiceMsg, WeakReference paramWeakReference) {}
  
  public void run()
  {
    int i = ReadInJoyMSFService.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService);
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttributes().put("seq", Integer.valueOf(i));
    ReadInJoyMSFService.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService).put(Integer.valueOf(i), this.jdField_a_of_type_JavaLangRefWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ltf
 * JD-Core Version:    0.7.0.1
 */