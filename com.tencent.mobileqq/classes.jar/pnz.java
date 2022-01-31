import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

public class pnz
  implements ViewFactory.FoundClickableViewListener
{
  pnz(pny parampny, int paramInt, TemplateBean paramTemplateBean) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if (pny.a(this.jdField_a_of_type_Pny) != null)
    {
      paramViewBase.setOnClickListener(new poa(this));
      return;
    }
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return;
    case 1038: 
      paramViewBase.setOnClickListener(new pod(this));
      return;
    case 1116: 
      paramViewBase.setOnClickListener(new pob(this));
      return;
    case 1040: 
      paramViewBase.setOnClickListener(new poc(this));
      return;
    }
    paramViewBase.setOnClickListener(new poe(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pnz
 * JD-Core Version:    0.7.0.1
 */