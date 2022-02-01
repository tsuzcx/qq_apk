import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;

public class ooz
  extends ClickableSpan
{
  public ooz(CommentInfo paramCommentInfo1, CommentInfo paramCommentInfo2, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    osp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo.authorUin, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    paramView = new oss(this.b.articleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo).a(orv.a).b(this.b.area).c(0).a().a();
    ocd.a(null, osp.a(this.b.articleInfo), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.b.articleInfo.mArticleID), String.valueOf(this.b.articleInfo.mAlgorithmID), this.b.articleInfo.innerUniqueID, paramView, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D7CAF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ooz
 * JD-Core Version:    0.7.0.1
 */