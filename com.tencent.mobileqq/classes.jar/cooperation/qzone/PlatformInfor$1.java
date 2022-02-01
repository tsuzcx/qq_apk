package cooperation.qzone;

import android.content.Context;
import blrt;
import common.config.service.QzoneConfig;

public class PlatformInfor$1
  implements Runnable
{
  public PlatformInfor$1(blrt paramblrt, Context paramContext) {}
  
  public void run()
  {
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneSharppGate", 1) == 1)
    {
      blrt.a(this.this$0, SharpPDec.a(this.a));
      return;
    }
    blrt.a(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.PlatformInfor.1
 * JD-Core Version:    0.7.0.1
 */