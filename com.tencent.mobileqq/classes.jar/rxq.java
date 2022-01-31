import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class rxq
  extends MessageObserver
{
  public rxq(BaseChatPie paramBaseChatPie) {}
  
  public void a(int paramInt)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
      this.a.jdField_a_of_type_MqqOsMqqHandler.post(new rxr(this, paramInt));
    }
  }
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgRevoke", 4, "onMsgRevokeNotice isSuccess=" + paramBoolean1);
    }
    boolean bool = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
    this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(267387140);
    Object localObject1 = new ArrayList();
    Object localObject2;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((ChatMessage)((Iterator)localObject2).next());
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgRevoke", 4, "onMsgRevokeNotice chatlist=" + ((List)localObject1).size());
    }
    if (paramBoolean1)
    {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(267387139);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        MultiMsgManager.a().a((List)localObject1);
        ChatActivityFacade.a((List)localObject1);
        ChatActivityFacade.b((List)localObject1);
        localObject2 = (ChatMessage)((List)localObject1).get(0);
        if (!(localObject2 instanceof MessageForPtt)) {
          break label372;
        }
        localObject1 = (MessageForPtt)((List)localObject1).get(0);
        localObject2 = MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
        if ((localObject2 == localObject1) || (((localObject2 instanceof MessageForPtt)) && (((ChatMessage)localObject2).frienduin != null) && (((ChatMessage)localObject2).frienduin.equals(((MessageForPtt)localObject1).frienduin)) && (((ChatMessage)localObject2).uniseq == ((MessageForPtt)localObject1).uniseq))) {
          MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
        }
      }
      if ((paramBoolean2) && (bool)) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B2", "0X80056B2", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      for (;;)
      {
        super.a(paramBoolean1, paramList, paramBoolean2);
        return;
        label372:
        if ((localObject2 instanceof MessageForShortVideo))
        {
          localObject1 = (MessageForShortVideo)((List)localObject1).get(0);
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
          this.a.b(131072);
          ShortVideoPTVItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
          break;
        }
        if ((localObject2 instanceof MessageForStructing))
        {
          localObject1 = ((MessageForStructing)((List)localObject1).get(0)).structingMsg;
          if ((localObject1 == null) || (!(localObject1 instanceof StructMsgForAudioShare)) || (!QQPlayerService.a((StructMsgForAudioShare)localObject1))) {
            break;
          }
          QQPlayerService.c(this.a.jdField_a_of_type_AndroidContentContext);
          break;
        }
        if ((localObject2 instanceof MessageForApollo))
        {
          localObject1 = (MessageForApollo)((List)localObject1).get(0);
          if (localObject1 == null) {
            break;
          }
          SpriteCommFunc.a(((MessageForApollo)localObject1).uniseq, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "withdraw_msg");
          if (((MessageForApollo)localObject1).mApolloMessage == null) {
            break;
          }
          VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "withdraw_success", ApolloUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(((MessageForApollo)localObject1).mApolloMessage.id) });
          break;
        }
        localObject1 = ((ChatMessage)localObject2).getExtInfoFromExtStr("tim_aio_gary_uniseq");
        if (QLog.isColorLevel()) {
          QLog.i("AIOMessageSpreadManager", 1, "del garyTips id[" + (String)localObject1 + "],targetId[" + ((ChatMessage)localObject2).msgUid + "], hashCode:" + localObject2.hashCode());
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        try
        {
          long l = Long.parseLong((String)localObject1);
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((ChatMessage)localObject2).frienduin, ((ChatMessage)localObject2).istroop, l, true);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          QLog.e("Q.aio.BaseChatPie", 1, localException.toString());
        }
      }
      break;
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(267387140);
    }
  }
  
  public void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, new Object[] { "[onGetTroopMsgFin], isSuc:", Boolean.valueOf(paramBoolean) });
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (!paramBoolean)) {
      return;
    }
    ((ApolloGameManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(210)).a(3, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rxq
 * JD-Core Version:    0.7.0.1
 */