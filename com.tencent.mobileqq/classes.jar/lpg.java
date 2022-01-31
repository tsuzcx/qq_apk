import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.qphone.base.util.QLog;

public class lpg
{
  public static int a(loy paramloy)
  {
    if (paramloy == null) {}
    do
    {
      do
      {
        return 11;
        if (!TextUtils.isEmpty(paramloy.c)) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("QavGPDownloadManager", 4, String.format("getEnableFlag, %s", new Object[] { paramloy }));
      return 11;
      if (!paramloy.a) {
        break;
      }
    } while (!a(paramloy));
    return 1;
    return 2;
  }
  
  static SharedPreferences a()
  {
    return EffectConfigBase.a(298, EffectConfigBase.c);
  }
  
  public static String a()
  {
    return UpdateAvSo.a();
  }
  
  public static boolean a(loy paramloy)
  {
    String str1 = paramloy.b;
    paramloy = a() + paramloy.d + ".so";
    String str2 = a().getString("so_zip_md5", null);
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGPDownloadManager", 4, String.format("isSoReady, sp_md5[%s], xmlMd5[%s]", new Object[] { str2, str1 }));
      }
    }
    do
    {
      return false;
      if (bdhb.a(paramloy)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("QavGPDownloadManager", 4, String.format("isSoReady, file no exist,  fileName[%s]", new Object[] { paramloy }));
    return false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lpg
 * JD-Core Version:    0.7.0.1
 */