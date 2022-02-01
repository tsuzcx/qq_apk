package com.tencent.tkd.topicsdk.mediaselector;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class PreviewPhotoPage$onCreateView$2
  implements View.OnClickListener
{
  PreviewPhotoPage$onCreateView$2(PreviewPhotoPage paramPreviewPhotoPage) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.a.b().get(this.a.a());
    Intrinsics.checkExpressionValueIsNotNull(paramView, "photoList[currentPosition]");
    paramView = (String)paramView;
    if (this.a.a().contains(paramView)) {
      this.a.a().remove(paramView);
    } else {
      this.a.a().add(paramView);
    }
    PreviewPhotoPage.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.PreviewPhotoPage.onCreateView.2
 * JD-Core Version:    0.7.0.1
 */