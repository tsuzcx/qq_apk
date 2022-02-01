package com.tencent.mobileqq.identification;

import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video.Image2VideoListener;
import com.tencent.biz.qqstory.takevideo.slideshow.ResultInfo;

class YUV2Video$1
  implements Image2Video.Image2VideoListener
{
  public void a(ResultInfo paramResultInfo)
  {
    synchronized (this.a)
    {
      this.a.a(paramResultInfo);
      this.a.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.YUV2Video.1
 * JD-Core Version:    0.7.0.1
 */