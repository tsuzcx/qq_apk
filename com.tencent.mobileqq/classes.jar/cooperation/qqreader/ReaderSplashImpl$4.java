package cooperation.qqreader;

import android.widget.TextView;
import cooperation.plugin.IPluginManager.OnOpenPluginListener;
import cooperation.qqreader.utils.Log;

class ReaderSplashImpl$4
  implements IPluginManager.OnOpenPluginListener
{
  ReaderSplashImpl$4(ReaderSplashImpl paramReaderSplashImpl) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Log.a("ReaderSplashImpl", "jumpToPlugin: openPlugin: failed");
      if (ReaderSplashImpl.a(this.a) != null) {
        ReaderSplashImpl.a(this.a).setText("跳转失败，请返回重试");
      }
      return;
    }
    Log.d("ReaderSplashImpl", "jumpToPlugin: openPlugin: succeed");
    ReaderSplashImpl.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.ReaderSplashImpl.4
 * JD-Core Version:    0.7.0.1
 */