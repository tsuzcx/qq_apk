package com.tencent.mobileqq.wink.editor;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "onGlobalLayout"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$onViewCreated$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  WinkEditorFragment$onViewCreated$1(WinkEditorFragment paramWinkEditorFragment) {}
  
  public final void onGlobalLayout()
  {
    WinkEditorFragment.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(WinkEditorFragment.b(this.a));
    WinkEditorFragment localWinkEditorFragment = this.a;
    WinkEditorFragment.a(localWinkEditorFragment, WinkEditorFragment.c(localWinkEditorFragment).a(WinkEditorFragment.a(this.a).getWidth(), WinkEditorFragment.a(this.a).getHeight()));
    WinkEditorFragment.a(this.a).post((Runnable)new WinkEditorFragment.onViewCreated.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.onViewCreated.1
 * JD-Core Version:    0.7.0.1
 */