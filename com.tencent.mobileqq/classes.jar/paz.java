import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;

class paz
  extends ClickableSpan
{
  paz(pay parampay, SubCommentData paramSubCommentData) {}
  
  public void onClick(View paramView)
  {
    paa.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataSubCommentData.uin, BaseActivity.sTopActivity);
    paramView = new oyn(this.jdField_a_of_type_Pay).a().a();
    oat.a(null, paa.a(this.jdField_a_of_type_Pay.a), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.jdField_a_of_type_Pay.a.mArticleID), String.valueOf(this.jdField_a_of_type_Pay.a.mAlgorithmID), this.jdField_a_of_type_Pay.a.innerUniqueID, paramView, false);
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
 * Qualified Name:     paz
 * JD-Core Version:    0.7.0.1
 */