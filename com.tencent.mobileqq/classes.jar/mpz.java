import com.tencent.qphone.base.util.QLog;

class mpz
  implements mqf
{
  mpz(mpv parammpv) {}
  
  public void a(mqe parammqe)
  {
    if (parammqe == this.a.jdField_a_of_type_Mqe)
    {
      this.a.jdField_a_of_type_Mqe = null;
      this.a.jdField_a_of_type_Mqf = null;
      this.a.a("onGetRedBagResult", mpv.d(this.a), parammqe.a);
      return;
    }
    QLog.w("AVRedBag", 1, "onGetRedBagResult,  GetRedBag不一致，callback[" + parammqe + "], src[" + this.a.jdField_a_of_type_Mqe + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mpz
 * JD-Core Version:    0.7.0.1
 */