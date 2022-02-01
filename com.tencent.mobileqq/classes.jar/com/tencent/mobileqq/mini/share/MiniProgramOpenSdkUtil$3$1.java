package com.tencent.mobileqq.mini.share;

import android.os.Bundle;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniProgramOpenSdkUtil$3$1
  implements IMiniCallback
{
  MiniProgramOpenSdkUtil$3$1(MiniProgramOpenSdkUtil.3 param3, JSONObject paramJSONObject, OpenSdkShareModel paramOpenSdkShareModel) {}
  
  public void onCallbackResult(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCmdResult() called with: succ = [");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("], bundle = [");
    ((StringBuilder)localObject).append(paramBundle);
    ((StringBuilder)localObject).append("]");
    QLog.d("MiniProgramOpenSdkUtil", 2, ((StringBuilder)localObject).toString());
    ForwardStatisticsReporter.a("KEY_STAGE_1_UPLOAD_IMAGE", paramBoolean);
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getString("imageUrl", "").replaceFirst("https*://", "");
      MiniProgramOpenSdkUtil.access$200(this.val$arkShareJson, paramBundle);
      localObject = this.val$openSdkShareModel;
      ((OpenSdkShareModel)localObject).imageUrl = paramBundle;
      ((OpenSdkShareModel)localObject).jsonStr = this.val$arkShareJson.toString();
      MiniProgramOpenSdkUtil.access$300(this.this$0.val$context, this.this$0.val$intent, this.this$0.val$finalNotEmptyPicUri, this.val$arkShareJson, this.val$openSdkShareModel);
      return;
    }
    MiniProgramOpenSdkUtil.access$200(this.val$arkShareJson, "");
    paramBundle = this.val$openSdkShareModel;
    paramBundle.imageUrl = "";
    paramBundle.jsonStr = this.val$arkShareJson.toString();
    MiniProgramOpenSdkUtil.access$300(this.this$0.val$context, this.this$0.val$intent, "", this.val$arkShareJson, this.val$openSdkShareModel);
    paramBundle = new StringBuilder();
    paramBundle.append("performUploadArkShareImage failed, NotEmptyPicUri = ");
    paramBundle.append(this.this$0.val$finalNotEmptyPicUri);
    QLog.e("MiniProgramOpenSdkUtil", 1, paramBundle.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil.3.1
 * JD-Core Version:    0.7.0.1
 */