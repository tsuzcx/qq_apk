import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySocialMsgTips;

public class mmc
  implements View.OnClickListener
{
  public mmc(ReadInJoyListViewGroup paramReadInJoyListViewGroup, KandianMergeManager paramKandianMergeManager) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyListViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup).b();
    ReadInJoyListViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup).removeHeaderView(ReadInJoyListViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup).a());
    ReadInJoyListViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup).postInvalidate();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmc
 * JD-Core Version:    0.7.0.1
 */