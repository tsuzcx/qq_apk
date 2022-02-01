import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class mzy
  extends aqgp
{
  private static String a()
  {
    if (bhjr.a()) {}
    for (String str1 = bigv.a(antf.ba);; str1 = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath())
    {
      String str2 = str1;
      if (str1 != null)
      {
        str2 = str1;
        if (!str1.endsWith(File.separator)) {
          str2 = str1 + File.separator;
        }
      }
      return str2 + "avgame/res" + File.separator;
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a() + "star/" + paramString1 + paramString2;
  }
  
  public static void a()
  {
    String str = a() + "star/";
    File localFile = new File(str);
    if ((localFile.exists()) && (localFile.listFiles() != null) && (localFile.listFiles().length >= 100))
    {
      bhmi.a(str);
      QLog.d("AvGameResHandler", 1, "shouldClearStarEffectVideoFiles [delete star video effect files]");
    }
  }
  
  public String a(aqgt paramaqgt)
  {
    paramaqgt = a() + paramaqgt.b + File.separator;
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResHandler", 2, "getUnzipDirPath dir = " + paramaqgt);
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
      long l3 = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4).getLong(paramaqgt.b, -1L);
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
        QLog.d("AvGameResHandler", 2, "verifyUnzipDir result = " + paramBoolean + ",recordedModifyTime = " + l3 + ",realModifyTime = " + l1);
        bool1 = paramBoolean;
      }
    }
    return bool1;
  }
  
  public String b(aqgt paramaqgt)
  {
    if (paramaqgt.a) {}
    for (paramaqgt = a() + paramaqgt.b + ".end";; paramaqgt = a(paramaqgt.b, paramaqgt.c))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameResHandler", 2, "getDownloadPath path[" + paramaqgt + "]");
      }
      return paramaqgt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mzy
 * JD-Core Version:    0.7.0.1
 */