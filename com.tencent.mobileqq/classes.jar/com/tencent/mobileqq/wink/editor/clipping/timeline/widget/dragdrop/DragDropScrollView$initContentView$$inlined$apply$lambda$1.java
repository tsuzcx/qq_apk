package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.DragDropViewEmptyClickEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragDropScrollView$initContentView$1$1"}, k=3, mv={1, 1, 16})
final class DragDropScrollView$initContentView$$inlined$apply$lambda$1
  implements View.OnClickListener
{
  DragDropScrollView$initContentView$$inlined$apply$lambda$1(DragDropScrollView paramDragDropScrollView) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = DragDropScrollView.a(this.a);
    if (localObject != null)
    {
      localObject = ((DragDropScrollViewController)localObject).c();
      if (localObject != null) {
        ((PanelEventHandler)localObject).a((PanelEvent)new DragDropViewEmptyClickEvent());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragDropScrollView.initContentView..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */