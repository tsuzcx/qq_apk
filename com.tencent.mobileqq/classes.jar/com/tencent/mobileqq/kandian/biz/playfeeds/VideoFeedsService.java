package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.Cmd2HandlerMap;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import java.util.Map;
import java.util.Random;
import mqq.app.MSFServlet;

public class VideoFeedsService
  extends MobileQQServiceBase
{
  VideoFeedsAppInterface a;
  Random b = new Random();
  
  VideoFeedsService(VideoFeedsAppInterface paramVideoFeedsAppInterface)
  {
    this.a = paramVideoFeedsAppInterface;
    seq = Math.abs(this.b.nextInt());
  }
  
  public AppInterface getAppInterface()
  {
    return this.a;
  }
  
  protected Map<String, String[]> getCompatibleCmd2HandlerMap()
  {
    return Cmd2HandlerMap.a();
  }
  
  protected Class<? extends MSFServlet> getServlet()
  {
    return VideoFeedsServlet.class;
  }
  
  protected void initCoders()
  {
    try
    {
      super.initCoders();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsService
 * JD-Core Version:    0.7.0.1
 */