import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;

class otq
  extends ClickableSpan
{
  otq(otp paramotp, SubCommentData paramSubCommentData) {}
  
  public void onClick(View paramView)
  {
    osp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataSubCommentData.uin, BaseActivity.sTopActivity);
    paramView = new orb(this.jdField_a_of_type_Otp).a().a();
    ocd.a(null, osp.a(this.jdField_a_of_type_Otp.a), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.jdField_a_of_type_Otp.a.mArticleID), String.valueOf(this.jdField_a_of_type_Otp.a.mAlgorithmID), this.jdField_a_of_type_Otp.a.innerUniqueID, paramView, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataSubCommentData.isAuthorSelection()) {}
    for (String str = "#FF8444";; str = "#737373")
    {
      paramTextPaint.setColor(Color.parseColor(str));
      paramTextPaint.setUnderlineText(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     otq
 * JD-Core Version:    0.7.0.1
 */