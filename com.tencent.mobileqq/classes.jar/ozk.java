import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "viewBase", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ozk
  implements ViewBase.OnClickListener
{
  ozk(pdp parampdp, pcf parampcf) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    if (this.jdField_a_of_type_Pdp.a != null)
    {
      Object localObject = this.jdField_a_of_type_Pcf.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "adapter.vafContext");
      localObject = ((VafContext)localObject).getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "viewBase");
      pkh.a((Context)localObject, paramViewBase.getEventAttachedData());
      if (this.jdField_a_of_type_Pcf.a() != null) {
        this.jdField_a_of_type_Pcf.a().e(this.jdField_a_of_type_Pdp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ozk
 * JD-Core Version:    0.7.0.1
 */