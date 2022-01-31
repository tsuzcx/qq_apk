import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

final class qsc
  implements SDKInitListener
{
  public void onSDKInited(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PlayerCaptureProxy", 2, "onSDKInited result:" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qsc
 * JD-Core Version:    0.7.0.1
 */