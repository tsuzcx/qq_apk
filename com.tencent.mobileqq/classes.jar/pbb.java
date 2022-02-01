import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;

class pbb
  extends ClickableSpan
{
  pbb(pay parampay, SubCommentData paramSubCommentData) {}
  
  public void onClick(View paramView)
  {
    paa.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataSubCommentData.repliedUserUin, BaseActivity.sTopActivity);
    paramView = new oyn(this.jdField_a_of_type_Pay).a().a();
    oat.a(null, paa.a(this.jdField_a_of_type_Pay.a), "0X800955B", "0X800955B", 0, 0, String.valueOf(this.jdField_a_of_type_Pay.a.mArticleID), String.valueOf(this.jdField_a_of_type_Pay.a.mAlgorithmID), this.jdField_a_of_type_Pay.a.innerUniqueID, paramView, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D7CAF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pbb
 * JD-Core Version:    0.7.0.1
 */