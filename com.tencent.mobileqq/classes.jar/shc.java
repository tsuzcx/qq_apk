import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

public class shc
  implements ViewFactory.FoundClickableViewListener
{
  public shc(ReadInJoyFastWebBottomSocialViewNew paramReadInJoyFastWebBottomSocialViewNew, ProteusItemData paramProteusItemData, FastWebActivity paramFastWebActivity) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    paramViewBase.setOnClickListener(new shd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     shc
 * JD-Core Version:    0.7.0.1
 */