package cooperation.qzone.music;

import android.os.Bundle;
import com.tencent.mobileqq.music.BroadcastMusicInfo;
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
    if (QzoneWebMusicJsPlugin.access$500(this.this$0)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject1;
      Object localObject2;
      if (this.val$bundle != null)
      {
        localObject1 = (SongInfo)this.val$bundle.getParcelable("param.song");
        if ((localObject1 != null) && (((SongInfo)localObject1).b == 9) && (((SongInfo)localObject1).a != null))
        {
          int i = this.val$bundle.getInt("param.state");
          localJSONObject.put("code", 0);
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("uin", this.val$bundle.getLong("param.uin"));
          ((JSONObject)localObject2).put("detailUrl", ((SongInfo)localObject1).a.c);
          ((JSONObject)localObject2).put("broadcastID", ((SongInfo)localObject1).a.a);
          ((JSONObject)localObject2).put("broadcastName", ((SongInfo)localObject1).a.b);
          if (i == 2) {
            ((JSONObject)localObject2).put("state", "playing");
          } else if (i == 1) {
            ((JSONObject)localObject2).put("state", "buffering");
          } else {
            ((JSONObject)localObject2).put("state", "paused");
          }
          localJSONObject.put("data", localObject2);
        }
        else
        {
          localJSONObject.put("code", 1);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = QzoneWebMusicJsPlugin.access$600(this.this$0);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("callNetWorkInterfaceForGetttingLiveInfo  isDestroy ");
        ((StringBuilder)localObject2).append(this.this$0.isDestroy);
        ((StringBuilder)localObject2).append("  result ");
        ((StringBuilder)localObject2).append(localJSONObject.toString());
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      if ((this.this$0.isDestroy) || (QzoneWebMusicJsPlugin.access$700() == null)) {
        break label353;
      }
      if (QzoneWebMusicJsPlugin.access$700().a)
      {
        this.this$0.callJs4OpenApi(QzoneWebMusicJsPlugin.access$700(), 0, localJSONObject.toString());
        return;
      }
      QzoneWebMusicJsPlugin.access$700().a(localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      label334:
      label353:
      break label334;
    }
    if (QLog.isColorLevel()) {
      QLog.e(QzoneWebMusicJsPlugin.access$600(this.this$0), 2, "callNetWorkInterfaceForGetttingLiveInfo error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.25
 * JD-Core Version:    0.7.0.1
 */