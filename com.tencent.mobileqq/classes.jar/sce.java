import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class sce
  implements Runnable
{
  WeakReference a;
  
  public sce(ChatSettingForTroop paramChatSettingForTroop)
  {
    this.a = new WeakReference(paramChatSettingForTroop);
  }
  
  public void run()
  {
    ChatSettingForTroop localChatSettingForTroop = (ChatSettingForTroop)this.a.get();
    if (localChatSettingForTroop == null) {}
    while (localChatSettingForTroop.c) {
      return;
    }
    Object localObject1 = localChatSettingForTroop.app;
    String str = localChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    Object localObject2 = new StringBuilder();
    int i = ChatSettingForTroop.a((QQAppInterface)localObject1, str, 1, (StringBuilder)localObject2);
    List localList = ((QQAppInterface)localObject1).a().b(str, 1);
    if ((localList != null) && (!localList.isEmpty())) {}
    for (long l1 = ((MessageRecord)localList.get(localList.size() - 1)).shmsgseq;; l1 = 0L)
    {
      if (i > 0) {}
      for (;;)
      {
        try
        {
          long l2 = Long.parseLong(((StringBuilder)localObject2).toString());
          l1 = Math.max(l2, l1);
          if (l1 > 0L) {
            ((QQAppInterface)localObject1).a().a(str, 1, l1);
          }
          ((QQAppInterface)localObject1).a().a(str, 1);
          ((QQAppInterface)localObject1).a().e(str, 1);
          SpriteCommFunc.a((QQAppInterface)localObject1, "chat_history_confirm_del_msg");
          localObject1 = ((QQAppInterface)localObject1).getHandler(Conversation.class);
          localObject2 = ((MqqHandler)localObject1).obtainMessage(1017);
          ((Message)localObject2).obj = str;
          ((Message)localObject2).arg1 = 1;
          ((MqqHandler)localObject1).sendMessage((Message)localObject2);
          localChatSettingForTroop.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(19);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "msg history already clear!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sce
 * JD-Core Version:    0.7.0.1
 */