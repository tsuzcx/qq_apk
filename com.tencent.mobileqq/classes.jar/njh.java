import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeAdapter;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.AutomatorObserver;

public class njh
  extends AutomatorObserver
{
  public njh(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  protected void a(int paramInt)
  {
    if (paramInt == 1)
    {
      SLog.b(MsgTabStoryNodeListManager.a() + ".VASH", "Friend Cache Inited!");
      MsgTabStoryNodeListManager.g = true;
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     njh
 * JD-Core Version:    0.7.0.1
 */