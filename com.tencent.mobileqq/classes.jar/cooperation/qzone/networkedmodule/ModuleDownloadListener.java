package cooperation.qzone.networkedmodule;

public abstract interface ModuleDownloadListener
{
  public abstract void onDownloadCanceled(String paramString);
  
  public abstract void onDownloadFailed(String paramString);
  
  public abstract void onDownloadProgress(String paramString, float paramFloat);
  
  public abstract void onDownloadSucceed(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.ModuleDownloadListener
 * JD-Core Version:    0.7.0.1
 */