import com.tencent.qphone.base.util.QLog;

public class mpt
  extends mqj
{
  public int a;
  public lgr a;
  public boolean a;
  public boolean b;
  
  mpt(mpc parammpc)
  {
    super(parammpc);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Lgr = new mpu(this);
    parammpc = lgq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (parammpc != null)
    {
      parammpc.a(11, this.jdField_a_of_type_Lgr);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mpt
 * JD-Core Version:    0.7.0.1
 */