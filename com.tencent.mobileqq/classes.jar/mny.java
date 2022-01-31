import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class mny
  implements INetInfoHandler
{
  public mny(FastWebVideoFeedsPlayManager paramFastWebVideoFeedsPlayManager) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "INetInfoHandler onNetMobile2None()");
    }
    FastWebVideoFeedsPlayManager.d(this.a);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "INetInfoHandler onNetMobile2Wifi() ssid=" + paramString);
    }
    FastWebVideoFeedsPlayManager.a(this.a, true);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "INetInfoHandler onNetNone2Mobile() apn=" + paramString);
    }
    FastWebVideoFeedsPlayManager.a(this.a, false);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "INetInfoHandler onNetNone2Wifi() ssid=" + paramString);
    }
    FastWebVideoFeedsPlayManager.a(this.a, true);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "INetInfoHandler onNetWifi2Mobile() apn=" + paramString);
    }
    FastWebVideoFeedsPlayManager.a(this.a, false);
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "INetInfoHandler onNetWifi2None()");
    }
    FastWebVideoFeedsPlayManager.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mny
 * JD-Core Version:    0.7.0.1
 */