import com.tencent.biz.troopgift.AIOGiftPanelContainer;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;

public class oyq
  implements Runnable
{
  public oyq(AIOGiftPanelContainer paramAIOGiftPanelContainer, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int j = 4;
    long l = System.currentTimeMillis();
    AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(222);
    TroopGiftManager localTroopGiftManager = (TroopGiftManager)this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112);
    int i;
    if (this.jdField_a_of_type_Int == 4)
    {
      i = 6;
      if (!(this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a instanceof FriendChatPie)) {
        break label123;
      }
      j = 11;
      i = 8;
    }
    for (;;)
    {
      localTroopGiftManager.a("OidbSvc.0x6c3", 1731, 1, this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, 2, i, j, new oyr(this, l, localTroopGiftManager, localAIOAnimationControlManager));
      return;
      i = 1;
      break;
      label123:
      if ((this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a instanceof DiscussChatPie)) {
        i = 9;
      } else if ((this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a instanceof StrangerChatPie)) {
        i = 10;
      } else {
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyq
 * JD-Core Version:    0.7.0.1
 */