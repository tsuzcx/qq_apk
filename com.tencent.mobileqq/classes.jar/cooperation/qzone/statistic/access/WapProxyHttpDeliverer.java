package cooperation.qzone.statistic.access;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import cooperation.qzone.statistic.access.concept.Global;

public class WapProxyHttpDeliverer
  extends HttpDeliverer
{
  public static final int PROXY_IS_NEED = 1;
  public static final int PROXY_NEVER_TRY = -1;
  public static final int PROXY_USELESS = 0;
  public static final String TAG = "cooperation.qzone.statistic.access.WapProxyHttpDeliverer";
  public int needProxy = -1;
  
  public WapProxyHttpDeliverer(String paramString)
  {
    super(paramString);
  }
  
  public static boolean isNetworkViaWAP()
  {
    if (Global.getContext() == null) {
      return false;
    }
    return ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).isWap();
  }
  
  public int deliver(String paramString, int paramInt)
  {
    if (this.needProxy == -1)
    {
      int i = super.deliver(paramString, paramInt);
      if (isNetworkViaWAP())
      {
        if (i != 0)
        {
          this.needProxy = 1;
          return super.deliver(paramString, paramInt);
        }
        this.needProxy = 0;
      }
      return i;
    }
    return super.deliver(paramString, paramInt);
  }
  
  public HttpDeliverer.IProxy getProxy()
  {
    if ((isNetworkViaWAP()) && (this.needProxy == 1)) {
      return HttpDeliverer.IProxy.Default;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.statistic.access.WapProxyHttpDeliverer
 * JD-Core Version:    0.7.0.1
 */