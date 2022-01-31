import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;

public class plh
  implements ViewBase.IBuilder
{
  public ViewBase build(VafContext paramVafContext)
  {
    return new plf(paramVafContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     plh
 * JD-Core Version:    0.7.0.1
 */