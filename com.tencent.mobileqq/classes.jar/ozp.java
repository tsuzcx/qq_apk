import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ozp
  implements ViewBase.OnClickListener
{
  ozp(pcf parampcf, pdp parampdp) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.jdField_a_of_type_Pcf;
    if (paramViewBase == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListAdapter");
    }
    ((pau)paramViewBase).a(this.jdField_a_of_type_Pdp, ozx.a(this.jdField_a_of_type_Pdp, 0), 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ozp
 * JD-Core Version:    0.7.0.1
 */