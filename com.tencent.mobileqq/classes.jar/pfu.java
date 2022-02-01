import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

class pfu
  implements ViewFactory.FoundClickableViewListener
{
  pfu(pfs parampfs) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if ((paramViewBase.getNativeView() == null) || (paramViewBase.getClickEvnet() == null)) {
      return;
    }
    paramViewBase.setOnClickListener(new pfv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pfu
 * JD-Core Version:    0.7.0.1
 */