import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;

class oij
  extends ClickableSpan
{
  oij(oii paramoii, SubCommentData paramSubCommentData) {}
  
  public void onClick(View paramView)
  {
    ohi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataSubCommentData.uin, BaseActivity.sTopActivity);
    paramView = new ofv(this.jdField_a_of_type_Oii).a().a();
    noo.a(null, ohi.a(this.jdField_a_of_type_Oii.a), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.jdField_a_of_type_Oii.a.mArticleID), String.valueOf(this.jdField_a_of_type_Oii.a.mAlgorithmID), this.jdField_a_of_type_Oii.a.innerUniqueID, paramView, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oij
 * JD-Core Version:    0.7.0.1
 */