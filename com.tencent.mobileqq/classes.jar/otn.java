import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.lang.ref.WeakReference;

public class otn
  implements Runnable
{
  private WeakReference a;
  
  public otn(TribeVideoPlugin paramTribeVideoPlugin)
  {
    this.a = new WeakReference(paramTribeVideoPlugin);
  }
  
  public void run()
  {
    TribeVideoPlugin localTribeVideoPlugin = (TribeVideoPlugin)this.a.get();
    if (localTribeVideoPlugin == null) {
      return;
    }
    TVK_SDKMgr.installPlugin(localTribeVideoPlugin.mRuntime.a().getApplication(), new oto(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     otn
 * JD-Core Version:    0.7.0.1
 */