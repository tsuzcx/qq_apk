import com.tencent.qphone.base.util.QLog;

public class mqs
  extends mri
{
  public int a;
  public lfy a;
  public boolean a;
  public boolean b;
  
  mqs(mqb parammqb)
  {
    super(parammqb);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Lfy = new mqt(this);
    parammqb = lfx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (parammqb != null)
    {
      parammqb.a(11, this.jdField_a_of_type_Lfy);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mqs
 * JD-Core Version:    0.7.0.1
 */