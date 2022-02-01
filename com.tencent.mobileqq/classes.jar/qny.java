import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class qny
  implements ViewBase.OnClickListener
{
  qny(qnw paramqnw, int paramInt, qfw paramqfw, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool;
    szd localszd;
    if (this.jdField_a_of_type_Int == 1160)
    {
      bool = true;
      localszd = this.jdField_a_of_type_Qfw.a();
      if (!bool) {
        break label43;
      }
    }
    label43:
    for (paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;; paramViewBase = this.b)
    {
      localszd.a(bool, paramViewBase);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qny
 * JD-Core Version:    0.7.0.1
 */