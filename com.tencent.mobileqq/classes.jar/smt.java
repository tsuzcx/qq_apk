import UserGrowth.stNotificationReq;
import UserGrowth.stNotificationRsp;

public class smt
  extends slp<stNotificationRsp>
{
  public smt(String paramString)
  {
    super("Notification");
    stNotificationReq localstNotificationReq = new stNotificationReq();
    localstNotificationReq.linkStrategyArgs = snc.a();
    localstNotificationReq.push_info = paramString;
    this.a = localstNotificationReq;
    snb.b("NotificationRequest", "stNotificationReq = " + localstNotificationReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     smt
 * JD-Core Version:    0.7.0.1
 */