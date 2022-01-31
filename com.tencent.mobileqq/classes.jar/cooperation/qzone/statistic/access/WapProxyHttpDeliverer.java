package cooperation.qzone.statistic.access;

import cooperation.qzone.statistic.access.concept.Global;
import cooperation.qzone.util.NetworkState;

public class WapProxyHttpDeliverer
  extends HttpDeliverer
{
  public static final String a = WapProxyHttpDeliverer.class.getName();
  public int b = -1;
  
  public WapProxyHttpDeliverer(String paramString)
  {
    super(paramString);
  }
  
  public static boolean a()
  {
    if (Global.a() == null) {
      return false;
    }
    return NetworkState.isWap();
  }
  
  public int a(String paramString, int paramInt)
  {
    if (this.b == -1)
    {
      int j = super.a(paramString, paramInt);
      int i = j;
      if (a())
      {
        if (j != 0)
        {
          this.b = 1;
          i = super.a(paramString, paramInt);
        }
      }
      else {
        return i;
      }
      this.b = 0;
      return j;
    }
    return super.a(paramString, paramInt);
  }
  
  public HttpDeliverer.IProxy a()
  {
    if ((a()) && (this.b == 1)) {
      return HttpDeliverer.IProxy.a;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.statistic.access.WapProxyHttpDeliverer
 * JD-Core Version:    0.7.0.1
 */