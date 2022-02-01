import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class qnx
  implements ViewBase.OnClickListener
{
  qnx(qnw paramqnw, int paramInt, qfw paramqfw, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    int i;
    szd localszd;
    if (this.jdField_a_of_type_Int == 1162)
    {
      i = 1;
      localszd = this.jdField_a_of_type_Qfw.a();
      if (i == 0) {
        break label42;
      }
    }
    label42:
    for (paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;; paramViewBase = this.b)
    {
      localszd.b(paramViewBase);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qnx
 * JD-Core Version:    0.7.0.1
 */