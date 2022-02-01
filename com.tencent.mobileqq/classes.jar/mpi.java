import com.tencent.qphone.base.util.QLog;

class mpi
  implements mpo
{
  mpi(mpe parammpe) {}
  
  public void a(mpn parammpn)
  {
    if (parammpn == this.a.jdField_a_of_type_Mpn)
    {
      this.a.jdField_a_of_type_Mpn = null;
      this.a.jdField_a_of_type_Mpo = null;
      this.a.a("onGetRedBagResult", mpe.d(this.a), parammpn.a);
      return;
    }
    QLog.w("AVRedBag", 1, "onGetRedBagResult,  GetRedBag不一致，callback[" + parammpn + "], src[" + this.a.jdField_a_of_type_Mpn + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mpi
 * JD-Core Version:    0.7.0.1
 */