import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.util.WeakReferenceHandler;

public class sna
  implements Runnable
{
  public sna(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    int j = 0;
    Object localObject = (FriendsManager)this.a.app.getManager(50);
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label164;
      }
      localObject = new Card();
    }
    label164:
    for (int i = 1;; i = 0)
    {
      ((Card)localObject).feedPreviewTime = System.currentTimeMillis();
      ((Card)localObject).strQzoneFeedsDesc = "";
      Message localMessage = Message.obtain();
      localMessage.obj = localObject;
      if (i != 0) {}
      for (localMessage.what = 6;; localMessage.what = 5)
      {
        if (this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) {
          this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
        }
        i = j;
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a != null) {
          i = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.h;
        }
        this.a.d(i);
        return;
        localObject = ((FriendsManager)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sna
 * JD-Core Version:    0.7.0.1
 */