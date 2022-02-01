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
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  @NotNull
  private final RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  @NotNull
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private final RelativeLayout b;
  @NotNull
  private final RelativeLayout c;
  @NotNull
  private final RelativeLayout d;
  
  public MediaDisplayLayout$DisplayViewHolder(ViewGroup paramViewGroup)
  {
    View localView = ((ViewGroup)localObject).findViewById(R.id.T);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.item_container)");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView);
    localView = ((ViewGroup)localObject).findViewById(R.id.aB);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.rl_cover_container)");
    this.b = ((RelativeLayout)localView);
    localView = ((ViewGroup)localObject).findViewById(R.id.aC);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.rl_del_media)");
    this.c = ((RelativeLayout)localView);
    localView = ((ViewGroup)localObject).findViewById(R.id.aD);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.rl_video_operator)");
    this.d = ((RelativeLayout)localView);
    Object localObject = ((ViewGroup)localObject).findViewById(R.id.aR);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "layout.findViewById(R.id.tv_change_cover)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    this.jdField_a_of_type_JavaLangString = "";
    localObject = new RelativeLayout.LayoutParams(paramViewGroup.a(), paramViewGroup.a());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramViewGroup.getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramViewGroup = new RelativeLayout.LayoutParams(-1, -1);
    this.b.addView((View)this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)paramViewGroup);
  }
  
  private final String a(DisplayItem paramDisplayItem)
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
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  @NotNull
  public final TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public final void a(@NotNull DisplayItem paramDisplayItem)
  {
    Intrinsics.checkParameterIsNotNull(paramDisplayItem, "item");
    String str = a(paramDisplayItem);
    Object localObject = paramDisplayItem.getMedia().getType();
    MediaType localMediaType = MediaType.PHOTO;
    int i = 0;
    if (localObject == localMediaType) {
      this.d.setVisibility(8);
    } else if (paramDisplayItem.getMedia().getType() == MediaType.VIDEO) {
      this.d.setVisibility(0);
    }
    this.jdField_a_of_type_JavaLangString = str;
    if (((CharSequence)str).length() > 0) {
      i = 1;
    }
    if (i != 0)
    {
      paramDisplayItem = com.tencent.tkd.topicsdk.framework.bridge.ImageLoader.a;
      localObject = this.jdField_a_of_type_AndroidWidgetImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "imageView.context");
      paramDisplayItem.a((Context)localObject).a(this.jdField_a_of_type_AndroidWidgetImageView).a(str);
    }
  }
  
  @NotNull
  public final RelativeLayout b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.MediaDisplayLayout.DisplayViewHolder
 * JD-Core Version:    0.7.0.1
 */