import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class qdg
  implements ViewBase.OnClickListener
{
  qdg(qda paramqda, rfu paramrfu, ArticleInfo paramArticleInfo) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool = true;
    int i;
    ArticleInfo localArticleInfo;
    if (this.jdField_a_of_type_Rfu.a)
    {
      i = 2;
      qda.a(this.jdField_a_of_type_Qda, this.jdField_a_of_type_Rfu, i);
      paramViewBase = this.jdField_a_of_type_Qda;
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      if (this.jdField_a_of_type_Rfu.a) {
        break label60;
      }
    }
    for (;;)
    {
      qda.a(paramViewBase, localArticleInfo, bool);
      return;
      i = 1;
      break;
      label60:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qdg
 * JD-Core Version:    0.7.0.1
 */