import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.CreateCommentInterface;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

public class mpx
  implements ReadInJoyCommentUtils.CreateCommentInterface
{
  public mpx(FastWebActivity paramFastWebActivity, String paramString) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.getString(2131438902), 0).a();
  }
  
  public void a(String paramString, CommentInfo paramCommentInfo)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.getString(2131438901), 0).a();
    ReadInJoyCommentUtils.a(FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity), this.jdField_a_of_type_JavaLangString);
    paramString = FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity);
    paramString.b += 1L;
    ThreadManager.getUIHandler().post(new mpy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mpx
 * JD-Core Version:    0.7.0.1
 */