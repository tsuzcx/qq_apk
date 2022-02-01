package cooperation.qzone.share;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import cooperation.qzone.QZoneShareData;
import eipc.EIPCClient;
import java.util.Map;
import org.json.JSONObject;

class QZoneShareActivity$4
  implements MiniAppCmdInterface
{
  QZoneShareActivity$4(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      String str = paramJSONObject.optString("jump_url");
      QZoneShareActivity.access$202(this.this$0, paramJSONObject.optBoolean("needShareCallBack"));
      if ((QZoneShareActivity.access$300(this.this$0) != null) && (QZoneShareActivity.access$300(this.this$0).xcxMapEx != null)) {
        QZoneShareActivity.access$300(this.this$0).xcxMapEx.put("xcxFakeLink", str);
      }
      if (!QZoneShareActivity.access$200(this.this$0)) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
      }
      QZoneShareActivity.access$400(this.this$0);
      this.this$0.runOnUiThread(new QZoneShareActivity.4.1(this));
      return;
    }
    long l = -1L;
    if (paramJSONObject != null)
    {
      QZoneShareActivity.access$202(this.this$0, paramJSONObject.optBoolean("needShareCallBack"));
      l = paramJSONObject.optLong("retCode");
    }
    for (paramJSONObject = paramJSONObject.optString("errMsg");; paramJSONObject = null)
    {
      if (!QZoneShareActivity.access$200(this.this$0)) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
      }
      this.this$0.runOnUiThread(new QZoneShareActivity.4.2(this, l, paramJSONObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.4
 * JD-Core Version:    0.7.0.1
 */