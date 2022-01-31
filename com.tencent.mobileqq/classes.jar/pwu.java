import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteSwitchManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class pwu
{
  private static volatile pwu jdField_a_of_type_Pwu;
  private boolean jdField_a_of_type_Boolean;
  
  public static pwu a()
  {
    if (jdField_a_of_type_Pwu == null) {}
    try
    {
      if (jdField_a_of_type_Pwu == null) {
        jdField_a_of_type_Pwu = new pwu();
      }
      return jdField_a_of_type_Pwu;
    }
    finally {}
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    pwt.c();
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  void a()
  {
    b();
    PTSLiteSwitchManager.1 local1 = new PTSLiteSwitchManager.1(this);
    ThreadManager.getFileThreadHandler().post(local1);
  }
  
  public boolean a()
  {
    return (b()) && (pwe.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pwu
 * JD-Core Version:    0.7.0.1
 */