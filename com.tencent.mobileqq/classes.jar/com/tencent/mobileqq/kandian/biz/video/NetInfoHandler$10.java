package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;

class NetInfoHandler$10
  implements Runnable
{
  NetInfoHandler$10(NetInfoHandler paramNetInfoHandler) {}
  
  public void run()
  {
    NetInfoHandler.a(this.this$0).notifyDataSetChanged();
    VideoPlayManager localVideoPlayManager = NetInfoHandler.a(this.this$0).a();
    if ((!localVideoPlayManager.a()) && (!localVideoPlayManager.d())) {
      NetInfoHandler.a(this.this$0).b(NetInfoHandler.a(this.this$0).a(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.NetInfoHandler.10
 * JD-Core Version:    0.7.0.1
 */