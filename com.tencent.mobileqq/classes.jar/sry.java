import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class sry
  implements INetInfoHandler
{
  public sry(FastWebActivity paramFastWebActivity) {}
  
  public void onNetMobile2None()
  {
    FastWebActivity.m(this.a);
    txq.a.onNetMobile2None();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    FastWebActivity.m(this.a);
    txq.a.onNetMobile2Wifi(paramString);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    FastWebActivity.m(this.a);
    txq.a.onNetNone2Mobile(paramString);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    FastWebActivity.m(this.a);
    txq.a.onNetNone2Wifi(paramString);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    FastWebActivity.m(this.a);
    txq.a.onNetWifi2Mobile(paramString);
  }
  
  public void onNetWifi2None()
  {
    FastWebActivity.m(this.a);
    txq.a.onNetWifi2None();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sry
 * JD-Core Version:    0.7.0.1
 */