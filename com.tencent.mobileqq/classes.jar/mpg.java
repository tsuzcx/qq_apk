import com.tencent.qphone.base.util.QLog;

class mpg
  implements mpm
{
  mpg(mpc parammpc) {}
  
  public void a(mpl parammpl)
  {
    if (parammpl == this.a.jdField_a_of_type_Mpl)
    {
      this.a.jdField_a_of_type_Mpl = null;
      this.a.jdField_a_of_type_Mpm = null;
      this.a.a("onGetRedBagResult", mpc.d(this.a), parammpl.a);
      return;
    }
    QLog.w("AVRedBag", 1, "onGetRedBagResult,  GetRedBag不一致，callback[" + parammpl + "], src[" + this.a.jdField_a_of_type_Mpl + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mpg
 * JD-Core Version:    0.7.0.1
 */