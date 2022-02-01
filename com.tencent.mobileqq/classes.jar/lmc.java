import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class lmc
{
  private static volatile lmc jdField_a_of_type_Lmc;
  lme jdField_a_of_type_Lme = null;
  lmg jdField_a_of_type_Lmg = null;
  
  public static lmc a()
  {
    if (jdField_a_of_type_Lmc == null) {}
    try
    {
      if (jdField_a_of_type_Lmc == null)
      {
        lmc locallmc = new lmc();
        locallmc.b();
        jdField_a_of_type_Lmc = locallmc;
      }
      return jdField_a_of_type_Lmc;
    }
    finally {}
  }
  
  public static void a()
  {
    lmc locallmc = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, String.format("onDownloadRequest, mStatusGameplay[%s]", new Object[] { Integer.valueOf(locallmc.jdField_a_of_type_Lme.a) }));
    }
    lmg.a();
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Lmc != null;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Lme = new lme();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Lmg = new lmg();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Lme.a();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Lme.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lmc
 * JD-Core Version:    0.7.0.1
 */