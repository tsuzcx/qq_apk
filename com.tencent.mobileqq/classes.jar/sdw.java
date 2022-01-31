import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.qphone.base.util.QLog;

class sdw
  implements Runnable
{
  sdw(sdv paramsdv) {}
  
  public void run()
  {
    if (this.a.a.a != null)
    {
      this.a.a.a.c();
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "Conversation onUpdateFriendList");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sdw
 * JD-Core Version:    0.7.0.1
 */