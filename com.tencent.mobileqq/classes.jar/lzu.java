import com.tencent.av.so.DownloadInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class lzu
{
  private static volatile lzu jdField_a_of_type_Lzu;
  lzw jdField_a_of_type_Lzw = null;
  lzz jdField_a_of_type_Lzz = null;
  
  public static lzu a()
  {
    if (jdField_a_of_type_Lzu == null) {}
    try
    {
      if (jdField_a_of_type_Lzu == null)
      {
        lzu locallzu = new lzu();
        locallzu.b();
        jdField_a_of_type_Lzu = locallzu;
      }
      return jdField_a_of_type_Lzu;
    }
    finally {}
  }
  
  public static void a()
  {
    lzu locallzu = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavSo", 4, String.format("onDownloadRequest, mStatusSo[%s]", new Object[] { Integer.valueOf(locallzu.jdField_a_of_type_Lzz.a) }));
    }
    lzw.a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Lzz = new lzz();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Lzw = new lzw();
    }
  }
  
  public DownloadInfo a()
  {
    return this.jdField_a_of_type_Lzz.a();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Lzz.a();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Lzz.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lzu
 * JD-Core Version:    0.7.0.1
 */