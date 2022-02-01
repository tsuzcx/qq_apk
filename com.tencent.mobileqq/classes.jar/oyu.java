import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class oyu
  implements ViewBase.OnClickListener
{
  oyu(pcf parampcf, pdp parampdp) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    if ((this.jdField_a_of_type_Pcf.a() == null) || (this.jdField_a_of_type_Pdp.a == null)) {}
    do
    {
      return;
      paramViewBase = this.jdField_a_of_type_Pcf.a();
      Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "adapter.vafContext");
      pkh.a(paramViewBase.getContext(), this.jdField_a_of_type_Pdp.a.activityJumpUrl);
    } while (this.jdField_a_of_type_Pcf.a() == null);
    this.jdField_a_of_type_Pcf.a().e(this.jdField_a_of_type_Pdp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyu
 * JD-Core Version:    0.7.0.1
 */