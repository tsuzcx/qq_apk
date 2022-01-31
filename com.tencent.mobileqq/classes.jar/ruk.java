import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ruk
  implements Runnable
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public ruk(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      QLog.d("Q.aio.BaseChatPie", 1, "UnReadTask mApp==null");
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(localQQAppInterface, false).iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ChatMessage)((Iterator)localObject1).next();
      if ((localObject2 instanceof MessageForUniteGrayTip))
      {
        localObject2 = (MessageForUniteGrayTip)localObject2;
        if ((localObject2 != null) && (((MessageForUniteGrayTip)localObject2).tipParam != null))
        {
          localObject3 = ((MessageForUniteGrayTip)localObject2).tipParam.c;
          if (QLog.isColorLevel()) {
            QLog.d("FriendReactive", 2, "graytips lgraymr.hasRead=" + ((MessageForUniteGrayTip)localObject2).hasRead + "grayTipId=" + ((MessageForUniteGrayTip)localObject2).tipParam.b + "subtype = " + ((MessageForUniteGrayTip)localObject2).subType);
          }
          if ((((MessageForUniteGrayTip)localObject2).tipParam.b == 2097153) && (((MessageForUniteGrayTip)localObject2).hasRead == 0))
          {
            if (((MessageForUniteGrayTip)localObject2).subType == 6)
            {
              if (QLog.isColorLevel()) {
                QLog.d("FriendReactive", 2, "unread message graytips big ship");
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(70);
            }
            for (;;)
            {
              ((MessageForUniteGrayTip)localObject2).hasRead = 1;
              ((MessageForUniteGrayTip)localObject2).updateUniteGrayTipMsgData(localQQAppInterface);
              break;
              AioAnimationDetector.a().a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie), ((MessageForUniteGrayTip)localObject2).subType, 4);
            }
          }
        }
      }
    }
    BaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c());
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
    if (BaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      BaseChatPie.a((BaseChatPie)localObject1, bool);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(localQQAppInterface, BaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
      localObject2 = new ArrayList();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
        break label491;
      }
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        break;
      }
      int i = ((List)localObject1).size() - 1;
      while (i >= 0)
      {
        localObject3 = (ChatMessage)((List)localObject1).get(i);
        if (((localObject3 instanceof MessageForPoke)) && (!((ChatMessage)localObject3).isSend())) {
          ((List)localObject2).add((MessageForPoke)localObject3);
        }
        i -= 1;
      }
    }
    if (((List)localObject2).size() > 0)
    {
      localObject1 = (MessageForPoke)((List)localObject2).get(0);
      if (!((MessageForPoke)localObject1).isPlayed) {
        localQQAppInterface.a().a.put(Long.valueOf(((MessageForPoke)localObject1).uniseq), localObject1);
      }
    }
    label491:
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16711689, 300000L);
    if ((BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie)) || (BaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie))) {
      ChatActivityFacade.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(localQQAppInterface);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        HotChatUtil.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      BaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(localQQAppInterface);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Long == -1L) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Long = localQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ruk
 * JD-Core Version:    0.7.0.1
 */