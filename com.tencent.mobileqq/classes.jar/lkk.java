import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.CreateCommentInterface;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListFragment;
import com.tencent.mobileqq.widget.QQToast;

public class lkk
  implements ReadInJoyCommentUtils.CreateCommentInterface
{
  public lkk(ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment, String paramString) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.getActivity(), 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.getString(2131438860), 0).a();
  }
  
  public void a(String paramString, CommentInfo paramCommentInfo)
  {
    ReadInJoyCommentUtils.a(ReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment), this.jdField_a_of_type_JavaLangString);
    QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.getActivity(), 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.getString(2131438859), 0).a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(paramString, null, 1, paramCommentInfo);
    ReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment).notifyDataSetChanged();
    ReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lkk
 * JD-Core Version:    0.7.0.1
 */