package com.tencent.mobileqq.wink.editor;

import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.view.WinkStickerFrameLayout.MenuClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/WinkEditorFragment$initStickerView$1", "Lcom/tencent/mobileqq/wink/view/WinkStickerFrameLayout$MenuClickListener;", "onDeleteMenuClick", "", "stickerModel", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "onEditMenuClick", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class WinkEditorFragment$initStickerView$1
  implements WinkStickerFrameLayout.MenuClickListener
{
  public void a(@NotNull WinkStickerModel paramWinkStickerModel)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkStickerModel, "stickerModel");
    this.a.d(paramWinkStickerModel);
  }
  
  public void b(@NotNull WinkStickerModel paramWinkStickerModel)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkStickerModel, "stickerModel");
    this.a.b(paramWinkStickerModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.initStickerView.1
 * JD-Core Version:    0.7.0.1
 */