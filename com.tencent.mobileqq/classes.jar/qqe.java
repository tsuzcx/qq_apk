import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

public class qqe
  implements ViewFactory.FoundClickableViewListener
{
  public qqe(ReadInJoyFastWebBottomSocialViewNew paramReadInJoyFastWebBottomSocialViewNew, ProteusItemData paramProteusItemData, FastWebActivity paramFastWebActivity) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if ((paramViewBase instanceof oyl)) {
      ((oyl)paramViewBase).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.b, 2);
    }
    paramViewBase.setOnClickListener(new qqf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qqe
 * JD-Core Version:    0.7.0.1
 */