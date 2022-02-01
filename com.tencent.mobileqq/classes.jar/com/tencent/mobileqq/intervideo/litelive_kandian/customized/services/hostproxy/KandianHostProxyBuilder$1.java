package com.tencent.mobileqq.intervideo.litelive_kandian.customized.services.hostproxy;

import android.util.SparseArray;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface.BizCommitScene;
import com.tencent.falco.base.libapi.hostproxy.HostReportInterface;
import com.tencent.falco.base.libapi.hostproxy.SdkEventInterface;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.hostproxy.DefaultCustomHostProxyService;

class KandianHostProxyBuilder$1
  extends DefaultCustomHostProxyService
{
  KandianHostProxyBuilder$1(KandianHostProxyBuilder paramKandianHostProxyBuilder) {}
  
  public boolean a()
  {
    return false;
  }
  
  public SparseArray<String> getBizCommitData(HostProxyInterface.BizCommitScene paramBizCommitScene)
  {
    return null;
  }
  
  public HostReportInterface getReportInterface()
  {
    return new KandianHostProxyBuilder.1.1(this);
  }
  
  public SdkEventInterface getSdkEventInterface()
  {
    return new KandianHostProxyBuilder.1.2(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.services.hostproxy.KandianHostProxyBuilder.1
 * JD-Core Version:    0.7.0.1
 */