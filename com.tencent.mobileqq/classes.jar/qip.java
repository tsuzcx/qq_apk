import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class qip
  extends ayvz
{
  qip(qio paramqio) {}
  
  public void handleMessage(Message paramMessage)
  {
    ayqm localayqm = (ayqm)paramMessage.obj;
    if ((localayqm == null) || (localayqm.jdField_b_of_type_Int != 24) || (localayqm.c != 10)) {}
    while ((localayqm.jdField_b_of_type_Long != this.a.jdField_a_of_type_Aywa.a) || (TextUtils.equals(localayqm.f, qio.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1002: 
    case 1004: 
    default: 
      return;
    case 1001: 
      if (this.a.jdField_a_of_type_Qin != null) {
        this.a.jdField_a_of_type_Qin.a();
      }
      qio.a(this.a, System.currentTimeMillis());
      return;
    case 1003: 
      qio.b(this.a, System.currentTimeMillis());
      noo.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 0, String.valueOf(qio.a(this.a)), String.valueOf(qio.b(this.a)), String.valueOf(qio.a(this.a) - qio.b(this.a)), String.valueOf(qio.c(this.a) - qio.d(this.a)));
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send finished!");
      }
      qio.a(this.a, localayqm.f);
      qio.b(this.a, localayqm.i);
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler mImageMd5=" + qio.a(this.a) + ", mImageUrl=" + qio.b(this.a));
      }
      qio.a(this.a, 0, qio.b(this.a), qio.a(this.a), null);
      return;
    }
    qio.b(this.a, System.currentTimeMillis());
    noo.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 1, String.valueOf(qio.a(this.a)), String.valueOf(qio.b(this.a)), String.valueOf(qio.a(this.a) - qio.b(this.a)), String.valueOf(qio.c(this.a) - qio.d(this.a)));
    if (QLog.isColorLevel()) {
      QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send error:" + localayqm.g);
    }
    qio.a(this.a, 1004, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qip
 * JD-Core Version:    0.7.0.1
 */