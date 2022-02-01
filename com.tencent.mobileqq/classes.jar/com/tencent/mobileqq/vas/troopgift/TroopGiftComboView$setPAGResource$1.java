package com.tencent.mobileqq.vas.troopgift;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGFile;
import org.libpag.PAGFont;
import org.libpag.PAGText;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lorg/libpag/PAGView;", "invoke"}, k=3, mv={1, 1, 16})
final class TroopGiftComboView$setPAGResource$1
  extends Lambda
  implements Function1<PAGView, Unit>
{
  TroopGiftComboView$setPAGResource$1(TroopGiftComboView paramTroopGiftComboView, String paramString1, String paramString2)
  {
    super(1);
  }
  
  public final void invoke(@NotNull PAGView paramPAGView)
  {
    Intrinsics.checkParameterIsNotNull(paramPAGView, "it");
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.a(), 2, "setPAGResource");
    }
    paramPAGView.addListener((PAGView.PAGViewListener)new TroopGiftComboView.setPAGResource.1.1(this));
    Object localObject = PAGFile.Load(this.$pagPath);
    PAGFont localPAGFont = PAGFont.RegisterFont(this.$fontPath);
    paramPAGView.setFile((PAGFile)localObject);
    localObject = paramPAGView.getFile();
    if (localObject != null) {
      localObject = ((PAGFile)localObject).getTextData(0);
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((PAGText)localObject).fontFamily = localPAGFont.fontFamily;
    }
    if (localObject != null) {
      ((PAGText)localObject).fontStyle = localPAGFont.fontStyle;
    }
    paramPAGView.setTextData(0, (PAGText)localObject);
    paramPAGView.setProgress(0.0D);
    paramPAGView.play();
    TroopGiftComboView.a(this.this$0, paramPAGView.duration() / 1000 - 300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftComboView.setPAGResource.1
 * JD-Core Version:    0.7.0.1
 */