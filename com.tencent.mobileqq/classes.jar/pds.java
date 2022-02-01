import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;

class pds
  extends ClickableSpan
{
  pds(pdp parampdp, SubCommentData paramSubCommentData) {}
  
  public void onClick(View paramView)
  {
    pbq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataSubCommentData.repliedUserUin, BaseActivity.sTopActivity);
    paramView = new paa(this.jdField_a_of_type_Pdp).a().a();
    olh.a(null, pbq.a(this.jdField_a_of_type_Pdp.a), "0X800955B", "0X800955B", 0, 0, String.valueOf(this.jdField_a_of_type_Pdp.a.mArticleID), String.valueOf(this.jdField_a_of_type_Pdp.a.mAlgorithmID), this.jdField_a_of_type_Pdp.a.innerUniqueID, paramView, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D7CAF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pds
 * JD-Core Version:    0.7.0.1
 */