package cooperation.qzone;

import android.content.Context;
import bize;
import common.config.service.QzoneConfig;

public class PlatformInfor$1
  implements Runnable
{
  public PlatformInfor$1(bize parambize, Context paramContext) {}
  
  public void run()
  {
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneSharppGate", 1) == 1)
    {
      bize.a(this.this$0, SharpPDec.a(this.a));
      return;
    }
    bize.a(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.PlatformInfor.1
 * JD-Core Version:    0.7.0.1
 */