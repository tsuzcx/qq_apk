import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.NativeCommentTextView;

public class oyi
  implements ValueAnimator.AnimatorUpdateListener
{
  String jdField_a_of_type_JavaLangString = NativeCommentTextView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView).a.commentId;
  
  public oyi(NativeCommentTextView paramNativeCommentTextView, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((NativeCommentTextView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView) == null) || (NativeCommentTextView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView).a == null) || (this.jdField_a_of_type_JavaLangString == null))
    {
      NativeCommentTextView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    if (!this.jdField_a_of_type_JavaLangString.equals(NativeCommentTextView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView).a.commentId))
    {
      NativeCommentTextView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    NativeCommentTextView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView).setAlpha(i);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(NativeCommentTextView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyi
 * JD-Core Version:    0.7.0.1
 */