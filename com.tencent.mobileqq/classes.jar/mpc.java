import com.tencent.qphone.base.util.QLog;

class mpc
  implements mpi
{
  mpc(moy parammoy) {}
  
  public void a(mph parammph)
  {
    if (parammph == this.a.jdField_a_of_type_Mph)
    {
      this.a.jdField_a_of_type_Mph = null;
      this.a.jdField_a_of_type_Mpi = null;
      this.a.a("onGetRedBagResult", moy.d(this.a), parammph.a);
      return;
    }
    QLog.w("AVRedBag", 1, "onGetRedBagResult,  GetRedBag不一致，callback[" + parammph + "], src[" + this.a.jdField_a_of_type_Mph + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mpc
 * JD-Core Version:    0.7.0.1
 */