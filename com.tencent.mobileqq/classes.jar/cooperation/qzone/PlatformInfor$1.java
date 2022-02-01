package cooperation.qzone;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzoneMixApi;
import common.config.service.QzoneConfig;

class PlatformInfor$1
  implements Runnable
{
  PlatformInfor$1(PlatformInfor paramPlatformInfor, Context paramContext) {}
  
  public void run()
  {
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneSharppGate", 1) == 1)
    {
      PlatformInfor.access$002(this.this$0, ((IQzoneMixApi)QRoute.api(IQzoneMixApi.class)).isSupportSharpP(this.val$context));
      return;
    }
    PlatformInfor.access$002(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.PlatformInfor.1
 * JD-Core Version:    0.7.0.1
 */