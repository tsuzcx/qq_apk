import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class our
  implements ViewBase.OnClickListener
{
  our(ouq paramouq, int paramInt, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2, opw paramopw) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool = true;
    ArticleInfo localArticleInfo1;
    ArticleInfo localArticleInfo2;
    qoe localqoe;
    if (this.jdField_a_of_type_Int == 1120)
    {
      localArticleInfo1 = (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      paramViewBase = this.b.innerUniqueID;
      localArticleInfo2 = localArticleInfo1;
      localqoe = this.jdField_a_of_type_Opw.a();
      if (this.jdField_a_of_type_Int != 1120) {
        break label97;
      }
    }
    for (;;)
    {
      localqoe.a(bool, localArticleInfo2, localArticleInfo1, paramViewBase);
      return;
      localArticleInfo2 = (ArticleInfo)this.b;
      paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
      localArticleInfo1 = (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      localArticleInfo2.isTwoItem = true;
      break;
      label97:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     our
 * JD-Core Version:    0.7.0.1
 */