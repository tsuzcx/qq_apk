import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyEntityManagerFactory;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;

public class loq
  implements Runnable
{
  public loq(ReadInJoyLogicEngine paramReadInJoyLogicEngine, ReadInJoyEntityManagerFactory paramReadInJoyEntityManagerFactory) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyEntityManagerFactory.verifyAuthentication();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     loq
 * JD-Core Version:    0.7.0.1
 */