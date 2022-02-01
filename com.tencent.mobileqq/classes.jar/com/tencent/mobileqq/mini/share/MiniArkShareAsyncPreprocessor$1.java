package com.tencent.mobileqq.mini.share;

import android.os.Bundle;
import apry;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniArkShareAsyncPreprocessor$1
  extends CmdCallback.Stub
{
  MiniArkShareAsyncPreprocessor$1(MiniArkShareAsyncPreprocessor paramMiniArkShareAsyncPreprocessor, JSONObject paramJSONObject, apry paramapry, Object paramObject, String paramString) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    MiniArkShareAsyncPreprocessor.access$000(this.this$0, paramBoolean, paramBundle, this.val$msgJson, this.val$callback, this.val$userData);
    if (paramBoolean) {
      MiniArkShareAsyncManager.removeArkShareLocalImageDatabaseEntity(this.val$finalFilePath);
    }
    QLog.d("MiniArkShareAsyncPrepro [miniappArkShare]", 2, "performChangeArkShareImageUrl succ = [" + paramBoolean + "],SourceUrl:" + this.val$finalFilePath + ", bundle = [" + paramBundle + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniArkShareAsyncPreprocessor.1
 * JD-Core Version:    0.7.0.1
 */