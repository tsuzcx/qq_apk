import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class pfr
  implements ViewBase.OnClickListener
{
  pfr(pfp parampfp, int paramInt, pau parampau, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool;
    ram localram;
    if (this.jdField_a_of_type_Int == 1150)
    {
      bool = true;
      localram = this.jdField_a_of_type_Pau.a();
      if (!bool) {
        break label43;
      }
    }
    label43:
    for (paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;; paramViewBase = this.b)
    {
      localram.b(bool, paramViewBase);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pfr
 * JD-Core Version:    0.7.0.1
 */