package com.tencent.tkd.topicsdk.adapter.widget;

import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke", "com/tencent/tkd/topicsdk/adapter/widget/BigVideoCoverLayout$displayVideoCover$1$1$1"}, k=3, mv={1, 1, 16})
final class BigVideoCoverLayout$displayVideoCover$1$$special$$inlined$also$lambda$1
  extends Lambda
  implements Function0<Unit>
{
  BigVideoCoverLayout$displayVideoCover$1$$special$$inlined$also$lambda$1(Bitmap paramBitmap, BigVideoCoverLayout.displayVideoCover.1 param1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    ViewGroup.LayoutParams localLayoutParams = BigVideoCoverLayout.a(this.this$0.this$0).getLayoutParams();
    localLayoutParams.width = ((int)(this.$it.getWidth() / this.$it.getHeight() * this.this$0.$backgroundViewHeight));
    BigVideoCoverLayout.a(this.this$0.this$0).setLayoutParams(localLayoutParams);
    BigVideoCoverLayout.a(this.this$0.this$0).setImageBitmap(this.$it);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.widget.BigVideoCoverLayout.displayVideoCover.1..special..inlined.also.lambda.1
 * JD-Core Version:    0.7.0.1
 */