import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

class rva
  implements INetInfoHandler
{
  rva(ruw paramruw) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "INetInfoHandler onNetMobile2None()");
    }
    ruw.b(this.a);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "INetInfoHandler onNetMobile2Wifi() ssid=" + paramString);
    }
    ruw.a(this.a, true);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "INetInfoHandler onNetNone2Mobile() apn=" + paramString);
    }
    ruw.a(this.a, false);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "INetInfoHandler onNetNone2Wifi() ssid=" + paramString);
    }
    ruw.a(this.a, true);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "INetInfoHandler onNetWifi2Mobile() apn=" + paramString);
    }
    ruw.a(this.a, false);
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "INetInfoHandler onNetWifi2None()");
    }
    ruw.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rva
 * JD-Core Version:    0.7.0.1
 */