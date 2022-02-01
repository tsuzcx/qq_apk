package com.tencent.mobileqq.profilesetting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/profilesetting/ProfileBasePrivacySettingAdapter$onBindViewHolder$1$1"}, k=3, mv={1, 1, 16})
final class ProfileBasePrivacySettingAdapter$onBindViewHolder$$inlined$let$lambda$1
  implements View.OnClickListener
{
  ProfileBasePrivacySettingAdapter$onBindViewHolder$$inlined$let$lambda$1(ProfileBasePrivacySettingAdapter.PrivacySettingClickListener paramPrivacySettingClickListener, ProfileBasePrivacySettingAdapter paramProfileBasePrivacySettingAdapter, ProfileBasePrivacySettingAdapter.ProfileBaseHolder paramProfileBaseHolder, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    ProfileBasePrivacySettingAdapter.PrivacySettingClickListener localPrivacySettingClickListener = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view");
    localPrivacySettingClickListener.a(paramView, (ProfileDisplaySettingItem)ProfileBasePrivacySettingAdapter.a(this.b).get(this.d));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileBasePrivacySettingAdapter.onBindViewHolder..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */