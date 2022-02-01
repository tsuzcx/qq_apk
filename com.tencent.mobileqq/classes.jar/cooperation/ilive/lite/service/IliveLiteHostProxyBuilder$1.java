package cooperation.ilive.lite.service;

import android.util.SparseArray;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface.BizCommitScene;
import com.tencent.falco.base.libapi.hostproxy.HostReportInterface;
import com.tencent.falco.base.libapi.hostproxy.SdkEventInterface;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.hostproxy.DefaultCustomHostProxyService;

class IliveLiteHostProxyBuilder$1
  extends DefaultCustomHostProxyService
{
  IliveLiteHostProxyBuilder$1(IliveLiteHostProxyBuilder paramIliveLiteHostProxyBuilder) {}
  
  public boolean a()
  {
    return true;
  }
  
  public SparseArray<String> getBizCommitData(HostProxyInterface.BizCommitScene paramBizCommitScene)
  {
    return null;
  }
  
  public HostReportInterface getReportInterface()
  {
    return new IliveLiteHostProxyBuilder.1.1(this);
  }
  
  public SdkEventInterface getSdkEventInterface()
  {
    return new IliveLiteHostProxyBuilder.1.2(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveLiteHostProxyBuilder.1
 * JD-Core Version:    0.7.0.1
 */