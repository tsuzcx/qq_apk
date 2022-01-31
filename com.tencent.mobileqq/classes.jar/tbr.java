import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;

public class tbr
  implements DialogInterface.OnClickListener
{
  public tbr(PayBridgeActivity paramPayBridgeActivity, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (BaseActivity.sTopActivity != null))
      {
        Intent localIntent = new Intent(BaseActivity.sTopActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        this.jdField_a_of_type_ComTencentMobileqqActivityPayBridgeActivity.startActivity(localIntent);
      }
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqActivityPayBridgeActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tbr
 * JD-Core Version:    0.7.0.1
 */