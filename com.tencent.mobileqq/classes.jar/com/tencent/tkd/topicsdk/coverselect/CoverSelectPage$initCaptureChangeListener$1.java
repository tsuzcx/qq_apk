package com.tencent.tkd.topicsdk.coverselect;

import android.graphics.Bitmap;
import com.tencent.tkd.topicsdk.covergallery.CoverGalleryView;
import com.tencent.tkd.topicsdk.videoprocess.videocapture.ImageUpdateListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/coverselect/CoverSelectPage$initCaptureChangeListener$1", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/ImageUpdateListener;", "onPreviewImageUpdate", "", "bitmap", "Landroid/graphics/Bitmap;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CoverSelectPage$initCaptureChangeListener$1
  implements ImageUpdateListener
{
  public void a(@Nullable Bitmap paramBitmap)
  {
    CoverSelectPage.a(this.a).a(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.coverselect.CoverSelectPage.initCaptureChangeListener.1
 * JD-Core Version:    0.7.0.1
 */