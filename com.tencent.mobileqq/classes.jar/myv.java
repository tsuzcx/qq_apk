import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class myv
  extends apsz
{
  private static String a()
  {
    if (bgjq.a()) {}
    for (String str1 = bhgg.a(anhk.ba);; str1 = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath())
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
      bgmg.a(str);
      QLog.d("AvGameResHandler", 1, "shouldClearStarEffectVideoFiles [delete star video effect files]");
    }
  }
  
  public String a(aptd paramaptd)
  {
    paramaptd = a() + paramaptd.b + File.separator;
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResHandler", 2, "getUnzipDirPath dir = " + paramaptd);
    }
    return paramaptd;
  }
  
  public boolean a(aptd paramaptd, boolean paramBoolean)
  {
    long l1 = -1L;
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramaptd.a)
    {
      long l3 = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4).getLong(paramaptd.b, -1L);
      paramaptd = new File(a(paramaptd));
      paramBoolean = bool2;
      if (paramaptd.exists())
      {
        long l2 = paramaptd.lastModified();
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
  
  public String b(aptd paramaptd)
  {
    if (paramaptd.a) {}
    for (paramaptd = a() + paramaptd.b + ".end";; paramaptd = a(paramaptd.b, paramaptd.c))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameResHandler", 2, "getDownloadPath path[" + paramaptd + "]");
      }
      return paramaptd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     myv
 * JD-Core Version:    0.7.0.1
 */