package com.tencent.mobileqq.emoticonview;

import com.tencent.image.URLDrawable;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class SystemAndEmojiUniversalPanel$1$1$1
  implements AbsListView.OnScrollListener
{
  SystemAndEmojiUniversalPanel$1$1$1(SystemAndEmojiUniversalPanel.1.1 param1) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    SystemAndEmojiUniversalPanel.access$400(this.this$2.this$1.this$0, paramAbsListView);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2))
    {
      URLDrawable.pause();
      return;
    }
    URLDrawable.resume();
    SystemAndEmojiUniversalPanel.access$300(this.this$2.this$1.this$0, this.this$2.val$panelData, SystemAndEmojiUniversalPanel.access$200(this.this$2.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.1.1.1
 * JD-Core Version:    0.7.0.1
 */