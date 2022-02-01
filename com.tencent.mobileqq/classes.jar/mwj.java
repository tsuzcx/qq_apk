import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class mwj
  implements DialogInterface.OnClickListener
{
  mwj(mwd parammwd, String paramString1, Activity paramActivity, int paramInt1, String paramString2, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if (mwd.a(this.jdField_a_of_type_Mwd) != null) {
        mwd.a(this.jdField_a_of_type_Mwd).removeObserver(mwd.a(this.jdField_a_of_type_Mwd));
      }
      mwd.a(this.jdField_a_of_type_Mwd, new mwk(this));
      mwd.a(this.jdField_a_of_type_Mwd).addObserver(mwd.a(this.jdField_a_of_type_Mwd));
      bcst.b(null, "dc00898", "", "", "0X800B078", "0X800B078", 0, 0, "", "", "", "");
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
 * Qualified Name:     mwj
 * JD-Core Version:    0.7.0.1
 */