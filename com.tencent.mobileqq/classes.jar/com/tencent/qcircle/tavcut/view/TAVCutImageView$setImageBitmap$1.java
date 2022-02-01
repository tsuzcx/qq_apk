package com.tencent.qcircle.tavcut.view;

import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TAVCutImageView$setImageBitmap$1
  implements Runnable
{
  TAVCutImageView$setImageBitmap$1(TAVCutImageView paramTAVCutImageView, List paramList, Bitmap paramBitmap) {}
  
  public final void run()
  {
    TAVCutImageView.access$setPoints$p(this.this$0, this.$points);
    TAVCutImageView localTAVCutImageView = this.this$0;
    TAVCutImageView.access$setInnerLines$p(localTAVCutImageView, localTAVCutImageView.makePointPairs(this.$points));
    localTAVCutImageView = this.this$0;
    localTAVCutImageView.setBitmapBound(TAVCutImageViewKt.calculateBitmap(localTAVCutImageView.getMeasuredWidth(), this.this$0.getMeasuredHeight(), this.$bitmap));
    if (!this.$bitmap.isRecycled()) {
      TAVCutImageView.access$getInnerImageView$p(this.this$0).setImageBitmap(this.$bitmap);
    }
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.view.TAVCutImageView.setImageBitmap.1
 * JD-Core Version:    0.7.0.1
 */