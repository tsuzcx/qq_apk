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
final class owu
  implements ViewBase.OnClickListener
{
  owu(pay parampay, pan parampan, Container paramContainer) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    if (opu.a(this.jdField_a_of_type_Pay)) {
      if ((this.jdField_a_of_type_Pay.a.advertisementInfo == null) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_Pay.a.advertisementInfo.mAdVideoUrl)) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_Pay.a.advertisementInfo.mAdViewId))) {
        break label101;
      }
    }
    label101:
    for (int i = 6;; i = 5)
    {
      paramViewBase = this.jdField_a_of_type_Pan.a();
      Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "adapter.vafContext");
      opu.a(paramViewBase.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_Pay, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     owu
 * JD-Core Version:    0.7.0.1
 */