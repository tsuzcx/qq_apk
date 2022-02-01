package cooperation.qzone;

import cooperation.qqcircle.beans.QCircleFakeFeed;

class QzoneIPCModule$RetryRequestFeed
  implements Runnable
{
  QCircleFakeFeed fakeFeed;
  QzoneIPCModule.ResultParmas resultParmas;
  int retryCount = 0;
  
  public QzoneIPCModule$RetryRequestFeed(QzoneIPCModule paramQzoneIPCModule, QCircleFakeFeed paramQCircleFakeFeed, int paramInt, QzoneIPCModule.ResultParmas paramResultParmas)
  {
    this.fakeFeed = paramQCircleFakeFeed;
    this.retryCount = paramInt;
    this.resultParmas = paramResultParmas;
  }
  
  public void run()
  {
    QzoneIPCModule.access$500(this.this$0, this.fakeFeed, this.retryCount, this.resultParmas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneIPCModule.RetryRequestFeed
 * JD-Core Version:    0.7.0.1
 */