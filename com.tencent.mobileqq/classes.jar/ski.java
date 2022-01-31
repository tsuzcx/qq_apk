import android.app.Activity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopshare.TroopShareUtility;

public final class ski
  implements Runnable
{
  public ski(String paramString1, Activity paramActivity, String paramString2, String paramString3, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = "temp_discuss_link_share_" + this.jdField_a_of_type_JavaLangString + ".png";
    str = QRUtils.a(this.jdField_a_of_type_AndroidAppActivity, str, TroopShareUtility.a(this.b, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new skj(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ski
 * JD-Core Version:    0.7.0.1
 */