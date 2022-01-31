package dov.com.tencent.mobileqq.shortvideo.gesture;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class GestureUtil
{
  public static int a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {}
    label132:
    label135:
    for (;;)
    {
      return 11;
      if (TextUtils.isEmpty(paramDownloadInfo.e))
      {
        if (QLog.isDevelopLevel())
        {
          QLog.d("QavGesture", 4, String.format("getEnableFlag, %s", new Object[] { paramDownloadInfo }));
          return 11;
        }
      }
      else
      {
        int i;
        int j;
        if (paramDownloadInfo.a) {
          if ((!c(paramDownloadInfo)) || (!b(paramDownloadInfo)))
          {
            i = 11;
            if (!paramDownloadInfo.jdField_b_of_type_Boolean) {
              break label132;
            }
            if ((c(paramDownloadInfo)) && (a(paramDownloadInfo))) {
              break label127;
            }
            j = 11;
          }
        }
        for (;;)
        {
          if ((j == 11) || (i == 11)) {
            break label135;
          }
          if ((j != 2) || (i != 2)) {
            break label137;
          }
          return 2;
          i = 1;
          break;
          i = 2;
          break;
          label127:
          j = 1;
          continue;
          j = 2;
        }
      }
    }
    label137:
    return 1;
  }
  
  static SharedPreferences a()
  {
    return BaseApplication.getContext().getSharedPreferences("config_qq.android.qavgesture", 4);
  }
  
  public static String a()
  {
    return UpdateAvSo.a() + "model" + File.separator;
  }
  
  public static boolean a(DownloadInfo paramDownloadInfo)
  {
    String str1 = paramDownloadInfo.j;
    paramDownloadInfo = c() + paramDownloadInfo.k;
    String str2 = a().getString("gamemodel_zip_md5", null);
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGesture", 4, String.format("isGameModelReady, sp_md5[%s], xmlMd5[%s]", new Object[] { str2, str1 }));
      }
    }
    do
    {
      return false;
      if (FileUtils.a(paramDownloadInfo)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("QavGesture", 4, String.format("isGameModelReady, file no exist,  fileName[%s]", new Object[] { paramDownloadInfo }));
    return false;
    return true;
  }
  
  public static String b()
  {
    return UpdateAvSo.a();
  }
  
  public static boolean b(DownloadInfo paramDownloadInfo)
  {
    String str1 = paramDownloadInfo.d;
    paramDownloadInfo = a() + paramDownloadInfo.h;
    String str2 = a().getString("model_zip_md5", null);
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGesture", 4, String.format("isModelReady, sp_md5[%s], xmlMd5[%s]", new Object[] { str2, str1 }));
      }
    }
    do
    {
      return false;
      if (FileUtils.a(paramDownloadInfo)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("QavGesture", 4, String.format("isModelReady, file no exist,  fileName[%s]", new Object[] { paramDownloadInfo }));
    return false;
    return true;
  }
  
  public static String c()
  {
    return UpdateAvSo.a() + "gamemodel" + File.separator;
  }
  
  public static boolean c(DownloadInfo paramDownloadInfo)
  {
    String str1 = paramDownloadInfo.jdField_b_of_type_JavaLangString;
    paramDownloadInfo = b() + paramDownloadInfo.f;
    String str2 = a().getString("so_zip_md5", null);
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGesture", 4, String.format("isSoReady, sp_md5[%s], xmlMd5[%s]", new Object[] { str2, str1 }));
      }
    }
    do
    {
      return false;
      if (FileUtils.a(paramDownloadInfo)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("QavGesture", 4, String.format("isSoReady, file no exist,  fileName[%s]", new Object[] { paramDownloadInfo }));
    return false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.gesture.GestureUtil
 * JD-Core Version:    0.7.0.1
 */