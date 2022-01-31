import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.KingShareReadInjoyModule;
import com.tencent.biz.pubaccount.readinjoy.struct.KingMomentInfo;

public class lri
  implements Runnable
{
  public lri(KingShareReadInjoyModule paramKingShareReadInjoyModule, int paramInt, KingMomentInfo paramKingMomentInfo) {}
  
  public void run()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKingMomentInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lri
 * JD-Core Version:    0.7.0.1
 */