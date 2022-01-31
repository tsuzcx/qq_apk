import com.tencent.av.so.DownloadInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class mce
{
  private static volatile mce jdField_a_of_type_Mce;
  mcg jdField_a_of_type_Mcg = null;
  mcj jdField_a_of_type_Mcj = null;
  
  public static mce a()
  {
    if (jdField_a_of_type_Mce == null) {}
    try
    {
      if (jdField_a_of_type_Mce == null)
      {
        mce localmce = new mce();
        localmce.b();
        jdField_a_of_type_Mce = localmce;
      }
      return jdField_a_of_type_Mce;
    }
    finally {}
  }
  
  public static void a()
  {
    mce localmce = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavSo", 4, String.format("onDownloadRequest, mStatusSo[%s]", new Object[] { Integer.valueOf(localmce.jdField_a_of_type_Mcj.a) }));
    }
    mcg.a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Mcj = new mcj();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Mcg = new mcg();
    }
  }
  
  public DownloadInfo a()
  {
    return this.jdField_a_of_type_Mcj.a();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Mcj.a();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Mcj.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mce
 * JD-Core Version:    0.7.0.1
 */