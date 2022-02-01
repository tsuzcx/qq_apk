package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data;

import android.os.Bundle;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

class DynamicChannelDataModule$6
  implements HttpWebCgiAsyncTask.Callback
{
  DynamicChannelDataModule$6(DynamicChannelDataModule paramDynamicChannelDataModule, int paramInt) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    QLog.d("DynamicChannelDataModule", 2, new Object[] { "onResult result = ", paramJSONObject, ", requestCode = ", Integer.valueOf(paramInt) });
    if (DynamicChannelDataModule.c(this.b)) {
      DynamicChannelDataModule.d(this.b).execute(new DynamicChannelDataModule.6.1(this, paramBundle, paramJSONObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelDataModule.6
 * JD-Core Version:    0.7.0.1
 */