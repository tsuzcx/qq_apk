package com.tencent.mobileqq.kandian.biz.pts.component;

import com.tencent.mobileqq.kandian.biz.gifvideo.media.MediaVideoView;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.IStrategy.URLCallback;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianShortContentGifStrategy;

class ComponentPGCShortContentBig$2
  implements Runnable
{
  ComponentPGCShortContentBig$2(ComponentPGCShortContentBig paramComponentPGCShortContentBig, IStrategy.URLCallback paramURLCallback) {}
  
  public void run()
  {
    if ((ComponentPGCShortContentBig.a(this.this$0) instanceof MediaVideoView)) {
      ((MediaVideoView)ComponentPGCShortContentBig.a(this.this$0)).requestUrlByVid(KandianShortContentGifStrategy.a(), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentPGCShortContentBig.2
 * JD-Core Version:    0.7.0.1
 */