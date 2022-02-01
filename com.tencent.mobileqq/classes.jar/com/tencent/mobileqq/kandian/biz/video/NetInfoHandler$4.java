package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;

class NetInfoHandler$4
  implements Runnable
{
  NetInfoHandler$4(NetInfoHandler paramNetInfoHandler, VideoPlayManager paramVideoPlayManager) {}
  
  public void run()
  {
    NetInfoHandler.a(this.this$0).notifyDataSetChanged();
    if (this.a.g())
    {
      this.a.e(true);
      this.a.k().u();
      return;
    }
    if ((!NetInfoHandler.b(this.this$0).x()) && (this.a.s()))
    {
      this.a.d(true);
      this.a.k().u();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.NetInfoHandler.4
 * JD-Core Version:    0.7.0.1
 */