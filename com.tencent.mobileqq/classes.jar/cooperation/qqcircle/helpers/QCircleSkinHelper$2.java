package cooperation.qqcircle.helpers;

import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;

class QCircleSkinHelper$2
  implements RFWDownloader.RFWDownloadListener
{
  QCircleSkinHelper$2(QCircleSkinHelper paramQCircleSkinHelper, String paramString1, QCircleSkinHelper.SkinDownLoadLister paramSkinDownLoadLister, String paramString2) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onRspCallback(boolean paramBoolean, String paramString)
  {
    QCircleSkinHelper.access$300(this.this$0, paramBoolean, paramString, this.val$url, this.val$skinDownLoadLister, this.val$oldSkinPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.helpers.QCircleSkinHelper.2
 * JD-Core Version:    0.7.0.1
 */