package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

class DynamicChannelDataModule$6$1
  implements Runnable
{
  DynamicChannelDataModule$6$1(DynamicChannelDataModule.6 param6, Bundle paramBundle, JSONObject paramJSONObject) {}
  
  public void run()
  {
    boolean bool;
    if (this.a.getInt("isPullDownRefresh", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = new ArrayList();
    if (this.b != null) {
      localObject = DynamicChannelDataModule.a(this.c.b, this.c.a, this.b, this.a);
    } else {
      QLog.d("DynamicChannelDataModule", 2, "onResult, result is null.");
    }
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      DynamicChannelDataModule.a(this.c.b, bool, this.c.a, false, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelDataModule.6.1
 * JD-Core Version:    0.7.0.1
 */