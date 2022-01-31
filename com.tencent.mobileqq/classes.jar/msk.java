import com.tencent.qphone.base.util.QLog;

public class msk
  extends mta
{
  public int a;
  public lip a;
  public boolean a;
  public boolean b;
  
  msk(mrt parammrt)
  {
    super(parammrt);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Lip = new msl(this);
    parammrt = lio.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (parammrt != null)
    {
      parammrt.a(11, this.jdField_a_of_type_Lip);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     msk
 * JD-Core Version:    0.7.0.1
 */