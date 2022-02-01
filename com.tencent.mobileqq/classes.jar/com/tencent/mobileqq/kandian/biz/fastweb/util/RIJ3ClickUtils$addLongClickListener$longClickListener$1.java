package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k=3, mv={1, 1, 16})
final class RIJ3ClickUtils$addLongClickListener$longClickListener$1
  implements View.OnLongClickListener
{
  RIJ3ClickUtils$addLongClickListener$longClickListener$1(FastWebActivity paramFastWebActivity, Container paramContainer) {}
  
  public final boolean onLongClick(View paramView)
  {
    RIJ3ClickUtils localRIJ3ClickUtils = RIJ3ClickUtils.a;
    FastWebActivity localFastWebActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity;
    Intrinsics.checkExpressionValueIsNotNull(paramView, "it");
    RIJ3ClickUtils.a(localRIJ3ClickUtils, localFastWebActivity, paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer);
    RIJ3ClickUtils.a(RIJ3ClickUtils.a);
    RIJ3ClickUtils.a(RIJ3ClickUtils.a, paramView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.RIJ3ClickUtils.addLongClickListener.longClickListener.1
 * JD-Core Version:    0.7.0.1
 */