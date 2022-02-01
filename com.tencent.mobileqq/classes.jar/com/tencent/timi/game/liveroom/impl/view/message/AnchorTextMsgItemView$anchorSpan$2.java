package com.tencent.timi.game.liveroom.impl.view.message;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import com.tencent.timi.game.ex.LayoutExKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/text/SpannableStringBuilder;", "invoke"}, k=3, mv={1, 1, 16})
final class AnchorTextMsgItemView$anchorSpan$2
  extends Lambda
  implements Function0<SpannableStringBuilder>
{
  AnchorTextMsgItemView$anchorSpan$2(AnchorTextMsgItemView paramAnchorTextMsgItemView, Context paramContext)
  {
    super(0);
  }
  
  @NotNull
  public final SpannableStringBuilder invoke()
  {
    AnchorTextMsgItemView localAnchorTextMsgItemView = this.this$0;
    Bitmap localBitmap = BitmapFactory.decodeResource(this.$context.getResources(), 2130852889);
    Intrinsics.checkExpressionValueIsNotNull(localBitmap, "BitmapFactory.decodeReso….tg_anchor_msg_anchor_ic)");
    return localAnchorTextMsgItemView.a(localBitmap, LayoutExKt.b(28), LayoutExKt.b(16), 0, LayoutExKt.b(4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.message.AnchorTextMsgItemView.anchorSpan.2
 * JD-Core Version:    0.7.0.1
 */