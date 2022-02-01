package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr.PreDownloadController;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr.VideoPreDownloadParam;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.viola.core.ViolaInstance;
import java.util.List;

class BridgeModule$3
  implements VideoPreDownloadMgr.PreDownloadController
{
  BridgeModule$3(BridgeModule paramBridgeModule, List paramList) {}
  
  public List<VideoPreDownloadMgr.VideoPreDownloadParam> a(int paramInt, boolean paramBoolean)
  {
    return this.a;
  }
  
  public boolean a()
  {
    return NetworkUtil.isWifiConnected(this.b.getViolaInstance().getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.3
 * JD-Core Version:    0.7.0.1
 */