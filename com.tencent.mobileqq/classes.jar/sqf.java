import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;

public class sqf
  extends BusinessCardObserver
{
  public sqf(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      BusinessCardManager localBusinessCardManager = (BusinessCardManager)this.a.app.getManager(111);
      this.a.a = localBusinessCardManager.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sqf
 * JD-Core Version:    0.7.0.1
 */