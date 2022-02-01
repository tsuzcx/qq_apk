package cooperation.qzone;

import android.content.Context;
import bmsv;
import common.config.service.QzoneConfig;

public class PlatformInfor$1
  implements Runnable
{
  public PlatformInfor$1(bmsv parambmsv, Context paramContext) {}
  
  public void run()
  {
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneSharppGate", 1) == 1)
    {
      bmsv.a(this.this$0, SharpPDec.a(this.a));
      return;
    }
    bmsv.a(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.PlatformInfor.1
 * JD-Core Version:    0.7.0.1
 */