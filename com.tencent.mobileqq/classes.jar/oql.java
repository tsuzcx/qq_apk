import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "viewBase", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class oql
  implements ViewBase.OnClickListener
{
  oql(otp paramotp, otd paramotd, Container paramContainer) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    if (tpk.a(this.jdField_a_of_type_Otp))
    {
      paramViewBase = this.jdField_a_of_type_Otd.a();
      Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "adapter.vafContext");
      tpk.a(paramViewBase.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_Otp, 1000);
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Otp.a == null);
      Object localObject = this.jdField_a_of_type_Otd.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "adapter.vafContext");
      localObject = ((VafContext)localObject).getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "viewBase");
      ozs.a((Context)localObject, paramViewBase.getEventAttachedData());
    } while (this.jdField_a_of_type_Otd.a() == null);
    this.jdField_a_of_type_Otd.a().e(this.jdField_a_of_type_Otp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oql
 * JD-Core Version:    0.7.0.1
 */