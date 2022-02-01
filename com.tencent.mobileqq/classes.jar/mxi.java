import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class mxi
  implements DialogInterface.OnClickListener
{
  mxi(mxc parammxc, String paramString1, Activity paramActivity, int paramInt1, String paramString2, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if (mxc.a(this.jdField_a_of_type_Mxc) != null) {
        mxc.a(this.jdField_a_of_type_Mxc).removeObserver(mxc.a(this.jdField_a_of_type_Mxc));
      }
      mxc.a(this.jdField_a_of_type_Mxc, new mxj(this));
      mxc.a(this.jdField_a_of_type_Mxc).addObserver(mxc.a(this.jdField_a_of_type_Mxc));
      bdll.b(null, "dc00898", "", "", "0X800B078", "0X800B078", 0, 0, "", "", "", "");
      paramDialogInterface = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", "https://ti.qq.com/realname/index.html?source=avgame");
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramDialogInterface);
      if (QLog.isColorLevel()) {
        QLog.i("AvGameManager", 2, "showRealNameDialog click confirm. roomId: " + this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxi
 * JD-Core Version:    0.7.0.1
 */