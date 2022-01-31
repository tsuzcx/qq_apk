import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class pft
  implements ViewBase.OnClickListener
{
  pft(pfs parampfs, int paramInt, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2, pax parampax) {}
  
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
      localObject = this.jdField_a_of_type_Pax.a().mProteusTemplateBean;
      if (localObject != null)
      {
        paramViewBase = pfs.a(this.jdField_a_of_type_Pfs, (TemplateBean)localObject, paramViewBase);
        localObject = this.jdField_a_of_type_Pax.a();
        if (this.jdField_a_of_type_Int != 1120) {
          break label130;
        }
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      ((rap)localObject).a(bool, localArticleInfo1, localArticleInfo2, str, paramViewBase);
      return;
      localArticleInfo1 = (ArticleInfo)this.b;
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
      localArticleInfo2 = (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      localArticleInfo1.isTwoItem = true;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pft
 * JD-Core Version:    0.7.0.1
 */