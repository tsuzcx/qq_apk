import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

class oit
  implements ViewFactory.FoundClickableViewListener
{
  oit(ois paramois, TemplateBean paramTemplateBean) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    }
    do
    {
      return;
    } while (!(paramViewBase instanceof qek));
    ((qek)paramViewBase).a(new oiu(this, paramViewBase));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oit
 * JD-Core Version:    0.7.0.1
 */