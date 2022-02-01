package cooperation.qzone.webviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class QzoneDynamicAlbumPlugin$2
  extends BroadcastReceiver
{
  QzoneDynamicAlbumPlugin$2(QzoneDynamicAlbumPlugin paramQzoneDynamicAlbumPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("QzoneDynamicAlbumPlugin", 2, paramContext);
    }
    paramIntent = paramIntent.getStringExtra("runningProcessName");
    if ((("com.tencent.process.stopping".equals(paramContext)) && (!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("com.tencent.mobileqq:tool"))) || ("tencent.av.v2q.StartVideoChat".equals(paramContext)))
    {
      QzoneDynamicAlbumPlugin.access$102(this.this$0, true);
      this.this$0.onAudioSessionActive();
    }
    while (((!"com.tencent.process.starting".equals(paramContext)) || (TextUtils.isEmpty(paramIntent)) || (!paramIntent.equals("com.tencent.mobileqq:tool")) || (!QzoneDynamicAlbumPlugin.access$200(this.this$0))) && (!"tencent.av.v2q.StopVideoChat".equals(paramContext))) {
      return;
    }
    QzoneDynamicAlbumPlugin.access$102(this.this$0, false);
    this.this$0.onAudioSessionDeactive();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.2
 * JD-Core Version:    0.7.0.1
 */