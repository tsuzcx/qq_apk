package cooperation.qzone.share;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import cooperation.qzone.QZoneShareData;
import java.util.ArrayList;
import org.json.JSONObject;

class QZoneShareActivity$5
  implements MiniAppCmdInterface
{
  QZoneShareActivity$5(QZoneShareActivity paramQZoneShareActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, int paramInt4, String paramString6, MiniAppCmdInterface paramMiniAppCmdInterface) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (localMiniAppInfo != null)
      {
        paramJSONObject = this.val$title;
        String str = this.val$description;
        if (TextUtils.isEmpty(this.val$title)) {
          paramJSONObject = localMiniAppInfo.name;
        }
        if (TextUtils.isEmpty(this.val$description)) {
          str = localMiniAppInfo.desc;
        }
        if (QZoneShareActivity.access$300(this.this$0) != null)
        {
          QZoneShareActivity.access$300(this.this$0).mTitle = paramJSONObject;
          QZoneShareActivity.access$300(this.this$0).mSummary = str;
          if ((QZoneShareActivity.access$300(this.this$0).mImageUrls != null) && (QZoneShareActivity.access$300(this.this$0).mImageUrls.size() == 0)) {
            QZoneShareActivity.access$300(this.this$0).mImageUrls.add(localMiniAppInfo.iconUrl);
          }
        }
        MiniProgramShareUtils.shareAsQzoneFeeds(this.val$appid, paramJSONObject, str, this.val$shareScene, this.val$shareTemplateType, this.val$shareBusinessType, this.val$picUrl, null, this.val$entryPath, localMiniAppInfo.iconUrl, this.val$versionType, localMiniAppInfo.versionId, this.val$appRichId, this.val$shareAsQzoneFeedsListener);
        return;
      }
      this.this$0.runOnUiThread(new QZoneShareActivity.5.1(this));
      return;
    }
    long l;
    if (paramJSONObject != null)
    {
      l = paramJSONObject.optLong("retCode");
      if (paramJSONObject == null) {
        break label260;
      }
    }
    label260:
    for (paramJSONObject = paramJSONObject.optString("errMsg");; paramJSONObject = "")
    {
      this.this$0.runOnUiThread(new QZoneShareActivity.5.2(this, paramJSONObject, l));
      return;
      l = 0L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.5
 * JD-Core Version:    0.7.0.1
 */