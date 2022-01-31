import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class qxt
  extends baua
{
  qxt(qxs paramqxs) {}
  
  public void handleMessage(Message paramMessage)
  {
    baoj localbaoj = (baoj)paramMessage.obj;
    if ((localbaoj == null) || (localbaoj.jdField_b_of_type_Int != 24) || (localbaoj.c != 10)) {}
    while ((localbaoj.jdField_b_of_type_Long != this.a.jdField_a_of_type_Baub.a) || (TextUtils.equals(localbaoj.f, qxs.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1002: 
    case 1004: 
    default: 
      return;
    case 1001: 
      if (this.a.jdField_a_of_type_Qxr != null) {
        this.a.jdField_a_of_type_Qxr.a();
      }
      qxs.a(this.a, System.currentTimeMillis());
      return;
    case 1003: 
      qxs.b(this.a, System.currentTimeMillis());
      nrt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 0, String.valueOf(qxs.a(this.a)), String.valueOf(qxs.b(this.a)), String.valueOf(qxs.a(this.a) - qxs.b(this.a)), String.valueOf(qxs.c(this.a) - qxs.d(this.a)));
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send finished!");
      }
      qxs.a(this.a, localbaoj.f);
      qxs.b(this.a, localbaoj.i);
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler mImageMd5=" + qxs.a(this.a) + ", mImageUrl=" + qxs.b(this.a));
      }
      qxs.a(this.a, 0, qxs.b(this.a), qxs.a(this.a), null);
      return;
    }
    qxs.b(this.a, System.currentTimeMillis());
    nrt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 1, String.valueOf(qxs.a(this.a)), String.valueOf(qxs.b(this.a)), String.valueOf(qxs.a(this.a) - qxs.b(this.a)), String.valueOf(qxs.c(this.a) - qxs.d(this.a)));
    if (QLog.isColorLevel()) {
      QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send error:" + localbaoj.g);
    }
    qxs.a(this.a, 1004, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qxt
 * JD-Core Version:    0.7.0.1
 */