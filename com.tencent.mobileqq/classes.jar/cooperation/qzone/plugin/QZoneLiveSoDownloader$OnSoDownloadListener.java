package cooperation.qzone.plugin;

public abstract interface QZoneLiveSoDownloader$OnSoDownloadListener
{
  public abstract void onDownLoadStart(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord);
  
  public abstract void onDownloadCanceled(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord);
  
  public abstract void onDownloadFailed(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord);
  
  public abstract void onDownloadProgress(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord);
  
  public abstract void onDownloadSucceed(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.plugin.QZoneLiveSoDownloader.OnSoDownloadListener
 * JD-Core Version:    0.7.0.1
 */