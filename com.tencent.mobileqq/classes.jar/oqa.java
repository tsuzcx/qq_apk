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
final class oqa
  implements ViewBase.OnClickListener
{
  oqa(otp paramotp, Container paramContainer, otd paramotd, ViewBase paramViewBase) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    if ((tpk.a(this.jdField_a_of_type_Otp)) && (this.jdField_a_of_type_Otp.a.advertisementInfo != null))
    {
      paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView().findViewBaseByName("id_comment_tail_3_dot");
      localObject = this.jdField_a_of_type_Otd.jdField_a_of_type_Toa;
      Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "idCommentTail3Dot");
      ((toa)localObject).a(paramViewBase.getNativeView(), this.jdField_a_of_type_Otp.a.advertisementInfo);
    }
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
      paramViewBase = (ViewBase)localObject;
      if (!(localObject instanceof owv)) {
        paramViewBase = null;
      }
      paramViewBase = (owv)paramViewBase;
      if (paramViewBase != null)
      {
        paramViewBase = paramViewBase.getNativeView();
        if (paramViewBase != null) {
          paramViewBase.setBackgroundColor(Color.parseColor("#DBE5EF"));
        }
      }
      paramViewBase = this.jdField_a_of_type_Otd;
    } while (paramViewBase == null);
    Object localObject = (Activity)this.jdField_a_of_type_Otd.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    ViewBase localViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
    Intrinsics.checkExpressionValueIsNotNull(localViewBase, "commentContentView");
    paramViewBase.a((Activity)localObject, localViewBase.getNativeView(), this.jdField_a_of_type_Otp, (blkc)new oqb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqa
 * JD-Core Version:    0.7.0.1
 */