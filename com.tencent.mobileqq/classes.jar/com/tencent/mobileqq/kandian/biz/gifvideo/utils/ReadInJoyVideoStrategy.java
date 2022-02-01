package com.tencent.mobileqq.kandian.biz.gifvideo.utils;

import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;

public class ReadInJoyVideoStrategy
  implements IStrategy
{
  private static ReadInJoyVideoStrategy a = new ReadInJoyVideoStrategy();
  
  public void a(String paramString, IStrategy.URLCallback paramURLCallback)
  {
    ThirdVideoManager.a().a(paramString, new ReadInJoyVideoStrategy.1(this, paramURLCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.utils.ReadInJoyVideoStrategy
 * JD-Core Version:    0.7.0.1
 */