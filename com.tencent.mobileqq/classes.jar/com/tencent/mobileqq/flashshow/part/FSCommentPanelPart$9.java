package com.tencent.mobileqq.flashshow.part;

import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.flashshow.fragment.FSBlockContainer;
import com.tencent.mobileqq.flashshow.widgets.comment.FSSlidBottomView;
import com.tencent.mobileqq.flashshow.widgets.comment.adapter.FSCommentPanelBlock;
import com.tencent.mobileqq.flashshow.widgets.comment.helper.FSCommentHelper.CommentInputListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

class FSCommentPanelPart$9
  implements FSCommentHelper.CommentInputListener
{
  FSCommentPanelPart$9(FSCommentPanelPart paramFSCommentPanelPart, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply) {}
  
  public void a(int paramInt)
  {
    if ((paramInt == 103) && (FSCommentPanelPart.a(this.c) != null)) {
      FSCommentPanelPart.a(this.c).e();
    }
  }
  
  public void a(FeedCloudMeta.StComment paramStComment)
  {
    if (FSCommentPanelPart.c(this.c) != null)
    {
      FSCommentPanelPart.c(this.c).a(paramStComment);
      FSCommentPanelPart.e(this.c);
    }
    if (FSCommentPanelPart.d(this.c) != null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "mNeedShowCommentList1");
      FSCommentPanelPart.d(this.c).getRecyclerView().scrollToPosition(0);
    }
  }
  
  public void a(FeedCloudMeta.StReply paramStReply)
  {
    if (FSCommentPanelPart.c(this.c) != null)
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        FSCommentPanelPart localFSCommentPanelPart = this.c;
        String str = ((FeedCloudMeta.StComment)localObject).id.get();
        localObject = this.b;
        if (localObject != null) {
          localObject = ((FeedCloudMeta.StReply)localObject).id.get();
        } else {
          localObject = "";
        }
        int i = FSCommentPanelPart.a(localFSCommentPanelPart, str, (String)localObject);
        FSCommentPanelPart.c(this.c).a(this.a.id.get(), paramStReply);
        if ((i != -1) && (FSCommentPanelPart.d(this.c) != null)) {
          FSCommentPanelPart.d(this.c).getRecyclerView().scrollBy(0, i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSCommentPanelPart.9
 * JD-Core Version:    0.7.0.1
 */