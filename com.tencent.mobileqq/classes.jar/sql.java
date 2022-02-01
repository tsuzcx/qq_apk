import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

class sql
  implements ViewFactory.FoundClickableViewListener
{
  sql(sqk paramsqk) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    paramViewBase.setOnClickListener(new sqm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sql
 * JD-Core Version:    0.7.0.1
 */