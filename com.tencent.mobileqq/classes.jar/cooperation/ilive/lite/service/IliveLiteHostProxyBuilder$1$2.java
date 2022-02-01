package cooperation.ilive.lite.service;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.hostproxy.HostReportInterface;
import com.tencent.mobileqq.litelivesdk.utils.network.NetworkUtil;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import cooperation.qzone.QUA;
import java.util.HashMap;
import java.util.Map;

class IliveLiteHostProxyBuilder$1$2
  implements HostReportInterface
{
  IliveLiteHostProxyBuilder$1$2(IliveLiteHostProxyBuilder.1 param1) {}
  
  public Map<String, String> getHostReportData()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("userid", this.a.a());
    String str = "1";
    localHashMap.put("scene", "1");
    localHashMap.put("subscene", "0");
    int j = CUKingCardUtils.a();
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    if (i == 0) {
      str = "0";
    }
    localHashMap.put("zt_str5", str);
    localHashMap.put("qua_new", QUA.getQUA3());
    localHashMap.put("mobile_type", "Android");
    localHashMap.put("host_version", "8.7.0");
    localHashMap.put("network_type", String.valueOf(NetworkUtil.a(BaseApplicationImpl.getContext())));
    return localHashMap;
  }
  
  public Map<String, String> getHostReportData(String paramString)
  {
    return null;
  }
  
  public String getHostReportPrivateData(String paramString, Bundle paramBundle)
  {
    return null;
  }
  
  public boolean isBeaconRealTimeDebug()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveLiteHostProxyBuilder.1.2
 * JD-Core Version:    0.7.0.1
 */