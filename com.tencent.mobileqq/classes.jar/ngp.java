import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ngp
  extends aqde
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
  
  public String a(aqdi paramaqdi)
  {
    paramaqdi = a() + paramaqdi.b + File.separator;
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResHandler", 2, "getUnzipDirPath dir = " + paramaqdi);
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
      long l3 = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4).getLong(paramaqdi.b, -1L);
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
        QLog.d("AvGameResHandler", 2, "verifyUnzipDir result = " + paramBoolean + ",recordedModifyTime = " + l3 + ",realModifyTime = " + l1);
        bool1 = paramBoolean;
      }
    }
    return bool1;
  }
  
  public String b(aqdi paramaqdi)
  {
    if (paramaqdi.a) {}
    for (paramaqdi = a() + paramaqdi.b + ".end";; paramaqdi = a(paramaqdi.b, paramaqdi.c))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameResHandler", 2, "getDownloadPath path[" + paramaqdi + "]");
      }
      return paramaqdi;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngp
 * JD-Core Version:    0.7.0.1
 */