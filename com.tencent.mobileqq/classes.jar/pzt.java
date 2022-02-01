import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

public class pzt
  implements ViewBase.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  sel jdField_a_of_type_Sel;
  
  public pzt(ArticleInfo paramArticleInfo, Context paramContext, sel paramsel)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Sel = paramsel;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (sel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
      ozs.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 1, false, 0, 3);
    }
    for (;;)
    {
      oxw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Sel);
      pzu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009440", "0X8009443");
      return;
      ozs.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 0, false, 0, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pzt
 * JD-Core Version:    0.7.0.1
 */