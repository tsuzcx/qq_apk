import android.os.Bundle;
import com.tencent.biz.webviewbase.WebAIOController;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.qphone.base.util.QLog;

public class oze
  extends Client.onRemoteRespObserver
{
  public oze(WebAIOController paramWebAIOController) {}
  
  public void onBindedToClient()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOBanner", 2, "-->onBindedToClient");
    }
  }
  
  public void onDisconnectWithService()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOBanner", 2, "-->onDisconnectWithService");
    }
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOBanner", 2, "-->onPushMsg");
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOBanner", 2, "-->onResponse");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oze
 * JD-Core Version:    0.7.0.1
 */