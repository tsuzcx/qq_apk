import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

class sts
  implements Runnable
{
  sts(stq paramstq, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + this.jdField_a_of_type_JavaLangString + ", mobileNum = " + this.b);
    }
    Object localObject1 = (FriendsManager)this.jdField_a_of_type_Stq.a.app.getManager(50);
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((FriendsManager)localObject1).a(this.jdField_a_of_type_Stq.a.a.a.jdField_a_of_type_JavaLangString))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 3;
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.jdField_a_of_type_JavaLangString;
      }
      localMessage.obj = localObject2;
      this.jdField_a_of_type_Stq.a.b.sendMessage(localMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sts
 * JD-Core Version:    0.7.0.1
 */