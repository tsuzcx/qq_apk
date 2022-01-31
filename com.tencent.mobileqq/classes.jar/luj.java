import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class luj
  extends alxm
{
  public String a(alxq paramalxq)
  {
    paramalxq = lcj.g() + paramalxq.b + File.separator;
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketRDHandler", 2, "getUnzipDirPath dir = " + paramalxq);
    }
    return paramalxq;
  }
  
  public boolean a(alxq paramalxq, boolean paramBoolean)
  {
    long l1 = -1L;
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramalxq.a)
    {
      long l3 = BaseApplicationImpl.getApplication().getSharedPreferences("avredpacket_sp", 4).getLong(paramalxq.b, -1L);
      paramalxq = new File(a(paramalxq));
      paramBoolean = bool2;
      if (paramalxq.exists())
      {
        long l2 = paramalxq.lastModified();
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
  
  public String b(alxq paramalxq)
  {
    paramalxq = lcj.g() + paramalxq.b + ".end";
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketRDHandler", 2, "getDownloadPath path[" + paramalxq + "]");
    }
    return paramalxq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     luj
 * JD-Core Version:    0.7.0.1
 */