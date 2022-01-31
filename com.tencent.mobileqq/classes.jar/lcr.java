import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.qphone.base.util.QLog;

public class lcr
{
  public static int a(lcj paramlcj)
  {
    if (paramlcj == null) {}
    do
    {
      do
      {
        return 11;
        if (!TextUtils.isEmpty(paramlcj.c)) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("QavGPDownloadManager", 4, String.format("getEnableFlag, %s", new Object[] { paramlcj }));
      return 11;
      if (!paramlcj.a) {
        break;
      }
    } while (!a(paramlcj));
    return 1;
    return 2;
  }
  
  static SharedPreferences a()
  {
    return EffectConfigBase.a(298, EffectConfigBase.d);
  }
  
  public static String a()
  {
    return UpdateAvSo.a();
  }
  
  public static boolean a(lcj paramlcj)
  {
    String str1 = paramlcj.b;
    paramlcj = a() + paramlcj.d + ".so";
    String str2 = a().getString("so_zip_md5", null);
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGPDownloadManager", 4, String.format("isSoReady, sp_md5[%s], xmlMd5[%s]", new Object[] { str2, str1 }));
      }
    }
    do
    {
      return false;
      if (bace.a(paramlcj)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("QavGPDownloadManager", 4, String.format("isSoReady, file no exist,  fileName[%s]", new Object[] { paramlcj }));
    return false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lcr
 * JD-Core Version:    0.7.0.1
 */