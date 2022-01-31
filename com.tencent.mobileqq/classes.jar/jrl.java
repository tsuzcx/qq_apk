import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.av.ui.CallbackWaitingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class jrl
  implements DialogInterface.OnClickListener
{
  jrl(jrk paramjrk) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent();
    paramDialogInterface.setPackage(CallbackWaitingActivity.a(this.a.a).getApp().getPackageName());
    paramDialogInterface.setAction("tencent.av.v2q.CancelCallBack");
    paramDialogInterface.putExtra("fromPhone", this.a.a.c);
    paramDialogInterface.putExtra("toPhone", this.a.a.jdField_b_of_type_JavaLangString);
    paramDialogInterface.putExtra("fromUin", this.a.a.e);
    paramDialogInterface.putExtra("uinType", this.a.a.jdField_b_of_type_Int);
    paramDialogInterface.putExtra("toUin", this.a.a.e);
    paramDialogInterface.putExtra("callBackId", this.a.a.a);
    CallbackWaitingActivity.a(this.a.a).getApp().sendBroadcast(paramDialogInterface);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jrl
 * JD-Core Version:    0.7.0.1
 */