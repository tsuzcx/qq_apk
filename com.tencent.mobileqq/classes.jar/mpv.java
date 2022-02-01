import com.tencent.qphone.base.util.QLog;

public class mpv
  extends mql
{
  public int a;
  public lfm a;
  public boolean a;
  public boolean b;
  
  mpv(mpe parammpe)
  {
    super(parammpe);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Lfm = new mpw(this);
    parammpe = lfl.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (parammpe != null)
    {
      parammpe.a(11, this.jdField_a_of_type_Lfm);
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
 * Qualified Name:     mpv
 * JD-Core Version:    0.7.0.1
 */