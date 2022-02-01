import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class opi
  implements ViewBase.OnClickListener
{
  opi(otp paramotp, otd paramotd, Container paramContainer) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    if (tpk.a(this.jdField_a_of_type_Otp)) {
      if ((this.jdField_a_of_type_Otp.a.advertisementInfo == null) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_Otp.a.advertisementInfo.mAdVideoUrl)) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_Otp.a.advertisementInfo.mAdViewId))) {
        break label101;
      }
    }
    label101:
    for (int i = 6;; i = 5)
    {
      paramViewBase = this.jdField_a_of_type_Otd.a();
      Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "adapter.vafContext");
      tpk.a(paramViewBase.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_Otp, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     opi
 * JD-Core Version:    0.7.0.1
 */