import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

public class pip
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private pax jdField_a_of_type_Pax;
  private rap jdField_a_of_type_Rap;
  
  public pip(ArticleInfo paramArticleInfo, Context paramContext, rap paramrap, pax parampax, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Rap = paramrap;
    this.jdField_a_of_type_Pax = parampax;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_Rap == null) || (this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Pax == null)) {}
    while (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      return;
    }
    this.jdField_a_of_type_Rap.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Pax.g());
    olg.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009A79", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pip
 * JD-Core Version:    0.7.0.1
 */