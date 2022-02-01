package com.tencent.mobileqq.mini.share;

import android.os.Bundle;
import com.tencent.mobileqq.ark.share.IArkMessagePreprocessorCallback;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniArkShareAsyncPreprocessor$2
  implements IMiniCallback
{
  MiniArkShareAsyncPreprocessor$2(MiniArkShareAsyncPreprocessor paramMiniArkShareAsyncPreprocessor, JSONObject paramJSONObject, IArkMessagePreprocessorCallback paramIArkMessagePreprocessorCallback, Object paramObject, String paramString) {}
  
  public void onCallbackResult(boolean paramBoolean, Bundle paramBundle)
  {
    MiniArkShareAsyncPreprocessor.access$000(this.this$0, paramBoolean, paramBundle, this.val$msgJson, this.val$callback, this.val$userData);
    if (paramBoolean) {
      MiniArkShareAsyncManager.removeArkShareLocalImageDatabaseEntity(this.val$finalFilePath);
    }
    QLog.d("MiniArkShareAsyncPrepro [miniappArkShare]", 2, "performUploadArkShareImage succ = [" + paramBoolean + "],SourceUrl:" + this.val$finalFilePath + ", bundle = [" + paramBundle + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniArkShareAsyncPreprocessor.2
 * JD-Core Version:    0.7.0.1
 */