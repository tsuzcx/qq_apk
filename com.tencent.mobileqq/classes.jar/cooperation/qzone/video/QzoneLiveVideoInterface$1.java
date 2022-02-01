package cooperation.qzone.video;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;

final class QzoneLiveVideoInterface$1
  implements WebEventListener
{
  QzoneLiveVideoInterface$1(Handler paramHandler) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ("cmd.uploadCommentVideo".equals(paramString))
    {
      paramString = new Message();
      paramString.obj = paramBundle;
      this.val$handler.sendMessage(paramString);
      if ((paramBundle.getBundle("data") != null) && (paramBundle.getBundle("data").getInt("status") != 2)) {
        RemoteHandleManager.getInstance().removeWebEventListener(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.video.QzoneLiveVideoInterface.1
 * JD-Core Version:    0.7.0.1
 */