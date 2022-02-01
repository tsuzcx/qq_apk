package cooperation.ilive;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.qphone.base.util.QLog;

@Keep
public class IliveHostProxy
{
  public static final String TAG = "IliveHostProxy";
  
  public static void initVideoPlayer() {}
  
  public static boolean isVideoPlayerReady()
  {
    QLog.e("IliveHostProxy", 1, "host isVideoPlayerReady");
    return QQVideoPlaySDKManager.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.IliveHostProxy
 * JD-Core Version:    0.7.0.1
 */