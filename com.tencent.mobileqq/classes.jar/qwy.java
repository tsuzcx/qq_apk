import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

class qwy
  implements ViewFactory.FoundClickableViewListener
{
  qwy(qwx paramqwx, int paramInt, TemplateBean paramTemplateBean) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if (qwx.a(this.jdField_a_of_type_Qwx) != null) {
      paramViewBase.setOnClickListener(new qwz(this));
    }
    do
    {
      return;
      switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
      {
      default: 
        return;
      case 1038: 
        paramViewBase.setOnClickListener(new qxb(this));
        return;
      case 1040: 
        paramViewBase.setOnClickListener(new qxa(this));
        return;
      case 1130: 
        paramViewBase.setOnClickListener(new qxc(this));
        return;
      }
    } while ((this.jdField_a_of_type_Qwx.a == null) || (this.jdField_a_of_type_Qwx.a.a() == null));
    paramViewBase.setOnClickListener(new qrh(this.jdField_a_of_type_Qwx.a, qwx.a(this.jdField_a_of_type_Qwx).getContext(), 1115, this.jdField_a_of_type_Qwx.a.e(), this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qwy
 * JD-Core Version:    0.7.0.1
 */