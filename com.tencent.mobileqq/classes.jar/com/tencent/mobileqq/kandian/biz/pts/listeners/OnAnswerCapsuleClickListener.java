package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public class OnAnswerCapsuleClickListener
  implements ViewBase.OnClickListener
{
  private AbsBaseArticleInfo a;
  private Context b;
  
  public OnAnswerCapsuleClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramContext;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    OnSuperTopicClickListener.a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnAnswerCapsuleClickListener
 * JD-Core Version:    0.7.0.1
 */