package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/nearby/profilecard/NewNearbyProfileEditPanel$setNearbyTagInfo$2$1"}, k=3, mv={1, 1, 16})
final class NewNearbyProfileEditPanel$setNearbyTagInfo$$inlined$apply$lambda$1
  implements View.OnClickListener
{
  NewNearbyProfileEditPanel$setNearbyTagInfo$$inlined$apply$lambda$1(NewNearbyProfileEditPanel paramNewNearbyProfileEditPanel) {}
  
  public final void onClick(View paramView)
  {
    NearbyInterestsChooseDialog.Companion localCompanion = NearbyInterestsChooseDialog.a;
    paramView = NewNearbyProfileEditPanel.a(this.a);
    if (paramView == null) {
      paramView = this.a.G.nearbyTag;
    }
    NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.a.F;
    Intrinsics.checkExpressionValueIsNotNull(localNearbyPeopleProfileActivity, "mActivity");
    localCompanion.a(paramView, localNearbyPeopleProfileActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NewNearbyProfileEditPanel.setNearbyTagInfo..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */