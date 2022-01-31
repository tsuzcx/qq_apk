import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

public class pox
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private pgd jdField_a_of_type_Pgd;
  private rqj jdField_a_of_type_Rqj;
  
  public pox(ArticleInfo paramArticleInfo, Context paramContext, rqj paramrqj, pgd parampgd, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Rqj = paramrqj;
    this.jdField_a_of_type_Pgd = parampgd;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_Rqj == null) || (this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Pgd == null)) {}
    while (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      return;
    }
    this.jdField_a_of_type_Rqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Pgd.g());
    opn.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009A79", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pox
 * JD-Core Version:    0.7.0.1
 */