import com.tencent.qphone.base.util.QLog;

class mpr
  extends mck
{
  mpr(mpn parammpn) {}
  
  protected void b(mco parammco)
  {
    if (parammco.jdField_b_of_type_Boolean) {
      return;
    }
    parammco.jdField_b_of_type_Boolean = this.a.a(false, 2);
    if (parammco.jdField_b_of_type_Boolean) {
      parammco.jdField_b_of_type_JavaLangString = "AVRegbagResultUI";
    }
    QLog.w(this.a.i, 1, "onAVActivityPreBackPressed, BlockSystemBack[" + parammco.jdField_b_of_type_Boolean + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mpr
 * JD-Core Version:    0.7.0.1
 */