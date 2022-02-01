import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteSwitchManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class qhv
{
  private static volatile qhv jdField_a_of_type_Qhv;
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  
  public static qhv a()
  {
    if (jdField_a_of_type_Qhv == null) {}
    try
    {
      if (jdField_a_of_type_Qhv == null) {
        jdField_a_of_type_Qhv = new qhv();
      }
      return jdField_a_of_type_Qhv;
    }
    finally {}
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = true;
    qhq.c();
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  private boolean d()
  {
    return this.b;
  }
  
  void a()
  {
    b();
    PTSLiteSwitchManager.1 local1 = new PTSLiteSwitchManager.1(this);
    ThreadManager.getFileThreadHandler().post(local1);
  }
  
  public boolean a()
  {
    return (d()) && (qha.a().a());
  }
  
  @Deprecated
  public boolean b()
  {
    return (c()) && (qha.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qhv
 * JD-Core Version:    0.7.0.1
 */