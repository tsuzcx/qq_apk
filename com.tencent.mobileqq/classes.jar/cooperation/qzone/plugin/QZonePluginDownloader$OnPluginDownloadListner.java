package cooperation.qzone.plugin;

public abstract interface QZonePluginDownloader$OnPluginDownloadListner
{
  public abstract void onDownLoadStart(PluginRecord paramPluginRecord);
  
  public abstract void onDownloadCanceled(PluginRecord paramPluginRecord);
  
  public abstract void onDownloadFailed(PluginRecord paramPluginRecord, int paramInt);
  
  public abstract void onDownloadProgress(PluginRecord paramPluginRecord);
  
  public abstract void onDownloadSucceed(PluginRecord paramPluginRecord, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginDownloader.OnPluginDownloadListner
 * JD-Core Version:    0.7.0.1
 */