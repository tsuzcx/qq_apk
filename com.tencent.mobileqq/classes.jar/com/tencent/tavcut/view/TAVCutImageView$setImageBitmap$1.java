package com.tencent.tavcut.view;

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
    TAVCutImageView.access$setPoints$p(this.this$0, this.jdField_a_of_type_JavaUtilList);
    TAVCutImageView localTAVCutImageView = this.this$0;
    TAVCutImageView.access$setInnerLines$p(localTAVCutImageView, localTAVCutImageView.makePointPairs(this.jdField_a_of_type_JavaUtilList));
    localTAVCutImageView = this.this$0;
    localTAVCutImageView.setBitmapBound(TAVCutImageViewKt.a(localTAVCutImageView.getMeasuredWidth(), this.this$0.getMeasuredHeight(), this.jdField_a_of_type_AndroidGraphicsBitmap));
    if (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
      TAVCutImageView.access$getInnerImageView$p(this.this$0).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.view.TAVCutImageView.setImageBitmap.1
 * JD-Core Version:    0.7.0.1
 */