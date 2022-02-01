import com.tencent.av.so.DownloadInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class mac
{
  private static volatile mac jdField_a_of_type_Mac;
  mae jdField_a_of_type_Mae = null;
  mah jdField_a_of_type_Mah = null;
  
  public static mac a()
  {
    if (jdField_a_of_type_Mac == null) {}
    try
    {
      if (jdField_a_of_type_Mac == null)
      {
        mac localmac = new mac();
        localmac.b();
        jdField_a_of_type_Mac = localmac;
      }
      return jdField_a_of_type_Mac;
    }
    finally {}
  }
  
  public static void a()
  {
    mac localmac = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavSo", 4, String.format("onDownloadRequest, mStatusSo[%s]", new Object[] { Integer.valueOf(localmac.jdField_a_of_type_Mah.a) }));
    }
    mae.a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Mah = new mah();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Mae = new mae();
    }
  }
  
  public DownloadInfo a()
  {
    return this.jdField_a_of_type_Mah.a();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Mah.a();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Mah.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mac
 * JD-Core Version:    0.7.0.1
 */