package cooperation.comic;

import android.os.Handler;
import android.os.Message;
import cooperation.comic.utils.QQComicPluginBridge.PluginInstallCallback;
import java.lang.ref.WeakReference;

class VipComicJumpActivity$ComicPluginInstallCallback
  implements QQComicPluginBridge.PluginInstallCallback
{
  private WeakReference<Handler> a;
  
  VipComicJumpActivity$ComicPluginInstallCallback(Handler paramHandler)
  {
    this.a = new WeakReference(paramHandler);
  }
  
  public void a(int paramInt, String paramString)
  {
    Handler localHandler = (Handler)this.a.get();
    if (localHandler != null) {
      localHandler.obtainMessage(1001, paramInt, 0, paramString).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.VipComicJumpActivity.ComicPluginInstallCallback
 * JD-Core Version:    0.7.0.1
 */