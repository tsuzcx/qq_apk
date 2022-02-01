import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class rts
  extends bdzm
{
  rts(rtr paramrtr) {}
  
  public void handleMessage(Message paramMessage)
  {
    bduk localbduk = (bduk)paramMessage.obj;
    if ((localbduk == null) || (localbduk.jdField_b_of_type_Int != 24) || (localbduk.c != 10)) {}
    while ((localbduk.jdField_b_of_type_Long != this.a.jdField_a_of_type_Bdzn.a) || (TextUtils.equals(localbduk.f, rtr.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1002: 
    case 1004: 
    default: 
      return;
    case 1001: 
      if (this.a.jdField_a_of_type_Rtq != null) {
        this.a.jdField_a_of_type_Rtq.a();
      }
      rtr.a(this.a, System.currentTimeMillis());
      return;
    case 1003: 
      rtr.b(this.a, System.currentTimeMillis());
      oat.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 0, String.valueOf(rtr.a(this.a)), String.valueOf(rtr.b(this.a)), String.valueOf(rtr.a(this.a) - rtr.b(this.a)), String.valueOf(rtr.c(this.a) - rtr.d(this.a)));
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send finished!");
      }
      rtr.a(this.a, localbduk.f);
      rtr.b(this.a, localbduk.i);
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler mImageMd5=" + rtr.a(this.a) + ", mImageUrl=" + rtr.b(this.a));
      }
      rtr.a(this.a, 0, rtr.b(this.a), rtr.a(this.a), null);
      return;
    }
    rtr.b(this.a, System.currentTimeMillis());
    oat.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 1, String.valueOf(rtr.a(this.a)), String.valueOf(rtr.b(this.a)), String.valueOf(rtr.a(this.a) - rtr.b(this.a)), String.valueOf(rtr.c(this.a) - rtr.d(this.a)));
    if (QLog.isColorLevel()) {
      QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send error:" + localbduk.g);
    }
    rtr.a(this.a, 1004, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rts
 * JD-Core Version:    0.7.0.1
 */