import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsResult;

public class kwd
  implements DialogInterface.OnCancelListener
{
  public kwd(CustomWebChromeClient paramCustomWebChromeClient, JsResult paramJsResult) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesJsResult.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kwd
 * JD-Core Version:    0.7.0.1
 */