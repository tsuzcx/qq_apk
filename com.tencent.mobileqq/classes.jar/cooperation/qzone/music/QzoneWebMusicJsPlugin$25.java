package cooperation.qzone.music;

import android.os.Bundle;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class QzoneWebMusicJsPlugin$25
  implements Runnable
{
  QzoneWebMusicJsPlugin$25(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, Bundle paramBundle) {}
  
  public void run()
  {
    if (QzoneWebMusicJsPlugin.access$500(this.this$0)) {
      for (;;)
      {
        try
        {
          localJSONObject1 = new JSONObject();
          if (this.val$bundle == null) {
            continue;
          }
          SongInfo localSongInfo = (SongInfo)this.val$bundle.getParcelable("param.song");
          if ((localSongInfo == null) || (localSongInfo.b != 9) || (localSongInfo.a == null)) {
            continue;
          }
          i = this.val$bundle.getInt("param.state");
          localJSONObject1.put("code", 0);
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("uin", this.val$bundle.getLong("param.uin"));
          localJSONObject2.put("detailUrl", localSongInfo.a.detailUrl);
          localJSONObject2.put("broadcastID", localSongInfo.a.broadcastID);
          localJSONObject2.put("broadcastName", localSongInfo.a.broadcastName);
          if (i != 2) {
            continue;
          }
          localJSONObject2.put("state", "playing");
        }
        catch (Exception localException)
        {
          JSONObject localJSONObject1;
          int i;
          JSONObject localJSONObject2;
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.e(QzoneWebMusicJsPlugin.access$600(this.this$0), 2, "callNetWorkInterfaceForGetttingLiveInfo error");
          return;
          localJSONObject2.put("state", "paused");
          continue;
          localException.put("code", 1);
          continue;
          QzoneWebMusicJsPlugin.access$700().a(localException);
        }
        localJSONObject1.put("data", localJSONObject2);
        if (QLog.isColorLevel()) {
          QLog.e(QzoneWebMusicJsPlugin.access$600(this.this$0), 2, "callNetWorkInterfaceForGetttingLiveInfo  isDestroy " + this.this$0.isDestroy + "  result " + localJSONObject1.toString());
        }
        if ((this.this$0.isDestroy) || (QzoneWebMusicJsPlugin.access$700() == null)) {
          return;
        }
        if (!QzoneWebMusicJsPlugin.access$700().a) {
          continue;
        }
        this.this$0.callJs4OpenApi(QzoneWebMusicJsPlugin.access$700(), 0, localJSONObject1.toString());
        return;
        if (i != 1) {
          continue;
        }
        localJSONObject2.put("state", "buffering");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.25
 * JD-Core Version:    0.7.0.1
 */