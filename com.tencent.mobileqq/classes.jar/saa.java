import UserGrowth.stNotificationReq;
import UserGrowth.stNotificationRsp;

public class saa
  extends ryw<stNotificationRsp>
{
  public saa(String paramString)
  {
    super("Notification");
    stNotificationReq localstNotificationReq = new stNotificationReq();
    localstNotificationReq.linkStrategyArgs = saj.a();
    localstNotificationReq.push_info = paramString;
    this.a = localstNotificationReq;
    sai.b("NotificationRequest", "stNotificationReq = " + localstNotificationReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     saa
 * JD-Core Version:    0.7.0.1
 */