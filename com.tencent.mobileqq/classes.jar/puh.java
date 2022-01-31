import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

public class puh
  implements ViewFactory.FoundClickableViewListener
{
  puh(pug parampug, int paramInt, TemplateBean paramTemplateBean) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if (pug.a(this.jdField_a_of_type_Pug) != null)
    {
      paramViewBase.setOnClickListener(new pui(this));
      return;
    }
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return;
    case 1038: 
      paramViewBase.setOnClickListener(new pul(this));
      return;
    case 1116: 
      paramViewBase.setOnClickListener(new puj(this));
      return;
    case 1040: 
      paramViewBase.setOnClickListener(new puk(this));
      return;
    }
    paramViewBase.setOnClickListener(new pum(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     puh
 * JD-Core Version:    0.7.0.1
 */