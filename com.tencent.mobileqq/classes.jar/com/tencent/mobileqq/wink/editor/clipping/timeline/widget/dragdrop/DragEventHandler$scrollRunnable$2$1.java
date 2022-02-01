package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragEventHandler$scrollRunnable$2$1", "Ljava/lang/Runnable;", "run", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class DragEventHandler$scrollRunnable$2$1
  implements Runnable
{
  public void run()
  {
    Object localObject = DragEventHandler.b(this.this$0.this$0);
    if (localObject != null)
    {
      if (DragEventHandler.c(this.this$0.this$0) == 0L) {
        DragEventHandler.a(this.this$0.this$0, System.currentTimeMillis());
      }
      if (DragEventHandler.a(this.this$0.this$0).a((View)localObject, (int)DragEventHandler.d(this.this$0.this$0)))
      {
        localObject = DragEventHandler.a(this.this$0.this$0);
        Runnable localRunnable = (Runnable)this;
        ((DragDropScrollView)localObject).removeCallbacks(localRunnable);
        ViewCompat.postOnAnimation((View)DragEventHandler.a(this.this$0.this$0), localRunnable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragEventHandler.scrollRunnable.2.1
 * JD-Core Version:    0.7.0.1
 */