import UserGrowth.stNotificationReq;
import UserGrowth.stNotificationRsp;

public class smw
  extends sls<stNotificationRsp>
{
  public smw(String paramString)
  {
    super("Notification");
    stNotificationReq localstNotificationReq = new stNotificationReq();
    localstNotificationReq.linkStrategyArgs = snf.a();
    localstNotificationReq.push_info = paramString;
    this.a = localstNotificationReq;
    sne.b("NotificationRequest", "stNotificationReq = " + localstNotificationReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     smw
 * JD-Core Version:    0.7.0.1
 */