import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.qphone.base.util.QLog;

public final class rzy
  implements Runnable
{
  public rzy(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    long l2 = 0L;
    Object localObject = (MedalWallMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
    if ((localObject == null) || (((MedalWallMng)localObject).a())) {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade", 2, "insertFriendMedalNewsIfNeeded strongRemindOff");
      }
    }
    label119:
    label126:
    for (;;)
    {
      return;
      localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      long l1;
      if (localObject == null)
      {
        l1 = 0L;
        if (localObject != null) {
          break label119;
        }
      }
      for (;;)
      {
        if (l1 <= l2) {
          break label126;
        }
        ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, l2);
        return;
        l1 = ((ExtensionInfo)localObject).medalUpdateTimestamp;
        break;
        l2 = ((ExtensionInfo)localObject).lastMedalTimestamp;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rzy
 * JD-Core Version:    0.7.0.1
 */