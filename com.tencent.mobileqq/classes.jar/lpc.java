import com.tencent.av.so.DownloadInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class lpc
{
  private static volatile lpc jdField_a_of_type_Lpc;
  lpe jdField_a_of_type_Lpe = null;
  lph jdField_a_of_type_Lph = null;
  
  public static lpc a()
  {
    if (jdField_a_of_type_Lpc == null) {}
    try
    {
      if (jdField_a_of_type_Lpc == null)
      {
        lpc locallpc = new lpc();
        locallpc.b();
        jdField_a_of_type_Lpc = locallpc;
      }
      return jdField_a_of_type_Lpc;
    }
    finally {}
  }
  
  public static void a()
  {
    lpc locallpc = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavSo", 4, String.format("onDownloadRequest, mStatusSo[%s]", new Object[] { Integer.valueOf(locallpc.jdField_a_of_type_Lph.a) }));
    }
    lpe.a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Lph = new lph();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Lpe = new lpe();
    }
  }
  
  public DownloadInfo a()
  {
    return this.jdField_a_of_type_Lph.a();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Lph.a();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Lph.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpc
 * JD-Core Version:    0.7.0.1
 */