import com.tencent.qphone.base.util.QLog;

class mqq
  extends mcx
{
  mqq(mqm parammqm) {}
  
  protected void b(mdb parammdb)
  {
    if (parammdb.jdField_b_of_type_Boolean) {
      return;
    }
    parammdb.jdField_b_of_type_Boolean = this.a.a(false, 2);
    if (parammdb.jdField_b_of_type_Boolean) {
      parammdb.jdField_b_of_type_JavaLangString = "AVRegbagResultUI";
    }
    QLog.w(this.a.i, 1, "onAVActivityPreBackPressed, BlockSystemBack[" + parammdb.jdField_b_of_type_Boolean + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mqq
 * JD-Core Version:    0.7.0.1
 */