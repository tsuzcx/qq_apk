package cooperation.qzone.share;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
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
      label244:
      for (;;)
      {
        try
        {
          Object localObject = (byte[])paramJSONObject.opt("mini_app_info_pb_data");
          paramJSONObject = new INTERFACE.StApiAppInfo();
          String str;
          QLog.e("QZoneShare", 1, "", localThrowable1);
        }
        catch (Throwable localThrowable1)
        {
          try
          {
            paramJSONObject.mergeFrom((byte[])localObject);
            if (paramJSONObject == null) {
              break;
            }
            localObject = this.val$title;
            str = this.val$description;
            if (TextUtils.isEmpty(this.val$title)) {
              localObject = paramJSONObject.appName.get();
            }
            if (TextUtils.isEmpty(this.val$description)) {
              str = paramJSONObject.desc.get();
            }
            if (QZoneShareActivity.access$300(this.this$0) != null)
            {
              QZoneShareActivity.access$300(this.this$0).mTitle = ((String)localObject);
              QZoneShareActivity.access$300(this.this$0).mSummary = str;
              if ((QZoneShareActivity.access$300(this.this$0).mImageUrls != null) && (QZoneShareActivity.access$300(this.this$0).mImageUrls.size() == 0)) {
                QZoneShareActivity.access$300(this.this$0).mImageUrls.add(paramJSONObject.icon.get());
              }
            }
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).shareAsQzoneFeeds(this.val$appid, (String)localObject, str, this.val$shareScene, this.val$shareTemplateType, this.val$shareBusinessType, this.val$picUrl, null, this.val$entryPath, paramJSONObject.icon.get(), this.val$versionType, paramJSONObject.versionId.get(), this.val$appRichId, this.val$shareAsQzoneFeedsListener);
            return;
          }
          catch (Throwable localThrowable2)
          {
            long l;
            break label244;
          }
          localThrowable1 = localThrowable1;
          paramJSONObject = null;
        }
      }
      this.this$0.runOnUiThread(new QZoneShareActivity.5.1(this));
      return;
    }
    if (paramJSONObject != null)
    {
      l = paramJSONObject.optLong("retCode");
      if (paramJSONObject == null) {
        break label318;
      }
    }
    label318:
    for (paramJSONObject = paramJSONObject.optString("errMsg");; paramJSONObject = "")
    {
      this.this$0.runOnUiThread(new QZoneShareActivity.5.2(this, paramJSONObject, l));
      return;
      l = 0L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.5
 * JD-Core Version:    0.7.0.1
 */