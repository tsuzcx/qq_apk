import com.tencent.av.utils.CharacterUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.QZoneFeedsServlet;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.NewIntent;

public final class rve
  implements Runnable
{
  public rve(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    ChatActivityFacade.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    long l;
    NewIntent localNewIntent;
    if (ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true))
    {
      l = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneFeeds", 2, "insertFriendNewestFeedIfNeeded   need last publish time:" + l);
      }
      localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneFeedsServlet.class);
      localNewIntent.putExtra("selfuin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    }
    try
    {
      localNewIntent.putExtra("hostuin", new long[] { CharacterUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) });
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneFeeds", 2, "insertFriendNewestFeedIfNeeded   lastTime:" + l);
      }
      localNewIntent.putExtra("lasttime", l);
      ChatActivityFacade.a().jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ChatActivityFacade.a().jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(ChatActivityFacade.a());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      ChatActivityFacade.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ChatActivityFacade.QZoneFeeds", 1, "Long.valueOf " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rve
 * JD-Core Version:    0.7.0.1
 */