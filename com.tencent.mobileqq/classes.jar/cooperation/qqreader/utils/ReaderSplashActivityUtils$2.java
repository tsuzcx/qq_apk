package cooperation.qqreader.utils;

import android.content.Intent;
import bbmy;
import bflh;
import bfne;
import bfng;
import cooperation.qqreader.QRBridgeUtil;

public class ReaderSplashActivityUtils$2
  implements Runnable
{
  public ReaderSplashActivityUtils$2(bfng parambfng, Intent paramIntent) {}
  
  public void run()
  {
    if (QRBridgeUtil.isPluginReady())
    {
      bfne.d("ReaderSplashActivityUti", "[checkJumpToPlugin] delay check ready");
      bflh.a(bfng.a(this.this$0), this.a, "com.qqreader.pureader.SSReaderActivity");
      return;
    }
    bfne.a("ReaderSplashActivityUti", "[checkJumpToPlugin] delay check error");
    bbmy.a(bfng.a(this.this$0), 1, "跳转失败，请重试！", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.utils.ReaderSplashActivityUtils.2
 * JD-Core Version:    0.7.0.1
 */