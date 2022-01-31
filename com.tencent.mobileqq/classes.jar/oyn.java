import com.tencent.biz.qrcode.QRCodeEncodeCallback;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.qphone.base.util.QLog;

class oyn
  implements QRCodeEncodeCallback
{
  oyn(oyl paramoyl, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "onReceive qrcode url: " + paramBoolean);
    }
    if ((this.jdField_a_of_type_Oyl.a.b) || (this.jdField_a_of_type_Oyl.a.isFinishing())) {
      return;
    }
    if (!paramBoolean)
    {
      this.jdField_a_of_type_Oyl.a.g();
      return;
    }
    this.jdField_a_of_type_Oyl.a.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramString);
    paramString = QRUtils.a(paramString, -1);
    if (paramString != null)
    {
      this.jdField_a_of_type_Oyl.a.a = paramString;
      this.jdField_a_of_type_Oyl.a.f();
      return;
    }
    this.jdField_a_of_type_Oyl.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyn
 * JD-Core Version:    0.7.0.1
 */