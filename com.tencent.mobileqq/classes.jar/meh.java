import com.tencent.qphone.base.util.QLog;

class meh
  implements men
{
  meh(med parammed) {}
  
  public void a(mem parammem)
  {
    if (parammem == this.a.jdField_a_of_type_Mem)
    {
      this.a.jdField_a_of_type_Mem = null;
      this.a.jdField_a_of_type_Men = null;
      this.a.a("onGetRedBagResult", med.d(this.a), parammem.a);
      return;
    }
    QLog.w("AVRedBag", 1, "onGetRedBagResult,  GetRedBag不一致，callback[" + parammem + "], src[" + this.a.jdField_a_of_type_Mem + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     meh
 * JD-Core Version:    0.7.0.1
 */