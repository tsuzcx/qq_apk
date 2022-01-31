import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

public class pck
  implements ViewFactory.FoundClickableViewListener
{
  pck(pcj parampcj, int paramInt, TemplateBean paramTemplateBean) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if (pcj.a(this.jdField_a_of_type_Pcj) != null)
    {
      paramViewBase.setOnClickListener(new pcl(this));
      return;
    }
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return;
    case 1038: 
      paramViewBase.setOnClickListener(new pco(this));
      return;
    case 1116: 
      paramViewBase.setOnClickListener(new pcm(this));
      return;
    case 1040: 
      paramViewBase.setOnClickListener(new pcn(this));
      return;
    }
    paramViewBase.setOnClickListener(new pcp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pck
 * JD-Core Version:    0.7.0.1
 */