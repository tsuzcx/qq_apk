package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ThumbClipView$onThumbnailGenerated$1
  implements Runnable
{
  ThumbClipView$onThumbnailGenerated$1(ThumbClipView paramThumbClipView, Bitmap paramBitmap) {}
  
  public final void run()
  {
    ThumbClipView localThumbClipView = this.this$0;
    Resources localResources = localThumbClipView.getResources();
    Intrinsics.checkExpressionValueIsNotNull(localResources, "resources");
    localThumbClipView.setImageDrawable((Drawable)new SafeBitmapDrawable(localResources, this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ThumbClipView.onThumbnailGenerated.1
 * JD-Core Version:    0.7.0.1
 */