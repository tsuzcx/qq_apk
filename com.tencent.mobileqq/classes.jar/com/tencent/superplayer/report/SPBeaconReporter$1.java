package com.tencent.superplayer.report;

import android.text.TextUtils;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.tplayer.plugins.report.BeaconAdapter;
import java.util.Map;

final class SPBeaconReporter$1
  implements Runnable
{
  SPBeaconReporter$1(String paramString, Map paramMap) {}
  
  public void run()
  {
    if ((TextUtils.isEmpty(this.val$eventName)) || (this.val$copyMap.isEmpty()))
    {
      LogUtil.e("MediaPlayerMgr.SPBeaconReporter", "report failed for eventName:" + this.val$eventName + "dataMap:" + this.val$copyMap);
      return;
    }
    BeaconAdapter.onUserActionToTunnel("00000U7O8S3BLETM", this.val$eventName, true, -1L, -1L, this.val$copyMap, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.report.SPBeaconReporter.1
 * JD-Core Version:    0.7.0.1
 */