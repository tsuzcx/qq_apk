package com.tencent.tkd.topicsdk.adapter.widget;

import android.graphics.Bitmap;
import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.common.BitmapUtils;
import com.tencent.tkd.topicsdk.common.StackBlur;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class BigVideoCoverLayout$displayVideoCover$1
  extends Lambda
  implements Function0<Unit>
{
  BigVideoCoverLayout$displayVideoCover$1(BigVideoCoverLayout paramBigVideoCoverLayout, DisplayItem paramDisplayItem, int paramInt1, int paramInt2)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Bitmap localBitmap = BitmapUtils.a.a(this.$displayItem.getCoverPath());
    if (localBitmap != null)
    {
      ThreadManagerKt.a((Function0)new BigVideoCoverLayout.displayVideoCover.1..special..inlined.also.lambda.1(localBitmap, this));
      localBitmap = Bitmap.createScaledBitmap(localBitmap, this.$backgroundViewWidth / 2, this.$backgroundViewHeight / 2, false);
      StackBlur.a(localBitmap, 50);
      ThreadManagerKt.a((Function0)new BigVideoCoverLayout.displayVideoCover.1..special..inlined.also.lambda.2(localBitmap, this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.widget.BigVideoCoverLayout.displayVideoCover.1
 * JD-Core Version:    0.7.0.1
 */