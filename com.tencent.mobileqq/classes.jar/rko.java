import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class rko
  extends beyf
{
  rko(rkn paramrkn) {}
  
  public void handleMessage(Message paramMessage)
  {
    bete localbete = (bete)paramMessage.obj;
    if ((localbete == null) || (localbete.jdField_b_of_type_Int != 24) || (localbete.c != 10)) {}
    while ((localbete.jdField_b_of_type_Long != this.a.jdField_a_of_type_Beyg.a) || (TextUtils.equals(localbete.f, rkn.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1002: 
    case 1004: 
    default: 
      return;
    case 1001: 
      if (this.a.jdField_a_of_type_Rkm != null) {
        this.a.jdField_a_of_type_Rkm.a();
      }
      rkn.a(this.a, System.currentTimeMillis());
      return;
    case 1003: 
      rkn.b(this.a, System.currentTimeMillis());
      ocd.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 0, String.valueOf(rkn.a(this.a)), String.valueOf(rkn.b(this.a)), String.valueOf(rkn.a(this.a) - rkn.b(this.a)), String.valueOf(rkn.c(this.a) - rkn.d(this.a)));
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send finished!");
      }
      rkn.a(this.a, localbete.f);
      rkn.b(this.a, localbete.i);
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler mImageMd5=" + rkn.a(this.a) + ", mImageUrl=" + rkn.b(this.a));
      }
      rkn.a(this.a, 0, rkn.b(this.a), rkn.a(this.a), null);
      return;
    }
    rkn.b(this.a, System.currentTimeMillis());
    ocd.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 1, String.valueOf(rkn.a(this.a)), String.valueOf(rkn.b(this.a)), String.valueOf(rkn.a(this.a) - rkn.b(this.a)), String.valueOf(rkn.c(this.a) - rkn.d(this.a)));
    if (QLog.isColorLevel()) {
      QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send error:" + localbete.g);
    }
    rkn.a(this.a, 1004, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rko
 * JD-Core Version:    0.7.0.1
 */