package com.tencent.qapmsdk.qqbattery;

import android.support.annotation.NonNull;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.IStreamListener;
import org.json.JSONArray;
import org.json.JSONObject;

class QQBatteryMonitor$1
  implements IStreamListener
{
  QQBatteryMonitor$1(QQBatteryMonitor paramQQBatteryMonitor, int[] paramArrayOfInt, int paramInt, JSONObject paramJSONObject) {}
  
  public void readLine(@NonNull String paramString)
  {
    Object localObject = this.val$controlCount;
    int i = localObject[2] - 1;
    localObject[2] = i;
    if (i <= 0) {
      return;
    }
    for (;;)
    {
      String str;
      try
      {
        String[] arrayOfString = paramString.split("\\|");
        str = arrayOfString[1];
        if (((str.startsWith("fg30")) && (this.val$controlCount[0] > this.val$maxReportCount)) || ((str.startsWith("bg5")) && (this.val$controlCount[1] > this.val$maxReportCount))) {
          break;
        }
        if (!this.val$rootJson.has(str))
        {
          localObject = new JSONArray();
          this.val$rootJson.put(str, localObject);
          QQBatteryMonitor.access$000(this.this$0, str, this.val$controlCount, arrayOfString, (JSONArray)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_battery_BatteryMonitor", "bad line = ", paramString, " | ", localException.toString() });
        return;
      }
      JSONArray localJSONArray = this.val$rootJson.getJSONArray(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.QQBatteryMonitor.1
 * JD-Core Version:    0.7.0.1
 */