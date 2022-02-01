package cooperation.qzone.webviewplugin;

class QzoneWebViewOfflinePlugin$2
  implements QzoneZipCacheHelperCallBack
{
  QzoneWebViewOfflinePlugin$2(QzoneWebViewOfflinePlugin paramQzoneWebViewOfflinePlugin, String paramString1, String paramString2, String paramString3) {}
  
  public void onResult(boolean paramBoolean)
  {
    QzoneWebViewOfflinePlugin.access$200(this.this$0, paramBoolean, this.val$business, this.val$dir, this.val$callback);
  }
  
  public void onResultOfNativeRequest(boolean paramBoolean, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin.2
 * JD-Core Version:    0.7.0.1
 */