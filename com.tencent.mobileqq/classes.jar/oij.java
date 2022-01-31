import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import org.jetbrains.annotations.NotNull;

class oij
  extends ClickableSpan
{
  oij(oif paramoif, BaseCommentData paramBaseCommentData, String paramString1, String paramString2) {}
  
  public void onClick(@NotNull View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAuthorReply()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage))) {
      ohf.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage, BaseActivity.sTopActivity);
    }
    for (;;)
    {
      nol.a(null, ohf.a(this.jdField_a_of_type_Oif.a), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.jdField_a_of_type_Oif.a.mArticleID), String.valueOf(this.jdField_a_of_type_Oif.a.mAlgorithmID), this.jdField_a_of_type_Oif.a.innerUniqueID, this.b, false);
      return;
      ohf.a(this.jdField_a_of_type_JavaLangString, BaseActivity.sTopActivity);
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
 * Qualified Name:     oij
 * JD-Core Version:    0.7.0.1
 */