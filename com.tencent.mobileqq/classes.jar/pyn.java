import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemSingle;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class pyn
  implements View.OnClickListener
{
  public pyn(ComponentTopicItemSingle paramComponentTopicItemSingle, qdv paramqdv) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.a();
    onk.a = paramView;
    onk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.getContext(), this.jdField_a_of_type_Qdv.b);
    String str1 = onk.a(paramView.mAlgorithmID, onk.a(paramView), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.e(), 0, 0, bbev.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.getContext()), paramView.mSubscribeID, null, paramView.innerUniqueID, null, paramView);
    String str2 = shx.b(paramView.mChannelID);
    noo.a(null, paramView.mSubscribeID, str2, str2, 0, 0, paramView.mFeedId + "", String.valueOf(this.jdField_a_of_type_Qdv.a), String.valueOf(paramView.mAlgorithmID), str1, false);
    onk.a(paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pyn
 * JD-Core Version:    0.7.0.1
 */