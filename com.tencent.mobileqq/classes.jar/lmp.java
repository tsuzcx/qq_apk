import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class lmp
{
  private static volatile lmp jdField_a_of_type_Lmp;
  lmr jdField_a_of_type_Lmr = null;
  lmt jdField_a_of_type_Lmt = null;
  
  public static lmp a()
  {
    if (jdField_a_of_type_Lmp == null) {}
    try
    {
      if (jdField_a_of_type_Lmp == null)
      {
        lmp locallmp = new lmp();
        locallmp.b();
        jdField_a_of_type_Lmp = locallmp;
      }
      return jdField_a_of_type_Lmp;
    }
    finally {}
  }
  
  public static void a()
  {
    lmp locallmp = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, String.format("onDownloadRequest, mStatusGameplay[%s]", new Object[] { Integer.valueOf(locallmp.jdField_a_of_type_Lmr.a) }));
    }
    lmt.a();
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Lmp != null;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Lmr = new lmr();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Lmt = new lmt();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Lmr.a();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Lmr.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lmp
 * JD-Core Version:    0.7.0.1
 */