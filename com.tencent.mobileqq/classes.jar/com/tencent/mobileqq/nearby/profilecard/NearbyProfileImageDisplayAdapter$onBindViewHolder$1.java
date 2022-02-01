package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class NearbyProfileImageDisplayAdapter$onBindViewHolder$1
  implements View.OnClickListener
{
  NearbyProfileImageDisplayAdapter$onBindViewHolder$1(NearbyProfileImageDisplayAdapter paramNearbyProfileImageDisplayAdapter, List paramList) {}
  
  public final void onClick(View paramView)
  {
    paramView = NearbyProfileImageDisplayAdapter.a(this.a).e;
    if (this.b.size() >= NearbyProfileCardConstants.a)
    {
      localObject = (Context)paramView;
      Intrinsics.checkExpressionValueIsNotNull(paramView, "activity");
      QQToast.makeText((Context)localObject, 0, (CharSequence)paramView.getResources().getString(2131892083), 0).show();
      return;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramView, "activity");
    Object localObject = paramView.getResources().getStringArray(2130968636);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "activity.resources.getSt…_profile_card_menu_items)");
    ActionSheet localActionSheet = ActionSheet.create((Context)paramView);
    localActionSheet.addButton((CharSequence)localObject[28]);
    localActionSheet.addButton((CharSequence)localObject[29]);
    localActionSheet.addCancelButton((CharSequence)localObject[16]);
    localActionSheet.setOnButtonClickListener((ActionSheet.OnButtonClickListener)new NearbyProfileImageDisplayAdapter.onBindViewHolder.1.1(this, paramView, localActionSheet));
    localActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileImageDisplayAdapter.onBindViewHolder.1
 * JD-Core Version:    0.7.0.1
 */