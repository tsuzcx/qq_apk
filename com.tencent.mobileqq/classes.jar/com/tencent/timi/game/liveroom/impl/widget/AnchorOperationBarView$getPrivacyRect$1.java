package com.tencent.timi.game.liveroom.impl.widget;

import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import com.tencent.timi.game.ex.ViewExKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AnchorOperationBarView$getPrivacyRect$1
  implements Runnable
{
  AnchorOperationBarView$getPrivacyRect$1(AnchorOperationBarView paramAnchorOperationBarView, Function1 paramFunction1) {}
  
  public final void run()
  {
    Object localObject = (ImageView)this.this$0.a(2131440650);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "privacyIv");
    int i = ViewExKt.c((View)localObject);
    localObject = (ImageView)this.this$0.a(2131440650);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "privacyIv");
    int j = ViewExKt.d((View)localObject);
    localObject = this.a;
    Rect localRect = new Rect();
    localRect.left = i;
    localRect.top = j;
    ImageView localImageView = (ImageView)this.this$0.a(2131440650);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "privacyIv");
    localRect.right = (i + localImageView.getWidth());
    localImageView = (ImageView)this.this$0.a(2131440650);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "privacyIv");
    localRect.bottom = (j + localImageView.getHeight());
    ((Function1)localObject).invoke(localRect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AnchorOperationBarView.getPrivacyRect.1
 * JD-Core Version:    0.7.0.1
 */