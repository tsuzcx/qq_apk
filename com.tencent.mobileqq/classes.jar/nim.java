import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DPCObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class nim
  implements DeviceProfileManager.DPCObserver
{
  public nim(MsgTabStoryNodeConfigManager paramMsgTabStoryNodeConfigManager) {}
  
  public void a(boolean paramBoolean)
  {
    ((QQStoryHandler)this.a.a.a(98)).a(1023, true, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nim
 * JD-Core Version:    0.7.0.1
 */