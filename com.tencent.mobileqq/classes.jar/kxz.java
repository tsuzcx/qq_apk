import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;

public class kxz
  implements DialogInterface.OnClickListener
{
  public kxz(CustomWebChromeClient paramCustomWebChromeClient, JsPromptResult paramJsPromptResult, EditText paramEditText) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesJsPromptResult.confirm(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kxz
 * JD-Core Version:    0.7.0.1
 */