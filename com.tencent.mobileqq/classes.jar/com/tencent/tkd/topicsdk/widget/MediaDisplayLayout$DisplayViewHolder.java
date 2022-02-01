package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.tkd.R.id;
import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.bean.MediaType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/MediaDisplayLayout$DisplayViewHolder;", "", "layout", "Landroid/view/ViewGroup;", "(Lcom/tencent/tkd/topicsdk/widget/MediaDisplayLayout;Landroid/view/ViewGroup;)V", "changeCoverText", "Landroid/widget/TextView;", "getChangeCoverText", "()Landroid/widget/TextView;", "coverContainer", "Landroid/widget/RelativeLayout;", "getCoverContainer", "()Landroid/widget/RelativeLayout;", "coverUrl", "", "delImageContainer", "getDelImageContainer", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "itemView", "getItemView", "videoOperatorLayout", "getVideoOperatorLayout", "bindView", "", "item", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "getMediaCoverPath", "topicsdk_release"}, k=1, mv={1, 1, 16})
final class MediaDisplayLayout$DisplayViewHolder
{
  @NotNull
  private final RelativeLayout b;
  @NotNull
  private final RelativeLayout c;
  @NotNull
  private final RelativeLayout d;
  @NotNull
  private final RelativeLayout e;
  @NotNull
  private final TextView f;
  @NotNull
  private final ImageView g;
  private String h;
  
  public MediaDisplayLayout$DisplayViewHolder(ViewGroup paramViewGroup)
  {
    View localView = ((ViewGroup)localObject).findViewById(R.id.A);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.item_container)");
    this.b = ((RelativeLayout)localView);
    localView = ((ViewGroup)localObject).findViewById(R.id.ad);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.rl_cover_container)");
    this.c = ((RelativeLayout)localView);
    localView = ((ViewGroup)localObject).findViewById(R.id.ae);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.rl_del_media)");
    this.d = ((RelativeLayout)localView);
    localView = ((ViewGroup)localObject).findViewById(R.id.af);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.rl_video_operator)");
    this.e = ((RelativeLayout)localView);
    Object localObject = ((ViewGroup)localObject).findViewById(R.id.as);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "layout.findViewById(R.id.tv_change_cover)");
    this.f = ((TextView)localObject);
    this.h = "";
    localObject = new RelativeLayout.LayoutParams(paramViewGroup.getDisplayItemsHeight(), paramViewGroup.getDisplayItemsHeight());
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.g = new ImageView(paramViewGroup.getContext());
    this.g.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramViewGroup = new RelativeLayout.LayoutParams(-1, -1);
    this.c.addView((View)this.g, (ViewGroup.LayoutParams)paramViewGroup);
  }
  
  private final String b(DisplayItem paramDisplayItem)
  {
    if (paramDisplayItem.getMedia().getType() == MediaType.VIDEO)
    {
      int i = ((CharSequence)paramDisplayItem.getCoverPath()).length();
      int j = 1;
      if (i > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return paramDisplayItem.getCoverPath();
      }
      if (((CharSequence)paramDisplayItem.getMergePath()).length() > 0) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0) {
        return paramDisplayItem.getMergePath();
      }
    }
    return paramDisplayItem.getMedia().getFilePath();
  }
  
  @NotNull
  public final RelativeLayout a()
  {
    return this.b;
  }
  
  public final void a(@NotNull DisplayItem paramDisplayItem)
  {
    Intrinsics.checkParameterIsNotNull(paramDisplayItem, "item");
    String str = b(paramDisplayItem);
    Object localObject = paramDisplayItem.getMedia().getType();
    MediaType localMediaType = MediaType.PHOTO;
    int i = 0;
    if (localObject == localMediaType) {
      this.e.setVisibility(8);
    } else if (paramDisplayItem.getMedia().getType() == MediaType.VIDEO) {
      this.e.setVisibility(0);
    }
    this.h = str;
    if (((CharSequence)str).length() > 0) {
      i = 1;
    }
    if (i != 0)
    {
      paramDisplayItem = com.tencent.tkd.topicsdk.framework.bridge.ImageLoader.a;
      localObject = this.g.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "imageView.context");
      paramDisplayItem.a((Context)localObject).a(this.g).a(str);
    }
  }
  
  @NotNull
  public final RelativeLayout b()
  {
    return this.d;
  }
  
  @NotNull
  public final TextView c()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.MediaDisplayLayout.DisplayViewHolder
 * JD-Core Version:    0.7.0.1
 */