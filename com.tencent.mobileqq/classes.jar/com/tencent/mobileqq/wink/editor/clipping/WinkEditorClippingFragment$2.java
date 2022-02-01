package com.tencent.mobileqq.wink.editor.clipping;

import android.animation.Animator;
import android.graphics.Point;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ReorderContainerView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ReorderListener;
import com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ReorderTransition;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragDropScrollView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragDropScrollViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackController;
import com.tencent.videocut.utils.DensityUtils;
import org.jetbrains.annotations.NotNull;

class WinkEditorClippingFragment$2
  implements ReorderListener
{
  int a = -1;
  
  WinkEditorClippingFragment$2(WinkEditorClippingFragment paramWinkEditorClippingFragment) {}
  
  public void a(@NotNull String paramString, int paramInt)
  {
    WinkEditorClippingFragment.c(this.b).setVisibility(4);
    WinkEditorClippingFragment.f(this.b).a(true);
    if (WinkEditorClippingFragment.d(this.b).d() != null) {
      ((VideoTrackContainerView)WinkEditorClippingFragment.d(this.b).d()).setVisibility(0);
    }
    if (WinkEditorClippingFragment.g(this.b).d() != null) {
      ((DragDropScrollView)WinkEditorClippingFragment.g(this.b).d()).setVisibility(0);
    }
    ((VideoTrackContainerView)WinkEditorClippingFragment.d(this.b).d()).setHandleView(null);
    if (this.a != paramInt)
    {
      if (paramInt < 0) {
        return;
      }
      WinkEditorClippingFragment.b(this.b).a(paramString, paramInt);
    }
  }
  
  @RequiresApi(api=19)
  public void a(@NotNull String paramString, @NotNull Point paramPoint)
  {
    this.a = WinkEditorClippingFragment.c(this.b).a(paramString, paramPoint);
    if (this.a != -1)
    {
      if (WinkEditorClippingFragment.d(this.b).d() == null) {
        return;
      }
      paramString = ((VideoTrackContainerView)WinkEditorClippingFragment.d(this.b).d()).getVideoTrackViews();
      int i = paramPoint.x;
      int j = DensityUtils.a.a(16.0F);
      int k = DensityUtils.a.a(72.0F);
      paramString = ReorderTransition.a.a(paramString, this.a, i - j, k);
      paramString.setDuration(WinkEditorClippingFragment.e(this.b).longValue());
      ((VideoTrackContainerView)WinkEditorClippingFragment.d(this.b).d()).a();
      paramString.addListener(new WinkEditorClippingFragment.2.1(this));
      paramString.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment.2
 * JD-Core Version:    0.7.0.1
 */