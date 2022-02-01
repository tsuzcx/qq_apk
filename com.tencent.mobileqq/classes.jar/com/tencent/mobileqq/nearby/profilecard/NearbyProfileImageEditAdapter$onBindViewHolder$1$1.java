package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.Collections;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k=3, mv={1, 1, 16})
final class NearbyProfileImageEditAdapter$onBindViewHolder$1$1
  implements ActionSheet.OnButtonClickListener
{
  NearbyProfileImageEditAdapter$onBindViewHolder$1$1(NearbyProfileImageEditAdapter.onBindViewHolder.1 param1, boolean paramBoolean, NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, ActionSheet paramActionSheet) {}
  
  public final void onClick(View paramView, int paramInt)
  {
    if (this.b)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt == 2) {
            NearbyProfileImageEditAdapter.a(this.a.a).a(this.a.d, this.a.c.itemView);
          }
        }
        else
        {
          paramView = AnimationUtils.a((View)this.a.c.a());
          this.c.showBigPhoto(this.a.d, paramView);
        }
      }
      else
      {
        Collections.swap(this.a.a.a(), 0, this.a.b);
        this.a.a.notifyDataSetChanged();
        NearbyProfileImageEditAdapter.a(this.a.a).o();
      }
    }
    else if (paramInt != 0)
    {
      if ((paramInt == 1) && (this.a.a.getItemCount() > 2)) {
        NearbyProfileImageEditAdapter.a(this.a.a).a(this.a.d, this.a.c.itemView);
      }
    }
    else
    {
      paramView = AnimationUtils.a((View)this.a.c.a());
      this.c.showBigPhoto(this.a.d, paramView);
    }
    this.d.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileImageEditAdapter.onBindViewHolder.1.1
 * JD-Core Version:    0.7.0.1
 */