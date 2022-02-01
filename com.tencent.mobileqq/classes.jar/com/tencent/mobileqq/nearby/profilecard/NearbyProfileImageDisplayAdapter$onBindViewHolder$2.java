package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.picbrowser.PicInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class NearbyProfileImageDisplayAdapter$onBindViewHolder$2
  implements View.OnClickListener
{
  NearbyProfileImageDisplayAdapter$onBindViewHolder$2(NearbyProfileImageDisplayAdapter paramNearbyProfileImageDisplayAdapter, NearbyProfileImageDisplayAdapter.VH paramVH, PicInfo paramPicInfo) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.a;
    ImageView localImageView = this.b.b();
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "p0.image");
    NearbyProfileImageDisplayAdapter.a(paramView, localImageView.getDrawable(), this.c, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileImageDisplayAdapter.onBindViewHolder.2
 * JD-Core Version:    0.7.0.1
 */