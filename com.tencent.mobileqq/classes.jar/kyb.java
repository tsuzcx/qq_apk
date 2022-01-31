import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;

public class kyb
  implements DialogInterface.OnCancelListener
{
  public kyb(CustomWebChromeClient paramCustomWebChromeClient, JsPromptResult paramJsPromptResult) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesJsPromptResult.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kyb
 * JD-Core Version:    0.7.0.1
 */