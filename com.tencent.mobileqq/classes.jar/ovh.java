import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.lang.ref.WeakReference;

public class ovh
  implements Runnable
{
  private WeakReference a;
  
  public ovh(TribeVideoPlugin paramTribeVideoPlugin)
  {
    this.a = new WeakReference(paramTribeVideoPlugin);
  }
  
  public void run()
  {
    TribeVideoPlugin localTribeVideoPlugin = (TribeVideoPlugin)this.a.get();
    if (localTribeVideoPlugin == null) {
      return;
    }
    TVK_SDKMgr.installPlugin(localTribeVideoPlugin.mRuntime.a().getApplication(), new ovi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovh
 * JD-Core Version:    0.7.0.1
 */