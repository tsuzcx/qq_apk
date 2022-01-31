import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureActivity;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class lhl
  implements INetInfoHandler
{
  public lhl(ReadInJoyCameraCaptureActivity paramReadInJoyCameraCaptureActivity) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "INetInfoHandler onNetMobile2None()");
    }
    if (ReadInJoyCameraCaptureActivity.a(this.a) == 6) {
      ReadInJoyCameraCaptureActivity.d(this.a);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "INetInfoHandler onNetMobile2Wifi() ssid=" + paramString);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "INetInfoHandler onNetNone2Mobile() apn=" + paramString);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "INetInfoHandler onNetNone2Wifi() ssid=" + paramString);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "INetInfoHandler onNetWifi2Mobile() apn=" + paramString);
    }
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "INetInfoHandler onNetWifi2None()");
    }
    if (ReadInJoyCameraCaptureActivity.a(this.a) == 6) {
      ReadInJoyCameraCaptureActivity.d(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lhl
 * JD-Core Version:    0.7.0.1
 */