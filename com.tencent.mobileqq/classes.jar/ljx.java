import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ljx
  extends aliz
{
  public static String a()
  {
    if (azzu.a()) {
      return ajed.aU + "pddata/prd/" + "av_redpacket";
    }
    return BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/" + "av_redpacket";
  }
  
  public String a(aljd paramaljd)
  {
    paramaljd = a() + File.separator + paramaljd.b + File.separator;
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketRDHandler", 2, "getUnzipDirPath dir = " + paramaljd);
    }
    return paramaljd;
  }
  
  public boolean a(aljd paramaljd, boolean paramBoolean)
  {
    long l1 = -1L;
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramaljd.a)
    {
      long l3 = BaseApplicationImpl.getApplication().getSharedPreferences("avredpacket_sp", 4).getLong(paramaljd.b, -1L);
      paramaljd = new File(a(paramaljd));
      paramBoolean = bool2;
      if (paramaljd.exists())
      {
        long l2 = paramaljd.lastModified();
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
  
  public String b(aljd paramaljd)
  {
    return a() + File.separator + paramaljd.b + ".end";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ljx
 * JD-Core Version:    0.7.0.1
 */