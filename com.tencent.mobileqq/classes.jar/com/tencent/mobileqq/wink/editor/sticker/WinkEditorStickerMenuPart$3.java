package com.tencent.mobileqq.wink.editor.sticker;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.wink.editor.MetaMaterialKt;
import com.tencent.mobileqq.wink.view.WinkMaterialPanelCategoryAdapter;

class WinkEditorStickerMenuPart$3
  extends RecyclerView.OnScrollListener
{
  WinkEditorStickerMenuPart$3(WinkEditorStickerMenuPart paramWinkEditorStickerMenuPart) {}
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      WinkEditorStickerMenuPart.a(this.a, false);
    }
  }
  
  public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (!WinkEditorStickerMenuPart.f(this.a))
    {
      paramInt1 = WinkEditorStickerMenuPart.g(this.a).findFirstVisibleItemPosition();
      paramInt1 = MetaMaterialKt.a(WinkEditorStickerMenuPart.a(this.a), WinkEditorStickerMenuPart.b(this.a), paramInt1);
      WinkEditorStickerMenuPart.h(this.a).a(paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.sticker.WinkEditorStickerMenuPart.3
 * JD-Core Version:    0.7.0.1
 */