package com.tencent.mobileqq.kandian.biz.framework.handlers;

import com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoPlayControlUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class FrameworkHandler$1
  extends ReadInJoyObserver
{
  FrameworkHandler$1(FrameworkHandler paramFrameworkHandler) {}
  
  public void a_(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    VideoPlayControlUtils.a(this.a.e(), paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler.1
 * JD-Core Version:    0.7.0.1
 */