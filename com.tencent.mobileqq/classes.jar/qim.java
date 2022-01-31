import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class qim
  extends aywb
{
  qim(qil paramqil) {}
  
  public void handleMessage(Message paramMessage)
  {
    ayqo localayqo = (ayqo)paramMessage.obj;
    if ((localayqo == null) || (localayqo.jdField_b_of_type_Int != 24) || (localayqo.c != 10)) {}
    while ((localayqo.jdField_b_of_type_Long != this.a.jdField_a_of_type_Aywc.a) || (TextUtils.equals(localayqo.f, qil.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1002: 
    case 1004: 
    default: 
      return;
    case 1001: 
      if (this.a.jdField_a_of_type_Qik != null) {
        this.a.jdField_a_of_type_Qik.a();
      }
      qil.a(this.a, System.currentTimeMillis());
      return;
    case 1003: 
      qil.b(this.a, System.currentTimeMillis());
      nol.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 0, String.valueOf(qil.a(this.a)), String.valueOf(qil.b(this.a)), String.valueOf(qil.a(this.a) - qil.b(this.a)), String.valueOf(qil.c(this.a) - qil.d(this.a)));
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send finished!");
      }
      qil.a(this.a, localayqo.f);
      qil.b(this.a, localayqo.i);
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler mImageMd5=" + qil.a(this.a) + ", mImageUrl=" + qil.b(this.a));
      }
      qil.a(this.a, 0, qil.b(this.a), qil.a(this.a), null);
      return;
    }
    qil.b(this.a, System.currentTimeMillis());
    nol.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 1, String.valueOf(qil.a(this.a)), String.valueOf(qil.b(this.a)), String.valueOf(qil.a(this.a) - qil.b(this.a)), String.valueOf(qil.c(this.a) - qil.d(this.a)));
    if (QLog.isColorLevel()) {
      QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send error:" + localayqo.g);
    }
    qil.a(this.a, 1004, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qim
 * JD-Core Version:    0.7.0.1
 */