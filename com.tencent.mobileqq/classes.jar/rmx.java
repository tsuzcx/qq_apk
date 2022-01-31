import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.utils.ContactUtils;

public class rmx
  implements Runnable
{
  public rmx(BaseChatPie paramBaseChatPie, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    String str2;
    String str3;
    String str1;
    Object localObject;
    if (this.jdField_a_of_type_Int == -1) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
      {
        str2 = "";
        str3 = "";
        str1 = str2;
        localObject = str3;
        if (this.b != 2) {
          break label149;
        }
        localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l()) {
          break label68;
        }
      }
    }
    for (;;)
    {
      return;
      label68:
      Friends localFriends = ((FriendsManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      str1 = str2;
      localObject = str3;
      if (localFriends != null)
      {
        str1 = "" + ContactUtils.a(localFriends);
        localObject = "" + ContactUtils.a(localFriends, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      label149:
      StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "clt", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "msg", this.b + "", "", "", str1, (String)localObject, BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie) + "");
      BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, 0);
      return;
      localObject = null;
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      }
      while (localObject != null)
      {
        StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "pic", "", this.jdField_a_of_type_Int + "", this.jdField_a_of_type_JavaLangString, "", "", "");
        return;
        localObject = "clt";
        continue;
        localObject = "grp";
        continue;
        localObject = "discuss";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rmx
 * JD-Core Version:    0.7.0.1
 */