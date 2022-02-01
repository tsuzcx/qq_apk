package com.tencent.mobileqq.flashshow.widgets.comment.adapter;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

class FSCommentPanelBlock$2
  implements Runnable
{
  public void run()
  {
    FSCommentPanelBlock.b(this.this$0);
    this.this$0.notifyItemInserted(this.a);
    FSCommentPanelBlock localFSCommentPanelBlock = this.this$0;
    localFSCommentPanelBlock.notifyItemRangeChanged(this.a, FSCommentPanelBlock.c(localFSCommentPanelBlock).size() - this.a);
    FSCommentPanelBlock.d(this.this$0).scrollToPosition(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.adapter.FSCommentPanelBlock.2
 * JD-Core Version:    0.7.0.1
 */