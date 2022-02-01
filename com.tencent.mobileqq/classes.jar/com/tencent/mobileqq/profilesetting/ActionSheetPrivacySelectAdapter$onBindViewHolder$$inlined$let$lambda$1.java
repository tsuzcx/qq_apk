package com.tencent.mobileqq.profilesetting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/profilesetting/ActionSheetPrivacySelectAdapter$onBindViewHolder$1$1"}, k=3, mv={1, 1, 16})
final class ActionSheetPrivacySelectAdapter$onBindViewHolder$$inlined$let$lambda$1
  implements View.OnClickListener
{
  ActionSheetPrivacySelectAdapter$onBindViewHolder$$inlined$let$lambda$1(ActionSheetPrivacySelectAdapter.PrivacySelectActionSheetClickListener paramPrivacySelectActionSheetClickListener, ActionSheetPrivacySelectAdapter paramActionSheetPrivacySelectAdapter, ActionSheetPrivacySelectAdapter.PrivacyHolder paramPrivacyHolder, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    ActionSheetPrivacySelectAdapter.PrivacySelectActionSheetClickListener localPrivacySelectActionSheetClickListener = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view");
    localPrivacySelectActionSheetClickListener.a(paramView, (ActionSheetPrivacySelectAdapter.ActionSheetPrivacySelectBean)ActionSheetPrivacySelectAdapter.a(this.b).get(this.d));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ActionSheetPrivacySelectAdapter.onBindViewHolder..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */