package com.tencent.viola.core;

import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.HashMap;

class ViolaReportManager$1
  implements Runnable
{
  ViolaReportManager$1(ViolaReportManager paramViolaReportManager, HashMap paramHashMap, String paramString) {}
  
  public void run()
  {
    HashMap localHashMap = this.val$hashMap;
    if ((localHashMap != null) && (!localHashMap.isEmpty())) {
      try
      {
        localHashMap = ViolaUtils.copyMap(this.val$hashMap);
        ViolaReportManager.access$000(this.this$0, this.val$eventName, localHashMap);
        ViolaReportManager.access$100(this.this$0, localHashMap);
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("postDataToBeacon runnable error:");
        localStringBuilder.append(localException.getMessage());
        ViolaLogUtils.e("ViolaReportManager", localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.core.ViolaReportManager.1
 * JD-Core Version:    0.7.0.1
 */