import com.tencent.av.so.DownloadInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class lzg
{
  private static volatile lzg jdField_a_of_type_Lzg;
  lzi jdField_a_of_type_Lzi = null;
  lzl jdField_a_of_type_Lzl = null;
  
  public static lzg a()
  {
    if (jdField_a_of_type_Lzg == null) {}
    try
    {
      if (jdField_a_of_type_Lzg == null)
      {
        lzg locallzg = new lzg();
        locallzg.b();
        jdField_a_of_type_Lzg = locallzg;
      }
      return jdField_a_of_type_Lzg;
    }
    finally {}
  }
  
  public static void a()
  {
    lzg locallzg = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavSo", 4, String.format("onDownloadRequest, mStatusSo[%s]", new Object[] { Integer.valueOf(locallzg.jdField_a_of_type_Lzl.a) }));
    }
    lzi.a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Lzl = new lzl();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Lzi = new lzi();
    }
  }
  
  public DownloadInfo a()
  {
    return this.jdField_a_of_type_Lzl.a();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Lzl.a();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Lzl.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lzg
 * JD-Core Version:    0.7.0.1
 */