import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class pwd
  implements ViewBase.OnClickListener
{
  pwd(pwa parampwa, int paramInt, ppu paramppu, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool;
    sel localsel;
    if (this.jdField_a_of_type_Int == 1160)
    {
      bool = true;
      localsel = this.jdField_a_of_type_Ppu.a();
      if (!bool) {
        break label43;
      }
    }
    label43:
    for (paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;; paramViewBase = this.b)
    {
      localsel.b(bool, paramViewBase);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pwd
 * JD-Core Version:    0.7.0.1
 */