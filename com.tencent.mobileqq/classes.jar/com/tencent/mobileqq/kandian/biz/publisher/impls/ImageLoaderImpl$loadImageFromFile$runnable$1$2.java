package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.widget.ImageView;
import com.tencent.tkd.topicsdk.interfaces.IImageLoader.ImageLoaderOption;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class ImageLoaderImpl$loadImageFromFile$runnable$1$2
  extends Lambda
  implements Function0<Unit>
{
  ImageLoaderImpl$loadImageFromFile$runnable$1$2(ImageLoaderImpl.loadImageFromFile.runnable.1 param1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    if (Intrinsics.areEqual(this.this$0.b.getTag(), this.this$0.c)) {
      this.this$0.b.setImageDrawable(this.this$0.a.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.ImageLoaderImpl.loadImageFromFile.runnable.1.2
 * JD-Core Version:    0.7.0.1
 */