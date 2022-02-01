package com.tencent.mobileqq.wink.editor;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.menu.BottomDashboardMenuPart;
import com.tencent.mobileqq.wink.editor.menu.MenuItem;
import com.tencent.mobileqq.wink.view.WinkStickerFrameLayout;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "Lcom/tencent/mobileqq/wink/editor/menu/MenuItem;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$initEditorViewModel$1<T>
  implements Observer<List<? extends MenuItem>>
{
  WinkEditorFragment$initEditorViewModel$1(WinkEditorFragment paramWinkEditorFragment) {}
  
  public final void a(List<? extends MenuItem> paramList)
  {
    WinkEditorFragment.k(this.a).a(paramList);
    WinkEditorFragment.l(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.initEditorViewModel.1
 * JD-Core Version:    0.7.0.1
 */