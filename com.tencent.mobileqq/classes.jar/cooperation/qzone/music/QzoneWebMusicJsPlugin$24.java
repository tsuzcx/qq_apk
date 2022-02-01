package cooperation.qzone.music;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;

class QzoneWebMusicJsPlugin$24
  implements Runnable
{
  QzoneWebMusicJsPlugin$24(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().setPlayMode(this.this$0.mRuntime.a().getLongAccountUin(), this.val$random, this.val$auto, this.val$_loopPlay);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.24
 * JD-Core Version:    0.7.0.1
 */