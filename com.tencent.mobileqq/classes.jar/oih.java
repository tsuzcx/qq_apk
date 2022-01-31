import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;

class oih
  extends ClickableSpan
{
  oih(oif paramoif, SubCommentData paramSubCommentData) {}
  
  public void onClick(View paramView)
  {
    ohf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataSubCommentData.repliedUserUin, BaseActivity.sTopActivity);
    paramView = new ofs(this.jdField_a_of_type_Oif).a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataSubCommentData.repliedUserUin).a();
    nol.a(null, ohf.a(this.jdField_a_of_type_Oif.a), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.jdField_a_of_type_Oif.a.mArticleID), String.valueOf(this.jdField_a_of_type_Oif.a.mAlgorithmID), this.jdField_a_of_type_Oif.a.innerUniqueID, paramView, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#737373"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oih
 * JD-Core Version:    0.7.0.1
 */