import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class mgw
{
  public static String a()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ImageUtil", 2, "[image download] getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/qav/image_download/";
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ImageUtil", 2, "[image early] trigger early download");
    }
    paramQQAppInterface = (amyp)paramQQAppInterface.getManager(77);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (amzn)paramQQAppInterface.a("qq.android.qav.image2");
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(false);
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    return new File(b(), paramString).exists();
  }
  
  public static String b()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ImageUtil", 2, "[image early] getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/qav/image_early/";
  }
  
  public static String c()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ImageUtil", 2, "[video early] getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/qav/video_early/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mgw
 * JD-Core Version:    0.7.0.1
 */