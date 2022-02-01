package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;

class NetInfoHandler$2
  implements Runnable
{
  NetInfoHandler$2(NetInfoHandler paramNetInfoHandler) {}
  
  public void run()
  {
    NetInfoHandler.a(this.this$0).notifyDataSetChanged();
    NetInfoHandler.a(this.this$0).b(NetInfoHandler.a(this.this$0).a(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.NetInfoHandler.2
 * JD-Core Version:    0.7.0.1
 */