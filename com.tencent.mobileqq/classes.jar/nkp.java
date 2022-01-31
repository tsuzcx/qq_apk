import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.smtt.export.external.interfaces.JsResult;

class nkp
  implements DialogInterface.OnClickListener
{
  nkp(nke paramnke, JsResult paramJsResult, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesJsResult.cancel();
    ((Activity)this.jdField_a_of_type_AndroidContentContext).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nkp
 * JD-Core Version:    0.7.0.1
 */