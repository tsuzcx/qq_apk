package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.graphics.Bitmap;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class ImageLoaderImpl$loadImageFromFile$runnable$1$1
  extends Lambda
  implements Function0<Unit>
{
  ImageLoaderImpl$loadImageFromFile$runnable$1$1(ImageLoaderImpl.loadImageFromFile.runnable.1 param1, Ref.ObjectRef paramObjectRef)
  {
    super(0);
  }
  
  public final void invoke()
  {
    ImageLoaderImpl.a(this.this$0.this$0).put(this.this$0.c, (Bitmap)this.$bitmap.element);
    if (Intrinsics.areEqual(this.this$0.b.getTag(), this.this$0.c)) {
      this.this$0.b.setImageBitmap((Bitmap)this.$bitmap.element);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.ImageLoaderImpl.loadImageFromFile.runnable.1.1
 * JD-Core Version:    0.7.0.1
 */