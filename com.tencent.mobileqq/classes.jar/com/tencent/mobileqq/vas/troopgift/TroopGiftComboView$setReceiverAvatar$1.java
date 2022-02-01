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
final class TroopGiftComboView$setReceiverAvatar$1
  extends Lambda
  implements Function1<PAGView, Unit>
{
  TroopGiftComboView$setReceiverAvatar$1(TroopGiftComboView paramTroopGiftComboView, Bitmap paramBitmap)
  {
    super(1);
  }
  
  public final void invoke(@NotNull PAGView paramPAGView)
  {
    Intrinsics.checkParameterIsNotNull(paramPAGView, "it");
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.getTAG(), 2, "setReceiverAvatar");
    }
    paramPAGView.replaceImage(1, PAGImage.FromBitmap(this.$receiverAvatar));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftComboView.setReceiverAvatar.1
 * JD-Core Version:    0.7.0.1
 */