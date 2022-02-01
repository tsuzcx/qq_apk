package com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.widget.ListView;

public class TKDTuWenHippyCommentAdapter$Builder
{
  private final TKDTuWenHippyCommentAdapter adapter;
  
  public TKDTuWenHippyCommentAdapter$Builder(QBaseActivity paramQBaseActivity)
  {
    this.adapter = new TKDTuWenHippyCommentAdapter(paramQBaseActivity);
  }
  
  public Builder anchorData(@NonNull AnchorData paramAnchorData)
  {
    this.adapter.anchorData = paramAnchorData;
    return this;
  }
  
  public Builder articleInfo(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.adapter.mArticleInfo = paramAbsBaseArticleInfo;
    return this;
  }
  
  public TKDTuWenHippyCommentAdapter build()
  {
    return this.adapter;
  }
  
  public Builder contentSrc(int paramInt)
  {
    this.adapter.contentSrc = paramInt;
    return this;
  }
  
  public Builder listView(ListView paramListView)
  {
    this.adapter.vList = paramListView;
    return this;
  }
  
  public Builder openCommentEditor(boolean paramBoolean)
  {
    this.adapter.openCommentEditor = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter.TKDTuWenHippyCommentAdapter.Builder
 * JD-Core Version:    0.7.0.1
 */