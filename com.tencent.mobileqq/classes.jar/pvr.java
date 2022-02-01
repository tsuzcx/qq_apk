import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class pvr
  implements ViewBase.OnClickListener
{
  pvr(pvl parampvl, qwn paramqwn, ArticleInfo paramArticleInfo) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool = true;
    int i;
    ArticleInfo localArticleInfo;
    if (this.jdField_a_of_type_Qwn.a)
    {
      i = 2;
      pvl.a(this.jdField_a_of_type_Pvl, this.jdField_a_of_type_Qwn, i);
      paramViewBase = this.jdField_a_of_type_Pvl;
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      if (this.jdField_a_of_type_Qwn.a) {
        break label60;
      }
    }
    for (;;)
    {
      pvl.a(paramViewBase, localArticleInfo, bool);
      return;
      i = 1;
      break;
      label60:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pvr
 * JD-Core Version:    0.7.0.1
 */