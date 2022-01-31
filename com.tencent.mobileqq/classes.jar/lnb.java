import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class lnb
{
  private static volatile lnb jdField_a_of_type_Lnb;
  lnd jdField_a_of_type_Lnd = null;
  lnf jdField_a_of_type_Lnf = null;
  
  public static lnb a()
  {
    if (jdField_a_of_type_Lnb == null) {}
    try
    {
      if (jdField_a_of_type_Lnb == null)
      {
        lnb locallnb = new lnb();
        locallnb.b();
        jdField_a_of_type_Lnb = locallnb;
      }
      return jdField_a_of_type_Lnb;
    }
    finally {}
  }
  
  public static void a()
  {
    lnb locallnb = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, String.format("onDownloadRequest, mStatusGameplay[%s]", new Object[] { Integer.valueOf(locallnb.jdField_a_of_type_Lnd.a) }));
    }
    lnf.a();
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Lnb != null;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Lnd = new lnd();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Lnf = new lnf();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Lnd.a();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Lnd.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lnb
 * JD-Core Version:    0.7.0.1
 */