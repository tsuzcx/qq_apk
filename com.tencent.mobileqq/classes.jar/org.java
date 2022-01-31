import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.util.TroopReportor;

public class org
  implements Runnable
{
  public org(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    String str = "temp_qrcode_share_" + this.a.jdField_c_of_type_JavaLangString + ".png";
    try
    {
      str = QRUtils.a(this.a.getApplicationContext(), str, this.a.b);
      this.a.runOnUiThread(new ori(this, str));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (this.a.jdField_c_of_type_Int == 2) {
        TroopReportor.a("Grp_share", "grpData_admin", "qr_qzone", 0, 0, new String[] { this.a.jdField_c_of_type_JavaLangString, String.valueOf(this.a.a), "1" });
      }
      this.a.runOnUiThread(new orh(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     org
 * JD-Core Version:    0.7.0.1
 */