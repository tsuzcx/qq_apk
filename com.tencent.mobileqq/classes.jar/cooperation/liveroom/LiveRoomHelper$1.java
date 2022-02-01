package cooperation.liveroom;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;

final class LiveRoomHelper$1
  implements Runnable
{
  LiveRoomHelper$1(String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://lme.gamefeeds.qq.com/LmeProxyCgi?data=");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{\"module\":\"LME.ReportChannelSvr.ReportChannelObj\",\"method\":\"SdkPluginReport\",\"param\":{\"req\":{\"report\":");
      localStringBuilder.append(this.val$reportStr);
      localStringBuilder.append("}}}");
      ((StringBuilder)localObject).append(URLEncoder.encode(localStringBuilder.toString()));
      localObject = ((StringBuilder)localObject).toString();
      HttpUtil.openUrl(BaseApplicationImpl.getApplication(), (String)localObject, "GET", null, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("LiveRoomHelper", 1, "LiveRoomPlugin report fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomHelper.1
 * JD-Core Version:    0.7.0.1
 */