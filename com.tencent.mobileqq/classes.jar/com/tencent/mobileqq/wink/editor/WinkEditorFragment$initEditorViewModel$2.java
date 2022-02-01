package com.tencent.mobileqq.wink.editor;

import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.view.WinkStickerFrameLayout;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$initEditorViewModel$2<T>
  implements Observer<MenuType>
{
  WinkEditorFragment$initEditorViewModel$2(WinkEditorFragment paramWinkEditorFragment) {}
  
  public final void a(MenuType paramMenuType)
  {
    if (paramMenuType == MenuType.BOTTOM_DASHBOARD)
    {
      WinkEditorFragment.m(this.a).setVisibility(0);
      return;
    }
    WinkEditorFragment.l(this.a).b();
    WinkEditorFragment.m(this.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.initEditorViewModel.2
 * JD-Core Version:    0.7.0.1
 */