import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class plz
  implements ViewBase.OnClickListener
{
  plz(plx paramplx, int paramInt, pgd parampgd, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool;
    rqj localrqj;
    if (this.jdField_a_of_type_Int == 1152)
    {
      bool = true;
      localrqj = this.jdField_a_of_type_Pgd.a();
      if (!bool) {
        break label43;
      }
    }
    label43:
    for (paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;; paramViewBase = this.b)
    {
      localrqj.b(bool, paramViewBase);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     plz
 * JD-Core Version:    0.7.0.1
 */