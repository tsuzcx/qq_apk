import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class luj
  extends aqde
{
  public String a(aqdi paramaqdi)
  {
    paramaqdi = lbh.g() + paramaqdi.b + File.separator;
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketRDHandler", 2, "getUnzipDirPath dir = " + paramaqdi);
    }
    return paramaqdi;
  }
  
  public boolean a(aqdi paramaqdi, boolean paramBoolean)
  {
    long l1 = -1L;
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramaqdi.a)
    {
      long l3 = BaseApplicationImpl.getApplication().getSharedPreferences("avredpacket_sp", 4).getLong(paramaqdi.b, -1L);
      paramaqdi = new File(a(paramaqdi));
      paramBoolean = bool2;
      if (paramaqdi.exists())
      {
        long l2 = paramaqdi.lastModified();
        l1 = l2;
        paramBoolean = bool2;
        if (l3 > 0L)
        {
          l1 = l2;
          paramBoolean = bool2;
          if (l3 != l2)
          {
            paramBoolean = false;
            l1 = l2;
          }
        }
      }
      bool1 = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d("AVRedPacketRDHandler", 2, "verifyUnzipDir result = " + paramBoolean + ",recordedModifyTime = " + l3 + ",realModifyTime = " + l1);
        bool1 = paramBoolean;
      }
    }
    return bool1;
  }
  
  public String b(aqdi paramaqdi)
  {
    paramaqdi = lbh.g() + paramaqdi.b + ".end";
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketRDHandler", 2, "getDownloadPath path[" + paramaqdi + "]");
    }
    return paramaqdi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     luj
 * JD-Core Version:    0.7.0.1
 */