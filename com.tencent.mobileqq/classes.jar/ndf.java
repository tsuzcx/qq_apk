import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ndf
  implements DialogInterface.OnClickListener
{
  ndf(ncz paramncz, WeakReference paramWeakReference, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if (ncz.a(this.jdField_a_of_type_Ncz) != null) {
        ncz.a(this.jdField_a_of_type_Ncz).removeObserver(ncz.a(this.jdField_a_of_type_Ncz));
      }
      ncz.a(this.jdField_a_of_type_Ncz, new ndg(this));
      ncz.a(this.jdField_a_of_type_Ncz).addObserver(ncz.a(this.jdField_a_of_type_Ncz));
      bdla.b(null, "dc00898", "", "", "0X800B078", "0X800B078", this.jdField_a_of_type_Int, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ndf
 * JD-Core Version:    0.7.0.1
 */