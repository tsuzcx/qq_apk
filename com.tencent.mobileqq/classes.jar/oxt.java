import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.InetAddress;
import java.net.URL;

public final class oxt
  implements Runnable
{
  public oxt(String paramString) {}
  
  public void run()
  {
    try
    {
      URL localURL = new URL(this.a);
      String str = InetAddress.getByName(localURL.getHost()).getHostAddress();
      if (!TextUtils.isEmpty(str)) {
        BaseApplicationImpl.getContext().getSharedPreferences("qbiz_host_ip_map", 0).edit().putString(localURL.getHost(), str).commit();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxt
 * JD-Core Version:    0.7.0.1
 */