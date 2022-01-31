import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.observer.GetRedPointExObserver;

public class nct
  extends GetRedPointExObserver
{
  public nct(MsgTabNodeListLoader paramMsgTabNodeListLoader) {}
  
  protected void a(Object paramObject)
  {
    ThreadManager.post(new ncu(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nct
 * JD-Core Version:    0.7.0.1
 */