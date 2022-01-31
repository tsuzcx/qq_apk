import com.tencent.av.so.DownloadInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class lzp
{
  private static volatile lzp jdField_a_of_type_Lzp;
  lzr jdField_a_of_type_Lzr = null;
  lzu jdField_a_of_type_Lzu = null;
  
  public static lzp a()
  {
    if (jdField_a_of_type_Lzp == null) {}
    try
    {
      if (jdField_a_of_type_Lzp == null)
      {
        lzp locallzp = new lzp();
        locallzp.b();
        jdField_a_of_type_Lzp = locallzp;
      }
      return jdField_a_of_type_Lzp;
    }
    finally {}
  }
  
  public static void a()
  {
    lzp locallzp = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavSo", 4, String.format("onDownloadRequest, mStatusSo[%s]", new Object[] { Integer.valueOf(locallzp.jdField_a_of_type_Lzu.a) }));
    }
    lzr.a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Lzu = new lzu();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Lzr = new lzr();
    }
  }
  
  public DownloadInfo a()
  {
    return this.jdField_a_of_type_Lzu.a();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Lzu.a();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Lzu.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lzp
 * JD-Core Version:    0.7.0.1
 */