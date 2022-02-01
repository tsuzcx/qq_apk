package cooperation.qzone.contentbox;

import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class QZoneMsgFragment$4
  implements Runnable
{
  QZoneMsgFragment$4(QZoneMsgFragment paramQZoneMsgFragment, String paramString) {}
  
  public void run()
  {
    QQMessageFacade localQQMessageFacade = this.this$0.app.getMessageFacade();
    Message localMessage = localQQMessageFacade.getLastMessage("2290230341", 1008);
    if (localMessage != null)
    {
      localMessage.saveExtInfoToExtStr("qzone_msg_box_promot", this.val$prompt);
      localQQMessageFacade.a("2290230341", 1008, localMessage.uniseq, "extStr", localMessage.extStr);
      return;
    }
    QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "updatePromptText message==null  ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.4
 * JD-Core Version:    0.7.0.1
 */