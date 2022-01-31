import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemSingle;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class qfe
  implements View.OnClickListener
{
  public qfe(ComponentTopicItemSingle paramComponentTopicItemSingle, qno paramqno) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.a();
    ors.a = paramView;
    ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.getContext(), this.jdField_a_of_type_Qno.b);
    String str1 = ors.a(paramView.mAlgorithmID, ors.a(paramView), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.e(), 0, 0, bdee.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.getContext()), paramView.mSubscribeID, null, paramView.innerUniqueID, null, paramView);
    String str2 = szp.b(paramView.mChannelID);
    nrt.a(null, paramView.mSubscribeID, str2, str2, 0, 0, paramView.mFeedId + "", String.valueOf(this.jdField_a_of_type_Qno.a), String.valueOf(paramView.mAlgorithmID), str1, false);
    ors.a(paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qfe
 * JD-Core Version:    0.7.0.1
 */