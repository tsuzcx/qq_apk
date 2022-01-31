import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout.NativeRelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;
import java.util.List;

class rlu
  implements ViewFactory.FoundClickableViewListener
{
  rlu(rlt paramrlt, ProteusItemData paramProteusItemData, Context paramContext) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if (("id_interaction_ui_view".equals(paramViewBase.getName())) && ((paramViewBase instanceof NativeRelativeLayout)))
    {
      ViewBase localViewBase = (ViewBase)((NativeRelativeLayout)paramViewBase).getSubViews().get(0);
      if ((localViewBase instanceof pka)) {
        ((pka)localViewBase).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.b, 1);
      }
    }
    paramViewBase.setOnClickListener(new rlv(this, paramViewBase));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rlu
 * JD-Core Version:    0.7.0.1
 */