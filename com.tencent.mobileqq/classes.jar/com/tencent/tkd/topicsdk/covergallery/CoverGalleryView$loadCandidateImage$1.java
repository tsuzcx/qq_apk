package com.tencent.tkd.topicsdk.covergallery;

import android.graphics.Bitmap;
import com.tencent.tkd.topicsdk.common.BitmapUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class CoverGalleryView$loadCandidateImage$1
  extends Lambda
  implements Function0<Unit>
{
  CoverGalleryView$loadCandidateImage$1(CoverGalleryView paramCoverGalleryView, String paramString)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Bitmap localBitmap = BitmapUtils.a.a(this.$path);
    CoverGalleryView.a(this.this$0, localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.covergallery.CoverGalleryView.loadCandidateImage.1
 * JD-Core Version:    0.7.0.1
 */