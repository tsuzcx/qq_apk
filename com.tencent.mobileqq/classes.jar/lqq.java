import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.SpecialChannelFilter;
import java.util.List;

public class lqq
  implements Runnable
{
  public lqq(ChannelInfoModule paramChannelInfoModule, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      ReadInJoyLogicEngineEventDispatcher.a().c(false, null);
      return;
    }
    SpecialChannelFilter.a().a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.c(this.jdField_a_of_type_JavaUtilList);
    ReadInJoyLogicEngineEventDispatcher.a().c(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lqq
 * JD-Core Version:    0.7.0.1
 */