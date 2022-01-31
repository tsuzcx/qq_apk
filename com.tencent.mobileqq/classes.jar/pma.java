import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class pma
  implements ViewBase.OnClickListener
{
  pma(plx paramplx, int paramInt, pgd parampgd, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    int i;
    rqj localrqj;
    if (this.jdField_a_of_type_Int == 1154)
    {
      i = 1;
      localrqj = this.jdField_a_of_type_Pgd.a();
      if (i == 0) {
        break label42;
      }
    }
    label42:
    for (paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;; paramViewBase = this.b)
    {
      localrqj.b(paramViewBase);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pma
 * JD-Core Version:    0.7.0.1
 */