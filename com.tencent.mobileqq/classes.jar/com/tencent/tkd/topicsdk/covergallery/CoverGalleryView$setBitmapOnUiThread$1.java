package com.tencent.tkd.topicsdk.covergallery;

import android.graphics.Bitmap;
import com.tencent.tkd.topicsdk.ucrop.view.GestureCropImageView;
import com.tencent.tkd.topicsdk.ucrop.view.UCropView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class CoverGalleryView$setBitmapOnUiThread$1
  extends Lambda
  implements Function0<Unit>
{
  CoverGalleryView$setBitmapOnUiThread$1(CoverGalleryView paramCoverGalleryView, Bitmap paramBitmap)
  {
    super(0);
  }
  
  public final void invoke()
  {
    CoverGalleryView.a(this.this$0).a().setImageBitmap(this.$bitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.covergallery.CoverGalleryView.setBitmapOnUiThread.1
 * JD-Core Version:    0.7.0.1
 */