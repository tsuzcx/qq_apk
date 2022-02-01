package com.tencent.mobileqq.qqvideoplatform.api;

import com.tencent.beacon.qimei.IAsyncQimeiListener;
import com.tencent.beacon.qimei.Qimei;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;

final class QQVideoPlaySDKManager$1
  implements IAsyncQimeiListener
{
  public void onQimeiDispatch(Qimei paramQimei)
  {
    SuperPlayerSDKMgr.setDeviceId(paramQimei.getQimeiOld());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager.1
 * JD-Core Version:    0.7.0.1
 */