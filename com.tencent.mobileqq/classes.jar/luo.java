import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class luo
  extends aqgp
{
  public String a(aqgt paramaqgt)
  {
    paramaqgt = lbm.g() + paramaqgt.b + File.separator;
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketRDHandler", 2, "getUnzipDirPath dir = " + paramaqgt);
    }
    return paramaqgt;
  }
  
  public boolean a(aqgt paramaqgt, boolean paramBoolean)
  {
    long l1 = -1L;
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramaqgt.a)
    {
      long l3 = BaseApplicationImpl.getApplication().getSharedPreferences("avredpacket_sp", 4).getLong(paramaqgt.b, -1L);
      paramaqgt = new File(a(paramaqgt));
      paramBoolean = bool2;
      if (paramaqgt.exists())
      {
        long l2 = paramaqgt.lastModified();
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
  
  public String b(aqgt paramaqgt)
  {
    paramaqgt = lbm.g() + paramaqgt.b + ".end";
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketRDHandler", 2, "getDownloadPath path[" + paramaqgt + "]");
    }
    return paramaqgt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     luo
 * JD-Core Version:    0.7.0.1
 */