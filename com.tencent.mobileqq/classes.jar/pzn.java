import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

public class pzn
  implements ViewBase.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  sel jdField_a_of_type_Sel;
  
  public pzn(ArticleInfo paramArticleInfo, Context paramContext, sel paramsel)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Sel = paramsel;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (sel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
      ozs.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 1, false, 0, 4);
    }
    for (;;)
    {
      oxw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Sel);
      pzu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009441", "0X8009444");
      return;
      ozs.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 0, false, 0, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pzn
 * JD-Core Version:    0.7.0.1
 */