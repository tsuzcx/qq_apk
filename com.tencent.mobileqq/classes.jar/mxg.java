import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.avgame.ui.AvGameLoadingActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class mxg
  implements DialogInterface.OnClickListener
{
  mxg(mxc parammxc, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface.cancel();
      if (this.jdField_a_of_type_AndroidAppActivity != null)
      {
        paramDialogInterface = this.jdField_a_of_type_Mxc.a();
        if (TextUtils.isEmpty(paramDialogInterface))
        {
          QLog.e("AvGameManager", 1, "preCheckIsUserGamePlaying roomPlayingId empty");
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131690343, 0).a();
        }
      }
      for (;;)
      {
        bdll.b(mxc.a(this.jdField_a_of_type_Mxc), "dc00898", "", "", "0X800B016", "0X800B016", 0, 0, "", "", "", "");
        return;
        mxc.a(this.jdField_a_of_type_Mxc);
        AvGameLoadingActivity.a(false, this.jdField_a_of_type_AndroidAppActivity, null, paramDialogInterface, null, "");
        continue;
        QLog.e("AvGameManager", 1, "alertDialogWithRetCode createAvGameRoom context  null ");
      }
    }
    paramDialogInterface.cancel();
    QLog.d("AvGameManager", 2, "showInPlayDialog dialog cancel");
    bdll.b(mxc.a(this.jdField_a_of_type_Mxc), "dc00898", "", "", "0X800B017", "0X800B017", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxg
 * JD-Core Version:    0.7.0.1
 */