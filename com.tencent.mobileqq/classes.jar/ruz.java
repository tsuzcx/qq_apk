import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class ruz
  implements Runnable
{
  ruz(ruy paramruy, MessageForMarketFace paramMessageForMarketFace, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.sendFaceName = this.jdField_a_of_type_Ruy.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.msgVia = this.jdField_a_of_type_Ruy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.istroop == 1)
    {
      AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace);
      if (GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.istroop)) {
        GoldMsgChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace);
      }
      if (MsgProxyUtils.a(this.jdField_a_of_type_Ruy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) != 1032) {
        break label320;
      }
      ConfessMsgUtil.a(this.jdField_a_of_type_Ruy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, this.jdField_a_of_type_Ruy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ruy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Ruy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ruy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, null);
      EmoticonManager localEmoticonManager = (EmoticonManager)this.jdField_a_of_type_Ruy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (localEmoticonManager == null) {
        break label360;
      }
      Object localObject = localEmoticonManager.a(this.jdField_a_of_type_Ruy.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label360;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!TextUtils.isEmpty(str))
        {
          RecentEmotion localRecentEmotion = new RecentEmotion();
          localRecentEmotion.epId = this.jdField_a_of_type_Ruy.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId;
          localRecentEmotion.eId = this.jdField_a_of_type_Ruy.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId;
          localRecentEmotion.keyword = str.toLowerCase();
          localRecentEmotion.exposeNum = 0;
          localEmoticonManager.a(localRecentEmotion);
        }
      }
      if (!AnonymousChatHelper.a().a) {
        break;
      }
      AnonymousChatHelper.a().a = false;
      break;
      label320:
      if (this.jdField_a_of_type_Ruy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.j) {
        ConfessMsgUtil.a(this.jdField_a_of_type_Ruy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, this.jdField_a_of_type_Ruy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    label360:
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "mainRunnable, epId = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId + " ePackage.copywritingType = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.copywritingType + " currentTime = " + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ruz
 * JD-Core Version:    0.7.0.1
 */