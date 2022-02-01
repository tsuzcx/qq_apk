package cooperation.groupvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

class GVideoPluginInstallerActivity$1
  extends Handler
{
  GVideoPluginInstallerActivity$1(GVideoPluginInstallerActivity paramGVideoPluginInstallerActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          this.a.finish();
          return;
        }
        GVideoPluginInstallerActivity.access$100(this.a);
        return;
      }
      if (((paramMessage.obj instanceof String)) && (this.a.mTextView != null)) {
        this.a.mTextView.setText((String)paramMessage.obj);
      }
    }
    else
    {
      GVideoPluginInstallerActivity.access$000(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.groupvideo.GVideoPluginInstallerActivity.1
 * JD-Core Version:    0.7.0.1
 */