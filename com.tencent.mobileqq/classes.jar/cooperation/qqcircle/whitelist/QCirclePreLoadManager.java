package cooperation.qqcircle.whitelist;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.local.requests.QCircleMoonCakeRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;

public class QCirclePreLoadManager
{
  private static final long MIN_NEXT_TIME_INTERVAL = 10000L;
  public static final String SP_KEY_ALLOW_LONG_VIDEO_SWITCH = "sp_key_allow_long_video_switch";
  public static final String SP_KEY_LAST_REQUEST_TIME = "sp_key_last_request_time";
  public static final String SP_KEY_MAX_LIMIT_VIDEO_LENGTH = "sp_key_max_limit_video_length";
  private static final String TAG = "[QcirclePublish]QCirclePreLoadManager";
  private static Object lock = new Object();
  private static QCirclePreLoadManager mInstance;
  
  public static QCirclePreLoadManager getInstance()
  {
    if (mInstance == null) {}
    synchronized (lock)
    {
      if (mInstance == null)
      {
        QLog.e("[QcirclePublish]QCirclePreLoadManager", 1, "getInstance");
        mInstance = new QCirclePreLoadManager();
      }
      return mInstance;
    }
  }
  
  public void requestWhiteList(String paramString)
  {
    QLog.d("[QcirclePublish]QCirclePreLoadManager", 1, new Object[] { "requestWhiteList... app.getLongAccountUin():", paramString });
    if (TextUtils.isEmpty(paramString)) {}
    long l1;
    long l2;
    do
    {
      return;
      l1 = Long.parseLong(paramString);
      l2 = LocalMultiProcConfig.getLong4Uin("sp_key_last_request_time", 0L, l1);
      QLog.d("[QcirclePublish]QCirclePreLoadManager", 1, new Object[] { "requestWhiteList... lastRequestTime:", Long.valueOf(l2), " currentTime:", Long.valueOf(System.currentTimeMillis()) });
    } while (System.currentTimeMillis() - l2 <= 10000L);
    QLog.d("[QcirclePublish]QCirclePreLoadManager", 1, "requestWhiteList... request MoonCakeRequest...");
    VSNetworkHelper.getInstance().sendRequest(new QCircleMoonCakeRequest(), new QCirclePreLoadManager.1(this, l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.whitelist.QCirclePreLoadManager
 * JD-Core Version:    0.7.0.1
 */