import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

public class rcm
  implements ViewFactory.FoundClickableViewListener
{
  public rcm(ReadInJoyFastWebBottomSocialViewNew paramReadInJoyFastWebBottomSocialViewNew, ProteusItemData paramProteusItemData, FastWebActivity paramFastWebActivity) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if ((paramViewBase instanceof pka)) {
      ((pka)paramViewBase).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.b, 2);
    }
    paramViewBase.setOnClickListener(new rcn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rcm
 * JD-Core Version:    0.7.0.1
 */