import com.tencent.qphone.base.util.QLog;

class msi
  extends meu
{
  msi(mse parammse) {}
  
  protected void b(mey parammey)
  {
    if (parammey.jdField_b_of_type_Boolean) {
      return;
    }
    parammey.jdField_b_of_type_Boolean = this.a.a(false, 2);
    if (parammey.jdField_b_of_type_Boolean) {
      parammey.jdField_b_of_type_JavaLangString = "AVRegbagResultUI";
    }
    QLog.w(this.a.i, 1, "onAVActivityPreBackPressed, BlockSystemBack[" + parammey.jdField_b_of_type_Boolean + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     msi
 * JD-Core Version:    0.7.0.1
 */