import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.util.WeakReferenceHandler;

class sly
  implements Runnable
{
  sly(slx paramslx) {}
  
  public void run()
  {
    if ((this.a.a.app == null) || (this.a.a.b == null)) {}
    do
    {
      return;
      localObject = (FriendsManager)this.a.a.app.getManager(50);
    } while (localObject == null);
    Card localCard = ((FriendsManager)localObject).a(this.a.a.a.a.a);
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    Object localObject = localCard;
    if (localCard == null) {
      localObject = this.a.a.a.a.a;
    }
    localMessage.obj = localObject;
    this.a.a.b.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sly
 * JD-Core Version:    0.7.0.1
 */