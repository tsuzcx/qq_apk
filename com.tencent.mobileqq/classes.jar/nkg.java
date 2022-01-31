import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.smtt.export.external.interfaces.JsResult;

class nkg
  implements DialogInterface.OnCancelListener
{
  nkg(nkb paramnkb, JsResult paramJsResult, Context paramContext) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesJsResult.cancel();
    if (this.jdField_a_of_type_Nkb.a > 2) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nkg
 * JD-Core Version:    0.7.0.1
 */