import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.av.ui.CallbackWaitingActivityExt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class jtk
  implements DialogInterface.OnClickListener
{
  jtk(jtj paramjtj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent();
    paramDialogInterface.setPackage(CallbackWaitingActivityExt.a(this.a.a.a).getApp().getPackageName());
    paramDialogInterface.setAction("tencent.av.v2q.CancelCallBack");
    paramDialogInterface.putExtra("fromPhone", this.a.a.a.c);
    paramDialogInterface.putExtra("toPhone", this.a.a.a.jdField_b_of_type_JavaLangString);
    paramDialogInterface.putExtra("fromUin", this.a.a.a.e);
    paramDialogInterface.putExtra("uinType", this.a.a.a.jdField_b_of_type_Int);
    paramDialogInterface.putExtra("toUin", this.a.a.a.e);
    paramDialogInterface.putExtra("callBackId", this.a.a.a.a);
    CallbackWaitingActivityExt.a(this.a.a.a).getApp().sendBroadcast(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jtk
 * JD-Core Version:    0.7.0.1
 */