import com.tencent.qphone.base.util.QLog;

class mpn
  extends mbx
{
  mpn(mpj parammpj) {}
  
  protected void b(mcb parammcb)
  {
    if (parammcb.jdField_b_of_type_Boolean) {
      return;
    }
    parammcb.jdField_b_of_type_Boolean = this.a.a(false, 2);
    if (parammcb.jdField_b_of_type_Boolean) {
      parammcb.jdField_b_of_type_JavaLangString = "AVRegbagResultUI";
    }
    QLog.w(this.a.i, 1, "onAVActivityPreBackPressed, BlockSystemBack[" + parammcb.jdField_b_of_type_Boolean + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mpn
 * JD-Core Version:    0.7.0.1
 */