import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class loz
{
  private static volatile loz jdField_a_of_type_Loz;
  lpb jdField_a_of_type_Lpb = null;
  lpd jdField_a_of_type_Lpd = null;
  
  public static loz a()
  {
    if (jdField_a_of_type_Loz == null) {}
    try
    {
      if (jdField_a_of_type_Loz == null)
      {
        loz localloz = new loz();
        localloz.b();
        jdField_a_of_type_Loz = localloz;
      }
      return jdField_a_of_type_Loz;
    }
    finally {}
  }
  
  public static void a()
  {
    loz localloz = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, String.format("onDownloadRequest, mStatusGameplay[%s]", new Object[] { Integer.valueOf(localloz.jdField_a_of_type_Lpb.a) }));
    }
    lpd.a();
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Loz != null;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Lpb = new lpb();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Lpd = new lpd();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Lpb.a();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Lpb.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     loz
 * JD-Core Version:    0.7.0.1
 */