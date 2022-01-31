import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ors
  implements Runnable
{
  public ors(QRDisplayActivity paramQRDisplayActivity, String paramString) {}
  
  public void run()
  {
    String str = QRUtils.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.b);
    ThreadManager.getUIHandler().post(new ort(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ors
 * JD-Core Version:    0.7.0.1
 */