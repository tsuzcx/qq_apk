package com.tencent.tkd.topicsdk.covergallery;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.common.BitmapUtils;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class CoverGalleryView$GalleryGridAdapter$getView$1
  implements View.OnClickListener
{
  CoverGalleryView$GalleryGridAdapter$getView$1(CoverGalleryView.GalleryGridAdapter paramGalleryGridAdapter, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    paramView = BitmapUtils.a.a(((Media)CoverGalleryView.a(this.jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView$GalleryGridAdapter.a).get(this.jdField_a_of_type_Int)).getFilePath());
    if (((Number)paramView.getFirst()).intValue() * ((Number)paramView.getSecond()).intValue() < 921600)
    {
      paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView$GalleryGridAdapter.a.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramView, "context");
      paramView = paramView.getResources().getString(R.string.k);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "context.resources.getStr…ing.cover_size_too_small)");
      TopicSDKHelperKt.a(paramView, false, null, 6, null);
      return;
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView$GalleryGridAdapter.a(this.jdField_a_of_type_Int);
    paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView$GalleryGridAdapter.a();
    if (paramView != null) {
      paramView = (Unit)paramView.invoke(Integer.valueOf(this.jdField_a_of_type_Int));
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView$GalleryGridAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.covergallery.CoverGalleryView.GalleryGridAdapter.getView.1
 * JD-Core Version:    0.7.0.1
 */