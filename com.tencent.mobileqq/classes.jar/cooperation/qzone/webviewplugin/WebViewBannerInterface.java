package cooperation.qzone.webviewplugin;

public abstract interface WebViewBannerInterface
{
  public abstract void close();
  
  public abstract void enableGesture(boolean paramBoolean);
  
  public abstract String getBannerData();
  
  public abstract void qbossReport(int paramInt, String paramString1, String paramString2);
  
  public abstract void setBannerHeight(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.WebViewBannerInterface
 * JD-Core Version:    0.7.0.1
 */