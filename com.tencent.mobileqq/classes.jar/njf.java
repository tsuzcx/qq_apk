import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.observer.GetRedPointExObserver;

public class njf
  extends GetRedPointExObserver
{
  public njf(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  protected void a(Object paramObject)
  {
    ThreadManager.post(new njg(this, paramObject), 5, null, true);
    SLog.b(MsgTabStoryNodeListManager.a(), "freshRedPoint, showStoryNode");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     njf
 * JD-Core Version:    0.7.0.1
 */