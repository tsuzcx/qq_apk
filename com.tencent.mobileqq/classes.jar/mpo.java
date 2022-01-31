import com.tencent.qphone.base.util.QLog;

class mpo
  extends mcf
{
  mpo(mpk parammpk) {}
  
  protected void b(mcj parammcj)
  {
    if (parammcj.jdField_b_of_type_Boolean) {
      return;
    }
    parammcj.jdField_b_of_type_Boolean = this.a.a(false, 2);
    if (parammcj.jdField_b_of_type_Boolean) {
      parammcj.jdField_b_of_type_JavaLangString = "AVRegbagResultUI";
    }
    QLog.w(this.a.i, 1, "onAVActivityPreBackPressed, BlockSystemBack[" + parammcj.jdField_b_of_type_Boolean + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mpo
 * JD-Core Version:    0.7.0.1
 */