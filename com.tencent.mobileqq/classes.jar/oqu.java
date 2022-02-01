import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class oqu
  implements ViewBase.OnClickListener
{
  oqu(ouc paramouc, ouo paramouo) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    if ((this.jdField_a_of_type_Ouc.a() == null) || (this.jdField_a_of_type_Ouo.a == null)) {}
    do
    {
      return;
      paramViewBase = this.jdField_a_of_type_Ouc.a();
      Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "adapter.vafContext");
      pay.a(paramViewBase.getContext(), this.jdField_a_of_type_Ouo.a.activityJumpUrl);
    } while (this.jdField_a_of_type_Ouc.a() == null);
    this.jdField_a_of_type_Ouc.a().e(this.jdField_a_of_type_Ouo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqu
 * JD-Core Version:    0.7.0.1
 */