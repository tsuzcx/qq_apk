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
    Object localObject1 = "";
    Object localObject2;
    if (paramBoolean)
    {
      try
      {
        localObject1 = (byte[])paramJSONObject.opt("mini_app_info_pb_data");
        paramJSONObject = new INTERFACE.StApiAppInfo();
        try
        {
          paramJSONObject.mergeFrom((byte[])localObject1);
        }
        catch (Throwable localThrowable1) {}
        QLog.e("QZoneShare", 1, "", localThrowable2);
      }
      catch (Throwable localThrowable2)
      {
        paramJSONObject = null;
      }
      if (paramJSONObject != null)
      {
        String str2 = this.val$title;
        String str1 = this.val$description;
        localObject2 = str2;
        if (TextUtils.isEmpty(str2)) {
          localObject2 = paramJSONObject.appName.get();
        }
        if (TextUtils.isEmpty(this.val$description)) {
          str1 = paramJSONObject.desc.get();
        }
        if (QZoneShareActivity.access$300(this.this$0) != null)
        {
          QZoneShareActivity.access$300(this.this$0).mTitle = ((String)localObject2);
          QZoneShareActivity.access$300(this.this$0).mSummary = str1;
          if ((QZoneShareActivity.access$300(this.this$0).mImageUrls != null) && (QZoneShareActivity.access$300(this.this$0).mImageUrls.size() == 0)) {
            QZoneShareActivity.access$300(this.this$0).mImageUrls.add(paramJSONObject.icon.get());
          }
        }
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).shareAsQzoneFeeds(this.val$appid, (String)localObject2, str1, this.val$shareScene, this.val$shareTemplateType, this.val$shareBusinessType, this.val$picUrl, null, this.val$entryPath, paramJSONObject.icon.get(), this.val$versionType, paramJSONObject.versionId.get(), this.val$appRichId, this.val$shareAsQzoneFeedsListener);
        return;
      }
      this.this$0.runOnUiThread(new QZoneShareActivity.5.1(this));
      return;
    }
    long l;
    if (paramJSONObject != null) {
      l = paramJSONObject.optLong("retCode");
    } else {
      l = 0L;
    }
    if (paramJSONObject != null) {
      localObject2 = paramJSONObject.optString("errMsg");
    }
    this.this$0.runOnUiThread(new QZoneShareActivity.5.2(this, (String)localObject2, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.5
 * JD-Core Version:    0.7.0.1
 */