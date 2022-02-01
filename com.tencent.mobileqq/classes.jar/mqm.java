import com.tencent.qphone.base.util.QLog;

public class mqm
  extends mrc
{
  public int a;
  public lfs a;
  public boolean a;
  public boolean b;
  
  mqm(mpv parammpv)
  {
    super(parammpv);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Lfs = new mqn(this);
    parammpv = lfr.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (parammpv != null)
    {
      parammpv.a(11, this.jdField_a_of_type_Lfs);
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
 * Qualified Name:     mqm
 * JD-Core Version:    0.7.0.1
 */