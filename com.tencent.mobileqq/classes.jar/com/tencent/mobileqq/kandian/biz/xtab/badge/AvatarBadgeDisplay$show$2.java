package com.tencent.mobileqq.kandian.biz.xtab.badge;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "oldUin", "", "drawable", "Landroid/graphics/drawable/Drawable;", "invoke"}, k=3, mv={1, 1, 16})
final class AvatarBadgeDisplay$show$2
  extends Lambda
  implements Function2<Long, Drawable, Unit>
{
  AvatarBadgeDisplay$show$2(AvatarBadgeDisplay paramAvatarBadgeDisplay)
  {
    super(2);
  }
  
  public final void invoke(long paramLong, @NotNull Drawable paramDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "drawable");
    if (this.this$0.a(paramLong))
    {
      AvatarBadgeDisplay.IDisplayListener localIDisplayListener = this.this$0.a();
      if (localIDisplayListener != null) {
        localIDisplayListener.a(paramLong);
      }
      this.this$0.a(true);
      this.this$0.b();
      this.this$0.a(paramDrawable, true);
      this.this$0.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.badge.AvatarBadgeDisplay.show.2
 * JD-Core Version:    0.7.0.1
 */