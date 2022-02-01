package com.tencent.mobileqq.kandian.biz.account.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ReadInJoyUploadAvatarFragment$3$1
  implements HttpWebCgiAsyncTask.Callback
{
  ReadInJoyUploadAvatarFragment$3$1(ReadInJoyUploadAvatarFragment.3 param3) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyUploadAvatarFragment.a, 2, "uploadImage->onResult");
    }
    if (paramJSONObject != null)
    {
      paramInt = paramJSONObject.optInt("retcode");
      if (paramJSONObject.optJSONObject("result") != null) {
        paramJSONObject = paramJSONObject.optJSONObject("result").optString("url");
      } else {
        paramJSONObject = null;
      }
      paramBundle = new Message();
      if ((paramInt == 0) && (!TextUtils.isEmpty(paramJSONObject)))
      {
        paramBundle.what = 1003;
        paramBundle.obj = paramJSONObject;
      }
      this.a.a.sendMessage(paramBundle);
      return;
    }
    this.a.a.sendMessage(new Message());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.activity.ReadInJoyUploadAvatarFragment.3.1
 * JD-Core Version:    0.7.0.1
 */