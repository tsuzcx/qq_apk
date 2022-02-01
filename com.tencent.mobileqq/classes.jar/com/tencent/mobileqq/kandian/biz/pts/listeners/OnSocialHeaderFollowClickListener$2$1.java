package com.tencent.mobileqq.kandian.biz.pts.listeners;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class OnSocialHeaderFollowClickListener$2$1
  implements Runnable
{
  OnSocialHeaderFollowClickListener$2$1(OnSocialHeaderFollowClickListener.2 param2) {}
  
  public void run()
  {
    OnSocialHeaderFollowClickListener.a(this.a.a).invalidateProteusTemplateBean();
    ReadInJoyLogicEngineEventDispatcher.a().c();
    ReadInJoyLogicEngineEventDispatcher.a().a(OnSocialHeaderFollowClickListener.a(this.a.a), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialHeaderFollowClickListener.2.1
 * JD-Core Version:    0.7.0.1
 */