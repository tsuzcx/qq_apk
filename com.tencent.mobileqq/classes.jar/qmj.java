import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

public class qmj
  implements ViewFactory.FoundClickableViewListener
{
  qmj(qmi paramqmi, int paramInt, TemplateBean paramTemplateBean) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if (qmi.a(this.jdField_a_of_type_Qmi) != null) {
      paramViewBase.setOnClickListener(new qmk(this));
    }
    do
    {
      return;
      switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
      {
      default: 
        return;
      case 1038: 
        paramViewBase.setOnClickListener(new qmn(this));
        return;
      case 1123: 
        paramViewBase.setOnClickListener(new qml(this));
        return;
      case 1040: 
        paramViewBase.setOnClickListener(new qmm(this));
        return;
      case 1131: 
        paramViewBase.setOnClickListener(new qmo(this));
        return;
      }
    } while ((this.jdField_a_of_type_Qmi.a == null) || (this.jdField_a_of_type_Qmi.a.a() == null));
    paramViewBase.setOnClickListener(new qha(this.jdField_a_of_type_Qmi.a, qmi.a(this.jdField_a_of_type_Qmi).getContext(), 1115, this.jdField_a_of_type_Qmi.a.e(), this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qmj
 * JD-Core Version:    0.7.0.1
 */