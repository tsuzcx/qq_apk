package com.tencent.mobileqq.nearby.profilecard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyTag.ChildDetail;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/nearby/profilecard/NearbyInterestsChooseDialog$onCreateView$1$3$1$2$1", "com/tencent/mobileqq/nearby/profilecard/NearbyInterestsChooseDialog$$special$$inlined$apply$lambda$4", "com/tencent/mobileqq/nearby/profilecard/NearbyInterestsChooseDialog$$special$$inlined$forEach$lambda$4", "com/tencent/mobileqq/nearby/profilecard/NearbyInterestsChooseDialog$$special$$inlined$forEach$lambda$8"}, k=3, mv={1, 1, 16})
final class NearbyInterestsChooseDialog$onCreateView$$inlined$apply$lambda$5
  implements View.OnClickListener
{
  NearbyInterestsChooseDialog$onCreateView$$inlined$apply$lambda$5(Function0 paramFunction0, String paramString, NowSummaryCard.NearbyTag.ChildDetail paramChildDetail, ViewGroup paramViewGroup1, View paramView, ViewGroup paramViewGroup2, NearbyInterestsChooseDialog paramNearbyInterestsChooseDialog, LayoutInflater paramLayoutInflater) {}
  
  public final void onClick(View paramView)
  {
    this.c.checked.set(this.c.checked.get() ^ true);
    this.a.invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyInterestsChooseDialog.onCreateView..inlined.apply.lambda.5
 * JD-Core Version:    0.7.0.1
 */