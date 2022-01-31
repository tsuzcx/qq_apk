import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemSingle;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class pyk
  implements View.OnClickListener
{
  public pyk(ComponentTopicItemSingle paramComponentTopicItemSingle, qds paramqds) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.a();
    onh.a = paramView;
    onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.getContext(), this.jdField_a_of_type_Qds.b);
    String str1 = onh.a(paramView.mAlgorithmID, onh.a(paramView), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.e(), 0, 0, bbfj.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.getContext()), paramView.mSubscribeID, null, paramView.innerUniqueID, null, paramView);
    String str2 = shu.b(paramView.mChannelID);
    nol.a(null, paramView.mSubscribeID, str2, str2, 0, 0, paramView.mFeedId + "", String.valueOf(this.jdField_a_of_type_Qds.a), String.valueOf(paramView.mAlgorithmID), str1, false);
    onh.a(paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pyk
 * JD-Core Version:    0.7.0.1
 */