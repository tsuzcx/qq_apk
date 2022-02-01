package com.tencent.mobileqq.intervideo.lite_now_biz.now_live;

import android.util.SparseArray;
import com.tencent.falco.base.libapi.hostproxy.ClickEventInterface;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface.BizCommitScene;
import com.tencent.falco.base.libapi.hostproxy.HostReportInterface;
import com.tencent.falco.base.libapi.hostproxy.SdkEventInterface;
import com.tencent.falco.base.libapi.hostproxy.SdkInfoInterface;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.hostproxy.DefaultCustomHostProxyService;

class NowHostProxyBuilder$1
  extends DefaultCustomHostProxyService
{
  NowHostProxyBuilder$1(NowHostProxyBuilder paramNowHostProxyBuilder) {}
  
  public boolean a()
  {
    return false;
  }
  
  public SparseArray<String> getBizCommitData(HostProxyInterface.BizCommitScene paramBizCommitScene)
  {
    return null;
  }
  
  public ClickEventInterface getClickEventInterface()
  {
    return null;
  }
  
  public HostReportInterface getReportInterface()
  {
    return new NowHostProxyBuilder.1.1(this);
  }
  
  public SdkEventInterface getSdkEventInterface()
  {
    return new NowHostProxyBuilder.1.3(this);
  }
  
  public SdkInfoInterface getSdkInfoInterface()
  {
    return new NowHostProxyBuilder.1.2(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.NowHostProxyBuilder.1
 * JD-Core Version:    0.7.0.1
 */