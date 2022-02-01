import com.tencent.qphone.base.util.QLog;

class mpt
  extends mcc
{
  mpt(mpp parammpp) {}
  
  protected void b(mcg parammcg)
  {
    if (parammcg.jdField_b_of_type_Boolean) {
      return;
    }
    parammcg.jdField_b_of_type_Boolean = this.a.a(false, 2);
    if (parammcg.jdField_b_of_type_Boolean) {
      parammcg.jdField_b_of_type_JavaLangString = "AVRegbagResultUI";
    }
    QLog.w(this.a.i, 1, "onAVActivityPreBackPressed, BlockSystemBack[" + parammcg.jdField_b_of_type_Boolean + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mpt
 * JD-Core Version:    0.7.0.1
 */