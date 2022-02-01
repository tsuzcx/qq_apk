import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class mxj
  extends anvn
{
  mxj(mxi parammxi) {}
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bdll.b(null, "dc00898", "", "", "0X800B079", "0X800B079", 0, 0, "", "", "", "");
      if (!this.a.jdField_a_of_type_JavaLangString.isEmpty()) {
        break label153;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AvGameManager", 2, "onGetRealNameStatusForAV createAvGameRoom");
      }
      this.a.jdField_a_of_type_Mxc.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_b_of_type_Int);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RealName", 2, "onGetRealNameStatusForAV authed: " + paramBoolean + ". Remove observer.");
      }
      mxc.a(this.a.jdField_a_of_type_Mxc).removeObserver(mxc.a(this.a.jdField_a_of_type_Mxc));
      return;
      label153:
      if (QLog.isColorLevel()) {
        QLog.i("AvGameManager", 2, "onGetRealNameStatusForAV joinAvGameRoom. roomId: " + this.a.jdField_a_of_type_JavaLangString);
      }
      this.a.jdField_a_of_type_Mxc.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxj
 * JD-Core Version:    0.7.0.1
 */