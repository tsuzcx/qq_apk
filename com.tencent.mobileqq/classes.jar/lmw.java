import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class lmw
{
  private static volatile lmw jdField_a_of_type_Lmw;
  lmy jdField_a_of_type_Lmy = null;
  lna jdField_a_of_type_Lna = null;
  
  public static lmw a()
  {
    if (jdField_a_of_type_Lmw == null) {}
    try
    {
      if (jdField_a_of_type_Lmw == null)
      {
        lmw locallmw = new lmw();
        locallmw.b();
        jdField_a_of_type_Lmw = locallmw;
      }
      return jdField_a_of_type_Lmw;
    }
    finally {}
  }
  
  public static void a()
  {
    lmw locallmw = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, String.format("onDownloadRequest, mStatusGameplay[%s]", new Object[] { Integer.valueOf(locallmw.jdField_a_of_type_Lmy.a) }));
    }
    lna.a();
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Lmw != null;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Lmy = new lmy();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Lna = new lna();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Lmy.a();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Lmy.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lmw
 * JD-Core Version:    0.7.0.1
 */