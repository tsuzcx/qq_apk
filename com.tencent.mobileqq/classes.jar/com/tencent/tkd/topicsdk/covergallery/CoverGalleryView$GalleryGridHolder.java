package com.tencent.tkd.topicsdk.covergallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.tkd.R.id;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/covergallery/CoverGalleryView$GalleryGridHolder;", "", "layout", "Landroid/view/ViewGroup;", "(Lcom/tencent/tkd/topicsdk/covergallery/CoverGalleryView;Landroid/view/ViewGroup;)V", "coverImageView", "Landroid/widget/ImageView;", "value", "", "imagePath", "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "itemView", "Landroid/widget/RelativeLayout;", "getItemView", "()Landroid/widget/RelativeLayout;", "shadowView", "Landroid/view/View;", "getShadowView", "()Landroid/view/View;", "strokeView", "getStrokeView", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CoverGalleryView$GalleryGridHolder
{
  @NotNull
  private final View jdField_a_of_type_AndroidViewView;
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  @NotNull
  private final RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private final View b;
  
  public CoverGalleryView$GalleryGridHolder(ViewGroup paramViewGroup)
  {
    Object localObject2 = ((ViewGroup)localObject1).findViewById(R.id.T);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "layout.findViewById(R.id.item_container)");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
    localObject2 = ((ViewGroup)localObject1).findViewById(R.id.Z);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "layout.findViewById(R.id.iv_cover)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
    localObject2 = ((ViewGroup)localObject1).findViewById(R.id.bz);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "layout.findViewById(R.id.view_stroke)");
    this.jdField_a_of_type_AndroidViewView = ((View)localObject2);
    Object localObject1 = ((ViewGroup)localObject1).findViewById(R.id.by);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "layout.findViewById(R.id.view_shadow)");
    this.b = ((View)localObject1);
    this.jdField_a_of_type_JavaLangString = "";
    localObject1 = DisplayUtils.a;
    localObject2 = paramViewGroup.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    int i = ((DisplayUtils)localObject1).a((Context)localObject2, 2.0F);
    localObject1 = DisplayUtils.a;
    paramViewGroup = paramViewGroup.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "context");
    i = (((DisplayUtils)localObject1).a(paramViewGroup) - i * 3) / 4;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(i, i));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  @NotNull
  public final View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  @NotNull
  public final RelativeLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.jdField_a_of_type_JavaLangString = paramString;
    int i;
    if (((CharSequence)this.jdField_a_of_type_JavaLangString).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      com.tencent.tkd.topicsdk.framework.bridge.ImageLoader localImageLoader = com.tencent.tkd.topicsdk.framework.bridge.ImageLoader.a;
      Context localContext = this.jdField_a_of_type_AndroidWidgetImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "coverImageView.context");
      localImageLoader.a(localContext).a(this.jdField_a_of_type_AndroidWidgetImageView).a(this.jdField_a_of_type_AndroidWidgetImageView.getWidth(), this.jdField_a_of_type_AndroidWidgetImageView.getHeight()).a(paramString);
    }
  }
  
  @NotNull
  public final View b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.covergallery.CoverGalleryView.GalleryGridHolder
 * JD-Core Version:    0.7.0.1
 */