import android.content.Intent;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class nbj
  extends MSFServlet
{
  private String[] a = { "OnlinePush.ReqPush.GameStatusPush" };
  
  public String[] getPreferSSOCommands()
  {
    return this.a;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    nbk localnbk = SensorAPIJavaScript.getMsfToWebViewConnector();
    if (localnbk != null) {
      localnbk.a(paramIntent, paramFromServiceMsg);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("GamePushServlet", 2, "WebView not connect to msf");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nbj
 * JD-Core Version:    0.7.0.1
 */