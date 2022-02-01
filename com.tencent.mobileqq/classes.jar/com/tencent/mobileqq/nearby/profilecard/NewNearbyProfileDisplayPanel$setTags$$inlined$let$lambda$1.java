package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/nearby/profilecard/NewNearbyProfileDisplayPanel$setTags$3$1$3", "com/tencent/mobileqq/nearby/profilecard/NewNearbyProfileDisplayPanel$$special$$inlined$apply$lambda$1"}, k=3, mv={1, 1, 16})
final class NewNearbyProfileDisplayPanel$setTags$$inlined$let$lambda$1
  implements View.OnClickListener
{
  NewNearbyProfileDisplayPanel$setTags$$inlined$let$lambda$1(Pair paramPair, NewNearbyProfileDisplayPanel paramNewNearbyProfileDisplayPanel, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, NearbyPeopleCard paramNearbyPeopleCard) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.b.e;
    RecentUtil.a((Context)paramView, paramView.app, String.valueOf(((Number)this.a.first).longValue()), 1, (String)this.a.second, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NewNearbyProfileDisplayPanel.setTags..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */