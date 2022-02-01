package cooperation.qzone.plugin;

import android.os.IInterface;

public abstract interface OnQZonePluginInstallListner
  extends IInterface
{
  public abstract void onInstallBegin(String paramString);
  
  public abstract void onInstallDownloadProgress(String paramString, float paramFloat, long paramLong);
  
  public abstract void onInstallError(String paramString, int paramInt);
  
  public abstract void onInstallFinish(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.OnQZonePluginInstallListner
 * JD-Core Version:    0.7.0.1
 */