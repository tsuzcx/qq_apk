import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.CreateCommentInterface;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListFragment;
import com.tencent.mobileqq.widget.QQToast;

public class lkf
  implements ReadInJoyCommentUtils.CreateCommentInterface
{
  public lkf(ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment, String paramString) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.getActivity();
    if (paramString1 != null) {
      QQToast.a(paramString1, 1, 2131438878, 0).a();
    }
  }
  
  public void a(String paramString, CommentInfo paramCommentInfo)
  {
    ReadInJoyCommentUtils.a(ReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment), this.jdField_a_of_type_JavaLangString);
    FragmentActivity localFragmentActivity = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.getActivity();
    if (localFragmentActivity != null) {
      QQToast.a(localFragmentActivity, 0, 2131438877, 0).a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(paramString, null, 1, paramCommentInfo);
    ReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment).notifyDataSetChanged();
    ReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lkf
 * JD-Core Version:    0.7.0.1
 */