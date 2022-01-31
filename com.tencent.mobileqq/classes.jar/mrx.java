import com.tencent.qphone.base.util.QLog;

class mrx
  implements msd
{
  mrx(mrt parammrt) {}
  
  public void a(msc parammsc)
  {
    if (parammsc == this.a.jdField_a_of_type_Msc)
    {
      this.a.jdField_a_of_type_Msc = null;
      this.a.jdField_a_of_type_Msd = null;
      this.a.a("onGetRedBagResult", mrt.d(this.a), parammsc.a);
      return;
    }
    QLog.w("AVRedBag", 1, "onGetRedBagResult,  GetRedBag不一致，callback[" + parammsc + "], src[" + this.a.jdField_a_of_type_Msc + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mrx
 * JD-Core Version:    0.7.0.1
 */