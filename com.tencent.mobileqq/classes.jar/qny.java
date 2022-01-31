import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.wadl.WLog;

public final class qny
  implements Runnable
{
  public qny(String paramString1, String paramString2) {}
  
  public void run()
  {
    int j = 0;
    WLog.b("QQInitHandler", "start checkGameCenter isWiFi=" + AppNetConnInfo.isWifiConn());
    GameCenterUtils.a();
    String[] arrayOfString;
    int k;
    int i;
    if (!TextUtils.isEmpty(this.a))
    {
      if ((GameCenterUtils.a) && (AppNetConnInfo.isWifiConn())) {
        GameCenterUtils.a(this.a);
      }
      arrayOfString = this.a.split("\\|");
      k = arrayOfString.length;
      i = 0;
      while (i < k)
      {
        GameCenterUtils.a(null, "558", "203713", arrayOfString[i], "55801", "4", "430");
        i += 1;
      }
    }
    if (!TextUtils.isEmpty(this.b))
    {
      if ((GameCenterUtils.b) && (GameCenterUtils.a(BaseApplicationImpl.getContext()))) {
        GameCenterUtils.b(this.b);
      }
      arrayOfString = this.b.split("\\|");
      k = arrayOfString.length;
      i = j;
      while (i < k)
      {
        GameCenterUtils.a(null, "558", "203701", arrayOfString[i], "55801", "4", "430");
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qny
 * JD-Core Version:    0.7.0.1
 */