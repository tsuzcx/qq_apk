import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

class qev
  implements ViewFactory.FoundClickableViewListener
{
  qev(qeu paramqeu, int paramInt, TemplateBean paramTemplateBean) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if (qeu.a(this.jdField_a_of_type_Qeu) != null) {
      paramViewBase.setOnClickListener(new qew(this));
    }
    do
    {
      return;
      switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
      {
      default: 
        return;
      case 1038: 
        paramViewBase.setOnClickListener(new qey(this));
        return;
      case 1040: 
        paramViewBase.setOnClickListener(new qex(this));
        return;
      case 1130: 
        paramViewBase.setOnClickListener(new qez(this));
        return;
      }
    } while ((this.jdField_a_of_type_Qeu.a == null) || (this.jdField_a_of_type_Qeu.a.a() == null));
    paramViewBase.setOnClickListener(new pzl(this.jdField_a_of_type_Qeu.a, qeu.a(this.jdField_a_of_type_Qeu).getContext(), 1115, this.jdField_a_of_type_Qeu.a.e(), this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qev
 * JD-Core Version:    0.7.0.1
 */