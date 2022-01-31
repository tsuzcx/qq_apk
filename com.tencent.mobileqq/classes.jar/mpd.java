import com.tencent.qphone.base.util.QLog;

class mpd
  implements mpj
{
  mpd(moz parammoz) {}
  
  public void a(mpi parammpi)
  {
    if (parammpi == this.a.jdField_a_of_type_Mpi)
    {
      this.a.jdField_a_of_type_Mpi = null;
      this.a.jdField_a_of_type_Mpj = null;
      this.a.a("onGetRedBagResult", moz.d(this.a), parammpi.a);
      return;
    }
    QLog.w("AVRedBag", 1, "onGetRedBagResult,  GetRedBag不一致，callback[" + parammpi + "], src[" + this.a.jdField_a_of_type_Mpi + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mpd
 * JD-Core Version:    0.7.0.1
 */