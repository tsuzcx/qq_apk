import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

class mxl
  implements DialogInterface.OnClickListener
{
  mxl(mxk parammxk, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      mxk.a(this.jdField_a_of_type_Mxk);
      paramDialogInterface = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", "https://ti.qq.com/realname/index.html?source=watchtogether");
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramDialogInterface, 21001);
      if (QLog.isColorLevel()) {
        QLog.i("WTogetherRealNameVideoProcessHelper", 2, "showRealNameDialog click confirm.");
      }
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mxl
 * JD-Core Version:    0.7.0.1
 */