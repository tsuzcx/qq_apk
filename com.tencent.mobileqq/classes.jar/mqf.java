import com.tencent.qphone.base.util.QLog;

class mqf
  implements mql
{
  mqf(mqb parammqb) {}
  
  public void a(mqk parammqk)
  {
    if (parammqk == this.a.jdField_a_of_type_Mqk)
    {
      this.a.jdField_a_of_type_Mqk = null;
      this.a.jdField_a_of_type_Mql = null;
      this.a.a("onGetRedBagResult", mqb.d(this.a), parammqk.a);
      return;
    }
    QLog.w("AVRedBag", 1, "onGetRedBagResult,  GetRedBag不一致，callback[" + parammqk + "], src[" + this.a.jdField_a_of_type_Mqk + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mqf
 * JD-Core Version:    0.7.0.1
 */