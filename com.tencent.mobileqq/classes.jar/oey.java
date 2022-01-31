import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;

public class oey
  extends ClickableSpan
{
  public oey(CommentInfo paramCommentInfo1, CommentInfo paramCommentInfo2, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    ohf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo.toUin, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    paramView = new ohi(this.b.articleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo).a(ogn.a).b(this.b.area).c(0).a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo.toUin).a();
    nol.a(null, ohf.a(this.b.articleInfo), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.b.articleInfo.mArticleID), String.valueOf(this.b.articleInfo.mAlgorithmID), this.b.articleInfo.innerUniqueID, paramView, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D7CAF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oey
 * JD-Core Version:    0.7.0.1
 */