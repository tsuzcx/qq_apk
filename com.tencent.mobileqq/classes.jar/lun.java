import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import java.util.Iterator;
import java.util.List;

public class lun
  implements Runnable
{
  public lun(InterestLabelInfoModule paramInterestLabelInfoModule, List paramList) {}
  
  public void run()
  {
    InterestLabelInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule).clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      InterestLabelInfo localInterestLabelInfo = (InterestLabelInfo)localIterator.next();
      InterestLabelInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule).add(localInterestLabelInfo);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(InterestLabelInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lun
 * JD-Core Version:    0.7.0.1
 */