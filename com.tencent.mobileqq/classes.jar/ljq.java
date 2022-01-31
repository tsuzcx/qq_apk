import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.CreateCommentInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class ljq
  implements ReadInJoyCommentUtils.CreateCommentInterface
{
  public ljq(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment, String paramString) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QQToast.a(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(2131438878), 0).a();
  }
  
  public void a(String paramString, CommentInfo paramCommentInfo)
  {
    ReadInJoyCommentUtils.a(ReadInJoyCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment), this.jdField_a_of_type_JavaLangString);
    QQToast.a(BaseApplication.getContext(), 0, BaseApplication.getContext().getString(2131438877), 0).a();
    ReadInJoyCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment);
    ReadInJoyCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment).notifyDataSetChanged();
    ReadInJoyCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ljq
 * JD-Core Version:    0.7.0.1
 */