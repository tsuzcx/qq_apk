import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class mwk
  extends anjq
{
  mwk(mwj parammwj) {}
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bcst.b(null, "dc00898", "", "", "0X800B079", "0X800B079", 0, 0, "", "", "", "");
      if (!this.a.jdField_a_of_type_JavaLangString.isEmpty()) {
        break label153;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AvGameManager", 2, "onGetRealNameStatusForAV createAvGameRoom");
      }
      this.a.jdField_a_of_type_Mwd.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_b_of_type_Int);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RealName", 2, "onGetRealNameStatusForAV authed: " + paramBoolean + ". Remove observer.");
      }
      mwd.a(this.a.jdField_a_of_type_Mwd).removeObserver(mwd.a(this.a.jdField_a_of_type_Mwd));
      return;
      label153:
      if (QLog.isColorLevel()) {
        QLog.i("AvGameManager", 2, "onGetRealNameStatusForAV joinAvGameRoom. roomId: " + this.a.jdField_a_of_type_JavaLangString);
      }
      this.a.jdField_a_of_type_Mwd.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mwk
 * JD-Core Version:    0.7.0.1
 */