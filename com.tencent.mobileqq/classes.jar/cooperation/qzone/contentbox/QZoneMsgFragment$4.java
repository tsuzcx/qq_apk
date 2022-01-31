package cooperation.qzone.contentbox;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class QZoneMsgFragment$4
  implements Runnable
{
  QZoneMsgFragment$4(QZoneMsgFragment paramQZoneMsgFragment, String paramString) {}
  
  public void run()
  {
    QQMessageFacade localQQMessageFacade = this.this$0.a.a();
    QQMessageFacade.Message localMessage = localQQMessageFacade.a("2290230341", 1008);
    if (localMessage != null)
    {
      localMessage.saveExtInfoToExtStr("qzone_msg_box_promot", this.a);
      localQQMessageFacade.a("2290230341", 1008, localMessage.uniseq, "extStr", localMessage.extStr);
      return;
    }
    QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "updatePromptText message==null  ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.4
 * JD-Core Version:    0.7.0.1
 */