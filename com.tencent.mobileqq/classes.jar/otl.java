import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class otl
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    paramString = osq.a(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      if ((str1.equals("md5")) && (str2 != null))
      {
        opq.a(ors.a(), "sp_key_latest_app_md5", str2.toLowerCase());
      }
      else if (str1.equals("version_name"))
      {
        opq.a(ors.a(), "sp_key_latest_app_version_name", str2);
      }
      else if ((str1.equals("download_url")) && (str2 != null))
      {
        str1 = orq.a(str2);
        opq.a(ors.a(), "sp_key_kb_download_url", str1);
      }
      else if (str1.equals("enable_predownload"))
      {
        opq.a(ors.a(), "sp_key_enable_pre_download", TextUtils.equals("1", str2));
      }
    }
    if (!paramString.containsKey("md5")) {
      opq.a(ors.a(), "sp_key_latest_app_md5", null);
    }
    opq.a();
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    opq.a(ors.a(), "sp_key_latest_app_md5", null);
    opq.a(ors.a(), "sp_key_latest_app_version_name", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     otl
 * JD-Core Version:    0.7.0.1
 */