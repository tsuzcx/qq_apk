package com.tencent.mobileqq.mini.share;

import android.os.Bundle;
import auuv;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniProgramOpenSdkUtil$3$1
  extends CmdCallback.Stub
{
  MiniProgramOpenSdkUtil$3$1(MiniProgramOpenSdkUtil.3 param3, JSONObject paramJSONObject, OpenSdkShareModel paramOpenSdkShareModel) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("MiniProgramOpenSdkUtil", 2, "onCmdResult() called with: succ = [" + paramBoolean + "], bundle = [" + paramBundle + "]");
    auuv.a("KEY_STAGE_1_UPLOAD_IMAGE", paramBoolean);
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getString("imageUrl", "").replaceFirst("https*://", "");
      MiniProgramOpenSdkUtil.access$200(this.val$arkShareJson, paramBundle);
      this.val$openSdkShareModel.imageUrl = paramBundle;
      this.val$openSdkShareModel.jsonStr = this.val$arkShareJson.toString();
      MiniProgramOpenSdkUtil.access$300(this.this$0.val$context, this.this$0.val$intent, this.this$0.val$finalNotEmptyPicUri, this.val$arkShareJson, this.val$openSdkShareModel);
      return;
    }
    MiniProgramOpenSdkUtil.access$200(this.val$arkShareJson, "");
    this.val$openSdkShareModel.imageUrl = "";
    this.val$openSdkShareModel.jsonStr = this.val$arkShareJson.toString();
    MiniProgramOpenSdkUtil.access$300(this.this$0.val$context, this.this$0.val$intent, "", this.val$arkShareJson, this.val$openSdkShareModel);
    QLog.e("MiniProgramOpenSdkUtil", 1, "performUploadArkShareImage failed, NotEmptyPicUri = " + this.this$0.val$finalNotEmptyPicUri);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil.3.1
 * JD-Core Version:    0.7.0.1
 */