import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.ProfileCardTemplate;

public class svi
  implements Runnable
{
  public svi(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    Object localObject = ((FriendsManager)this.a.app.getManager(50)).a(this.a.app.getCurrentAccountUin());
    if (localObject == null) {
      this.a.j = "-1";
    }
    for (;;)
    {
      this.a.j = "-1";
      return;
      if (((Card)localObject).lCurrentStyleId == ProfileCardTemplate.a)
      {
        localObject = (QZoneCover)this.a.app.getEntityManagerFactory().createEntityManager().a(QZoneCover.class, this.a.app.getCurrentAccountUin());
        if (localObject != null) {
          this.a.j = ((QZoneCover)localObject).type;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     svi
 * JD-Core Version:    0.7.0.1
 */