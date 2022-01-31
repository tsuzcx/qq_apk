import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;

class sks
  implements Runnable
{
  sks(skk paramskk) {}
  
  public void run()
  {
    MsgTabStoryNodeConfigManager localMsgTabStoryNodeConfigManager = (MsgTabStoryNodeConfigManager)this.a.a.a.getManager(251);
    if (localMsgTabStoryNodeConfigManager.a)
    {
      ((MsgTabStoryManager)this.a.a.a.getManager(250)).a();
      this.a.a.a(new skt(this, localMsgTabStoryNodeConfigManager));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sks
 * JD-Core Version:    0.7.0.1
 */