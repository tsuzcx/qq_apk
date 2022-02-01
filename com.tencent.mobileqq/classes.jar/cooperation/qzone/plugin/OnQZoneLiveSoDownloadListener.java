package cooperation.qzone.plugin;

import android.os.IInterface;

public abstract interface OnQZoneLiveSoDownloadListener
  extends IInterface
{
  public abstract void onDownloadBegin();
  
  public abstract void onDownloadCancel();
  
  public abstract void onDownloadFail(int paramInt);
  
  public abstract void onDownloadProgress(float paramFloat);
  
  public abstract void onDownloadSuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener
 * JD-Core Version:    0.7.0.1
 */