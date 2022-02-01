package com.tencent.timi.game.liveroom.impl.view;

import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.timi.game.ex.ViewExKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AnchorPrivateGuideView$setPrivateBtnRect$1
  implements Runnable
{
  AnchorPrivateGuideView$setPrivateBtnRect$1(AnchorPrivateGuideView paramAnchorPrivateGuideView, Rect paramRect) {}
  
  public final void run()
  {
    AnchorPrivateGuideView.a(this.this$0, this.a);
    float f1 = this.a.centerX();
    float f2 = this.a.centerY();
    Rect localRect = new Rect();
    Object localObject = this.this$0.a(2131432709);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "eyePos");
    localRect.left = ViewExKt.c((View)localObject);
    localObject = this.this$0.a(2131432709);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "eyePos");
    localRect.top = ViewExKt.d((View)localObject);
    int i = localRect.left;
    localObject = this.this$0.a(2131432709);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "eyePos");
    localRect.right = (i + ((View)localObject).getWidth());
    i = localRect.top;
    localObject = this.this$0.a(2131432709);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "eyePos");
    localRect.bottom = (i + ((View)localObject).getHeight());
    localObject = (FrameLayout)this.this$0.a(2131440653);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "privateGuide");
    ((FrameLayout)localObject).setTranslationX(f1 - localRect.centerX());
    localObject = (FrameLayout)this.this$0.a(2131440653);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "privateGuide");
    ((FrameLayout)localObject).setTranslationY(f2 - localRect.centerY());
    this.this$0.postInvalidate();
    this.this$0.post((Runnable)new AnchorPrivateGuideView.setPrivateBtnRect.1.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorPrivateGuideView.setPrivateBtnRect.1
 * JD-Core Version:    0.7.0.1
 */