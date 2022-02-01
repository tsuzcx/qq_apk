import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class llw
{
  private static volatile llw jdField_a_of_type_Llw;
  lly jdField_a_of_type_Lly = null;
  lma jdField_a_of_type_Lma = null;
  
  public static llw a()
  {
    if (jdField_a_of_type_Llw == null) {}
    try
    {
      if (jdField_a_of_type_Llw == null)
      {
        llw localllw = new llw();
        localllw.b();
        jdField_a_of_type_Llw = localllw;
      }
      return jdField_a_of_type_Llw;
    }
    finally {}
  }
  
  public static void a()
  {
    llw localllw = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, String.format("onDownloadRequest, mStatusGameplay[%s]", new Object[] { Integer.valueOf(localllw.jdField_a_of_type_Lly.a) }));
    }
    lma.a();
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Llw != null;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Lly = new lly();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Lma = new lma();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Lly.a();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Lly.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     llw
 * JD-Core Version:    0.7.0.1
 */