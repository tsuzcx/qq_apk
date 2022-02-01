import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class lmw
{
  public static int a(lmo paramlmo)
  {
    if (paramlmo == null) {}
    do
    {
      do
      {
        return 11;
        if (!TextUtils.isEmpty(paramlmo.c)) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("QavGPDownloadManager", 4, String.format("getEnableFlag, %s", new Object[] { paramlmo }));
      return 11;
      if (!paramlmo.a) {
        break;
      }
    } while (!a(paramlmo));
    return 1;
    return 2;
  }
  
  static SharedPreferences a()
  {
    return EffectConfigBase.a(298, EffectConfigBase.c);
  }
  
  public static String a()
  {
    return AVSoUtils.b();
  }
  
  public static boolean a(lmo paramlmo)
  {
    String str1 = paramlmo.b;
    paramlmo = a() + paramlmo.d + ".so";
    String str2 = a().getString("so_zip_md5", null);
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGPDownloadManager", 4, String.format("isSoReady, sp_md5[%s], xmlMd5[%s]", new Object[] { str2, str1 }));
      }
    }
    do
    {
      return false;
      if (FileUtils.fileExists(paramlmo)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("QavGPDownloadManager", 4, String.format("isSoReady, file no exist,  fileName[%s]", new Object[] { paramlmo }));
    return false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lmw
 * JD-Core Version:    0.7.0.1
 */