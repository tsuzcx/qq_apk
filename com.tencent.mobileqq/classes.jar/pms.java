import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemSingle;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class pms
  implements View.OnClickListener
{
  public pms(ComponentTopicItemSingle paramComponentTopicItemSingle, prx paramprx) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.a();
    obz.a = paramView;
    obz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.getContext(), this.jdField_a_of_type_Prx.b);
    String str1 = obz.a(paramView.mAlgorithmID, obz.a(paramView), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.e(), 0, 0, badq.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.getContext()), paramView.mSubscribeID, null, paramView.innerUniqueID, null, paramView);
    String str2 = rvf.b(paramView.mChannelID);
    ndn.a(null, paramView.mSubscribeID, str2, str2, 0, 0, paramView.mFeedId + "", String.valueOf(this.jdField_a_of_type_Prx.a), String.valueOf(paramView.mAlgorithmID), str1, false);
    obz.a(paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pms
 * JD-Core Version:    0.7.0.1
 */