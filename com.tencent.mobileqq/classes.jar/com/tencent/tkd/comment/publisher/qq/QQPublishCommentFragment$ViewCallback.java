package com.tencent.tkd.comment.publisher.qq;

import android.graphics.drawable.Drawable;
import com.tencent.tkd.comment.publisher.qq.model.TkdCommentLinkData;
import com.tencent.tkd.comment.publisher.qq.util.QQViewCallback;
import com.tencent.tkd.comment.publisher.qq.widget.TkdCommentLinkView;
import java.util.List;

class QQPublishCommentFragment$ViewCallback
  implements QQViewCallback
{
  private QQPublishCommentFragment$ViewCallback(QQPublishCommentFragment paramQQPublishCommentFragment) {}
  
  public List<TkdCommentLinkData> getCommentLinkData()
  {
    return QQPublishCommentFragment.LinkUi.access$400(QQPublishCommentFragment.access$1100(this.this$0)).getData();
  }
  
  public void onAddGif(Drawable paramDrawable)
  {
    QQPublishCommentFragment.GifUi.access$1000(QQPublishCommentFragment.access$900(this.this$0), paramDrawable);
  }
  
  public void onAddLink(TkdCommentLinkData paramTkdCommentLinkData)
  {
    QQPublishCommentFragment.access$1100(this.this$0).onAddLink(paramTkdCommentLinkData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment.ViewCallback
 * JD-Core Version:    0.7.0.1
 */