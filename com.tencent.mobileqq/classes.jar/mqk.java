import com.tencent.qphone.base.util.QLog;

class mqk
  extends mct
{
  mqk(mqg parammqg) {}
  
  protected void b(mcx parammcx)
  {
    if (parammcx.jdField_b_of_type_Boolean) {
      return;
    }
    parammcx.jdField_b_of_type_Boolean = this.a.a(false, 2);
    if (parammcx.jdField_b_of_type_Boolean) {
      parammcx.jdField_b_of_type_JavaLangString = "AVRegbagResultUI";
    }
    QLog.w(this.a.i, 1, "onAVActivityPreBackPressed, BlockSystemBack[" + parammcx.jdField_b_of_type_Boolean + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqk
 * JD-Core Version:    0.7.0.1
 */