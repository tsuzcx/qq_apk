import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class pfs
  implements ViewBase.OnClickListener
{
  pfs(pfp parampfp, int paramInt, pau parampau, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    int i;
    ram localram;
    if (this.jdField_a_of_type_Int == 1152)
    {
      i = 1;
      localram = this.jdField_a_of_type_Pau.a();
      if (i == 0) {
        break label42;
      }
    }
    label42:
    for (paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;; paramViewBase = this.b)
    {
      localram.b(paramViewBase);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pfs
 * JD-Core Version:    0.7.0.1
 */