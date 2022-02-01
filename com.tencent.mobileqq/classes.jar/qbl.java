import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class qbl
  implements ViewBase.OnClickListener
{
  qbl(qbf paramqbf, rdl paramrdl, ArticleInfo paramArticleInfo) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool = true;
    int i;
    ArticleInfo localArticleInfo;
    if (this.jdField_a_of_type_Rdl.a)
    {
      i = 2;
      qbf.a(this.jdField_a_of_type_Qbf, this.jdField_a_of_type_Rdl, i);
      paramViewBase = this.jdField_a_of_type_Qbf;
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      if (this.jdField_a_of_type_Rdl.a) {
        break label60;
      }
    }
    for (;;)
    {
      qbf.a(paramViewBase, localArticleInfo, bool);
      return;
      i = 1;
      break;
      label60:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbl
 * JD-Core Version:    0.7.0.1
 */