package com.tencent.mobileqq.mini.share;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.webkit.URLUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

final class MiniProgramOpenSdkUtil$3
  implements MiniAppCmdInterface
{
  MiniProgramOpenSdkUtil$3(Runnable paramRunnable1, Runnable paramRunnable2, MiniProgramOpenSdkUtil.TimeOutInfo paramTimeOutInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, Context paramContext, Intent paramIntent, String paramString9) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    ForwardStatisticsReporter.b("KEY_STAGE_1_GET_SHARE_INFO");
    int j = 0;
    QLog.d("MiniProgramOpenSdkUtil", 1, new Object[] { "arkShareJson:", paramJSONObject.toString() });
    ThreadManager.getUIHandler().removeCallbacks(this.val$timeoutRunnable);
    ThreadManager.getUIHandler().removeCallbacks(this.val$showLoadingRunnable);
    if ((this.val$outInfo.progressDialog != null) && (this.val$outInfo.progressDialog.isShowing())) {
      this.val$outInfo.progressDialog.dismiss();
    }
    if (this.val$outInfo.isTimeout)
    {
      QLog.e("MiniProgramOpenSdkUtil", 1, "forwardShare failed timeout");
      return;
    }
    if (paramBoolean)
    {
      localObject = new OpenSdkShareModel();
      ((OpenSdkShareModel)localObject).miniAppAppid = this.val$miniProgramAppid;
      ((OpenSdkShareModel)localObject).miniAppPath = this.val$miniProgramPath;
      ((OpenSdkShareModel)localObject).miniAppType = this.val$miniProgramType;
      ((OpenSdkShareModel)localObject).webPageUrl = this.val$url;
      ((OpenSdkShareModel)localObject).appRichId = this.val$appRichId;
      ((OpenSdkShareModel)localObject).title = this.val$title;
      ((OpenSdkShareModel)localObject).desc = this.val$desc;
      int i = j;
      if (!URLUtil.isHttpUrl(this.val$finalNotEmptyPicUri))
      {
        i = j;
        if (!URLUtil.isHttpsUrl(this.val$finalNotEmptyPicUri)) {
          i = 1;
        }
      }
      if (i != 0)
      {
        ForwardStatisticsReporter.a("KEY_STAGE_1_UPLOAD_IMAGE");
        MiniArkShareAsyncManager.performUploadArkShareImage(this.val$finalNotEmptyPicUri, new MiniProgramOpenSdkUtil.3.1(this, paramJSONObject, (OpenSdkShareModel)localObject));
        return;
      }
      MiniProgramOpenSdkUtil.access$400(paramJSONObject);
      ((OpenSdkShareModel)localObject).imageUrl = this.val$previewPicUrl;
      ((OpenSdkShareModel)localObject).jsonStr = paramJSONObject.toString();
      MiniProgramOpenSdkUtil.access$300(this.val$context, this.val$intent, this.val$finalNotEmptyPicUri, paramJSONObject, (OpenSdkShareModel)localObject);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getShareInfo - failed,  miniProgramJson: ");
    ((StringBuilder)localObject).append(paramJSONObject);
    QLog.e("MiniProgramOpenSdkUtil", 1, ((StringBuilder)localObject).toString());
    paramJSONObject = paramJSONObject.optString("errMsg");
    ThreadManagerV2.getUIHandlerV2().post(new MiniProgramOpenSdkUtil.3.2(this, paramJSONObject));
    MiniProgramOpenSdkUtil.access$100(this.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil.3
 * JD-Core Version:    0.7.0.1
 */