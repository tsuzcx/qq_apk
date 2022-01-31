import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

public class owx
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private opw jdField_a_of_type_Opw;
  private qoe jdField_a_of_type_Qoe;
  
  public owx(ArticleInfo paramArticleInfo, Context paramContext, qoe paramqoe, opw paramopw, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Qoe = paramqoe;
    this.jdField_a_of_type_Opw = paramopw;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_Qoe == null) || (this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Opw == null)) {}
    while (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      return;
    }
    this.jdField_a_of_type_Qoe.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Opw.g());
    nzv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009A79", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     owx
 * JD-Core Version:    0.7.0.1
 */