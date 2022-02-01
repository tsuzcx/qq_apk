package com.tencent.mobileqq.vas.troopgift;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.mobileqq.utils.ImageUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/troopgift/CommonGiftController$senderAvatarCallback$1", "Landroid/graphics/drawable/Drawable$Callback;", "invalidateDrawable", "", "who", "Landroid/graphics/drawable/Drawable;", "scheduleDrawable", "what", "Ljava/lang/Runnable;", "when", "", "unscheduleDrawable", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CommonGiftController$senderAvatarCallback$1
  implements Drawable.Callback
{
  public void invalidateDrawable(@NotNull Drawable paramDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "who");
    Object localObject = this.a;
    CommonGiftController.b((CommonGiftController)localObject, CommonGiftController.d((CommonGiftController)localObject) + 1);
    if (CommonGiftController.d(this.a) >= 5)
    {
      paramDrawable.setCallback((Drawable.Callback)null);
      return;
    }
    localObject = CommonGiftController.a(this.a);
    paramDrawable = ImageUtil.b(paramDrawable);
    Intrinsics.checkExpressionValueIsNotNull(paramDrawable, "ImageUtil.drawableToBitmap(who)");
    ((TroopGiftComboView)localObject).setSenderAvatar(paramDrawable);
  }
  
  public void scheduleDrawable(@NotNull Drawable paramDrawable, @NotNull Runnable paramRunnable, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "who");
    Intrinsics.checkParameterIsNotNull(paramRunnable, "what");
  }
  
  public void unscheduleDrawable(@NotNull Drawable paramDrawable, @NotNull Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "who");
    Intrinsics.checkParameterIsNotNull(paramRunnable, "what");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.CommonGiftController.senderAvatarCallback.1
 * JD-Core Version:    0.7.0.1
 */