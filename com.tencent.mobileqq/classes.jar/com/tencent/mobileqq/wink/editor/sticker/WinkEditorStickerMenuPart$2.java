package com.tencent.mobileqq.wink.editor.sticker;

import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback;

class WinkEditorStickerMenuPart$2
  extends BottomSheetBehavior.BottomSheetCallback
{
  WinkEditorStickerMenuPart$2(WinkEditorStickerMenuPart paramWinkEditorStickerMenuPart) {}
  
  public void onSlide(@NonNull View paramView, float paramFloat) {}
  
  public void onStateChanged(@NonNull View paramView, int paramInt)
  {
    if (paramInt == 4)
    {
      this.a.l();
      WinkEditorStickerMenuPart.e(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.sticker.WinkEditorStickerMenuPart.2
 * JD-Core Version:    0.7.0.1
 */