import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class pwr
  extends axvs
{
  pwr(pwq parampwq) {}
  
  public void handleMessage(Message paramMessage)
  {
    axqf localaxqf = (axqf)paramMessage.obj;
    if ((localaxqf == null) || (localaxqf.jdField_b_of_type_Int != 24) || (localaxqf.c != 10)) {}
    while ((localaxqf.jdField_b_of_type_Long != this.a.jdField_a_of_type_Axvt.a) || (TextUtils.equals(localaxqf.f, pwq.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1002: 
    case 1004: 
    default: 
      return;
    case 1001: 
      if (this.a.jdField_a_of_type_Pwp != null) {
        this.a.jdField_a_of_type_Pwp.a();
      }
      pwq.a(this.a, System.currentTimeMillis());
      return;
    case 1003: 
      pwq.b(this.a, System.currentTimeMillis());
      ndn.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 0, String.valueOf(pwq.a(this.a)), String.valueOf(pwq.b(this.a)), String.valueOf(pwq.a(this.a) - pwq.b(this.a)), String.valueOf(pwq.c(this.a) - pwq.d(this.a)));
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send finished!");
      }
      pwq.a(this.a, localaxqf.f);
      pwq.b(this.a, localaxqf.i);
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler mImageMd5=" + pwq.a(this.a) + ", mImageUrl=" + pwq.b(this.a));
      }
      pwq.a(this.a, 0, pwq.b(this.a), pwq.a(this.a), null);
      return;
    }
    pwq.b(this.a, System.currentTimeMillis());
    ndn.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 1, String.valueOf(pwq.a(this.a)), String.valueOf(pwq.b(this.a)), String.valueOf(pwq.a(this.a) - pwq.b(this.a)), String.valueOf(pwq.c(this.a) - pwq.d(this.a)));
    if (QLog.isColorLevel()) {
      QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send error:" + localaxqf.g);
    }
    pwq.a(this.a, 1004, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pwr
 * JD-Core Version:    0.7.0.1
 */