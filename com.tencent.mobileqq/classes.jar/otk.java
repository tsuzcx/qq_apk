import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class otk
  implements Runnable
{
  public otk(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    String str = "temp_qrcode_share_" + this.a.c + ".png";
    str = QRUtils.a(this.a, str, this.a.b);
    ThreadManager.getUIHandler().post(new otl(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     otk
 * JD-Core Version:    0.7.0.1
 */