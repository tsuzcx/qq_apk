import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;

class omv
  extends ClickableSpan
{
  omv(omt paramomt, SubCommentData paramSubCommentData) {}
  
  public void onClick(View paramView)
  {
    olt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataSubCommentData.repliedUserUin, BaseActivity.sTopActivity);
    paramView = new oke(this.jdField_a_of_type_Omt).a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataSubCommentData.repliedUserUin).a();
    nrt.a(null, olt.a(this.jdField_a_of_type_Omt.a), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.jdField_a_of_type_Omt.a.mArticleID), String.valueOf(this.jdField_a_of_type_Omt.a.mAlgorithmID), this.jdField_a_of_type_Omt.a.innerUniqueID, paramView, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#737373"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     omv
 * JD-Core Version:    0.7.0.1
 */