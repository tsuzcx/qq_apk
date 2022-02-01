import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class oqz
  implements ViewBase.OnClickListener
{
  oqz(ViewBase paramViewBase, ouc paramouc, ouo paramouo) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
    paramViewBase = (ViewBase)localObject;
    if (!(localObject instanceof oxv)) {
      paramViewBase = null;
    }
    paramViewBase = (oxv)paramViewBase;
    if (paramViewBase != null)
    {
      paramViewBase = paramViewBase.getNativeView();
      if (paramViewBase != null) {
        paramViewBase.setBackgroundColor(Color.parseColor("#DBE5EF"));
      }
    }
    paramViewBase = this.jdField_a_of_type_Ouc;
    if (paramViewBase != null)
    {
      localObject = (Activity)this.jdField_a_of_type_Ouc.a;
      ViewBase localViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
      Intrinsics.checkExpressionValueIsNotNull(localViewBase, "commentContentView");
      paramViewBase.a((Activity)localObject, localViewBase.getNativeView(), this.jdField_a_of_type_Ouo, (bjoy)new ora(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqz
 * JD-Core Version:    0.7.0.1
 */