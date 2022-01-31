import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class lwq
  extends anol
{
  public String a(anop paramanop)
  {
    paramanop = len.g() + paramanop.b + File.separator;
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketRDHandler", 2, "getUnzipDirPath dir = " + paramanop);
    }
    return paramanop;
  }
  
  public boolean a(anop paramanop, boolean paramBoolean)
  {
    long l1 = -1L;
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramanop.a)
    {
      long l3 = BaseApplicationImpl.getApplication().getSharedPreferences("avredpacket_sp", 4).getLong(paramanop.b, -1L);
      paramanop = new File(a(paramanop));
      paramBoolean = bool2;
      if (paramanop.exists())
      {
        long l2 = paramanop.lastModified();
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
  
  public String b(anop paramanop)
  {
    paramanop = len.g() + paramanop.b + ".end";
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketRDHandler", 2, "getDownloadPath path[" + paramanop + "]");
    }
    return paramanop;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lwq
 * JD-Core Version:    0.7.0.1
 */