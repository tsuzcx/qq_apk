import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteSwitchManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class qph
{
  private static volatile qph jdField_a_of_type_Qph;
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  
  public static qph a()
  {
    if (jdField_a_of_type_Qph == null) {}
    try
    {
      if (jdField_a_of_type_Qph == null) {
        jdField_a_of_type_Qph = new qph();
      }
      return jdField_a_of_type_Qph;
    }
    finally {}
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = true;
    qpc.c();
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
    return (d()) && (qoo.a().a());
  }
  
  @Deprecated
  public boolean b()
  {
    return (c()) && (qoo.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qph
 * JD-Core Version:    0.7.0.1
 */