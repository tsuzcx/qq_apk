package com.tencent.tkd.topicsdk.adapter.widget;

import android.graphics.Bitmap;
import com.tencent.tkd.topicsdk.common.BitmapUtils;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class BigVideoCoverLayout$displayHorizontalVideoCover$1
  extends Lambda
  implements Function0<Unit>
{
  BigVideoCoverLayout$displayHorizontalVideoCover$1(BigVideoCoverLayout paramBigVideoCoverLayout, String paramString)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Bitmap localBitmap = BitmapUtils.a.a(this.$coverPath);
    if (localBitmap != null) {
      ThreadManagerKt.a((Function0)new BigVideoCoverLayout.displayHorizontalVideoCover.1..special..inlined.run.lambda.1(localBitmap, this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.widget.BigVideoCoverLayout.displayHorizontalVideoCover.1
 * JD-Core Version:    0.7.0.1
 */