package com.tencent.mobileqq.flashshow.list.presenter;

import android.view.View.OnClickListener;
import com.tencent.mobileqq.flashshow.api.bean.FSInitBean;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StReply;
import java.util.List;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class FSTopReplayMessagePresenter
  extends FSDefaultMessagePresenter
{
  private View.OnClickListener x;
  
  public FSTopReplayMessagePresenter(int paramInt)
  {
    super(paramInt);
  }
  
  public void a(FSInitBean paramFSInitBean)
  {
    QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = new QQCircleFeedBase.StBusiInfoCommentListData();
    Object localObject = (FeedCloudMeta.StComment)this.d.operation.comment.get();
    if (localObject != null)
    {
      localStBusiInfoCommentListData.comment.set((MessageMicro)localObject);
      localObject = ((FeedCloudMeta.StComment)localObject).vecReply.get();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int i = ((List)localObject).size();
        localStBusiInfoCommentListData.reply.set((MessageMicro)((List)localObject).get(i - 1));
      }
      paramFSInitBean.setBusiInfoData(localStBusiInfoCommentListData.toByteArray());
    }
  }
  
  protected View.OnClickListener j()
  {
    if (this.x == null) {
      this.x = new FSTopReplayMessagePresenter.1(this);
    }
    return this.x;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSTopReplayMessagePresenter
 * JD-Core Version:    0.7.0.1
 */