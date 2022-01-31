import com.tencent.qphone.base.util.QLog;

public class mpq
  extends mqg
{
  public int a;
  public lgm a;
  public boolean a;
  public boolean b;
  
  mpq(moz parammoz)
  {
    super(parammoz);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Lgm = new mpr(this);
    parammoz = lgl.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (parammoz != null)
    {
      parammoz.a(11, this.jdField_a_of_type_Lgm);
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
 * Qualified Name:     mpq
 * JD-Core Version:    0.7.0.1
 */