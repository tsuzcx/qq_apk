import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.nearby.HotChatUtil;
import java.util.Comparator;

public class sni
  implements Comparator
{
  public sni(Conversation paramConversation) {}
  
  public int a(RecentBaseData paramRecentBaseData1, RecentBaseData paramRecentBaseData2)
  {
    if (((paramRecentBaseData1 instanceof RecentUserBaseData)) && ((paramRecentBaseData2 instanceof RecentUserBaseData)))
    {
      paramRecentBaseData1 = (RecentUserBaseData)paramRecentBaseData1;
      paramRecentBaseData2 = (RecentUserBaseData)paramRecentBaseData2;
      TroopManager localTroopManager = (TroopManager)this.a.a.getManager(51);
      boolean bool1;
      boolean bool2;
      if ((paramRecentBaseData1.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 1) && (!HotChatUtil.a(this.a.a, paramRecentBaseData1.jdField_a_of_type_ComTencentMobileqqDataRecentUser)))
      {
        bool1 = localTroopManager.b(paramRecentBaseData1.a());
        if ((paramRecentBaseData2.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type != 1) || (HotChatUtil.a(this.a.a, paramRecentBaseData2.jdField_a_of_type_ComTencentMobileqqDataRecentUser))) {
          break label155;
        }
        bool2 = localTroopManager.b(paramRecentBaseData2.a());
      }
      for (;;)
      {
        if ((!bool1) || (bool2)) {
          break label179;
        }
        return -1;
        if (paramRecentBaseData1.jdField_a_of_type_ComTencentMobileqqDataRecentUser.showUpTime > 0L)
        {
          bool1 = true;
          break;
        }
        bool1 = false;
        break;
        label155:
        if (paramRecentBaseData2.jdField_a_of_type_ComTencentMobileqqDataRecentUser.showUpTime > 0L) {
          bool2 = true;
        } else {
          bool2 = false;
        }
      }
      label179:
      if ((!bool1) && (bool2)) {
        return 1;
      }
      if ((!bool1) && (!bool2)) {
        if ((paramRecentBaseData1.c > 0) && (paramRecentBaseData1.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 0) && (QvipSpecialCareManager.a(this.a.a.getCurrentAccountUin() + paramRecentBaseData1.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) && (!Conversation.a(this.a, paramRecentBaseData1.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, 0)))
        {
          i = 1;
          if (i == 0) {
            break label522;
          }
        }
      }
    }
    label516:
    label522:
    for (int i = 4096;; i = 0)
    {
      if ((paramRecentBaseData2.c > 0) && (paramRecentBaseData2.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 0) && (QvipSpecialCareManager.a(this.a.a.getCurrentAccountUin() + paramRecentBaseData2.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) && (!Conversation.a(this.a, paramRecentBaseData2.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, 0)))
      {
        j = 1;
        label362:
        if (j == 0) {
          break label516;
        }
      }
      for (int j = 4096;; j = 0)
      {
        long l1 = Math.max(paramRecentBaseData1.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime, paramRecentBaseData1.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgdrafttime);
        long l2 = Math.max(paramRecentBaseData2.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime, paramRecentBaseData2.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgdrafttime);
        label410:
        if (l1 > l2) {
          l1 = 3L;
        }
        for (;;)
        {
          l1 = (int)(l1 | i) - (int)(0x2 | j);
          if (l1 != 0L) {
            break label503;
          }
          return 0;
          i = 0;
          break;
          j = 0;
          break label362;
          l1 = paramRecentBaseData1.jdField_a_of_type_Long;
          l2 = paramRecentBaseData2.jdField_a_of_type_Long;
          j = 0;
          i = 0;
          break label410;
          if (l1 < l2) {
            l1 = 1L;
          } else {
            l1 = 2L;
          }
        }
        label503:
        if (l1 < 0L) {
          return 1;
        }
        return -1;
        return 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sni
 * JD-Core Version:    0.7.0.1
 */