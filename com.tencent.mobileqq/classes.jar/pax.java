import com.tencent.biz.webviewplugin.QzoneWebViewOfflinePlugin;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

public class pax
  implements QzoneZipCacheHelperCallBack
{
  public pax(QzoneWebViewOfflinePlugin paramQzoneWebViewOfflinePlugin, String paramString1, String paramString2, String paramString3) {}
  
  public void onResult(boolean paramBoolean)
  {
    QzoneWebViewOfflinePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginQzoneWebViewOfflinePlugin, paramBoolean, this.jdField_a_of_type_JavaLangString, this.b, this.c);
  }
  
  public void onResultOfNativeRequest(boolean paramBoolean, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pax
 * JD-Core Version:    0.7.0.1
 */