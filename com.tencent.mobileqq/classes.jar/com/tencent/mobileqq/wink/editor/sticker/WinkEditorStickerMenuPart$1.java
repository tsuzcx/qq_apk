package com.tencent.mobileqq.wink.editor.sticker;

import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.mobileqq.wink.editor.MetaMaterialKt;
import com.tencent.mobileqq.wink.utils.AdapterUtils;
import com.tencent.mobileqq.wink.view.WinkMaterialPanelCategoryAdapter.ItemListener;

class WinkEditorStickerMenuPart$1
  implements WinkMaterialPanelCategoryAdapter.ItemListener
{
  WinkEditorStickerMenuPart$1(WinkEditorStickerMenuPart paramWinkEditorStickerMenuPart) {}
  
  public void a(int paramInt, @Nullable MetaCategory paramMetaCategory) {}
  
  public void b(int paramInt, @Nullable MetaCategory paramMetaCategory)
  {
    WinkEditorStickerMenuPart.a(this.a, true);
    paramInt = MetaMaterialKt.b(WinkEditorStickerMenuPart.a(this.a), WinkEditorStickerMenuPart.b(this.a), paramInt);
    AdapterUtils.b(WinkEditorStickerMenuPart.c(this.a), WinkEditorStickerMenuPart.d(this.a).a(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.sticker.WinkEditorStickerMenuPart.1
 * JD-Core Version:    0.7.0.1
 */