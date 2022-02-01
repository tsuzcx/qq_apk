import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class lmk
{
  private static volatile lmk jdField_a_of_type_Lmk;
  lmm jdField_a_of_type_Lmm = null;
  lmo jdField_a_of_type_Lmo = null;
  
  public static lmk a()
  {
    if (jdField_a_of_type_Lmk == null) {}
    try
    {
      if (jdField_a_of_type_Lmk == null)
      {
        lmk locallmk = new lmk();
        locallmk.b();
        jdField_a_of_type_Lmk = locallmk;
      }
      return jdField_a_of_type_Lmk;
    }
    finally {}
  }
  
  public static void a()
  {
    lmk locallmk = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, String.format("onDownloadRequest, mStatusGameplay[%s]", new Object[] { Integer.valueOf(locallmk.jdField_a_of_type_Lmm.a) }));
    }
    lmo.a();
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Lmk != null;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Lmm = new lmm();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Lmo = new lmo();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Lmm.a();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Lmm.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lmk
 * JD-Core Version:    0.7.0.1
 */