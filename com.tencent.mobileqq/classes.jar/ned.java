import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.observer.GetRedPointExObserver;

public class ned
  extends GetRedPointExObserver
{
  public ned(MsgTabNodeListLoader paramMsgTabNodeListLoader) {}
  
  protected void a(Object paramObject)
  {
    ThreadManager.post(new nee(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ned
 * JD-Core Version:    0.7.0.1
 */