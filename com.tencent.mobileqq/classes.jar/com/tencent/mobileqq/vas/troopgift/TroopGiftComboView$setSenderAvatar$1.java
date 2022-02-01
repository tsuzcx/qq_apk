package com.tencent.mobileqq.vas.troopgift;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGImage;
import org.libpag.PAGView;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lorg/libpag/PAGView;", "invoke"}, k=3, mv={1, 1, 16})
final class TroopGiftComboView$setSenderAvatar$1
  extends Lambda
  implements Function1<PAGView, Unit>
{
  TroopGiftComboView$setSenderAvatar$1(TroopGiftComboView paramTroopGiftComboView, Bitmap paramBitmap)
  {
    super(1);
  }
  
  public final void invoke(@NotNull PAGView paramPAGView)
  {
    Intrinsics.checkParameterIsNotNull(paramPAGView, "it");
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.a(), 2, "setSenderAvatar");
    }
    paramPAGView.replaceImage(0, PAGImage.FromBitmap(this.$senderAvatar));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftComboView.setSenderAvatar.1
 * JD-Core Version:    0.7.0.1
 */