package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class NearbyProfileImageEditAdapter$onBindViewHolder$1
  implements View.OnClickListener
{
  NearbyProfileImageEditAdapter$onBindViewHolder$1(NearbyProfileImageEditAdapter paramNearbyProfileImageEditAdapter, int paramInt, NearbyProfileImageEditAdapter.ViewHolder paramViewHolder, PicInfo paramPicInfo) {}
  
  public final void onClick(View paramView)
  {
    paramView = NearbyProfileImageEditAdapter.a(this.a).F;
    ActionSheet localActionSheet = ActionSheet.create((Context)paramView);
    boolean bool;
    if (this.b != 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramView, "activity");
      localActionSheet.addButton((CharSequence)paramView.getResources().getString(2131892092));
    }
    localActionSheet.addButton((CharSequence)HardCodeUtil.a(2131905124));
    if ((bool) || (this.a.getItemCount() > 2)) {
      localActionSheet.addButton((CharSequence)HardCodeUtil.a(2131905201), 3);
    }
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener((ActionSheet.OnButtonClickListener)new NearbyProfileImageEditAdapter.onBindViewHolder.1.1(this, bool, paramView, localActionSheet));
    localActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileImageEditAdapter.onBindViewHolder.1
 * JD-Core Version:    0.7.0.1
 */