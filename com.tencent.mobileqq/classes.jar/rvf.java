import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler;

public final class rvf
  implements Runnable
{
  public rvf(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    long l1;
    long l2;
    if (localExtensionInfo == null)
    {
      l1 = 0L;
      if (localExtensionInfo != null) {
        break label102;
      }
      l2 = 0L;
      label38:
      if (localExtensionInfo != null) {
        break label111;
      }
    }
    label102:
    label111:
    for (long l3 = 0L;; l3 = localExtensionInfo.lastPullPLNewsTimestamp)
    {
      if ((l1 > l2) && (System.currentTimeMillis() / 1000L - l3 >= 86400L)) {
        ((PersonalityLabelHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(112)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, l2);
      }
      return;
      l1 = localExtensionInfo.latestPLUpdateTimestamp;
      break;
      l2 = localExtensionInfo.lastPLNewsTimestamp;
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rvf
 * JD-Core Version:    0.7.0.1
 */