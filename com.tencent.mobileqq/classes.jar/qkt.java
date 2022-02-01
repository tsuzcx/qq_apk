import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

class qkt
  implements ViewFactory.FoundClickableViewListener
{
  qkt(qks paramqks, int paramInt, TemplateBean paramTemplateBean) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if (qks.a(this.jdField_a_of_type_Qks) != null) {
      paramViewBase.setOnClickListener(new qku(this));
    }
    do
    {
      return;
      switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
      {
      default: 
        return;
      case 1038: 
        paramViewBase.setOnClickListener(new qkw(this));
        return;
      case 1040: 
        paramViewBase.setOnClickListener(new qkv(this));
        return;
      case 1130: 
        paramViewBase.setOnClickListener(new qkx(this));
        return;
      }
    } while ((this.jdField_a_of_type_Qks.a == null) || (this.jdField_a_of_type_Qks.a.a() == null));
    paramViewBase.setOnClickListener(new qff(this.jdField_a_of_type_Qks.a, qks.a(this.jdField_a_of_type_Qks).getContext(), 1115, this.jdField_a_of_type_Qks.a.e(), this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qkt
 * JD-Core Version:    0.7.0.1
 */