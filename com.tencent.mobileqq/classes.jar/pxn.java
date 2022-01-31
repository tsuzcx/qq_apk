import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.qphone.base.util.QLog;

public final class pxn
  implements Runnable
{
  public pxn(String paramString1, String paramString2, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(0, 1);
    Object localObject = new Intent();
    ((Intent)localObject).addFlags(603979776);
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("uintype", 9501);
    ((Intent)localObject).putExtra("file_send_business_type", 1);
    ((Intent)localObject).putExtra("file_send_path", this.b);
    long l = System.currentTimeMillis();
    localObject = ShortVideoBusiManager.a(1, localObject, localShortVideoReq);
    if (QLog.isColorLevel()) {
      QLog.i("DeviceShortVideo", 2, "createShortVideoUploadInfo cost:" + (System.currentTimeMillis() - l));
    }
    localShortVideoReq.a((ShortVideoUploadInfo)localObject);
    ShortVideoBusiManager.a(localShortVideoReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pxn
 * JD-Core Version:    0.7.0.1
 */