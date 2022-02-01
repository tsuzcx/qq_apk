package com.tencent.tkd.comment.publisher.qq;

import com.tencent.tkd.comment.publisher.qq.widget.TKDListenFocusEditText;
import com.tencent.tkd.comment.publisher.qq.widget.TKDListenFocusEditText.OnWindowFocusChangeListener;

class QQPublishCommentFragment$2
  implements TKDListenFocusEditText.OnWindowFocusChangeListener
{
  QQPublishCommentFragment$2(QQPublishCommentFragment paramQQPublishCommentFragment) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QQPublishCommentFragment.access$300(this.this$0).setWindowFocusChangeListener(null);
      QQPublishCommentFragment.access$300(this.this$0).post(new QQPublishCommentFragment.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment.2
 * JD-Core Version:    0.7.0.1
 */