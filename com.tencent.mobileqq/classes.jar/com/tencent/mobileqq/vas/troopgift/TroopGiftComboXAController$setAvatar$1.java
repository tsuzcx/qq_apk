package com.tencent.mobileqq.vas.troopgift;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGView;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "Lorg/libpag/PAGView;", "invoke"}, k=3, mv={1, 1, 16})
final class TroopGiftComboXAController$setAvatar$1
  extends Lambda
  implements Function1<PAGView, Bitmap>
{
  TroopGiftComboXAController$setAvatar$1(Drawable paramDrawable)
  {
    super(1);
  }
  
  public final Bitmap invoke(@NotNull PAGView paramPAGView)
  {
    Intrinsics.checkParameterIsNotNull(paramPAGView, "<anonymous parameter 0>");
    return TroopUtils.a(this.$senderDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftComboXAController.setAvatar.1
 * JD-Core Version:    0.7.0.1
 */