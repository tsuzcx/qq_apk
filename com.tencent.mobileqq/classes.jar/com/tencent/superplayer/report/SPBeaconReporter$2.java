package com.tencent.superplayer.report;

import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.NetworkUtil;
import com.tencent.thumbplayer.tplayer.plugins.report.BeaconAdapter;
import java.util.Map;

final class SPBeaconReporter$2
  implements Runnable
{
  SPBeaconReporter$2(String paramString, Map paramMap) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.val$eventName)) && (!this.val$copyMap.isEmpty()))
    {
      this.val$copyMap.put("param_uin", SuperPlayerSDKMgr.getUid());
      this.val$copyMap.put("param_netType", String.valueOf(NetworkUtil.getNetWorkType()));
      BeaconAdapter.onUserActionToTunnel("00000U7O8S3BLETM", this.val$eventName, true, -1L, -1L, this.val$copyMap, true, true);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report failed for eventName:");
    localStringBuilder.append(this.val$eventName);
    localStringBuilder.append("dataMap:");
    localStringBuilder.append(this.val$copyMap);
    LogUtil.e(".SPBeaconReporter", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.report.SPBeaconReporter.2
 * JD-Core Version:    0.7.0.1
 */