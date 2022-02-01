import com.tencent.qphone.base.util.QLog;

public class mpp
  extends mqf
{
  public int a;
  public lfk a;
  public boolean a;
  public boolean b;
  
  mpp(moy parammoy)
  {
    super(parammoy);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Lfk = new mpq(this);
    parammoy = lfj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (parammoy != null)
    {
      parammoy.a(11, this.jdField_a_of_type_Lfk);
      return;
    }
    QLog.w(this.i, 1, "ListenPeerMsg, mHandlerForVideo为空");
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    if (QLog.isDevelopLevel()) {
      QLog.w(this.i, 1, "resetData[" + paramString + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mpp
 * JD-Core Version:    0.7.0.1
 */