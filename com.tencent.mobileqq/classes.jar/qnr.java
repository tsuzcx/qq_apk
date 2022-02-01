import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentAccountSummary;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class qnr
  extends ClickableSpan
  implements skl
{
  private int jdField_a_of_type_Int = -1;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  boolean jdField_a_of_type_Boolean;
  
  public qnr(ComponentAccountSummary paramComponentAccountSummary, ArticleInfo paramArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidTextTextPaint != null) {
      updateDrawState(this.jdField_a_of_type_AndroidTextTextPaint);
    }
  }
  
  public void onClick(View paramView)
  {
    ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 3);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.jdField_a_of_type_AndroidTextTextPaint = paramTextPaint;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#285c95"));
    paramTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = this.jdField_a_of_type_Int;; i = 16119285)
    {
      paramTextPaint.bgColor = i;
      this.jdField_a_of_type_AndroidTextTextPaint.setUnderlineText(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qnr
 * JD-Core Version:    0.7.0.1
 */