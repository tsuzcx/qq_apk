import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import org.jetbrains.annotations.NotNull;

class nxb
  extends ClickableSpan
{
  nxb(nwx paramnwx, BaseCommentData paramBaseCommentData, String paramString1, String paramString2) {}
  
  public void onClick(@NotNull View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAuthorReply()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage))) {
      nvx.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage, BaseActivity.sTopActivity);
    }
    for (;;)
    {
      ndn.a(null, nvx.a(this.jdField_a_of_type_Nwx.a), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.jdField_a_of_type_Nwx.a.mArticleID), String.valueOf(this.jdField_a_of_type_Nwx.a.mAlgorithmID), this.jdField_a_of_type_Nwx.a.innerUniqueID, this.b, false);
      return;
      nvx.a(this.jdField_a_of_type_JavaLangString, BaseActivity.sTopActivity);
    }
  }
  
  public void updateDrawState(@NotNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#376099"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nxb
 * JD-Core Version:    0.7.0.1
 */