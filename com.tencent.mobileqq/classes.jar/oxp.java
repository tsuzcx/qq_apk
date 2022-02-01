import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class oxp
  implements ViewBase.OnClickListener
{
  oxp(pan parampan, ViewBase paramViewBase, pay parampay) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.jdField_a_of_type_Pan.a();
    Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "adapter.vafContext");
    pha.a(paramViewBase.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getEventAttachedData());
    if (this.jdField_a_of_type_Pan.a() != null) {
      this.jdField_a_of_type_Pan.a().g(this.jdField_a_of_type_Pay);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oxp
 * JD-Core Version:    0.7.0.1
 */