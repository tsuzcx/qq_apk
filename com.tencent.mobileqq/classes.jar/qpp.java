import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class qpp
  extends ClickableSpan
  implements skl
{
  private int jdField_a_of_type_Int = -1;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  boolean jdField_a_of_type_Boolean;
  
  public qpp(ComponentHeaderNewSocial paramComponentHeaderNewSocial, ArticleInfo paramArticleInfo, int paramInt)
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
    if (sel.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 0, false, 5, false);
      sel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.a.a.e());
      return;
    }
    ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.jdField_a_of_type_AndroidTextTextPaint = paramTextPaint;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#285c95"));
    paramTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = this.jdField_a_of_type_Int;; i = -1)
    {
      paramTextPaint.bgColor = i;
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(agej.a(2, 14, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.getResources()));
      this.jdField_a_of_type_AndroidTextTextPaint.setUnderlineText(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpp
 * JD-Core Version:    0.7.0.1
 */