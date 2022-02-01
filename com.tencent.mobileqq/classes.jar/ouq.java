import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;

class ouq
  extends ClickableSpan
{
  ouq(ouo paramouo, SubCommentData paramSubCommentData) {}
  
  public void onClick(View paramView)
  {
    oto.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataSubCommentData.repliedUserUin, BaseActivity.sTopActivity);
    paramView = new osa(this.jdField_a_of_type_Ouo).a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataSubCommentData.repliedUserUin).a();
    odq.a(null, oto.a(this.jdField_a_of_type_Ouo.a), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.jdField_a_of_type_Ouo.a.mArticleID), String.valueOf(this.jdField_a_of_type_Ouo.a.mAlgorithmID), this.jdField_a_of_type_Ouo.a.innerUniqueID, paramView, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#737373"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ouq
 * JD-Core Version:    0.7.0.1
 */