import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.SpecialChannelFilter;
import java.util.List;

public class ltz
  implements Runnable
{
  public ltz(ChannelInfoModule paramChannelInfoModule, boolean paramBoolean1, boolean paramBoolean2, List paramList1, List paramList2) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      ReadInJoyLogicEngineEventDispatcher.a().c(false, null);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      ReadInJoyLogicEngineEventDispatcher.a().c(true, this.jdField_a_of_type_JavaUtilList);
      return;
    }
    ChannelInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.a(this.jdField_a_of_type_JavaUtilList, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.c(this.jdField_b_of_type_JavaUtilList);
    if (!ReadInJoyUtils.a())
    {
      List localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.a(this.jdField_a_of_type_JavaUtilList);
      SpecialChannelFilter.a().a(this.jdField_b_of_type_JavaUtilList);
      SpecialChannelFilter.a().b(localList);
      localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.c();
      if (!this.jdField_b_of_type_JavaUtilList.equals(localList)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.c());
      }
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.a());
    if (!ReadInJoyUtils.a())
    {
      ReadInJoyLogicEngineEventDispatcher.a().c(true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.b());
      return;
    }
    ReadInJoyLogicEngineEventDispatcher.a().c(true, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ltz
 * JD-Core Version:    0.7.0.1
 */