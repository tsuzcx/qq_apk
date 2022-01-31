package com.tencent.mobileqq.richmedia.mediacodec.widget;

import com.tencent.ttpic.openapi.filter.GPUBaseFilter;

class VideoFilterPlayView$1
  implements Runnable
{
  VideoFilterPlayView$1(VideoFilterPlayView paramVideoFilterPlayView) {}
  
  public void run()
  {
    VideoFilterPlayView.a(this.this$0).init();
    VideoFilterPlayView.a(this.this$0).onOutputSizeChanged(this.this$0.b, this.this$0.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView.1
 * JD-Core Version:    0.7.0.1
 */