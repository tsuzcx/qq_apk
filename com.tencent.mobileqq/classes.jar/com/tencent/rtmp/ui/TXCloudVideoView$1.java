package com.tencent.rtmp.ui;

class TXCloudVideoView$1
  implements Runnable
{
  TXCloudVideoView$1(TXCloudVideoView paramTXCloudVideoView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void run()
  {
    TXCloudVideoView localTXCloudVideoView = this.e;
    TXCloudVideoView.access$002(localTXCloudVideoView, localTXCloudVideoView.getWidth() * this.a);
    localTXCloudVideoView = this.e;
    TXCloudVideoView.access$102(localTXCloudVideoView, localTXCloudVideoView.getWidth() * this.b);
    localTXCloudVideoView = this.e;
    TXCloudVideoView.access$202(localTXCloudVideoView, localTXCloudVideoView.getHeight() * this.c);
    localTXCloudVideoView = this.e;
    TXCloudVideoView.access$302(localTXCloudVideoView, localTXCloudVideoView.getHeight() * this.d);
    if (this.e.mDashBoard != null) {
      this.e.mDashBoard.a((int)TXCloudVideoView.access$000(this.e), (int)TXCloudVideoView.access$200(this.e), (int)TXCloudVideoView.access$100(this.e), (int)TXCloudVideoView.access$300(this.e));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.ui.TXCloudVideoView.1
 * JD-Core Version:    0.7.0.1
 */