import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class lck
{
  private static volatile lck jdField_a_of_type_Lck;
  lcm jdField_a_of_type_Lcm = null;
  lco jdField_a_of_type_Lco = null;
  
  public static lck a()
  {
    if (jdField_a_of_type_Lck == null) {}
    try
    {
      if (jdField_a_of_type_Lck == null)
      {
        lck locallck = new lck();
        locallck.b();
        jdField_a_of_type_Lck = locallck;
      }
      return jdField_a_of_type_Lck;
    }
    finally {}
  }
  
  public static void a()
  {
    lck locallck = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, String.format("onDownloadRequest, mStatusGameplay[%s]", new Object[] { Integer.valueOf(locallck.jdField_a_of_type_Lcm.a) }));
    }
    lco.a();
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Lck != null;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Lcm = new lcm();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Lco = new lco();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Lcm.a();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Lcm.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lck
 * JD-Core Version:    0.7.0.1
 */