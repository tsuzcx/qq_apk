import com.tencent.biz.webviewplugin.QzonePlugin;
import com.tencent.smtt.sdk.WebView;

public class pco
  implements Runnable
{
  public pco(QzonePlugin paramQzonePlugin, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (QzonePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginQzonePlugin) != null) {
      QzonePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginQzonePlugin).postUrl(QzonePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginQzonePlugin), this.jdField_a_of_type_ArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pco
 * JD-Core Version:    0.7.0.1
 */