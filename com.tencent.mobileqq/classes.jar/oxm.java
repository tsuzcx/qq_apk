import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class oxm
  implements ViewBase.OnClickListener
{
  oxm(pay parampay, Container paramContainer, pan parampan, ViewBase paramViewBase) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    if ((opu.a(this.jdField_a_of_type_Pay)) && (this.jdField_a_of_type_Pay.a.advertisementInfo != null))
    {
      paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView().findViewBaseByName("id_comment_tail_3_dot");
      localObject = this.jdField_a_of_type_Pan.jdField_a_of_type_Oop;
      Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "idCommentTail3Dot");
      ((oop)localObject).a(paramViewBase.getNativeView(), this.jdField_a_of_type_Pay.a.advertisementInfo);
    }
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
      paramViewBase = (ViewBase)localObject;
      if (!(localObject instanceof ped)) {
        paramViewBase = null;
      }
      paramViewBase = (ped)paramViewBase;
      if (paramViewBase != null)
      {
        paramViewBase = paramViewBase.getNativeView();
        if (paramViewBase != null) {
          paramViewBase.setBackgroundColor(Color.parseColor("#DBE5EF"));
        }
      }
      paramViewBase = this.jdField_a_of_type_Pan;
    } while (paramViewBase == null);
    Object localObject = (Activity)this.jdField_a_of_type_Pan.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    ViewBase localViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
    Intrinsics.checkExpressionValueIsNotNull(localViewBase, "commentContentView");
    paramViewBase.a((Activity)localObject, localViewBase.getNativeView(), this.jdField_a_of_type_Pay, (bkiz)new oxn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oxm
 * JD-Core Version:    0.7.0.1
 */