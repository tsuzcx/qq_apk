import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

public class poc
  implements ViewFactory.FoundClickableViewListener
{
  poc(pob parampob, int paramInt, TemplateBean paramTemplateBean) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if (pob.a(this.jdField_a_of_type_Pob) != null)
    {
      paramViewBase.setOnClickListener(new pod(this));
      return;
    }
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return;
    case 1038: 
      paramViewBase.setOnClickListener(new pog(this));
      return;
    case 1116: 
      paramViewBase.setOnClickListener(new poe(this));
      return;
    case 1040: 
      paramViewBase.setOnClickListener(new pof(this));
      return;
    }
    paramViewBase.setOnClickListener(new poh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     poc
 * JD-Core Version:    0.7.0.1
 */