import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class qnn
  implements ViewBase.OnClickListener
{
  qnn(qnj paramqnj, rpr paramrpr, ArticleInfo paramArticleInfo) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool = true;
    int i;
    ArticleInfo localArticleInfo;
    if (this.jdField_a_of_type_Rpr.a)
    {
      i = 2;
      qnj.a(this.jdField_a_of_type_Qnj, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i);
      paramViewBase = this.jdField_a_of_type_Qnj;
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      if (this.jdField_a_of_type_Rpr.a) {
        break label60;
      }
    }
    for (;;)
    {
      qnj.a(paramViewBase, localArticleInfo, bool);
      return;
      i = 1;
      break;
      label60:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qnn
 * JD-Core Version:    0.7.0.1
 */