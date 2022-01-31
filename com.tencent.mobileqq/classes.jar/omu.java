import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;

class omu
  extends ClickableSpan
{
  omu(omt paramomt, SubCommentData paramSubCommentData) {}
  
  public void onClick(View paramView)
  {
    olt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataSubCommentData.uin, BaseActivity.sTopActivity);
    paramView = new oke(this.jdField_a_of_type_Omt).a().a();
    nrt.a(null, olt.a(this.jdField_a_of_type_Omt.a), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.jdField_a_of_type_Omt.a.mArticleID), String.valueOf(this.jdField_a_of_type_Omt.a.mAlgorithmID), this.jdField_a_of_type_Omt.a.innerUniqueID, paramView, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     omu
 * JD-Core Version:    0.7.0.1
 */