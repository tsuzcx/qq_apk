import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteSwitchManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class rad
{
  private static volatile rad jdField_a_of_type_Rad;
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  
  public static rad a()
  {
    if (jdField_a_of_type_Rad == null) {}
    try
    {
      if (jdField_a_of_type_Rad == null) {
        jdField_a_of_type_Rad = new rad();
      }
      return jdField_a_of_type_Rad;
    }
    finally {}
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = true;
    qzw.c();
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
    return (d()) && (qzg.a().a());
  }
  
  @Deprecated
  public boolean b()
  {
    return (c()) && (qzg.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rad
 * JD-Core Version:    0.7.0.1
 */