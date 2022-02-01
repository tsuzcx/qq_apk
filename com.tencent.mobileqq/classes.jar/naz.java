import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class naz
  extends apaa
{
  private static String a()
  {
    if (SystemUtil.isExistSDCard()) {}
    for (String str1 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH);; str1 = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath())
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
      FileUtils.deleteDirectory(str);
      QLog.d("AvGameResHandler", 1, "shouldClearStarEffectVideoFiles [delete star video effect files]");
    }
  }
  
  public String a(apae paramapae)
  {
    paramapae = a() + paramapae.b + File.separator;
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResHandler", 2, "getUnzipDirPath dir = " + paramapae);
    }
    return paramapae;
  }
  
  public boolean a(apae paramapae, boolean paramBoolean)
  {
    long l1 = -1L;
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramapae.a)
    {
      long l3 = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4).getLong(paramapae.b, -1L);
      paramapae = new File(a(paramapae));
      paramBoolean = bool2;
      if (paramapae.exists())
      {
        long l2 = paramapae.lastModified();
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
  
  public String b(apae paramapae)
  {
    if (paramapae.a) {}
    for (paramapae = a() + paramapae.b + ".end";; paramapae = a(paramapae.b, paramapae.c))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameResHandler", 2, "getDownloadPath path[" + paramapae + "]");
      }
      return paramapae;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     naz
 * JD-Core Version:    0.7.0.1
 */