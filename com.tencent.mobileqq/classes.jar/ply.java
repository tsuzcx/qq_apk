import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class ply
  implements ViewBase.OnClickListener
{
  ply(plx paramplx, int paramInt, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2, pgd parampgd) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ArticleInfo localArticleInfo1;
    String str;
    ArticleInfo localArticleInfo2;
    Object localObject;
    if (this.jdField_a_of_type_Int == 1120)
    {
      localArticleInfo1 = (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      str = this.b.innerUniqueID;
      localArticleInfo2 = localArticleInfo1;
      localObject = this.jdField_a_of_type_Pgd.a().mProteusTemplateBean;
      if (localObject != null)
      {
        paramViewBase = plx.a(this.jdField_a_of_type_Plx, (TemplateBean)localObject, paramViewBase);
        localObject = this.jdField_a_of_type_Pgd.a();
        if (this.jdField_a_of_type_Int != 1120) {
          break label130;
        }
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      ((rqj)localObject).a(bool, localArticleInfo1, localArticleInfo2, str, paramViewBase);
      return;
      localArticleInfo1 = (ArticleInfo)this.b;
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
      localArticleInfo2 = (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      localArticleInfo1.isTwoItem = true;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ply
 * JD-Core Version:    0.7.0.1
 */