import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;

class nwy
  extends ClickableSpan
{
  nwy(nwx paramnwx, SubCommentData paramSubCommentData) {}
  
  public void onClick(View paramView)
  {
    nvx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataSubCommentData.uin, BaseActivity.sTopActivity);
    paramView = new nuj(this.jdField_a_of_type_Nwx).a().a();
    ndn.a(null, nvx.a(this.jdField_a_of_type_Nwx.a), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.jdField_a_of_type_Nwx.a.mArticleID), String.valueOf(this.jdField_a_of_type_Nwx.a.mAlgorithmID), this.jdField_a_of_type_Nwx.a.innerUniqueID, paramView, false);
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
 * Qualified Name:     nwy
 * JD-Core Version:    0.7.0.1
 */